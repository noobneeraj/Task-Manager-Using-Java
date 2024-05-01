import java.time.LocalDate; // we are use to store the user entered string as LocalDate type



//This is Task class used to set the Task Information

public class Task 

{

	int id;

    //String Uname,TaskName,Priority;

    String Uname,TaskName,pname;

    LocalDate starDate,dueDate;

//    public Task(int id,String Uname,String TaskName,LocalDate sDate,LocalDate dueDate,String Priority)  // constructor used to set the values of TaskName, Uname,id,priority and strat,due date

//    {

//        this.id=id;

//        this.Uname=Uname;

//        this.TaskName=TaskName;

//        this.starDate=sDate;

//        this.dueDate=dueDate;

//        this.Priority=Priority;

//    }

    

    public Task(int id, String Uname, String TaskName, LocalDate sDate, LocalDate dueDate, String pname) {

    	this.id = id;

    	this.Uname = Uname;

    	this.TaskName = TaskName;

    	this.starDate = sDate;

    	this.dueDate = dueDate;

    	this.pname = pname;

    }

    

  //these are the getter and setter methods used get and set the values

    public int getId() {

        return id;

    }

    

	public void setId(int id) {

        this.id = id;

    }

    public String getUname() {

        return Uname;

    }

    public void setUname(String uname) {  

        Uname = uname;

    }

    public String getTaskName() {

        return TaskName;

    }

    public void setTaskName(String taskName) {

        TaskName = taskName;

    }

//    public String getPriority() {

//        return Priority;

//    }

//    public void setPriority(String priority) {

//        Priority = priority;

//    }

    

    public String getPname() {

		return pname;

	}



	public void setPname(String pname) {

		this.pname = pname;

	}

    

    public LocalDate getStarDate() {

        return starDate;

    }

    



	public void setStarDate(LocalDate starDate) {

        this.starDate = starDate;

    }

    public LocalDate getDueDate() {

        return dueDate;

    }

    public void setDueDate(LocalDate dueDate) {

        this.dueDate = dueDate;

    }

    

}
