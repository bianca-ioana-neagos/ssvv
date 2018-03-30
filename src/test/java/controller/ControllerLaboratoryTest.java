package controller;

import model.Laboratory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

public class ControllerLaboratoryTest {
    private Laboratory l1,l2,l3;
    Controller ctrl = new Controller("students.txt","laboratories.txt");


    @Before
    public void setUp() throws Exception {
        float grade=9;
        l1=new Laboratory(3,"30/04/2018",5,grade,"asdf1234");
        l2=new Laboratory(6,"30/04/2018",11,grade,"asdf1234");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Test Completed");
    }

    @Test
    public void saveLab() throws IOException {
        assertTrue(ctrl.saveLaboratory(l1));
    }
    @Test
    public void saveLab_2() throws IOException {
        assertFalse(ctrl.saveLaboratory(l2));
    }
}
