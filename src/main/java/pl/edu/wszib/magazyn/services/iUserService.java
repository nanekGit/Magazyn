package pl.edu.wszib.magazyn.services;

import pl.edu.wszib.magazyn.model.User;
import pl.edu.wszib.magazyn.model.view.RegistrationModel;

public interface iUserService {

    void authenticate(User user);
    void logout();
    boolean register(RegistrationModel registrationModel);
}
