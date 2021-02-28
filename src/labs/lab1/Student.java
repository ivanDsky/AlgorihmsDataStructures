package labs.lab1;

public class Student extends UnivPerson{
    private int group;
    private int course;

    public Student(String fullName) {
        super(fullName);
    }

    public Student(String fullName,Department department){
        this(fullName);
        setDepartment(department);
    }

    public Student(String fullName,Department department,int course){
        this(fullName,department);
        this.course = course;
    }

    public Student(String fullName,Department department,int course,int group){
        this(fullName,department,course);
        this.group = group;
    }

    public int getGroup() {
        return group;
    }

    public Student setGroup(int group) {
        this.group = group;
        return this;
    }

    public boolean equals(Student s) {
        return getName().equals(s.getName()) &&
                getDepartment().equals(s.getDepartment()) &&
                getCourse() == s.getGroup() &&
                getGroup() == s.getGroup();
    }

    @Override
    protected Student setDepartment(Department department) {
        this.department = department;
        return this;
    }

    @Override
    public String toString() {
        String ret = "This is student " + getName() + ".";
        if(department != null)ret += " Department : " + getDepartment().getName() + ".";
        if(group != 0)ret += " Group : " + getGroup() + ".";
        if(course != 0)ret += " Course : " + getCourse() + ".";
        return ret;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }
}
