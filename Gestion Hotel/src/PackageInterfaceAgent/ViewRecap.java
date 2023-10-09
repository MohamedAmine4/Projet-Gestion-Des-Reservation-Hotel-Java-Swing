package PackageInterfaceAgent;

import java.util.Date;

import javax.swing.*;

import PackageAjouterReservation.Ajouter_RES;

public class ViewRecap extends JFrame {
	
	JPanel panelPrincipal,panelInfoC,panelInfoCh1,panelInfoCh2,panelInfoCh3,panelPrix,panelPrixReduction;
	
	JButton quitter,imprimer;
	
	//Ajouter_RES objAjoutRes=new Ajouter_RES();
	//double prixTotaleRes=0;
	
	JLabel lblnum,lblCin,lbldateFacturation,lblnom,lblprenom,lbltel,lblPrixTotal,lblPrixReduction,lblNbrNuit,lblNbrChambre;
	JLabel num,cin,dateFacturation,nom,prenom,tel,nbrNuit,nbrChambre;
	JLabel lblChambre,lblCategorie,lblSaison,lblEnfant,lblAdulte;
	JLabel chambre,categorie,saison,enfant,adulte ;
	JLabel lblText1,lblText2,lblText3;
	JLabel prixTotal,prixReduction;
	
	ViewRecap(){
		
		//prixTotaleRes=objAjoutRes.prix_totale();
		
		
		panelPrincipal =new JPanel();
		panelInfoC=new JPanel();
		panelPrix=new JPanel();
		panelInfoCh1=new JPanel();
		panelInfoCh2=new JPanel();
		panelInfoCh3=new JPanel();
		//panelButton=new JPanel();
		panelPrixReduction=new JPanel();
		
	   quitter=new JButton("Quitter");
	   imprimer=new JButton("Imprimer");
		
	   lblnum=new JLabel("Numero de Réservation : "); lblCin=new JLabel("CIN : ");
	   num= new JLabel("*******"); cin=new JLabel("*****");
	   lblnom= new JLabel("Nom : ");lblprenom= new JLabel("Prénom : ");lbltel= new JLabel("Téléphone : ");
	   nom= new JLabel("*******"); prenom= new JLabel("*******"); tel= new JLabel("*******");
	   lblPrixTotal= new JLabel("******"); lblPrixReduction= new JLabel("*********");
	   
	   //informations Du clients:
//	   lblnum=new JLabel("Numero de Réservation : "); lblCin=new JLabel("CIN : ");
//	   num= new JLabel("*******"); cin=new JLabel("*****");
//	   lblnom= new JLabel("Nom : ");lblprenom= new JLabel("Prénom : ");lbltel= new JLabel("Téléphone : ");
//	   nom= new JLabel("*******"); prenom= new JLabel("*******"); tel= new JLabel("*******");
//	   lblPrixTotal= new JLabel("******"); lblPrixReduction= new JLabel("*********");
//	   
	   //info du chambre:
	   lblText1=new JLabel("Chambre Numéro "+" **** "+" de Catégorie "+ " ********** " + " contient " + " *** " +" Adultes et "+" *** " +" Enfants en Saison "+" ******** "+" avec prix "+"  ******* ");
	   lblText2=new JLabel("Chambre Numéro "+" **** "+" de Catégorie "+ " ********** " + " contient " + " *** " +" Adultes et "+" *** " +" Enfants en Saison "+" ******** "+" avec prix "+"  ******** ");
	   lblText3=new JLabel("Chambre Numéro "+" **** "+" de Catégorie "+ " ********** " + " contient " + " *** " +" Adultes et "+" *** " +" Enfants en Saison "+" ******** "+" avec prix "+"  ****** ");
	   //Add to Panels:
	   
		panelPrincipal.setLayout(null);
		
		
//		panelInfoC.setLayout(null);
//		panelInfoC.setBounds(20, 10,720, 200);
//		panelInfoC.setBorder(BorderFactory.createTitledBorder("Informations du Client : "));
//		//add to PanelInfoC:
//		
//		
//		panelInfoC.add(lblnum);panelInfoC.add(num);
//		panelInfoC.add(lblCin);panelInfoC.add(cin);
//		panelInfoC.add(lblnom);panelInfoC.add(nom);
//		panelInfoC.add(lblprenom);panelInfoC.add(prenom);
//		panelInfoC.add(lbltel);panelInfoC.add(tel);
//		//panelInfoC.add(lbldateFacturation);panelInfoC.add(dateFacturation);
//		
//		lblnum.setBounds(30,30,150,30);num.setBounds(180,30,150,30);
//		lblCin.setBounds(30,60,150,30);cin.setBounds(60,60,150,30);
//		lblnom.setBounds(30,90,150,30);nom.setBounds(70,90,150,30);
//		lblprenom.setBounds(30,120,150,30);prenom.setBounds(90,120,150,30);
//		lbltel.setBounds(30,150,150,30);tel.setBounds(100,150,150,30);
	   //lbldateFacturation.setBounds(30,111,150,30);dateFacturation.setBounds(90,30,150,30);
		
//	    panelInfoCh.setLayout(null);
//		panelInfoCh.setBounds(20, 250,650, 70);
//		panelInfoCh.add(lblText);    lblText.setBounds(30,20,650, 30);
//		panelInfoCh.setBorder(BorderFactory.createTitledBorder("Chambre 1 "));
		//panelInfoC.add(lblText);
		
	//	afficherChambre1();
//		afficherChambre2();
//		afficherChambre3();
		//calculerChamps(2);
		
		
		//afficherPrixTotal(00.00);
		//afficherPrixReduction(00.00);
//	panelPrix.setLayout(null);
//	panelPrix.setBounds(390, 500,150,50);
//	panelPrix.setBorder(BorderFactory.createTitledBorder("Prix Total "));
//	panelPrix.add(lblPrixTotal);
//	lblPrixTotal.setBounds(12,15, 150, 30);
//	
//	panelPrixReduction.setLayout(null);
//	panelPrixReduction.setBounds(590, 500,150,50);
//	panelPrixReduction.setBorder(BorderFactory.createTitledBorder("Prix Reduction "));
//	panelPrixReduction.add(lblPrixReduction);
//	lblPrixReduction.setBounds(12,15, 150, 30);	
//		
	
//	JPanel panelButton =new JPanel();
//	panelButton.setLayout(null);
//	panelButton.setBounds(322, 590,325,45);
//	panelButton.setBorder(BorderFactory.createTitledBorder("imprimer"));
//	
//	panelButton.add(imprimer);imprimer.setBounds(325,595,100 ,30 );
	

		
		//panelPrincipal.add(panelInfoC);
//		panelPrincipal.add(panelInfoCh);
		panelPrincipal.add(panelPrix);
		panelPrincipal.add(panelPrixReduction);
		
		panelPrincipal.add(imprimer); panelPrincipal.add(quitter);
		imprimer.setBounds(390, 580, 150, 40); quitter.setBounds(590, 580, 150, 40);
		
		this.add(panelPrincipal);
		this.setTitle("Récapulatif des Données: " + new Date());
		//this.setSize(800, 700);
		this.setSize(780,680);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);	
	}
	//public void afficherChambre1(int numCh,String categorie,int nbrAdulte,int nbrEnfant,String saison, double prixCh) 
	public void afficherChambre1(int numCh,String categorie,int nbAdu,int nbEnf,String saison,double prix) {
		    panelInfoCh1.setLayout(null);
			panelInfoCh1.setBounds(20, 230,720, 70);
			 lblText1.setText("Chambre Numéro "+ numCh +" , de Catégorie "+categorie + " ,  contient " +nbAdu +" Adultes et "+ nbEnf +" Enfants ,  en Saison "+ saison+" ,  avec prix "+prix +" DH.");
			panelInfoCh1.add(lblText1);    lblText1.setBounds(20,20,700, 30);
			panelInfoCh1.setBorder(BorderFactory.createTitledBorder("Chambre 1 "));
		
			panelPrincipal.add(panelInfoCh1);
			this.add(panelPrincipal);
			this.setVisible(true);	
		
			}
	
	public void afficherChambre2(int numCh,String categorie,int nbAdu,int nbEnf,String saison,double prix) {
		    panelInfoCh2.setLayout(null);
			panelInfoCh2.setBounds(20, 310,720, 70);
			lblText2.setText("Chambre Numéro "+ numCh +" , de Catégorie "+categorie + " , contient " +nbAdu +" Adultes et "+ nbEnf +" Enfants ,  en Saison "+ saison+" ,  avec prix "+prix+" DH.");
			panelInfoCh2.add(lblText2);    lblText2.setBounds(20,20,700, 30);
			panelInfoCh2.setBorder(BorderFactory.createTitledBorder("Chambre 2 : "));
			
			panelPrincipal.add(panelInfoCh2);
			this.add(panelPrincipal);
			this.setVisible(true);	
			}
	
	public void afficherChambre3(int numCh,String categorie,int nbAdu,int nbEnf,String saison,double prix) {
	    panelInfoCh3.setLayout(null);
		panelInfoCh3.setBounds(20, 390,720, 70);
		lblText3.setText("Chambre Numéro "+ numCh +" , de Catégorie "+categorie + " , contient " +nbAdu +" Adultes et "+ nbEnf +" Enfants ,  en Saison "+ saison+" , avec prix "+prix+" DH.");
		panelInfoCh3.add(lblText3);    lblText3.setBounds(20,20,700, 30);
		panelInfoCh3.setBorder(BorderFactory.createTitledBorder("Chambre 3 : "));
		
		panelPrincipal.add(panelInfoCh3);
		this.add(panelPrincipal);
		this.setVisible(true);	
		}
	  
	
	public void afficherInfoClient(int numRes, String cinT, String nomT, String prenomT, String telT) {
		  
		   num.setText(Integer.toString(numRes));
		   cin.setText(cinT);
		   nom.setText(nomT);
		   prenom.setText(prenomT);
		   tel.setText(telT);
		  
		    panelInfoC.setLayout(null);
			panelInfoC.setBounds(20, 10,720, 200);
			panelInfoC.setBorder(BorderFactory.createTitledBorder("Informations du Client : "));
		
		    panelInfoC.add(lblnum);panelInfoC.add(num);
			panelInfoC.add(lblCin);panelInfoC.add(cin);
			panelInfoC.add(lblnom);panelInfoC.add(nom);
			panelInfoC.add(lblprenom);panelInfoC.add(prenom);
			panelInfoC.add(lbltel);panelInfoC.add(tel);
			//panelInfoC.add(lbldateFacturation);panelInfoC.add(dateFacturation);
			
			lblnum.setBounds(30,30,150,30);num.setBounds(180,30,150,30);
			lblCin.setBounds(30,60,150,30);cin.setBounds(60,60,150,30);
			lblnom.setBounds(30,90,150,30);nom.setBounds(70,90,150,30);
			lblprenom.setBounds(30,120,150,30);prenom.setBounds(90,120,150,30);
			lbltel.setBounds(30,150,150,30);tel.setBounds(100,150,150,30);
		
		
			panelPrincipal.add(panelInfoC);
			this.add(panelPrincipal);
			this.setVisible(true);	
		
		
	}
	// static double x=getPrixTotal();
	
	public void afficherPrixTotal(double prixTot) {
		
		panelPrix.setLayout(null);
		panelPrix.setBounds(390, 500,150,50);
		panelPrix.setBorder(BorderFactory.createTitledBorder("Prix Total "));
		//double x=getPrixTotal();
		
		lblPrixTotal.setText(Double.toString(prixTot));
		panelPrix.add(lblPrixTotal);
		lblPrixTotal.setBounds(12,15, 150, 30);		
	}
	
	public void afficherPrixReduction(double prixReduc) {
		
		panelPrixReduction.setLayout(null);
		panelPrixReduction.setBounds(590, 500,150,50);
		lblPrixReduction.setText(Double.toString(prixReduc));
		panelPrixReduction.setBorder(BorderFactory.createTitledBorder("Prix avec Reduction "));
		panelPrixReduction.add(lblPrixReduction);
		lblPrixReduction.setBounds(12,15, 150, 30);	
		
	}
	
	
	
//  public void calculerChamps(int nbCh) {
//		  
//	    //  int nbCh=3;
//		  for(int i=0;i<nbCh;i++) {
//			  
//			  if(i==0)    afficherChambre1();
//			  if(i==1) {  afficherChambre1();
//			              afficherChambre2();
//			  }
//			 
//			  if(i==2) {    afficherChambre1();
//			  				afficherChambre2();
//			  			    afficherChambre3();
//			  
//			
//			  }
//		  }}
	
}
