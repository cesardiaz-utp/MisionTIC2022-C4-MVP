package co.com.cesardiaz.misiontic.mytask.presenter;

import java.util.List;

import co.com.cesardiaz.misiontic.mytask.model.MainInteractor;
import co.com.cesardiaz.misiontic.mytask.mvp.MainMVP;
import co.com.cesardiaz.misiontic.mytask.view.dto.TaskItem;

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

    }
}
