import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 *  Test class for Doubly Linked List
 *
 *  @author  
 *  @version 13/10/16 18:15
 */
@RunWith(JUnit4.class)
public class DoublyLinkedListTest
{
    //~ Constructor ........................................................
    @Test
    public void testConstructor()
    {
      new DoublyLinkedList<Integer>();
    }

    //~ Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * Check if the insertBefore works
     */
    @Test
    public void testInsertBefore()
    {
        // test non-empty list
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);

        testDLL.insertBefore(0,4);
        assertEquals( "Checking insertBefore to a list containing 3 elements at position 0", "4,1,2,3", testDLL.toString() );
        testDLL.insertBefore(1,5);
        assertEquals( "Checking insertBefore to a list containing 4 elements at position 1", "4,5,1,2,3", testDLL.toString() );
        testDLL.insertBefore(2,6);       
        assertEquals( "Checking insertBefore to a list containing 5 elements at position 2", "4,5,6,1,2,3", testDLL.toString() );
        testDLL.insertBefore(-1,7);        
        assertEquals( "Checking insertBefore to a list containing 6 elements at position -1 - expected the element at the head of the list", "7,4,5,6,1,2,3", testDLL.toString() );
        testDLL.insertBefore(7,8);        
        assertEquals( "Checking insertBefore to a list containing 7 elemenets at position 8 - expected the element at the tail of the list", "7,4,5,6,1,2,3,8", testDLL.toString() );
        testDLL.insertBefore(700,9);        
        assertEquals( "Checking insertBefore to a list containing 8 elements at position 700 - expected the element at the tail of the list", "7,4,5,6,1,2,3,8,9", testDLL.toString() );

        // test empty list
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);        
        assertEquals( "Checking insertBefore to an empty list at position 0 - expected the element at the head of the list", "1", testDLL.toString() );
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(10,1);        
        assertEquals( "Checking insertBefore to an empty list at position 10 - expected the element at the head of the list", "1", testDLL.toString() );
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(-10,1);        
        assertEquals( "Checking insertBefore to an empty list at position -10 - expected the element at the head of the list", "1", testDLL.toString() );
    }

    // TODO: add more tests here. Each line of code in DoublyLinkedList.java should
    // be executed at least once from at least one test.
    @Test
    public void testIsEmpty()
    {
        // test non-empty list
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
	testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);

	assertFalse("Checking isEmpty for a list containing 3 elements - expecting false", testDLL.isEmpty());

	// test empty list
        testDLL = new DoublyLinkedList<Integer>();

	assertTrue("Checking isEmpty for an empty list - expecting true", testDLL.isEmpty());

    }
    @Test
    public void testGet()
    {
	// test non-empty list
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
	testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);

        assertEquals( "Checking get from a list containing 3 elements at position 0", 1, (int)testDLL.get(0) );
        assertEquals( "Checking get from a list containing 3 elements at position 1", 2, (int)testDLL.get(1) );
        assertEquals( "Checking get from a list containing 3 elements at position 2", 3, (int)testDLL.get(2) );
        assertNull( "Checking get from a list containing 3 elements at position 10 - expecting null ", testDLL.get(10));
        assertNull( "Checking get from a list containing 3 elements at position -10 - expecting null ", testDLL.get(-10));

	// test empty list
        testDLL = new DoublyLinkedList<Integer>();
        assertNull( "Checking get from an empty list at position 0 - expecting null ", testDLL.get(0));
        assertNull( "Checking get from an empty list at position 10 - expecting null ", testDLL.get(10));
        assertNull( "Checking get from an empty list at position -10 - expecting null ", testDLL.get(-10));

    }
    @Test
    public void testDeleteAt()
    {
	// test non-empty list
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
	testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);
        testDLL.insertBefore(3,4);
        testDLL.insertBefore(4,5);

	boolean deleted = testDLL.deleteAt(2);
        assertEquals( "Checking deleteAt to a list containing 5 elements at position 2", "1,2,4,5", testDLL.toString() );
	assertTrue( "Checking the return value of deleteAt - expecting true ", deleted );
	deleted = testDLL.deleteAt(0);
        assertEquals( "Checking deleteAt to a list containing 4 elements at position 0", "2,4,5", testDLL.toString() );
	assertTrue( "Checking the return value of deleteAt - expecting true ", deleted );
	deleted = testDLL.deleteAt(2);
        assertEquals( "Checking deleteAt to a list containing 3 elements at position 2", "2,4", testDLL.toString() );
	assertTrue( "Checking the return value of deleteAt - expecting true ", deleted );
	deleted = testDLL.deleteAt(10);
        assertEquals( "Checking deleteAt from a list containing 3 elements at position 10 - expecting no change", "2,4", testDLL.toString() );
	assertFalse( "Checking the return value of deleteAt - expecting false ", deleted );
	deleted = testDLL.deleteAt(-10);
        assertEquals( "Checking deleteAt from a list containing 3 elements at position -10 - expecting no change", "2,4", testDLL.toString() );
	assertFalse( "Checking the return value of deleteAt - expecting false ", deleted );

	// test empty list
        testDLL = new DoublyLinkedList<Integer>();
	deleted = testDLL.deleteAt(0);
	assertEquals( "Checking deleteAt to an empty list at position 0", "", testDLL.toString() );
	assertFalse( "Checking the return value of deleteAt - expecting false ", deleted );
	deleted = testDLL.deleteAt(10);
        assertEquals( "Checking deleteAt from an empty list at position 10 - expecting no change", "", testDLL.toString() );
	assertFalse( "Checking the return value of deleteAt - expecting false ", deleted );
	deleted = testDLL.deleteAt(-10);
        assertEquals( "Checking deleteAt from a list containing 3 elements at position -10 - expecting no change", "", testDLL.toString() );
	assertFalse( "Checking the return value of deleteAt - expecting false ", deleted );

    }
    @Test
    public void testReverse()
    {
	// test non-empty list
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
	testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);
        testDLL.insertBefore(3,4);
        testDLL.insertBefore(4,5);
	
	testDLL.reverse();
        assertEquals( "Checking reverse to a list containing 5 elements", "5,4,3,2,1", testDLL.toString() );

	// test empty list
	testDLL = new DoublyLinkedList<Integer>();
	testDLL.reverse();
        assertEquals( "Checking reverse to an empty list", "", testDLL.toString() );

    }
    @Test
    public void testMakeUnique()
    {
	// test non-empty list
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
	testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,1);
        testDLL.insertBefore(3,2);
        testDLL.insertBefore(4,2);

	testDLL.makeUnique();
        assertEquals( "Checking makeUnique to a list containing 5 elements", "1,2", testDLL.toString() );
	
	// test empty list
	testDLL = new DoublyLinkedList<Integer>();

	testDLL.makeUnique();
        assertEquals( "Checking makeUnique to an empty list", "", testDLL.toString() );

    }
    @Test
    public void testPush()
    {
	// test non-empty list
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
	testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);

	testDLL.push(4);
        assertEquals( "Checking push to a list containing 3 elements", "4,1,2,3", testDLL.toString() );

	// test empty list
	testDLL = new DoublyLinkedList<Integer>();

	testDLL.push(4);
        assertEquals( "Checking push to an empty list", "4", testDLL.toString() );

    }
    @Test
    public void testPop()
    {
	// test non-empty list
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
	testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);

	int poppedValue = testDLL.pop();
        assertEquals( "Checking pop from a list containing 3 elements", "2,3", testDLL.toString() );
	assertEquals( "Checking value of poppedValue - expecting 1", 1, poppedValue );
	
	// test empty list
	testDLL = new DoublyLinkedList<Integer>();

	testDLL.pop();
        assertEquals( "Checking pop from an empty list", "", testDLL.toString() );
        assertNull( "Checking value of poppedValue - expecting null ", testDLL.pop());

    }
    @Test
    public void testEnqueue()
    {
	// test non-empty list
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
	testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);

	testDLL.enqueue(4);
        assertEquals( "Checking enqueue to a list containing 3 elements", "1,2,3,4", testDLL.toString() );
	
	// test empty list
	testDLL = new DoublyLinkedList<Integer>();

	testDLL.enqueue(4);
        assertEquals( "Checking enqueue to an empty list", "4", testDLL.toString() );
    }
    @Test
    public void testDequeue()
    {
	// test non-empty list
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
	testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);

	int dequeuedValue = testDLL.dequeue();
        assertEquals( "Checking dequeue from a list containing 3 elements", "2,3", testDLL.toString() );
	assertEquals( "Checking value of dequeedValue - expecting 1", 1, dequeuedValue );
	
	// test empty list
	testDLL = new DoublyLinkedList<Integer>();

	testDLL.dequeue();
        assertEquals( "Checking dequeue from an empty list", "", testDLL.toString() );
        assertNull( "Checking value of dequeuedValue - expecting null ", testDLL.pop());

    }

}

