/**
 * Tuba Siddiqui
 * CS1C
 * singly linked list StackList class where we can only push() and pop()
 * items from one end of the stack (top)
 **/


package stacks;

import java.util.*;

//Define the parameterized class StackList​ using a singly linked list
//which implements Iterable

/**
 * use singly linked list implementing Iterable to push() and pop() items
 * @param <E>
 */

public class StackList<E> implements Iterable<E> {

    //Attributes
    //A variable called name of type String for the name of this instance.
    //We we will use this for testing and debugging purposes.
    /**
     *  name used to test
     */
    private String name;
    //A variable called top, which points to the top of the stack.
    //Recall that elements can be added or removed from only one end of the stack.

    /**
     * points to top of stack
     */
    private Node top;

    /**
     * number of elements in the stack
     */
    //Number of elements in a stack
    private int numStacks;

    //inner classes:
    //An inner class Node with attributes next of type Node and data of a generic type

    /**
     * inner class of type Node and data with generic type
     */
    private class Node {
        Node next;
        E item;

        /**
         * constructor for Node
         * @param data  generic item for Node class
         */

        //constructor for Node
        Node(E data) {
            item = data;
            next = null;
        }

        //included in Node class as we are printing the Node items

        /**
         * print Node items
         * @return return string from Node
         */
        public String toString() {
            String str = item.toString();
            return str;
        }
    }
    //A constructor that initializes the class all the attributes

    /**
     * constructor for class initializing variables
     */
    StackList() {
        name = "";
        top = null;
        numStacks = 0;
    }

    //A method called push() which takes a generic item as the argument
    //and adds the item to the top of the stack.

    /**
     * add item to top of stack
     * @param item  go to top of stack
     */
    public void push(E item) {
        //instantiate temp object
        //use temp to replace top item with new item but push the other item below
        //it and not just replace it
        Node temp = new Node(item);
        temp.next = top;
        top = temp;
        numStacks++;
    }

    //A method called pop() which receives no arguments and removes the item from the top of the stack.
    //This method should return the generic item popped
    //The method pop() will return silently with a null in case of an empty stack.

    /**
     * removes item from list
     * @return return generic item popped
     */
    public E pop() {

        if (isEmpty() == true)
            return null;

        else {
            Node temp = top;
            top = top.next;
            numStacks--;
            return temp.item;
        }
    }

    //A method called peek() which looks at the top of the stack and returns a generic type for the data seen at the top of the stack.
    // The item should not be removed from the top of the stack.
    //NOTE: If the stack is empty, returns null.

    /**
     * looks at top card of stack
     * @return return top card
     */
    public E peek() {
        if (isEmpty() == true)
            return null;
        else {
            Node temp = top; // create pointer to top
            return temp.item; // return pointer item
        }
    }

    //A method called clear() which discards all object references from the
    //linked-list to "empty" this StackList instance

    /**
     * discards all object references
     */
    public void clear() {
        top = null;
        numStacks = 0;
    }

    //The toString() method should include the name of the stack passed in by the Navigator class
    //in addition to the number of links in the stack.

    /**
     * print items in stack to String
     * @return prints item in stack
     */
    public String toString() {

        Node myNode;

        String printStack = "";
        for (myNode = top; myNode != null; myNode = myNode.next) {
            printStack += myNode.toString();

            if (size() > 1) {
                printStack += ", ";
            }

        }
        return printStack;
    }

    //The isEmpty() method, which checks if the top of
    //the stack is pointing to anything

    /**
     * check if top of stack is pointing to anything
     * @return true or false if stack os or isnt pointing to anything
     */

    public boolean isEmpty() {

        if(top == null){
            return true;
        }
        else{
            return false;
        }
    }

    //The size() method, which returns the number of elements in the stack.

    /**
     * size of stack
     * @return number of elements in stack
     */
    public int size() {

        return numStacks;
    }

    //The inner StackIterator parameterized class which implements an the Iterator interface

    /**
     * class to implement iterator interface
     */
    private class StackIterator implements Iterator<E> {
        private Node mCurrent = top;

        //Object next(): A method that returns the item to the immediate right (next) of the iterator,
        //and moves the iterator up one using temp

        /**
         * return next item
         * @return return item to right of iterator and moves it up one
         */
        public E next() {
            E temp = mCurrent.item;
            mCurrent = mCurrent.next;
            return temp;

        }

        //boolean hasNext(): a method that returns true if there is something in the list to
        //the immediate right of the iterator. If there is no item there, returns false

        /**
         * check if anything to right of iterator
         * @return true if there is an item to the right
         */
        public boolean hasNext() {
            if (mCurrent == null) {
                return false;
            } else {
                return true;
            }

        }

        //void remove(): This will remove the item that was most recently returned by next()
        //throw exception as test file will not use this method

        /**
         * remove recently returned item
         */
        public void remove() {

            System.out.println("no files to remove");
        }

    }

    //public class that will return the StackIterator value

    /**
     *
     * @return return StackIterator value
     */
    public Iterator<E> iterator() {
        return new StackIterator();
    }


}