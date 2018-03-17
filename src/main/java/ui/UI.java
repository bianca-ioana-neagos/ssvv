package ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

//import com.sun.org.apache.xpath.internal.operations.Bool;
import controller.Controller;
import model.Laboratory;
import model.Student;

public class UI {
	private Controller controller;

    public UI(Controller ctrl) throws IOException {
        this.controller = ctrl;
    }

    public void run() throws IOException, ParseException {
        System.out.println("Starting");

        Scanner s= new Scanner(System.in);
        //BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));

        String cmdM = "";
        do {
            System.out.println(" 1) Add student \n 2) Add Laboratory \n 3) Add grade \n 4) Get passing students \n 5) Get all students \n 0) Exit \n");
            cmdM = s.nextLine();
            switch (cmdM) {
                case "1":
                    addStudent();
                    break;
                case "2":
                    addLab();
                    break;
                case "3":
                    addGrade();
                    break;
                case "4":
                    getPassingStudents();
                    break;
                case "5":
                    getAllStudents();
                    break;
            }
        }while(!cmdM.equals("0"));
        System.exit(0);
    }



    void addStudent() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String registrationNumber, name;
        int group = 0;
        System.out.print("Registration number(4 letters and 4 digits): ");
        registrationNumber = br.readLine();
        System.out.print("Name: ");
        name = br.readLine();
        try {
            System.out.print("Group number(between 100 and 900): ");
            String groupString = br.readLine();
            group = Integer.parseInt(groupString);
        } catch (NumberFormatException e) {
            System.out.println("Invalid group - not a number");
        }
        Student student = new Student(registrationNumber, name, group);
        Boolean success = controller.saveStudent(student);
        br.readLine();
        if (!success) {
            System.out.println("Invalid student");
        }
    }

    void addLab() throws IOException, ParseException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = 0, problemNumber=0;
        String date, studentRegNumber;

        try {
            System.out.println("Lab number: ");
            String labNumberString = br.readLine();
            System.out.println("Problem number: ");
            String labProblemNumberString = br.readLine();
            number = Integer.parseInt(labNumberString);
            problemNumber = Integer.parseInt(labProblemNumberString);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input");
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Date (dd/mm/yyy)");
        date = br.readLine();
        System.out.println("Student reg number");
        studentRegNumber = br.readLine();

        Laboratory lab = new Laboratory(number, date, problemNumber, studentRegNumber);
        Boolean success = controller.saveLaboratory(lab);
        if (!success) {
            System.out.println("Cannot save laboratory");
        }
    }

    private void addGrade() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String registrationNumber, labNumber;
        float grade = 0;
        System.out.println("Reg number: ");
        registrationNumber = br.readLine();
        System.out.println("Lab number: ");
        labNumber = br.readLine();
        try {
            System.out.println("Grade: ");
            String gradeString = br.readLine();
            grade = Float.parseFloat(gradeString);
        } catch (NumberFormatException e) {
            System.out.println("Invalid grade");

        }
        try {
            Boolean success = controller.addGrade(registrationNumber, labNumber, grade);
            if (!success) {
                System.out.println("Cannot save grade");
            }
        } catch (NumberFormatException|IOException|ParseException e) {
            System.out.println("Cannot save grade");
        }

    }

    void getPassingStudents() throws IOException {
        try {
            List<Student> passingStudents = controller.passedStudents();
            System.out.println("Passing students: ");
            for ( Student student : passingStudents) {
                System.out.println("\t - " + student.toString());
            }
        } catch (ParseException e) {
            System.out.println("Could not get passing students");
        }
    }

    void getAllStudents() throws IOException {
        List<Student> students = controller.getStudentPersistence().getStudentsList();
        System.out.println("All students: ");
        for (Student student : students) {
            System.out.println("\t - " + student.toString());
        }
    }
} 