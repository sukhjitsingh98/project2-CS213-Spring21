public class Parttime extends Employee {

    private float hourlyRate;
    private float workingHours;
    private float singlePayPeriodSalary;

    public Parttime(String name, String department, String dateHired, String hourlyRate, String workingHours){
        super(name, department, dateHired);
        this.hourlyRate = Float.parseFloat(hourlyRate);
        this.workingHours = Float.parseFloat(workingHours);
        singlePayPeriodSalary = 0;
    }

    @Override
    public String toString() {

        String result =
                "Payment $" + String.format("%.2f", singlePayPeriodSalary) + "::PART TIME::Hourly Rate $" + getHourlyRate() + "::Hours worked this period: " +(int)getWorkingHours();

        return super.toString() + result;

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
        /*
        //Type cast the given object and check if its data members are equal to this object's data members
        Parttime parttime = (Parttime) obj;
        if (parttime.getHourlyRate() == hourlyRate && parttime.getWorkingHours() == workingHours){
            return true;
        }
        */
        //return false;
        return true;
    }


    @Override
    public void calculatePayment() {
        singlePayPeriodSalary = 0;
        float currentHours = workingHours; //currentHours is used as a temporary value in order to not modify working hours.
        //check if the employee has worked overtime and add it (80 hours)
        if(workingHours > Constants.MAXIMUM_NON_OVERTIME_HOURS_PER_PERIOD) {
            singlePayPeriodSalary += hourlyRate * Constants.OVERTIME_SALARY_MULTIPLIER * (workingHours - Constants.MAXIMUM_NON_OVERTIME_HOURS_PER_PERIOD);
            //reduce workingHours by the overtime that has now been accounted for.
            currentHours = workingHours - (workingHours - Constants.MAXIMUM_NON_OVERTIME_HOURS_PER_PERIOD);
        }
        //Non overtime compensation.
        singlePayPeriodSalary += currentHours * hourlyRate;
    }


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
