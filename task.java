
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package registration;

import java.util.List;

/**
 *
 * @author wtcyr
 */

public class task {
    private final String description;
    private final int hours;
    private final String taskID;

    public task(String description, int hours) {
        this.description = description;
        this.hours = hours;
        this.taskID = createTaskID();
    }

    public boolean checkTaskDescription() {
        return description.length() <= 50;
    }

    private String createTaskID() {
        // Assume TaskManager has a method to retrieve the number of tasks
        int taskCount = TaskManager.getTaskCount();
        return String.valueOf(taskCount + 1);
    }

    public String printTaskDetails() {
        return "Task ID: " + taskID + "\nDescription: " + description + "\nHours: " + hours;
    }

    // Getters and setters

    public String getDescription() {
        return description;
    }

    public int getHours() {
        return hours;
    }

    public String getTaskID() {
        return taskID;
    }


    private static class Task {

        public Task(String task_2_description, int par) {
        }

        private boolean checkTaskDescription() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }


        private boolean printTaskDetails() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }        

        

        
    }
}

    
    class TaskManager {

        static int getTaskCount() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
    private final List<Task> tasks;

        public TaskManager(List<Task> tasks) {
        this.tasks = tasks;
        }

    int returnTotalHours() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private static class Task {

        public Task() {
        }
    }
    }


