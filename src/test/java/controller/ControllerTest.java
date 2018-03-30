package controller;

import model.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class ControllerTest {
    private Student s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,s13;
    Controller ctrl = new Controller("students.txt","laboratories.txt");
    @Before
    public void setUp() throws Exception {
        s1=new Student("aqsw1234","asd asd", 123);
        s12=new Student("zsed0987","asd asd", 123);
        s13=new Student("zxfg6754","asd asd", 123);
        //group
        s2=new Student("asdf1235","asd asd", 99);
        s3=new Student("asdf1236","asd asd", 901);
        s10=new Student("asdf1245","asd asd", 900);
        s11=new Student("asdf1267","asd asd", 100);

        //regNumber
        s4=new Student("asd1239","asd asd", 123);
        s5=new Student("asdf123","asd asd", 123);
        s6=new Student("asdfg12367","asd asd", 123);

        //name
        s7=new Student("asdf1231","asd", 123);
        s8=new Student("asdf1232","asd5 asd6", 123);
        s9=new Student("asdf1233","", 123);
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Test Completed");
    }

    @Test
    public void saveStudent() throws IOException {
        assertTrue(ctrl.saveStudent(s1));
    }
    @Test
    public void saveStudent_2() throws IOException {
        assertFalse(ctrl.saveStudent(s2));
    }
    @Test
    public void saveStudent_3() throws IOException {
        assertFalse(ctrl.saveStudent(s3));
    }
    @Test
    public void saveStudent_4() throws IOException {
        assertTrue(ctrl.saveStudent(s10));
    }
    @Test
    public void saveStudent_5() throws IOException {
        assertTrue(ctrl.saveStudent(s11));
    }

    @Test
    public void saveStudentName() throws IOException {
        assertTrue(ctrl.saveStudent(s12));
    }
    @Test
    public void saveStudentName_2() throws IOException {
        assertFalse(ctrl.saveStudent(s4));
    }
    @Test
    public void saveStudentName_3() throws IOException {
        assertFalse(ctrl.saveStudent(s5));
    }
    @Test
    public void saveStudentName_4() throws IOException {
        assertFalse(ctrl.saveStudent(s6));
    }

    @Test
    public void saveStudentRegNumber() throws IOException {
        assertTrue(ctrl.saveStudent(s13));
    }
    @Test
    public void saveStudentRegNumber_2() throws IOException {
        assertFalse(ctrl.saveStudent(s7));
    }
    @Test
    public void saveStudentRegNumber_3() throws IOException {
        assertFalse(ctrl.saveStudent(s8));
    }
    @Test
    public void saveStudentRegNumber_4() throws IOException {
        assertFalse(ctrl.saveStudent(s9));
    }
}