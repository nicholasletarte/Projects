/**
 * Nicholas Letarte
 * CS 5004
 * This is the assignment key for chapter 7.
 * This is the view class for the MVC assignment
 */

/**
 * This layer of MVC represents the output of the program
 * It will display data that is retrieved from the model layer by the controller
 * This allows us to visually see the data
 * All the information for the view is obtained from the controller
 */

import java.util.Arrays;
public class ToDoView {

    //code is used to print values to console for user to see
    public void printTaskDetails(String day, int numbTasks , String[] tasks){
        System.out.println("ToDo for "+day+":");
        System.out.println("Number of tasks to complete today: " + numbTasks);
        System.out.println("Tasks to do: " + Arrays.toString(tasks) + "\n");
    }


}

