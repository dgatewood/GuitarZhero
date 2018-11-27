import java.util.*;
/**
 * Write a description of class PatientRecord here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PatientRecord
{
    private String lastName = "";
    private String firstName = "";
    private String DOB = "";
    ArrayList<Visit> visits = new ArrayList();
    /**
     * Constructor for objects of class PatientRecord
     */
    public PatientRecord(String fn, String ln, String dob, ArrayList<Visit> list)
    {
        lastName = ln;
        firstName = fn;
        DOB = dob;
        for(Visit v : list)
        {
            visits.add(v);
        }
    }

    public PatientRecord(String fn, String ln, String dob)
    {
        lastName = ln;
        firstName = fn;
        DOB = dob;
    }

    public String getLastName()
    {
        return lastName;
    }

    public String getFirstName()
    {
        return lastName;
    }

    public String getDOB()
    {
        return lastName;
    }
    
    public void addVisit(Visit v)
    {
        visits.add(v);
    }
    
    public ArrayList<Visit> getVisits()
    {
        return visits;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof PatientRecord)) {
            return false;
        }
        PatientRecord p = (PatientRecord)o;
        return (p.getLastName() == getLastName()) && (p.getFirstName() == getFirstName()) && (p.getDOB() == getDOB());
    }

    @Override 
    public int hashCode() {  
        int hash = 5;  
        hash = 79 * hash + hashCode(firstName);  
        hash = 79 * hash + hashCode(lastName);  
        hash = 79 * hash + hashCode(DOB);  
        return hash & 0x7fffffff; 
    }

    public int hashCode(String value) {
        int h= 0 ;
        for(int i = 0; i < value.length(); i++)
        {
            char c = value.charAt(i); 
            h = 31 * h + c;
        }

        return h;
    }
}
