package co.com.cesardiaz.misiontic.mytask.presenter;

import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import co.com.cesardiaz.misiontic.mytask.model.MainInteractor;
import co.com.cesardiaz.misiontic.mytask.mvp.MainMVP;
import co.com.cesardiaz.misiontic.mytask.view.dto.TaskItem;
import co.com.cesardiaz.misiontic.mytask.view.dto.TaskState;

public class MainPresenter implements MainMVP.Presenter {

    private MainMVP.View view;
    private MainMVP.Model model;

    public MainPresenter(MainMVP.View view){
        this.view = view;
        this.model = new MainInteractor();
    }

    @Override
    public void loadTasks() {
        List<TaskItem> items = model.getTasks();

        view.showTaskList(items);
    }

    @Override
    public void addNewTask() {
        Log.i(MainPresenter.class.getSimpleName(), "Add new Task");
        String description = view.getTaskDescription();
        String date = SimpleDateFormat.getDateTimeInstance().format(new Date());

        TaskItem task = new TaskItem(description, date);
        model.saveTask(task);
        view.addTaskToList(task);
    }

    @Override
    public void taskItemClicked(TaskItem item) {
        item.setState(TaskState.DONE);

        model.updateTask(item);
        view.updateTask(item);
    }
}
