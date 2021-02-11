public class Management extends Fulltime {
    private int role;
    private float singlePayPeriodCompensation;
    private float annualCompensation = setCompensation();

    public Management(String name, String department, String dateHired, String annualSalary, String role){
        super(name, department, dateHired, annualSalary, true);
        this.role = Integer.parseInt(role);
    }

    @Override
    public String toString() {
        calculatePayment();
        String result = "::" + managementRole() + " Compensation " + Float.toString(singlePayPeriodCompensation);
        return super.toString() + result;
    }
    @Override
    public boolean equals(Object obj) {
        //If the super class Data members are equal check if the Management data members are equal
        if(super.equals(obj)){
            if (obj instanceof Management){
                Management management = (Management) obj;
                if (management.getAnnualCompensation() == annualCompensation){
                    return true;
                }
                return false;
            }
            return false;
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
        singlePayPeriodCompensation = getAnnualCompensation()/Constants.TOTAL_PAY_PERIODS;
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
            annualCompensation = Constants.MANAGER_COMPENSATION;
        }
        else if (managementRole().equals("Department Head")){
            annualCompensation = Constants.DEPARTMENT_HEAD_COMPENSATION;
        }
        else if (managementRole().equals("Director")){
            annualCompensation = Constants.DIRECTOR_COMPENSATION;
        }
        return 0;

    }

    public float getAnnualCompensation(){
        return annualCompensation;
    }
}
