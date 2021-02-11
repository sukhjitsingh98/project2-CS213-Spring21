public class Parttime extends Employee {
    private float hourlyRate;
    private int workingHours;

    public Parttime(String name, String department, String dateHired, String hourlyRate){
        super(name, department, dateHired, false, true, false);
        this.hourlyRate = Float.parseFloat(hourlyRate);
        this.workingHours = 0;
    }

    @Override
    public String toString() {
        return "";
    }
    @Override
    public boolean equals(Object obj) {
        return false;
    }

    @Override
    public void calculatePayment() {
        String b ="";
    }

    //Maybe int parameter, maybe String, we shall decide when the time comes for implementation
    public void setWorkingHours(int workingHours) {
        this.workingHours = workingHours;
    }

    public int getWorkingHours(){
        return workingHours;
    }

    public float getHourlyRate(){
        return hourlyRate;
    }
}
