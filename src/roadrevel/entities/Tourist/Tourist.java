package roadrevel.entities.Tourist;




import java.util.Date;
import java.util.Objects;
import roadrevel.entities.User.User;


/**
 *
 * @author user
 */
public class Tourist extends User{
    
    private String nationality;
    private String langue; 


     
    public Tourist(int Id_User) {
        super(Id_User);
    }
    
 
    public Tourist(int Id_User, String role,String nationality, String langue) {
        super(Id_User, role);
        this.nationality = nationality;
        this.langue = langue;
    }

    public Tourist(int Id_User, String User_FirstName, String User_LastName, String User_mail, int User_phone, String Username, String Password, String role,String nationality, String langue) {
        super(Id_User, User_FirstName, User_LastName, User_mail, User_phone, Username, Password, role);
        this.nationality = nationality;
        this.langue = langue;
    }

    public Tourist(int Id_User, String User_FirstName, String User_LastName, String User_mail, int User_phone, String Username, String Password,String nationality, String langue) {
        super(Id_User, User_FirstName, User_LastName, User_mail, User_phone, Username, Password);
        this.nationality = nationality;
        this.langue = langue;
    }

    public Tourist(int Id_User,String nationality, String langue) {
        super(Id_User);
        this.nationality = nationality;
        this.langue = langue;
    }

    public Tourist(String nationality, String langue, String User_FirstName, String User_LastName, String User_mail, int User_phone, String Username, String Password) {
        super(User_FirstName, User_LastName, User_mail, User_phone, Username, Password);
        this.nationality = nationality;
        this.langue = langue;
    }



    public Tourist(int Id_User, String cityname, Date dateBegin, Date dateEnd,String nationality, String langue) {
        super(Id_User, cityname, dateBegin, dateEnd);
        this.nationality = nationality;
        this.langue = langue;
    }

    public Tourist(int Id_User, Date dateBegin, Date dateEnd, Boolean disponibility,String nationality, String langue) {
        super(Id_User, dateBegin, dateEnd, disponibility);
        this.nationality = nationality;
        this.langue = langue;
    }


    public Tourist(String User_FirstName, String User_LastName, String User_mail, int User_phone, String Username, String Password,String nationality, String langue) {
        super(User_FirstName, User_LastName, User_mail, User_phone, Username, Password);
        this.nationality = nationality;
        this.langue = langue;
    }

    public Tourist(String User_FirstName, String User_LastName, String User_mail, String Username, String Password, int User_phone, String role,String nationality, String langue) {
        super(User_FirstName, User_LastName, User_mail, User_phone, Username, Password, role);
        this.nationality = nationality;
        this.langue = langue;
    }

  
    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getLangue() {
        return langue;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.nationality);
        hash = 11 * hash + Objects.hashCode(this.langue);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Tourist other = (Tourist) obj;
        if (!Objects.equals(this.nationality, other.nationality)) {
            return false;
        }
        return Objects.equals(this.langue, other.langue);
    }

    

    @Override
    public String toString() {
        return "Tourist{" + "nationality=" + nationality + ", langue=" + langue + '}';
    }

    
}
