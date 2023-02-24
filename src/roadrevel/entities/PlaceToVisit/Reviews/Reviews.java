/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package roadrevel.entities.PlaceToVisit.Reviews;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Objects;

/**
 *
 * @author Nasr
 */
public class Reviews {
    private int  Review_id ;
    private String Place_Name ;
    private double Rating ; 
    private String Review_txt ; 
    private int place_id ;
    private Date review_date ;
    private int id_User ;

    public int getId_User() {
        return id_User;
    }

    public void setId_User(int id_User) {
        this.id_User = id_User;
    }


    public Reviews(int Review_id) {
        this.Review_id = Review_id;
    }

    public Reviews(String Place_Name, double Rating, String Review_txt, int place_id , Date review_date,int id_User) {
        this.Place_Name = Place_Name;
        this.Rating = Rating;
        this.Review_txt = Review_txt;
        this.place_id = place_id;
        this.review_date =  review_date ;
        this.id_User = id_User;
    }



    public Reviews(int Review_id, String Place_Name, double Rating, String Review_txt, int place_id,Date review_date ,int id_User ) {
        this.Review_id = Review_id;
        this.Place_Name = Place_Name;
        this.Rating = Rating;
        this.Review_txt = Review_txt;
        this.place_id = place_id;
        this.review_date =  review_date ;
        this.id_User=id_User ;
    }

    public Date getReview_date() {
        return review_date;
    }

    public void setReview_date(Date review_date) {
        this.review_date = review_date;
    }

    @Override
    public String toString() {
        return "Reviews{" + "Place_Name=" + Place_Name + ", Rating=" + Rating + ", Review_txt=" + Review_txt + '}';
    }

    public int getReview_id() {
        return Review_id;
    }

    public void setReview_id(int Review_id) {
        this.Review_id = Review_id;
    }

    public String getPlace_Name() {
        return Place_Name;
    }

    public void setPlace_Name(String Place_Name) {
        this.Place_Name = Place_Name;
    }

    public double getRating() {
        return Rating;
    }

    public void setRating(double Rating) {
        this.Rating = Rating;
    }

    public String getReview_txt() {
        return Review_txt;
    }

    public void setReview_txt(String Review_txt) {
        this.Review_txt = Review_txt;
    }

    public int getPlace_id() {
        return place_id;
    }

    public void setPlace_id(int place_id) {
        this.place_id = place_id;
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final Reviews other = (Reviews) obj;
        if (this.Review_id != other.Review_id) {
            return false;
        }
        if (Double.doubleToLongBits(this.Rating) != Double.doubleToLongBits(other.Rating)) {
            return false;
        }
        if (this.place_id != other.place_id) {
            return false;
        }
        if (!Objects.equals(this.Place_Name, other.Place_Name)) {
            return false;
        }
        return Objects.equals(this.Review_txt, other.Review_txt);
    }

    
}
