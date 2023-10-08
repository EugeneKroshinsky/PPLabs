package org.example;

import java.util.*;
import java.io.*;
public class Gradebook {
    private String firstname;
    private String sername;
    private int course;
    private ArrayList<Session> arrayListOfSessions;
    public Gradebook(){

    }

    public Gradebook(String firstname, String sername, int course, ArrayList<Session> arrayListOfSessions) {
        this.firstname = firstname;
        this.sername = sername;
        this.course = course;
        this.arrayListOfSessions = arrayListOfSessions;
    }

    public class Session {
        private int numberOfSemestr = 0;
        private ArrayList<Exam> arrayListOfExams;
        public Session(int semestr){
            numberOfSemestr = semestr;
        }
        public class Exam {
            private String examName;
            private String teacherName;
            private int examGrade;
            public void scanExam(Scanner in) throws IOException{
                teacherName = in.next();
                examGrade = Integer.parseInt(in.next());
                examName = in.nextLine().trim();
            }
            public void printExamConsole() throws IOException{
                System.out.println(this.toString());
            }
            @Override
            public String toString() {
                return new StringJoiner(", ", Exam.class.getSimpleName() + "[", "]")
                        .add("ExamName=" + examName)
                        .add("TeacherName=" + teacherName)
                        .add("ExamGrade=" + examGrade)
                        .toString();
            }
            public boolean isExcellentExam(){
                return examGrade == 9 || examGrade == 10;
            }
        }
        public void pushExamsToList(Scanner in) throws IOException{
            int count = Integer.parseInt(in.next());
            arrayListOfExams = new ArrayList<>();
            for(int i = 0; i < count; i++)
            {
                Exam exam = new Exam();
                exam.scanExam(in);
                arrayListOfExams.add(exam);
            }
        }
        public void printExamsFromList() throws IOException{
            System.out.println(numberOfSemestr);
            for (Exam exam : arrayListOfExams){
                exam.printExamConsole();
            }
        }
        public boolean isSessionExcellent(){
            for (Exam exam : arrayListOfExams){
                if (!exam.isExcellentExam()){
                    return false;
                }
            }
            return true;
        }
    }
    public void scanStudent(Scanner in) throws IOException{

        arrayListOfSessions = new ArrayList<>();
        firstname = in.next();
        sername = in.next();
        int countOfSessions = in.nextInt();
        for (int i = 0; i < countOfSessions; i++){
            Session session = new Session(i + 1);
            session.pushExamsToList(in);
            arrayListOfSessions.add(session);
        }
        course = countOfSessions / 2 + 1;
    }
    public void printStudentConsole() throws IOException{
        System.out.println(firstname + " " + sername);
        System.out.println("Course: " + course);
        for (Session session : arrayListOfSessions){
            session.printExamsFromList();
        }
        System.out.println();
    }
    public boolean isStudentExcellent(){
        for (Session session : arrayListOfSessions){
            if(!session.isSessionExcellent()){
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Gradebook.class.getSimpleName() + "[", "]")
                .add("firstname=" + firstname)
                .add("sername=" + sername)
                .add("course=" + course)
                .toString();
    }
}