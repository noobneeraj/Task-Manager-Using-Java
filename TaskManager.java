import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class TaskManager {

	static Scanner sc = new Scanner(System.in); // Used to take input

	DateFormat formatter = new SimpleDateFormat("yyyy-mm-dd"); // Used to set the date format
	int mid = 0;
	ArrayList<Task> TaskList = new ArrayList<Task>(); // this array list store the Task information as Task class type

	boolean validDate(String[] s) // this function check for the valid date
	{

        if (Integer.parseInt(s[0]) != Calendar.getInstance().get(Calendar.YEAR) || (Integer.parseInt(s[1]) <= 0 || Integer.parseInt(s[1]) > 12) || (Integer.parseInt(s[2]) < 0 || Integer.parseInt(s[2]) > 31)) {
        
            return false;

        } else {

        return true;

        }

	}

	void addTask() // This Function add task
	{

	mid++;
	sc.nextLine();
	String name = "";
	boolean isNameValid = false;
	while (!isNameValid) {
        System.out.print("Enter name of the user: ");

        if (sc.hasNextLine()) {

            name = sc.nextLine().trim();
            if (!name.isEmpty() && name.matches("[a-zA-Z ]+")) {
                
                isNameValid = true;

            } else {

            System.out.println("Invalid input. Please enter a valid name.");

            }

        }

    }


    String taskName = "";
    boolean isValid = false;
    while (!isValid) {

        System.out.print("Enter name of the task: ");
        if (sc.hasNextLine()) {

            taskName = sc.nextLine().trim();

            if (!taskName.isEmpty() && taskName.matches("[a-zA-Z ]+")) {

            isValid = true;

            } else {

            System.out.println("Invalid input. Please enter a valid name.");

            }

        }

    }
    LocalDate sd=LocalDate.now();
    LocalDate dd=LocalDate.now();
    boolean valid=true;
        
    while (valid) {
        System.out.println("Enter the Starting Date of Task. (yyyy-mm-dd) : ");

        String sdate = sc.nextLine().trim();

        if (validDate(sdate.split("-")) == false) {

            System.out.println("Enter Valid Date");

            return;

        }

        sd = LocalDate.parse(sdate);
        System.out.println("Enter the Due Date of Task. (yyyy-mm-dd) : ");
        String duedate = sc.nextLine().trim();
        if (validDate(duedate.split("-")) == false) {

            System.out.println("Enter Valid Date");

            return;

        }

        dd = LocalDate.parse(duedate);
        if(dd.compareTo(sd)<0)
        {
            System.out.println("Enter the Valid Date");
        }
        else{
            valid=false;
        }
    }
        
    String pname = "low || High";
    boolean isPriorityValid = false;
    while (!isPriorityValid) {

        System.out.print("Enter your priority(low or High): ");
        if (sc.hasNextLine()) {

            pname = sc.nextLine().trim();

            if (!pname.isEmpty() && pname.matches("[lowhighLowHigh ]+")) {

            isPriorityValid = true;

            } else {

            System.out.println("Invalid input, Please enter a valid priority name.");

            }

        }

	}

	Task t1 = new Task(mid, name, taskName, sd, dd, pname);

	TaskList.add(t1);

    }






	


    void UpdateTask() // This function Update the task
	{
	System.out.println("Enter the User ID: ");
	int id = sc.nextInt();
	System.out.println("1.User Name\n2.Task Name\n3.Start Date\n4.DueDate\n5.Priority");
	System.out.println("What do you want to update Enter Your Choice: ");

	int ch = sc.nextInt();
    int flag=0;
	for (int j = 0; j < TaskList.size(); j++) {

        if (TaskList.get(j).id == id) {
            flag=1;

        switch (ch) {

        case 1:

        sc.nextLine();

        String name = "";

        boolean isNameValid = false;

        while (!isNameValid) {

        System.out.println("Enter new name of the user: ");

        if (sc.hasNextLine()) {

        name = sc.nextLine().trim();

        if (!name.isEmpty() && name.matches("[a-zA-Z ]+")) {

        isNameValid = true;

        } else {

        System.out.println("Invalid input. Please enter a valid name.");

        }

        }

	    }

        TaskList.get(j).Uname = name;

        break;

        // sc.nextLine();



        case 2:

        sc.nextLine();

        String taskName = "";

        boolean isValid = false;



        while (!isValid) {

        System.out.println("Enter new name of the task: ");

        if (sc.hasNextLine()) {

        taskName = sc.nextLine().trim();

        if (!taskName.isEmpty() && taskName.matches("[a-zA-Z ]+")) {

        isValid = true;

        } else {

        System.out.println("Invalid input. Please enter a valid name.");

        }

        }

        }

        TaskList.get(j).TaskName = taskName;

        break;
        
        case 3:
        System.out.println("Enter the new Starting Date of Task. (yyyy-mm-dd) : ");
        String sdate = sc.nextLine().trim();

        sdate.trim();

        if (validDate(sdate.split("-")) == false) {
            System.out.println("Enter Valid Date");
            return;

        }
        LocalDate sd = LocalDate.parse(sdate);
        TaskList.get(j).starDate = sd;
        break;

        case 4:

        System.out.println("Enter the new Due Date of Task. (yyyy-mm-dd) : ");

        String duedate = sc.nextLine().trim();

        if (validDate(duedate.split("-")) == false) {

            System.out.println("Enter Valid Date");

            return;

        }

        LocalDate dd = LocalDate.parse(duedate);
        TaskList.get(j).dueDate = dd;
        break;

        case 5:
        sc.nextLine();
        String pname = "low || High";
        boolean isPriorityValid = false;
        while (!isPriorityValid) {

            System.out.print("Enter your priority(low or High): ");

            if (sc.hasNextLine()) {

            pname = sc.nextLine().trim();

            if (!pname.isEmpty() && pname.matches("[lowhighLowHigh ]+")) {

            isPriorityValid = true;

            } else {

            System.out.println("Invalid input, Please enter a valid priority name.");

            }

            }

        }
        TaskList.get(j).pname = pname;
        break;

        default:
        System.out.println("Invalid Choice!");
        break;
        }

        }

	}

	if(flag==0) {

	System.out.println("Id does not exists");

	return;

	}



	

	}



	void RemoveTask() // This Function remove/delete the task for tasklist

	{
        if(TaskList.isEmpty())
        {
            System.out.println("Task list is empty");
            return;
        }
        
	System.out.println("Enter the User ID: ");

	int id = sc.nextInt();

	// System.out.println("Enter the Task Name: ");

	// sc.nextLine();

	int flag=0;

	for (int j = 0; j < TaskList.size(); j++) {

	if (TaskList.get(j).id == id) {

        flag=1;

	TaskList.remove(j);
    for(int k=j;k<TaskList.size();k++)
    {
        TaskList.get(k).id=TaskList.get(k).id-1;
    }
    mid--;

	}

	}

	 if(flag==0) {

	System.out.println("Id does not exists");

	return;

	}

    

	

	}



	public void Display() // This function is used to Display the task list

	{

	System.out.println("\nID \t Uname \t\t Task Name \t\t Start Date \t\t Due Date \t\t Priority");

	for (int j = 0; j < TaskList.size(); j++) {



	System.out.println(TaskList.get(j).id + "\t" + TaskList.get(j).Uname + "\t\t" + TaskList.get(j).TaskName

	+ "\t\t" + TaskList.get(j).starDate + "\t\t" + TaskList.get(j).dueDate + "\t\t"

	+ TaskList.get(j).pname);



	}



	System.out.println(

	"****************************************||***************************||**********************************");

	}



	public static void main(String[] args) {



	TaskManager t = new TaskManager();

	while (true) {

	System.out.println("\n1.Add Task\n2.Update Task\n3.Remove Task\n4.Display Task\n5.Exit");

	System.out.println("Enter your Choice from 1-5: ");

	int c = sc.nextInt();

	switch (c) {

	case 1:

	t.addTask();

	System.out.println("Task Added Successfully");
    System.out.println(

	"****************************************||***************************||**********************************");

	break;



	case 2:

	t.UpdateTask();

	System.out.println("Task Updated Successfully");
    System.out.println(

	"****************************************||***************************||**********************************");

	break;



	case 3:

	t.RemoveTask();

	System.out.println("Task Removed Successfully");
    System.out.println(

	"****************************************||***************************||**********************************");

	break;



	case 4:

	t.Display();
    System.out.println(

	"****************************************||***************************||**********************************");

	break;



	case 5:

	System.out.println("Successfully Existed");

	System.exit(0);

	break;



	default:

	System.out.println("Invalid Choice!");

	break;

	}

	}

	}

}