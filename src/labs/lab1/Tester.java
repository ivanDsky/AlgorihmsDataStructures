package labs.lab1;

import utils.DataInput;
/**
 * This is console interface that gets information from user and deliver it to logic classes
 */
public class Tester {
    private static University Mohyla = University.getInstance();

    public static void main(String[] args) {
        preInit();


        while (true) {
            System.out.println("This is Kyiv-Mohyla academy manager");
            System.out.println("1 - if you want to create/remove/edit something\n" +
                    "2 - if you want to find teacher/student\n" +
                    "3 - if you want to get different kinds of teacher/student lists\n" +
                    "4 - exit");
            int id = DataInput.getIntInRange("Enter number of action : ", 1, 4);
            if (id == 1) CREFaculty();
            if (id == 2) Find();
            if (id == 3) Show();
            if (id == 4) System.exit(0);
        }
    }

    private static void preInit() {
        Faculty fi = new Faculty("FI");
        Mohyla.addFaculty(fi);
        Faculty fsnst = new Faculty("FSNST");
        Mohyla.addFaculty(fsnst);
        Faculty fen = new Faculty("FEN");
        Mohyla.addFaculty(fen);

        Department ipz = new Department("IPZ",fi);
        fi.addDepartment(ipz);
        Department pm = new Department("PM",fi);
        fi.addDepartment(pm);

        Department sociology = new Department("Sociology",fsnst);
        fsnst.addDepartment(sociology);
        Department PS = new Department("Political science",fsnst);
        fsnst.addDepartment(PS);
        Department psychology = new Department("Psychology",fsnst);
        fsnst.addDepartment(psychology);

        Department finance = new Department("Finance",fen);
        fen.addDepartment(finance);
        Department marketing = new Department("Marketing",fen);
        fen.addDepartment(marketing);

        Mohyla.addStudent(new Student("Буряк Олеся Володимирівна",PS,1,2),PS);
        Mohyla.addStudent(new Student("Кітик Анастасія Ігорівна",PS,1,1),PS);
        Mohyla.addStudent(new Student("Устинова Ольга Олександрівна",PS,2,4),PS);
        Mohyla.addStudent(new Student("Кобилецький Маркіян-Іван Миколайович",PS,4,6),PS);

        Mohyla.addStudent(new Student("Ткач Алєся Арсеніївна",psychology,3,4),psychology);
        Mohyla.addStudent(new Student("Зарицька Євгенія Семенівна",psychology,4,1),psychology);
        Mohyla.addStudent(new Student("Денисенко Валерія Геннадіївна",psychology,1,5),psychology);
        Mohyla.addStudent(new Student("Данченко Софія Богданівна",psychology,4,4),psychology);

        Mohyla.addStudent(new Student("Трегуб Софія Володимирівна",sociology,6,3),sociology);
        Mohyla.addStudent(new Student("Жураховська Олена Станіславівна",sociology,2,6),sociology);
        Mohyla.addStudent(new Student("Гончаренко Анна Олександрівна",sociology,1,2),sociology);
        Mohyla.addStudent(new Student("Камінська Руслана Володимирівна",sociology,3,4),sociology);

        Mohyla.addStudent(new Student("Гангало Богдан Сергійович",finance,1,1),finance);
        Mohyla.addStudent(new Student("Лавріненко Юлія Олегівна",finance,2,1),finance);
        Mohyla.addStudent(new Student("Москаленко Ольга Олександрівна",finance,4,6),finance);
        Mohyla.addStudent(new Student("Данович Олександра Олегівна",finance,4,2),finance);

        Mohyla.addStudent(new Student("Денисюк Іоанна Михайлівна",marketing,4,3),marketing);
        Mohyla.addStudent(new Student("Торяник Марія Михайлівна",marketing,3,5),marketing);
        Mohyla.addStudent(new Student("Лепський Максим Сергійович",marketing,3,2),marketing);
        Mohyla.addStudent(new Student("Письменна Марія Олександрівна",marketing,1,2),marketing);

        Mohyla.addStudent(new Student("Вербівська Юлія Віталіївна",pm,2,4),pm);
        Mohyla.addStudent(new Student("Колодяжна Дарія Олександрівна",pm,3,6),pm);
        Mohyla.addStudent(new Student("Гурський Богдан Русланович",pm,3,2),pm);
        Mohyla.addStudent(new Student("Дойничко Арсен Ігорович",pm,1,2),pm);

        Mohyla.addStudent(new Student("Мельник Ірина Валеріївна",ipz,1,3),ipz);
        Mohyla.addStudent(new Student("Санченко Георгій Олександрович",ipz,1,5),ipz);
        Mohyla.addStudent(new Student("Шевченко Дар'я Валеріївна",ipz,3,2),ipz);
        Mohyla.addStudent(new Student("Жорник Дмитро Олегович",ipz,1,2),ipz);
    }

    private static void CREFaculty() {
        while (true) {
            System.out.println("1 - if you want to create faculty\n" +
                    "2 - if you want to remove faculty\n" +
                    "3 - if you want to edit faculty\n" +
                    "4 - back");
            int id = DataInput.getIntInRange("Enter number of action : ", 1, 4);
            if (id == 1) {
                String name = DataInput.getString("Enter faculty name : ");
                Mohyla.addFaculty(new Faculty(name));
            }
            if (id == 2 || id == 3) {
                Faculty fac = University.getFaculty();
                if(fac == null)continue;
                if (id == 2) try {
                    Mohyla.removeFaculty(fac);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (id == 3) EditFaculty(fac);
            }
            if (id == 4) return;
        }
    }

    private static void EditFaculty(Faculty faculty) {
        while (true) {
            System.out.println("1 - if you want to change faculty name\n" +
                    "2 - if you want to operate with department\n" +
                    "3 - back");
            int id = DataInput.getIntInRange("Enter number of action : ", 1, 3);
            if (id == 1) {
                while (true) {
                    String name = DataInput.getString("Enter new faculty name : ");
                    if (Mohyla.findFaculty(new Faculty(name)) != -1) {
                        System.out.println("This name is in " + Mohyla.getName());
                        continue;
                    }
                    faculty.setName(name);
                    break;
                }
            }
            if (id == 2) CREDepartment(faculty);
            if (id == 3) return;
        }
    }

    private static void CREDepartment(Faculty faculty) {
        while (true) {
            System.out.println("1 - if you want to create department\n" +
                    "2 - if you want to remove department\n" +
                    "3 - if you want to edit department\n" +
                    "4 - back");
            int id = DataInput.getIntInRange("Enter number of action : ", 1, 4);
            if (id == 1) {
                String name = DataInput.getString("Enter department name : ");
                faculty.addDepartment(new Department(name,faculty));
            }
            if (id == 2 || id == 3) {
                Department dep = faculty.getDepartment();
                if(dep == null)continue;
                if (id == 2) try {
                    faculty.removeDepartment(dep);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (id == 3) EditDepartment(dep);
            }
            if (id == 4) return;
        }
    }

    private static void EditDepartment(Department dep) {
        while (true) {
            System.out.println("1 - if you want to change department name\n" +
                    "2 - if you want to change department faculty\n" +
                    "3 - if you want to operate with students\n" +
                    "4 - if you want to operate with teachers\n" +
                    "5 - back");
            int id = DataInput.getIntInRange("Enter number of action : ", 1, 5);
            if (id == 1) {
                while (true) {
                    String name = DataInput.getString("Enter new department name : ");
                    if (dep.getFaculty().findDepartment(new Department(name, dep.getFaculty())) != -1) {
                        System.out.println("This name is in " + dep.getFaculty().getName());
                        continue;
                    }
                    dep.setName(name);
                    break;
                }
            }
            if (id == 2) {
                Faculty faculty = University.getFaculty();
                try{dep.getFaculty().removeDepartment(dep);}catch (Exception e){e.printStackTrace();}
                dep.setFaculty(faculty);
                faculty.addDepartment(dep);
            }
            if (id == 3) CREStudent(dep);
            if (id == 4) CRETeacher(dep);
            if (id == 5) return;
        }
    }



    private static void CREStudent(Department dep) {
        while (true) {
            System.out.println("1 - if you want to add student\n" +
                    "2 - if you want to remove student\n" +
                    "3 - if you want to edit student\n" +
                    "4 - back");
            int id = DataInput.getIntInRange("Enter number of action : ", 1, 4);
            if (id == 1) {
                String name = DataInput.getString("Enter student full name : ");
                int course = University.getCourse();
                int group = DataInput.getIntInRange("Enter group : ",1,6);
                Mohyla.addStudent(new Student(name,dep,course,group),dep);
            }
            if (id == 2 || id == 3) {
                Student student = University.getStudent(dep);
                if(student == null)continue;
                if (id == 2) try {
                    Mohyla.removeStudent(student);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (id == 3) EditStudent(student);
            }
            if (id == 4) return;
        }

    }

    private static void EditStudent(Student student) {
        while (true) {
            System.out.println("1 - if you want to change student name\n" +
                    "2 - if you want to change student department\n" +
                    "3 - if you want to change student course\n" +
                    "4 - if you want to change student group\n" +
                    "5 - back");
            int id = DataInput.getIntInRange("Enter number of action : ", 1, 5);
            if (id == 1) {
                while (true) {
                    String name = DataInput.getString("Enter new students name : ");
                    if (Mohyla.findStudent(new Student(name, student.department, student.getCourse(),
                            student.getGroup())) != -1) {
                        System.out.println("This name is in " + student.department.getName());
                        continue;
                    }
                    student.setName(name);
                    break;
                }
            }
            if (id == 2) {
                Department dep = University.getFaculty().getDepartment();
                student.setDepartment(dep);
            }
            if (id == 3){
                int x = University.getCourse();
                student.setCourse(x);
            }
            if (id == 4){
                int x = DataInput.getIntInRange("Enter group : ",1,6);
                student.setGroup(x);
            }
            if(id == 5)return;
        }
    }

    private static void CRETeacher(Department dep) {
        while (true) {
            System.out.println("1 - if you want to add teacher\n" +
                    "2 - if you want to remove teacher\n" +
                    "3 - if you want to edit teacher\n" +
                    "4 - back");
            int id = DataInput.getIntInRange("Enter number of action : ", 1, 4);
            if (id == 1) {
                String name = DataInput.getString("Enter teacher full name : ");
                Mohyla.addTeacher(new Teacher(name,dep),dep);
            }
            if (id == 2 || id == 3) {
                Teacher teacher = University.getTeacher(dep);
                if(teacher == null)continue;
                if (id == 2) try {
                    Mohyla.removeTeacher(teacher);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (id == 3) EditTeacher(teacher);
            }
            if (id == 4) return;
        }
    }

    private static void EditTeacher(Teacher teacher) {
        while (true) {
            System.out.println("1 - if you want to change teacher name\n" +
                    "2 - if you want to change teacher department\n" +
                    "3 - back");
            int id = DataInput.getIntInRange("Enter number of action : ", 1, 5);
            if (id == 1) {
                while (true) {
                    String name = DataInput.getString("Enter new teacher name : ");
                    if (Mohyla.findTeacher(new Teacher(name, teacher.department)) != -1) {
                        System.out.println("This name is in " + teacher.department.getName());
                        continue;
                    }
                    teacher.setName(name);
                    break;
                }
            }
            if (id == 2) {
                Department dep = University.getFaculty().getDepartment();
                teacher.setDepartment(dep);
            }
            if(id == 3)return;
        }
    }

    private static void Find() {
        while (true) {
            System.out.println("1 - if you want to find student by full name and course\n" +
                    "2 - if you want to find student by full name and group\n" +
                    "3 - if you want to find teacher by full name\n" +
                    "4 - back");
            int id = DataInput.getIntInRange("Enter number of action : ", 1, 4);
            if(id == 4)return;
            String name = DataInput.getString("Enter " + ((id == 1 || id == 2) ? "student" : "teacher")
                    + " name : ");
            if(id <= 2){
                int x = DataInput.getIntInRange("Enter " + ((id == 1) ? "course : " : "group : "),1,6);
                if(id == 1)Mohyla.printStudentByCourse(name,x);
                if(id == 2)Mohyla.printStudentByGroup(name,x);
            }else{
                Mohyla.printTeacherByName(name);
            }
        }
    }

    private static void Show() {
        while (true) {
            System.out.println("1 - if you want to print students sorted by course\n" +
                    "2 - if you want to print students of faculty sorted alphabetically\n" +
                    "3 - if you want to print students of department sorted by course\n" +
                    "4 - if you want to print students of department sorted alphabetically\n" +
                    "5 - if you want to print students of department with defined course\n" +
                    "6 - if you want to print students of department with defined course sorted alphabetically\n" +
                    "7 - if you want to print teachers of faculty sorted alphabetically\n" +
                    "8 - if you want to print teachers of department sorted alphabetically\n" +
                    "9 - back");
            int id = DataInput.getIntInRange("Enter number of action : ", 1, 9);
            if(id == 9)return;
            if(id == 1){Mohyla.printStudents(SortStudentsBy.BY_COURSE);continue;}
            Faculty faculty = University.getFaculty();
            if(faculty == null)continue;
            if(id == 2){Mohyla.printStudents(SortStudentsBy.IN_FACULTY_BY_NAME,faculty);continue;}
            if(id == 7){Mohyla.printTeachers(faculty);continue;}
            Department department = faculty.getDepartment();
            if(department == null)continue;
            if(id == 3){Mohyla.printStudents(SortStudentsBy.IN_DEPARTMENT_BY_COURSE,department);continue;}
            if(id == 4){Mohyla.printStudents(SortStudentsBy.IN_DEPARTMENT_BY_NAME,department);continue;}
            if(id == 8){Mohyla.printTeachers(department);continue;}
            int course = University.getCourse();
            if(id == 5){Mohyla.printStudents(SortStudentsBy.IN_DEPARTMENT_WITH_COURSE,department,course);continue;}
            if(id == 6){Mohyla.printStudents(SortStudentsBy.IN_DEPARTMENT_WITH_COURSE_BY_NAME,department,course);continue;}
        }
    }
}


