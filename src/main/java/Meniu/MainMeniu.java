package Meniu;
    import Data.User;
    import Pass.UserService;
    import TestSer.TestService;

    import java.util.Scanner;

    public class MainMenu {

        private final UserService userService;
        private final TestService testService;

        public MainMenu(UserService userService, TestService testService) {
            this.userService = userService;
            this.testService = testService;
        }

        public void display() {
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("Pasirinkite veiksmą:");
                System.out.println("1. Prisijungti");
                System.out.println("2. Užsiregistruoti");
                System.out.println("3. Išeiti");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("Įveskite vartotojo vardą:");
                        String username = scanner.next();
                        System.out.println("Įveskite slaptažodį:");
                        String password = scanner.next();

                        if (userService.authenticateUser(username, password)) {
                            User user = userService.findUserByUsername(username);
                            if (user.isAdmin()) {
                                new AdminMenu(userService, testService, userService1, testService1).display();
                            } else {
                                new UserMenu(userService, testService, user).display();
                            }
                        } else {
                            System.out.println("Neteisingas vartotojo vardas arba slaptažodis!");
                        }
                        break;
                    case 2:
                        // Čia įdėkite užsiregistravimo kodą
                        break;
                    case 3:
                        System.out.println("Viso gero!");
                        System.exit(0);
                    default:
                        System.out.println("Neteisingas pasirinkimas. Bandykite dar kartą.");
                }
            }
        }
    }


