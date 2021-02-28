package labs.lab1;

public abstract class UnivPerson implements IName {
    private String fullName;
    protected Department department;

    UnivPerson(String fullName){
        this.fullName = fullName;
        department = null;
    }

    public String getName() {
        return fullName;
    }

    public UnivPerson setName(String name) {
        this.fullName = name;
        return this;
    }

    public Department getDepartment() {
        return department;
    }

    protected UnivPerson setDepartment(Department department) {
        return this;
    }
}
