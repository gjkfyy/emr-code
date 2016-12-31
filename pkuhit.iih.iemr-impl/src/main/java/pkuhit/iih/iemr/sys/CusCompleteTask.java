package pkuhit.iih.iemr.sys;

public class CusCompleteTask
{
    private String taskPk;
    
    private TaskModel[] taskArray;

    public String getTaskPk()
    {
        return taskPk;
    }

    public void setTaskPk(String taskPk)
    {
        this.taskPk = taskPk;
    }

    public TaskModel[] getTaskArray()
    {
        return taskArray;
    }

    public void setTaskArray(TaskModel[] taskArray)
    {
        this.taskArray = taskArray;
    }
}
