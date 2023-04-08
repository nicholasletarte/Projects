/**
 * Nicholas Letarte
 * CS 5004 chapter 7 assignment key
 * This is the controller class
 */

/**
 * The controller can be thought of as an interface between the model and view
 * The controller will receive user requests from the view and process them accordingly
 * These user requests will be sent to the model for data processing
 * The processed data will be sent back to the controller and displayed on the view
 */

public class ToDoController {
    private ToDoModel model;//the controller must interact with the model
    private ToDoView view;//the controller must interact with the view

    /**
     * Constructor for the controller
     * allows the controller to interact with the model and view
     * @param model
     * @param view
     */
    public ToDoController(ToDoModel model, ToDoView view){
        this.model = model;
        this.view = view;
    }

    /**
     * allows us to set the tasks for the day
     * @param name
     */
    public void setTasksName(String[] name){
        model.setTasks(name);
    }

    /**
     * gets the tasks of the day
     * @return an array of strings
     */
    //get the name of each tasks as a List of strings
    public String[] getTaskName(){
        return model.getTasks();
    }

    /**
     * sets the number of tasks for the day
     * @param i
     */
    public void setNumTasks(int i){
        model.setNumbTasks(i);
    }

    /**
     * gets the number of tasks for the day
     * @return
     */
    public int getNumTasks(){
        int size = model.getNumbTasks();
        return size;
    }

    /**
     * We can set the day of the week
     * @param d
     */
    public void setDay(String d){
        model.setDay(d);
    }

    /**
     * We can get the day of the week
     * @return
     */
    public String getDay(){
        return model.getDay();
    }

    /**
     * This is how the controller will update the view based on the data processed from the model
     */
    public void updateView(){
        view.printTaskDetails(model.getDay(), model.getNumbTasks(), model.getTasks());
    }




}
