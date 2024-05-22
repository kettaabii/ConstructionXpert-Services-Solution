package modals;

import java.sql.Date;
import java.util.List;

public class Task {
    private int idTask;
    private String title;
    private String description;
    private Date dateDebutTache;
    private Date dateFinTache;
    private String statut;
    private int ProjectId ;


    public Task(int idTask, String title, String description, Date dateDebutTache, Date dateFinTache, String statut, int projectId) {
        this.idTask = idTask;
        this.title = title;
        this.description = description;
        this.dateDebutTache = dateDebutTache;
        this.dateFinTache = dateFinTache;
        this.statut = statut;
        ProjectId = projectId;
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

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public int getProjectId() {
        return ProjectId;
    }

    public void setProjectId(int projectId) {
        ProjectId = projectId;
    }




}
