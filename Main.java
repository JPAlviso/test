import java.util.Scanner;

public class Main {

    private static Main m;
    private static Scanner sc;

    // User Data
    private static boolean[] hasEmployee;
    private static int employeeAmount = 100; // The size of the array since it is not dynamic. Use Array List to make it dynamic :>
    private static String[] names, passwords, positions;
    private static double[] ratePerHour;
    private static double[] workHours;
    private static double[] netPays;
    private static int[] workDays;

    private static int currentEmployees = 0; // Registered Employees

    private static int ID = 0; // Current Employee


    public static void main(String[] args) {

        sc = new Scanner(System.in);
        m = new Main();

        hasEmployee = new boolean[employeeAmount];
        names = new String[employeeAmount];
        passwords =  new String[employeeAmount];
        positions = new String[employeeAmount];
        ratePerHour = new double[employeeAmount];
        netPays = new double[employeeAmount];
        workHours = new double[employeeAmount];
        workDays = new int[employeeAmount];

        //

        m.preloadEmployee();

        m.titleBar();
        m.mainMenu();
    }

    public void initStorage(){
        for(int i = 0; i < employeeAmount; i++){
            hasEmployee[i] = false;
        }
    }

    // Default Employees (Available Accounts)
    public void preloadEmployee() {
        m.insertEmployee("John", "12345", 1000, "CEO");
    }

    public void titleBar() {
        // Change Below for different title
        m.createHyphens(10);
        System.out.print(" PAYROLL SYSTEM ");
        m.createHyphens(10);
        System.out.println();
    }

    public void mainMenu() {

        boolean valid = false;

        while(!valid) {

            System.out.println("Main Menu");
            m.createHyphens(50);
            System.out.println();
            System.out.println("1. Login");
            System.out.println("2. Registration");
            System.out.println("3. List of all employees");
            System.out.print("Type the number of your desired option: ");

            int choice = sc.nextInt();
            sc.nextLine();
            switch(choice) {
                case 1:
                    valid = true;
                    m.loginPage();
                    break;
                case 2:
                    valid = true;
                    m.registrationPage();
                    break;
                case 3:
                    valid = true;
                    m.listOfAllEmployee();
                    break;
                default:
                    // Try Again
                    System.out.println("\nError: Invalid Input");
            }
        }
    }

    // Login Part of the Program
    public void loginPage() {
        boolean Satisfied = false;
        boolean error = false;

        while(!Satisfied) {
            if(error) {
                m.createHyphens(50);
                System.out.println("\n !!! Incorrect Credentials !!! ");
            }
            System.out.println("\nLogin");
            m.createHyphens(50);

            System.out.print("\nFull Name: ");
            String fullName = sc.nextLine();

            System.out.print("Password: ");
            String password = sc.nextLine();

            // Find the user

            for(int i = 0; i < names.length; i++) {
                if(fullName.equals(names[i])) {
                    if(password.equals(passwords[i])) {
                        Satisfied = true;
                        error = false;
                        ID = i;
                        employeePage();
                        break;
                    }
                    else {
                        error = true;
                    }
                }
                else {
                    error = true;
                }
            }
        }
    }

    // Registration Part of the Program
    public void registrationPage() {
        boolean Satisfied = false;
        boolean error = false;
        while(!Satisfied) {
            if(error) {
                m.createHyphens(50);
                System.out.println("\nError: Passwords do not match! ");
            }
            System.out.println("\nRegistration: Please enter all required credentials");
            m.createHyphens(50);

            System.out.print("\nFull Name: ");
            String fullName = sc.nextLine();

            System.out.print("Password: ");
            String password = sc.nextLine();

            System.out.print("Retype Password: ");
            String passwordAgain = sc.nextLine();

            System.out.print("Rate Per Hour: ");
            double rate = sc.nextDouble();
            sc.nextLine();

            System.out.print("Position: ");
            String position = sc.nextLine();

            if(!password.equals(passwordAgain)) {
                error = true;
            }
            else {
                error = false;
                System.out.print("\nIs everything correct? (Y/N): ");
                String ans = sc.nextLine();

                switch(ans) {
                    case "Y":
                    case "y":
                        Satisfied = true;
                        m.insertEmployee(fullName, password, rate, position);

                        System.out.println("\n!!! SUCCESSFULLY REGISTERED !!!\n");

                        m.mainMenu();
                        break;
                    default:
                        // Not Satisfied
                }
            }
        }

    }

    // If the user manage to logged in successfully
    public void employeePage() {
        boolean valid = false;

        while(!valid) {

            System.out.println();
            m.createHyphens(50);
            System.out.println("\nWelcome " + names[ID] + "!");
            m.createHyphens(50);
            System.out.println();
            System.out.println("1. Time in and Time out");
            System.out.println("2. Employee Pay");
            System.out.println("3. Employee Details");
            System.out.println("4. Log out");
            System.out.print("Type the number of your desired option: ");

            int choice = sc.nextInt();
            sc.nextLine();
            switch(choice) {
                case 1:
                    valid = true;
                    // Time in and Time Out
                    m.inOut();
                    break;
                case 2:
                    valid = true;
                    m.employeePay();
                    break;
                case 3:
                    valid = true;
                    m.employeeDetails();
                    break;
                case 4:
                    valid = true;
                    m.mainMenu();
                    break;
                default:
                    // Try Again
                    System.out.println("\nError: Invalid Input");
            }
        }
    }

    public void inOut() {
        boolean Satisfied = false;

        while(!Satisfied) {
            System.out.println("\nTime in and Time out: (USE MILITARY FORMAT HH:MM)");
            m.createHyphens(50);
            System.out.print("\nEnter time in: ");
            String timeIn = sc.nextLine(); // HH:MM
            System.out.print("Enter time out: "); // HH:MM
            String timeOut = sc.nextLine();

            if(timeIn.length() < 5) {
                timeIn = "0" + timeIn;
            }

            if(timeOut.length() < 5) {
                timeOut = "0" + timeOut;
            }

            // TODO: CALCULATE THE HOURS USING THE HOUR FORMAT GIVEN BY THE USER
            int hourIn = Integer.parseInt(timeIn.substring(0, 2));
            int minuteIn = Integer.parseInt(timeIn.substring(3));

            double inTotal = hourIn + (minuteIn / 60.0);
            // Test Code
            //System.out.println("In total: " +inTotal);

            int hourOut = Integer.parseInt(timeOut.substring(0,2));
            int minuteOut = Integer.parseInt(timeOut.substring(3));

            double outTotal = hourOut + (minuteOut / 60.0);
            // Test Code
            //System.out.println("Out total: " +outTotal);
            double total = outTotal - inTotal;

            // Check if the time is valid
            System.out.println("Number of hours: " + total + " hours.");

            System.out.print("Is everything correct? (Y/N): ");
            String ans = sc.nextLine();

            switch(ans) {
                case "Y":
                case "y":
                    Satisfied = true;

                    // Add to the total Work Hours and Work Days
                    workHours[ID] += total;
                    workDays[ID]++;

                    // Success Message
                    System.out.println("\nTime Successfully Recorded!");

                    m.employeePage();

                    break;
                default:
                    // Not Satisfied
            }

        }
    }

    public void employeePay() {
        // TODO: Weekly Pay
        m.createHyphens(50);

        if(workHours[ID] > 0) {

            double grossSalary = workHours[ID] * ratePerHour[ID];
            double deduction = grossSalary * 0.10;
            double netPay = grossSalary - deduction;

            netPays[ID] = netPay;

            System.out.println("\nEmployee Pay of " + names[ID]);
            System.out.println("Gross Salary:  " + grossSalary);
            System.out.println("Deduction:     " + deduction);
            System.out.println("Net Pay:       " + netPay);

        }
        else {
            System.out.println("\nNo work hours to calculate yet...");
        }
        System.out.print("Press Enter to exit: ");
        sc.nextLine();
        m.employeePage();
    }

    public void employeeDetails() {
        // TODO: Employee Details
        m.createHyphens(50);
        System.out.println("\nEmployee Details");
        System.out.println("Name:          " + names[ID]);
        System.out.println("Rate Per Hour: " + ratePerHour[ID]);
        System.out.println("Position:      " + positions[ID]);
        System.out.println("Total Hours:   " + workHours[ID]);
        System.out.print("Press Enter to exit: ");
        sc.nextLine();
        m.employeePage();
    }

    // Table of all employees
    public void listOfAllEmployee(){
                System.out.println("No.\tName\tPosition\tWork Hours\tRate Per Hour\tCurrent Earnings");
        for(int i = 0; i < employeeAmount; i++){
            if(hasEmployee[i]){
                System.out.println(i + "\t" + names[i] + "\t" + positions[i] + "\t\t\t" + workHours[i] + "\t\t\t" + ratePerHour[i] + "\t\t\t" + netPays[i]);

            }
        }

        System.out.print("Press Enter to exit: ");
        sc.nextLine();
        m.mainMenu();
    }

    public void insertEmployee(String name, String password, double rate, String position) {
        names[currentEmployees] = name;
        passwords[currentEmployees] = password;
        ratePerHour[currentEmployees] = rate;
        positions[currentEmployees] = position;
        hasEmployee[currentEmployees] = true;
        currentEmployees++; // Add Employee by 1
    }

    public void createHyphens(int amount) {
        // Creating hyphens for lazy people
        for(int i = 0; i < amount; i++) {
            System.out.print("-");
        }
    }

}