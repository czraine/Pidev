/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package roadrevel.entities.Events;

import java.util.Objects;

/**
 *
 * @author Nasr
 */
public class Events {
    private int event_id ; 
    private String event_name ;
    private String event_descp ;
    private String event_img ;
    private String event_img2 ;
    private String event_img3 ;

    public Events(int event_id) {
        this.event_id = event_id;
    }

    public Events(String event_name, String event_descp, String event_img, String event_img2, String event_img3) {
        this.event_name = event_name;
        this.event_descp = event_descp;
        this.event_img = event_img;
        this.event_img2 = event_img2;
        this.event_img3 = event_img3;
    }

    public Events(int event_id, String event_name, String event_descp, String event_img, String event_img2, String event_img3) {
        this.event_id = event_id;
        this.event_name = event_name;
        this.event_descp = event_descp;
        this.event_img = event_img;
        this.event_img2 = event_img2;
        this.event_img3 = event_img3;
    }

    public int getEvent_id() {
        return event_id;
    }

    public void setEvent_id(int event_id) {
        this.event_id = event_id;
    }

    public String getEvent_name() {
        return event_name;
    }

    public void setEvent_name(String event_name) {
        this.event_name = event_name;
    }

    public String getEvent_descp() {
        return event_descp;
    }

    public void setEvent_descp(String event_descp) {
        this.event_descp = event_descp;
    }

    public String getEvent_img() {
        return event_img;
    }

    public void setEvent_img(String event_img) {
        this.event_img = event_img;
    }

    public String getEvent_img2() {
        return event_img2;
    }

    public void setEvent_img2(String event_img2) {
        this.event_img2 = event_img2;
    }

    public String getEvent_img3() {
        return event_img3;
    }

    public void setEvent_img3(String event_img3) {
        this.event_img3 = event_img3;
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
        final Events other = (Events) obj;
        if (this.event_id != other.event_id) {
            return false;
        }
        if (!Objects.equals(this.event_name, other.event_name)) {
            return false;
        }
        if (!Objects.equals(this.event_descp, other.event_descp)) {
            return false;
        }
        if (!Objects.equals(this.event_img, other.event_img)) {
            return false;
        }
        if (!Objects.equals(this.event_img2, other.event_img2)) {
            return false;
        }
        return Objects.equals(this.event_img3, other.event_img3);
    }

    @Override
    public String toString() {
        return "Events{" + "event_id=" + event_id + ", event_name=" + event_name + ", event_descp=" + event_descp + ", event_img=" + event_img + ", event_img2=" + event_img2 + ", event_img3=" + event_img3 + '}';
    }   
    
    
}
