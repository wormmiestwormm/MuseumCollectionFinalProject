import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PublicCollection
{
    private ArrayList<Specimen> viewC = new ArrayList<>();
    int areaOfStudy;

    public void getFullCollection(int areaOfStudy) {
        MasterCollection getCollections = new MasterCollection();
        this.areaOfStudy = areaOfStudy;

        viewC = getCollections.copyCollection(areaOfStudy, viewC);
        printCollection();
    }

    public void printCollection()
    {
        int count = 1;

        if (areaOfStudy == 1)
        {
            System.out.println("Archaeology collection:");
        }
        else if (areaOfStudy == 2)
        {
            System.out.println("Geology collection:");
        }
        else
        {
            System.out.println("Paleontology collection:");
        }
        System.out.println("_______________________");

        for (Specimen s: viewC)
        {
            System.out.print(count + s.getName() + ", ");
            count++;
        }
        System.out.println();
        System.out.println("_______________________");
    }

    public void filterCollection(String filter)
    {
        if (areaOfStudy == 1)
        {
            Artifact a;
            for (Specimen s : viewC)
            {
                a = (Artifact) s;
                if (!s.getName().contains(filter) && !s.getRegion().contains(filter) && !a.getCulture().contains(filter) && !a.getItemType().contains(filter)) {
                    viewC.remove(s);
                }
            }
        }
        else if (areaOfStudy == 2)
        {
            Mineral m;
            for (Specimen s : viewC)
            {
                m = (Mineral) s;
                if (!s.getName().contains(filter) && !s.getRegion().contains(filter) && !m.getHasCrystal()) {
                    viewC.remove(s);
                }
            }
        }
        else
        {
            Fossil f;
            for (Specimen s : viewC)
            {
                f = (Fossil) s;
                if (!s.getName().contains(filter) && !s.getRegion().contains(filter) && !f.getFamily().contains(filter) && !f.getBone().contains(filter)) {
                    viewC.remove(s);
                }
            }
        }

    }


    public void sortCollectionAZ()
    {
        Collections.sort(viewC, Comparator.comparing(Specimen::getName));
    }

    public void sortCollectionZA()
    {
        Collections.sort(viewC, Collections.reverseOrder(Comparator.comparing(Specimen::getName)));
    }

    public void sortCollectionDate()
    {
        Collections.sort(viewC, Comparator.comparing(Specimen::getArrivalDate));
    }
    public void sortCollectionRegion()
    {
        Collections.sort(viewC, Comparator.comparing(Specimen::getRegion));
    }

    public void viewSpecimen(int specIndex)
    {
        viewC.get(specIndex).printInfo();
    }
}
