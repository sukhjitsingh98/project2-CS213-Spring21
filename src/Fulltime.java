public class Fulltime extends Employee {

    private float annualSalary;

    public Fulltime(String name, String department, String dateHired, String annualSalary, boolean management){
        super(name, department, dateHired, true, false, management);
        this.annualSalary = Float.parseFloat(annualSalary);
    }

    @Override
    public String toString() {
        String result =
                "Payment " + "insert payment here" + "::FULL TIME::Annual Salary " + Float.toString(annualSalary);
        return super.toString() + result;
    }
    @Override
    public boolean equals(Object obj) {
        //If the employee profile is the same check if the Fulltime data members are equal
        if(super.equals(obj)){
            if (obj instanceof Fulltime){
                Fulltime fulltime = (Fulltime) obj;
                if (fulltime.getAnnualSalary() == annualSalary){
                    return true;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    /*
    //Maybe create a private int and compute payment and return the value of that int in a get method?
    @Override
    public void calculatePayment() {
    }
    */

    public float getAnnualSalary() {
        return annualSalary;
    }

}
