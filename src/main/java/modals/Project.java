package modals;

import java.sql.Date;

public class Project {
    private int id;
    private String projectName;
    private String description;
    private Double budget;
    private Date dateDebut;
    private Date dateFin;

    public Project(int id, String projectName, String description, Double budget, Date dateDebut, Date dateFin) {
        this.id = id;
        this.projectName = projectName;
        this.description = description;
        this.budget = budget;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    public Project() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
