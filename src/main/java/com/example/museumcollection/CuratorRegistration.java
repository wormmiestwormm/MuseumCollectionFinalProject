import java.util.ArrayList;

public class CuratorRegistration
{

    static ArrayList<Curator> accountList = new ArrayList<Curator>();

    public boolean addNewCurator(String inputUsername, String inputPassword)
    {

        for (Curator c : accountList)
        {
            if (c.getUsername().equals(inputUsername) || c.getPassword().equals(inputPassword))
            {
                return false;
            }
        }
        Curator c = new Curator(inputUsername, inputPassword);
        accountList.add(c);
        return true;
    }

    public void checkInfo(String inputUsername, String inputPassword)
    {

        System.out.println("checkInfo is active");
        System.out.println();

        boolean accountExists = false;


        for (Curator c: accountList)
        {
            if (c.getUsername().equals(inputUsername) && c.getPassword().equals(inputPassword))
            {
                accountExists = true;
                CuratorMenu cM = new CuratorMenu();
                System.out.println("launching curator menu");
                cM.curatorGreeting();
                break;
            }
        }
        //doesnt do this, fix later
        if (!accountExists)
        {
            System.out.println("Account not found, try again.");
        }
    }
}
