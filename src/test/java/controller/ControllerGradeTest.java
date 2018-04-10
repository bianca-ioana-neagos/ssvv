package controller;

import model.Laboratory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.text.ParseException;

import static org.junit.Assert.*;

public class ControllerGradeTest {
    private String s;
    private int l;
    private float g1, g2;
    Controller ctrl = new Controller("students.txt","laboratories.txt");

    @Before
    public void setUp() throws Exception {
        g1=9;
        g2=0;
        s="asdf1234";
        l=4;

    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Test Completed");
    }

    @Test
    public void addGrade() throws IOException {
        try {
            assertTrue(ctrl.addGrade(s,l,g1));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void addGrade_2() throws IOException {
        try {
            assertFalse(ctrl.addGrade(s,l,g2));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
