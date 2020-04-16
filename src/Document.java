import com.sun.javafx.tk.Toolkit;

public class Document {
    int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCred_id() {
        return cred_id;
    }

    public void setCred_id(int cred_id) {
        this.cred_id = cred_id;
    }

    String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    TaskTypes getTask_status() {
        return task_status;
    }

    void setTask_status(TaskTypes task_status) {
        this.task_status = task_status;
    }

    Document(int id, int cred_id, String task, TaskTypes task_status) {
        this.id = id;
        this.cred_id = cred_id;
        this.task = task;
        this.task_status = task_status;
    }

    private int id;
    private int cred_id;
    private String task;
    private TaskTypes task_status;
}
