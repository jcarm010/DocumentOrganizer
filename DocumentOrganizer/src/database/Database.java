
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
    
   /* private TreeMap<Company, List> comp_pat = new TreeMap<Company, List>();    
    
    public void addPatient(Company company, Patient patient){
        if (comp_pat.containsKey(company)){  
            List values = (List)comp_pat.get(company); 
            if (!values.contains(patient)){
                 values.add(patient);
                comp_pat.put(company, values);
            }
        }
        else{
            List values = new ArrayList();  
            values.add(patient);  
            comp_pat.put(company, values); 
        }
    }*/
    
    private HashMap <Patient, Company> comp_pat = new HashMap<Patient, Company>();
    private HashMap<Patient, HashMap<Date,List<Document>>> pat_doc = new HashMap<>();
    
    public void addPatient(Company company, Patient patient){
        this.comp_pat.put(patient, company);
    }
    
     public List<Patient> getAllPatients(){
        Set<Patient> set = this.comp_pat.keySet();
        List<Patient> list = new ArrayList<>();
        for(Patient p: set)
            list.add(p);        
        return list;
    }
     
    public Company getCompany(Patient patient){
        return comp_pat.get(patient);
    }
    
    
    

    
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
