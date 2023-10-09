package PackageInterfaceAdmin;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;


public class ViewAjouterCh  {
	private JFrame frame;
	private JLabel labelNumChambre;  private JTextField txtNumChambre;
	private JLabel labelEtage;      
	private JLabel labelNbLits;      
	String [] elementsEtages={"1","2","3","4","5"};
	String [] elementsNbLits={"1","2","3","4","5"};
	JComboBox txtListEtages, txtListNbLits;
	private ButtonGroup BG=null;
	private JRadioButton bRadioSimple, bRadioDouble, bRadioSuite;
	private JButton bouttonAjouter, bouttonAnnuler;
	
	public ViewAjouterCh(String titre) {
		   frame=new JFrame();
//		this.frame.setLayout(null);
//Le panneau Ajouter Chambre :
		JPanel panAjouterCha=new JPanel();
		 panAjouterCha.setBorder(BorderFactory.createTitledBorder(titre));
		 panAjouterCha.setLayout(null);
		 panAjouterCha.setBounds(25,25,620,400);
		 
		 labelNumChambre=new JLabel(" Numero du Chambre : "); labelNumChambre.setBounds(40,20,200,50);  panAjouterCha.add(labelNumChambre);
		 txtNumChambre=new JTextField();                         txtNumChambre.setBounds(220,30,230,35);      panAjouterCha.add(txtNumChambre);
		 labelEtage=new JLabel(" Etage : ");                  labelEtage.setBounds(40, 83, 200, 50);    panAjouterCha.add(labelEtage);
		 txtListEtages=new JComboBox(elementsEtages);            txtListEtages.setBounds(220, 90, 230, 35);   panAjouterCha.add(txtListEtages); 
		 labelNbLits=new JLabel(" Nombre de lits : ");        labelNbLits.setBounds(40, 150, 200, 50);  panAjouterCha.add(labelNbLits);
		 txtListNbLits=new JComboBox(elementsNbLits);            txtListNbLits.setBounds(220, 155, 230, 35);  panAjouterCha.add(txtListNbLits); 
		 
//Le panneau Categorie de Chambre :
		 JPanel panCategorieCha=new JPanel();
		 panCategorieCha.setBorder(BorderFactory.createTitledBorder("Categorie de Chambre"));
		 panCategorieCha.setLayout(null);
		 panCategorieCha.setBounds(40,230,410,70); 
//Les bouttons Radios :
		 bRadioSimple=new JRadioButton(" Simple ");   bRadioSimple.setBounds(40, 30, 80, 20);     bRadioSimple.setSelected(true);     panCategorieCha.add(bRadioSimple); 
		 bRadioDouble=new JRadioButton(" Double ");   bRadioDouble.setBounds(170, 30, 80, 20);    panCategorieCha.add(bRadioDouble); 
		 bRadioSuite=new JRadioButton(" Suite ");     bRadioSuite.setBounds(310, 30, 80, 20);     panCategorieCha.add(bRadioSuite); 
		 BG=new ButtonGroup(); BG.add(bRadioSimple);  BG.add(bRadioDouble);  BG.add(bRadioSuite);
		 panAjouterCha.add(panCategorieCha);
//Les bouttons Ajouter & Annuler :
		 bouttonAjouter=new JButton(" Ajouter ");     bouttonAjouter.setBounds(480, 330, 115, 40); panAjouterCha.add(bouttonAjouter);
		 bouttonAnnuler=new JButton(" Annuler ");     bouttonAnnuler.setBounds(340, 330, 115, 40); panAjouterCha.add(bouttonAnnuler);

		 
//Le panneau Principale :
			JPanel panPrincipale=new JPanel();
			panPrincipale.setLayout(null);
			panPrincipale.add(panAjouterCha); 
		 
//		this.frame.add(panAjouterCha);
//		this.frame.setContentPane(panAjouterCha);
		this.frame.getContentPane().add(panPrincipale);
//		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.pack();
		//this.frame.setSize(700,700);
		this.frame.setSize(700,550);
		this.frame.setResizable(false);
		this.frame.setLocationRelativeTo(null);
		this.frame.setVisible(true);
		this.frame.setTitle(titre);
	}
		

	public JTextField getTxtNumChambre() {
		return txtNumChambre;
	}

	public void setTxtNumChambre(JTextField txtNumChambre) {
		this.txtNumChambre = txtNumChambre;
	}

	public JComboBox getTxtListEtages() {
		return txtListEtages;
	}

	public void setTxtListEtages(JComboBox txtListEtages) {
		this.txtListEtages = txtListEtages;
	}

	public JComboBox getTxtListNbLits() {
		return txtListNbLits;
	}

	public void setTxtListNbLits(JComboBox txtListNbLits) {
		this.txtListNbLits = txtListNbLits;
	}

	public JButton getBouttonAjouter() {
		return bouttonAjouter;
	}

	public void setBouttonAjouter(JButton bouttonAjouter) {
		this.bouttonAjouter = bouttonAjouter;
	}

	public JButton getBouttonAnnuler() {
		return bouttonAnnuler;
	}

	public void setBouttonAnnuler(JButton bouttonAnnuler) {
		this.bouttonAnnuler = bouttonAnnuler;
	}

	public JRadioButton getbRadioSimple() {
		return bRadioSimple;
	}

	public void setbRadioSimple(JRadioButton bRadioSimple) {
		this.bRadioSimple = bRadioSimple;
	}

	public JRadioButton getbRadioDouble() {
		return bRadioDouble;
	}

	public void setbRadioDouble(JRadioButton bRadioDouble) {
		this.bRadioDouble = bRadioDouble;
	}

	public JRadioButton getbRadioSuite() {
		return bRadioSuite;
	}

	public void setbRadioSuite(JRadioButton bRadioSuite) {
		this.bRadioSuite = bRadioSuite;
	}


	public JFrame getFrame() {
		return frame;
	}


	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	
	

	
	

}
