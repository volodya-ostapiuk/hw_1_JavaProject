package com.epam.model;

import java.lang.reflect.Field;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SubjectEntityNGTest {
    @Test(groups = { "functest" })
    public void testIdSetter() throws NoSuchFieldException, IllegalAccessException {
        final SubjectEntity subjectEntity = new SubjectEntity();
        subjectEntity.setId(101);
        final Field field = subjectEntity.getClass().getDeclaredField("id");
        field.setAccessible(true);
        Assert.assertEquals(field.get(subjectEntity), 101, "Fields didn't match");
        Assert.assertNotEquals(field.get(subjectEntity), 111, "Fields match");
    }

    @Test(groups = { "functest" })
    public void testIdGetter() throws NoSuchFieldException, IllegalAccessException {
        final SubjectEntity subjectEntity = new SubjectEntity();
        final Field field = subjectEntity.getClass().getDeclaredField("id");
        field.setAccessible(true);
        field.set(subjectEntity, 55);
        final int result = subjectEntity.getId();
        Assert.assertEquals(result, 55, "Field wasn't retrieved properly");
        Assert.assertNotEquals(result, 53, "Field was retrieved properly");
    }

    @Test(groups = { "functest" })
    public void testNameSetter() throws NoSuchFieldException, IllegalAccessException {
        final SubjectEntity subjectEntity = new SubjectEntity();
        subjectEntity.setName("Math");
        final Field field = subjectEntity.getClass().getDeclaredField("name");
        field.setAccessible(true);
        Assert.assertEquals(field.get(subjectEntity), "Math", "Fields didn't match");
        Assert.assertNotEquals(field.get(subjectEntity), "Algebra", "Fields match");
    }

    @Test(groups = { "functest" })
    public void testNameGetter() throws NoSuchFieldException, IllegalAccessException {
        final SubjectEntity subjectEntity = new SubjectEntity();
        final Field field = subjectEntity.getClass().getDeclaredField("name");
        field.setAccessible(true);
        field.set(subjectEntity, "English");
        final String result = subjectEntity.getName();
        Assert.assertEquals(result, "English", "Field wasn't retrieved properly");
        Assert.assertNotEquals(result, "British", "Field was retrieved properly");
    }

    @Test(groups = { "functest" })
    public void testDescriptionSetter() throws NoSuchFieldException, IllegalAccessException {
        final SubjectEntity subjectEntity = new SubjectEntity();
        subjectEntity.setDescription("Subject is from 5th grade");
        final Field field = subjectEntity.getClass().getDeclaredField("description");
        field.setAccessible(true);
        Assert.assertEquals(field.get(subjectEntity),
                "Subject is from 5th grade", "Fields didn't match");
        Assert.assertNotEquals(field.get(subjectEntity),
                "Subject is from 8th grade", "Fields match");
    }

    @Test(groups = { "functest" })
    public void testDescriptionGetter() throws NoSuchFieldException, IllegalAccessException {
        final SubjectEntity subjectEntity = new SubjectEntity();
        final Field field = subjectEntity.getClass().getDeclaredField("description");
        field.setAccessible(true);
        field.set(subjectEntity, "Subject has 2 teachers");
        final String result = subjectEntity.getDescription();
        Assert.assertEquals(result, "Subject has 2 teachers", "Field wasn't retrieved properly");
        Assert.assertNotEquals(result, "Subject has 3 teachers", "Field was retrieved properly");
    }

    @Test(groups = { "checkintest" })
    public void testToString() {
        final SubjectEntity subjectEntity = new SubjectEntity();
        String toString = subjectEntity.toString();
        Assert.assertTrue(toString.contains("id=" + subjectEntity.getId()));
    }

    @Test(groups = { "functest", "checkintest" })
    public void testClassEntity1() {
        final SubjectEntity subjectEntity = new SubjectEntity();
        Assert.assertEquals(0, subjectEntity.getId());
        Assert.assertNull(subjectEntity.getDescription());
    }

    @Test(groups = { "functest", "checkintest" })
    public void testClassEntity2() {
        final SubjectEntity subjectEntity = new SubjectEntity("Algebra",
                "Subject is from 5th grade");
        Assert.assertEquals("Algebra", subjectEntity.getName());
        Assert.assertNotEquals(null, subjectEntity.getDescription());
    }

    @Test(groups = { "functest", "checkintest" })
    public void testClassEntity3() {
        final SubjectEntity subjectEntity = new SubjectEntity(1, "Astronomy",
                "Subject is from 10th grade");
        Assert.assertEquals("Astronomy", subjectEntity.getName());
        Assert.assertEquals(1, subjectEntity.getId());
        Assert.assertNotEquals(null, subjectEntity.getDescription());
    }
}
