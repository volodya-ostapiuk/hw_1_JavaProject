package com.epam.model;

import org.junit.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.*;

public class ClassEntityTest {
    @Test
    public void testIdSetter() throws NoSuchFieldException, IllegalAccessException {
        final ClassEntity classEntity = new ClassEntity();
        classEntity.setId(101);
        final Field field = classEntity.getClass().getDeclaredField("id");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(classEntity), 101);
        assertNotEquals("Fields match", field.get(classEntity), 111);
    }

    @Test
    public void testIdGetter() throws NoSuchFieldException, IllegalAccessException {
        final ClassEntity classEntity = new ClassEntity();
        final Field field = classEntity.getClass().getDeclaredField("id");
        field.setAccessible(true);
        field.set(classEntity, 55);
        final int result = classEntity.getId();
        assertEquals("Field wasn't retrieved properly", result, 55);
        assertNotEquals("Field was retrieved properly", result, 53);
    }

    @Test
    public void testNameSetter() throws NoSuchFieldException, IllegalAccessException {
        final ClassEntity classEntity = new ClassEntity();
        classEntity.setName("Volodya");
        final Field field = classEntity.getClass().getDeclaredField("name");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(classEntity), "Volodya");
        assertNotEquals("Fields match", field.get(classEntity), "Volod");
    }

    @Test
    public void testNameGetter() throws NoSuchFieldException, IllegalAccessException {
        final ClassEntity classEntity = new ClassEntity();
        final Field field = classEntity.getClass().getDeclaredField("name");
        field.setAccessible(true);
        field.set(classEntity, "Java");
        final String result = classEntity.getName();
        assertEquals("Field wasn't retrieved properly", result, "Java");
        assertNotEquals("Field was retrieved properly", result, "avaJ");
    }

    @Test
    public void testDescriptionSetter() throws NoSuchFieldException, IllegalAccessException {
        final ClassEntity classEntity = new ClassEntity();
        classEntity.setDescription("Class is situated on 3rd floor");
        final Field field = classEntity.getClass().getDeclaredField("description");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(classEntity), "Class is situated on 3rd floor");
        assertNotEquals("Fields match", field.get(classEntity), "Class is situated on 2nd floor");
    }

    @Test
    public void testDescriptionGetter() throws NoSuchFieldException, IllegalAccessException {
        final ClassEntity classEntity = new ClassEntity();
        final Field field = classEntity.getClass().getDeclaredField("description");
        field.setAccessible(true);
        field.set(classEntity, "Class has 15 students");
        final String result = classEntity.getDescription();
        assertEquals("Field wasn't retrieved properly", result, "Class has 15 students");
        assertNotEquals("Field was retrieved properly", result, "Class has 13 students");
    }

    @Test
    public void testTeacherIdSetter() throws NoSuchFieldException, IllegalAccessException {
        final ClassEntity classEntity = new ClassEntity();
        classEntity.setTeacherID(20);
        final Field field = classEntity.getClass().getDeclaredField("teacherID");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(classEntity), 20);
        assertNotEquals("Fields match", field.get(classEntity), 21);
    }

    @Test
    public void testTeacherIdGetter() throws NoSuchFieldException, IllegalAccessException {
        final ClassEntity classEntity = new ClassEntity();
        final Field field = classEntity.getClass().getDeclaredField("teacherID");
        field.setAccessible(true);
        field.set(classEntity, 0);
        final int result = classEntity.getTeacherID();
        assertEquals("Field wasn't retrieved properly", result, 0);
        assertNotEquals("Field was retrieved properly", result, 1);
    }

    @Test
    public void testToString() {
        final ClassEntity classEntity = new ClassEntity();
        String toString = classEntity.toString();
        assertTrue(toString.contains("id=" + classEntity.getId()));
    }

    @Test
    public void testClassEntity1() {
        final ClassEntity classEntity = new ClassEntity();
        assertEquals(0, classEntity.getId());
        assertNull(classEntity.getDescription());
    }

    @Test
    public void testClassEntity2() {
        final ClassEntity classEntity = new ClassEntity("11B", "Class has 15 students", 11);
        assertEquals("11B", classEntity.getName());
        assertEquals(11, classEntity.getTeacherID());
        assertNotEquals(null, classEntity.getDescription());
    }

    @Test
    public void testClassEntity3() {
        final ClassEntity classEntity = new ClassEntity(1, "8A", "Class is very friendly", 4);
        assertEquals("8A", classEntity.getName());
        assertEquals(1, classEntity.getId());
        assertNotEquals(null, classEntity.getDescription());
    }
}
