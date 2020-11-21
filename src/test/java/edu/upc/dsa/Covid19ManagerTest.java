package edu.upc.dsa;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class Covid19ManagerTest {
    @Before
    public void setUp() {
        Covid19ManagerImpl.getInstance().addBrote("Brote1");
        Covid19ManagerImpl.getInstance().addBrote("Brote2");
        Covid19ManagerImpl.getInstance().addBrote("Brote3");
        Covid19ManagerImpl.getInstance().addBrote("Brote4");
        Covid19ManagerImpl.getInstance().afegirCaso("Kevin","Garcia","Caso1",new Date (1996,9,2),new Date(2020,6,24),"nocaso","Femenino","kevinalca@gmail","635473","dsfasd","Brote1");
        Covid19ManagerImpl.getInstance().afegirCaso("Joel","Garcia","Caso1",new Date (1996,9,2),new Date(2020,6,24),"nocaso","Femenino","kevinalca@gmail","635473","dsfasd","Brote1");



    }



    @Test
    public void CrearBrote() {


        Covid19ManagerImpl.getInstance().addBrote("Brote5");
        assertEquals(5, Covid19ManagerImpl.getInstance().sizeBrotes());

    }

    @Test
    public void AñadirCaso() {


        Covid19ManagerImpl.getInstance().afegirCaso("Majo","Garcia","Caso1",new Date (1996,9,2),new Date(2020,6,24),"nocaso","Femenino","kevinalca@gmail","635473","dsfasd","Brote1");

        assertEquals(3, Covid19ManagerImpl.getInstance().sizeCasos());

    }


    @After
    public void tearDown() { Covid19ManagerImpl.getInstance().delete();}







}
