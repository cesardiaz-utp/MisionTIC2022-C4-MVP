package co.com.cesardiaz.misiontic.mytask;

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
}
