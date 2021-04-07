package MVC_ToDoTableView;

import java.time.LocalDate;
import java.util.ArrayList;

// THIS IS MY UI PROGRAM'S MODEL
public class ToDoItem {
    private static Controller myController;
    private static ArrayList<ToDoItem> allMyData;
    private String todoItem;
    private LocalDate completionDate;

    public ToDoItem(String todoItem, LocalDate completionDate) {
        this.todoItem = todoItem;
        this.completionDate = completionDate;

        if (allMyData == null) {
            allMyData = new ArrayList<ToDoItem>();
        }
    }

    public static Controller getMyController() {
        return myController;
    }

    public static void setMyController(Controller myController) {
        ToDoItem.myController = myController;
    }

    public static ArrayList<ToDoItem> getAllMyData() {
        return allMyData;
    }

    public static void setAllMyData(ArrayList<ToDoItem> allMyData) {
        ToDoItem.allMyData = allMyData;
    }

    public String getTodoItem() {
        return todoItem;
    }

    public void setTodoItem(String todoItem) {
        this.todoItem = todoItem;
    }

    public LocalDate getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(LocalDate completionDate) {
        this.completionDate = completionDate;
    }

    static public void addToDoItem(String todo, LocalDate time) {
        ToDoItem newItem = new ToDoItem(todo, time);
        allMyData.add(newItem);
        myController.updateUI();
        // ?? TODO: tell the UI to update itself with the new item
    }

    public String toString() {
        String prettyDescription = new String(todoItem + " " + completionDate.getDayOfWeek());
        return prettyDescription;
    }
}
