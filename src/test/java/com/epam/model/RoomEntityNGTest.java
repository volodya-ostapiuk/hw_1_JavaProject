package com.epam.model;

import java.lang.reflect.Field;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RoomEntityNGTest {
    @Test(groups = { "functest" })
    public void testIdSetter() throws NoSuchFieldException, IllegalAccessException {
        final RoomEntity roomEntity = new RoomEntity();
        roomEntity.setId(101);
        final Field field = roomEntity.getClass().getDeclaredField("id");
        field.setAccessible(true);
        Assert.assertEquals(field.get(roomEntity), 101, "Fields didn't match");
        Assert.assertNotEquals(field.get(roomEntity), 111, "Fields match");
    }

    @Test(groups = { "functest" })
    public void testIdGetter() throws NoSuchFieldException, IllegalAccessException {
        final RoomEntity roomEntity = new RoomEntity();
        final Field field = roomEntity.getClass().getDeclaredField("id");
        field.setAccessible(true);
        field.set(roomEntity, 55);
        final int result = roomEntity.getId();
        Assert.assertEquals(result, 55, "Field wasn't retrieved properly");
        Assert.assertNotEquals(result, 53, "Field was retrieved properly");
    }

    @Test(groups = { "functest" })
    public void testNumberSetter() throws NoSuchFieldException, IllegalAccessException {
        final RoomEntity roomEntity = new RoomEntity();
        roomEntity.setNumber("102D");
        final Field field = roomEntity.getClass().getDeclaredField("number");
        field.setAccessible(true);
        Assert.assertEquals(field.get(roomEntity), "102D", "Fields didn't match");
        Assert.assertNotEquals(field.get(roomEntity), "102", "Fields match");
    }

    @Test(groups = { "functest" })
    public void testNumberGetter() throws NoSuchFieldException, IllegalAccessException {
        final RoomEntity roomEntity = new RoomEntity();
        final Field field = roomEntity.getClass().getDeclaredField("number");
        field.setAccessible(true);
        field.set(roomEntity, "403");
        final String result = roomEntity.getNumber();
        Assert.assertEquals(result, "403", "Field wasn't retrieved properly");
        Assert.assertNotEquals(result, "403A", "Field was retrieved properly");
    }

    @Test(groups = { "functest" })
    public void testDescriptionSetter() throws NoSuchFieldException, IllegalAccessException {
        final RoomEntity roomEntity = new RoomEntity();
        roomEntity.setDescription("Room is situated on 3rd floor");
        final Field field = roomEntity.getClass().getDeclaredField("description");
        field.setAccessible(true);
        Assert.assertEquals(field.get(roomEntity),
                "Room is situated on 3rd floor", "Fields didn't match");
        Assert.assertNotEquals(field.get(roomEntity),
                "Room is situated on 2nd floor", "Fields match");
    }

    @Test(groups = { "functest" })
    public void testDescriptionGetter() throws NoSuchFieldException, IllegalAccessException {
        final RoomEntity roomEntity = new RoomEntity();
        final Field field = roomEntity.getClass().getDeclaredField("description");
        field.setAccessible(true);
        field.set(roomEntity, "Room has 15 desks");
        final String result = roomEntity.getDescription();
        Assert.assertEquals(result, "Room has 15 desks", "Field wasn't retrieved properly");
        Assert.assertNotEquals(result, "Room has 13 desks", "Field was retrieved properly");
    }

    @Test(groups = { "checkintest" })
    public void testToString() {
        final RoomEntity roomEntity = new RoomEntity();
        String toString = roomEntity.toString();
        Assert.assertTrue(toString.contains("id=" + roomEntity.getId()));
    }

    @Test(groups = { "functest", "checkintest" })
    public void testClassEntity1() {
        final RoomEntity roomEntity = new RoomEntity();
        Assert.assertEquals(0, roomEntity.getId());
        Assert.assertNull(roomEntity.getDescription());
    }

    @Test(groups = { "functest", "checkintest" })
    public void testClassEntity2() {
        final RoomEntity roomEntity = new RoomEntity("102B", "Room has 15 desks");
        Assert.assertEquals("102B", roomEntity.getNumber());
        Assert.assertNotEquals(null, roomEntity.getDescription());
    }

    @Test(groups = { "functest", "checkintest" })
    public void testClassEntity3() {
        final RoomEntity roomEntity = new RoomEntity(1, "118A", "Room is very cold");
        Assert.assertEquals("118A", roomEntity.getNumber());
        Assert.assertEquals(1, roomEntity.getId());
        Assert.assertNotEquals(null, roomEntity.getDescription());
    }
}

