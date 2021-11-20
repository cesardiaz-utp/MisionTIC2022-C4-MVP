package co.com.cesardiaz.misiontic.mytask.view.dto;

import java.util.Objects;

public class TaskItem {
    private String description;
    private String date;
    private TaskState state;

    public TaskItem(String description, String date) {
        this.description = description;
        this.date = date;
        this.state = TaskState.PENDING;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    public TaskState getState() {
        return state;
    }

    public void setState(TaskState state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskItem taskItem = (TaskItem) o;
        return description.equals(taskItem.description) && date.equals(taskItem.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, date);
    }
}
