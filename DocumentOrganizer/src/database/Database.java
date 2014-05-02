
package database;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import ui.Company;
import ui.Document;
import ui.Patient;

public class Database {
    
    
    private HashMap <Patient, Company> comp_pat = new HashMap<Patient, Company>();
    private HashMap<Patient, HashMap<Date,List<Document>>> pat_doc = new HashMap<>();
    private HashMap<Company, Set<Patient>> pat_comp= new HashMap<>();
    

    
    // Add a patient with a company
    public void addPatient(Company company, Patient patient){
        this.comp_pat.put(patient, company);
    }
    
    // Returns list of all patients
    public List<Patient> getAllPatients(){
        Set<Patient> set = this.comp_pat.keySet();
        List<Patient> list = new ArrayList<>();
        for(Patient p: set)
            list.add(p);        
        return list;
    }
    
    // Returns the Company of a patient
    public Company getCompany(Patient patient){
        return comp_pat.get(patient);
    }
    
    // Return list of all Companies
    public List<Company> getAllCompanies(){

        List<Company> result = new ArrayList<>();
        Set <Company> list = new HashSet();
        Set<Entry<Patient,Company>> set = this.comp_pat.entrySet();
        for(Entry<Patient, Company> e: set){
            list.add(e.getValue());            
        }
        for(Company c: list)
            result.add(c); 
        return result;
    }
    
    // Returns all patients of a Company
    public List<Patient> getCompanyPatients(Company company){
       List<Patient> list = new ArrayList<>(); 
       Set<Patient> set = pat_comp.get(company);
       for(Patient p: set)
           list.add(p);
       return list;
    }

    // Add Document to a patient
    public void addDocument(Patient patient, Document doc){
        List list = this.pat_doc.get(patient).get(doc.getDate());
        list.add(doc);
        HashMap<Date,List<Document>> map = this.pat_doc.get(patient);
        map.put(doc.getDate(), list);
        this.pat_doc.put(patient, map);
        //this.pat_doc.put(patient,this.pat_doc.get(patient).put(doc.getDate(), list));
                
    }
    
    
    // Returns List of all Documents of a specific patient withing a period
    public List<Document> getDocuments(Patient patient, List<Date> period){        
        HashMap<Date,List<Document>> documents = this.pat_doc.get(patient);
        List<Document> result = new ArrayList<>();
        List<Document> list;
        for(Date d: period){
           list = documents.get(d);
           for(Document doc: list){
               result.add(doc);
           }
        }
        return result;
    }
    
    // Returns all Documents of a specific patient
    public List<Document> getDocument(Patient patient){
        
        HashMap<Date,List<Document>> documents = this.pat_doc.get(patient);
        List<Document> result = new ArrayList<>();
        List<Document> list;
        Set<Entry<Date,List<Document>>> set = documents.entrySet();
        for(Entry<Date, List<Document>> e: set){
            list = e.getValue();
            for(Document doc: list)
                result.add(doc);           
        }
        return result;    
    }
}
