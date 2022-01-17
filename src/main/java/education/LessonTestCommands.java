package education;


interface LessonStudentCommands {
    String EXIT = "0";
    String ADD_LESSON = "1";
    String ADD_STUDENT = "2";
    String PRINT_STUDENTS = "3";
    String PRINT_STUDENTS_BY_LESSON = "4";
    String PRINT_LESSONS = "5";
    String DELETE_LESSON_BY_NAME = "6";
    String DELETE_STUDENT_BY_EMAIL = "7";
    String LOGOUT = "8";
    String LOGIN = "1";
    String REGISTER = "2";

    static void printCommands() {
        System.out.println("\u001B[34m" + "please input " + EXIT + " for EXIT");
        System.out.println("please input " + LOGIN + " for login");
        System.out.println("please input " + REGISTER + " for register");
    }


    static void printAdminCommands() {
        System.out.println("\u001B[34m" + "please input " + EXIT + " to EXIT");
        System.out.println("please input " + ADD_LESSON + " for add lesson");
        System.out.println("please input " + ADD_STUDENT + " for add student");
        System.out.println("please input " + PRINT_STUDENTS + " for print student");
        System.out.println("please input " + PRINT_STUDENTS_BY_LESSON + " for print students by lesson");
        System.out.println("please input " + PRINT_LESSONS + " for print lesson");
        System.out.println("please input " + DELETE_LESSON_BY_NAME + " for delete lesson by name");
        System.out.println("please input " + DELETE_STUDENT_BY_EMAIL + " for delete student  by email");
        System.out.println("please input " + LOGOUT + " for logout");

    }

    static void printUserCommands() {
        System.out.println("\u001B[34m" + "please input " + EXIT + " for EXIT");
        System.out.println("please input " + ADD_LESSON + " for add lesson");
        System.out.println("please input " + ADD_STUDENT + " for add student");
        System.out.println("please input " + PRINT_STUDENTS + " for print student");
        System.out.println("please input " + PRINT_STUDENTS_BY_LESSON + " for print students by lesson");
        System.out.println("please input " + PRINT_LESSONS + " for print lesson");
        System.out.println("please input " + LOGOUT + " for logout");
    }

}
