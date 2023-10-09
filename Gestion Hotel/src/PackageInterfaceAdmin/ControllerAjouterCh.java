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

public class ControllerAjouterCh {
	ModelAjouterCh modelAjouterCh;
	ViewAjouterCh viewAjouterCh;
	ViewSuppModChamService  viewSuppModChamService;
	
	public ControllerAjouterCh(ModelAjouterCh m, ViewAjouterCh v) {
		   modelAjouterCh=m;
		    viewAjouterCh=v;
	}
	
	public void initControllerAjouterCh() {
		viewAjouterCh.getBouttonAjouter().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				EnregistrerInfos();         }
		});
	//Lambda Exprressions
	  viewAjouterCh.getBouttonAnnuler().addActionListener(e->fermer());
	  
	        VerifierChamps();  

}  
	
	private void EnregistrerInfos() {
		//Verfier les Champs :
		String numChamText = viewAjouterCh.getTxtNumChambre().getText();
		if (numChamText.isEmpty()) {
	    	    JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs");
	    } else {     
	      Connexion connexion = new Connexion();
	    try {
	        connexion.connect();
	        
	        //la recuperation des champs :
	        String table = "Chambre";
	        int numCham = Integer.parseInt(numChamText);
	        //int numCham = Integer.parseInt(viewAjouterCh.getTxtNumChambre().getText()); 
	        int etage = Integer.parseInt(viewAjouterCh.getTxtListEtages().getSelectedItem().toString());
	        int nbLits = Integer.parseInt(viewAjouterCh.getTxtListNbLits().getSelectedItem().toString());
	        
	        //la recuperation de la categorie :
	        int idCategorie=0;
	        if (viewAjouterCh.getbRadioSimple().isSelected()) 
	              idCategorie = 1;
	          else if (viewAjouterCh.getbRadioDouble().isSelected()) 
	        	  idCategorie = 2;
	          else if (viewAjouterCh.getbRadioSuite().isSelected()) 
	        	  idCategorie = 3;
	        
	   //Ce champs tres important : Recuperer le numChambre precedent (pour Modifier Chambre) : 
	        int numChambMod=ControllerSuppModChamService.numChamStatic;
	        
            
        	//Verifier l'interface de Modifier Chambre :
        	if(viewAjouterCh.getBouttonAjouter().getText().equals("Modifier")) {
        		
        		String values=null;
        	if(connexion.chambreExiste(table, numCham)==true)	
              values = " etage = " + etage + ", nbLits = " + nbLits + ", idCategorie = '" + idCategorie + "'";
        	else
              values = "numeroCh = " + numCham + ", etage = " + etage + ", nbLits = " + nbLits + ", idCategorie = '" + idCategorie + "'";
	
        String condition = "numeroCh = " + numChambMod;
         connexion.updateData(table, values,condition);
         JOptionPane.showMessageDialog(null, "la chambre numero "+ numChambMod  + " modifiée avec succès", "Info", JOptionPane.INFORMATION_MESSAGE);

            viewAjouterCh.getFrame().setVisible(false);
        	}
	     
      //l'interface d'Ajouter Chambre :  	
        else {
	        // Vérifier si le numéro de chambre existe déjà
	        if (connexion.chambreExiste(table, numCham)==true) {
                JOptionPane.showMessageDialog(null, "Le numéro de chambre " + numCham + " existe déjà.");
            } else {
            	//Verifier l'interface d'Ajouter Chambre : 
            	String etatChambreParDefaut="Hors Service";
            	if(viewAjouterCh.getBouttonAjouter().getText().equals(" Ajouter ")) {
            String values = "'" + numCham + "', " + idCategorie + ", " + nbLits + ", " + etage + ", '" + etatChambreParDefaut + "'" ; 
	        connexion.insertData(table, values);
	         JOptionPane.showMessageDialog(null, "la chambre numero "+numCham+" Enregistré avec succès", "Info", JOptionPane.INFORMATION_MESSAGE); 
	         viewAjouterCh.getFrame().setVisible(false);    
	        // new InterfacePrincipaleAdmin();
	         }
            	
            }//fin Chambre existe
	        
        }
	        } catch (SQLException e) {
	        //e.printStackTrace();
	        JOptionPane.showMessageDialog(null, "Une erreur s'est produite lors de l'enregistrement des données", "Erreur", JOptionPane.ERROR_MESSAGE);
	       } 
	   }//fin Remplir champs
	}
	
	private void fermer() {
		int rep=JOptionPane.showConfirmDialog(null, "Souhaitez-vous fermer cette interface ?");
		  if(rep==JOptionPane.OK_OPTION) {
		 viewAjouterCh.getFrame().setVisible(false);
			 
		   }
			  // System.exit(0);
	}


/*------------------------------------ Verification des Champs : -----------------------------------*/
//cette methode qui permet de verifier est ce que les caracteres sont des chiffres et ne depasse pas 10 chiffres :
	  public void VerifierChamps() {
		 // Ajouter un KeyListener au champ de texte
		   viewAjouterCh.getTxtNumChambre().addKeyListener(new KeyAdapter() {
		    @Override
		    public void keyTyped(KeyEvent e) {
		        char c = e.getKeyChar();
		        // Vérifie si le caractère est un chiffre ou non, ou si c'est la touche BACK_SPACE ou DELETE
		        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE)) {
		            e.consume();
		            viewAjouterCh.getTxtNumChambre().setBorder(BorderFactory.createLineBorder(Color.RED)); // Change la bordure du champ de texte en rouge
		        } else {
		            // Vérifie si nous avons déjà 10 chiffres
		            if ( viewAjouterCh.getTxtNumChambre().getText().length() == 10) {
		                e.consume();
		            }
		             viewAjouterCh.getTxtNumChambre().setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Change la bordure du champ de texte en noir
		        }
		    }
		  });	
		  }


}
