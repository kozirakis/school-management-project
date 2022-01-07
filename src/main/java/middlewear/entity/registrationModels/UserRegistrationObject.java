package middlewear.entity.registrationModels;

import org.springframework.data.annotation.Id;

public class UserRegistrationObject {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public UserRegistrationObject() {

    }

    public UserRegistrationObject(String firstName,
                               String lastName, String email, String password) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
}

