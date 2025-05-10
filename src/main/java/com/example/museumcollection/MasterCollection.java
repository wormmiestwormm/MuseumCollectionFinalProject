import java.util.ArrayList;

public class MasterCollection {
    private static final ArrayList<Artifact> archaeology = new ArrayList<>();
    private static final ArrayList<Mineral> geology = new ArrayList<>();
    private static final ArrayList<Fossil> paleontology = new ArrayList<>();

    public String addNewArtifact(String name, String arrivalDate, String region, String culture, String itemType)
    {
        String id = "A:" + archaeology.size();
        Artifact newArtifact = new Artifact(id, name, arrivalDate, region, culture, itemType);

        archaeology.add(newArtifact);
        return id;
    }

    public String addNewMineral(String name, String arrivalDate, String region, boolean hasCrystal)
    {
        String id = "G:" + geology.size();
        Mineral newMineral = new Mineral(id, name, arrivalDate, region, hasCrystal);

        geology.add(newMineral);
        return id;
    }

    public String addNewFossil(String name, String arrivalDate, String region, String family, String bone)
    {
        String id = "P:" + paleontology.size();
        Fossil newFossil = new Fossil(id, name, arrivalDate, region, family, bone);

        paleontology.add(newFossil);
        return id;
    }


    public void removeSpecimen(int areaOfStudy, int index)
    {
        if (areaOfStudy == 1)
        {
            System.out.println("_________________________________________________________________");
            System.out.println("Removed " + archaeology.get(index).getId() + " from archaeology collection.");
            System.out.println("_________________________________________________________________");
            System.out.println();
            archaeology.remove(index);
        }

        else if (areaOfStudy == 2)
        {
            System.out.println("_________________________________________________________________");
            System.out.println("Removed " + geology.get(index).getId() + " from archaeology collection.");
            System.out.println("_________________________________________________________________");
            System.out.println();
            geology.remove(index);
        }

        else if (areaOfStudy == 3)
        {
            System.out.println("_________________________________________________________________");
            System.out.println("Removed " + paleontology.get(index).getId() + " from archaeology collection.");
            System.out.println("_________________________________________________________________");
            System.out.println();
            paleontology.remove(index);
        }
    }

    public int viewSpecimen(int areaOfStudy, String id)
    {
        if (areaOfStudy == 1)
        {
            for (Specimen S: archaeology)
            {
                if (S.getId().equalsIgnoreCase(id))
                {
                    archaeology.indexOf(S);
                    S.printInfo();
                    return archaeology.indexOf(S);
                }
            }
        }

        else if (areaOfStudy == 2)
        {
            for (Specimen S: geology)
            {
                if (S.getId().equalsIgnoreCase(id))
                {
                    S.printInfo();
                    return geology.indexOf(S);
                }
            }
        }

        else if (areaOfStudy == 3)
        {
            for (Specimen S: paleontology)
            {
                if (S.getId().equalsIgnoreCase(id))
                {
                    S.printInfo();
                    return paleontology.indexOf(S);
                }
            }
        }

        return -1;
    }

    public void editSpecimen(int areaOfStudy, int index, int criteria, String newInfo)
    {
        if (areaOfStudy == 1)
        {
            switch (criteria)
            {
                case 1:
                    archaeology.get(index).setName(newInfo);
                    break;
                case 2:
                    archaeology.get(index).setArrivalDate(newInfo);
                    break;
                case 3:
                    archaeology.get(index).setRegion(newInfo);
                    break;
                case 4:
                    archaeology.get(index).setCulture(newInfo);
                    break;
                case 5:
                    archaeology.get(index).setItemType(newInfo);
                    break;
            }
        }
        else if (areaOfStudy == 2)
        {
            switch (criteria)
            {
                case 1:
                    geology.get(index).setName(newInfo);
                    break;
                case 2:
                    geology.get(index).setArrivalDate(newInfo);
                    break;
                case 3:
                    geology.get(index).setRegion(newInfo);
                    break;
                case 4:
                    boolean crystal = false;
                    if (newInfo.equalsIgnoreCase("y"))
                    {
                        crystal = true;
                    }
                    geology.get(index).setHasCrystal(crystal);
                    break;
            }
        }
        else
        {
            switch (criteria)
            {
                case 1:
                    paleontology.get(index).setName(newInfo);
                    break;
                case 2:
                    paleontology.get(index).setArrivalDate(newInfo);
                    break;
                case 3:
                    paleontology.get(index).setRegion(newInfo);
                    break;
                case 4:
                    paleontology.get(index).setFamily(newInfo);
                    break;
                case 5:
                    paleontology.get(index).setBone(newInfo);
                    break;
            }
        }
    }

    public ArrayList<Specimen> copyCollection(int areaOfStudy, ArrayList<Specimen> copiedList)
    {
        if (areaOfStudy == 1)
        {
            copiedList = (ArrayList)archaeology.clone();
            return copiedList;
        }
        else if (areaOfStudy == 2)
        {
            copiedList = (ArrayList)geology.clone();
            return copiedList;
        }
        else
        {
            copiedList = (ArrayList)paleontology.clone();
            return copiedList;
        }
    }
}
