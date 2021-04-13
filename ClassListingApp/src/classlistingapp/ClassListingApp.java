//Lecture Demonstration
package classlistingapp;

import static java.lang.System.out;

public class ClassListingApp {

    public static void main(String[] args) {
       
        ClassList classList =  new ClassList();
        boolean isExit = false;
        
        do{
            out.println("CLASS LISTING APP");
            out.println("-----------------");
            out.println();
            out.println("Main Menu:");
            out.println("----------");
            out.println("[1] - Assign Faculty");
            out.println("[2] - Add Student");
            out.println("[3] - Update Student");
            out.println("[4] - Delete Student");
            out.println("[5] - Display Students");
            out.println("[6] - Display Class List");
            out.println("[7] - Exit Application");
            out.println();
            out.print(">> Enter your choice: ");
            int choice = KeyInput.getIntUserInput();
            out.println();
            switch(choice){
                case 1: 
                    out.println("Assign Faculty:");
                    out.println("---------------");
                    ClassListController.assignFaculty(classList);
                    out.println(" --New faculty is Successfully assigned.");
                    break;
                
                case 2:
                    out.println("Add Student:");
                    out.println("------------");
                    if(ClassListController.addStudent(classList)){
                        out.println(" --New student is successfully added.");
                    }
                    break;
                
                case 3: 
                    out.println("Update Student Info:");
                    out.println("--------------------");
                    if(ClassListController.updateStudent(classList)){
                        out.println(" --Student info is successfully updated");
                    }
                    break;
                
                case 4: 
                    out.println("Delete Student:");
                    out.println("---------------");
                    if(ClassListController.deleteStudent(classList)){
                        out.println(" --Student info is successfully deleted");
                    }
                    break;
                        
                case 5:        
                    out.println("Display Students:");
                    out.println("----------------");
                    ClassListController.displayStudents(classList);
                    break;
                    
                case 6:
                    out.println("Display ClassList:");
                    out.println("------------------");
                    ClassListController.displayClassList(classList);
                    break;
                        
                case 7:
                        isExit = true; break;
                
                default:
                        out.println("INPUT ERROR: Invalid Choice");
            }
            
            if(isExit){
                out.println("Thank you for using the application");
                break;
            }
            out.println();
            out.print("Enter any key to display the menu: ");
            KeyInput.getCharUserInput();
            out.println();
        }while(true);
    }
    
}


