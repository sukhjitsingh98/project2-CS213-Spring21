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
        if (profile.equals(obj)){
            return true;
        }
        return false;
    }

}
