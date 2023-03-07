/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package roadrevel.entities.user;

import roadrevel.entities.user.User;

/**
 *
 * @author Nasr
 */
public class SingleUser {
          private User user;
  private final static SingleUser INSTANCE = new SingleUser();
  
  private SingleUser() {}
  
  public static SingleUser getInstance() {
    return INSTANCE;
  }
  
  public void setUser(User p) {
    this.user = p;
  }
  
  public User getUser() {
    return this.user;
  }
}
