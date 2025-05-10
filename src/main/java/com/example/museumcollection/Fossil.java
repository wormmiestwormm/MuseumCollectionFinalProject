public class Fossil extends Specimen
{
    private String family, bone;

    public Fossil(String id, String name, String arrivalDate, String region, String family, String bone)
    {
        super(id, name, arrivalDate, region);
        this.family = family;
        this.bone = bone;
    }

    public void setFamily(String family)
    {
        this.family = family;
    }

    public void setBone(String bone)
    {
        this.bone = bone;
    }

    public String getFamily()
    {
        return family;
    }

    public String getBone()
    {
        return bone;
    }

    @Override
    public void printInfo ()
    {
        super.printInfo();

        System.out.println("    " + super.getName() + " is a part of " + family + ". ");
        System.out.println("    The " + bone + " of "+ super.getName() + " have been found from " + super.getRegion());
        System.out.println("___________________________________");
    }
}
