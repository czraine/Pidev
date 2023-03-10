/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roadrevel.entities.Events;

/**
 *
 * @author GAMING A15
 */
public class SingleEvent {
    
    private Events Event;

    private final static SingleEvent INSTANCE = new SingleEvent();
  
  private SingleEvent() {}
  
  public static SingleEvent getInstance() {
    return INSTANCE;
  }
  
  public void setEvent(Events e) {
    this.Event = e;
  }
  
  public Events getEvent() {
    return this.Event;
  }
    
    
    
    
}
