/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classlistingapp;

/**
 *
 * @author JunAr
 */
public class Faculty {
    private int facultyNo;
    private String lastname;
    private String firstname;
    private String middlename;
    private char gender;
    private String birthdate;

    public Faculty(int facultyNo) {
        this.facultyNo = facultyNo;
    }
    
    
    public int getFacultyNo() {
        return facultyNo;
    }

    public void setFacultyNo(int facultyNo) {
        this.facultyNo = facultyNo;
    }

    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }
    public char getGender() {
        return gender;
    }
    public void setGender(char gender) {
        this.gender = gender;
    }
    public String getBirthdate() {
        return birthdate;
    }
    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }
    
    //public method
   public String getProperName(){
       return lastname.toUpperCase() + ", " + firstname.toUpperCase() 
               + " " + getInitials(middlename);
   }
   
   //private method
   private String getInitials(String name){
       String initials = "";
       name = name.toUpperCase().trim();
       int space_index = name.indexOf(" ");
       while(space_index > 0){
           String word = name.substring(0, space_index);
           initials = initials + word.charAt(0) + ".";
           name = name.substring(space_index+1);
           space_index = name.indexOf(" ");
       }
       return initials + name.charAt(0) + ".";
   }
   
    
}
