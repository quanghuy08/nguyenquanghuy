package model;

public class User {
    private int Id;
    private String Name;
    private String Email;
    private String Address;
    private int Phone;

    public User() {
    }

    public User(int id, String name, String email, String address, int phone) {
        Id = id;
        Name = name;
        Email = email;
        Address = address;
        Phone = phone;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public int getPhone() {
        return Phone;
    }

    public void setPhone(int phone) {
        Phone = phone;
    }
}
