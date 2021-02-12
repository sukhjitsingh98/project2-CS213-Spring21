public class Management extends Fulltime {
    private int role;
    private float singlePayPeriodCompensation;
    private float annualCompensation;

    public Management(String name, String department, String dateHired, String annualSalary, String role){
        super(name, department, dateHired, annualSalary);
        this.role = Integer.parseInt(role);
        this.annualCompensation = setCompensation();
    }

    @Override
    public String toString() {
        calculatePayment();
        String result = "::" + managementRole() + " Compensation " + Float.toString(singlePayPeriodCompensation);
        return super.toString() + result;
    }

    @Override
    public boolean equals(Object obj) {
        //Check if super class is equal to the given object
        if(!super.equals(obj)) {
            return false;
        }
        //Check if the given object is a Management object
        else if (!(obj instanceof Management)) {
            return false;
        }
        //Type cast the given object and check if its data members are equal to this object's data members
        Management management = (Management) obj;
        if (management.getAnnualCompensation() == annualCompensation){
            return true;
        }
        return false;
    }

    //Maybe keep this? Maybe remove this? Might be useful?
    @Override
    public float getAnnualSalary() {
        return super.getAnnualSalary();
    }

    /*
    @Override
    */
    public void calculatePayment() {
        //super.calculatePayment();
        singlePayPeriodCompensation = annualCompensation/Constants.TOTAL_PAY_PERIODS;
    }

    private String managementRole(){
        if(role == Constants.MANAGER){
            return "Manager";
        }
        else if(role == Constants.DEPARTMENT_HEAD){
            return "Department Head";
        }
        else if(role == Constants.DIRECTOR){
            return "Director";
        }
        return null;
    }

    private float setCompensation(){
        if (managementRole().equals("Manager")){
            return Constants.MANAGER_COMPENSATION;
        }
        else if (managementRole().equals("Department Head")){
            return Constants.DEPARTMENT_HEAD_COMPENSATION;
        }
        else if (managementRole().equals("Director")){
            return Constants.DIRECTOR_COMPENSATION;
        }
        return 0;

    }

    public float getAnnualCompensation(){
        return annualCompensation;
    }
}
