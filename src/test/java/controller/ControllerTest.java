package controller;

import model.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class ControllerTest {
    private Student s1,s2,s3;
    Controller ctrl = new Controller("students.txt","laboratories.txt");
    @Before
    public void setUp() throws Exception {
        s1=new Student("asdf1239","asd asd", 123);
        s2=new Student("asdf1235","asd asd", 99);
        s3=new Student("asdf1236","asd asd", 999);
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Test Completed");
    }

    @Test
    public void saveStudent() throws IOException {
        assertTrue(ctrl.saveStudent(s1));
        assertFalse(ctrl.saveStudent(s2));
        assertFalse(ctrl.saveStudent(s3));
    }
}