package dev.mbonigabay.validationdoc.model.request;

import java.time.LocalDate;

import dev.mbonigabay.validationdoc.util.constraint.Age;
import dev.mbonigabay.validationdoc.util.constraint.PasswordMatch;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

@PasswordMatch
public class RegistrationRequest {
    private String name;
    @Email
    private String username;
    @Size(min = 8)
    private String password;
    private String confirmation;
    @Age(min = "18")
    private LocalDate birthDate;

    
    
    public RegistrationRequest() {
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
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getConfirmation() {
        return confirmation;
    }
    public void setConfirmation(String confirmation) {
        this.confirmation = confirmation;
    }
    public LocalDate getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
    @Override
    public String toString() {
        return "RegistrationRequest [name=" + name + ", username=" + username + ", password=" + password
                + ", confirmation=" + confirmation + ", birthDate=" + birthDate + "]";
    }

    
}
