/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roadrevel.entities.EventReview;

import java.util.Objects;

/**
 *
 * @author GAMING A15
 */
public class Review {
    private int Review_id;
    private String Event_name;
    private String Review_txt;
    
    private int id_user;
        private int Event_id;

    public int getEvent_id() {
        return Event_id;
    }

    public void setEvent_id(int Event_id) {
        this.Event_id = Event_id;
    }


    public Review(int Review_id, String Event_name, String Review_txt,  int id_user, int Event_id) {
        this.Review_id = Review_id;
        this.Event_name = Event_name;
        this.Review_txt = Review_txt;
        
        this.id_user = id_user;
        this.Event_id = Event_id;
    }

    public Review(String Event_name, String Review_txt, int id_user, int Event_id) {
        this.Event_name = Event_name;
        this.Review_txt = Review_txt;
        
        this.id_user = id_user;
                this.Event_id = Event_id;

    }

    public Review(String Event_name, String Review_txt) {
        this.Event_name = Event_name;
        this.Review_txt = Review_txt;
    }

    public Review(String Review_txt) {
        this.Review_txt = Review_txt;
    }
    
    
    

    public int getReview_id() {
        return Review_id;
    }

    public void setReview_id(int Review_id) {
        this.Review_id = Review_id;
    }

    public String getEvent_name() {
        return Event_name;
    }

    public void setEvent_name(String Event_name) {
        this.Event_name = Event_name;
    }

    public String getReview_txt() {
        return Review_txt;
    }

    public void setReview_txt(String Review_txt) {
        this.Review_txt = Review_txt;
    }

   

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Review other = (Review) obj;
        if (this.Review_id != other.Review_id) {
            return false;
        }
        if (!Objects.equals(this.Event_name, other.Event_name)) {
            return false;
        }
        if (!Objects.equals(this.Review_txt, other.Review_txt)) {
            return false;
        }
        
        if (this.id_user != other.id_user) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Review{" + "Review_id=" + Review_id + ", Event_name=" + Event_name + ", Review_txt=" + Review_txt + " id_user=" + id_user + '}';
    }
    
    
    
    
    
}
