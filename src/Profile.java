public class Profile {
    private String name; //employee’s name in the form “lastname,firstname”
    private String department; //department code: CS, ECE, IT
    private Date dateHired;
    @Override
    public String toString() {
        String result = name + "::" + department + "::" + dateHired.getMonth() + "/" + dateHired.getDay() + "/" + dateHired.getYear() + "::"; //once the earnings portion is added this will be finished

        return result;
    }
    @Override
    public boolean equals(Object obj) {
        return false;
    } //compare name, department and dateHired

    //returns the name of the employees profile
    public String getName() {
        return name;
    }

    //return the department
    public String getDepartment() {
        return department;
    }

    //returns dateHired
    public Date getDateHired() {
        return dateHired;
    }
}

