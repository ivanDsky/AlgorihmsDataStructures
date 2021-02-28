package labs.lab1;

public class Faculty implements IName{
    private String facultyName;

    private Department[] departments;
    private int departmentLen;

    public Department getDepartment(){
        int id = University.getArrayElement("Departments of " + facultyName,"Enter id : ", departments);
        if(id == -1|| id == -2){
            if(id == -1)System.out.println("No created department in " + getName());
            return null;
        }
        return departments[id];
    }

    Faculty(String name){
        facultyName = name;
        departments = new Department[University.MAX_SIZE];
    }

    @Override
    public String getName() {
        return facultyName;
    }

    public Faculty setName(String name){
        this.facultyName = name;
        return this;
    }

    public void addDepartment(Department department){
        if(findDepartment(department) != -1){
            System.out.println("This department is in faculty");
            return;
        }
        departments[departmentLen++] = department;
        System.out.println(department.getName() + " added to " + facultyName);
    }

    public void removeDepartment(Department department) throws Exception{
        int id = findDepartment(department);
        removeDepartment(id);
    }

    public void removeDepartment(int id) throws Exception{
        if(id < 0 || id >= departmentLen){
            throw new Exception("Department isn't in " + getName());
        }
        University.getInstance().removeStudent(departments[id]);
        University.getInstance().removeTeacher(departments[id]);
        departments[id] = departments[departmentLen - 1];
        departmentLen--;
        departments[departmentLen] = null;
    }

    public void removeAllDepartments(){
        for(int i = 0;i < departmentLen; ++i){
            try{removeDepartment(i);}catch (Exception e){e.printStackTrace();}
            --i;
        }
    }

    public int findDepartment(Department department){
        for(int i = 0;i < departmentLen; ++i){
            if(departments[i].getName().equals(department.getName()))return i;
        }
        return -1;
    }
}
