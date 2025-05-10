public class Specimen
{
    private String id, name, arrivalDate, region;

    public Specimen(String id, String name, String arrivalDate, String region)
    {
        this.id = id;
        this.name = name;
        this.arrivalDate = arrivalDate;
        this.region = region;
    }

    public String getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public String getArrivalDate()
    {
        return arrivalDate;
    }

    public String getRegion()
    {
        return region;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    //mutates arrivalDate
    public void setArrivalDate(String arrivalDate)
    {
        this.arrivalDate = arrivalDate;
    }

    //mutates region
    public void setRegion(String region)
    {
        this.region = region;
    }

    //prints all info on artifact
    public void printInfo ()
    {
        System.out.println("___________________________________");
        System.out.println("Specimen: " + id);
        System.out.println("    Arrived to the museum at " + arrivalDate + ".");
    }
}