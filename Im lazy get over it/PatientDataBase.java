import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.*;
import java.io.*;
/**
 * Write a description of class PatientDataBase here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PatientDataBase
{
    HashMap<Integer, PatientRecord> database = new HashMap();
    public PatientDataBase(String filename) throws Exception
    {

        File file = new File(filename);
        Scanner scanner = new Scanner(file);
        while(scanner.hasNextLine())
        {
            String line = scanner.nextLine();
            System.out.println(line + "<---- printed from line");
            if(line.substring(0,1).equals("?"))
            {

            }
            else
            {
                String fName = scanner.nextLine();
                System.out.println("f name " + fName);
                String lName = scanner.nextLine();
                System.out.println("last name " +lName);
                String DOB = scanner.nextLine();
                System.out.println("DOB " + DOB);
                PatientRecord pR = new PatientRecord(fName, lName, DOB);

                if(scanner.hasNextInt() || !scanner.hasNextLine())
                {
                    System.out.println("no int and not next line");
                }
                else
                {
                    String DOV = scanner.nextLine();
                    System.out.println("Dov " + DOV);
                    String reason = scanner.nextLine();
                    System.out.println("reason " + reason);
                    String treatment = scanner.nextLine();
                    System.out.println("treatment " + treatment);
                    Visit v = new Visit(DOV, reason, treatment);
                }
                int hashID = pR.hashCode();
                System.out.println(hashID);
                
                database.put(hashID, pR);
            }
        }
    }

    public void addPatientVisit(int id, Visit v)
    {
        PatientRecord r = database.get(id);
        r.addVisit(v);
    }

    public ArrayList<Pair<String, String>> getReasonTreatmentPairs(int id,String date)
    {
        ArrayList<Pair<String, String>> treatmentPairs = new ArrayList<>();
        PatientRecord r = database.get(id);
        for(Visit v : r.getVisits())
        {
            Pair<String, String> p = new Pair(v.getVisitReason(), v.getVisitTreatment());
        }
        return treatmentPairs;
    }

    public void writeDatabaseFile(String fileName)
    {

    }

    public void addPatientRecord(String fn, String ln, String dob)
    {
        PatientRecord pR = new PatientRecord(fn, ln, dob);
        int key = pR.hashCode();
        database.put(key, pR);
    }

    public void removePatientRecord(String firstName, String lastName, String DOB)
    {

    }

    public PatientRecord getPatientRecord(int id)
    {
        return database.get(id);
    }

    public List getVisitDates(int id)
    {
        ///Need to search by ID and return a list of Strings of the dates that that patient has.
        List<String> visitDates = new ArrayList<String>();
        PatientRecord p = database.get(id);
        ArrayList<Visit> visits = p.getVisits();
        for(Visit v: visits)
        {
            visitDates.add(v.getDate());
        }

        return visitDates;
    }

    public HashMap getPatientIdsNames()
    {
        HashMap<Integer, String> hm = new HashMap<Integer, String>();
        return hm;
    }
}
