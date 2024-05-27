package DTO;

import modals.Employee;
import modals.Project;
import modals.Resource;
import modals.Task;

import java.util.List;

public class ProjectData {
    private Project project;
    private List<Task> tasks;
    private int doneTasks;
    private int totalTasks;

    public ProjectData(Project project, int doneTasks, int totalTasks) {
        this.project = project;
        this.doneTasks = doneTasks;
        this.totalTasks = totalTasks;
    }

    public ProjectData(Project project,  List<Task> tasks, int doneTasks, int totalTasks) {
        this.project = project;
        this.tasks = tasks;
        this.doneTasks = doneTasks;
        this.totalTasks = totalTasks;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public int getDoneTasks() {
        return doneTasks;
    }

    public void setDoneTasks(int doneTasks) {
        this.doneTasks = doneTasks;
    }

    public int getTotalTasks() {
        return totalTasks;
    }

    public void setTotalTasks(int totalTasks) {
        this.totalTasks = totalTasks;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
