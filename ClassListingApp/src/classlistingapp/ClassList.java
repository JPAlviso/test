
package classlistingapp;


public class ClassList {
    
    public static final int MAX_COUNT = 40;
    private int studentCount = 0;

    private Faculty assignedFaculty;
    private Student[] students =  new Student[MAX_COUNT];
    
    
    public int getStudentCount() {
        return studentCount;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public void setStudentCount(int studentCount) {
        this.studentCount = studentCount;
    }
  

    public Faculty getAssignedFaculty() {
        return assignedFaculty;
    }

    public void setAssignedFaculty(Faculty assignedFaculty) {
        this.assignedFaculty = assignedFaculty;
    }

    public Student[] getStudents() {
        return students;
    }

}
