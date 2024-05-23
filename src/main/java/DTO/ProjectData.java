package DTO;

import modals.Project;

public class ProjectData {
    private Project project;
    private int doneTasks;
    private int totalTasks;

    public ProjectData(Project project, int doneTasks, int totalTasks) {
        this.project = project;
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


}
