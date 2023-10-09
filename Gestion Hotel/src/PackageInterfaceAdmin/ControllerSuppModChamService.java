package PackageInterfaceAdmin;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.*;
import javax.swing.BorderFactory;
//import java.sql.SQLException;
import javax.swing.JOptionPane;

import Test_Hotel_MVC.Connexion;

import javax.swing.*;

public class ControllerSuppModChamService {
		ModelSuppModChamService modelSuppModChamService;
		ViewSuppModChamService  viewSuppModChamService;
		static int numChamStatic;
		static int numChamStaticService;
		static String etatChambre;
		
		public ControllerSuppModChamService(ModelSuppModChamService m, ViewSuppModChamService v) {
			 modelSuppModChamService=m;
			 viewSuppModChamService=v;
		}
/*-------------------------- Partie I : Supprimer Chambre : -------------------------------------------*/		
//Controlleur pour Supprimer Chambre :		
		public void initControllerSupprimerChamb() {
			viewSuppModChamService.getBouttonRechercher().addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					SupprimerChambre();   
					viewSuppModChamService.getFrame().setVisible(false);
					}
			  });
	                VerifierChamps();
	               
	      }	
		
//Fonction pour Supprimer Chambre :		
		private void SupprimerChambre() {
			//Verfier les Champs :
			String numChamText = viewSuppModChamService.getTxtNumChambre().getText();
		  if (numChamText.isEmpty()) {
		    	    JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs");
		  } else {     
		      Connexion connexion = new Connexion();
		    try {
		        connexion.connect();
		        
		        //la recuperation des champs :
		        String table = "Chambre";
		        int numCham = Integer.parseInt(numChamText);
		        
	            // Vérifier si le numéro de chambre n'existe pas
		        if (connexion.chambreExiste(table, numCham)==false) 
	                JOptionPane.showMessageDialog(null, "Le numéro de chambre " + numCham + " n'existe pas dans la table.");
	            else {
	            	int rep=JOptionPane.showConfirmDialog(null, "Souhaitez-vous supprimer le numero de chambre "+ numCham +" ?");
	      		      if(rep==JOptionPane.OK_OPTION) {
	      		    	String condition = "numeroCh = " + numCham;
	      		    	  connexion.deleteData(table,condition);
	      		    	JOptionPane.showMessageDialog(null, "Le numéro de chambre " + numCham + " est bien supprime.");
	      		      }
	      		    	
	             }//fin Chambre existe
		        
		        } catch (SQLException e) {
		        //e.printStackTrace();
		        JOptionPane.showMessageDialog(null, "Une erreur s'est produite lors de l'enregistrement des données", "Erreur", JOptionPane.ERROR_MESSAGE);
		       }  
		   }//fin Remplir champs
		}

		
/*-------------------------- Partie II : Modifier Chambre -------------------------------------------*/
//Controlleur pour Modifier Chambre :
		public void initControllerModifierChamb() {
			viewSuppModChamService.getBouttonRechercher().addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					 ModifierChambre();  
					 viewSuppModChamService.getFrame().setVisible(false);
				}
			  });
	                 VerifierChamps();
	       }
		
//Fonction pour Modifier Chambre :
		private void ModifierChambre() {
			//Verfier les Champs :
			String numChamText = viewSuppModChamService.getTxtNumChambre().getText();
		  if (numChamText.isEmpty()) {
		    	    JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs");
		  } else {     
		      Connexion connexion = new Connexion();
		    try {
		        connexion.connect();
		        
		        //la recuperation des champs :
		        String table = "Chambre";
		         int numCham = Integer.parseInt(numChamText);
		         
		            numChamStatic=numCham; //pour utiliser dans l'interface Modifier Chambre
		            
	            // Vérifier si le numéro de chambre n'existe pas
		        if (connexion.chambreExiste(table, numCham)==false) 
	                JOptionPane.showMessageDialog(null, "Le numéro de chambre " + numCham + " n'existe pas dans la table.");
	            else {
//	                JOptionPane.showMessageDialog(null, "Le numéro de chambre " + numCham + " existe dans la table.");
	            	ViewAjouterCh  vAjouterCh=new ViewAjouterCh("Modifier Chambre");
	            	ControllerAjouterCh cAjouterCh=new ControllerAjouterCh(null, vAjouterCh);
	            	cAjouterCh.initControllerAjouterCh();
	            	
	            	ResultSet res=connexion.getAllData(table,numCham);
	            	while(res.next()) {
	            	  int idCategorie=Integer.parseInt(res.getString(2)); int nbLits=res.getInt(3); int etage=res.getInt(4); 
	                
	            	vAjouterCh.getBouttonAjouter().setText("Modifier");
	            	vAjouterCh.getTxtNumChambre().setText(""+numCham);
	            	vAjouterCh.getTxtListEtages().setSelectedItem(""+etage);
	            	vAjouterCh.getTxtListNbLits().setSelectedItem(""+nbLits);
	            	
	            	if(idCategorie==1)
	            	vAjouterCh.getbRadioSimple().setSelected(true);
	            	if(idCategorie==2)
		            	vAjouterCh.getbRadioDouble().setSelected(true);
	            	if(idCategorie==3)
		            	vAjouterCh.getbRadioSuite().setSelected(true);
	            	}
	             }//fin Chambre existe
		        
		        } catch (SQLException e) {
		        //e.printStackTrace();
		        JOptionPane.showMessageDialog(null, "Une erreur s'est produite lors de l'enregistrement des données", "Erreur", JOptionPane.ERROR_MESSAGE);
		       }  
		   }//fin Remplir champs
		}
						
		
/*-------------------------- Partie III : Hors Service -------------------------------------------*/
//Controlleur pour Hors Service :
		public void initControllerHorsService() {
			viewSuppModChamService.getBouttonRechercher().addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					  HorsService();
					  ModifierEtatChambre();
					  afficherEtatChambre();
				}
			  });
	                  VerifierChamps();
	                  
	       }
		
//Fonction pour Hors Service :
		private void HorsService() {
			//Verfier les Champs :
			String numChamText = viewSuppModChamService.getTxtNumChambre().getText();
		  if (numChamText.isEmpty()) {
		    	    JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs");
		  } else {     
		      Connexion connexion = new Connexion();
		    try {
		        connexion.connect();
		        
		        //la recuperation des champs :
		        String table = "Chambre";
		        int numCham = Integer.parseInt(numChamText);
		        
		     //Pour Hors Service :
		        numChamStaticService=numCham;
		        
	            // Vérifier si le numéro de chambre n'existe pas
		        if (connexion.chambreExiste(table, numCham)==false) 
	                JOptionPane.showMessageDialog(null, "Le numéro de chambre " + numCham + " n'existe pas dans la table.");
	            else {
//	                JOptionPane.showMessageDialog(null, "Le numéro de chambre " + numCham + " existe dans la table.");
	            	viewSuppModChamService.interfaceEtatChambre();
	            	
	             }//fin Chambre existe
		        
		        } catch (SQLException e) {
		        //e.printStackTrace();
		        JOptionPane.showMessageDialog(null, "Une erreur s'est produite lors de l'enregistrement des données", "Erreur", JOptionPane.ERROR_MESSAGE);
		       } 
		   }//fin Remplir champs
		}
		
//Modifier Etat de la chambre :
		public void ModifierEtatChambre() {
		    viewSuppModChamService.getSaveButtonService().addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
		            int etatChambreSlider = viewSuppModChamService.getSliderService().getValue(); // Récupérer l'état actuel de la chambre (0 pour En Service, 1 pour Hors Service)
		    
		               if(etatChambreSlider==0)
		            	   etatChambre="En Service";
		               if(etatChambreSlider==1)
		            	   etatChambre="Hors Service";
		               
		            Connexion connexion = new Connexion();
				    try {
				        connexion.connect();
				        String table = "Chambre";
				        String values= "etatCh = " + "'" + etatChambre +"'";
				        String condition = "numeroCh = " + numChamStaticService ;
				        connexion.updateEtatChambre(table,values,condition);
				        
				        JOptionPane.showMessageDialog(null, "L'etat maintenant de la Chambre Numero " + numChamStaticService + " est "+etatChambre);
				        viewSuppModChamService.getFrame().setVisible(false);
		            
				    } catch (SQLException exp) {
				        //e.printStackTrace();
				        JOptionPane.showMessageDialog(null, "Une erreur s'est produite lors de l'enregistrement des données", "Erreur", JOptionPane.ERROR_MESSAGE);
				       }  
		        }
		    });
		}

public void afficherEtatChambre() {
		  // Récupérer l'état actuel de la chambre depuis la base de données
	    String etatChambre = "";
	    Connexion connexion = new Connexion();
	    try {
	        connexion.connect();
	        String table="Chambre";
	        int condition=numChamStaticService;
	        etatChambre=connexion.etatChambre(table, condition);
	    } catch (SQLException e) {
	        JOptionPane.showMessageDialog(null, "Une erreur s'est produite lors de la récupération des données", "Erreur", JOptionPane.ERROR_MESSAGE);
	    } 
	    // Définir la valeur du curseur du JSlider en fonction de l'état actuel de la chambre
	    int etatChambreSlider = 0;
	    if (etatChambre.equals("Hors Service"))
	        etatChambreSlider = 1;
	    
	    viewSuppModChamService.getSliderService().setValue(etatChambreSlider);
	
	    // Mettre à jour l'affichage du JSlider
	    viewSuppModChamService.getSliderService().updateUI(); 
}

		
/*------------------------------------ Verification des Champs : -----------------------------------*/
//cette methode qui permet de verifier est ce que les caracteres sont des chiffres et ne depasse pas 10 chiffres :
	  public void VerifierChamps() {
		 // Ajouter un KeyListener au champ de texte
		   viewSuppModChamService.getTxtNumChambre().addKeyListener(new KeyAdapter() {
		    @Override
		    public void keyTyped(KeyEvent e) {
		        char c = e.getKeyChar();
		        // Vérifie si le caractère est un chiffre ou non, ou si c'est la touche BACK_SPACE ou DELETE
		        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE)) {
		            e.consume();
		            viewSuppModChamService.getTxtNumChambre().setBorder(BorderFactory.createLineBorder(Color.RED)); // Change la bordure du champ de texte en rouge
		            java.awt.Toolkit.getDefaultToolkit().beep(); // Ajoute le son de clavier
		        } else {
		            // Vérifie si nous avons déjà 10 chiffres
		            if ( viewSuppModChamService.getTxtNumChambre().getText().length() == 10) {
		                e.consume();
			            java.awt.Toolkit.getDefaultToolkit().beep(); // Ajoute le son de clavier
		            }
		            viewSuppModChamService.getTxtNumChambre().setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Change la bordure du champ de texte en noir
		        }
		    }
		  });	
	  }
	  
		
//	  private boolean estModification() {
//		    String titre = viewSuppModChamService.getTitre();
//		    return titre.equals("Modifier Chambre");
//		}



}