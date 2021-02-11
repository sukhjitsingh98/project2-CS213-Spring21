public class Employee {
    private Profile profile;

    //constructor
    Employee(String name, String department, String dateHired){
        this.profile = new Profile(name,department,dateHired);
    }

    @Override
    public String toString() {
        return profile.toString();
    }
    @Override
    public boolean equals(Object obj) {
        Employee employee = (Employee) obj;
        if (profile.equals(employee.profile)){
            return true;
        }
        return false;
    }

    public Date getDateHired(){
        return profile.getDateHired();
    }

    public String getDepartment(){
        return profile.getDepartment();
    }

}
