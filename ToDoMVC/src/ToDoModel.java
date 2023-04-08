/**
 * Nicholas Letarte
 * CS 5004
 * This is the assignment key for chapter 7.
 * This is the model class for the MVC assignment
 */


/**
 * The model holds data and defines logic of the system.
 * The model also represents the state of the application
 * The object model holds and gets the state of the model in a database
 */

public class ToDoModel {
    private String day;//input the day
    private int numbTasks;//number of tasks to finish in a day
    private String[] tasks;//the name of the tasks to accomplish stored in an array

    /**
     * gets the day of the week for us
     * @return day
     */
    public String getDay() {
        return day;
    }

    /**
     * sets the day of the week
     * @param d
     */
    public void setDay(String d) {
        this.day = d;
    }

    /**
     * Tells us how many tasks are in a day
     * @return int
     */
    public int getNumbTasks() {
        return numbTasks;
    }

    /**
     * sets the number of tasks in a day
     * @param n
     */
    public void setNumbTasks(int n) {
        this.numbTasks = n;
    }

    /**
     * Gets the tasks of the day
     * @return an array of strings
     */
    public String[] getTasks() {
        return tasks;
    }

    /**
     * Sets the tasks of the day with an array of strings
     * @param t
     */
    public void setTasks(String[] t) {
        this.tasks = t;
    }



}
