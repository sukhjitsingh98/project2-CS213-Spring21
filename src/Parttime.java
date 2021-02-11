public class Parttime extends Employee {
    private float hourlyRate;
    private float workingHours;

    public Parttime(String name, String department, String dateHired, String hourlyRate, String workingHours){
        super(name, department, dateHired);
        this.hourlyRate = Float.parseFloat(hourlyRate);
        this.workingHours = Float.parseFloat(workingHours);
    }

    @Override
    public String toString() {
        return "";
    }
    @Override
    public boolean equals(Object obj) {
        //Check if super class is equal to the given object
        if(!super.equals(obj)) {
            return false;
        }
        //Check if the given object is a Parttime object
        else if (!(obj instanceof Parttime)) {
            return false;
        }
        //Type cast the given object and check if its data members are equal to this object's data members
        Parttime parttime = (Parttime) obj;
        if (parttime.getHourlyRate() == hourlyRate && parttime.getWorkingHours() == workingHours){
            return true;
        }
        return false;

    }

    /*
    @Override
    public void calculatePayment() {
    }
    */

    //Maybe int parameter, maybe String, we shall decide when the time comes for implementation
    public void setWorkingHours(float workingHours) {
        this.workingHours = workingHours;
    }

    public float getWorkingHours(){
        return workingHours;
    }

    public float getHourlyRate(){
        return hourlyRate;
    }
}
