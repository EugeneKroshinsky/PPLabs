package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("input.txt"));

        ArrayList<Gradebook> students = new ArrayList<Gradebook>();
        int countOfStudents = in.nextInt();
        for (int i = 0; i < countOfStudents; i++){
            Gradebook gradebook = new Gradebook();
            gradebook.scanStudent(in);
            students.add(gradebook);
        }
        for (Gradebook gradebook : students){
            gradebook.printStudentConsole();
        }
        System.out.println();
        System.out.println("===Excellent students list:");
        boolean flag = true;
        for (Gradebook gradebook : students){
            if(gradebook.isStudentExcellent()){
                flag = false;
                System.out.println(gradebook.toString());
            }
        }
        if (flag) {
            System.out.println("There is no excellent students");
        }
        System.out.println();
    }
}