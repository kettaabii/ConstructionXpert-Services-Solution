package modals;

import java.sql.Date;
import java.util.List;

public class Task {
    private int idTask;
    private String title;
    private String description;
    private Date dateDebutTache;
    private Date dateFinTache;
    private int ProjectId ;
    private Status status;
    private int assignedEmployeeId;
    private List<Integer> requiredResourceIds;


    public Task(int idTask, String title, String description, Date dateDebutTache, Date dateFinTache, Status status, int projectId, int assignedEmployee, List<Integer> requiredResourceIds) {
        this.idTask = idTask;
        this.title = title;
        this.description = description;
        this.dateDebutTache = dateDebutTache;
        this.dateFinTache = dateFinTache;
        this.status = status;
        this.ProjectId = projectId;
        this.assignedEmployeeId = assignedEmployee;
        this.requiredResourceIds = requiredResourceIds;
    }
    public Task(int idTask, String title, String description, Date dateDebutTache, Date dateFinTache, Status status, int idProjet) {
        this.idTask = idTask;
        this.title = title;
        this.description = description;
        this.dateDebutTache = dateDebutTache;
        this.dateFinTache = dateFinTache;
        this.status = status;
        this.ProjectId = idProjet;
    }

    public Task() {
    }

    public int getIdTask() {
        return idTask;
    }

    public void setIdTask(int idTask) {
        this.idTask = idTask;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateDebutTache() {
        return dateDebutTache;
    }

    public void setDateDebutTache(Date dateDebutTache) {
        this.dateDebutTache = dateDebutTache;
    }

    public Date getDateFinTache() {
        return dateFinTache;
    }

    public void setDateFinTache(Date dateFinTache) {
        this.dateFinTache = dateFinTache;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getAssignedEmployeeId() {
        return assignedEmployeeId;
    }

    public void setAssignedEmployeeId(int assignedEmployeeId) {
        this.assignedEmployeeId = assignedEmployeeId;
    }

    public List<Integer> getRequiredResourceIds() {
        return requiredResourceIds;
    }

    public void setRequiredResourceIds(List<Integer> requiredResourceIds) {
        this.requiredResourceIds = requiredResourceIds;
    }

    public int getProjectId() {
        return ProjectId;
    }

    public void setProjectId(int projectId) {
        ProjectId = projectId;
    }

    public enum Status {
        A_FAIRE,
        EN_COURS,
        FAITE
    }

    @Override
    public String toString() {
        return "Task{" +
                "idTask=" + idTask +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", dateDebutTache=" + dateDebutTache +
                ", dateFinTache=" + dateFinTache +
                ", ProjectId=" + ProjectId +
                ", status=" + status +
                ", assignedEmployeeId=" + assignedEmployeeId +
                ", requiredResourceIds=" + requiredResourceIds +
                '}';
    }
}
