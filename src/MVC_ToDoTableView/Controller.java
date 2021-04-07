package MVC_ToDoTableView;

import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.ArrayList;

public class Controller {
    public TextField textField1;
    public DatePicker myDatePicker;
    public Button saveButton;
    public TableView myTableView;
    public TableColumn<ToDoItem, String> todoTableColumn;
    public TableColumn<ToDoItem, LocalDate> dateTableColumn;

    public void initialize() {
        // This gets called BEFORE the User ever uses the UI
        ToDoItem.setMyController(this);

        // Wire table's columns with fields in ToDoItem object
        todoTableColumn.setCellValueFactory(new PropertyValueFactory<>("todoItem"));
        dateTableColumn.setCellValueFactory(new PropertyValueFactory<>("completionDate"));
    }

    public void updateUI() {
        // Delete every item from UI
        myTableView.getItems().clear();
        // Match data in Model and UI
        ArrayList toDoList = ToDoItem.getAllMyData();
        for (Object toDoItem : toDoList) {
            myTableView.getItems().add(toDoItem);
        }
    }

    public void userSavedText() {
        String textToSave = textField1.getText();
        LocalDate dateToSave = myDatePicker.getValue();
        ToDoItem.addToDoItem(textToSave, dateToSave);
    }
}
