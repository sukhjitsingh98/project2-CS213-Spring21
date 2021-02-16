/**
 This class defines the abstract data type Profile, which encapsulates the data fields and methods of an employee's
 profile.
 Contains getters and setters for the profile fields.
 @author German Munguia, Sukhjit Singh
 */

public class Profile {
    private String name; //employee’s name in the form “lastname,firstname”
    private String department; //department code: CS, ECE, IT
    private Date dateHired;

    /**
     Returns a String with the profile fields in a specified format.
     @return String with the employee's name, department, and dateHired fields
     */
    @Override
    public String toString() {
        String result = name + "::" + department + "::" + dateHired.getMonth() + "/" + dateHired.getDay() + "/" + dateHired.getYear() + "::";

        return result;
    }

    /**
     Compares the given profile object with this profile based on its name, department, and dateHired.
     @param obj the given profile who's data members will be compared
     @return true if the name, department, and dateHired of both profiles are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {  //compare name, department and dateHired
        //explicit casting
        Profile temp = (Profile) obj;
        if(name.equals(temp.name) &&  department.equals(temp.getDepartment()) && dateHired.compareTo(temp.getDateHired()) == 0){
            return true;
        }

        return false;
    }

    /**
     Constructor used to generate a Profile object using the given parameters.
     @param name of the employee.
     @param department the employee works in.
     @param dateHired the starting date of the employee.
     */
    Profile(String name, String department, String dateHired){
        this.name = name;
        this.department = department;
        this.dateHired = new Date(dateHired);
    }

    /**
     Method which returns the String representing the employee's name.
     @return name of the employee
     */
    public String getName() {
        return name;
    }

    /**
     Method which returns the String representing the department the employee works in.
     @return department the employee works in
     */
    public String getDepartment() {
        return department;
    }

    /**
     Method which returns the String representing the date the employee was hired.
     @return dateHired the date the employee was hired
     */
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


        Parttime t1 = new Parttime("lastname, firstname", "ECE", "1/01/2020","22","0");
        Employee emp1 = t1;

        Fulltime t2 = new Fulltime("Washington, George", "CS", "02/02/2005", "90000");
        Employee emp2 = t2;

        Fulltime t4 = new Fulltime("dodo, name", "IT", "02/02/2001", "10");
        Employee emp4 = t4;

        Management  t3 = new Management("Jefferson, Thomas", "ECE", "03/22/2020","50000","1");
        Employee emp3 = t3;
        System.out.println("Employee three: " + emp3.toString());

        Company company = new Company();
        company.add(emp4);
        company.add(emp1);
        company.add(emp2);
        company.add(emp3);
        System.out.println("Normal Print:");
        company.print();
        System.out.println("Date print:");
        company.printByDate();
        System.out.println("Department Print:");
        company.printByDepartment();

        company.setHours(new Parttime("lastname, firstname", "ECE", "1/01/2020","0","40"));
        System.out.println("");
        company.processPayments();
        company.print();

        company.remove(new Parttime("lastname, firstname", "ECE", "1/01/2020","0","0"));
        System.out.println("");
        company.print();
    }

}

