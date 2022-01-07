package middlewear.service;

import middlewear.entity.User;
import middlewear.entity.registrationModels.UserRegistrationObject;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

// The UserDetailsService interface is used to retrieve
// user-related data. It has one method named loadUserByUsername().

public interface UserService extends UserDetailsService{
    User save(UserRegistrationObject registrationObject);

    List<User> getAll();
}
