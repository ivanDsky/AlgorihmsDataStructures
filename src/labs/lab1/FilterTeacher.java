package labs.lab1;

public class FilterTeacher {
    public static Teacher[] getByLength(Teacher[] teachers,int length){
        length = Math.min(length, teachers.length);
        Teacher[] newTeachers = new Teacher[length];
        for(int i = 0;i < length; ++i){
            if(teachers[i] == null)break;
            newTeachers[i] = teachers[i];
        }
        return newTeachers;
    }

    public static Teacher[] getByDepartment(Teacher[] teachers,Department department) {
        Teacher[] newTeachers = new Teacher[teachers.length];
        int len = 0;
        for (int i = 0; i < teachers.length; ++i) {
            if(teachers[i] == null)break;
            if (teachers[i].getDepartment().equals(department)) newTeachers[len++] = teachers[i];
        }
        return getByLength(newTeachers, len);
    }

    public static Teacher[] getByFaculty(Teacher[] teachers,Faculty faculty){
        Teacher[] newTeachers = new Teacher[teachers.length];
        int len = 0;
        for (int i = 0; i < teachers.length; ++i) {
            if(teachers[i] == null)break;
            if(teachers[i].getDepartment().getFaculty().equals(faculty))newTeachers[len++] = teachers[i];
        }
        return getByLength(newTeachers,len);
    }
}
