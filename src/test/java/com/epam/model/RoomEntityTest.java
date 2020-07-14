package com.epam.model;

import org.junit.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.*;

public class RoomEntityTest {
    @Test
    public void testIdSetter() throws NoSuchFieldException, IllegalAccessException {
        final RoomEntity roomEntity = new RoomEntity();
        roomEntity.setId(101);
        final Field field = roomEntity.getClass().getDeclaredField("id");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(roomEntity), 101);
        assertNotEquals("Fields match", field.get(roomEntity), 111);
    }

    @Test
    public void testIdGetter() throws NoSuchFieldException, IllegalAccessException {
        final RoomEntity roomEntity = new RoomEntity();
        final Field field = roomEntity.getClass().getDeclaredField("id");
        field.setAccessible(true);
        field.set(roomEntity, 55);
        final int result = roomEntity.getId();
        assertEquals("Field wasn't retrieved properly", result, 55);
        assertNotEquals("Field was retrieved properly", result, 53);
    }

    @Test
    public void testNumberSetter() throws NoSuchFieldException, IllegalAccessException {
        final RoomEntity roomEntity = new RoomEntity();
        roomEntity.setNumber("102D");
        final Field field = roomEntity.getClass().getDeclaredField("number");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(roomEntity), "102D");
        assertNotEquals("Fields match", field.get(roomEntity), "102");
    }

    @Test
    public void testNumberGetter() throws NoSuchFieldException, IllegalAccessException {
        final RoomEntity roomEntity = new RoomEntity();
        final Field field = roomEntity.getClass().getDeclaredField("number");
        field.setAccessible(true);
        field.set(roomEntity, "403");
        final String result = roomEntity.getNumber();
        assertEquals("Field wasn't retrieved properly", result, "403");
        assertNotEquals("Field was retrieved properly", result, "403A");
    }

    @Test
    public void testDescriptionSetter() throws NoSuchFieldException, IllegalAccessException {
        final RoomEntity roomEntity = new RoomEntity();
        roomEntity.setDescription("Room is situated on 3rd floor");
        final Field field = roomEntity.getClass().getDeclaredField("description");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(roomEntity), "Room is situated on 3rd floor");
        assertNotEquals("Fields match", field.get(roomEntity), "Room is situated on 2nd floor");
    }

    @Test
    public void testDescriptionGetter() throws NoSuchFieldException, IllegalAccessException {
        final RoomEntity roomEntity = new RoomEntity();
        final Field field = roomEntity.getClass().getDeclaredField("description");
        field.setAccessible(true);
        field.set(roomEntity, "Room has 15 desks");
        final String result = roomEntity.getDescription();
        assertEquals("Field wasn't retrieved properly", result, "Room has 15 desks");
        assertNotEquals("Field was retrieved properly", result, "Room has 13 desks");
    }

    @Test
    public void testToString() {
        final RoomEntity roomEntity = new RoomEntity();
        String toString = roomEntity.toString();
        assertTrue(toString.contains("id=" + roomEntity.getId()));
    }

    @Test
    public void testClassEntity1() {
        final RoomEntity roomEntity = new RoomEntity();
        assertEquals(0, roomEntity.getId());
        assertNull(roomEntity.getDescription());
    }

    @Test
    public void testClassEntity2() {
        final RoomEntity roomEntity = new RoomEntity("102B", "Room has 15 desks");
        assertEquals("102B", roomEntity.getNumber());
        assertNotEquals(null, roomEntity.getDescription());
    }

    @Test
    public void testClassEntity3() {
        final RoomEntity roomEntity = new RoomEntity(1, "118A", "Room is very cold");
        assertEquals("118A", roomEntity.getNumber());
        assertEquals(1, roomEntity.getId());
        assertNotEquals(null, roomEntity.getDescription());
    }
}
