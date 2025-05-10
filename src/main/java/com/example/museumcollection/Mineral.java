public class Mineral extends Specimen
{
    private boolean hasCrystal;

    public Mineral(String id, String name, String arrivalDate, String region, boolean hasCrystal)
    {
        super(id, name, arrivalDate, region);
        this.hasCrystal = hasCrystal;
    }

    public void setHasCrystal(boolean hasCrystal)
    {
        this.hasCrystal = hasCrystal;
    }

    public boolean getHasCrystal()
    {
        return hasCrystal;
    }

    @Override
    public void printInfo ()
    {
        super.printInfo();

        System.out.println("    This is a " + super.getName());
        System.out.print("    It originated from " + super.getRegion() + ", ");
        if (hasCrystal)
        {
            System.out.println("and bears crystals");
        }
        else
            System.out.println("and bears no crystals");

        System.out.println("___________________________________");
    }
}
