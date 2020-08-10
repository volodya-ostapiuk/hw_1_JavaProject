package com.epam.DAO.implementation;

import com.epam.model.RoomEntity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.SQLException;

public class RoomDAOImplNGTest {
    private RoomDAOImpl roomDAO;
    public RoomEntity roomEntity1, roomEntity2, roomEntity3, roomEntity4, roomEntity5;
    private static Logger logger = LogManager.getLogger();

    @BeforeClass
    public void createEntities() {
        roomEntity1 = new RoomEntity(1, "102A", "Room has 2 windows");
        roomEntity2 = new RoomEntity(16, "202", "Room has 3 windows");
        roomEntity3 = new RoomEntity(22, "127", "Room has 3 windows");
        roomEntity4 = new RoomEntity(10, "213B", "Room has 5 windows");
        roomEntity5 = new RoomEntity(2, "003A", "Room has 0 windows");
    }

    @Test(priority = 0)
    public void testCreate() throws SQLException {
        roomDAO = new RoomDAOImpl();
        roomDAO.create(roomEntity2);
        roomDAO.create(roomEntity5);
        printAddedEntity(roomEntity2);
        printAddedEntity(roomEntity5);
        Assert.assertNull(roomDAO.readById(roomEntity1.getId()), "Room wasn't created");
        Assert.assertNotNull(roomDAO.readById(roomEntity5.getId()), "Room was created");
        Assert.assertEquals(roomDAO.readById(roomEntity2.getId())
                .getNumber(), "202", "Room wasn't created properly");
        Assert.assertNotEquals(roomDAO.readById(roomEntity5.getId())
                .getNumber(), "102B", "Room was created properly");
    }

    @Test(priority = 2)
    public void testUpdate() throws SQLException {
        roomDAO = new RoomDAOImpl();
        roomDAO.create(roomEntity3);
        roomDAO.create(roomEntity4);
        printAddedEntity(roomEntity3);
        printAddedEntity(roomEntity4);
        roomEntity3.setNumber("127A");
        roomEntity4.setDescription("Room has 0 windows");
        roomDAO.update(roomEntity3);
        roomDAO.update(roomEntity4);
        printUpdatedEntity(roomEntity3);
        printUpdatedEntity(roomEntity4);
        Assert.assertEquals(roomDAO.readById(roomEntity3.getId())
                .getNumber(), "127A", "Room wasn't updated properly");
        Assert.assertNotEquals(roomDAO.readById(roomEntity3.getId())
                .getNumber(), "127", "Room wasn't updated properly");
        Assert.assertEquals(roomDAO.readById(roomEntity4.getId())
                .getDescription(), "Room has 0 windows", "Room wasn't updated properly");
        Assert.assertNotEquals(roomDAO.readById(roomEntity4.getId())
                .getDescription(), "Room has 5 windows", "Room wasn't updated properly");
    }

    @Test(priority = 4)
    public void testDelete() throws SQLException {
        roomDAO = new RoomDAOImpl();
        roomDAO.create(roomEntity1);
        roomDAO.create(roomEntity2);
        printAddedEntity(roomEntity1);
        printAddedEntity(roomEntity2);
        roomDAO.delete(roomEntity1.getId());
        logger.info("Room with id = " + roomEntity1.getId() + " was deleted.");
        Assert.assertNull(roomDAO.readById(roomEntity1.getId()), "Room wasn't deleted");
        Assert.assertNotNull(roomDAO.readById(roomEntity2.getId()), "Room was deleted");
    }

    @Test(priority = 3)
    public void testReadId() throws SQLException {
        roomDAO = new RoomDAOImpl();
        roomDAO.create(roomEntity1);
        roomDAO.create(roomEntity3);
        roomDAO.create(roomEntity5);
        printAddedEntity(roomEntity1);
        printAddedEntity(roomEntity5);
        RoomEntity entityRead1 = roomDAO.readById(roomEntity1.getId());
        RoomEntity entityRead2 = roomDAO.readById(roomEntity1.getId());
        logger.info("Room with id = " + roomEntity1.getId() + " was read.");
        logger.info("Room with id = " + roomEntity2.getId() + " was read.");
        Assert.assertEquals(entityRead1.getId(), 1, "Room wasn't read properly");
        Assert.assertNotEquals(entityRead2.getId(), 111, "Room wasn't read properly");
    }

    private void printAddedEntity(RoomEntity entity) {
        logger.info("Room with id = " + entity.getId() + ", number = " + entity.getNumber() +
                ", description = " + entity.getDescription() + "was added.");
    }

    private void printUpdatedEntity(RoomEntity entity) {
        logger.info("Room with id = " + entity.getId() + ", number = " + entity.getNumber() +
                ", description = " + entity.getDescription() + "was updated.");
    }
}
