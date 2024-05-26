package modals;

import modals.Task;

import java.util.List;

public class Resource {
    private int resourceId;
    private String resourceName;
    private String resourceDescription;
    private int quantity;
    private String supplier;
    private List<Task> tasks;
    private int taskId;

    public Resource(int resourceId, String resourceName, String resourceDescription, int quantity, String supplier,int taskId) {
        this.resourceId = resourceId;
        this.resourceName = resourceName;
        this.resourceDescription = resourceDescription;
        this.quantity = quantity;
        this.supplier = supplier;
        this.taskId=taskId;
    }

    public Resource(int resourceId, String resourceName, String resourceDescription, int quantity, String supplier, List<Task> tasks) {
        this.resourceId = resourceId;
        this.resourceName = resourceName;
        this.resourceDescription = resourceDescription;
        this.quantity = quantity;
        this.supplier = supplier;
        this.tasks = tasks;
    }

    // Getters and setters for all attributes

    public List<Task> getTasks() {
        return tasks;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getResourceDescription() {
        return resourceDescription;
    }

    public void setResourceDescription(String resourceDescription) {
        this.resourceDescription = resourceDescription;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
