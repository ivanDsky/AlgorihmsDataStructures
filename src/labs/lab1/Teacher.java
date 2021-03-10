package labs.lab1;

public class Teacher extends UnivPerson{

    public Teacher(String fullName) {
        super(fullName);
    }

    public Teacher(String fullName,Department department){
        this(fullName);
        setDepartment(department);
    }

    public boolean equals(Teacher s) {
        return getName().equals(s.getName());
    }

    @Override
    protected Teacher setDepartment(Department department) {
        this.department = department;
        return this;
    }

    @Override
    public String toString() {
        return "This is teacher " + getName() + ". Department : " + getDepartment().getName() + ".";
    }
}
