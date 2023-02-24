/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package roadrevel.Entities.Tourist;


import java.util.Objects;
import roadrevel.entities.User.User;

/**
 *
 * @author user
 */
public class Tourist extends User{
    
   private String nationality;
    private String langue; 

    public Tourist(int User_Id) {
        super(User_Id);
    }

    public Tourist( String Fname, String Lname, String Uemail, String UserName, String Password, int Uphone, String role,String nationality, String langue) {
        super(Fname, Lname, Uemail, UserName, Password, Uphone, role);
        this.nationality = nationality;
        this.langue = langue;
    }

    public Tourist( int User_Id, String Fname, String Lname, String Uemail, String UserName, String Password, int Uphone,String nationality, String langue) {
        super(User_Id, Fname, Lname, Uemail, UserName, Password, Uphone);
        this.nationality = nationality;
        this.langue = langue;
    }

    public Tourist( int User_Id, String Fname, String Lname, String Uemail, String UserName, String Password, int Uphone, String role,String nationality, String langue) {
        super(User_Id, Fname, Lname, Uemail, UserName, Password, Uphone, role);
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

    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.nationality);
        hash = 11 * hash + Objects.hashCode(this.langue);
        return hash;
    }

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

    

    public String toString() {
        return "Tourist{" + "nationality=" + nationality + ", langue=" + langue + '}';
    }


    
  

    
   

    
   
   

   

    
    
}
