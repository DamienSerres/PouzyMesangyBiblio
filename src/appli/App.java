/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appli;

import entities.Bibliotheque;
import services.CBDD;
import services.CParametresStockageBDD;
import IHM.JFrameBibliotheque;
import entities.Livre;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import services.CTableLivres;

/**
 *
 * @author gimli
 */
public class App {

    public Bibliotheque biblio;
    public JFrameBibliotheque jFrameBiblio;
    public CTableLivres tableLivres;

    public void runBibliothequeIHM() {

        biblio = new Bibliotheque();
        jFrameBiblio = new JFrameBibliotheque();
        tableLivres = new CTableLivres(new CBDD(new CParametresStockageBDD("parametresBdd.properties")));
        jFrameBiblio.app = this;
        this.majBiblio();

        jFrameBiblio.setVisible(true);

    }

    public void majBiblio() {
        biblio.setListeLivres(tableLivres.lireLivres());
        this.afficherListejTableBiblio();
    }

    public void setRowCountjTableBiblio(int rowCount) {
        DefaultTableModel model = (DefaultTableModel) jFrameBiblio.getjTableBibliotheque().getModel();
        model.setRowCount(rowCount);
        jFrameBiblio.getjTableBibliotheque().setModel(model);
        this.jFrameBiblio.idLivres = new String[rowCount];
    }

    public void afficherListejTableBiblio() {
        this.setRowCountjTableBiblio(this.biblio.getListeLivres().size());

        for (int i = 0; i < this.biblio.getListeLivres().size(); i++) {
            this.jFrameBiblio.idLivres[i] = this.biblio.getListeLivres().get(i).getId();
            this.jFrameBiblio.getjTableBibliotheque().setValueAt(this.biblio.getListeLivres().get(i).getTitre(), i, 0);
            this.jFrameBiblio.getjTableBibliotheque().setValueAt(this.biblio.getListeLivres().get(i).getAuteur(), i, 1);
            this.jFrameBiblio.getjTableBibliotheque().setValueAt(this.biblio.getListeLivres().get(i).getRef(), i, 2);
            this.jFrameBiblio.getjTableBibliotheque().setValueAt(this.biblio.getListeLivres().get(i).getNbrePages(), i, 3);
            this.jFrameBiblio.getjTableBibliotheque().setValueAt(this.biblio.getListeLivres().get(i).getEdition(), i, 4);
            this.jFrameBiblio.getjTableBibliotheque().setValueAt(this.biblio.getListeLivres().get(i).getGenre(), i, 5);
            this.jFrameBiblio.getjTableBibliotheque().setValueAt(this.biblio.getListeLivres().get(i).getAnneeEdition(), i, 6);
            this.jFrameBiblio.getjTableBibliotheque().setValueAt(this.biblio.getListeLivres().get(i).getLangue(), i, 7);
            this.jFrameBiblio.getjTableBibliotheque().setValueAt(this.biblio.getListeLivres().get(i).getFormat(), i, 8);
        }
    }

    public void afficherListejTableBiblio(ArrayList<Livre> list) {
        this.setRowCountjTableBiblio(list.size());

        for (int i = 0; i < list.size(); i++) {
            this.jFrameBiblio.idLivres[i] = list.get(i).getId();
            this.jFrameBiblio.getjTableBibliotheque().setValueAt(list.get(i).getTitre(), i, 0);
            this.jFrameBiblio.getjTableBibliotheque().setValueAt(list.get(i).getAuteur(), i, 1);
            this.jFrameBiblio.getjTableBibliotheque().setValueAt(list.get(i).getRef(), i, 2);
            this.jFrameBiblio.getjTableBibliotheque().setValueAt(list.get(i).getNbrePages(), i, 3);
            this.jFrameBiblio.getjTableBibliotheque().setValueAt(list.get(i).getEdition(), i, 4);
            this.jFrameBiblio.getjTableBibliotheque().setValueAt(list.get(i).getGenre(), i, 5);
            this.jFrameBiblio.getjTableBibliotheque().setValueAt(list.get(i).getAnneeEdition(), i, 6);
            this.jFrameBiblio.getjTableBibliotheque().setValueAt(list.get(i).getLangue(), i, 7);
            this.jFrameBiblio.getjTableBibliotheque().setValueAt(list.get(i).getFormat(), i, 8);
        }
    }

    public static void main(String[] args) {
        new App().runBibliothequeIHM();

    }

    public void jFrameBiblioBoutonAnnuler() {
        JOptionPane.showMessageDialog(null, "Annulation en cours...");
        
    }
}
