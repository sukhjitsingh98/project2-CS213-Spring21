public class Fulltime extends Employee {

    private int annualSalary;

    public Fulltime(String name, String department, String dateHired, String annualSalary, boolean management){
        super(name, department, dateHired, true, false, management);
        this.annualSalary = Integer.parseInt(annualSalary);
    }

    @Override
    public String toString() {
        return "";
    }
    @Override
    public boolean equals(Object obj) {
        return false;
    }

    //Maybe create a private int and compute payment and return the value of that int in a get method?
    @Override
    public void calculatePayment() {
        String a ="";
    }

    public int getAnnualSalary() {
        return annualSalary;
    }

}
