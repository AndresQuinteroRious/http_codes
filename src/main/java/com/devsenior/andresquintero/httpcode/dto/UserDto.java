package com.devsenior.andresquintero.httpcode.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
//@JsonIgnoreProperties({"active", "password"})
public class UserDto {
    @JsonProperty(value="user_name",index=0) //para que aparesca de primero 
    private String username;
   
    private String email;
   
     @JsonIgnore
    private String password;

   @JsonAlias({"nombre", "full_name"})
    private String name;

   
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    @JsonProperty("hire_Date")

    private LocalDate hireDate;

    private Boolean active;
    

    public UserDto() {
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
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
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }
   

    public Boolean getActive() {
        return active;
    }
    public void setActive(Boolean active) {
        this.active = active;
    }
    @Override
    public String toString() {
        return "UserDto [username=" + username + ", email=" + email + ", password=" + password + ", name=" + name
                + ", hireDate=" + hireDate + ", active=" + active + "]";
    }


    
    
}
