package dev.mbonigabay.validationdoc.model.entity;

import java.time.LocalDate;

public class Registration {
    private String name;
    private String username;
    private LocalDate birthDate;

    
    
    public Registration() {
    }

    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public LocalDate getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }


    @Override
    public String toString() {
        return "Registration [name=" + name + ", username=" + username + ", birthDate=" + birthDate + "]";
    }

    
}
