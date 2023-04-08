/**
 * Nicholas Letarte
 * CS 5004
 * This is the assignment key for chapter 7.
 * This is the driver file for the MVC assignment
 * The purpose of this assignment is to make a todo list program
 */

public class Main {

    public static void main(String[] args){
        ToDoModel model = retrieveToDoFromDatabase();//database where we store our info
        ToDoView view = new ToDoView();//new view object created
        ToDoController controller = new ToDoController(model,view);//new controller object created
        controller.updateView();//controller telling view to update based on what is in our data base

        //Thinking ahead, we make a todo list for the next day, Tuesday
        //the controller will be able to update the view based on the info input below
        //the controller will send this data to the model to be processed
        controller.setDay("Tuesday");
        String[] t = {"Eat Breakfast", "Workout", "Complete more assignments","Unwind and relax"};
        controller.setTasksName(t);
        controller.setNumTasks(t.length);
        System.out.println("Tomorrows ToDo list is as follows: \n");
        controller.updateView();//The next days tasks are shown

    }
    private static ToDoModel retrieveToDoFromDatabase()
    {
        //This is our database where we store our desired data for that day
        ToDoModel m = new ToDoModel();
        m.setDay("Monday");
        //saving the days tasks to an array of strings
        String[] a = {"Eat Breakfast","Take shower","Go on a walk","Do laundry", "Finish Final"};
        //our tasks are set based on the array
        m.setTasks(a);
        //the number of tasks is based on how many strings are in our array
        m.setNumbTasks(a.length);
        return m;
    }

}
