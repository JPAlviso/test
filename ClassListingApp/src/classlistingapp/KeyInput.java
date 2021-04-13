
package classlistingapp;

import java.util.Scanner;
import static java.lang.System.in;
import static java.lang.System.out;
public class KeyInput {
    
    private static Scanner scanner;
    
    public static int getIntUserInput(String prompt){
        out.print(prompt + ": ");
        return getIntUserInput();
    }
    
    public static int getIntUserInput(){
        return new Scanner(in).nextInt();
    }
    
    public static String getStringUserInput(String prompt){
        out.print(prompt + ": ");
        return getStringUserInput();
    }
    
    public static String getStringUserInput(){
        return new Scanner(in).nextLine();
    }
    
    public static char getCharUserInput(String prompt){
        out.print(prompt + ": ");
        return getCharUserInput();
    }
    
    public static char getCharUserInput(){
        return new Scanner(in).next().charAt(0);
    }
}
