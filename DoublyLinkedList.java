import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

// -------------------------------------------------------------------------
/**
 *  This class contains the methods of Doubly Linked List.
 *
 *  @author Neil Kilbane 
 *  @version 09/10/18 11:13:22
 */


/**
 * Class DoublyLinkedList: implements a *generic* Doubly Linked List.
 * @param <T> This is a type parameter. T is used as a class name in the
 * definition of this class.
 *
 * When creating a new DoublyLinkedList, T should be instantiated with an
 * actual class name that extends the class Comparable.
 * Such classes include String and Integer.
 *
 * For example to create a new DoublyLinkedList class containing String data: 
 *    DoublyLinkedList<String> myStringList = new DoublyLinkedList<String>();
 *
 * The class offers a toString() method which returns a comma-separated sting of
 * all elements in the data structure.
 * 
 * This is a bare minimum class you would need to completely implement.
 * You can add additional methods to support your code. Each method will need
 * to be tested by your jUnit tests -- for simplicity in jUnit testing
 * introduce only public methods.
 */
class DoublyLinkedList<T extends Comparable<T>>
{

    /**
     * private class DLLNode: implements a *generic* Doubly Linked List node.
     */
    private class DLLNode
    {
        public final T data; // this field should never be updated. It gets its
                             // value once from the constructor DLLNode.
        public DLLNode next;
        public DLLNode prev;
    
        /**
         * Constructor
         * @param theData : data of type T, to be stored in the node
         * @param prevNode : the previous Node in the Doubly Linked List
         * @param nextNode : the next Node in the Doubly Linked List
         * @return DLLNode
         */
        public DLLNode(T theData, DLLNode prevNode, DLLNode nextNode) 
        {
          data = theData;
          prev = prevNode;
          next = nextNode;
        }
    }

    // Fields head and tail point to the first and last nodes of the list.
    private DLLNode head, tail;

    /**
     * Constructor of an empty DLL
     * @return DoublyLinkedList
     */
    public DoublyLinkedList() 
    {
      head = null;
      tail = null;
    }

    /**
     * Tests if the doubly linked list is empty
     * @return true if list is empty, and false otherwise
     *
     * Worst-case asymptotic running time cost: Theta(1)
     *
     * Justification: There is only one line to execute, which has a constant running time
     *  
     */
    public boolean isEmpty()
    {
      return (this.head == null);
    }

    /**
     * Inserts an element in the doubly linked list
     * @param pos : The integer location at which the new data should be
     *      inserted in the list. We assume that the first position in the list
     *      is 0 (zero). If pos is less than 0 then add to the head of the list.
     *      If pos is greater or equal to the size of the list then add the
     *      element at the end of the list.
     * @param data : The new data of class T that needs to be added to the list
     * @return none
     *
     * Worst-case asymptotic running time cost: O(N)
     *
     * Justification:
     *  If the value of pos is 'n', the for-loop will be executed n times. We can assume that
     *  every other line has a cost of O(1), so the total cost of this method will be n*O(1) = O(N) 
     *
     */
    public void insertBefore( int pos, T data ) 
    {
      //TODO
      DLLNode newNode;
      DLLNode nextNode = this.head;
      DLLNode prevNode = null;
      for(int i = 0; i < pos; i++)
      {
        if(nextNode != null)
        {
          prevNode = nextNode;
	  nextNode = nextNode.next;
	}
      }
      newNode = new DLLNode(data, prevNode, nextNode);
      if(nextNode != null)
      {
        nextNode.prev = newNode;
      }
      else
      {
        this.tail = newNode;
      }
      if(prevNode != null)
      {
        prevNode.next = newNode;
      }
      else
      {
        this.head = newNode;
      }
      return;
    }

    /**
     * Returns the data stored at a particular position
     * @param pos : the position
     * @return the data at pos, if pos is within the bounds of the list, and null otherwise.
     *
     * Worst-case asymptotic running time cost: O(N)
     *
     * Justification:
     *  If the value of pos is 'n', the for-loop will be executed n times. We can assume that
     *  every other line has a cost of O(1), so the total cost of this method will be n*O(1) = O(N) 
     *
     */
    public T get(int pos) 
    {
      //TODO
      if(pos >= 0)
      {
        DLLNode currentNode = this.head;
        for(int i = 0; i < pos; i++)
        {
	  if(currentNode != null)
	  {
	    currentNode = currentNode.next;
	  }
        }
        if(currentNode != null)
        {
          return currentNode.data;
        }
      }
      return null;
    }

    /**
     * Deletes the element of the list at position pos.
     * First element in the list has position 0. If pos points outside the
     * elements of the list then no modification happens to the list.
     * @param pos : the position to delete in the list.
     * @return true : on successful deletion, false : list has not been modified. 
     *
     * Worst-case asymptotic running time cost: O(N)
     *
     * Justification:
     *  If the value of pos is 'n', the for-loop will be executed n times. We can assume that
     *  every other line has a cost of O(1), so the total cost of this method will be n*O(1) = O(N) 
     */
    public boolean deleteAt(int pos) 
    {
      //TODO
      boolean deleted = false;
      if(pos >= 0)
      {
        DLLNode currentNode = this.head;
        for(int i = 0; i < pos; i++)
        {
	  if(currentNode != null)
	  {
	    currentNode = currentNode.next;
	  }	
        }
        if(currentNode != null)
        {
          if(currentNode.next != null)
          {
            currentNode.next.prev = currentNode.prev;
          }
          else
          {
	    this.tail = currentNode.prev;
          }
          if(currentNode.prev != null)
          {
            currentNode.prev.next = currentNode.next;
          }
          else
          {
	    this.head = currentNode.next;
          }
          currentNode.next = null;
          currentNode.prev = null;
	  deleted = true;
        }
      }
      return deleted;
    }

    /**
     * Reverses the list.
     * If the list contains "A", "B", "C", "D" before the method is called
     * Then it should contain "D", "C", "B", "A" after it returns.
     *
     * Worst-case asymptotic running time cost: O(N)
     *
     * Justification:
     *  If the list contains 'n' elements, the while-loop will be executed n times.
     *  We can assume that every other line has a cost of O(1), so the total cost of this method will be n*O(1) = O(N)
     */
    public void reverse()
    {
      //TODO
      DLLNode currentNode = this.head;
      DLLNode tempNode;
      while(currentNode != null)
      {
	tempNode = currentNode.next;
	currentNode.next = currentNode.prev;
	currentNode.prev = tempNode;
	currentNode = currentNode.prev;
      }
      tempNode = this.head;
      this.head = this.tail;
      this.tail = tempNode;
    }

    /**
     * Removes all duplicate elements from the list.
     * The method should remove the _least_number_ of elements to make all elements uniqueue.
     * If the list contains "A", "B", "C", "B", "D", "A" before the method is called
     * Then it should contain "A", "B", "C", "D" after it returns.
     * The relative order of elements in the resulting list should be the same as the starting list.
     *
     * Worst-case asymptotic running time cost: O(N^2)
     *
     * Justification:
     *  If the list contains 'n' elements, the outer while-loop will be executed n times, and the inner while-loop
     *  will be executed n*(n-1) times.
     *  We can assume that every other line has a cost of O(1), so the total cost of this method will be n*(n-1)*O(1) = O(N^2)
     *  
     */
    public void makeUnique()
    {
      //TODO
      DLLNode currentNode = this.head;
      DLLNode otherNode;
      DLLNode nextNode;
      while(currentNode != null)
      {
	otherNode = currentNode.next;
	while(otherNode != null)
	{
	  nextNode = otherNode.next;
	  if(otherNode.data == currentNode.data)
	  {
	    if(otherNode.next != null)
      	    {
              otherNode.next.prev = otherNode.prev;
            }
            else
            {
	      this.tail = otherNode.prev;
            }
	    otherNode.prev.next = otherNode.next;
            otherNode.next = null;
            otherNode.prev = null;
	  }
	  otherNode = nextNode;
	}
	currentNode = currentNode.next;
      }
    }


    /*----------------------- STACK API 
     * If only the push and pop methods are called the data structure should behave like a stack.
     */

    /**
     * This method adds an element to the data structure.
     * How exactly this will be represented in the Doubly Linked List is up to the programmer.
     * @param item : the item to push on the stack
     *
     * Worst-case asymptotic running time cost: O(1)
     *
     * Justification:
     *  We can assume that every line has a cost of O(1), so the total cost of this method is O(1)
     */
    public void push(T item) 
    {
      //TODO
      DLLNode pushedNode = new DLLNode(item, null, this.head);
      if(!isEmpty())
      {
        this.head.prev = pushedNode;
      }
      else
      {
	this.tail = pushedNode;
      }
      this.head = pushedNode;
    }

    /**
     * This method returns and removes the element that was most recently added by the push method.
     * @return the last item inserted with a push; or null when the list is empty.
     *
     * Worst-case asymptotic running time cost: O(1)
     *
     * Justification:
     *  We can assume that every line has a cost of O(1), so the total cost of this method is O(1)
     */
    public T pop() 
    {
      //TODO
      T poppedItem = null;
      if(!isEmpty())
      {
	poppedItem = this.head.data;
	deleteAt(0);
      }
      return poppedItem;
    }

    /*----------------------- QUEUE API
     * If only the enqueue and dequeue methods are called the data structure should behave like a FIFO queue.
     */
 
    /**
     * This method adds an element to the data structure.
     * How exactly this will be represented in the Doubly Linked List is up to the programmer.
     * @param item : the item to be enqueued to the stack
     *
     * Worst-case asymptotic running time cost: O(1)
     *
     * Justification:
     *  We can assume that every line has a cost of O(1), so the total cost of this method is O(1)
     */
    public void enqueue(T item) 
    {
      //TODO
      DLLNode enqueuedNode = new DLLNode(item, this.tail, null);
      if(!isEmpty())
      {
        this.tail.next = enqueuedNode;
      }
      else
      {
	this.head = enqueuedNode;
      }
      this.tail = enqueuedNode;

    }

     /**
     * This method returns and removes the element that was least recently added by the enqueue method.
     * @return the earliest item inserted with an equeue; or null when the list is empty.
     *
     * Worst-case asymptotic running time cost: O(1)
     *
     * Justification:
     *  We can assume that every line has a cost of O(1), so the total cost of this method is O(1)
     */
    public T dequeue() 
    {
      //TODO
      T dequeuedItem = null;
      if(!isEmpty())
      {
	dequeuedItem = this.head.data;
	deleteAt(0);
      }
      return dequeuedItem;
    }
 

    /**
     * @return a string with the elements of the list as a comma-separated
     * list, from beginning to end
     *
     * Worst-case asymptotic running time cost:   Theta(n)
     *
     * Justification:
     *  We know from the Java documentation that StringBuilder's append() method runs in Theta(1) asymptotic time.
     *  We assume all other method calls here (e.g., the iterator methods above, and the toString method) will execute in Theta(1) time.
     *  Thus, every one iteration of the for-loop will have cost Theta(1).
     *  Suppose the doubly-linked list has 'n' elements.
     *  The for-loop will always iterate over all n elements of the list, and therefore the total cost of this method will be n*Theta(1) = Theta(n).
     */
    public String toString() 
    {
      StringBuilder s = new StringBuilder();
      boolean isFirst = true; 

      // iterate over the list, starting from the head
      for (DLLNode iter = head; iter != null; iter = iter.next)
      {
        if (!isFirst)
        {
          s.append(",");
        } else {
          isFirst = false;
        }
        s.append(iter.data.toString());
      }

      return s.toString();
    }


}



