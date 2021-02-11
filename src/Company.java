public class Company {
    private Employee[] emplist;
    private int numEmployee;

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
        //find the book employee the helper method
        int employeeIndex = find(employee);

        //if the index equals -1 than the employee is not in the system and the working hours cannot be set.
        if(employeeIndex == Constants.EMPLOYEE_NOT_FOUND){
            return false;
        }
        else {
            //Check if the employee is a part time worker
            if (emplist[employeeIndex] instanceof Parttime) {
                Parttime parttime = (Parttime) emplist[employeeIndex];
                //NOTE: In the PayrollProcessing class just make a new object that stores the working hours and pass
                // that as a parameter into this method (DELETE THIS NOTE WHEN DONE).
                parttime.setWorkingHours(((Parttime) employee).getWorkingHours());
                return true;
            }
            else{
                return false;
            }
        }
    } //set working hours for a part time

    public void processPayments() { } //process payments for all employees
    public void print() { } //print earning statements for all employees
    public void printByDepartment() { } //print earning statements by department
    public void printByDate() { } //print earning statements by date hired
}
