package modals;

public class Employee {
    private int idEmployee;
    private String employeeName;
    private String departement;
    private String picture;

    public Employee(int idEmployee, String employeeName, String departement, String picture) {
        this.idEmployee = idEmployee;
        this.employeeName = employeeName;
        this.departement = departement;
        this.picture = picture;
    }

    public Employee() {
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
