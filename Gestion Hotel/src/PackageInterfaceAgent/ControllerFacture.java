package PackageInterfaceAgent;
import PackageInterfaceAdmin.*;
import Test_Hotel_MVC.Connexion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
//import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Date;

import javax.swing.JOptionPane;


public class ControllerFacture {

	static LinkedList listNumCh=new LinkedList<>();
	static LinkedList listCategorie=new LinkedList<>();
	static LinkedList listNbAdultes=new LinkedList<>();
	static LinkedList listNbEnfants=new LinkedList<>();
	static LinkedList listPrix=new LinkedList<>();
	static LinkedList listSaison=new LinkedList<>();
	
	ViewFacture  viewFacture;
//	ViewRecap viewRecap = new ViewRecap();

	ControllerFacture(){
		
		viewFacture=new ViewFacture(); 
		
	String   xnumero= viewFacture.numero.getText();	
	String   xmontant= viewFacture.montant.getText();	
	String   xdate= viewFacture.date.getText();	
	
	String numReservText = ControllerAnnModResFacture.numReservationText;
	int numReservation=Integer.parseInt(numReservText);
	
		viewFacture.montant.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			//	 viewFacture.prix.setText("00.0");
				 char c = e.getKeyChar();
				 if (numReservText.length() >5) { e.consume();}
			        if (!Character.isDigit(c)) {		  
			            e.consume();
			        }   
			}
		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub			
		}
			@Override
			public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			}
			
//			
		});
		
		viewFacture.numero.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			//	 viewFacture.prix.setText("00.0");
				 char c = e.getKeyChar();
				 if (numReservText.length() >5) { e.consume();}
			        if (!Character.isDigit(c)) {		  
			            e.consume();
			        }   
			}
		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub			
		}
			@Override
			public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			}
			
//			
		});

		viewFacture.bAnnuler.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
		    
				viewFacture.jTypePay.setSelectedIndex(0);
			//	viewFacture.prix.setText("00.0");
				viewFacture.numero.setText("");
				viewFacture.montant.setText("");
				viewFacture.date.setText("");
				
			}	
		});	
			
		viewFacture.bPrecedant.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			
				viewFacture.setVisible(false);
				
				
			}	
		});	
			
		viewFacture.jTypePay.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
		    
				if (viewFacture.jTypePay.getSelectedItem().equals("Liquide")) {

					JOptionPane.showMessageDialog(null,"L'opération est bien faite!,Le processus est en cours");
					viewFacture.numero.setText("*****************************************");
				    viewFacture.montant.setText("****************************************");
			     	viewFacture.date.setText("*****************************************");}
				
				else if (viewFacture.jTypePay.getSelectedItem().equals("Cheque")){
					JOptionPane.showMessageDialog(null,"Le processus est en cours!");
					
						viewFacture.numero.setText("");
						viewFacture.montant.setText("");
						viewFacture.date.setText("");
					
					
					}

				else if (viewFacture.jTypePay.getSelectedItem().equals("Espece")) {
					JOptionPane.showMessageDialog(null,"L'opération est bien faite!,Le processus est en cours");
					   viewFacture.numero.setText("*****************************************");
					   viewFacture.montant.setText("****************************************");
				       viewFacture.date.setText("*****************************************");
				       
				
				}

			}	
		});	
				
		viewFacture.bConfirmer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {   
				
		Connexion connexion = new Connexion();
		try {  
			if (!viewFacture.jTypePay.getSelectedItem().equals("Choisir le type de Payment")) { 
				
			////Insertion dans la table facture :
				int numRes = Integer.parseInt(ControllerAnnModResFacture.numReservationText);
	        	// Date dateAuj=new Date();
	        	 String tablefact="Facture";
	        	 String valuesFact=null;
	        	 
	        	 double prixTotal=connexion.calculerPrixTotal(numRes);
	        	 
	        	 double prixReduction=connexion.calculerPrixReduction(numRes);
	        	 
	        	 if(viewFacture.jTypePay.getSelectedItem().equals("Liquide"))
	        	     valuesFact="'"+numRes+"' ,"+ prixTotal +" ,"+ "'Liquide'" ;
	        	 else  if(viewFacture.jTypePay.getSelectedItem().equals("Espece"))
	        	           valuesFact="'"+numRes+"' ,"+ prixTotal +" ,"+ "'Espece'" ;
	        	       else
	        	    	   valuesFact="'"+numRes+"' ,"+ prixTotal +" ,"+ "'Cheque'" ;
	        	 if(connexion.FactureExiste(tablefact, numRes)==false)
	        	      connexion.insertDataFacture(tablefact, valuesFact);
	        	 //else 
	        		// JOptionPane.showMessageDialog(null, "Ce Client avec numero de Reservation "+numRes +" est deja paye la facture !");
				
	        	 
				// Si le type de paiement est un chèque
				if (viewFacture.jTypePay.getSelectedItem().equals("Cheque")) { 
					connexion.connect();
					int reference = connexion.getReferenceFact(numRes);
					//String typePayement = connexion.getTypePayementFact(numRes);    
					
					String mumeroCheqText = viewFacture.numero.getText();
					String montantCheqText = viewFacture.montant.getText();
					String dateValid = viewFacture.date.getText();
					
					// Vérification des champs du chèque
					if (mumeroCheqText.equals("") || montantCheqText.equals("") || dateValid.equals("")) {
						JOptionPane.showMessageDialog(null, "SVP Remplir tous les donnees du Cheque ", "WARNING", JOptionPane.YES_NO_OPTION); }
				    else {
						int mumeroCheq = Integer.parseInt(viewFacture.numero.getText().toString());
						double montantCheq = Double.parseDouble(viewFacture.montant.getText().toString());
						String dateValidite = viewFacture.date.getText().toString();
						
					// Si la référence est existe dans la table Facture
					if (reference!= 0) {
						if (montantCheq >= prixReduction) {
							String tableCheq = "Cheque";
							String valuesCheq = "'" + mumeroCheq + "'," + reference + ",'" + dateValidite + "','" + prixReduction + "'";
							
							if(connexion.getReferenceFactTypeCheq(numReservation)==0)
								JOptionPane.showMessageDialog(null,"La Facture est deja Effectuee", "Erreur", JOptionPane.WARNING_MESSAGE);
							else	
							connexion.insertData(tableCheq, valuesCheq); 
	
	                                   if (JOptionPane.showConfirmDialog(null, "Voulez vous Imprimer la facture?", "WARNING", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						                        viewFacture.setVisible(false);
						                          afficherNbChambre(); }
						 } else {
							JOptionPane.showMessageDialog(null, "Le montant " + montantCheq + "DH, de Cheque est inferieur au prix a paye " + prixReduction + "DH !", "Erreur", JOptionPane.WARNING_MESSAGE);
						}
					}  	 
					// Si la référence n'est pas disponible
				}  
				// Si le type de paiement est de l'espèce ou du liquide
			  } else if (viewFacture.jTypePay.getSelectedItem().equals("Espece") || viewFacture.jTypePay.getSelectedItem().equals("Liquide")) {
					if (JOptionPane.showConfirmDialog(null, "Voulez vous Imprimer la facture?", "WARNING", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						viewFacture.setVisible(false);
						afficherNbChambre();
					}
				}
				// Si aucun type de paiement n'a été choisi 
		    }else {
					JOptionPane.showMessageDialog(null, "SVP Choisir le type de Payement avant de Confirmer", "WARNING", JOptionPane.YES_NO_OPTION);
				} 
	    
	}
		catch (SQLException e2) {
			 e2.printStackTrace();
	
	} 
					
}});

	}

 public void afficherNbChambre() {
	 
	ControllerRecap controllerRecap= new ControllerRecap();
//	 ViewRecap viewRecap = new ViewRecap();
	//controllerRecap.calculerChamps(2);
	 Connexion connexion= new Connexion();
	 try { 
		 connexion.connect();
		 int numRes=Integer.parseInt(ControllerAnnModResFacture.numReservationText);
		 //les infos personnels
		 String dataCl="C.*";
		 String tablesCl="Client C,Reservation R";
         String conditionsCl="C.cin=R.cin AND R.numeroRes=" + numRes;	
         ResultSet resCl = connexion.getAllData(dataCl, tablesCl, conditionsCl);
         
         while(resCl.next()) {
        	 String cin= resCl.getString(1);
        	 String nom= resCl.getString(2);
        	 String prenom= resCl.getString(3);
        	 String tel= resCl.getString(4);
        	 
        	 controllerRecap.afficherInfoPersonnel(numRes,cin,nom,prenom,tel); }
        	 
         
         double prixTotal=connexion.calculerPrixTotal(numRes);
    	 controllerRecap.afficherPrixTot(prixTotal);
    	 
    	 double prixReduction=connexion.calculerPrixReduction(numRes);
    	 controllerRecap.afficherPrixReduction(prixReduction);
        
    	 ResultSet resCh=null;
    	 
          //les infos des chambres:
         String dataCh="DISTINCT DR.numeroCh,cat.Nom,DR.nbAdultes,DR.nbEnfants, PCh.prixChambre,S.Nom ";
		 String tablesCh="Reservation R, DetailReservation DR,Categorie cat,Chambre Ch,Saison S,PrixChambre PCh";
         String conditionsCh="DR.numeroCh=PCh.numeroCh AND R.numeroRes=DR.numeroRes AND DR.idCategorie=cat.idCategorie AND cat.idCategorie=PCh.idCategorie AND PCh.idSaison=S.idSaison AND R.numeroRes=" + numRes+" LIMIT 3";	
         resCh = connexion.getAllData(dataCh, tablesCh, conditionsCh);
         
         //resCh.close();
         
         String table="detailReservation";
 		 int nbChambre=connexion.nombreChambre(table, numRes);
 		 
 		listNumCh.clear();     listCategorie.clear();  listNbAdultes.clear();
        listNbEnfants.clear(); listPrix.clear();       listSaison.clear();
 		 
          for(int i=1;i<=resCh.getMetaData().getColumnCount();i++) {
         	 while(resCh.next()) {
         		 listNumCh.add(Integer.parseInt(resCh.getString(1)));
         		 listCategorie.add(resCh.getString(2));
         	     listNbAdultes.add(Integer.parseInt(resCh.getString(3)));
         	     listNbEnfants.add(Integer.parseInt(resCh.getString(4)));
         	     listPrix.add(Double.parseDouble(resCh.getString(5)));
         	     listSaison.add(resCh.getString(6));
         }}
          
          //Chambre 1 si existe :
          int numCh1=0, nbAdulte1=0, nbEnfant1=0; String categorie1="", saison1=""; double prix1=0;
              numCh1=Integer.parseInt(listNumCh.get(0).toString());
              categorie1=listCategorie.get(0).toString();
              nbAdulte1=Integer.parseInt(listNbAdultes.get(0).toString());
              nbEnfant1=Integer.parseInt(listNbEnfants.get(0).toString());
              prix1=Double.parseDouble(listPrix.get(0).toString());
              saison1=listSaison.get(0).toString();
              
              //listNumCh.remove(0);     listCategorie.remove(0);  listNbAdultes.remove(0);
              //listNbEnfants.remove(0); listPrix.remove(0);       listSaison.remove(0);
             // if(categorie1==listCategorie.get(1).toString())
               //     listPrix.remove(0); 
              
          //Chambre 2 si existe :
          int numCh2=0, nbAdulte2=0, nbEnfant2=0; String categorie2="", saison2=""; double prix2=0;
          if (listNumCh.size() >= 2) {
              numCh2 = Integer.parseInt(listNumCh.get(1).toString());
              categorie2 = listCategorie.get(1).toString();
              nbAdulte2 = Integer.parseInt(listNbAdultes.get(1).toString());
              nbEnfant2 = Integer.parseInt(listNbEnfants.get(1).toString());
              prix2 = Double.parseDouble(listPrix.get(1).toString());
              saison2 = listSaison.get(1).toString();
              
              
          } else {
              numCh2 = 0; categorie2 = ""; nbAdulte2 = 0; nbEnfant2 = 0; prix2 = 0.0; saison2 = "";
          }
          
          //Chambre 3 si existe :
          int numCh3=0, nbAdulte3=0, nbEnfant3=0; String categorie3="", saison3=""; double prix3=0;
          if (listNumCh.size() >= 3) {
              numCh3 = Integer.parseInt(listNumCh.get(2).toString());
              categorie3 = listCategorie.get(2).toString();
              nbAdulte3 = Integer.parseInt(listNbAdultes.get(2).toString());
              nbEnfant3 = Integer.parseInt(listNbEnfants.get(2).toString());
              prix3 = Double.parseDouble(listPrix.get(2).toString());
              saison3 = listSaison.get(2).toString();
              
          } else {
              numCh3 = 0; categorie3 = ""; nbAdulte3 = 0; nbEnfant3 = 0; prix3 = 0.0; saison3 = "";
          }
          
  
      //L'affichage :    
        controllerRecap.calculerChamps(nbChambre,numCh1,categorie1,nbAdulte1,nbEnfant1,prix1,numCh2,categorie2,nbAdulte2,nbEnfant2,prix2,numCh3,categorie3,nbAdulte3,nbEnfant3,prix3,saison1);	
              
            //connexion.disconnect();
	 }
	 catch(SQLException e) {
	 e.printStackTrace();}
  }
 
 
 }