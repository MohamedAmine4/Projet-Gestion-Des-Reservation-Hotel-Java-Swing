package PackageInterfaceAdmin;

import javax.swing.JComboBox;
import javax.swing.JTextField;

public class ModelAjouterCh {
	private int numChambre;
	private int listEtages, listNbLits;
	private String categorie;
	
	public ModelAjouterCh(int numChambre, int listEtages, int listNbLits, String categorie) {
		super();
		this.numChambre = numChambre;
		this.listEtages = listEtages;
		this.listNbLits = listNbLits;
		this.categorie=categorie;
	}

	public int getNumChambre() {
		return numChambre;
	}

	public void setNumChambre(int numChambre) {
		this.numChambre = numChambre;
	}

	public int getListEtages() {
		return listEtages;
	}

	public void setListEtages(int listEtages) {
		this.listEtages = listEtages;
	}

	public int getListNbLits() {
		return listNbLits;
	}

	public void setListNbLits(int listNbLits) {
		this.listNbLits = listNbLits;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	
	
	
	

}
