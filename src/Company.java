public class Company {
    private Employee[] emplist;
    private int numEmployee;

    Company() {
        emplist = new Employee[Constants.STARTING_ARRAY_SIZE];
        numEmployee = 0;
    }

    /**
     Finds the index of the given employee within the employee array.
     If the given employee is not in the array then return a negative one.
     @param employee The employee object which is being searched for
     @return the index location of the given employee object, -1 if the employee was not found in the array
     */
    private int find(Employee employee) {
        //Iterate through the employee list and compare the employees until they match.
        for(int i = 0; i < numEmployee; i++) {
            if(employee.equals(emplist[i])){
                return i;
            }
        }

        //if its not found, return -1.
        return Constants.EMPLOYEE_NOT_FOUND;
    }

    /**
     Increases the size of the employee array by four indexes.
     The employee objects are copied into a new array and the employee array gets reassigned.
     */
    private void grow() {
        Employee[] newArray = new Employee[emplist.length + Constants.INCREASE_ARRAY_BY];
        //copy the current employees.
        for(int i = 0; i < numEmployee; i++) {
            newArray[i] = emplist[i];
        }
        //reassign emplist so that it refers to newArray.
        emplist = newArray;
    }

    /**
     Add the given employee into the employee array.
     Use the find() method to check if the employee is inside the employee array.
     If the employee array is full, then increase the size with the grow() method.
     @param employee the book which is being added to the bag
     @return true if the employee was added, false otherwise
     */
    public boolean add(Employee employee) {
        //Check profile and see if the given employee already exists in the system
        if(find(employee) != Constants.EMPLOYEE_NOT_FOUND){
            //If a match is found, the given employee cannot be added to the system
            return false;
        }
        else {
            //Grow the array if no empty index remains
            if (emplist[emplist.length - 1] != null) {
                grow();
            }
            //Add new employee to the first empty index available
            for (int i = 0; i < emplist.length; i++) {
                if (emplist[i] == null) {
                    emplist[i] = employee;
                    break;
                }
            }
            numEmployee++;
            return true;
        }
    } //check the profile before adding

    /**
     Remove the given employee from the employee array.
     Use the find() method to check if the employee is inside the employee array.
     @param employee The employee that is being removed from the bag
     @return true if the employee was removed, false otherwise
     */
    public boolean remove(Employee employee) {
        //find the employee the helper method
        int employeeIndex = find(employee);

        //if the index equals -1 than the employee is not in the system and cannot be removed.
        if(employeeIndex == Constants.EMPLOYEE_NOT_FOUND) {
            return false;
        }
        //set the employee at the given index as null to remove it.
        emplist[employeeIndex] = null;
        //shift the elements to the right of it by one.
        for(int i = employeeIndex+1; i < emplist.length; i++) {
            //will trail i by one that way the previous index can be replaced. Since i can never be zero there is no out of bound issue.
            int previousIndex = i - 1;
            emplist[previousIndex] = emplist[i]; //make the swap of elements
        }
        //reduce the count by one as an employee was successfully just removed.
        numEmployee--;
        return true;
    } //maintain the original sequence

    public boolean setHours(Employee employee) {
        //find the employee index with the helper method
        int employeeIndex = find(employee);

        //if the index equals -1 than the employee is not in the system and the working hours cannot be set.
        if(employeeIndex == Constants.EMPLOYEE_NOT_FOUND){
            return false;
        }
        else {
            Parttime parttime = (Parttime) emplist[employeeIndex];
            //NOTE: In the PayrollProcessing class just make a new object that stores the working hours and pass
            // that as a parameter into this method (DELETE THIS NOTE WHEN DONE).
            parttime.setWorkingHours(((Parttime) employee).getWorkingHours());
            return true;
        }
    } //set working hours for a part time

    public void processPayments() { } //process payments for all employees

    //print earning statements for all employees
    public void print() {
        for(int i = 0; i < numEmployee; i++){
            System.out.println(emplist[i].toString());
        }
    }


    /**
     Sort the bag from smallest serial number to largest.
     */
    private void sortEmployeeDepartment(){
        for (int i = 1; i < emplist.length; i++) {
            Employee[] tempList = new Employee[1];
            tempList[0] = emplist[i];
            int j = i - 1;
            while(j >= 0 && emplist[j] != null && tempList[0] != null &&
                    emplist[j].getDepartment().compareTo(tempList[0].getDepartment()) > 0) {
                emplist[j + 1] = emplist[j];
                j = j - 1;
            }
            emplist[j + 1] = tempList[0];
        }
    }

    //print earning statements by department
    //CS, ECE, IT, alphabetical order.
    public void printByDepartment() {
        if(numEmployee > 1) {
            //first sort the employees by department
            sortEmployeeDepartment();
        }
        //call the print statement
        print();
    }

    private boolean compareDateHired(Employee employee1, Employee employee2){
        //If employee1 year is greater than employee2 year, return true
        if(employee1.getDateHired().getYear() > employee2.getDateHired().getYear()){
            return true;
        }
        else if(employee1.getDateHired().getYear() == employee2.getDateHired().getYear()){
            //If same year and employee1 month is greater than employee2 month, return true
            if(employee1.getDateHired().getMonth() > employee2.getDateHired().getMonth()){
                return true;
            }
            else if(employee1.getDateHired().getMonth() == employee2.getDateHired().getMonth()){
                //If same year and month and employee1 day is greater than employee2 hired day, return true
                if(employee1.getDateHired().getDay()>employee2.getDateHired().getDay()){
                    return true;
                }
                return false;
            }
            return false;
        }
        //Otherwise employee2 has the greater hired date
        return false;
    }

    /**
     Sort the bag of employees from oldest to most recent.
     */
    private void sortEmployeeHiredDateAscending(){
        for (int i = 1; i < emplist.length; i++) {
            Employee[] tempList = new Employee[1];
            tempList[0] = emplist[i];
            int j = i - 1;
            while(j >= 0 && emplist[j] != null && tempList[0] != null && compareDateHired(emplist[j],tempList[0]) == true) {
                emplist[j + 1] = emplist[j];
                j = j - 1;
            }
            emplist[j + 1] = tempList[0];
        }
    }

    /**
     Print the bag of employees from oldest to newest.
     call the sort by date method to sort and then the print method to print.
     */
    public void printByDate() {  //print earning statements by date hired
        if (numEmployee > 1) {
            //call the sorting method
            sortEmployeeHiredDateAscending();
        }
        //call the print method once sorted.
        print();
    }


}
