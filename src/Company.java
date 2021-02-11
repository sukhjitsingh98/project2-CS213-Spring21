public class Company {
    private Employee[] emplist;
    private int numEmployee;

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
    private void grow() {
        Employee[] newArray = new Employee[emplist.length + Constants.INCREASE_ARRAY_BY];
        //copy the current employees.
        for(int i = 0; i < numEmployee; i++) {
            newArray[i] = emplist[i];
        }
        //reassign emplist so that it refers to newArray.
        emplist = newArray;
    }

    public boolean add(Employee employee) {
        return false;
    } //check the profile before adding
    public boolean remove(Employee employee) {
        return false;
    } //maintain the original sequence
    public boolean setHours(Employee employee) {
        if (employee.isParttime()){
            //A bit confused on how to set the hours rn
            return true;
        }
        return false;
    } //set working hours for a part time
    public void processPayments() { } //process payments for all employees
    public void print() { } //print earning statements for all employees
    public void printByDepartment() { } //print earning statements by department
    public void printByDate() { } //print earning statements by date hired
}
