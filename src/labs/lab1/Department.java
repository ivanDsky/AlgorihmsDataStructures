package labs.lab1;

public class Department implements IName{
    private String departmentName;
    private Faculty faculty;

    Department(String departmentName,Faculty faculty){
        this.departmentName = departmentName;
        this.faculty = faculty;
    }

    @Override
    public String getName() {
        return departmentName;
    }

    public Department setName(String name){
        this.departmentName = name;
        return this;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public boolean equals(Department department) {
        return getName().equals(department.getName());
    }

    public boolean less(Department department) {
        return getName().compareToIgnoreCase(department.getName()) < 0;
    }
}
