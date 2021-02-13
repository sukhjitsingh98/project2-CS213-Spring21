/**
 PayrollProcessing class creates an interface in which the user can interact with the Employee profiles.
 User interacts through inputs using a scanner.
 @author German Munguia, Sukhjit Singh
 */

import java.util.Scanner;
import java.util.StringTokenizer;

public class PayrollProcessing {
    public void run() {
        //Create the library which contains the array bag of book type.
        Company company = new Company();
        System.out.println("Running...");

        Scanner sc = new Scanner(System.in);
        //continuously loop and scan until the session is ended by the input of "Q".
        while(sc.hasNext()){

            StringTokenizer input = new StringTokenizer(sc.nextLine());
            String currentToken = input.nextToken();

            if(currentToken.equals("Q")) {
                break;
            }

            //if an employee is begin added
            else if(currentToken.equals("AP") &&  input.countTokens() == 4|| currentToken.equals("AF") && input.countTokens() > 4 || currentToken.equals("AM") && input.countTokens() == 5) {
                //Employee info.
                String name = input.nextToken();
                String department = input.nextToken();
                String date = input.nextToken();

                //Check for department validity
                if(department.equals("IT") ||department.equals("ECE")||department.equals("CS")) {
                    //check the date format
                    if (new Date(date).isValid()) {
                        //now add the specific token if the pay rate/salary is valid
                        String payment = input.nextToken();
                        if (Double.parseDouble(payment) < 0) {
                            //Part time has a different message than full time.
                            if (currentToken.equals("AP")) {
                                System.out.println("Pay rate cannot be negative.");
                            } else {
                                System.out.println("Salary cannot be negative.");
                            }
                            continue;
                        }

                        if (currentToken.equals("AP")) {
                            Parttime parttime = new Parttime(name, department, date, payment, "0");
                            //add it and check the return value
                            if (company.add(parttime)) {
                                System.out.println("Employee added.");
                            } else {
                                System.out.println("Employee is already in the list.");
                            }
                        }
                        else if (currentToken.equals("AF")) {
                            Fulltime fulltime = new Fulltime(name, department, date, payment);
                            if (company.add(fulltime)) {
                                System.out.println("Employee added.");
                            } else {
                                System.out.println("Employee is already in the list.");
                            }
                        }
                        else {
                            String managementCode = input.nextToken();
                            //Check for a valid code
                            if (Integer.parseInt(managementCode) < 1 || Integer.parseInt(managementCode) > 3) {
                                System.out.println("invalid management code.");
                                continue;
                            }
                            Management management = new Management(name, department, date, payment, managementCode);
                            if (company.add(management)) {
                                System.out.println("Employee added.");
                            } else {
                                System.out.println("Employee is already in the list.");
                            }
                        }
                    }
                    else{
                        System.out.println(date + " is not a valid date!");
                    }
                }
                else{
                    System.out.println("'" + department + "' is not a valid department code.");
                }

            }

            //remove the given employee
            else if(currentToken.equals("R") && input.countTokens() == 3) {
                //Employee info.
                String name = input.nextToken();
                String department = input.nextToken();
                String date = input.nextToken();

                //if the date is correctly formatted attempt to remove the employee.
                if(new Date(date).isValid()) {
                    if(company.remove(new Employee(name, department, date))) {
                        System.out.println("Employee Removed.");
                    }
                    else{
                        System.out.println("Employee does not exist.");
                    }
                }
                else{
                    System.out.println(date + " is not a valid date!");
                }

            }

            else if(currentToken.equals("C")) {
                if(company.getNumEmployee() == 0){
                    System.out.println("Employee database is empty.");
                }
                else {
                    company.processPayments();
                    System.out.println("Calculation of employee payments is done.");
                }
            }

            else if(currentToken.equals("S") && input.countTokens() == 4) {
                //Employee info.
                String name = input.nextToken();
                String department = input.nextToken();
                String date = input.nextToken();
                String workingHours = input.nextToken();

                if(new Date(date).isValid()) {
                    if (Integer.parseInt(workingHours) < 0){
                        System.out.println("Working hours cannot be negative.");
                    }
                    else if(company.setHours(new Parttime(name, department, date, "0", workingHours))) {
                        System.out.println("Working hours set.");
                    }
                    else{
                        System.out.println("Employee does not exist.");
                    }
                }
                else{
                    System.out.println(date + " is not a valid date!");
                }

            }

            else if(currentToken.equals("PA")) {

                if(company.getNumEmployee() == 0) {
                    System.out.println("Employee database is empty.");
                }

                else{
                    System.out.println("--Printing earning statements for all employees--");
                    company.print();
                }
            }

            else if(currentToken.equals("PH")) {

                if(company.getNumEmployee() == 0) {
                    System.out.println("Employee database is empty.");
                }
                else{
                    System.out.println("--Printing earning statements by date hired--");
                    company.printByDate();
                }
            }

            else if(currentToken.equals("PD")) {

                if(company.getNumEmployee() == 0) {
                    System.out.println("Employee database is empty.");
                }
                else{
                    System.out.println("--Printing earning statements by department--");
                    company.printByDepartment();
                }
            }

            else{
                System.out.println("Invalid command.");
            }

        }
        System.out.println("Payroll Processing completed.");
    }
}
