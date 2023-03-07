
package roadrevel.entities.user;

import java.util.Objects;

/**
 *
 * @author Nasr
 */
public class User {
    private int User_Id ;
    private String Fname ;
    private String Lname ; 
    private String Uemail ;
        private String UserName ;
    private String Password ;
    private int Uphone ;
    private String role ;

    public User(String Fname, String Lname, String Uemail, String UserName, String Password, int Uphone, String role) {
        this.Fname = Fname;
        this.Lname = Lname;
        this.Uemail = Uemail;
        this.UserName = UserName;
        this.Password = Password;
        this.Uphone = Uphone;
        this.role = role;
    }

    public User(int User_Id, String Fname, String Lname, String Uemail, String UserName, String Password, int Uphone) {
        this.User_Id = User_Id;
        this.Fname = Fname;
        this.Lname = Lname;
        this.Uemail = Uemail;
        this.UserName = UserName;
        this.Password = Password;
        this.Uphone = Uphone;
    }

    public User(int User_Id) {
        this.User_Id = User_Id;
    }

    public User(int User_Id, String Fname, String Lname, String Uemail, String UserName, String Password, int Uphone, String role) {
        this.User_Id = User_Id;
        this.Fname = Fname;
        this.Lname = Lname;
        this.Uemail = Uemail;
        this.UserName = UserName;
        this.Password = Password;
        this.Uphone = Uphone;
        this.role = role;
    }

    User(int User_Id, String Fname, String Lname, String Uemail, int Uphone, String UserName, String Password) {
        this.User_Id = User_Id;
        this.Fname = Fname;
        this.Lname = Lname;
        this.Uemail = Uemail;
        this.UserName = UserName;
        this.Password = Password;
        this.Uphone = Uphone;
         }


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


    public int getUser_Id() {
        return User_Id;
    }

    public void setUser_Id(int User_Id) {
        this.User_Id = User_Id;
    }

    public String getFname() {
        return Fname;
    }

    public void setFname(String Fname) {
        this.Fname = Fname;
    }

    public String getLname() {
        return Lname;
    }

    public void setLname(String Lname) {
        this.Lname = Lname;
    }

    public String getUemail() {
        return Uemail;
    }

    public void setUemail(String Uemail) {
        this.Uemail = Uemail;
    }

    public int getUphone() {
        return Uphone;
    }

    public void setUphone(int Uphone) {
        this.Uphone = Uphone;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.User_Id);
        hash = 97 * hash + Objects.hashCode(this.Password);
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
        final User other = (User) obj;
        if (this.Uphone != other.Uphone) {
            return false;
        }
        if (!Objects.equals(this.User_Id, other.User_Id)) {
            return false;
        }
        if (!Objects.equals(this.Fname, other.Fname)) {
            return false;
        }
        if (!Objects.equals(this.Lname, other.Lname)) {
            return false;
        }
        if (!Objects.equals(this.Uemail, other.Uemail)) {
            return false;
        }
        if (!Objects.equals(this.UserName, other.UserName)) {
            return false;
        }
        return Objects.equals(this.Password, other.Password);
    }

    @Override
    public String toString() {
        return "User{" + "User_Id=" + User_Id + ", Fname=" + Fname + ", Lname=" + Lname + ", Uemail=" + Uemail + ", Uphone=" + Uphone + ", UserName=" + UserName + ", Password=" + Password + '}';
    }
    
    
    
}
