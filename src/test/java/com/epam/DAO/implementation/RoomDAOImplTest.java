package com.epam.DAO.implementation;

import com.epam.model.RoomEntity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class RoomDAOImplTest {
    private RoomDAOImpl roomDAO;
    public RoomEntity roomEntity1, roomEntity2, roomEntity3, roomEntity4, roomEntity5;
    private static Logger logger = LogManager.getLogger();

    @Before
    public void createEntities() {
        roomEntity1 = new RoomEntity(1, "102A", "Room has 2 windows");
        roomEntity2 = new RoomEntity(16, "202", "Room has 3 windows");
        roomEntity3 = new RoomEntity(22, "127", "Room has 3 windows");
        roomEntity4 = new RoomEntity(10, "213B", "Room has 5 windows");
        roomEntity5 = new RoomEntity(2, "003A", "Room has 0 windows");
    }

    @Test
    public void testCreate() throws SQLException {
        roomDAO = new RoomDAOImpl();
        roomDAO.create(roomEntity2);
        roomDAO.create(roomEntity5);
        printAddedEntity(roomEntity2);
        printAddedEntity(roomEntity5);
        assertNull("Room wasn't created", roomDAO.readById(roomEntity1.getId()));
        assertNotNull("Room was created", roomDAO.readById(roomEntity5.getId()));
        assertEquals("Room wasn't created properly", roomDAO.readById(roomEntity2.getId())
                .getNumber(), "202");
        assertNotEquals("Room was created properly", roomDAO.readById(roomEntity5.getId())
                .getNumber(), "102B");
    }

    @Test
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
        assertEquals("Room wasn't updated properly", roomDAO.readById(roomEntity3.getId())
                .getNumber(), "127A");
        assertNotEquals("Room wasn't updated properly", roomDAO.readById(roomEntity3.getId())
                .getNumber(), "127");
        assertEquals("Room wasn't updated properly", roomDAO.readById(roomEntity4.getId())
                .getDescription(), "Room has 0 windows");
        assertNotEquals("Room wasn't updated properly", roomDAO.readById(roomEntity4.getId())
                .getDescription(), "Room has 5 windows");
    }

    @Test
    public void testDelete() throws SQLException {
        roomDAO = new RoomDAOImpl();
        roomDAO.create(roomEntity1);
        roomDAO.create(roomEntity2);
        printAddedEntity(roomEntity1);
        printAddedEntity(roomEntity2);
        roomDAO.delete(roomEntity1.getId());
        logger.info("Room with id = " + roomEntity1.getId() + " was deleted.");
        assertNull("Room wasn't deleted", roomDAO.readById(roomEntity1.getId()));
        assertNotNull("Room was deleted", roomDAO.readById(roomEntity2.getId()));
    }

    @Test
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
        assertEquals("Room wasn't read properly", entityRead1.getId(), 1);
        assertNotEquals("Room wasn't read properly", entityRead2.getId(), 111);
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
