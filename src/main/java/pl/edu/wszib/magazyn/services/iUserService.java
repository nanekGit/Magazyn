package pl.edu.wszib.magazyn.services;

import pl.edu.wszib.magazyn.model.User;
import pl.edu.wszib.magazyn.model.view.RegistrationModel;

import java.util.regex.Pattern;

public interface iUserService {

    Pattern getLengthPattern();
    void authenticate(User user);
    void logout();
    boolean register(RegistrationModel registrationModel);
}
