package com.epam.model;

import org.junit.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.*;

public class SubjectEntityTest {
    @Test
    public void testIdSetter() throws NoSuchFieldException, IllegalAccessException {
        final SubjectEntity subjectEntity = new SubjectEntity();
        subjectEntity.setId(101);
        final Field field = subjectEntity.getClass().getDeclaredField("id");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(subjectEntity), 101);
        assertNotEquals("Fields match", field.get(subjectEntity), 111);
    }

    @Test
    public void testIdGetter() throws NoSuchFieldException, IllegalAccessException {
        final SubjectEntity subjectEntity = new SubjectEntity();
        final Field field = subjectEntity.getClass().getDeclaredField("id");
        field.setAccessible(true);
        field.set(subjectEntity, 55);
        final int result = subjectEntity.getId();
        assertEquals("Field wasn't retrieved properly", result, 55);
        assertNotEquals("Field was retrieved properly", result, 53);
    }

    @Test
    public void testNameSetter() throws NoSuchFieldException, IllegalAccessException {
        final SubjectEntity subjectEntity = new SubjectEntity();
        subjectEntity.setName("Math");
        final Field field = subjectEntity.getClass().getDeclaredField("name");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(subjectEntity), "Math");
        assertNotEquals("Fields match", field.get(subjectEntity), "Algebra");
    }

    @Test
    public void testNameGetter() throws NoSuchFieldException, IllegalAccessException {
        final SubjectEntity subjectEntity = new SubjectEntity();
        final Field field = subjectEntity.getClass().getDeclaredField("name");
        field.setAccessible(true);
        field.set(subjectEntity, "English");
        final String result = subjectEntity.getName();
        assertEquals("Field wasn't retrieved properly", result, "English");
        assertNotEquals("Field was retrieved properly", result, "British");
    }

    @Test
    public void testDescriptionSetter() throws NoSuchFieldException, IllegalAccessException {
        final SubjectEntity subjectEntity = new SubjectEntity();
        subjectEntity.setDescription("Subject is from 5th grade");
        final Field field = subjectEntity.getClass().getDeclaredField("description");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(subjectEntity), "Subject is from 5th grade");
        assertNotEquals("Fields match", field.get(subjectEntity), "Subject is from 8th grade");
    }

    @Test
    public void testDescriptionGetter() throws NoSuchFieldException, IllegalAccessException {
        final SubjectEntity subjectEntity = new SubjectEntity();
        final Field field = subjectEntity.getClass().getDeclaredField("description");
        field.setAccessible(true);
        field.set(subjectEntity, "Subject has 2 teachers");
        final String result = subjectEntity.getDescription();
        assertEquals("Field wasn't retrieved properly", result, "Subject has 2 teachers");
        assertNotEquals("Field was retrieved properly", result, "Subject has 3 teachers");
    }

    @Test
    public void testToString() {
        final SubjectEntity subjectEntity = new SubjectEntity();
        String toString = subjectEntity.toString();
        assertTrue(toString.contains("id=" + subjectEntity.getId()));
    }

    @Test
    public void testClassEntity1() {
        final SubjectEntity subjectEntity = new SubjectEntity();
        assertEquals(0, subjectEntity.getId());
        assertNull(subjectEntity.getDescription());
    }

    @Test
    public void testClassEntity2() {
        final SubjectEntity subjectEntity = new SubjectEntity("Algebra", "Subject is from 5th grade");
        assertEquals("Algebra", subjectEntity.getName());
        assertNotEquals(null, subjectEntity.getDescription());
    }

    @Test
    public void testClassEntity3() {
        final SubjectEntity subjectEntity = new SubjectEntity(1, "Astronomy", "Subject is from 10th grade");
        assertEquals("Astronomy", subjectEntity.getName());
        assertEquals(1, subjectEntity.getId());
        assertNotEquals(null, subjectEntity.getDescription());
    }
}
