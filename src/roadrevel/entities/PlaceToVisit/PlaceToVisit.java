/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package roadrevel.entities.PlaceToVisit;

import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author Nasr
 */
public class PlaceToVisit {
    private int Place_Id ; 
    private String Place_name ; 
    private String Cityname ; 
    private String Place_Type ; 
    private String Place_Description ; 
    private String Place_Address ; 
    private int tickets_Price ;
    private String Place_img ; 
    private String Place_img2 ;
    private String Place_img3 ;

    public PlaceToVisit(int Place_Id) {
        this.Place_Id = Place_Id;
    }

    public PlaceToVisit(int Place_Id, String Place_name, String Cityname, String Place_Type, String Place_Description, String Place_Address, int tickets_Price, String Place_img, String Place_img2, String Place_img3) {
        this.Place_Id = Place_Id;
        this.Place_name = Place_name;
        this.Cityname = Cityname;
        this.Place_Type = Place_Type;
        this.Place_Description = Place_Description;
        this.Place_Address = Place_Address;
        this.tickets_Price = tickets_Price;
        this.Place_img = Place_img;
        this.Place_img2 = Place_img2;
        this.Place_img3 = Place_img3;
    }

    public PlaceToVisit(String Place_name, String Cityname, String Place_Type, String Place_Description, String Place_Address, int tickets_Price, String Place_img, String Place_img2, String Place_img3) {
        this.Place_name = Place_name;
        this.Cityname = Cityname;
        this.Place_Type = Place_Type;
        this.Place_Description = Place_Description;
        this.Place_Address = Place_Address;
        this.tickets_Price = tickets_Price;
        this.Place_img = Place_img;
        this.Place_img2 = Place_img2;
        this.Place_img3 = Place_img3;
    }



    public int getPlace_Id() {
        return Place_Id;
    }

    public void setPlace_Id(int Place_Id) {
        this.Place_Id = Place_Id;
    }

    public String getPlace_name() {
        return Place_name;
    }

    public void setPlace_name(String Place_name) {
        this.Place_name = Place_name;
    }

    public String getCityname() {
        return Cityname;
    }

    public void setCityname(String Cityname) {
        this.Cityname = Cityname;
    }

    public String getPlace_Type() {
        return Place_Type;
    }

    public void setPlace_Type(String Place_Type) {
        this.Place_Type = Place_Type;
    }

    public String getPlace_Description() {
        return Place_Description;
    }

    public void setPlace_Description(String Place_Description) {
        this.Place_Description = Place_Description;
    }

    public String getPlace_Address() {
        return Place_Address;
    }

    public void setPlace_Address(String Place_Address) {
        this.Place_Address = Place_Address;
    }

    public int getTickets_Price() {
        return tickets_Price;
    }

    public void setTickets_Price(int tickets_Price) {
        this.tickets_Price = tickets_Price;
    }

    public String getPlace_img() {
        return Place_img;
    }

    public void setPlace_img(String Place_img) {
        this.Place_img = Place_img;
    }

    public String getPlace_img2() {
        return Place_img2;
    }

    public void setPlace_img2(String Place_img2) {
        this.Place_img2 = Place_img2;
    }

    public String getPlace_img3() {
        return Place_img3;
    }

    public void setPlace_img3(String Place_img3) {
        this.Place_img3 = Place_img3;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final PlaceToVisit other = (PlaceToVisit) obj;
        if (this.Place_Id != other.Place_Id) {
            return false;
        }
        if (Double.doubleToLongBits(this.tickets_Price) != Double.doubleToLongBits(other.tickets_Price)) {
            return false;
        }
        if (!Objects.equals(this.Place_name, other.Place_name)) {
            return false;
        }
        if (!Objects.equals(this.Cityname, other.Cityname)) {
            return false;
        }
        if (!Objects.equals(this.Place_Type, other.Place_Type)) {
            return false;
        }
        if (!Objects.equals(this.Place_Description, other.Place_Description)) {
            return false;
        }
        if (!Objects.equals(this.Place_Address, other.Place_Address)) {
            return false;
        }
        if (!Objects.equals(this.Place_img, other.Place_img)) {
            return false;
        }
        if (!Objects.equals(this.Place_img2, other.Place_img2)) {
            return false;
        }
        return Objects.equals(this.Place_img3, other.Place_img3);
    }

    @Override
    public String toString() {
        return "PlaceToVisit{" + "Place_Id=" + Place_Id + ", Place_name=" + Place_name + ", Cityname=" + Cityname + ", Place_Type=" + Place_Type + ", Place_Description=" + Place_Description + ", Place_Address=" + Place_Address + ", tickets_Price=" + tickets_Price + ", Place_img=" + Place_img + ", Place_img2=" + Place_img2 + ", Place_img3=" + Place_img3 + '}';
    }
    
    
}
