
/**
 * Write a description of class Visit here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Visit
{
    private String date;
    private String visitReason;
    private String visitTreatment;
    /**
     * Constructor for objects of class Visit
     */
    public Visit(String d, String vR, String vT)
    {
        date = d;
        visitReason = vR;
        visitTreatment = vT;
    }
    
    public String getDate()
    {
        return date;
    }
    
    public String getVisitReason()
    {
        return visitReason;
    }
    
    public String getVisitTreatment()
    {
        return visitTreatment;
    }

}
