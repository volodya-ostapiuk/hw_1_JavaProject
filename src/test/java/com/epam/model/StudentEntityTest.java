package com.epam.model;

import org.junit.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.*;

public class StudentEntityTest {
    @Test
    public void testIdSetter() throws NoSuchFieldException, IllegalAccessException {
        final StudentEntity studentEntity = new StudentEntity();
        studentEntity.setId(101);
        final Field field = studentEntity.getClass().getDeclaredField("id");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(studentEntity), 101);
        assertNotEquals("Fields match", field.get(studentEntity), 111);
    }

    @Test
    public void testIdGetter() throws NoSuchFieldException, IllegalAccessException {
        final StudentEntity studentEntity = new StudentEntity();
        final Field field = studentEntity.getClass().getDeclaredField("id");
        field.setAccessible(true);
        field.set(studentEntity, 55);
        final int result = studentEntity.getId();
        assertEquals("Field wasn't retrieved properly", result, 55);
        assertNotEquals("Field was retrieved properly", result, 53);
    }

    @Test
    public void testClassIdSetter() throws NoSuchFieldException, IllegalAccessException {
        final StudentEntity studentEntity = new StudentEntity();
        studentEntity.setClassID(20);
        final Field field = studentEntity.getClass().getDeclaredField("classID");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(studentEntity), 20);
        assertNotEquals("Fields match", field.get(studentEntity), 21);
    }

    @Test
    public void testClassIdGetter() throws NoSuchFieldException, IllegalAccessException {
        final StudentEntity studentEntity = new StudentEntity();
        final Field field = studentEntity.getClass().getDeclaredField("classID");
        field.setAccessible(true);
        field.set(studentEntity, 0);
        final int result = studentEntity.getClassID();
        assertEquals("Field wasn't retrieved properly", result, 0);
        assertNotEquals("Field was retrieved properly", result, 1);
    }

    @Test
    public void testFirstNameSetter() throws NoSuchFieldException, IllegalAccessException {
        final StudentEntity studentEntity = new StudentEntity();
        studentEntity.setFirstName("Volodya");
        final Field field = studentEntity.getClass().getDeclaredField("firstName");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(studentEntity), "Volodya");
        assertNotEquals("Fields match", field.get(studentEntity), "Vova");
    }

    @Test
    public void testFirstNameGetter() throws NoSuchFieldException, IllegalAccessException {
        final StudentEntity studentEntity = new StudentEntity();
        final Field field = studentEntity.getClass().getDeclaredField("firstName");
        field.setAccessible(true);
        field.set(studentEntity, "Anna");
        final String result = studentEntity.getFirstName();
        assertEquals("Field wasn't retrieved properly", result, "Anna");
        assertNotEquals("Field was retrieved properly", result, "Inna");
    }

    @Test
    public void testLastNameSetter() throws NoSuchFieldException, IllegalAccessException {
        final StudentEntity studentEntity = new StudentEntity();
        studentEntity.setLastName("Volodya");
        final Field field = studentEntity.getClass().getDeclaredField("lastName");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(studentEntity), "Volodya");
        assertNotEquals("Fields match", field.get(studentEntity), "Vova");
    }

    @Test
    public void testLastNameGetter() throws NoSuchFieldException, IllegalAccessException {
        final StudentEntity studentEntity = new StudentEntity();
        final Field field = studentEntity.getClass().getDeclaredField("lastName");
        field.setAccessible(true);
        field.set(studentEntity, "Anna");
        final String result = studentEntity.getLastName();
        assertEquals("Field wasn't retrieved properly", result, "Anna");
        assertNotEquals("Field was retrieved properly", result, "Inna");
    }

    @Test
    public void testAddressSetter() throws NoSuchFieldException, IllegalAccessException {
        final StudentEntity studentEntity = new StudentEntity();
        studentEntity.setAddress("Lviv");
        final Field field = studentEntity.getClass().getDeclaredField("address");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(studentEntity), "Lviv");
        assertNotEquals("Fields match", field.get(studentEntity), "Kyiv");
    }

    @Test
    public void testAddressGetter() throws NoSuchFieldException, IllegalAccessException {
        final StudentEntity studentEntity = new StudentEntity();
        final Field field = studentEntity.getClass().getDeclaredField("address");
        field.setAccessible(true);
        field.set(studentEntity, "Kyiv");
        final String result = studentEntity.getAddress();
        assertEquals("Field wasn't retrieved properly", result, "Kyiv");
        assertNotEquals("Field was retrieved properly", result, "Odessa");
    }

    @Test
    public void testBirthdaySetter() throws NoSuchFieldException, IllegalAccessException {
        final StudentEntity studentEntity = new StudentEntity();
        studentEntity.setBirthday("2002-07-01");
        final Field field = studentEntity.getClass().getDeclaredField("birthday");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(studentEntity), "2002-07-01");
        assertNotEquals("Fields match", field.get(studentEntity), "01-07-2002");
    }

    @Test
    public void testBirthdayGetter() throws NoSuchFieldException, IllegalAccessException {
        final StudentEntity studentEntity = new StudentEntity();
        final Field field = studentEntity.getClass().getDeclaredField("birthday");
        field.setAccessible(true);
        field.set(studentEntity, "01-06-2001");
        final String result = studentEntity.getBirthday();
        assertEquals("Field wasn't retrieved properly", result, "01-06-2001");
        assertNotEquals("Field was retrieved properly", result, "2001-06-01");
    }

    @Test
    public void testPhoneSetter() throws NoSuchFieldException, IllegalAccessException {
        final StudentEntity studentEntity = new StudentEntity();
        studentEntity.setPhone("562");
        final Field field = studentEntity.getClass().getDeclaredField("phone");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(studentEntity), "562");
        assertNotEquals("Fields match", field.get(studentEntity), "562-562");
    }

    @Test
    public void testPhoneGetter() throws NoSuchFieldException, IllegalAccessException {
        final StudentEntity studentEntity = new StudentEntity();
        final Field field = studentEntity.getClass().getDeclaredField("phone");
        field.setAccessible(true);
        field.set(studentEntity, "562-562");
        final String result = studentEntity.getPhone();
        assertEquals("Field wasn't retrieved properly", result, "562-562");
        assertNotEquals("Field was retrieved properly", result, "562");
    }

    @Test
    public void testToString() {
        final StudentEntity studentEntity = new StudentEntity();
        String toString = studentEntity.toString();
        assertTrue(toString.contains("id=" + studentEntity.getId()));
    }

    @Test
    public void testClassEntity1() {
        final StudentEntity studentEntity = new StudentEntity();
        assertEquals(0, studentEntity.getId());
        assertNull(studentEntity.getAddress());
    }

    @Test
    public void testClassEntity2() {
        final StudentEntity studentEntity = new StudentEntity("Anna", "Sych", "Lviv",
                "1997-05-15", "3303-55-01", 12);
        assertEquals("Sych", studentEntity.getLastName());
        assertEquals(12, studentEntity.getClassID());
        assertNotEquals(null, studentEntity.getBirthday());
    }

    @Test
    public void testClassEntity3() {
        final StudentEntity studentEntity = new StudentEntity(1, "Oleg","Tor","Kyiv",
                "1968-08-11", "111-22-05", 11);
        assertEquals("1968-08-11", studentEntity.getBirthday());
        assertEquals(1, studentEntity.getId());
        assertNotEquals(null, studentEntity.getFirstName());
    }
}
