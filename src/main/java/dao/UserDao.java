package dao;
import database.ConnectionUtil;
import model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    Connection connection = ConnectionUtil.getConnection();

    public List<User> getListUser(int id) {
        List<User> list = new ArrayList<>();
        String sql = "SELECT * FROM  user WHERE id= ?";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User u = new User();
                u.setId(rs.getInt("id"));
                u.setName(rs.getString("name"));
                u.setEmail(rs.getString("email"));
                u.setAddress(rs.getString("address"));
                u.setPhone(rs.getInt("phone"));

                list.add(u);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
    public String updateUser(User u){
        String sql="UPDATE product SET name = ?,email = ?, address = ?, phone = ? WHERE id=?";
        try{
            PreparedStatement ps =  connection.prepareStatement(sql);
            ps.setString(1, u.getName());
            ps.setString(2, u.getEmail());
            ps.setString(3, u.getAddress());
            ps.setInt(4, u.getPhone());
            int isSuccess=ps.executeUpdate();
            if(isSuccess>0){
                return"Success";
            }
        }catch(SQLException throwables){
            throwables.printStackTrace();
        }
        return"Fail";
    }
    public String deleteUser(int id){
        String sql="DELETE FROM product WHERE id=?";
        try{
            PreparedStatement ps=connection.prepareStatement(sql);
            ps.setInt(1, id);
            int isSuccess=ps.executeUpdate();
            if(isSuccess>0){
                return"Success";
            }
        }catch(SQLException throwables){
            throwables.printStackTrace();
        }
        return"Fail";
    }

    public String insertUser(User u){
        String sql="INSERT INTO product(name,email,address,phone)VALUES(?,?,?,?)";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, u.getName());
            ps.setString(2, u.getEmail());
            ps.setString(3, u.getAddress());
            ps.setInt(4, u.getPhone());
            int isSuccess = ps.executeUpdate();
            if(isSuccess > 0){
                return "Success";
            }
        }catch(SQLException throwables){
            throwables.printStackTrace();
        }
        return"Fail";
    }
}
