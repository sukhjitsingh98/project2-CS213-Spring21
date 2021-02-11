public class Management extends Fulltime {
    private int role;

    public Management(String name, String department, String dateHired, String annualSalary, String role){
        super(name, department, dateHired, annualSalary, true);
        this.role = Integer.parseInt(role);
    }

    @Override
    public String toString() {
        return "";
    }
    @Override
    public boolean equals(Object obj) {
        return false;
    }

    //Maybe keep this? Maybe remove this? Might be useful?
    @Override
    public int getAnnualSalary() {
        return super.getAnnualSalary();
    }

    @Override
    public void calculatePayment() {
        super.calculatePayment();
    }

    public int getAnnualCompensation(){
        if (role == Constants.MANAGER){
            return Constants.MANAGER_COMPENSATION;
        }
        else if (role == Constants.DEPARTMENT_HEAD){
            return Constants.DEPARTMENT_HEAD_COMPENSATION;
        }
        else if (role == Constants.DIRECTOR){
            return Constants.DIRECTOR_COMPENSATION;
        }
        return 0;
    }
}
