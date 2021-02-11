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
    public boolean equals(Object obj) {  //compare name, department and dateHired
        //explicit casting
        Profile temp = (Profile) obj;
        if(name.equals(temp.name) &&  department.equals(temp.getDepartment()) && dateHired.compareTo(temp.getDateHired()) == 0){
            return true;
        }

        return false;
    }

    //constructor
    Profile(String name, String department, String dateHired){
        this.name = name;
        this.department = department;
        this.dateHired = new Date(dateHired);
    }

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

    //temporary testing
    public static void main(String[] args) {
        Profile test1 = new Profile("Last,First", "CS", "01/22/1999");
        Profile test2 = new Profile("Obama,Barack", "ECE", "01/22/2008");
        Profile test3 = new Profile("Obama,Barack", "ECE", "01/22/2008");
        System.out.println(test2.toString());
        System.out.println(test2.equals(test1));
        System.out.println(test2.equals(test3));


        Parttime t1 = new Parttime("last, first", "ECE", "1/01/2020","22","40");
        System.out.println(t1.toString());
        Employee emp1 = t1;
        System.out.println("emp1:  " + emp1.toString());

    }

}

