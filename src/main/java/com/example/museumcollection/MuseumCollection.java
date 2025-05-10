import java.util.Scanner;

public class MuseumCollection
{

    public static void main(String[] args)
    {
        Scanner scnr = new Scanner(System.in);
        String input = "";

        while (!input.equalsIgnoreCase("e"))
        {
            System.out.println("           Welcome to the Museum!");
            System.out.println("(V)iew the museum as guest   (L)ogin as curator   (E)nd");

            input = scnr.next();

            if (input.equalsIgnoreCase("v")) {
                VisitorMenu vM = new VisitorMenu();
                vM.visitorGreeting();
            } else if (input.equalsIgnoreCase("l")) {
                register();
            } else if (input.equalsIgnoreCase("e")) {
                return;
            } else {
                System.out.println("Invalid input, please try again.");
            }
        }
    }

    public static void register() {
        Scanner scnr = new Scanner(System.in);
        String input = "";
        String inputUsername;
        String inputPassword;
        boolean validLogin = false;
        CuratorRegistration cR = new CuratorRegistration();

        while (!input.equalsIgnoreCase("b")) { //CHANGE THIS
            System.out.println();
            System.out.println("(C)reate new account   (B)ack   If you already have an account, enter any key.");

            input = scnr.next();
            if (input.equalsIgnoreCase("b"))
            {
                break;
            }
            if (input.equalsIgnoreCase("c")) {
                System.out.println("Creating new account:");

                while (!validLogin) {
                    System.out.println("________________________________");
                    System.out.print("Enter new username: ");
                    inputUsername = scnr.next();
                    System.out.println();

                    System.out.print("Enter new password: ");
                    inputPassword = scnr.next();
                    System.out.println();

                    validLogin = cR.addNewCurator(inputUsername, inputPassword);

                    if (!validLogin) {
                        System.out.println("Username or password already exists, try again");
                    }
                }
            }


            System.out.println("Enter your username and password");
            System.out.println("________________________________");

            System.out.print("Username: ");
            inputUsername = scnr.next();

            System.out.println();
            System.out.print("Password: ");
            inputPassword = scnr.next();

            System.out.println("launching curatorRegistration");
            cR.checkInfo(inputUsername, inputPassword);
        }
    }
}