/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import entities.Livre;
import java.util.ArrayList;

/**
 *
 * @author Damien
 */

/*
Nous souhaitons créer une application mimant une bibliothèque, et les services 
associés donc :
 */
public class Bibliotheque {

    /**
     * Notre bibliothèque contient des livres, on va donc avoir besoin d'un
     * attribut où les ranger.
     */
    private ArrayList<Livre> listeLivres = new ArrayList<Livre>();

    /**
     * Méthode pour enregistre un livre dans la liste en attribut.
     *
     * @param livre le livre à ajouter
     */
    public void enregistrerLivre(Livre livre) {
        this.listeLivres.add(livre);
    }

    /**
     *
     * @param titre
     * @param auteur
     * @param ref
     * @param nbrePages
     * @param edition
     * @param genre
     * @param anneeEdition
     * @param langue
     * @param format
     * @return
     */
    public Livre creationLivre(String titre, String auteur, String ref, String nbrePages, String edition, String genre, String anneeEdition, String langue, String format) {
        Livre livre = new Livre(titre, auteur, ref, nbrePages, edition, genre, anneeEdition, langue, format);
        return livre;
    }

    public void setListeLivres(ArrayList<Livre> listeLivres) {
        this.listeLivres = listeLivres;
    }

    public ArrayList<Livre> getListeLivres() {
        return listeLivres;
    }
}
