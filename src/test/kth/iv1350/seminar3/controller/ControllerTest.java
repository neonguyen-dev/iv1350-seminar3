package test.kth.iv1350.seminar3.controller;

import static org.junit.Assert.*;
import org.junit.Test;

import se.kth.iv1350.seminar3.integration.DatabaseCouldNotBeFoundException;
import se.kth.iv1350.seminar3.integration.InventorySystem;
import se.kth.iv1350.seminar3.integration.ItemNotFoundException;

public class ControllerTest {
    @Test
    public void testException() {
        InventorySystem inventorydBHandler = new InventorySystem();

        //Test for DataBaseCouldNotBeFoundException
        try {
            inventorydBHandler.findItem(6);
            fail("Could find database");
        } catch (DatabaseCouldNotBeFoundException e){
            assertTrue("DatabaseCouldNotBeFoundException is caught", true);
        } catch (ItemNotFoundException e){
            
        }

        //Test for ItemNotFoundException
        try {
            inventorydBHandler.findItem(5);
            fail("Could find invalid item");
        } catch (ItemNotFoundException e) {
            assertTrue("ItemNoutFoundException is caught", true);
        } catch (DatabaseCouldNotBeFoundException e){

        }
    }
}
