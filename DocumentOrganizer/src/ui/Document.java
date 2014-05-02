package ui;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Document implements Serializable {
    
    private Date date;
    private String address;
    
    public Document(Date date, String address){
        this.date = date;
        this.address = address;
    }
    
    public Date getDate(){
        return this.getDate();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.date);
        hash = 29 * hash + Objects.hashCode(this.address);
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
        final Document other = (Document) obj;
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        return true;
    }
    
    
}
