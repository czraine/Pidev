/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package roadrevel.entities.Produit.Reviews;

import java.util.Objects;

/**
 *
 * @author Nasr
 */
public class Reviews {
    private int  Review_id ;
    private String Product_Name ;
    private int Rating ; 
    private String Review_txt ; 

    public Reviews(int Review_id) {
        this.Review_id = Review_id;
    }

    public Reviews(int Review_id, String Product_Name, int Rating, String Review_txt) {
        this.Review_id = Review_id;
        this.Product_Name = Product_Name;
        this.Rating = Rating;
        this.Review_txt = Review_txt;
    }

    public Reviews(String Product_Name, int Rating, String Review_txt) {
        this.Product_Name = Product_Name;
        this.Rating = Rating;
        this.Review_txt = Review_txt;
    }

    public int getReview_id() {
        return Review_id;
    }

    public void setReview_id(int Review_id) {
        this.Review_id = Review_id;
    }

    public String getProduct_Name() {
        return Product_Name;
    }

    public void setProduct_Name(String Product_Name) {
        this.Product_Name = Product_Name;
    }

    public int getRating() {
        return Rating;
    }

    public void setRating(int Rating) {
        this.Rating = Rating;
    }

    public String getReview_txt() {
        return Review_txt;
    }

    public void setReview_txt(String Review_txt) {
        this.Review_txt = Review_txt;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        if (this.Rating != other.Rating) {
            return false;
        }
        if (!Objects.equals(this.Product_Name, other.Product_Name)) {
            return false;
        }
        return Objects.equals(this.Review_txt, other.Review_txt);
    }

    @Override
    public String toString() {
        return "Reviews{" + "Review_id=" + Review_id + ", Product_Name=" + Product_Name + ", Rating=" + Rating + ", Review_txt=" + Review_txt + '}';
    }

}
