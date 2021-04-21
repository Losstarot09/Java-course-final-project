package com.rcs;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private final String name;
    private final String surname;
    private final String personalId;
    private final List<Course> courses;

    public Student (String name, String surname, String personalId) {
        this.name = name;
        this.surname = surname;
        this.personalId = personalId;
        this.courses = new ArrayList<>();
    }

    public void addCourse (Course course) {
        this.courses.add(course);
    }

    public void setAttendance(int courseNm,int day, boolean attendance) {
        this.courses.get(courseNm).setAttendance(day, attendance);
    }

    public void setHmMark(int courseNm, int hwNm, int mark) {
        this.courses.get(courseNm).setHwMark(hwNm, mark);
    }

    public void setTMark(int courseNm, int tNm, int mark) {
        this.courses.get(courseNm).setTMark(tNm, mark);
    }

    public void setEMark(int courseNm, int eNm, int mark) {
        this.courses.get(courseNm).setEMark(eNm, mark);
    }

    public List<Course> getCourses() { return this.courses; }

    public String showHwMark(int courseNm) {
        String result = "";
        int size = this.courses.get(courseNm).getHwMarks().length;
        for (int i = 0; i < size; i++) {
            result += this.courses.get(courseNm).getHwMarks()[i] + i == size - 1 ? "; " : "";
        }
        return result;
    }

    public String showTMark(int courseNm) {
        String result = "";
        int size = this.courses.get(courseNm).getTMarks().length;
        for (int i = 0; i < size; i++) {
            result += this.courses.get(courseNm).getTMarks()[i] + i == size - 1 ? "" : "; ";
        }
        return result;
    }

    public String showEMark(int courseNm) {
        String result = "";
        int size = this.courses.get(courseNm).getEMarks().length;
        for (int i = 0; i < size; i++) {
            result += this.courses.get(courseNm).getEMarks()[i] + i == size - 1 ? "; " : "";
        }
        return result;
    }

    public String showAttendance(int courseNm) {
        double att = 0;
        int size = this.courses.get(courseNm).getAttendance().length;
        for (int i = 0; i < size; i++) {
            if (this.courses.get(courseNm).getAttendance()[i]) {
                att += 1;
            }
        }
        att = Math.round( att/size * 100.00) / 100.00;
        return String.format("Students %s %s overall attendance for course %s is %.2f", this.name, this.surname,
                this.courses.get(courseNm).getName(), att);
    }

    private boolean checkAttendance(int courseNm) {
        boolean result = false;
        if (this.courses.get(courseNm).getAttendanceBonus()) {
            int size = this.courses.get(courseNm).getAttendance().length;
            int counter = 0;
            for (int i = 0; i < size; i++) {
                if (this.courses.get(courseNm).getAttendance()[i]) {
                    counter++;
                }
            }
            if (counter == size) {
                result = true;
            }
        }
        return result;
    }

    private double calcRating(int courseNm) {
        double homeWork = 0;
        double tests = 0;
        double exam = 0;
        int hSize = this.courses.get(courseNm).getHwMarks().length;
        int tSize = this.courses.get(courseNm).getTMarks().length;
        int eSize = this.courses.get(courseNm).getEMarks().length;

        double checkAtt = checkAttendance(courseNm) ? this.courses.get(courseNm).getAttendanceCoef() : 0.00;

        for (int i = 0; i < hSize; i++) {
            homeWork += this.courses.get(courseNm).getHwMarks()[i];
        }

        homeWork = homeWork / hSize;

        for (int i = 0; i < tSize; i++) {
            tests += this.courses.get(courseNm).getTMarks()[i];
        }

        tests = tests / tSize;

        for (int i = 0; i < eSize; i++) {
            exam += this.courses.get(courseNm).getEMarks()[i];
        }

        exam = exam / eSize;

        double rating = Math.round((homeWork * this.courses.get(courseNm).getHomeworkCoef() +
                tests * this.courses.get(courseNm).getTestCoef() +
                exam * this.courses.get(courseNm).getExamCoef() +
                checkAtt) * 100.00) / 100.00;

        if (rating > 10) {
            rating = 10.00;
        }

        return rating;
    }

    public String showCourseRating(int courseNm) {
        double rating = calcRating(courseNm);
        return String.format("Students %s %s rating for course %s is %.2f", this.name, this.surname,
                this.courses.get(courseNm).getName(), rating);
    }

    public String showOverallRating() {
        int size = this.courses.size();
        double markA = 0.00;
        double markB = 0.00;
        double markC = 0.00;
        int counterA = 0;
        int counterB = 0;
        int counterC = 0;
        double coefA = 0.00;
        double coefB = 0.00;
        double coefC = 0.00;
        double mark = 0.00;
        for (int i = 0; i < size; i++) {
            switch (this.courses.get(i).getCategory()) {
                case  A :
                    counterA++;
                    markA += calcRating(i);
                    coefA = this.courses.get(i).getCourseCoef();
                    break;
                case  B :
                    counterB++;
                    markB += calcRating(i);
                    coefB = this.courses.get(i).getCourseCoef();
                    break;
                case  C :
                    counterC++;
                    markC += calcRating(i);
                    coefC = this.courses.get(i).getCourseCoef();
                    break;
            }
            markA = Math.round(markA / counterA * 100.00) / 100.00 *  coefA;
            markB = Math.round(markB / counterB * 100.00) / 100.00 *  coefB;
            markC = Math.round(markC / counterC * 100.00) / 100.00 *  coefC;
            mark = markA + markB + markC;
        }
        return String.format("Students %s %s overall rating is %.2f", this.name, this.surname, mark);
    }

    public void showCourses() {
        int i = 0;
        for (Course course : this.courses) {
            System.out.println(++i + ". " + course);
        }
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", this.name, this.surname, this.personalId);
    }


}
