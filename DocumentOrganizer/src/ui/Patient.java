
package ui;
import java.io.Serializable;
import java.util.Objects;

public class Patient implements Serializable {
    
    private String first_name;
    private String last_name;
    private int id;
    
    public Patient(String first_name, String last_name, int id){
        this.first_name = first_name;
        this.last_name = last_name;    
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.first_name);
        hash = 37 * hash + Objects.hashCode(this.last_name);
        hash = 37 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Patient other = (Patient) obj;
        if (!Objects.equals(this.first_name, other.first_name)) {
            return false;
        }
        if (!Objects.equals(this.last_name, other.last_name)) {
            return false;
        }
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
}
