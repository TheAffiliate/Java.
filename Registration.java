
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
/*package registration;

/**
 *
 * @author wtcyr
 */
/*public class Registration {

    /**
     * @param args the command line arguments
     */
  /*  public static void main(String[] args) {
        // TODO code application logic here
    }
    
}*/

package registration;

import javax.swing.JOptionPane;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Registration {

    private static String[] taskID;
    private static String totalHours;

    public static Boolean CheckUsername(String username) {
        boolean isValid = false;
        int validLength = 5;
        if (username.length() <= validLength) {
            if (username.contains("_")) {
                isValid = true;
            }
        }
        return isValid;
    }

    public static Boolean checkPasswordComplexity(String password) {
        boolean isValid = false;

        boolean isLength = false;
        int length = 8;
        if (password.length() >= length) {
            isLength = true;
        }
        boolean isChar = false;
        Pattern pattern = Pattern.compile("[^a-z0-9]", Pattern.CASE_INSENSITIVE);
        Matcher matches = pattern.matcher(password);
        boolean isFound = matches.find();
        if (isFound) {
            isChar = true;
        }
        boolean isNumber = false;
        boolean isUppercase = false;
        for (int i = 0; i < password.length(); i++) {
            if (Character.isDigit(password.charAt(i))) {
                isNumber = true;
            }
            if (Character.isUpperCase(password.charAt(i))) {
                isUppercase = true;
            }
        }

        if (isChar && isLength && isNumber && isUppercase) {
            isValid = true;
        }

        return isValid;
    }
 // private String[] developer1;
 // private String[] taskNames1;
 // private int[] taskID1;
 // private int[] taskDuration1;
 // private String[] taskStatus1;
 // private int currentIndex;

    private Registration() {
     //   throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String registerUser(String username, String password) {
        if (!CheckUsername(username) && checkPasswordComplexity(password)) {
            return "The username is incorrectly formatted";
        } else if (!checkPasswordComplexity(password) && CheckUsername(username)) {
            return "The password does not meet the complexity requirements.";
        } else {
            return "The conditions above have been met and the user has been registered successfully.";
        }
    }

    public boolean loginUser(String username, String password, String loginUsername, String loginPassword) {
        return username.equals(loginUsername) && password.equals(loginPassword);
    }

    public String returnloginstatus(String first, String last, String username, String password, String loginUsername,
            String loginPassword) {
        if (loginUser(username, password, loginUsername, loginPassword)) {
            return "Welcome " + first + " " + last + ", it is great to see you again";
        } else {
            return "Username or password incorrect, try again";
        }
    }

    /**
     *
     * @param args
     */
    
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Welcome to the Registration Feature");
        JOptionPane.showMessageDialog(null, "Enter your First Name: ", "Registration", JOptionPane.INFORMATION_MESSAGE);
        String FirstN = JOptionPane.showInputDialog(null, "Enter your First Name");

        JOptionPane.showMessageDialog(null, "Enter your Last Name: ", "Registration", JOptionPane.INFORMATION_MESSAGE);
        String LastN = JOptionPane.showInputDialog(null, "Enter your Last Name");

        JOptionPane.showMessageDialog(null, "Enter your Username: ", "Registration", JOptionPane.INFORMATION_MESSAGE);
        String registrationUsername = JOptionPane.showInputDialog(null, "Enter your Username");

        JOptionPane.showMessageDialog(null, "Enter your Password: ", "Registration", JOptionPane.INFORMATION_MESSAGE);
        String registrationPassword = JOptionPane.showInputDialog(null, "Enter your Password");

        Registration status = new Registration();
        boolean reg = false;
        while (!reg) {
            if (Registration.CheckUsername(registrationUsername) && Registration.checkPasswordComplexity(registrationPassword)) {
                JOptionPane.showMessageDialog(null, status.registerUser(registrationUsername, registrationPassword));
                reg = true;
                JOptionPane.showMessageDialog(null, "The username is successfully captured");
                break;
            } else {
                JOptionPane.showMessageDialog(null, "The username/password entered is incorrect");
                JOptionPane.showMessageDialog(null, "Enter your Username: ", "Registration",
                        JOptionPane.INFORMATION_MESSAGE);
                registrationUsername = JOptionPane.showInputDialog(null, "Enter your Username");
                JOptionPane.showMessageDialog(null, "Enter your Password: ", "Registration",
                        JOptionPane.INFORMATION_MESSAGE);
                registrationPassword = JOptionPane.showInputDialog(null, "Enter your Password");
            }
        }
        

        ///PART 2 POE
        
        JOptionPane.showMessageDialog(null, "Please login to your account");

        JOptionPane.showMessageDialog(null, "Enter your Username: ", "Login", JOptionPane.INFORMATION_MESSAGE);
        String loginUsername = JOptionPane.showInputDialog(null, "Enter your Username");

        JOptionPane.showMessageDialog(null, "Enter your Password: ", "Login", JOptionPane.INFORMATION_MESSAGE);
        String loginPassword = JOptionPane.showInputDialog(null, "Enter your Password");

        String loginStatus = status.returnloginstatus(FirstN, LastN, registrationUsername, registrationPassword,
                loginUsername, loginPassword);
        JOptionPane.showMessageDialog(null, loginStatus);

        JOptionPane.showMessageDialog(null, "Thank you for using the Registration Feature");
        
        JOptionPane.showMessageDialog(null, "Welcome to EasyKanban");


        if (loginUser(loginUsername, loginPassword)) {
    JOptionPane.showMessageDialog(null, "Welcome to EasyKanban");
    int option;
    
    String[] developerFirstname = null;
    String[] developerLastname = null;
    String[] taskDescription = null;
    String[] taskName = null;
    String[] taskStatus = null;
    String[] taskID = null;
    int[] taskDuration = null;

    do {
        String menu = "Select a feature:\nOption 1: Add tasks\nOption 2: Show report (Now Available)\nOption 3: Quit";
        option = Integer.parseInt(JOptionPane.showInputDialog(null, menu));

        switch (option) {
            case 1 -> {
                int taskNumber = Integer.parseInt(JOptionPane.showInputDialog(null, "How many tasks do you want to add"));

                developerFirstname = new String[taskNumber];
                developerLastname = new String[taskNumber];
                taskDescription = new String[taskNumber];
                taskName = new String[taskNumber];
                taskStatus = new String[taskNumber];
                taskID = new String[taskNumber];
                taskDuration = new int[taskNumber];

                for (int i = 0; i < taskNumber; i++) {
                    JOptionPane.showMessageDialog(null, "Task " + (i + 1));

                    taskDescription[i] = JOptionPane.showInputDialog(null, "Please enter the Task Description:");
                    while (taskDescription[i].length() > 50) {
                        JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 characters");
                        taskDescription[i] = JOptionPane.showInputDialog(null, "Please enter the Task Description:");
                    }

                    taskName[i] = JOptionPane.showInputDialog(null, "Please enter the Task Name:");

                    developerFirstname[i] = JOptionPane.showInputDialog(null, "Please enter the Developer First name:");
                    developerLastname[i] = JOptionPane.showInputDialog(null, "Please enter the Developer Last name:");

                    taskDuration[i] = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter the task duration:"));
                    returnTotalHours(taskDuration[i]);

                    taskID[i] = createTaskID(taskName[i], i, developerLastname[i]);

                    String[] statusOptions = {"To Do", "Done", "Doing"};
                    int selectedStatus = JOptionPane.showOptionDialog(null, "Please choose the task status:", "Task Status",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, statusOptions, statusOptions[0]);

                    taskStatus[i] = statusOptions[selectedStatus];

                    String taskDetails = printTaskDetails(taskStatus[i], developerFirstname[i], developerLastname[i], i, taskName[i],
                            taskDescription[i], taskID[i], taskDuration[i]);
                    JOptionPane.showMessageDialog(null, taskDetails);
                }

                JOptionPane.showMessageDialog(null, "Total hours across all tasks: " + totalHours);
            }
                /// PART 3 POE STARTS HERE, SINCE IT CONTINUES FROM PART 2.
            case 2 -> {
              
                if (developerFirstname != null && developerLastname != null && taskDescription != null && taskName != null
                        && taskStatus != null && taskID != null && taskDuration != null) {
                    // Display the Developer, Task Names, and Task Duration for all tasks with the status of done
                    StringBuilder doneTasks = new StringBuilder();
                    for (int i = 0; i < taskStatus.length; i++) {
                        if (taskStatus[i].equals("Done")) {
                            doneTasks.append("Developer: ").append(developerFirstname[i]).append(" ").append(developerLastname[i])
                                    .append(", Task Name: ").append(taskName[i]).append(", Task Duration: ").append(taskDuration[i])
                                    .append(" hours").append("\n");
                        }
                    }
                    JOptionPane.showMessageDialog(null, "Tasks with the status of done:\n" + doneTasks.toString());

                    // Display the Developer and Duration of the task with the longest duration
                    int longestDuration = 0;
                    String longestDurationDeveloper = "";
                    for (int i = 0; i < taskDuration.length; i++) {
                        if (taskDuration[i] > longestDuration) {
                            longestDuration = taskDuration[i];
                            longestDurationDeveloper = developerFirstname[i] + " " + developerLastname[i];
                        }
                    }
                    JOptionPane.showMessageDialog(null, "Task with the longest duration:\nDeveloper: "
                            + longestDurationDeveloper + ", Duration: " + longestDuration + " hours");

                    // Search for a task with a Task Name and display the Task Name, Developer, and Task Status
                    String searchTaskName = JOptionPane.showInputDialog(null, "Enter the task name to search:");
                    boolean taskFound = false;
                    for (int i = 0; i < taskName.length; i++) {
                        if (taskName[i].equalsIgnoreCase(searchTaskName)) {
                            JOptionPane.showMessageDialog(null, "Task found:\nTask Name: " + taskName[i]
                                    + "\nDeveloper: " + developerFirstname[i] + " " + developerLastname[i]
                                    + "\nTask Status: " + taskStatus[i]);
                            taskFound = true;
                            break;
                        }
                    }
                    if (!taskFound) {
                        JOptionPane.showMessageDialog(null, "Task not found.");
                    }

                    // Search for all tasks assigned to a developer and display the Task Name and Task Status
                    String searchDeveloper = JOptionPane.showInputDialog(null, "Enter the developer name to search:");
                    boolean developerFound = false;
                    StringBuilder tasksAssigned = new StringBuilder();
                    for (int i = 0; i < developerFirstname.length; i++) {
                        if (developerFirstname[i].equalsIgnoreCase(searchDeveloper)
                                || developerLastname[i].equalsIgnoreCase(searchDeveloper)) {
                            tasksAssigned.append("Task Name: ").append(taskName[i]).append(", Task Status: ").append(taskStatus[i]).append("\n");
                            developerFound = true;
                        }
                    }
                    if (developerFound) {
                        JOptionPane.showMessageDialog(null, "Tasks assigned to " + searchDeveloper + ":\n" + tasksAssigned.toString());
                    } else {
                        JOptionPane.showMessageDialog(null, "No tasks assigned to " + searchDeveloper);
                    }

                    // Delete a task using the Task Name
                    String deleteTaskName = JOptionPane.showInputDialog(null, "Enter the task name to delete:");
                    boolean taskDeleted = false;
                    for (int i = 0; i < taskName.length; i++) {
                        if (taskName[i].equalsIgnoreCase(deleteTaskName)) {
                            taskName[i] = "";
                            developerFirstname[i] = "";
                            developerLastname[i] = "";
                            taskDescription[i] = "";
                            taskStatus[i] = "";
                            taskID[i] = "";
                            taskDuration[i] = 0;
                            taskDeleted = true;
                            break;
                        }
                    }
                    if (taskDeleted) {
                        JOptionPane.showMessageDialog(null, "Task deleted successfully.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Task not found.");
                    }

                    // Display a report that lists the full details of all captured tasks
                    StringBuilder report = new StringBuilder("Task Report:\n");
                    int taskNumber = 0;
                    for (int i = 0; i < taskNumber; i++) {
                        report.append("Task ").append(i + 1).append(":\n")
                                .append("Task Name: ").append(taskName[i]).append("\n")
                                .append("Developer: ").append(developerFirstname[i]).append(" ").append(developerLastname[i]).append("\n")
                                .append("Task Description: ").append(taskDescription[i]).append("\n")
                                .append("Task Status: ").append(taskStatus[i]).append("\n")
                                .append("Task ID: ").append(taskID[i]).append("\n")
                                .append("Task Duration: ").append(taskDuration[i]).append(" hours").append("\n\n");
                    }
                    JOptionPane.showMessageDialog(null, report.toString());
                } else {
                    JOptionPane.showMessageDialog(null, "Please add tasks first before generating the report.");
                }
            }

            case 3 -> JOptionPane.showMessageDialog(null, "Goodbye! This Was Programmed By Katlego Sebona/St10239864");

            default -> JOptionPane.showMessageDialog(null, "Invalid option. Please try again.");
        }
    } while (option != 3);
} else {
    JOptionPane.showMessageDialog(null, "Username or password incorrect. Please try again.");
}

        
        /*int capacity = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of tasks:"));
        TaskManagement taskManagement = new TaskManagement(capacity);
        
        for (int i = 0; i < capacity; i++) {
            String developer = JOptionPane.showInputDialog("Enter the name of the developer assigned to task " + (i + 1));
            String taskName = JOptionPane.showInputDialog("Enter the name of task " + (i + 1));
            int taskID = Integer.parseInt(JOptionPane.showInputDialog("Enter the task ID for task " + (i + 1)));
            int taskDuration = Integer.parseInt(JOptionPane.showInputDialog("Enter the duration for task " + (i + 1)));
            String taskStatus = JOptionPane.showInputDialog("Enter the status of task " + (i + 1));

            taskManagement.addTask(developer, taskName, taskID, taskDuration, taskStatus);
        }
        
        taskManagement.displayTasksWithStatus("Done");

        taskManagement.displayLongestDurationTask();

        String searchTaskName = JOptionPane.showInputDialog("Enter the task name to search:");
        taskManagement.searchTaskByName(searchTaskName);

        String searchDeveloper = JOptionPane.showInputDialog("Enter the developer to search:");
        taskManagement.searchTasksByDeveloper(searchDeveloper);

        String deleteTaskName = JOptionPane.showInputDialog("Enter the task name to delete:");
        taskManagement.deleteTaskByName(deleteTaskName);

        taskManagement.displayReport();*/
    }
    
    public static boolean loginUser(String loginUsername, String loginPassword) {
        // Perform the login validation logic here
        // Return true if login is successful, false otherwise
        return true; // Placeholder, replace with actual logic
    }

    public static void returnTotalHours(int duration) {
        totalHours += duration;
    }

    public static String createTaskID(String taskName, int taskNumber, String developerLastName) {
        String firstTwoLetters = taskName.substring(0, 2).toUpperCase();
        String lastThreeLetters = developerLastName.substring(developerLastName.length() - 3).toUpperCase();
        return firstTwoLetters + ":" + taskNumber + ":" + lastThreeLetters;
    }

    public static String printTaskDetails(String taskStatus, String developerFirstName, String developerLastName,
                                          int taskNumber, String taskName, String taskDescription, String taskID, int taskDuration) {
        StringBuilder details = new StringBuilder();
        details.append("Task Status: ").append(taskStatus).append("\n");
        details.append("Developer Details: ").append(developerFirstName).append(" ").append(developerLastName).append("\n");
        details.append("Task Number: ").append(taskNumber).append("\n");
        details.append("Task Name: ").append(taskName).append("\n");
        details.append("Task Description: ").append(taskDescription).append("\n");
        details.append("Task ID: ").append(taskID).append("\n");
        details.append("Task Duration: ").append(taskDuration).append(" hours").append("\n");
        return details.toString();
    }
    
    
    
     ////PART 3 POE
    
    public class TaskManagement {
        
    private final String[] developer1;
    private final String[] taskNames1;
    private final int[] taskID1;
    private final int[] taskDuration1;
    private final String[] taskStatus1;
    private int currentIndex;
    
        public TaskManagement(int capacity) {
            developer1 = new String[capacity];
            taskNames1 = new String[capacity];
            taskID1 = new int[capacity];
            taskDuration1 = new int[capacity];
            taskStatus1 = new String[capacity];
            currentIndex = 0;
        } 
        
        public void addTask(String developer, String taskName, int taskID, int taskDuration, String taskStatus) {
            developer1[currentIndex] = developer;
            taskNames1[currentIndex] = taskName;
            taskID1[currentIndex] = taskID;
            taskDuration1[currentIndex] = taskDuration;
            taskStatus1[currentIndex] = taskStatus;
            currentIndex++;
        }
        
        public void displayTasksWithStatus(String status) {
            StringBuilder sb = new StringBuilder();
            sb.append("Tasks with status: ").append(status).append("\n");
            sb.append("Developer\tTask Name\tDuration\n");
            for (int i = 0; i < currentIndex; i++) {
                if (taskStatus1[i].equalsIgnoreCase(status)) {
                    sb.append(developer1[i]).append("\t\t");
                    sb.append(taskNames1[i]).append("\t\t");
                    sb.append(taskDuration1[i]).append("\n");
                }
            }
            JOptionPane.showMessageDialog(null, sb.toString());
        }
        
        public void displayLongestDurationTask() {
            int maxDuration = 0;
            int maxDurationIndex = -1;

            for (int i = 0; i < currentIndex; i++) {
                if (taskDuration1[i] > maxDuration) {
                    maxDuration = taskDuration1[i];
                    maxDurationIndex = i;
                }
            }

            if (maxDurationIndex != -1) {
                StringBuilder sb = new StringBuilder();
                sb.append("Task with the longest duration:\n");
                sb.append("Developer: ").append(developer1[maxDurationIndex]).append("\n");
                sb.append("Duration: ").append(taskDuration1[maxDurationIndex]).append("\n");
                JOptionPane.showMessageDialog(null, sb.toString());
            } else {
                JOptionPane.showMessageDialog(null, "No tasks found.");
            }
        }
        
        public void searchTaskByName(String taskName) {
            int foundIndex = -1;

            for (int i = 0; i < currentIndex; i++) {
                if (taskNames1[i].equalsIgnoreCase(taskName)) {
                    foundIndex = i;
                break;
                }
            }

            if (foundIndex != -1) {
                StringBuilder sb = new StringBuilder();
                sb.append("Task Details:\n");
                sb.append("Task Name: ").append(taskNames1[foundIndex]).append("\n");
                sb.append("Developer: ").append(developer1[foundIndex]).append("\n");
                sb.append("Status: ").append(taskStatus1[foundIndex]).append("\n");
                JOptionPane.showMessageDialog(null, sb.toString());
            } else {
                JOptionPane.showMessageDialog(null, "Task not found.");
            }
        }
        
        public void searchTasksByDeveloper(String developer) {
            StringBuilder sb = new StringBuilder();
            sb.append("Tasks assigned to developer: ").append(developer).append("\n");
            sb.append("Task Name\tStatus\n");
            boolean tasksFound = false;

            for (int i = 0; i < currentIndex; i++) {
                if (developer1[i].equalsIgnoreCase(developer)) {
                    sb.append(taskNames1[i]).append("\t\t");
                    sb.append(taskStatus1[i]).append("\n");
                    tasksFound = true;
                }
            }   

            if (tasksFound) {
                JOptionPane.showMessageDialog(null, sb.toString());
            } else {
                JOptionPane.showMessageDialog(null, "No tasks assigned to the developer.");
            }
        }    
     
        public void deleteTaskByName(String taskName) {
            int foundIndex = -1;

            for (int i = 0; i < currentIndex; i++) {
                if (taskNames1[i].equalsIgnoreCase(taskName)) {
                    foundIndex = i;
                    break;
                }
            }

            if (foundIndex != -1) {
                for (int i = foundIndex; i < currentIndex - 1; i++) {
                    developer1[i] = developer1[i + 1];
                    taskNames1[i] = taskNames1[i + 1];
                    taskID1[i] = taskID1[i + 1];
                    taskDuration1[i] = taskDuration1[i + 1];
                    taskStatus1[i] = taskStatus1[i + 1];
                }
                currentIndex--;

                JOptionPane.showMessageDialog(null, "Task deleted successfully.");
            } else {
                JOptionPane.showMessageDialog(null, "Task not found.");
            }
        }
        
        public void displayReport() {
            StringBuilder sb = new StringBuilder();
            sb.append("Task Management Report\n\n");
            sb.append("Developer\tTask Name\tTask ID\t\tDuration\tStatus\n");
            for (int i = 0; i < currentIndex; i++) {
                sb.append(developer1[i]).append("\t\t");
                sb.append(taskNames1[i]).append("\t\t");
                sb.append(taskID1[i]).append("\t\t");
                sb.append(taskDuration1[i]).append("\t\t");
                sb.append(taskStatus1[i]).append("\n");
            }
            JOptionPane.showMessageDialog(null, sb.toString());
        }        
    }
}
    
   