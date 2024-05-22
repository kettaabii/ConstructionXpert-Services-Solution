package modals;

public class Ressources {
    private int ressourceId;
    private String ressourceName;
    private String ressourceDescription;
    private int quantity;
    private String supplier;
    private int idTask;

    public Ressources(int ressourceId, String ressourceName, String ressourceDescription, int quantity, String supplier) {
        this.ressourceId = ressourceId;
        this.ressourceName = ressourceName;
        this.ressourceDescription = ressourceDescription;
        this.quantity = quantity;
        this.supplier = supplier;
    }

    public Ressources(int ressourceId, String ressourceName, String ressourceDescription, int quantity, String supplier, int idTask) {
        this.ressourceId = ressourceId;
        this.ressourceName = ressourceName;
        this.ressourceDescription = ressourceDescription;
        this.quantity = quantity;
        this.supplier = supplier;
        this.idTask = idTask;
    }

    public Ressources() {
    }

    public int getRessourceId() {
        return ressourceId;
    }

    public void setRessourceId(int ressourceId) {
        this.ressourceId = ressourceId;
    }

    public String getRessourceName() {
        return ressourceName;
    }

    public void setRessourceName(String ressourceName) {
        this.ressourceName = ressourceName;
    }

    public String getRessourceDescription() {
        return ressourceDescription;
    }

    public void setRessourceDescription(String ressourceDescription) {
        this.ressourceDescription = ressourceDescription;
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

    public int getIdTask() {
        return idTask;
    }

    public void setIdTask(int idTask) {
        this.idTask = idTask;
    }
}
