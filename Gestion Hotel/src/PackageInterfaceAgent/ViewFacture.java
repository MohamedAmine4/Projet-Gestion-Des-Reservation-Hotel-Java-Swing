package PackageInterfaceAgent;

import java.awt.BorderLayout;
import java.util.Date;
import javax.swing.*;


public class ViewFacture extends JFrame {
	
    JLabel labelPayment,labelNumero,labelMontant,labelDate;
	JTextField numero,date,montant;
	
    JButton bConfirmer,bAnnuler,bPrecedant;
    String[] elements= {"Choisir le type de Payment","Cheque","Liquide","Espece"};
    JComboBox<String> jTypePay;
	
    JPanel panel1,panelRecherche,panelCheque;
    
    ViewFacture(){
		
	    panel1=new JPanel();
	    panelRecherche=new JPanel();
	    panelCheque= new  JPanel();
	    
	    
	  	bConfirmer=new JButton("Confirmer");
	  	bAnnuler=new JButton("Annuler");
	 	bPrecedant=new JButton("Precedant");
	 	
	 	labelPayment=new JLabel("Type de Payement:");
	 	
	 	labelNumero=new JLabel("Numero:");
		labelMontant=new JLabel("Montant:");
		
		labelDate=new JLabel("Date de validité:");
		
		numero=new JTextField(15);
		montant=new JTextField(15);
		date=new JTextField(15);
	 	
	 	jTypePay=new JComboBox(elements);
	    panel1.setLayout(null);
	    
	    panelRecherche.setLayout(null);
		panelRecherche.setBounds(20, 35,600, 120);
		panelRecherche.setBorder(BorderFactory.createTitledBorder("Choisir le type de Payement :"));
		
		
		labelPayment.setBounds(30,45 ,150 ,30 );
		jTypePay.setBounds(280, 45,220 ,30 );

		panelRecherche.add(labelPayment);
		panelRecherche.add(jTypePay);
		
		afficherChampCheque();
		
		bAnnuler.setBounds(520, 450, 100,30 );
		bConfirmer.setBounds(410, 450, 100,30 );
		bPrecedant.setBounds(300, 450, 100,30 );
		
		panel1.add(panelRecherche);
		panel1.add(bAnnuler);
		panel1.add(bConfirmer);
		panel1.add(bPrecedant);
	
		
		this.setTitle("Facture du  "+new Date());
		this.setContentPane(panel1);
		this.setSize(700,560);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

    }

	public void afficherChampCheque() {
//		JFrame frameCheq=new JFrame();
		    panelCheque.setLayout(null);
		    panelCheque.setBounds(20,180,600, 200);
		    panelCheque.setBorder(BorderFactory.createTitledBorder("Données du Chéque :"));
    		    
    		    labelNumero.setBounds(20,40 ,150 ,20 );
    		    numero.setBounds(200,40 ,150 ,20 );
    		    labelMontant.setBounds(20,90 ,150 ,20 );
    		    montant.setBounds(200,90 , 150,20 );
    		    labelDate.setBounds(20, 130,150 ,20 );
    		    date.setBounds(200,130 ,150 ,20 );
    		    
    		    panelCheque.add(labelNumero); panelCheque.add(numero);
    		    panelCheque.add(labelMontant); panelCheque.add(montant);
    		    panelCheque.add(labelDate); panelCheque.add(date);
    		    
    		    panel1.add(panelCheque);
    			this.add(panel1);
    			this.setVisible(true);	
    		    
}

	public JTextField getNumero() {
		return numero;
	}

	public void setNumero(JTextField numero) {
		this.numero = numero;
	}

	public JTextField getDate() {
		return date;
	}

	public void setDate(JTextField date) {
		this.date = date;
	}

	public JTextField getMontant() {
		return montant;
	}

	public void setMontant(JTextField montant) {
		this.montant = montant;
	}
  
	
	
    	
}