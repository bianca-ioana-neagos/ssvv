package controller;

import model.Laboratory;
import model.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.text.ParseException;

import static org.junit.Assert.*;

public class ControllerBigBangTest {
    private Laboratory l1;
    private Student s1;
    private String s;
    private int l;
    float grade=9;
    Controller ctrl = new Controller("students.txt","laboratories.txt");

    @Before
    public void setUp() throws Exception {
        s="asdf1234";
        l=4;
        l1=new Laboratory(3,"30/04/2018",11,grade,"asdf1234");
        s1=new Student("aqsw1238","asd asd", 123);
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
    public void saveLab() throws IOException, ParseException {
        assertFalse(ctrl.saveLaboratory(l1));
        assertTrue(ctrl.addGrade(s,l,grade));
    }

    @Test
    public void getPassed() throws IOException, ParseException {
        assertEquals(2,ctrl.passedStudents().size());
    }

    @Test
    public void bigBang() throws IOException, ParseException {
        assertTrue(ctrl.saveStudent(new Student("zxcv4321", "asdf fds", 234)));
        assertTrue(ctrl.saveLaboratory(new Laboratory(4,"30/04/2018",5,grade, "zxcv4321")));
        assertTrue(ctrl.addGrade("zxcv4321", 4, grade));
        assertEquals(2,ctrl.passedStudents().size());
    }
}
