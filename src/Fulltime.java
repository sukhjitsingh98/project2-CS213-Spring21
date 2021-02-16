public class Fulltime extends Employee {

    private float annualSalary;
    private float singlePayPeriodSalary;

    public Fulltime(String name, String department, String dateHired, String annualSalary){
        super(name, department, dateHired);
        this.annualSalary = Float.parseFloat(annualSalary);
        singlePayPeriodSalary = 0;
    }

    @Override
    public String toString() {
        String result =
                "Payment " + String.format("%.2f", singlePayPeriodSalary) + "::FULL TIME::Annual Salary $" + Float.toString(annualSalary);
        return super.toString() + result;
    }
    @Override
    public boolean equals(Object obj) {
        //Check if super class is equal to the given object
        if(!super.equals(obj)) {
            return false;
        }
        //Check if the given object is a Fulltime object
        else if (!(obj instanceof Fulltime)) {
            return false;
        }
        /*
        //Type cast the given object and check if its data members are equal to this object's data members
        Fulltime fulltime = (Fulltime) obj;
        if (fulltime.getAnnualSalary() == annualSalary){
            return true;
        }
         */

        //return false;
        return true;
    }


    //Maybe create a private int and compute payment and return the value of that int in a get method?
    @Override
    public void calculatePayment() {
        singlePayPeriodSalary = annualSalary/Constants.TOTAL_PAY_PERIODS;
    }

    public float getSinglePayPeriodSalary(){
        return singlePayPeriodSalary;
    }

    public void addBonus(float PeriodBonus) {
        singlePayPeriodSalary += PeriodBonus;
    }

    public float getAnnualSalary() {
        return annualSalary;
    }

}
