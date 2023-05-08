package Meniu;
import Pass.UserService;
import TestSer.TestService;

public class AdminMenu {
    private final UserService userService;
    private final TestService testService;

    public AdminMenu(UserService userService, TestService testService, UserService userService1, TestService testService1) {

        this.userService = userService1;
        this.testService = testService1;
    }
}
