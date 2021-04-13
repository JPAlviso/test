/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classlistingapp;

public class Student {

    /*FIELDS*/
    private String studentNo;
    private String lastname;
    private String firstname;
    private String middlename;
    private char gender;
    private String birthdate;
    
    /*CONSTRUCTOR*/
    public Student(String studentNo, String lastname, String firstname, 
                    String middlename, char gender) {
        this.studentNo = studentNo;
        this.lastname = lastname;
        this.firstname = firstname;
        this.middlename = middlename;
        this.gender = Character.toUpperCase(gender);
        this.birthdate = "";
        
    }
    public Student(String studentNo) {
        this(studentNo, "", "", "", 'X');
    }
    public Student(String studentNo, String lastname, String firstname) {
        this(studentNo, lastname, firstname, "N/A", 'X');
    }
    public Student(String studentNo, String lastname, String firstname, 
            char gender) {
        this(studentNo, lastname, firstname, "N/A", gender);
    }
    

    /*METHODS*/
    //Getters and Setters
    public String getStudentNo() {
        return studentNo;
    }
    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
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
        this.gender = Character.toUpperCase(gender);
    }
    public String getBirtdate() {
        return birthdate;
    }
    public void setBirtdate(String birthdate) {
        this.birthdate = birthdate;
    }
    
   //public method
   public String getProperName(){
       return lastname.toUpperCase() + ", " + firstname.toUpperCase() 
               + " " + getInitials(middlename);
   }
   
   public int compareTo(Student s){
       return this.getProperName().compareTo(s.getProperName());
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
