package education;

import education.LessonStudentCommands;
import education.exeption.UserNotFoundException;
import education.model.Lesson;
import education.model.Student;
import education.model.User;
import education.model.UserType;
import education.storage.LessonStorage;
import education.storage.StudentStorage;
import education.storage.UserStorage;
import education.util.DateUtil;

import java.text.ParseException;
import java.util.*;


public class EducationTest implements LessonStudentCommands {

    static Scanner scanner = new Scanner(System.in);
    static LessonStorage lessonStorage = new LessonStorage();
    static StudentStorage studentStorage = new StudentStorage();
    static UserStorage userStorage = new UserStorage();


    public static void main(String[] args) {

        boolean isRun = true;
        while (isRun) {
            LessonStudentCommands.printCommands();
            String command = scanner.nextLine();
            switch (command) {
                case EXIT:
                    isRun = false;
                    break;
                case LOGIN:
                    insertLogin();
                    break;
                case REGISTER:
                    register();
                    break;
            }
        }
    }

    private static void typeAdmin() {
        boolean isRun = true;
        while (isRun) {
            LessonStudentCommands.printAdminCommands();
            String command = scanner.nextLine();
            switch (command) {
                case EXIT:
                    isRun = false;
                    break;
                case ADD_LESSON:
                    addLesson();
                    break;
                case ADD_STUDENT:
                    addStudent();
                    break;
                case PRINT_STUDENTS:
                    studentStorage.print();
                    break;
                case PRINT_LESSONS:
                    printLessons();
                    break;
                case DELETE_LESSON_BY_NAME:
                    deleteLessons();
                    break;
                case DELETE_STUDENT_BY_EMAIL:
                    deleteStudent();
                    break;
                case PRINT_STUDENTS_BY_LESSON:
                    printStudentsByLesson();
                    break;
                default:
                    System.out.println("Invalid command!");
            }
        }
    }


    private static void typeUser() {
        boolean isRun = true;
        while (isRun) {
            LessonStudentCommands.printUserCommands();
            String command = scanner.nextLine();
            switch (command) {
                case EXIT:
                    isRun = false;
                    break;
                case ADD_LESSON:
                    addLesson();
                    break;
                case ADD_STUDENT:
                    addStudent();
                    break;
                case PRINT_STUDENTS:
                    studentStorage.print();
                    break;
                case PRINT_LESSONS:
                    printLessons();
                    break;
                case PRINT_STUDENTS_BY_LESSON:
                    printStudentsByLesson();
                    break;
                default:
                    System.out.println("Invalid command!");
            }
        }
    }

    private static void insertLogin() {

        System.out.println(" Please input email ");
        String email = scanner.nextLine();
        System.out.println(" Please input password ");
        String password = scanner.nextLine();

        userStorage.getByEmail(email);
        userStorage.getByEmail(password);
        User user = userStorage.getByEmail(email);

        if (userStorage.getByEmail(email) == null
                && userStorage.getByEmail(password) == null) {
            System.err.println("Invalid email or password, please try again");
        } else if (user.getType().equals("user")) {
            typeUser();
        } else if (user.getType().equals("admin")) {
            typeAdmin();
        }
    }


    private static void register() {

        System.out.println("Please input user's name");
        String name = scanner.nextLine();
        System.out.println("Please input user's surname");
        String surname = scanner.nextLine();
        System.out.println("Please input user's email");
        String email = scanner.nextLine();
        System.out.println("Please input user's password");
        String password = scanner.nextLine();
        System.out.println("Please input user's type");
        String type = scanner.nextLine();
        if (type.equalsIgnoreCase("admin")
                || type.equalsIgnoreCase("user")) {
        } else {
            System.out.println(" type is invalid ");
        }
        User user = new User(name, surname, email, password, type);

        if (userStorage.getByEmail(user.getEmail()) != null) {
            System.err.println("User with this email already exists");
        } else {
            userStorage.add(user);
            System.out.println("User was added");
        }
    }


    private static void deleteStudent() {

        String email = scanner.nextLine();
        Student student = studentStorage.getByEmail(email);
        if (student != null) {
            studentStorage.deleteStudentByEmail(email);
        } else {
            System.err.println("Author does not exists");

        }
    }


    private static void deleteLessons() {
        String name = scanner.nextLine();
        Lesson lesson = lessonStorage.getByName(name);
        if (lesson != null) {
            lessonStorage.deleteLessonByName(name);
        } else {
            System.err.println("Lesson does not found");

        }
    }


    private static void printLessons() {
        lessonStorage.print();
    }

    private static void printStudentsByLesson() {
        System.out.println("Please input lesson name for show students");
        String name = scanner.nextLine();
        studentStorage.printStudentByLesson(name);
    }


    private static void addStudent() {
       System.out.println("Please input  students name");
        String name = scanner.nextLine();
        System.out.println("Please input students surname");
        String surname = scanner.nextLine();
        System.out.println("Please input students age");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("Please input students email");
        String email = scanner.nextLine();
        System.out.println("Please input students phone");
        int phone = Integer.parseInt(scanner.nextLine());
        System.out.println("Please input dateOfBirth [12/12/2021]");
        String dateOfBirth = scanner.nextLine();
        Date date = null;
        try {
            date = DateUtil.stringToDate(dateOfBirth);
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println("Invalid date format,please respect format [12/12/2021]");
            return;
        }
        System.out.println("Please input lessons name");
        String lessonName = scanner.nextLine();
        String[] lessonNames = lessonName.split(",");

        List<Lesson> lessons = new LinkedList<>();
        Lesson lesson;
        for (String lssnName : lessonNames) {
            if ((lesson = lessonStorage.getByName(lssnName)) != null) {
                lessons.add(lesson);

            }
        }
        Student student = new Student();
        studentStorage.add(student);
        System.out.println("Thank you, Student was added");

    }
        private static void addLesson () {

            System.out.println("Please input lesson name,duration,lecturerName,price,");
            String lessonDataStr = scanner.nextLine();
            String[] lessonData = lessonDataStr.split(",");
            if (lessonData.length == 4) {
                Lesson lesson = new Lesson();
                if (lessonStorage.getByName(lesson.getName()) != null) {
                    System.out.println("Invalid name ");
                } else {
                    lessonStorage.add(lesson);
                    System.out.println("Thank you lesson is added");
                }

            } else {
                System.out.println("Invalid data");
            }
        }
    }