package com.example.theunivercity;

public class Compte {
    int id , num_cart  ;
    String first_name , family_name  ;
    String speciality ;
    String username , password ;

    public Compte() {
    }

    public Compte(int id, int num_cart, String first_name, String family_name, String speciality, String username, String password) {
        this.id = id;
        this.num_cart = num_cart;
        this.first_name = first_name;
        this.family_name = family_name;
        this.speciality = speciality;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNum_cart() {
        return num_cart;
    }

    public void setNum_cart(int num_cart) {
        this.num_cart = num_cart;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getFamily_name() {
        return family_name;
    }

    public void setFamily_name(String family_name) {
        this.family_name = family_name;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
