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

            else if(currentToken.equals("AP")) {
                //use input.nextToken() and input.tokenCount to obtain following input from each line

            }

            else if(currentToken.equals("AF")) {

            }

            else if(currentToken.equals("AM")) {

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
