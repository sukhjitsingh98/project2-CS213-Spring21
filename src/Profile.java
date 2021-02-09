public class Profile {
    private String name; //employee’s name in the form “lastname,firstname”
    private String department; //department code: CS, ECE, IT
    private Date dateHired;
    @Override
    public String toString() {
        return "";
    }
    @Override
    public boolean equals(Object obj) {
        return false;
    } //compare name, department and dateHired
}
