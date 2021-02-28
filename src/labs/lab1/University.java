package labs.lab1;

import utils.DataInput;

public class University implements IName {
    public final static String NAME = "Kyiv-Mohyla Academy";
    private static University singletone;

    public static University getInstance() {
        if (singletone == null) {
            singletone = new University();
            singletone.faculties = new Faculty[MAX_SIZE];
            singletone.students = new Student[MAX_SIZE];
            singletone.teachers = new Teacher[MAX_SIZE];
            return singletone;

        } else return singletone;
    }

    public static int getArrayElement(String s1, String s2, IName[] array) {
        int l = array.length;
        for (int i = 0; i < array.length; ++i) {
            if (array[i] == null) {
                l = i;
                break;
            }
            if (i == 0) System.out.println(s1);
            System.out.println((i + 1) + " - " + array[i].getName());
        }
        if (l != 0) System.out.println((l + 1) + " - back");
        if (l == 0) return -1;
        int x;
        while (true) {
            x = DataInput.getInt(s2) - 1;
            if (x < 0 || x > l) {
                System.out.println("Index isn't in [1.." + (l + 1) + "]");
                continue;
            }
            break;
        }
        if (x == l) return -2;
        return x;
    }

    public static Faculty getFaculty() {
        int id = getArrayElement("Faculties", "Enter id : ", getInstance().faculties);
        if (id == -1 || id == -2) {
            if (id == -1) System.out.println("No created faculties in " + NAME);
            return null;
        }
        return University.getInstance().faculties[id];
    }

    public static Student getStudent(Department dep) {
        Student[] students = FilterStudent.getByDepartment(getInstance().students, dep);
        int id = getArrayElement("Students", "Enter id : ", students);
        if (id == -1 || id == -2) {
            if (id == -1) System.out.println("No students in " + dep.getName());
            return null;
        }
        return students[id];
    }

    public static Teacher getTeacher(Department dep) {
        Teacher[] teachers = FilterTeacher.getByDepartment(getInstance().teachers, dep);
        int id = getArrayElement("Teachers", "Enter id : ", teachers);
        if (id == -1 || id == -2) {
            if (id == -1) System.out.println("No teachers in " + dep.getName());
            return null;
        }
        return teachers[id];
    }

    public static int getCourse() {
        return DataInput.getIntInRange("Enter course : ", 1, 6);
    }

    public final static int MAX_SIZE = 500;

    private Faculty[] faculties;
    private int facultyLen;
    private Student[] students;
    private int studentLen;
    private Teacher[] teachers;
    private int teacherLen;


    @Override
    public String getName() {
        return NAME;
    }

    public void addFaculty(Faculty faculty) {
        if (findFaculty(faculty) != -1) {
            System.out.println("This faculty is in university");
            return;
        }
        faculties[facultyLen++] = faculty;
        System.out.println(faculty.getName() + " added to " + NAME);
    }

    public void removeFaculty(Faculty faculty) throws Exception {
        int id = findFaculty(faculty);
        removeFaculty(id);
    }

    public void removeFaculty(int id) throws Exception {
        if (id < 0 || id >= facultyLen) {
            throw new Exception("Faculty isn't in " + getName());
        }
        faculties[id].removeAllDepartments();
        faculties[id] = faculties[facultyLen - 1];
        facultyLen--;
        faculties[facultyLen] = null;
    }

    public int findFaculty(Faculty faculty) {
        for (int i = 0; i < facultyLen; ++i) {
            if (faculties[i].getName().equals(faculty.getName())) return i;
        }
        return -1;
    }

    public void addStudent(Student student, Department department) {
        if (findStudent(student) != -1) {
            System.out.println("This student is in university");
            return;
        }
        student.setDepartment(department);
        students[studentLen++] = student;
        System.out.println(student.getName() + " added to " + NAME);
    }

    public void removeStudent(Student student) throws Exception {
        int id = findStudent(student);
        removeStudent(id);
    }

    public void removeStudent(int id) throws Exception {
        if (id < 0 || id >= studentLen) {
            throw new Exception("Student isn't in " + getName());
        }
        students[id] = students[studentLen - 1];
        studentLen--;
        students[studentLen] = null;
    }

    public void removeStudent(Department department) {
        for (int i = 0; i < studentLen; ++i) {
            if (students[i].getDepartment().equals(department)) {
                try {
                    removeStudent(i);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                --i;
            }
        }
    }

    public int findStudent(Student student) {
        for (int i = 0; i < studentLen; ++i) {
            if (student.equals(students[i])) return i;
        }
        return -1;
    }

    public void printStudentByCourse(String name, int course) {
        String ct = "";
        for (int i = 0; i < studentLen; ++i) {
            if (students[i].getName().equals(name) && students[i].getCourse() == course) {
                ct += "   " + students[i] + "\n";
            }
        }
        if (ct.equals("")) {
            System.out.println("No students with this name and course");
        } else {
            System.out.println("Results\n" + ct);
        }
    }

    public void printStudentByGroup(String name, int group) {
        String ct = "";
        for (int i = 0; i < studentLen; ++i) {
            if (students[i].getName().equals(name) && students[i].getGroup() == group) {
                ct += "   " + students[i] + "\n";
            }
        }
        if (ct.equals("")) {
            System.out.println("No students with this name and group");
        } else {
            System.out.println("Results\n" + ct);
        }
    }

    public void printTeacherByName(String name) {
        String ct = "";
        for (int i = 0; i < teacherLen; ++i) {
            if (teachers[i].getName().equals(name)) {
                ct += "   " + teachers[i] + "\n";
            }
        }
        if (ct.equals("")) {
            System.out.println("No teachers with this name");
        } else {
            System.out.println("Results\n" + ct);
        }
    }

    public void addTeacher(Teacher teacher, Department department) {
        if (findTeacher(teacher) != -1) {
            System.out.println("This teacher is in university");
            return;
        }
        teacher.setDepartment(department);
        teachers[teacherLen++] = teacher;
        System.out.println(teacher.getName() + " added to " + NAME);
    }

    public void removeTeacher(Teacher teacher) throws Exception {
        int id = findTeacher(teacher);
        removeTeacher(id);
    }

    public void removeTeacher(int id) throws Exception {
        if (id < 0 || id >= teacherLen) {
            throw new Exception("Teacher isn't in " + getName());
        }
        teachers[id] = teachers[teacherLen - 1];
        teacherLen--;
        teachers[teacherLen] = null;
    }

    public void removeTeacher(Department department) {
        for (int i = 0; i < teacherLen; ++i) {
            if (teachers[i].getDepartment().equals(department)) {
                try {
                    removeTeacher(i);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                --i;
            }
        }
    }

    public int findTeacher(Teacher teacher) {
        for (int i = 0; i < teacherLen; ++i) {
            if (teacher.equals(teachers[i])) return i;
        }
        return -1;
    }

    public void printStudents(Student[] students) {
        if (students.length == 0) {
            System.out.println("No students");
            return;
        }
        System.out.println("Students of " + getName());
        for (Student student : students) {
            System.out.println("   " + student);
        }
    }

    public void printTeachers(Teacher[] teachers) {
        if (teachers.length == 0) {
            System.out.println("No teachers");
            return;
        }
        System.out.println("Teachers of " + getName());
        for (Teacher teacher : teachers) {
            System.out.println("   " + teacher);
        }
    }

    public void printStudents(SortStudentsBy sort) {
        Student[] newStudents = FilterStudent.getByLength(students, studentLen);
        if (sort == SortStudentsBy.BY_COURSE) {
            SortStudent.sortByCourse(newStudents);
        }
        printStudents(newStudents);
    }

    public void printStudents(SortStudentsBy sort, Faculty faculty) {
        Student[] newStudents = FilterStudent.getByLength(students, studentLen);
        newStudents = FilterStudent.getByFaculty(newStudents, faculty);
        SortStudent.sortByName(newStudents);
        printStudents(newStudents);
    }

    public void printStudents(SortStudentsBy sort, Department department) {
        Student[] newStudents = FilterStudent.getByDepartment(
                FilterStudent.getByLength(students, studentLen), department);
        if (sort == SortStudentsBy.IN_DEPARTMENT_BY_COURSE) {
            SortStudent.sortByCourse(newStudents);
        }
        if (sort == SortStudentsBy.IN_DEPARTMENT_BY_NAME) {
            SortStudent.sortByName(newStudents);
        }
        printStudents(newStudents);
    }

    public void printStudents(SortStudentsBy sort, Department department, int course) {
        Student[] newStudents = FilterStudent.getByDepartment(
                FilterStudent.getByLength(students, studentLen), department);
        if (sort == SortStudentsBy.IN_DEPARTMENT_WITH_COURSE) {
            newStudents = FilterStudent.getByCourse(newStudents, course);
        }
        if (sort == SortStudentsBy.IN_DEPARTMENT_WITH_COURSE_BY_NAME) {
            newStudents = FilterStudent.getByCourse(newStudents, course);
            SortStudent.sortByName(newStudents);
        }
        printStudents(newStudents);
    }

    public void printTeachers(Faculty faculty) {
        Teacher[] newTeachers = FilterTeacher.getByLength(teachers, teacherLen);
        newTeachers = FilterTeacher.getByFaculty(newTeachers, faculty);
        SortTeacher.sortByName(newTeachers);
        printTeachers(newTeachers);
    }

    public void printTeachers(Department department) {
        Teacher[] newTeachers = FilterTeacher.getByLength(teachers, teacherLen);
        newTeachers = FilterTeacher.getByDepartment(newTeachers, department);
        SortTeacher.sortByName(newTeachers);
        printTeachers(newTeachers);
    }
}
