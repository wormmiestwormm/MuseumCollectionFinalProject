import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Scanner;

public class VisitorMenu extends Application
{
    private PublicCollection pC = new PublicCollection();
    private Scanner scnr;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(VisitorMenu.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public void visitorGreeting()
    {
        scnr = new Scanner(System.in);
        System.out.println("Which of our collections would you like to view?");
        System.out.println("________________________________________________");
        System.out.println("(1) Archaeology   (2) Geology   (3) Paleontology");

        int areaOfStudy = scnr.nextInt();
        pC.getFullCollection(areaOfStudy);

        nextOption();
    }

    public void nextOption()
    {
        scnr = new Scanner(System.in);
        String action = "";
        while(!action.equalsIgnoreCase("b"))
        {
            System.out.println("Next action:");
            System.out.println("(V)iew specimen  (F)ilter   (S)ort   (B)ack");
            action = scnr.next();

            if (action.equalsIgnoreCase("v"))
            {
                getSpecimenIndex();
            } else if (action.equalsIgnoreCase("f"))
            {
                getFilter();
            } else if (action.equalsIgnoreCase("s"))
            {
                getSortCriteria();
            }
        }
    }

    public void getFilter()
    {
        scnr = new Scanner(System.in);
        String filter;

        System.out.print("Search by: ");
        filter = scnr.next();
        System.out.println();

        pC.filterCollection(filter);
        pC.printCollection();
    }

    public void getSortCriteria()
    {
        scnr = new Scanner(System.in);
        int sortAction;

        System.out.println("Sort by: (1)A-Z   (2)Z-A   (3)Date delivered to museum   (4)Region");
        sortAction = scnr.nextInt();

        switch (sortAction)
        {
            case 1:
                pC.sortCollectionAZ();
                break;
            case 2:
                pC.sortCollectionZA();
                break;
            case 3:
                pC.sortCollectionDate();
                break;
            case 4:
                pC.sortCollectionRegion();
                break;
        }
        pC.printCollection();
    }

    public void getSpecimenIndex()
    {
        int specIndex;
        scnr = new Scanner(System.in);
        boolean done = false;

        while (!done)
        {
            System.out.println("Enter the number of the specimen to see the information");
            specIndex = scnr.nextInt() - 1;

            try
            {
                pC.viewSpecimen(specIndex);
                done = true;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Error, index out of bounds, please try again");
            }
        }
    }
}