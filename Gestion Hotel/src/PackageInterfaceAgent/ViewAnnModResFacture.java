package PackageInterfaceAgent;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class ViewAnnModResFacture {
	private JFrame frame; private JPanel panPrincipale;
	private JLabel labelReservation;  private JTextField txtNumReservation; 
	private JButton bouttonRechercher;
	
	//Modifier les details des Chambres
	JFrame frameCh=new JFrame();
	    JLabel labelChambre;
		JTextField txtNumCham;
	    JButton btnRechercherCh;
		
	//Afficher les details des chambres
		JFrame frameDt=new JFrame();
		JLabel lblNum,num,lblCategorie,lblNbAdultes,lblNbEnfants;
		JTextField categorie, nbAdultes, nbEnfants;
		JLabel labelPrixChambre,prixChambre;
		JButton btnModifier;
	
	public ViewAnnModResFacture(String titre) {
		frame=new JFrame();
		this.frame.setLayout(null);
//le panneau Annuler/Modifier Reservation et Etablir Facture :
		JPanel panAnnModResFact=new JPanel();
		TitledBorder borderSai = BorderFactory.createTitledBorder(titre);
		panAnnModResFact.setBorder(borderSai);
		panAnnModResFact.setLayout(null);
		panAnnModResFact.setBounds(25,25,620, 200);
		
		labelReservation=new JLabel("Numero de Reservation : ");  labelReservation.setBounds(40,20,200,50);   panAnnModResFact.add(labelReservation);
		txtNumReservation=new JTextField();  txtNumReservation.setBounds(220,30,350,35); panAnnModResFact.add(txtNumReservation);
		bouttonRechercher=new JButton(" Rechercher "); bouttonRechercher.setBounds(450,80,120,30); panAnnModResFact.add(bouttonRechercher);
		
  //Le panneau Principale :
		panPrincipale=new JPanel();
		panPrincipale.setLayout(null);
		panPrincipale.add(panAnnModResFact); 
		
		this.frame.setContentPane(panPrincipale); 
//		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.pack();
		//this.frame.setSize(700,500);
		this.frame.setSize(700,550);
		this.frame.setResizable(false);
		this.frame.setLocationRelativeTo(null);
		this.frame.setVisible(true);
		this.frame.setTitle(titre); 
		
	}

	public JTextField getTxtNumReservation() {
		return txtNumReservation;
	}

	public void setTxtNumReservation(JTextField txtNumReservation) {
		this.txtNumReservation = txtNumReservation;
	}

	public JButton getBouttonRechercher() {
		return bouttonRechercher;
	}

	public void setBouttonRechercher(JButton bouttonRechercher) {
		this.bouttonRechercher = bouttonRechercher;
	}
	
	public void afficherModifierReservation() {
		frameCh=new JFrame();
		
		JPanel panModifierCh=new JPanel();
		TitledBorder borderSai = BorderFactory.createTitledBorder("Modifier Les details de la chambre");
		panModifierCh.setBorder(borderSai);
		panModifierCh.setLayout(null);
		panModifierCh.setBounds(25,25,620, 200);
		
		labelChambre=new JLabel("Numero de Chambre : ");  labelChambre.setBounds(40,20,200,50);   panModifierCh.add(labelChambre);
		txtNumCham=new JTextField();  txtNumCham.setBounds(220,30,350,35); panModifierCh.add(txtNumCham);
		btnRechercherCh=new JButton(" Rechercher "); btnRechercherCh.setBounds(450,80,120,30); panModifierCh.add(btnRechercherCh);
		
		JPanel panPrincipaleCh=new JPanel();

		  //Le panneau Principale :
				panPrincipaleCh=new JPanel();
				panPrincipaleCh.setLayout(null);
				panPrincipaleCh.add(panModifierCh);
		  
		frame.setVisible(false);
		frameCh.setContentPane(panPrincipaleCh);
		//frameCh.setSize(700,500);
		frameCh.setSize(700,500);
		frameCh.setResizable(false);
		frameCh.setLocationRelativeTo(null);
		frameCh.setVisible(true);
		frameCh.setTitle("Modifier Les details de la chambre");
			
	}
	
	//pour l'interface des details des chambres:
	
		public void afficherDetailChambre(int numR, int categorieP,int nbAdulte,int nbEnfant,double prix) {
			frameDt=new JFrame();
			JPanel panDt=new JPanel();
			
			TitledBorder borderSai = BorderFactory.createTitledBorder("Les details de la chambre :");
			panDt.setBorder(borderSai);
			panDt.setLayout(null);
			panDt.setBounds(25,25,620, 320);
			
			lblNum=new JLabel("Numero de Chambre : ");  lblNum.setBounds(50,30,150,30); panDt.add(lblNum);
			num=new JLabel("********");  num.setBounds(200,30,150,30); panDt.add(num);
			lblCategorie=new JLabel("Categorie de Chambre : ");  lblCategorie.setBounds(50,80,150,30); panDt.add(lblCategorie);
			categorie=new JTextField(15);  categorie.setBounds(200,80,150,30); panDt.add(categorie);
			lblNbAdultes=new JLabel("Nombre des adultes : ");  lblNbAdultes.setBounds(50,130,150,30);  panDt.add(lblNbAdultes);
			nbAdultes=new JTextField(15);  nbAdultes.setBounds(200,130,150,30);  panDt.add(nbAdultes);
			lblNbEnfants=new JLabel("Nombre des enfants : ");  lblNbEnfants.setBounds(50,170,150,50);  panDt.add(lblNbEnfants);
			nbEnfants=new JTextField(15);  nbEnfants.setBounds(200,180,150,30);  panDt.add(nbEnfants);
			
			labelPrixChambre=new JLabel("Prix du chambre :");  labelPrixChambre.setBounds(50,230,150,30);  panDt.add(labelPrixChambre);
			prixChambre=new JLabel("******");  prixChambre.setBounds(200,230,150,30);  panDt.add(prixChambre);
			
			btnModifier=new JButton(" Modifier "); btnModifier.setBounds(450,260,120,35); panDt.add(btnModifier);
			
			
			   num.setText(Integer.toString(numR));
			   categorie.setText(Integer.toString(categorieP));
			   nbAdultes.setText(Integer.toString(nbAdulte));
			   nbEnfants.setText(Integer.toString( nbEnfant));
			   prixChambre.setText(Double.toString(prix));
			
			JPanel panPrincipaleDt=new JPanel();

			  //Le panneau Principale :
					panPrincipaleDt=new JPanel();
					panPrincipaleDt.setLayout(null);
					panPrincipaleDt.add(panDt);
					frameDt.setVisible(true);
			        //frame.setVisible(false);		
		        	frameCh.setVisible(false);
			
			frameDt.setContentPane(panPrincipaleDt);
			//frameDt.setSize(700,500);
			frameDt.setSize(700,500);
			frameDt.setResizable(false);
			frameDt.setLocationRelativeTo(null);
		//	frameDt.setVisible(true);
			frameDt.setTitle("Modifier Les details de la chambre");
		}

//les getters et setters des details des chambres
	
	public JTextField getTxtNumCham() {
		return txtNumCham;
	}

	public void setTxtNumCham(JTextField txtNumCham) {
		this.txtNumCham = txtNumCham;
	}

	public JButton getBtnRechercherCh() {
		return btnRechercherCh;
	}

	public void setBtnRechercherCh(JButton btnRechercherCh) {
		this.btnRechercherCh = btnRechercherCh;
	}

	public JFrame getFrameCh() {
		return frameCh;
	}

	public void setFrameCh(JFrame frameCh) {
		this.frameCh = frameCh;
	}
	
	// getters et setters
	
		public JFrame getFrameDt() {
			return frameDt;
		}

		public void setFrameDt(JFrame frameDt) {
			this.frameDt = frameDt;
		}

		public JTextField getCategorie() {
			return categorie;
		}

		public void setCategorie(JTextField categorie) {
			this.categorie = categorie;
		}

		public JTextField getNbAdultes() {
			return nbAdultes;
		}

		public void setNbAdultes(JTextField nbAdultes) {
			this.nbAdultes = nbAdultes;
		}

		public JTextField getNbEnfants() {
			return nbEnfants;
		}

		public void setNbEnfants(JTextField nbEnfants) {
			this.nbEnfants = nbEnfants;
		}

		public JButton getBtnModifier() {
			return this.btnModifier;
		}

		public void setBtnModifier(JButton btnModifier) {
			this.btnModifier = btnModifier;
		}

		public JFrame getFrame() {
			return frame;
		}

		public void setFrame(JFrame frame) {
			this.frame = frame;
		}
		
		
	

}