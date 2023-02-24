/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package roadrevel.entities;

import roadrevel.entities.PlaceToVisit.PlaceToVisit;
import roadrevel.entities.User.User;

/**
 *
 * @author Nasr
 */

public final class SinglePlace {
      private PlaceToVisit place;
  private final static SinglePlace INSTANCE = new SinglePlace();
  
  private SinglePlace() {}
  
  public static SinglePlace getInstance() {
    return INSTANCE;
  }
  
  public void setPlace(PlaceToVisit p) {
    this.place = p;
  }
  
  public PlaceToVisit getPlace() {
    return this.place;
  }
    
}
