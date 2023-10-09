package PackageInterfaceAgent;

import PackageAjouterReservation.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.event.*;
public class InterfacePrincipaleAgent implements ActionListener{
	JButton btnAjouterRes, btnModifierRes, btnAnnulerRes, btnEtablirFacture ;
	private JFrame frame;
	
	
    public InterfacePrincipaleAgent() {
    	frame=new JFrame();

        // Créer les boutons
    	btnAjouterRes = new JButton("Ajouter Reservation");
    	btnModifierRes = new JButton("Modifier Reservation");
    	btnAnnulerRes = new JButton("Annuler Reservation");
    	btnEtablirFacture = new JButton("Etablir Facture");
    	
    	 // Définir la taille préférée des boutons
        Dimension buttonSize = new Dimension(300, 60);
        btnAjouterRes.setPreferredSize(buttonSize);
        
     // Créer une bordure simple avec une épaisseur de 3 pixels
        Border border = BorderFactory.createLineBorder(Color.BLACK, 3);
        btnAjouterRes.setBorder(border);      btnModifierRes.setBorder(border);
        btnAnnulerRes.setBorder(border);      btnEtablirFacture.setBorder(border);
        //btnAjouterCha.setBackground(Color.GREEN);
        
    // Définir une police de taille 16 pour le texte des boutons
        Font buttonFont = new Font("Arial", Font.BOLD, 14);
        btnAjouterRes.setFont(buttonFont);     btnModifierRes.setFont(buttonFont);
        btnAnnulerRes.setFont(buttonFont);     btnEtablirFacture.setFont(buttonFont);
        btnAjouterRes.setForeground(Color.BLACK);
        btnAjouterRes.setBackground(Color.LIGHT_GRAY);
        btnModifierRes.setForeground(Color.BLACK);
        btnModifierRes.setBackground(Color.LIGHT_GRAY);
        btnAnnulerRes.setForeground(Color.BLACK);
        btnAnnulerRes.setBackground(Color.LIGHT_GRAY);
        btnEtablirFacture.setForeground(Color.BLACK);
        btnEtablirFacture.setBackground(Color.LIGHT_GRAY);

        // Ajouter les boutons à la fenêtre
        JPanel panel = new JPanel(new GridLayout(4,1,40,40));
        panel.add(btnAjouterRes);
        panel.add(btnModifierRes);
        panel.add(btnAnnulerRes);
        panel.add(btnEtablirFacture);
        
   //Panneau Bouttons :
        JPanel panBou=new JPanel();
//		panBou.setBorder(BorderFactory.createTitledBorder("L'interface Principale"));
//		Dimension panSize = new Dimension(500, 440);
//		panBou.setPreferredSize(panSize);
//		Border PanelBorder = BorderFactory.createEmptyBorder(20,2,2,2);
//		panel.setBorder(PanelBorder);
        panel.setBackground(Color.GRAY);
		panBou.add(panel);
		panBou.setBackground(Color.GRAY);
		
    //Le panneau Principale :
		JPanel panPrincipale=new JPanel();
		panPrincipale.add(panBou);
		 Border mainPanelBorder = BorderFactory.createEmptyBorder(100, 40, 20, 20);
	        panPrincipale.setBorder(mainPanelBorder);
	        panPrincipale.setBackground(Color.GRAY);
        
        this.frame.getContentPane().add(panPrincipale);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.pack();
        //this.frame.setSize(700,700);
        this.frame.setSize(5000,5000);
        this.frame.setVisible(true);
        this.frame.setTitle("Interface de l'agent");
        
        ImageIcon icone=new ImageIcon("src/images/icone_Hotel.png");
        this.frame.setIconImage(icone.getImage());

        // Ajouter les listeners pour les boutons
        btnAjouterRes.addActionListener(this);
        btnModifierRes.addActionListener(this);
        btnAnnulerRes.addActionListener(this);
        btnEtablirFacture.addActionListener(this);
        }

// Gérer les événements de clic sur les boutons
		public void actionPerformed(ActionEvent e) {
		    if (e.getSource() == btnAjouterRes) {
          // Afficher l'interface pour ajouter une reservation
		    	new Ajouter_RES();
		    	
		    } else if (e.getSource() == btnModifierRes) {
		  // Afficher l'interface pour modifier une reservation
		    	ViewAnnModResFacture vModifierRes=new ViewAnnModResFacture("Modifier Reservation");
		    	ControllerAnnModResFacture cModifierRes=new ControllerAnnModResFacture(null, vModifierRes);
		    	cModifierRes.initControllerModifierRes();
		    	
		    } else if (e.getSource() == btnAnnulerRes) {
		  // Afficher l'interface pour annuler une reservation
		    	ViewAnnModResFacture vAnnulerRes=new ViewAnnModResFacture("Annuler Reservation");
		    	ControllerAnnModResFacture cAnnulerRes=new ControllerAnnModResFacture(null, vAnnulerRes);
		    	cAnnulerRes.initControllerAnnulerRes();
		    	
		    } else if (e.getSource() == btnEtablirFacture) {
		  // Afficher l'interface pour etablir facture
		    	ViewAnnModResFacture vEtablirFact=new ViewAnnModResFacture("Etablir Facture");
		    	ControllerAnnModResFacture cEtablirFact=new ControllerAnnModResFacture(null, vEtablirFact);
		    	cEtablirFact.initControllerEtablirFacture();
		    	
		    }
		}

}
