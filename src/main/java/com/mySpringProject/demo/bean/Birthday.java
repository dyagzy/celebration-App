package com.mySpringProject.demo.bean;

//@AllArgsConstructor
public class Birthday {
  private int id;
  private String dob;
  private String name;


  public Birthday(int id, String dob, String name){
    this.id=id;
    this.name=name;
    this.dob=dob;

  }

  public String getName(){
    return name;
  }

  public String getDob(){
    return dob;
  }

  public void setName(String name){
    this.name= name;
  }
  public int getId(){
    return id;
  }
}
