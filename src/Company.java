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
    private void grow() { }
    public boolean add(Employee employee) {
        return false;
    } //check the profile before adding
    public boolean remove(Employee employee) {
        return false;
    } //maintain the original sequence
    public boolean setHours(Employee employee) {
        return false;
    } //set working hours for a part time
    public void processPayments() { } //process payments for all employees
    public void print() { } //print earning statements for all employees
    public void printByDepartment() { } //print earning statements by department
    public void printByDate() { } //print earning statements by date hired
}
