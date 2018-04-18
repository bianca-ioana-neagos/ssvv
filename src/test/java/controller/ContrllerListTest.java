package controller;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.text.ParseException;

import static org.junit.Assert.*;

public class ContrllerListTest {
    Controller ctrl = new Controller("students.txt","laboratories.txt");

    @After
    public void tearDown() throws Exception {
        System.out.println("Test Completed");
    }

    @Test
    public void getPassed() throws IOException, ParseException {
        assertEquals(1,ctrl.passedStudents().size());
    }
}
