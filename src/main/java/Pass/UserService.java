package Pass;

import Data.User;

public class UserService {
    public void registerUser(String username, String plainTextPassword, boolean isAdmin) {
        String hashedPassword = PasswordUtils.hashPassword(plainTextPassword);
        User newUser = new User(username, hashedPassword, isAdmin);
        // Įrašykite naują vartotoją į duomenų bazę čia
    }
    public boolean authenticateUser(String username, String plainTextPassword) {
        User user = findUserByUsername(username); // Čia turite gauti vartotoją iš duomenų bazės pagal vartotojo vardą
        if (user == null) {
            return false;
        }
        return PasswordUtils.checkPassword(plainTextPassword, user.getPassword());
    }
}


