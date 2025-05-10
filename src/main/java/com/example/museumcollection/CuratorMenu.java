import java.util.Scanner;

public class CuratorMenu {
    Scanner scnr;

    private MasterCollection mC = new MasterCollection();

    public void curatorGreeting() {
        scnr = new Scanner(System.in);
        String action = "";

        System.out.println("Hello, what would you like to do?");
        System.out.println("(A)dd Specimen   (V)iew Specimen   (B)ack");

        action = scnr.next();
        if (action.equalsIgnoreCase("A")) {
            getNewArtifactInfo();
            curatorOptions();
        } else if (action.equalsIgnoreCase("V")) {
            getSpecimen();
            curatorOptions();
        } else if (action.equalsIgnoreCase("b")) {
            //ends method and goes back to MuseumCollection
        } else
        {
            System.out.println("Invalid input, please try again");
            curatorOptions();
        }
    }

    public void curatorOptions()
    {
        String input = "";
        scnr = new Scanner(System.in);

        while (!input.equalsIgnoreCase("b"))
        {
            System.out.println("what would you like to do next?");
            System.out.println("(A)dd Specimen   (V)iew Specimen   (B)ack");

            input = scnr.next();
            if (input.equalsIgnoreCase("A")) {
                getNewArtifactInfo();
            }
            else if (input.equalsIgnoreCase("V")) {
                getSpecimen();
            }
            else if (input.equalsIgnoreCase("b")) {
                //ends method and goes back to MuseumCollection
            }
            else
            {
                System.out.println("Invalid input, please try again");
                curatorOptions();
            }
        }
    }

    public void getNewArtifactInfo()
    {
        String name, arrivalDate, region, description, id;
        scnr = new Scanner(System.in);

        System.out.println("Which collection does this specimen go to?");
        System.out.println("________________________________________________");
        System.out.println("(1) Archaeology   (2) Geology   (3) Paleontology");

        int areaOfStudy = scnr.nextInt();
        while (areaOfStudy != 1 && areaOfStudy != 2 && areaOfStudy != 3) {
            System.out.println("Please try again");
            System.out.println("________________");
            System.out.println("(1) Archaeology   (2) Geology   (3) Paleontology");
            areaOfStudy = scnr.nextInt();
        }

        System.out.print("Enter the artifact/mineral/species name of the specimen: ");
        scnr.nextLine();
        name = scnr.nextLine();
        System.out.println();

        System.out.print("Enter the date " + name + " arrived to the museum: ");
        arrivalDate = scnr.nextLine();
        System.out.println();

        System.out.print("Enter the country " + name + " was discovered in: ");
        region = scnr.nextLine();
        System.out.println();

        if (areaOfStudy == 1)
        {
            System.out.print("Enter the culture " + name + " belonged to: ");
            String culture = scnr.nextLine();
            System.out.println();

            System.out.print("Enter the type of object " + name + " is: ");
            String itemType = scnr.nextLine();
            System.out.println();

            id = mC.addNewArtifact( name, arrivalDate, region, culture, itemType);

            System.out.println("_________________________________________________________________");
            System.out.println("Added " + name + " to archaeology collection with the ID: " + id);
            System.out.println("_________________________________________________________________");
            System.out.println();
        }
        else if (areaOfStudy == 2)
        {
            boolean hasCrystal;

            System.out.println("Does " + name + " have crystals? ");
            System.out.println("(y)es   (n)o");
            if (scnr.next().equalsIgnoreCase("y"))
            {
                hasCrystal = true;
            }
            else
                hasCrystal = false;

            System.out.println();

            id = mC.addNewMineral( name, arrivalDate, region, hasCrystal);

            System.out.println("_________________________________________________________________");
            System.out.println("Added " + name + " to geology collection with the ID: " + id);
            System.out.println("_________________________________________________________________");
            System.out.println();
        }
        else {
            System.out.print("Enter the family the species belongs to: ");
            String family = scnr.next();
            System.out.println();

            System.out.print("Enter the type of skeletal material found of " + name + ": ");
            scnr.nextLine();
            String bone = scnr.nextLine();
            System.out.println();

            id = mC.addNewFossil( name, arrivalDate, region, family, bone);

            System.out.println("_________________________________________________________________");
            System.out.println("Added " + name + " to paleontology collection with the ID: " + id);
            System.out.println("_________________________________________________________________");
            System.out.println();
        }
    }

    public void getSpecimen()
    {
        mC.addNewArtifact("name", "arrivalDate", "region", "culture", "itemType");
        Scanner scnr = new Scanner(System.in);
        int areaOfStudy;
        String id;

        System.out.println("Which collection would you like to access?");
        System.out.println("________________________________________________");
        System.out.println("(1) Archaeology   (2) Geology   (3) Paleontology");

        areaOfStudy = scnr.nextInt();
        while (areaOfStudy != 1 && areaOfStudy != 2 && areaOfStudy != 3) {
            System.out.println("Please try again");
            System.out.println("________________");
            System.out.println("(1) Archaeology   (2) Geology   (3) Paleontology");
            areaOfStudy = scnr.nextInt();
        }

        System.out.println("Enter the ID of the specimen you'd like to retrieve");
        scnr.nextLine();
        id = scnr.nextLine();

        System.out.println();

        int index = mC.viewSpecimen(areaOfStudy, id);
        while (index == -1)
        {

            System.out.println("Please try again");
            System.out.println("________________");
            System.out.println("Enter the id of the specimen you'd like to retrieve");
            id = scnr.nextLine();

            index = mC.viewSpecimen(areaOfStudy, id);
        }

        System.out.println();
        System.out.println("Specimen found! What would you like to do?");
        System.out.println("(E)dit properties   (R)emove");
        String action = scnr.next();

        if (action.equalsIgnoreCase("r"))
        {
            mC.removeSpecimen(areaOfStudy, index);
        }
        if (action.equalsIgnoreCase("e"))
        {
            getEditCriteria(areaOfStudy, index);
        }
    }

    public void getEditCriteria(int areaOfStudy, int index)
    {
        Scanner scnr = new Scanner(System.in);
        int criteria = 1;
        String newInfo;

        System.out.println("Select specimen info to change:");
        System.out.print("(1)Name   (2)Arrival Date   (3)Region ");

        if (areaOfStudy == 1)
        {

            System.out.println("(4)Culture   (5)Item type)");
            criteria = scnr.nextInt();

            while (criteria != 1 && criteria != 2 && criteria != 3 && criteria != 4 && criteria != 5)
            {
                System.out.println("Invalid input, try again");
                criteria = scnr.nextInt();
            }

            System.out.print("Change to: ");
            scnr.nextLine();
            newInfo = scnr.nextLine();

            mC.editSpecimen(areaOfStudy, index, criteria, newInfo);
        }
        else if (areaOfStudy == 2)
        {
            System.out.println("(4)Crystal");
            criteria = scnr.nextInt();

            while (criteria != 1 && criteria != 2 && criteria != 3 && criteria != 4)
            {
                System.out.println("Invalid input, try again");
                criteria = scnr.nextInt();
            }

            if (criteria == 4)
            {
                System.out.println("Crystal formation:");
                System.out.println("(C)rystal present   (N)o crystal");
            }
            else
                System.out.print("Change to: ");
            scnr.nextLine();
            newInfo = scnr.nextLine();

            mC.editSpecimen(areaOfStudy, index, criteria, newInfo);
        }
        else {
            System.out.println("(4)Family   (5)Bone");
            criteria = scnr.nextInt();

            while (criteria != 1 && criteria != 2 && criteria != 3 && criteria != 4 && criteria != 5)
            {
                System.out.println("Invalid input, try again");
                criteria = scnr.nextInt();
            }

            System.out.print("Change to: ");
            scnr.nextLine();
            newInfo = scnr.nextLine();

            mC.editSpecimen(areaOfStudy, index, criteria, newInfo);
        }
    }
}
