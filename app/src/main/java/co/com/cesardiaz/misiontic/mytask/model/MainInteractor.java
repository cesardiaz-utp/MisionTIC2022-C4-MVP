package co.com.cesardiaz.misiontic.mytask.model;

import java.util.ArrayList;
import java.util.List;

import co.com.cesardiaz.misiontic.mytask.mvp.MainMVP;
import co.com.cesardiaz.misiontic.mytask.view.dto.TaskItem;

public class MainInteractor implements MainMVP.Model {

    private List<TaskItem> tempItems;

    public MainInteractor() {
        tempItems = new ArrayList<>();
        tempItems.add(new TaskItem("Do the shopping", "November 20, 2021"));
    }

    @Override
    public List<TaskItem> getTasks() {
        return new ArrayList<>(tempItems);
    }

    @Override
    public void saveTask(TaskItem task) {
        tempItems.add(task);
    }

    @Override
    public void updateTask(TaskItem item) {

    }

    @Override
    public void deleteTask(TaskItem task) {

    }
}
