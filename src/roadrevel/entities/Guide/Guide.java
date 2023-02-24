package roadrevel.entities.Guide;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.Objects;
import roadrevel.entities.User.User;


/**
 *
 * @author user
 */
public class Guide extends User{
     
    private String lang1;
    private String lang2;
    private String lang3;
    private String cityname;

    public Guide(int User_Id) {
        super(User_Id);
    }

    public Guide(String lang1, String lang2, String lang3, String cityname, String Fname, String Lname, String Uemail, String UserName, String Password, int Uphone, String role) {
        super(Fname, Lname, Uemail, UserName, Password, Uphone, role);
        this.lang1 = lang1;
        this.lang2 = lang2;
        this.lang3 = lang3;
        this.cityname = cityname;
    }

    public Guide( int User_Id, String Fname, String Lname, String Uemail, String UserName, String Password, int Uphone,String lang1, String lang2, String lang3, String cityname) {
        super(User_Id, Fname, Lname, Uemail, UserName, Password, Uphone);
        this.lang1 = lang1;
        this.lang2 = lang2;
        this.lang3 = lang3;
        this.cityname = cityname;
    }

    public Guide( int User_Id, String Fname, String Lname, String Uemail,int Uphone, String UserName, String Password, String lang1, String lang2, String lang3, String cityname) {
        super(User_Id, Fname, Lname, Uemail, UserName, Password, Uphone);
        this.lang1 = lang1;
        this.lang2 = lang2;
        this.lang3 = lang3;
        this.cityname = cityname;
    }

    public Guide(String Fname, String Lname, String Uname, String mail, String Pass, String Role, int Tpho, String Langue1, String Langue2, String Langue3, String Cityname) {
        super(Fname, Lname, mail, Uname, Pass, Tpho, Role);
        this.lang1 = Langue1;
        this.lang2 = Langue2;
        this.lang3 = Langue3;
        this.cityname = Cityname;
    }




   

   

   

    public String getLang1() {
        return lang1;
    }

    public String getLang2() {
        return lang2;
    }

    public String getLang3() {
        return lang3;
    }

    public String getCityname() {
        return cityname;
    }

    public void setLang1(String lang1) {
        this.lang1 = lang1;
    }

    public void setLang2(String lang2) {
        this.lang2 = lang2;
    }

    public void setLang3(String lang3) {
        this.lang3 = lang3;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname;
    }

    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.lang1);
        hash = 59 * hash + Objects.hashCode(this.lang2);
        hash = 59 * hash + Objects.hashCode(this.lang3);
        hash = 59 * hash + Objects.hashCode(this.cityname);
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
        final Guide other = (Guide) obj;
        if (!Objects.equals(this.lang1, other.lang1)) {
            return false;
        }
        if (!Objects.equals(this.lang2, other.lang2)) {
            return false;
        }
        if (!Objects.equals(this.lang3, other.lang3)) {
            return false;
        }
        return Objects.equals(this.cityname, other.cityname);
    }

    public String toString() {
        return "Guide{"+super.toString() +" " + "lang1=" + lang1 + ", lang2=" + lang2 + ", lang3=" + lang3 + ", cityname=" + cityname + '}';
    }

   
}


