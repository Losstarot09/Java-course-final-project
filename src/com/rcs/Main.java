package com.rcs;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //Here starts giant constructor for program to work with
        //TO DO Change that constructor loads from file and write separate class for creating and saving file
        //TO DO input check for everything!!!

        System.out.print("Please, enter name of this university class: ");
        Scanner read = new Scanner(System.in);
        UniClass uniClass = new UniClass(read.nextLine());

        //part that creates student list for university class
        while (true) {
            System.out.print("Please, enter new students name: ");
            String name = read.nextLine().trim();
            System.out.print("Please, enter new students suname: ");
            String surname = read.nextLine().trim();
            System.out.print("Please, enter new students personal number: ");
            String personalId = read.nextLine().trim();
            uniClass.addStudent(name, surname, personalId);
            System.out.print("Please, enter \"q\" to guit adding students or any other symbol to continue: ");
            String key = read.nextLine().trim().toLowerCase();
            if (key.equals("q")) {
                break;
            }
        }

        //part that creates coefficients for course category
        System.out.println("Courses are divided in three categories: A, B and C");
        System.out.println("Category A - obligatory courses, highest mark coefficient");
        System.out.println("Category B - semi-obligatory courses, medium mark coefficient");
        System.out.println("Category C - free-choice courses, lowest mark coefficient");
        System.out.println("Remember sum of coefficients can't be bigger than 1.00 ");
        System.out.print("Please, enter coefficients for A category courses: ");
        double coefA = read.nextDouble();
        System.out.print("Please, enter coefficients for B category courses: ");
        double coefB = read.nextDouble();
        System.out.print("Please, enter coefficients for C category courses: ");
        double coefC = read.nextDouble();
        System.out.print("How many courses there be in total: ");
        int courseQuantity = read.nextInt();
        read.nextLine();

        //part where for each student courses are added
        System.out.print("Now you will fill courses for each student!");
        for (int i = 0; i < uniClass.getStudents().size(); i++ ) {
            System.out.printf("You will now enter course for student: %s\n",
                        uniClass.getStudents().get(i).toString());

                //courses them selves
                for (int j = 0; j < courseQuantity; j++) {
                    System.out.printf("Please, enter name of course Nr. %d: ", j +1);
                    String courseName = read.nextLine().trim();
                    System.out.printf("Please, enter category of course Nr. %d: ", j +1);
                    CourseCategory category = CourseCategory.valueOf(read.nextLine().trim().toUpperCase());
                    double coef = 0.00;
                    switch (category) {
                        case A:
                            coef = coefA;
                            break;
                        case B:
                            coef = coefB;
                            break;
                        case C:
                            coef = coefC;
                            break;
                    }
                    System.out.printf("Please, enter number of lectures for course Nr. %d: ", j +1);
                    int lectureQuantity = read.nextInt();
                    System.out.printf("Please, enter number of homeworks for course Nr. %d: ", j +1);
                    int homeworkQuantity = read.nextInt();
                    System.out.printf("Please, enter number of tests for course Nr. %d: ", j +1);
                    int testQuantity = read.nextInt();
                    System.out.printf("Please, enter number of exams for course Nr. %d: ", j +1);
                    int examQuantity = read.nextInt();
                    read.nextLine();
                    System.out.print("Will there be bonus for 100% attendance (yes / no): ");
                    String bonus = read.nextLine().trim().toLowerCase();
                    boolean aBonus = bonus.equals("yes");

                    uniClass.getStudents().get(i).addCourse(new Course(courseName, category, lectureQuantity,
                            homeworkQuantity,testQuantity, examQuantity, aBonus, coef));

                    //now attendance of a student for this course
                    for (int k = 0; k < uniClass.getStudents().get(i).getCourses().get(j).getNumberOfLectures(); k++) {
                        System.out.printf("Did student %s attended at lecture Nr. %d (yes/no): ",
                                uniClass.getStudents().get(i).toString(), k + 1);
                        String atten = read.nextLine().trim().toLowerCase();
                        uniClass.getStudents().get(i).getCourses().get(j).setAttendance(k, atten.equals("yes"));

                    }

                    //now homework marks of a student for this course
                    for (int k = 0; k < uniClass.getStudents().get(i).getCourses().get(j).getNumberOfHomeworks(); k++) {
                        System.out.printf("What mark student %s get for homework Nr. %d (1-10): ",
                                uniClass.getStudents().get(i).toString(), k + 1);
                        int mark = read.nextInt();

                        uniClass.getStudents().get(i).getCourses().get(j).setHwMark(k, mark);
                    }
                    System.out.print("Please, set coefficient of homeworks for these course\n" +
                            "(Sum of homework, test and exam coefficients can't be bigger than 1.00): ");
                    double coefHw = read.nextDouble();
                    read.nextLine();
                    uniClass.getStudents().get(i).getCourses().get(j).setHomeworkCoef(coefHw);

                    //now test marks of a student for this course
                    for (int k = 0; k < uniClass.getStudents().get(i).getCourses().get(j).getNumberOfTests(); k++) {
                        System.out.printf("What mark student %s get for test Nr. %d (1-10): ",
                                uniClass.getStudents().get(i).toString(), k + 1);
                        int mark = read.nextInt();

                        uniClass.getStudents().get(i).getCourses().get(j).setTMark(k, mark);
                    }
                    System.out.print("Please, set coefficient of tests for these course\n" +
                            "(Sum of homework, test and exam coefficients can't be bigger than 1.00): ");
                    double coefT = read.nextDouble();
                    read.nextLine();
                    uniClass.getStudents().get(i).getCourses().get(j).setTestCoef(coefT);

                    //now exam marks of a student for this course
                    for (int k = 0; k < uniClass.getStudents().get(i).getCourses().get(j).getNumberOfExams(); k++) {
                        System.out.printf("What mark student %s get for exam Nr. %d (1-10): ",
                                uniClass.getStudents().get(i).toString(), k + 1);
                        int mark = read.nextInt();

                        uniClass.getStudents().get(i).getCourses().get(j).setEMark(k, mark);
                    }
                    System.out.print("Please, set coefficient of exams for these course\n" +
                            "(Sum of homework, test and exam coefficients can't be bigger than 1.00): ");
                    double coefE = read.nextDouble();
                    read.nextLine();
                    uniClass.getStudents().get(i).getCourses().get(j).setExamCoef(coefE);
                }

            }

        //clear console input
        for (int i = 0; i < 40; i++) {
            System.out.println();
        }

        //Now program itself!
        //the idea was to see list of students who belong to one class
        //See each student attendance, marks for homework, tests and exams for each course
        //See their overall attendance for course
        //See their overall mark rating for course
        //See their overall mark rating for all courses combined
        //To Do overall mark rating of a student for all courses combined
        //To Do overall attendance of a student for all courses combined
        //To Do overall attendance and mark rating for whole class
        System.out.printf("Hello, you are currently looking at class %s\n", uniClass.getName());
        boolean exit = false;
        while (!exit) {
            System.out.print("Your option are:\n" +
                    "1. View students\n" +
                    "2. View courses of an individual student\n" +
                    "3. View attendance for course of an individual student\n" +
                    "4. View homework marks for course of an individual student\n" +
                    "5. View test marks for course of an individual student\n" +
                    "6. View exam marks for course of an individual student\n" +
                    "7. View overall mark for course of an individual student\n" +
                    "7. View overall mark of an individual student\n" +
                    "Please, enter options number or \"q\"/\"quit\" to exit program: ");
            String option = read.nextLine().trim().toLowerCase();
            switch (option) {

                case "1" :
                    System.out.println();
                    uniClass.showStudents();
                    System.out.print("Type any symbol to continue: ");
                    read.nextLine();
                    read.nextLine();
                    break;

                case "2" :
                    //select student
                    while (true) {
                        System.out.println();
                        uniClass.showStudents();
                        System.out.print("Please, enter students number: ");
                        try {
                            int studentNm = read.nextInt();
                            if (studentNm > 0 && studentNm <= uniClass.getStudents().size()) {
                                uniClass.getStudents().get(studentNm).showCourses();
                                System.out.println("Type \"q\" to return to previous menu " +
                                        "or any other to select another student");
                                if (read.nextLine().trim().equalsIgnoreCase("q")) {
                                    break;
                                }
                            } else {
                                System.out.println("Wrong student number");
                            }
                        } catch (Exception ex) {
                            System.out.println("Wrong student number");
                        }
                    }
                    read.nextLine();
                    break;

                case "3" :
                    //select student
                    while (true) {
                        System.out.println();
                        uniClass.showStudents();
                        System.out.print("Please, enter students number: ");
                        try {
                            int studentNm = read.nextInt();
                            if (studentNm > 0 && studentNm <= uniClass.getStudents().size()) {
                                //select course
                                while (true) {
                                    uniClass.getStudents().get(studentNm).showCourses();
                                    System.out.print("Please, enter course number: ");
                                    try {
                                        int courseNm = read.nextInt();
                                        if (courseNm > 0 && courseNm <=
                                                uniClass.getStudents().get(studentNm).getCourses().size()) {
                                            System.out.println(uniClass.getStudents().get(studentNm).showAttendance(courseNm));
                                            System.out.println("Type \"q\" to return to previous menu " +
                                                    "or any other symbol to select another course");
                                            if (read.nextLine().trim().equalsIgnoreCase("q")) {
                                                break;
                                            }
                                        } else {
                                            System.out.println("Wrong student number");
                                        }
                                    } catch (Exception ex) {
                                        System.out.println("Wrong student number");
                                    }
                                }
                                System.out.println("Type \"q\" to return to previous menu " +
                                        "or any other to select another student");
                                if (read.nextLine().trim().equalsIgnoreCase("q")) {
                                    break;
                                }
                            } else {
                                System.out.println("Wrong student number");
                            }
                        } catch (Exception ex) {
                            System.out.println("Wrong student number");
                        }
                    }
                    read.nextLine();
                    break;

                case "4" :
                    //select student
                    while (true) {
                        System.out.println();
                        uniClass.showStudents();
                        System.out.print("Please, enter students number: ");
                        try {
                            int studentNm = read.nextInt();
                            if (studentNm > 0 && studentNm <= uniClass.getStudents().size()) {
                                //select course
                                while (true) {
                                    uniClass.getStudents().get(studentNm).showCourses();
                                    System.out.print("Please, enter course number: ");
                                    try {
                                        int courseNm = read.nextInt();
                                        if (courseNm > 0 && courseNm <=
                                                uniClass.getStudents().get(studentNm).getCourses().size()) {
                                            System.out.println(uniClass.getStudents().get(studentNm).showHwMark(courseNm));
                                            System.out.println("Type \"q\" to return to previous menu " +
                                                    "or any other symbol to select another course");
                                            if (read.nextLine().trim().equalsIgnoreCase("q")) {
                                                break;
                                            }
                                        } else {
                                            System.out.println("Wrong student number");
                                        }
                                    } catch (Exception ex) {
                                        System.out.println("Wrong student number");
                                    }
                                }
                                System.out.println("Type \"q\" to return to previous menu " +
                                        "or any other to select another student");
                                if (read.nextLine().trim().equalsIgnoreCase("q")) {
                                    break;
                                }
                            } else {
                                System.out.println("Wrong student number");
                            }
                        } catch (Exception ex) {
                            System.out.println("Wrong student number");
                        }
                    }
                    read.nextLine();
                    break;

                case "5" :
                    //select student
                    while (true) {
                        System.out.println();
                        uniClass.showStudents();
                        System.out.print("Please, enter students number: ");
                        try {
                            int studentNm = read.nextInt();
                            if (studentNm > 0 && studentNm <= uniClass.getStudents().size()) {
                                //select course
                                while (true) {
                                    uniClass.getStudents().get(studentNm).showCourses();
                                    System.out.print("Please, enter course number: ");
                                    try {
                                        int courseNm = read.nextInt();
                                        if (courseNm > 0 && courseNm <=
                                                uniClass.getStudents().get(studentNm).getCourses().size()) {
                                            System.out.println(uniClass.getStudents().get(studentNm).showTMark(courseNm));
                                            System.out.println("Type \"q\" to return to previous menu " +
                                                    "or any other symbol to select another course");
                                            if (read.nextLine().trim().equalsIgnoreCase("q")) {
                                                break;
                                            }
                                        } else {
                                            System.out.println("Wrong student number");
                                        }
                                    } catch (Exception ex) {
                                        System.out.println("Wrong student number");
                                    }
                                }
                                System.out.println("Type \"q\" to return to previous menu " +
                                        "or any other to select another student");
                                if (read.nextLine().trim().equalsIgnoreCase("q")) {
                                    break;
                                }
                            } else {
                                System.out.println("Wrong student number");
                            }
                        } catch (Exception ex) {
                            System.out.println("Wrong student number");
                        }
                    }
                    read.nextLine();
                    break;

                case "6" :
                    //select student
                    while (true) {
                        System.out.println();
                        uniClass.showStudents();
                        System.out.print("Please, enter students number: ");
                        try {
                            int studentNm = read.nextInt();
                            if (studentNm > 0 && studentNm <= uniClass.getStudents().size()) {
                                //select course
                                while (true) {
                                    uniClass.getStudents().get(studentNm).showCourses();
                                    System.out.print("Please, enter course number: ");
                                    try {
                                        int courseNm = read.nextInt();
                                        if (courseNm > 0 && courseNm <=
                                                uniClass.getStudents().get(studentNm).getCourses().size()) {
                                            System.out.println(uniClass.getStudents().get(studentNm).showEMark(courseNm));
                                            System.out.println("Type \"q\" to return to previous menu " +
                                                    "or any other symbol to select another course");
                                            if (read.nextLine().trim().equalsIgnoreCase("q")) {
                                                break;
                                            }
                                        } else {
                                            System.out.println("Wrong student number");
                                        }
                                    } catch (Exception ex) {
                                        System.out.println("Wrong student number");
                                    }
                                }
                                System.out.println("Type \"q\" to return to previous menu " +
                                        "or any other to select another student");
                                if (read.nextLine().trim().equalsIgnoreCase("q")) {
                                    break;
                                }
                            } else {
                                System.out.println("Wrong student number");
                            }
                        } catch (Exception ex) {
                            System.out.println("Wrong student number");
                        }
                    }
                    read.nextLine();
                    break;

                case "7" :
                    //select student
                    while (true) {
                        System.out.println();
                        uniClass.showStudents();
                        System.out.print("Please, enter students number: ");
                        try {
                            int studentNm = read.nextInt();
                            if (studentNm > 0 && studentNm <= uniClass.getStudents().size()) {
                                //select course
                                while (true) {
                                    uniClass.getStudents().get(studentNm).showCourses();
                                    System.out.print("Please, enter course number: ");
                                    try {
                                        int courseNm = read.nextInt();
                                        if (courseNm > 0 && courseNm <=
                                                uniClass.getStudents().get(studentNm).getCourses().size()) {
                                            System.out.println(uniClass.getStudents().get(studentNm).showCourseRating(courseNm));
                                            System.out.println("Type \"q\" to return to previous menu " +
                                                    "or any other symbol to select another course");
                                            if (read.nextLine().trim().equalsIgnoreCase("q")) {
                                                break;
                                            }
                                        } else {
                                            System.out.println("Wrong student number");
                                        }
                                    } catch (Exception ex) {
                                        System.out.println("Wrong student number");
                                    }
                                }
                                System.out.println("Type \"q\" to return to previous menu " +
                                        "or any other to select another student");
                                if (read.nextLine().trim().equalsIgnoreCase("q")) {
                                    break;
                                }
                            } else {
                                System.out.println("Wrong student number");
                            }
                        } catch (Exception ex) {
                            System.out.println("Wrong student number");
                        }
                    }
                    read.nextLine();
                    break;

                case "8" :
                    //select student
                    while (true) {
                        System.out.println();
                        uniClass.showStudents();
                        System.out.print("Please, enter students number: ");
                        try {
                            int studentNm = read.nextInt();
                            if (studentNm > 0 && studentNm <= uniClass.getStudents().size()) {
                                System.out.println(uniClass.getStudents().get(studentNm).showOverallRating());
                                System.out.println("Type \"q\" to return to previous menu " +
                                        "or any other to select another student");
                                if (read.nextLine().trim().equalsIgnoreCase("q")) {
                                    break;
                                }
                            } else {
                                System.out.println("Wrong student number");
                            }
                        } catch (Exception ex) {
                            System.out.println("Wrong student number");
                        }
                    }
                    read.nextLine();
                    break;

                case "q" :
                case "quit" :
                    exit = true;
                    break;
                default :
                    System.out.println("Error, wrong option number");
                    read.nextLine();
                    continue;
            }
        }
        read.close();
    }
}

