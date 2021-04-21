package com.rcs;

public class Course {
    private final String courseName;
    private final CourseCategory category;
    private final double courseCoef;
    private final int numberOfLectures;
    private final int numberOfHomeworks;
    private final int numberOfTests;
    private final int numberOfExams;
    private final int[] hwMarks;
    private final int[] tMarks;
    private final int[] eMarks;
    private final boolean[] attendance;

    private double homeworkCoef;
    private double testCoef;
    private double examCoef;

    private final boolean attendanceBonus;

    public Course (String name, CourseCategory category, int numberOfLectures, int numberOfHomeworks,
                   int numberOfTests, int numberOfExams, boolean attendanceBonus, double rating) {
        this.courseName = name;
        this.category = category;

        this.numberOfLectures = numberOfLectures;
        this.attendance = new boolean[numberOfLectures];

        this.numberOfHomeworks = numberOfHomeworks;
        this.hwMarks = new int[numberOfHomeworks];

        this.numberOfTests = numberOfTests;
        this.tMarks = new int[numberOfTests];

        this.numberOfExams = numberOfExams;
        this.eMarks = new int[numberOfExams];

        this.attendanceBonus = attendanceBonus;
        this.courseCoef = rating;
    }

    public String getName() { return this.courseName; }

    public CourseCategory getCategory() { return this.category; }

    public boolean[] getAttendance() { return this.attendance; }
    public void setAttendance(int number, boolean attendance) {
        this.attendance[number] = attendance;
    }

    public int[] getHwMarks() { return this.hwMarks;}
    public int[] getTMarks() { return this.tMarks;}
    public int[] getEMarks() { return this.eMarks;}

    public void setHwMark(int number, int mark) {
        this.hwMarks[number] = mark;
    }

    public void setTMark(int number, int mark) {
        this.tMarks[number] = mark;
    }

    public void setEMark(int number, int mark) {
        this.eMarks[number] = mark;
    }

    public void setHomeworkCoef(double rating) { this.homeworkCoef = rating; }
    public void setTestCoef(double rating) { this.testCoef = rating; }
    public void setExamCoef(double rating) { this.examCoef = rating; }

    public double getCourseCoef () { return this.courseCoef; }
    public double getHomeworkCoef () { return this.homeworkCoef; }
    public double getTestCoef () { return this.testCoef; }
    public double getExamCoef () { return this.examCoef; }
    public double getAttendanceCoef () {
        return 0.05; }

    public int getNumberOfLectures () { return this.numberOfLectures; }
    public int getNumberOfHomeworks () { return this.numberOfHomeworks; }
    public int getNumberOfTests () { return  this.numberOfTests; }
    public int getNumberOfExams () {return this.numberOfExams; }
    public boolean getAttendanceBonus () { return this.attendanceBonus; }

    @Override
    public String toString () {
        return String.format("Course title: %s; category: %s;\n" +
                        "lectures: %d; homeworks: %d; tests: %d; exams: %d; attendance bonus: %s\n",
                this.courseName, this.category.toString(), this.numberOfLectures,
                this.numberOfHomeworks, this.numberOfTests, this.numberOfExams,
                attendanceBonus ? "yes" : "no");
    }

}
