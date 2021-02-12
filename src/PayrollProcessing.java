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
        int increment = 0;

        Scanner sc = new Scanner(System.in);
        //continuously loop and scan until the session is ended by the input of "Q".
        while(sc.hasNext()){

            StringTokenizer input = new StringTokenizer(sc.nextLine());
            String currentToken = input.nextToken();

            if(currentToken.equals("Q")) {
                break;
            }

            //use input.nextToken() and input.tokenCount to obtain following input from each line

            else if(currentToken.equals("AP") &&  input.countTokens() == 4|| currentToken.equals("AF") && input.countTokens() > 4 || currentToken.equals("AM") && input.countTokens() == 5) {
                String name = input.nextToken();
                String department = input.nextToken();
                String date = input.nextToken();

                //check the date format
                if(new Date(date).isValid()) {
                    //now add the specific token
                    if(currentToken.equals("AP")){
                        Parttime parttime = new Parttime(name, department, date, input.nextToken(), "0");
                        //add it and check the return value
                        if(company.add(parttime)) {
                            System.out.println("Employee added.");
                        }
                        else{
                            System.out.println("Employee is already in the list.");
                        }
                    }

                    else if(currentToken.equals("AF")) {
                        Fulltime fulltime = new Fulltime(name, department, date, input.nextToken());
                        if(company.add(fulltime)) {
                            System.out.println("Employee added.");
                        }
                        else{
                            System.out.println("Employee is already in the list.");
                        }
                    }

                    else if(currentToken.equals("AM")) {
                        String salary = input.nextToken();
                        Management management = new Management(name, department, date, salary, input.nextToken());
                        if(company.add(management)) {
                            System.out.println("Employee added.");
                        }
                        else{
                            System.out.println("Employee is already in the list.");
                        }
                    }
                }

                else{
                    System.out.println(date + " is not a valid date!");
                }
            }


            else if(currentToken.equals("R")) {

            }

            else if(currentToken.equals("C")) {

            }

            else if(currentToken.equals("S")) {

            }

            else if(currentToken.equals("PA")) {

            }

            else if(currentToken.equals("PH")) {

            }

            else if(currentToken.equals("PD")) {

            }

        }
        System.out.println("Payroll Processing completed.");
    }
}
