package com.epam.model;

import org.junit.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.*;

public class LessonEntityTest {
    @Test
    public void testIdSetter() throws NoSuchFieldException, IllegalAccessException {
        final LessonEntity lessonEntity = new LessonEntity();
        lessonEntity.setId(101);
        final Field field = lessonEntity.getClass().getDeclaredField("id");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(lessonEntity), 101);
        assertNotEquals("Fields match", field.get(lessonEntity), 111);
    }

    @Test
    public void testIdGetter() throws NoSuchFieldException, IllegalAccessException {
        final LessonEntity lessonEntity = new LessonEntity();
        final Field field = lessonEntity.getClass().getDeclaredField("id");
        field.setAccessible(true);
        field.set(lessonEntity, 55);
        final int result = lessonEntity.getId();
        assertEquals("Field wasn't retrieved properly", result, 55);
        assertNotEquals("Field was retrieved properly", result, 53);
    }

    @Test
    public void testClassIdSetter() throws NoSuchFieldException, IllegalAccessException {
        final LessonEntity lessonEntity = new LessonEntity();
        lessonEntity.setClassID(20);
        final Field field = lessonEntity.getClass().getDeclaredField("classID");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(lessonEntity), 20);
        assertNotEquals("Fields match", field.get(lessonEntity), 21);
    }

    @Test
    public void testClassIdGetter() throws NoSuchFieldException, IllegalAccessException {
        final LessonEntity lessonEntity = new LessonEntity();
        final Field field = lessonEntity.getClass().getDeclaredField("classID");
        field.setAccessible(true);
        field.set(lessonEntity, 0);
        final int result = lessonEntity.getClassID();
        assertEquals("Field wasn't retrieved properly", result, 0);
        assertNotEquals("Field was retrieved properly", result, 1);
    }

    @Test
    public void testRoomIdSetter() throws NoSuchFieldException, IllegalAccessException {
        final LessonEntity lessonEntity = new LessonEntity();
        lessonEntity.setRoomID(20);
        final Field field = lessonEntity.getClass().getDeclaredField("roomID");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(lessonEntity), 20);
        assertNotEquals("Fields match", field.get(lessonEntity), 21);
    }

    @Test
    public void testRoomIdGetter() throws NoSuchFieldException, IllegalAccessException {
        final LessonEntity lessonEntity = new LessonEntity();
        final Field field = lessonEntity.getClass().getDeclaredField("roomID");
        field.setAccessible(true);
        field.set(lessonEntity, 0);
        final int result = lessonEntity.getRoomID();
        assertEquals("Field wasn't retrieved properly", result, 0);
        assertNotEquals("Field was retrieved properly", result, 1);
    }

    @Test
    public void testSubjectIdSetter() throws NoSuchFieldException, IllegalAccessException {
        final LessonEntity lessonEntity = new LessonEntity();
        lessonEntity.setSubjectID(20);
        final Field field = lessonEntity.getClass().getDeclaredField("subjectID");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(lessonEntity), 20);
        assertNotEquals("Fields match", field.get(lessonEntity), 21);
    }

    @Test
    public void testSubjectIdGetter() throws NoSuchFieldException, IllegalAccessException {
        final LessonEntity lessonEntity = new LessonEntity();
        final Field field = lessonEntity.getClass().getDeclaredField("subjectID");
        field.setAccessible(true);
        field.set(lessonEntity, 0);
        final int result = lessonEntity.getSubjectID();
        assertEquals("Field wasn't retrieved properly", result, 0);
        assertNotEquals("Field was retrieved properly", result, 1);
    }

    @Test
    public void testTeacherIdSetter() throws NoSuchFieldException, IllegalAccessException {
        final LessonEntity lessonEntity = new LessonEntity();
        lessonEntity.setTeacherID(20);
        final Field field = lessonEntity.getClass().getDeclaredField("teacherID");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(lessonEntity), 20);
        assertNotEquals("Fields match", field.get(lessonEntity), 21);
    }

    @Test
    public void testTeacherIdGetter() throws NoSuchFieldException, IllegalAccessException {
        final LessonEntity lessonEntity = new LessonEntity();
        final Field field = lessonEntity.getClass().getDeclaredField("teacherID");
        field.setAccessible(true);
        field.set(lessonEntity, 0);
        final int result = lessonEntity.getTeacherID();
        assertEquals("Field wasn't retrieved properly", result, 0);
        assertNotEquals("Field was retrieved properly", result, 1);
    }

    @Test
    public void testTopicSetter() throws NoSuchFieldException, IllegalAccessException {
        final LessonEntity lessonEntity = new LessonEntity();
        lessonEntity.setTopic("Squares");
        final Field field = lessonEntity.getClass().getDeclaredField("topic");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(lessonEntity), "Squares");
        assertNotEquals("Fields match", field.get(lessonEntity), "Circles");
    }

    @Test
    public void testTopicGetter() throws NoSuchFieldException, IllegalAccessException {
        final LessonEntity lessonEntity = new LessonEntity();
        final Field field = lessonEntity.getClass().getDeclaredField("topic");
        field.setAccessible(true);
        field.set(lessonEntity, "Multiply");
        final String result = lessonEntity.getTopic();
        assertEquals("Field wasn't retrieved properly", result, "Multiply");
        assertNotEquals("Field was retrieved properly", result, "Divide");
    }

    @Test
    public void testHomeworkSetter() throws NoSuchFieldException, IllegalAccessException {
        final LessonEntity lessonEntity = new LessonEntity();
        lessonEntity.setHomework("Ex. 105-108");
        final Field field = lessonEntity.getClass().getDeclaredField("homework");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(lessonEntity), "Ex. 105-108");
        assertNotEquals("Fields match", field.get(lessonEntity), "None");
    }

    @Test
    public void testHomeworkGetter() throws NoSuchFieldException, IllegalAccessException {
        final LessonEntity lessonEntity = new LessonEntity();
        final Field field = lessonEntity.getClass().getDeclaredField("homework");
        field.setAccessible(true);
        field.set(lessonEntity, "Read a poem");
        final String result = lessonEntity.getHomework();
        assertEquals("Field wasn't retrieved properly", result, "Read a poem");
        assertNotEquals("Field was retrieved properly", result, "Read a novel");
    }

    @Test
    public void testDateSetter() throws NoSuchFieldException, IllegalAccessException {
        final LessonEntity lessonEntity = new LessonEntity();
        lessonEntity.setDate("2020-07-01");
        final Field field = lessonEntity.getClass().getDeclaredField("date");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(lessonEntity), "2020-07-01");
        assertNotEquals("Fields match", field.get(lessonEntity), "01-07-2020");
    }

    @Test
    public void testDateGetter() throws NoSuchFieldException, IllegalAccessException {
        final LessonEntity lessonEntity = new LessonEntity();
        final Field field = lessonEntity.getClass().getDeclaredField("date");
        field.setAccessible(true);
        field.set(lessonEntity, "01-06-2019");
        final String result = lessonEntity.getDate();
        assertEquals("Field wasn't retrieved properly", result, "01-06-2019");
        assertNotEquals("Field was retrieved properly", result, "2019-06-01");
    }

    @Test
    public void testToString() {
        final LessonEntity lessonEntity = new LessonEntity();
        String toString = lessonEntity.toString();
        assertTrue(toString.contains("id=" + lessonEntity.getId()));
    }

    @Test
    public void testClassEntity1() {
        final LessonEntity lessonEntity = new LessonEntity();
        assertEquals(0, lessonEntity.getId());
        assertNull(lessonEntity.getDate());
    }

    @Test
    public void testClassEntity2() {
        final LessonEntity lessonEntity = new LessonEntity(1, 2, 3, 5,
                "Shevchenko poem", "Learn a poem", "2018-06-19");
        assertEquals("Learn a poem", lessonEntity.getHomework());
        assertEquals(1, lessonEntity.getClassID());
        assertNotEquals(null, lessonEntity.getTopic());
    }

    @Test
    public void testClassEntity3() {
        final LessonEntity lessonEntity = new LessonEntity(1,1, 5,9,15,
                "Squares", "Exc. 59-61", "2020-05-16");
        assertEquals("Squares", lessonEntity.getTopic());
        assertEquals(1, lessonEntity.getId());
        assertNotEquals(null, lessonEntity.getDate());
    }
}
