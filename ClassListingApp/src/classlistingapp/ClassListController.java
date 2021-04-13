
package classlistingapp;
import static java.lang.System.out;
import java.util.Arrays;
public class ClassListController {
    
    public static void assignFaculty(ClassList classList){
        classList.setAssignedFaculty(assignFaculty());
    }
    
    public static Faculty assignFaculty(){
        
        out.println("Enter the Faculty Information: ");
        int fid = KeyInput.getIntUserInput(" >> Enter the Faculty ID");
        Faculty faculty = new Faculty(fid);
        String name = KeyInput.getStringUserInput(" >> Enter the lastname");
        faculty.setLastname(name);
        name = KeyInput.getStringUserInput(" >> Enter the firstname");
        faculty.setFirstname(name);
        name = KeyInput.getStringUserInput(" >> Enter the middlename");
        faculty.setMiddlename(name);
        
        return faculty;
    }
    
    public static void displayFaculty(ClassList classList){
        displayFaculty(classList.getAssignedFaculty());
    }
    
    public static void displayFaculty(Faculty faculty){
        out.println("Assigned Faculty: [" + faculty.getFacultyNo() 
                    + "] " + faculty.getProperName());
    }
    
    public static boolean addStudent(ClassList classList){
        
        int studCount = classList.getStudentCount();
        if (studCount == ClassList.MAX_COUNT){
            out.println(" --Unable to add new student");
            return false;
        } 
        
        Student students[] = classList.getStudents();
        out.println("Enter the Student Information: ");
        String sid = KeyInput.getStringUserInput(" >> Enter the Student No");
        students[studCount] = new Student(sid);
        String name = KeyInput.getStringUserInput(" >> Enter the Lastname");
        students[studCount].setLastname(name);
        name = KeyInput.getStringUserInput(" >> Enter the Firstname");
        students[studCount].setFirstname(name);
        name = KeyInput.getStringUserInput(" >> Enter the Middlename");
        students[studCount].setMiddlename(name);
        char gender = KeyInput.getCharUserInput(" >>Enter the Gender");
        students[studCount].setGender(gender);
        classList.setStudentCount(studCount + 1);
        return true;
    }
    
    public static boolean updateStudent(ClassList classList){
        out.print(" >> Enter the student no: ");
        String studNo = KeyInput.getStringUserInput();
        
        int index = searchStudent(classList, studNo);
        if(index<0){
            out.println(" --The Student does not exists in the list.");
            return false;
        }
        Student s = classList.getStudents()[index];
        return modifyStudentField(s);
    }
    
    public static boolean modifyStudentField(Student s){
        boolean isModified = false;
        do{
            displayStudentDetails(s);
            out.print(" >> Enter the field no. to edit (0 - Exit): ");
            int ch = KeyInput.getIntUserInput();

            String[] field = {"Student No.", "Lastname", "Firstname", 
                                "Middlename", "Gender", "Birthdate"};

            if(ch >= 1 && ch <= 4 || ch == 6){
                out.print(" >> Enter the new " + field[ch-1]+": ");
                String input = KeyInput.getStringUserInput(); 
                switch(ch){
                    case 1: s.setStudentNo(input); break;
                    case 2: s.setLastname(input);break;
                    case 3: s.setFirstname(input);break;
                    case 4: s.setMiddlename(input);break;
                    case 6: s.setBirtdate(input);break;
                }
                isModified = true;
                out.println(" --" + field[ch-1] + " is succesfully modified");
            }
            else if(ch == 5){
                out.print("Enter the new " + field[ch-1] + ": ");
                char input = KeyInput.getCharUserInput();
                s.setGender(input);
                isModified = true;
                out.println(" --" + field[ch-1] + " is succesfully modified");
            }
            else if (ch == 0) break;
            else{
                out.println("ERROR: Invalid Choice");
            }
    
        }while(true);
        return isModified;
    }
    
    public static void displayStudentDetails(Student s){
        out.println("Student Details:");
        out.println(" [1] StudentNo : " +  s.getStudentNo());
        out.println(" [2] Lastname  : " +  s.getLastname());
        out.println(" [3] Firstname : " +  s.getFirstname());
        out.println(" [4] Middlename: " +  s.getMiddlename());
        out.println(" [5] Gender    : " +  s.getGender());
        out.println(" [6] Birthdate : " +  s.getBirtdate());
    }
    
    public static int searchStudent(ClassList classList, String studentNo){
        
        Student[] students = Arrays.copyOfRange(classList.getStudents(),
                                0 ,classList.getStudentCount());
        for(int i = 0; i<students.length; i++){
            if(students[i].getStudentNo().equals(studentNo))
                return i;
        }
        return -1;
    }
    
    public static boolean deleteStudent(ClassList classList){
        out.print(" >> Enter the student no: ");
        String studNo = KeyInput.getStringUserInput();
        
        int index = searchStudent(classList, studNo);
        if(index<0){
            out.println(" --The Student does not exists in the list.");
            return false;
        }
        Student s = classList.getStudents()[index];
        displayStudentDetails(s);
        out.print(" >> Delete student (Enter \'Y\' to delete)? ");
        char yes = KeyInput.getCharUserInput();
        if (yes == 'Y' || yes == 'y'){
            int studCount =  classList.getStudentCount();
            Student[] list = classList.getStudents();
            Student[] newList = new Student[ClassList.MAX_COUNT];
            int newListI = 0;
            
            for(int i = 0; i < studCount; i++){
                if (i == index) continue;
                
                newList[newListI] = list[i];
                newListI++;
            }
            
            classList.setStudents(newList);
            classList.setStudentCount(studCount-1);
            return true;
        }
        return false;
    }
    
    public static void displayStudents(ClassList classList){
        
        Student[] students = Arrays.copyOf(classList.getStudents(),
                                classList.getStudentCount());
        displayStudents(students);
    }
    
    public static void displayClassList(ClassList classList){
        
        Student[] students = Arrays.copyOf(classList.getStudents(),
                                classList.getStudentCount());
        sortStudents(students);
        displayStudents(students);
        out.println();
        Faculty f = classList.getAssignedFaculty();
        out.println("Faculty-in-Charge: " + f.getProperName() 
                       + "["+f.getFacultyNo()+"]" );
        
    }
    private static void displayStudents(final Student[] students){
        //-----------12345678901234567890123456789012345678901234567890
        out.println("+----------+------------------------------+--------+");
        out.println("| Student# | Name                         | Gender |");
        out.println("+----------+------------------------------+--------+");
                
        
        for(Student s: students){
            out.println("| " + s.getStudentNo() + " | "  
                         + LeftFormat(s.getProperName().trim(), 28) 
                         + " |   " + s.getGender() + "   |" );
            out.println("+----------+------------------------------+--------+");
        }
    }
    private static String LeftFormat(String s, int length){
        for(int i = s.length(); i < length; i++)
            s = s + " ";
        
        return s;
    }
            
    private static void sortStudents(Student[] students){
        for(int i = 0; i < students.length; i++){
            for (int j = i+1; j < students.length; j++){

                if(students[i].compareTo(students[j])>0){
                    Student temp = students[i];
                    students[i] = students[j];
                    students[j] = temp;
                }
            }                
        }
    }
    
    private void sortStudentByName(Student[] s){
        
    }
            
}
