package Meniu;

import Data.User;
import Pass.UserService;
import TestSer.TestService;

import java.util.Scanner;

    public class UserMenu {

        private final UserService userService;
        private final TestService testService;
        private final User user;

        public UserMenu(UserService userService, TestService testService, User user) {
            this.userService = userService;
            this.testService = testService;
            this.user = user;
        }

        public UserMenu(UserService userService, TestService testService, User user, UserService userService1, TestService testService1, User user1) {
            this.userService = userService1;
            this.testService = testService1;
            this.user = user1;
        }

        public void display() {
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("Pasirinkite veiksmą:");
                System.out.println("1. Pradėti testą");
                System.out.println("2. Peržiūrėti rezultatus");
                System.out.println("3. Atsijungti");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        // Čia įdėkite testo pradžios kodą
                        break;
                    case 2:
                        // Čia įdėkite rezultatų peržiūrėjimo kodą
                        break;
                    case 3:
                        System.out.println("Atsijungiate.");
                        return;
                    default:
                        System.out.println("Neteisingas pasirinkimas. Bandykite dar kartą.");
                }
            }
        }
    }


