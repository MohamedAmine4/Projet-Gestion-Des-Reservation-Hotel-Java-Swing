package PackageInterfaceAgent;
import PackageInterfaceAdmin.*;
import Test_Hotel_MVC.Connexion;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.*;
import java.util.LinkedList;

import javax.swing.BorderFactory;
//import java.sql.SQLException;
import javax.swing.JOptionPane;

import com.itextpdf.awt.geom.Dimension;

import javax.swing.*;

public class ControllerAnnModResFacture {
		ModelAnnModResFacture modelAnnModResFacture;
		ViewAnnModResFacture  viewAnnModResFacture;
		
		static String numReservationText ;
		
		public ControllerAnnModResFacture(ModelAnnModResFacture m, ViewAnnModResFacture v) {
			 modelAnnModResFacture=m;
			 viewAnnModResFacture=v;
		}
/*-------------------------- Partie I : Annuler Reservation -------------------------------------------*/		
//Controlleur pour Annuler Reservation :		
		public void initControllerAnnulerRes() {
			viewAnnModResFacture.getBouttonRechercher().addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					AnnulerReservation();         }
			  });
			        VerifierChampsReserv();
	      }
		
//Fonction pour Annuler Reservation :		
		private void AnnulerReservation() {			
			//Verfier les Champs :
			String numReservText = viewAnnModResFacture.getTxtNumReservation().getText();
			if (numReservText.isEmpty()) {
		    	    JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs");
		  } else {     
		      Connexion connexion = new Connexion();
		    try {
		        connexion.connect();
		        
		        //la recuperation des champs :
		        String table = "Reservation";
		        int numReserv = Integer.parseInt(numReservText);
		        
	            //Vérifier si le numéro de reservation n'existe pas
		        if (connexion.reservationEffectuee(table, numReserv)==false) 
	                JOptionPane.showMessageDialog(null, "Le numéro de reservation " + numReserv + " n'existe pas dans la table.");
	            else {
//	                JOptionPane.showMessageDialog(null, "Le numéro de reservation " + numReserv + " existe dans la table.");
//		        LinkedList<Integer> listNumChambre=new LinkedList<>();
//		        listNumChambre=connexion.listNumeroChambres(numReserv);
//		        
//		        String condition="numeroCh IN"+listNumChambre;
//		        connexion.deleteData("PrixChambre", condition);
//		        System.out.println(listNumChambre);
	            	
	            	JOptionPane.showMessageDialog(null, "Le numéro de reservation " + numReserv + " existe dans la table.");
	  	          int h=JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment annuler la reservation ?","",JOptionPane.YES_NO_OPTION);
	  		        //////////////////////ici/////////////////
	  	          if(h==JOptionPane.OK_OPTION) {
	  	        	  int nombreNumCh=0;
	  	        	  int nombreReserv=0;
	  	        	  int ch1=0,ch2=0,ch3=0;
	  	         LinkedList<Integer> ListNumCh=new LinkedList<>();
	  	         ListNumCh=connexion.listNumeroChambres(numReserv);
//	  	         System.out.println(ListNumCh);
//	  	         System.out.println(ListNumCh.get(0));
//	  	         System.out.println(connexion.nombreRes(numReserv));
	  	         nombreReserv=connexion.nombreRes(numReserv);
	  	         String cin=connexion.CinRes(numReserv);
	  	     //System.out.println("DELETE FROM Client WHERE  CIN ='"+cin+"'");

	  	         nombreNumCh= ListNumCh.size();
	  	         if(nombreNumCh==1) {
	  	        	ch1=ListNumCh.get(0);
	  	          connexion.updateEtatHorsSer(ch1);
	  	          }
	  	         else if(nombreNumCh==2)
	  	         {	ch1=ListNumCh.get(0);
	  	          	ch2=ListNumCh.get(1);
	  	          	 connexion.updateEtatHorsSer(ch1);
	  	          	 connexion.updateEtatHorsSer(ch2);
	  	         }
	  	         else {
	  	        	 ch1=ListNumCh.get(0);
	  		          	ch2=ListNumCh.get(1);
	  		          	ch3=ListNumCh.get(2);
	  		          	 connexion.updateEtatHorsSer(ch1);
	  		          	 connexion.updateEtatHorsSer(ch2);
	  		          	 connexion.updateEtatHorsSer(ch3);
	  	         }
	  	         int referenceFact=connexion.getReferenceFact(numReserv);
	  	         int referenceCheque=connexion.getReferenceFactTypeCheq(numReserv);
	  	        String conditionFact="Reference="+referenceFact;
	  	        
             if(referenceCheque==0) { //Le type de Payement n'est pas de type "Cheque" 
	  	        connexion.deleteData("facture", conditionFact); 
             }else {
            	 connexion.deleteData("Cheque", conditionFact); 
 	  	         connexion.deleteData("facture", conditionFact); 
                }
	  	        
	  	        connexion.Delete_Res_DetRes(numReserv);   
	             String condition="numeroCh IN ("+ch1+", "+ch2+", "+ch3+")";
	            connexion.deleteData("PrixChambre", condition);   
	           // System.out.println(nombreReserv);
	  	         if(nombreReserv==1){
	  	        	 //System.out.println("delete client");
	  	 
	  	       connexion.deletClient(cin);
	         }
	  	        JOptionPane.showMessageDialog(null, "La suppression de reservation numero " + numReserv + " avec succes ");
	  	             viewAnnModResFacture.getFrame().setVisible(false);
	  	        
	  	          }//fin Reservation existe
	  	         
	  	         // else System.exit(0);
	            	
	             }//fin Reservation existe
		        
		        } catch (SQLException e) {
		        //e.printStackTrace();
		        JOptionPane.showMessageDialog(null, "Une erreur s'est produite lors de l'enregistrement des données", "Erreur", JOptionPane.ERROR_MESSAGE);
		       }  
		   }//fin Remplir champs
		}

		
/*-------------------------- Partie II : Modifier Reservation -------------------------------------------*/
//Controlleur pour Modifier Reservation :
		public void initControllerModifierRes() {
			viewAnnModResFacture.getBouttonRechercher().addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					 ModifierReservation();       
				}
			  });
			        VerifierChampsReserv();
	       }
		
//Fonction pour Modifier Reservation : 
		private void ModifierReservation() {
			//Verfier les Champs :
			String numReservText = viewAnnModResFacture.getTxtNumReservation().getText();
			if (numReservText.isEmpty()) {
		    	    JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs");
		  } else {     
		      Connexion connexion = new Connexion();
		    try {
		        connexion.connect();
		        
		        //la recuperation des champs :
		        String table = "Reservation";
		        int numReserv = Integer.parseInt(numReservText);
		        
	            //Vérifier si le numéro de reservation n'existe pas
		        if (connexion.reservationEffectuee(table, numReserv)==false) 
	                JOptionPane.showMessageDialog(null, "Le numéro de reservation " + numReserv + " n'existe pas dans la table.");
	            else {
	            	LinkedList<Integer> listNumChambre=new LinkedList<>();
	 		        listNumChambre=connexion.listNumeroChambres(numReserv);
	                JOptionPane.showMessageDialog(null, "Le numéro de reservation " + numReserv + " contient les chambres "+listNumChambre);
	                viewAnnModResFacture.getFrame().setVisible(false);
	                listNumChambre.clear();
	                
	                
//La creation de l'interface Rechercher Numero Chambre a partir de la methode afficherModifierReservation() 
	                viewAnnModResFacture.afficherModifierReservation();
	                initControllerModifierDetailCh();
	             
	            }//fin Reservation existe
		        
		        } catch (SQLException e) {
		        //e.printStackTrace();
		        JOptionPane.showMessageDialog(null, "Une erreur s'est produite lors de l'enregistrement des données", "Erreur", JOptionPane.ERROR_MESSAGE);
		       } 
		   }//fin Remplir champs
		}	
		
		
/*-------------------------- Partie III : Etablir Facture -------------------------------------------*/
//Controlleur pour Etablir Facture :
		public void initControllerEtablirFacture() {
			viewAnnModResFacture.getBouttonRechercher().addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					 EtablirFacture();       
				}
			  });
			        VerifierChampsReserv();
	       }
		
//Fonction pour Etablir Facture :
		private void EtablirFacture() {
			//Verfier les Champs :
			String numReservText = viewAnnModResFacture.getTxtNumReservation().getText();
			numReservationText= numReservText;
			
			if (numReservText.isEmpty()) {
		    	    JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs");
		  } else {     
		      Connexion connexion = new Connexion();
		    try {
		        connexion.connect();
		        
		        //la recuperation des champs :
		        String table = "Reservation";
		        int numReserv = Integer.parseInt(numReservText);
		        
	            //Vérifier si le numéro de reservation n'existe pas
		        if (connexion.reservationEffectuee(table, numReserv)==false) 
	                JOptionPane.showMessageDialog(null, "Le numéro de reservation " + numReserv + " n'existe pas dans la table.");
	            else {
	                JOptionPane.showMessageDialog(null, "Le numéro de reservation " + numReserv + " existe dans la table.");
		            viewAnnModResFacture.getFrame().setVisible(false);
		            
	                //Le controlleur Facture 
	                new ControllerFacture();
	                
	             }//fin Reservation existe
		        
		        } catch (SQLException e) {
		        //e.printStackTrace();
		        JOptionPane.showMessageDialog(null, "Une erreur s'est produite lors de l'enregistrement des données", "Erreur", JOptionPane.ERROR_MESSAGE);
		       } 
		   }//fin Remplir champs
		}


/*-------------------------- Partie IIII : Modifier les details des Chambres -------------------------------------------*/
//Controlleur pour Modifier les details des Chambres :
		public void initControllerModifierDetailCh() {
		    viewAnnModResFacture.getBtnRechercherCh().addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					ModifierDetailCham();    
				}
			  });
	                 VerifierChampsChambre();
	       }
		
//Fonction pour  Modifier les details des Chambres :		
		private void ModifierDetailCham() {			
			//Verfier les Champs :
			String numChambreText = viewAnnModResFacture.getTxtNumCham().getText();
			if (numChambreText.isEmpty()) {
		    	    JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs");
		  } else {     
		      Connexion connexion = new Connexion();
		    try {
		        connexion.connect();
		        
		        //la recuperation des champs :
		        String table = "Chambre";
		        int numChamb = Integer.parseInt(numChambreText);
		        
	            //Vérifier si le numéro de reservation n'existe pas
		        if (connexion.chambreExiste(table, numChamb)==false) 
	                JOptionPane.showMessageDialog(null, "Le numéro de chambre " + numChamb + " n'existe pas dans la table.");
	            else {
	                JOptionPane.showMessageDialog(null, "Le numéro de chambre " + numChamb + " existe dans la table.");
		
	                //viewAnnModResFacture.setBtnModifier(viewAnnModResFacture.getBtnModifier());
	                afficherInfoChambre();
	                
	                initControllerVerifierModifierDetailCh();
	                
	             }//fin Reservation existe
		        
		        } catch (SQLException e) {
		        //e.printStackTrace();
		        JOptionPane.showMessageDialog(null, "Une erreur s'est produite lors de l'enregistrement des données", "Erreur", JOptionPane.ERROR_MESSAGE);
		       } 
		   }//fin Remplir champs
		}

		
/*-------------------------- Partie IIIII : Verifier Les Modifications des details des Chambres -------------------------------------------*/
//Controlleur pour Modifier les details des Chambres :
		public void initControllerVerifierModifierDetailCh() {
			
		    viewAnnModResFacture.getBtnModifier().addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					VerifierModifierDetailCham();
				}
			  });
	       }
		
//Fonction pour  Modifier les details des Chambres :		
		private void VerifierModifierDetailCham() {			
			//Verfier les Champs :
			String numReservationText=viewAnnModResFacture.getTxtNumReservation().getText();
			String numChambreText = viewAnnModResFacture.getTxtNumCham().getText();
	  
		      Connexion connexion = new Connexion();
		       String table = "Chambre";
		       int numChamb = Integer.parseInt(numChambreText);
		       int numReservation = Integer.parseInt(numReservationText);
		       
		       //les donnees de la view apres la saisie :
		       int categorieView=Integer.parseInt(viewAnnModResFacture.getCategorie().getText().toString());
		       int nbAdultesView=Integer.parseInt(viewAnnModResFacture.getNbAdultes().getText().toString());
		       int nbEnfantsView=Integer.parseInt(viewAnnModResFacture.getNbEnfants().getText().toString());
		       
		    try {
		    	connexion.connect();
				 String dataCh="R.idReservation,R.idCategorie,R.nbAdultes,R.nbEnfants,P.prixChambre";
				 String tablesCh=" DetailReservation R, PrixChambre P";
		         String conditionsCh="R.idCategorie=P.idCategorie AND R.numeroCh=P.numeroCh AND R.numeroCh=" + numChamb;//numCh	
		         ResultSet resCh = connexion.getAllData(dataCh, tablesCh, conditionsCh);
		         
		         int idRes=0,categorieP=0,nbAdulte=0,nbEnfant=0; double prix=0.00;
		         while(resCh.next()) {
		        	 idRes=Integer.parseInt(resCh.getString(1));
		        	 categorieP= Integer.parseInt(resCh.getString(2));
		        	 nbAdulte= Integer.parseInt(resCh.getString(3));
		        	 nbEnfant= Integer.parseInt(resCh.getString(4));
		        	 prix= Double.parseDouble(resCh.getString(5)); }
		         
		         int numChaEnService=0; 
		         if(categorieView>=1 && categorieView<=3) {
		        	 if(nbAdultesView==1 || nbAdultesView==2 ) {
		        		 if(nbEnfantsView==0 || nbEnfantsView==1 || nbEnfantsView==2) {

		      if(categorieP==categorieView) {  			 
		    	     numChaEnService=numChamb;
		    	     
			         String tableDetailRes="DetailReservation";
			         String valuesDetailRes="idCategorie="+categorieView+" , "+"numeroCh="+numChaEnService+" , "+"nbAdultes="+nbAdultesView+" , "+"nbEnfants="+nbEnfantsView;
			         String conditionDetailRes="idReservation="+idRes; 
			        
			          connexion.updateData(tableDetailRes,valuesDetailRes,conditionDetailRes);
			         
			      //la Modification da la table PrixChambre
			          
			          String tablePrixCh="PrixChambre";
			          String valuesPrixCh="idCategorie="+categorieView+" , "+"numeroCh="+numChaEnService+","+"prixChambre="+connexion.recalculerPrixCh(numReservation, categorieView, nbAdultesView, nbEnfantsView);      
			          String conditionPrixCh="numeroCh="+ numChamb;
			          
			          connexion.updateData(tablePrixCh, valuesPrixCh, conditionPrixCh);
		      }
		      else {
		         numChaEnService=connexion.Numch(categorieView);
		         
		         //Modifier l'etat de la chambre Ancienne :
		         connexion.updateEtatHorsSer(numChamb);
		         
		       //Modifier l'etat de la Nouvelle Chambre :
		         connexion.updateEtatEnSer(numChaEnService);
		         
		         String tableDetailRes="DetailReservation";
		         String valuesDetailRes="idCategorie="+categorieView+" , "+"numeroCh="+numChaEnService+" , "+"nbAdultes="+nbAdultesView+" , "+"nbEnfants="+nbEnfantsView;
		         String conditionDetailRes="idReservation="+idRes; 
		        
		          connexion.updateData(tableDetailRes,valuesDetailRes,conditionDetailRes);
		         
		      //la Modification da la table PrixChambre
		          
		          String tablePrixCh="PrixChambre";
		          String valuesPrixCh="idCategorie="+categorieView+" , "+"numeroCh="+numChaEnService+","+"prixChambre="+connexion.recalculerPrixCh(numReservation, categorieView, nbAdultesView, nbEnfantsView);      
		          String conditionPrixCh="numeroCh="+ numChamb;
		          
		          connexion.updateData(tablePrixCh, valuesPrixCh, conditionPrixCh);
		      }        
JOptionPane.showMessageDialog(null,  "La chambre de la reservation numero "+numReservation+" modifiée\n      De : [numeroCh="+numChamb +", categorie="+categorieP +", nbAdultes="+nbAdulte+", nbEnfants="+nbEnfant +", Prix="+prix +"]\n       En :  [numeroCh="+numChaEnService +", categorie="+categorieView +", nbAdultes="+nbAdultesView+", nbEnfants="+nbEnfantsView +", Prix="+connexion.recalculerPrixCh(numReservation,categorieView, nbAdultesView, nbEnfantsView) + "]\n avec Succès", "Info", JOptionPane.INFORMATION_MESSAGE);     		
                          viewAnnModResFacture.getFrameDt().setVisible(false);

		        		 }	
		        	else 
				 		JOptionPane.showMessageDialog(null, " le nombre des enfants est incorrect(soit 0, soit 1, soit 2) !! ");

		        	 }
		        	else
		 		       JOptionPane.showMessageDialog(null, " le nombre des adultes est incorrect(soit 1, soit 2) !! ");

		        }
		         else 
		        	 JOptionPane.showMessageDialog(null,"cette categorie n'existe pas!");
		         
		        		        
		        
		        } catch (SQLException e) {
		        //e.printStackTrace();
		        JOptionPane.showMessageDialog(null, "Une erreur s'est produite lors de l'enregistrement des données", "Erreur", JOptionPane.ERROR_MESSAGE);
		       }  
		}

		

//test1 fonction qui affiche les details d une chambre
	   public void afficherInfoChambre() {
		    String numChambreText = viewAnnModResFacture.getTxtNumCham().getText();
		    int numChamb = Integer.parseInt(numChambreText);
		  
			 Connexion connexion= new Connexion();
			 try { 
				 connexion.connect();
				 String dataCh="R.numeroCh,R.idCategorie,R.nbAdultes,R.nbEnfants,P.prixChambre";
				 String tablesCh=" DetailReservation R, PrixChambre P";
		         String conditionsCh="R.idCategorie=P.idCategorie AND R.numeroCh=P.numeroCh AND R.numeroCh=" + numChamb;//numCh	
		         ResultSet resCh = connexion.getAllData(dataCh, tablesCh, conditionsCh);
		         
		         while(resCh.next()) {
		        	 int numR=Integer.parseInt(resCh.getString(1));
		        	 int categorieP= Integer.parseInt(resCh.getString(2));
		        	 int nbAdulte= Integer.parseInt(resCh.getString(3));
		        	 int nbEnfant= Integer.parseInt(resCh.getString(4));
		        	 double prix= Double.parseDouble(resCh.getString(5));
		        	 
		        	// viewAnnModResFacture.setBtnModifier(viewAnnModResFacture.btnModifier);
		        	 
		        	 viewAnnModResFacture.afficherDetailChambre(numR, categorieP, nbAdulte,nbEnfant,prix);
		         } 
		         }
			 catch(SQLException e) {
		        	 e.printStackTrace();} 
		}                            

	
		
		
/*------------------------------------ Verification des Champs (Reservation) : -----------------------------------*/
//cette methode qui permet de verifier est ce que les caracteres sont des chiffres et ne depasse pas 10 chiffres :
	  public void  VerifierChampsReserv() {
		 // Ajouter un KeyListener au champ de texte
			viewAnnModResFacture.getTxtNumReservation().addKeyListener(new KeyAdapter() {
		    @Override
		    public void keyTyped(KeyEvent e) {
		        char c = e.getKeyChar();
		        // Vérifie si le caractère est un chiffre ou non, ou si c'est la touche BACK_SPACE ou DELETE
		        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE)) {
		            e.consume();
		            viewAnnModResFacture.getTxtNumReservation().setBorder(BorderFactory.createLineBorder(Color.RED)); // Change la bordure du champ de texte en rouge
		            java.awt.Toolkit.getDefaultToolkit().beep(); // Ajoute le son de clavier
		        } else {
		            // Vérifie si nous avons déjà 10 chiffres
		            if ( viewAnnModResFacture.getTxtNumReservation().getText().length() == 10) {
		                e.consume();
		                java.awt.Toolkit.getDefaultToolkit().beep(); // Ajoute le son de clavier
		            }
		            viewAnnModResFacture.getTxtNumReservation().setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Change la bordure du champ de texte en noir
		        }
		    }
		  });	
	  }

/*------------------------------------ Verification des Champs (Chambre)  : -----------------------------------*/
	//cette methode qui permet de verifier est ce que les caracteres sont des chiffres et ne depasse pas 10 chiffres :
	  public void VerifierChampsChambre() {
		 // Ajouter un KeyListener au champ de texte
			viewAnnModResFacture.getTxtNumCham().addKeyListener(new KeyAdapter() {
		    @Override
		    public void keyTyped(KeyEvent e) {
		        char c = e.getKeyChar();
		        // Vérifie si le caractère est un chiffre ou non, ou si c'est la touche BACK_SPACE ou DELETE
		        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE)) {
		            e.consume();
		            viewAnnModResFacture.getTxtNumCham().setBorder(BorderFactory.createLineBorder(Color.RED)); // Change la bordure du champ de texte en rouge
		            java.awt.Toolkit.getDefaultToolkit().beep(); // Ajoute le son de clavier
		        } else {
		            // Vérifie si nous avons déjà 10 chiffres
		            if ( viewAnnModResFacture.getTxtNumCham().getText().length() == 10) {
		                e.consume();
		                java.awt.Toolkit.getDefaultToolkit().beep(); // Ajoute le son de clavier
		            }
		            viewAnnModResFacture.getTxtNumCham().setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Change la bordure du champ de texte en noir
		        }
		    }
		  });	
	  }
		
	  
/*
 UPDATE DetailReservation, Categorie
SET DetailReservation.idCategorie=3 AND numeroCh=44 AND nbAdultes=2 AND nbEnfants=3
WHERE DetailReservation.idCategorie=Categorie.idCategorie AND idReservation=22
  */


}
