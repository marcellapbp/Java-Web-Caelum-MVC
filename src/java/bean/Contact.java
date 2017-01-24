package bean;

import java.util.Calendar;

/**
 *
 * @author marcella
 */
public class Contact 
{
    private long Id;
    private String Name;
    private String Email;
    private String Address;
    private Calendar Birthday;

    public long getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public Calendar getBirthday() {
        return Birthday;
    }

    public void setBirthday(Calendar Birthday) {
        this.Birthday = Birthday;
    }
    
    
    
}
