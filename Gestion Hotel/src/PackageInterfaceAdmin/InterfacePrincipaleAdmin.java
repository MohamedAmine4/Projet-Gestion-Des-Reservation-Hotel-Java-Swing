package PackageInterfaceAdmin;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.event.*;
public class InterfacePrincipaleAdmin implements ActionListener{
	JButton btnAjouterCha, btnModifierCha, btnSupprimerCha, btnHorsService ;
	private JFrame frame;
	
	
    public InterfacePrincipaleAdmin() {
    	frame=new JFrame();

        // Créer les boutons
    	btnAjouterCha = new JButton("Ajouter Chambre");
    	btnModifierCha = new JButton("Modifier Chambre");
    	btnSupprimerCha = new JButton("Supprimer Chambre");
    	btnHorsService = new JButton("Rendre Hors Service");
    	
    	 // Définir la taille préférée des boutons
        Dimension buttonSize = new Dimension(300, 60);
        btnAjouterCha.setPreferredSize(buttonSize);
        
     // Créer une bordure simple avec une épaisseur de 3 pixels
        Border border = BorderFactory.createLineBorder(Color.BLACK, 3);
        btnAjouterCha.setBorder(border);      btnModifierCha.setBorder(border);
        btnSupprimerCha.setBorder(border);    btnHorsService.setBorder(border);
        //btnAjouterCha.setBackground(Color.GREEN);
        
    // Définir une police de taille 16 pour le texte des boutons
        Font buttonFont = new Font("Arial", Font.BOLD, 14);
        btnAjouterCha.setFont(buttonFont);     btnModifierCha.setFont(buttonFont);
        btnSupprimerCha.setFont(buttonFont);     btnHorsService.setFont(buttonFont);
        btnAjouterCha.setForeground(Color.BLACK);
        btnAjouterCha.setBackground(Color.LIGHT_GRAY);
        btnModifierCha.setForeground(Color.BLACK);
        btnModifierCha.setBackground(Color.LIGHT_GRAY);
        btnSupprimerCha.setForeground(Color.BLACK);
        btnSupprimerCha.setBackground(Color.LIGHT_GRAY);
        btnHorsService.setForeground(Color.BLACK);
        btnHorsService.setBackground(Color.LIGHT_GRAY);
        
        // Ajouter les boutons à la fenêtre
        JPanel panel = new JPanel(new GridLayout(4,1,40,40));
        panel.add(btnAjouterCha);
        panel.add(btnModifierCha);
        panel.add(btnSupprimerCha);
        panel.add(btnHorsService);
        
   //Panneau Bouttons :
        JPanel panBou=new JPanel();
//		panBou.setBorder(BorderFactory.createTitledBorder("L'interface Principale"));
//		Dimension panSize = new Dimension(500, 440);
//		panBou.setPreferredSize(panSize);
//		Border PanelBorder = BorderFactory.createEmptyBorder(20,2,2,2);
//		panel.setBorder(PanelBorder);
		panBou.add(panel);
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
        this.frame.setSize(5000,5000);
        //this.frame.setSize(700,670);
        //this.frame.setResizable(false);
        //this.frame.setLocationRelativeTo(null);
        this.frame.setVisible(true);
        this.frame.setTitle("Interface de l'administrateur");
        
        ImageIcon icone=new ImageIcon("src/images/icone_Hotel.png");
        this.frame.setIconImage(icone.getImage());

        // Ajouter les listeners pour les boutons
        btnAjouterCha.addActionListener(this);
        btnModifierCha.addActionListener(this);
        btnSupprimerCha.addActionListener(this);
        btnHorsService.addActionListener(this);
        }

// Gérer les événements de clic sur les boutons
		public void actionPerformed(ActionEvent e) {
		    if (e.getSource() == btnAjouterCha) {
          // Afficher l'interface pour ajouter une chambre
		    	ViewAjouterCh  vAjouterCh=new ViewAjouterCh("Ajouter Chambre");
		    	ControllerAjouterCh cAjouterCh=new ControllerAjouterCh(null, vAjouterCh);
		    	cAjouterCh.initControllerAjouterCh();
	
		    } else if (e.getSource() == btnModifierCha) {
		  // Afficher l'interface pour modifier une chambre
		    	ViewSuppModChamService vModifierCh=new ViewSuppModChamService("Modifier Chambre");
		    	ControllerSuppModChamService cModifierCh=new ControllerSuppModChamService(null, vModifierCh);
		    	cModifierCh.initControllerModifierChamb();
		    	
		    } else if (e.getSource() == btnSupprimerCha) {
		  // Afficher l'interface pour supprimer une chambre
		    	 ViewSuppModChamService vSupprimerCh=new ViewSuppModChamService("Supprimer Chambre");
		    	 ControllerSuppModChamService cSupprimerCh=new ControllerSuppModChamService(null, vSupprimerCh);
		    	 cSupprimerCh.initControllerSupprimerChamb();
		    	
		    } else if (e.getSource() == btnHorsService) {
		  // Afficher l'interface pour mettre une chambre hors service
		    	ViewSuppModChamService vHorsService=new ViewSuppModChamService("Chambre Hors Service");
		    	ControllerSuppModChamService cHorsService=new ControllerSuppModChamService(null, vHorsService);
		    	cHorsService.initControllerHorsService();
		    }
		}

}
