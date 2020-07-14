package com.epam.model;

import org.junit.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.*;

public class TeacherEntityTest {
    @Test
    public void testIdSetter() throws NoSuchFieldException, IllegalAccessException {
        final TeacherEntity teacherEntity = new TeacherEntity();
        teacherEntity.setId(101);
        final Field field = teacherEntity.getClass().getDeclaredField("id");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(teacherEntity), 101);
        assertNotEquals("Fields match", field.get(teacherEntity), 111);
    }

    @Test
    public void testIdGetter() throws NoSuchFieldException, IllegalAccessException {
        final TeacherEntity teacherEntity = new TeacherEntity();
        final Field field = teacherEntity.getClass().getDeclaredField("id");
        field.setAccessible(true);
        field.set(teacherEntity, 55);
        final int result = teacherEntity.getId();
        assertEquals("Field wasn't retrieved properly", result, 55);
        assertNotEquals("Field was retrieved properly", result, 53);
    }

    @Test
    public void testSalarySetter() throws NoSuchFieldException, IllegalAccessException {
        final TeacherEntity teacherEntity = new TeacherEntity();
        teacherEntity.setSalary(20);
        final Field field = teacherEntity.getClass().getDeclaredField("salary");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(teacherEntity), 20);
        assertNotEquals("Fields match", field.get(teacherEntity), 21);
    }

    @Test
    public void testSalaryGetter() throws NoSuchFieldException, IllegalAccessException {
        final TeacherEntity teacherEntity = new TeacherEntity();
        final Field field = teacherEntity.getClass().getDeclaredField("salary");
        field.setAccessible(true);
        field.set(teacherEntity, 0);
        final int result = teacherEntity.getSalary();
        assertEquals("Field wasn't retrieved properly", result, 0);
        assertNotEquals("Field was retrieved properly", result, 1);
    }

    @Test
    public void testFirstNameSetter() throws NoSuchFieldException, IllegalAccessException {
        final TeacherEntity teacherEntity = new TeacherEntity();
        teacherEntity.setFirstName("Volodya");
        final Field field = teacherEntity.getClass().getDeclaredField("firstName");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(teacherEntity), "Volodya");
        assertNotEquals("Fields match", field.get(teacherEntity), "Vova");
    }

    @Test
    public void testFirstNameGetter() throws NoSuchFieldException, IllegalAccessException {
        final TeacherEntity teacherEntity = new TeacherEntity();
        final Field field = teacherEntity.getClass().getDeclaredField("firstName");
        field.setAccessible(true);
        field.set(teacherEntity, "Anna");
        final String result = teacherEntity.getFirstName();
        assertEquals("Field wasn't retrieved properly", result, "Anna");
        assertNotEquals("Field was retrieved properly", result, "Inna");
    }

    @Test
    public void testLastNameSetter() throws NoSuchFieldException, IllegalAccessException {
        final TeacherEntity teacherEntity = new TeacherEntity();
        teacherEntity.setLastName("Volodya");
        final Field field = teacherEntity.getClass().getDeclaredField("lastName");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(teacherEntity), "Volodya");
        assertNotEquals("Fields match", field.get(teacherEntity), "Vova");
    }

    @Test
    public void testLastNameGetter() throws NoSuchFieldException, IllegalAccessException {
        final TeacherEntity teacherEntity = new TeacherEntity();
        final Field field = teacherEntity.getClass().getDeclaredField("lastName");
        field.setAccessible(true);
        field.set(teacherEntity, "Anna");
        final String result = teacherEntity.getLastName();
        assertEquals("Field wasn't retrieved properly", result, "Anna");
        assertNotEquals("Field was retrieved properly", result, "Inna");
    }

    @Test
    public void testAddressSetter() throws NoSuchFieldException, IllegalAccessException {
        final TeacherEntity teacherEntity = new TeacherEntity();
        teacherEntity.setAddress("Lviv");
        final Field field = teacherEntity.getClass().getDeclaredField("address");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(teacherEntity), "Lviv");
        assertNotEquals("Fields match", field.get(teacherEntity), "Kyiv");
    }

    @Test
    public void testAddressGetter() throws NoSuchFieldException, IllegalAccessException {
        final TeacherEntity teacherEntity = new TeacherEntity();
        final Field field = teacherEntity.getClass().getDeclaredField("address");
        field.setAccessible(true);
        field.set(teacherEntity, "Kyiv");
        final String result = teacherEntity.getAddress();
        assertEquals("Field wasn't retrieved properly", result, "Kyiv");
        assertNotEquals("Field was retrieved properly", result, "Odessa");
    }

    @Test
    public void testBirthdaySetter() throws NoSuchFieldException, IllegalAccessException {
        final TeacherEntity teacherEntity = new TeacherEntity();
        teacherEntity.setBirthday("2002-07-01");
        final Field field = teacherEntity.getClass().getDeclaredField("birthday");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(teacherEntity), "2002-07-01");
        assertNotEquals("Fields match", field.get(teacherEntity), "01-07-2002");
    }

    @Test
    public void testBirthdayGetter() throws NoSuchFieldException, IllegalAccessException {
        final TeacherEntity teacherEntity = new TeacherEntity();
        final Field field = teacherEntity.getClass().getDeclaredField("birthday");
        field.setAccessible(true);
        field.set(teacherEntity, "01-06-2001");
        final String result = teacherEntity.getBirthday();
        assertEquals("Field wasn't retrieved properly", result, "01-06-2001");
        assertNotEquals("Field was retrieved properly", result, "2001-06-01");
    }

    @Test
    public void testPhoneSetter() throws NoSuchFieldException, IllegalAccessException {
        final TeacherEntity teacherEntity = new TeacherEntity();
        teacherEntity.setPhone("562");
        final Field field = teacherEntity.getClass().getDeclaredField("phone");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(teacherEntity), "562");
        assertNotEquals("Fields match", field.get(teacherEntity), "562-562");
    }

    @Test
    public void testPhoneGetter() throws NoSuchFieldException, IllegalAccessException {
        final TeacherEntity teacherEntity = new TeacherEntity();
        final Field field = teacherEntity.getClass().getDeclaredField("phone");
        field.setAccessible(true);
        field.set(teacherEntity, "562-562");
        final String result = teacherEntity.getPhone();
        assertEquals("Field wasn't retrieved properly", result, "562-562");
        assertNotEquals("Field was retrieved properly", result, "562");
    }

    @Test
    public void testCategorySetter() throws NoSuchFieldException, IllegalAccessException {
        final TeacherEntity teacherEntity = new TeacherEntity();
        teacherEntity.setCategory("B");
        final Field field = teacherEntity.getClass().getDeclaredField("category");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(teacherEntity), "B");
        assertNotEquals("Fields match", field.get(teacherEntity), "A");
    }

    @Test
    public void testCategoryGetter() throws NoSuchFieldException, IllegalAccessException {
        final TeacherEntity teacherEntity = new TeacherEntity();
        final Field field = teacherEntity.getClass().getDeclaredField("category");
        field.setAccessible(true);
        field.set(teacherEntity, "A");
        final String result = teacherEntity.getCategory();
        assertEquals("Field wasn't retrieved properly", result, "A");
        assertNotEquals("Field was retrieved properly", result, "B");
    }

    @Test
    public void testToString() {
        final TeacherEntity teacherEntity = new TeacherEntity();
        String toString = teacherEntity.toString();
        assertTrue(toString.contains("id=" + teacherEntity.getId()));
    }

    @Test
    public void testClassEntity1() {
        final TeacherEntity teacherEntity = new TeacherEntity();
        assertEquals(0, teacherEntity.getId());
        assertNull(teacherEntity.getAddress());
    }

    @Test
    public void testClassEntity2() {
        final TeacherEntity teacherEntity = new TeacherEntity("Petro","Sola", "Lviv",
                "123-01-01",12, "A", "1973-04-11");
        assertEquals("Sola", teacherEntity.getLastName());
        assertEquals(12, teacherEntity.getSalary());
        assertNotEquals(null, teacherEntity.getBirthday());
    }

    @Test
    public void testClassEntity3() {
        final TeacherEntity teacherEntity = new TeacherEntity(1, "Petro","Sola", "Lviv",
                "123-01-01",12, "A", "1973-04-11");
        assertEquals("1973-04-11", teacherEntity.getBirthday());
        assertEquals(1, teacherEntity.getId());
        assertNotEquals(null, teacherEntity.getFirstName());
    }
}
