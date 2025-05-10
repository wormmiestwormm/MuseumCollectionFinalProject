public class Artifact extends Specimen
{
    private String culture, itemType;

    public Artifact(String id, String name, String arrivalDate, String region, String culture, String itemType)
    {
        super(id, name, arrivalDate, region);
        this.culture = culture;
        this.itemType = itemType;
    }

    public void setCulture(String culture)
    {
        this.culture = culture;
    }

    public void setItemType(String bone)
    {
        this.itemType = itemType;
    }

    public String getCulture()
    {
        return culture;
    }

    public String getItemType()
    {
        return itemType;
    }

    @Override
    public void printInfo ()
    {
        super.printInfo();

        if (itemType.charAt(0) == 'a')
        {
            System.out.println("    " + super.getName() + " is an " + itemType + ". ");
        }
        else
            System.out.println("    " + super.getName() + " is a " + itemType + ". ");

        System.out.println("    It belonged to the " + culture + " civilization in " + super.getRegion());
        System.out.println("___________________________________");
    }
}
