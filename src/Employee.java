public class Employee {
    private Profile profile;
    //These may not be needed
    private boolean fulltime;
    private boolean parttime;
    private boolean management;

    //constructor
    Employee(String name, String department, String dateHired, boolean fulltime, boolean parttime, boolean management){
        this.profile = new Profile(name,department,dateHired);
        this.fulltime = fulltime;
        this.parttime = parttime;
        this.management = management;
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

    public boolean isFulltime() {
        return fulltime;
    }

    public boolean isParttime() {
        return parttime;
    }

    public boolean isManagement() {
        return management;
    }
}
