package PackageInterfaceAdmin;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class ViewSuppModChamService {
	private JFrame frame; private JPanel panPrincipale;
	private JLabel labelChambre;  private JTextField txtNumChambre; 
	private JButton bouttonRechercher, saveButtonService;
	private JSlider sliderService;
	
	public ViewSuppModChamService(String titre) {
		frame=new JFrame();
		this.frame.setLayout(null);
//le panneau Supprimer/Modifier Chambre et Hors-Service :
		JPanel panSuppModChamSer=new JPanel();
		TitledBorder borderSai = BorderFactory.createTitledBorder(titre);
		panSuppModChamSer.setBorder(borderSai);
		panSuppModChamSer.setLayout(null);
		panSuppModChamSer.setBounds(25,25,620, 180);
		
		labelChambre=new JLabel("Numero de Chambre : ");  labelChambre.setBounds(40,20,200,50);   panSuppModChamSer.add(labelChambre);
		txtNumChambre=new JTextField();  txtNumChambre.setBounds(220,30,350,35); panSuppModChamSer.add(txtNumChambre);
		bouttonRechercher=new JButton(" Rechercher "); bouttonRechercher.setBounds(450,80,120,30); panSuppModChamSer.add(bouttonRechercher);
		
		//Le panneau Principale :
		panPrincipale=new JPanel();
		panPrincipale.setLayout(null);
		panPrincipale.add(panSuppModChamSer); 
		
	    
		
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
	
//l'etat de la chambre (En Service/Hors Service)
	public void interfaceEtatChambre() {
		int numCham=ControllerSuppModChamService.numChamStaticService;
		
	    JPanel panel = new JPanel();
	    JLabel labelChambre = new JLabel("la Chambre Numero "+numCham);
	    labelChambre.setBounds(30, 35, 150, 50);

	    JLabel labelEnService = new JLabel("En Service");
	    labelEnService.setBounds(270, 35, 80, 50);
	    
	    JLabel labelHorsService = new JLabel("Hors Service");
	    labelHorsService.setBounds(500, 35, 100, 50);
	    
	    sliderService = new JSlider(JSlider.HORIZONTAL, 0, 1, 0); // 1 = Hors Service, 0 = En Service
	    sliderService.setMajorTickSpacing(1);
	    sliderService.setPaintTicks(true);
	    sliderService.setPaintLabels(true);
	    sliderService.setBounds(350, 50, 140, 50);
	    
	   saveButtonService = new JButton("Enregistrer");
	   saveButtonService.setBounds(480, 120, 120, 35);
		
	    panel.setLayout(null);
	    panel.setBounds(25,240,620,180);
	    
	    panel.setBorder(BorderFactory.createTitledBorder("L'état de la Chambre"));
	  
	    panel.add(labelChambre);
	    panel.add(labelEnService);
	    panel.add(labelHorsService);
	    panel.add(sliderService);
	    panel.add(saveButtonService);
	    panPrincipale.add(panel);
	    
	    this.frame.setContentPane(panPrincipale);
	    this.frame.setVisible(true);
	        
	}
	
//Getters et Setters :
	public JTextField getTxtNumChambre() {
		return txtNumChambre;
	}

	public void setTxtNumChambre(JTextField txtNumChambre) {
		this.txtNumChambre = txtNumChambre;
	}

	public JButton getBouttonRechercher() {
		return bouttonRechercher;
	}

	public void setBouttonRechercher(JButton bouttonRechercher) {
		this.bouttonRechercher = bouttonRechercher;
	}

	public JButton getSaveButtonService() {
		return saveButtonService;
	}

	public void setSaveButtonService(JButton saveButtonService) {
		this.saveButtonService = saveButtonService;
	}

	public JSlider getSliderService() {
		return sliderService;
	}

	public void setSliderService(JSlider sliderService) {
		this.sliderService = sliderService;
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	
	
	
	
	
	
	
	



}
