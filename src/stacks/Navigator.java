/**
 * Tuba Siddiqui
 * CS1C
 * Provides three navigation options where the user can:
 * 1. Set the current link via setCurrentLink(linkName) method.
 * 2. Replace the current link by going back one link via goBack() method.
 * 3. Replace the current link by going forward one link via goForward() method.
 **/

package stacks;

import java.util.*;

/**
 * create two objects of type StackList
 */
//Define the new class type: Navigator which creates two objects of type StackList class
public class Navigator {
    //Attributes:
    /**
     * returns currentLink
     */
    //The current webpage the user is viewing
    private String currentLink;

    /**
     * Stacks for back button links and forward links
     */
    //Two stacks: one for "Back" button links; another for "Forward" button links
    private StackList<String> backLinks;
    private StackList<String> forwardLinks;

    boolean myString = true; // keeps track of whether it is the first string or not

    //Methods:
    //Define the constructor of Navigator class so that it sets the currentLink to the empty String and
    //initializes two objects of type StackList(name) called backLinks and forwardLinks.

    /**
     * constructor that initializes variables
     */
    Navigator() {
        //initialize String currentLink to an empty string
        currentLink = "";
        //initialize backLinks
        backLinks = new StackList<String>();
        //initialize forwardLinks
        forwardLinks = new StackList<String>();
    }

    //setCurrentLink() which takes an object of type String​ for the current requested link and
    //updates the backLinks and forwardLinks stacks.
    //Sets currentLink to the supplied link address. Places the old currentLink on the
    //backLinks stack. Then, clears the forwardLinks stack.sets current link

    /**
     * update backLinks and forwardLinks stacks
     * @param currentLink  set to supplied link address
     */
    public void setCurrentLink(String currentLink) {
        if (myString == true) {
            this.currentLink = currentLink; //set currentLink to supplied address
            myString = false;

        } else {
            this.currentLink = currentLink;
            backLinks.push(this.currentLink); //Place old currentLink on backLinks stack
            forwardLinks.clear(); //clears the forwardLinks stack.sets current link
        }
    }

    //goBack() and goForward() which update the currentLink to the link at the top of the backLinks
    //stack or forwardLinks stack respectively
    //If there is a link on the backLinks stack, goes to the top link on the
    //backLinks stack. Pushes the old currentLink onto the forwardLinks stack.
    //Remember to check for boundary conditions

    /**
     * update currentLink to link at top of stack
     */
    public void goBack() {
        //check if there is a link on the backLinks stack
        //if there is no link
        if (backLinks.isEmpty() == true) {
            System.out.print("No links on stack");
        } else {
            //push old currentLink onto forwardLinks stack
            forwardLinks.push(currentLink);
            this.currentLink = backLinks.pop();
        }

    }

    ///If there is a link on the forwardLinks stack, goes to the top link on the forwardLinks stack.
    //Pushes the old currentLink onto the backLinks stack.
    //Remember to check for boundary conditions.

    /**
     * go to top link of forward stack
     */
    public void goForward() {
        //check if there is a link on the forwardLinks stack using isEmpty() method
        //if there is no link
        if (forwardLinks.isEmpty() == true) {
            System.out.print("No links on stack");
        } else {
            //push old currentLink onto backLinks stack
            backLinks.push(currentLink);
            this.currentLink = forwardLinks.pop();
        }

    }

    //Accessor methods for the class attributes
    //The accessor method for the String representation of the currentLink

    /**
     *
     * @return return current weblink
     */
    public String getCurrentLink() {
        return currentLink;
    }

    //The accessor method for the entire backLinks stack

    /**
     *
     * @return return backLinks stack
     */
    public StackList<String> getBackLinks() {
        return backLinks;
    }

    //The accessor method for the entire forwardLinks stack

    /**
     *
     * @return return forwardLinks stack
     */
    public StackList<String> getForwardLinks() {
        return forwardLinks;
    }

}
