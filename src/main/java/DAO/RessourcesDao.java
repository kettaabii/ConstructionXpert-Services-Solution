package DAO;

import modals.Ressources;

import java.util.List;

public interface RessourcesDao {
    void addRessources(Ressources ressources);
    void updateRessources(Ressources ressources);
    void deleteRessources(Ressources ressources);
    Ressources getRessources(Ressources ressources);
    List<Ressources> getAllRessources();
}
