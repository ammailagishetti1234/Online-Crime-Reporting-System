
package com.entities;

public class Admin {
    private int id;
    private String email;
    private String password;
    private String code;

    public Admin(int id, String email, String password, String code) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.code = code;
    }
    
     public Admin(String email, String password, String code) {
        this.email = email;
        this.password = password;
        this.code = code;
    }

    public Admin() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    
     
    public boolean checkCredentials(String email, String pass) {
         return this.email.equals(email) && this.password.equals(password);
    }
    
    
}
