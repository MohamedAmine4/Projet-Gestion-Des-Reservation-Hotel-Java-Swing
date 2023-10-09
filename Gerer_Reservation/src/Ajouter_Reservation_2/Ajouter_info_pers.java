package Ajouter_Reservation_2;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Ajouter_Reservation_1.Ajouter_RES;
import Connexion.*;
import Main.Frame;

public class Ajouter_info_pers extends JPanel   {
	Ajouter_RES obj;
	double prix_total=0;
	int nombre_chambre;int nombre_nuit;  Date datea;Date dated;
	 String values_detail_Reservation__chambre1;String values_detail_Reservation__chambre2;  String values_detail_Reservation__chambre3;
	Connexion connecter=new Connexion();
	int countv=0;
	JPanel info_pers,nemuro,prixtota;
	JLabel nom,prenom ,telephon,CIN;
	JTextField lnom,lprenom,ltele,lnemuro,lprix,lCIN;
	JButton valider,enregistrer,annuler;
    Frame jo=new Frame();
    Frame jo2=new Frame();
    float prix=0;
	public Ajouter_info_pers(Ajouter_RES obj) {
		jo.add(this);
		jo.setBackground(Color.GRAY);
		jo.setTitle("Information Personnelles");
		 jo.setVisible(true);
		this.setLayout(null);
		 this.setBounds(225,130,1000,500);
	
		  nombre_chambre=obj.nombreChambre() ;
 	     nombre_nuit=((int)obj.diffDate());
 	     datea=obj.getDatea();
 	     dated=obj.getDated();
 	     
 	    values_detail_Reservation__chambre1=obj.getValue_chambre1();
	    values_detail_Reservation__chambre2=obj.getValue_chambre2();
	     values_detail_Reservation__chambre3=obj.getValue_chambre3();
	     
		info_pers=new JPanel();
		info_pers.setLayout(null);
		info_pers.setBounds(70,40,900,270);
		info_pers.setBorder(BorderFactory.createTitledBorder("Information Personnelles"));
		CIN=new JLabel("CIN");
		CIN.setBounds(70,5,70,50);
		lCIN=new JTextField();
		lCIN.setBounds(280,15,300,20);
		nom=new JLabel("NOM");
		nom.setBounds(70,40,70,50);
		prenom=new JLabel("Prenom");
		prenom.setBounds(70,100,70,50);
		telephon=new JLabel("Numero de telephone");
		telephon.setBounds(70,154,150,50);
		lnom=new JTextField(10);
		lnom.setBounds(280,55,300,20);
		lprenom=new JTextField(10);
		lprenom.setBounds(280,112,300,20);
		ltele=new JTextField(10);
		ltele.setBounds(280,170,300,20);
		valider=new JButton("Valider");
		valider.setBounds(790,220,100,40);
		info_pers.add(CIN);
		info_pers.add(lCIN);
		info_pers.add(nom);
		info_pers.add(lnom);
		info_pers.setBackground(Color.GRAY);
		info_pers.add(prenom);
		info_pers.add(lprenom);
		
		info_pers.add(telephon);
		info_pers.add(ltele);
		info_pers.add(valider);
		this.add(info_pers);
		
		nemuro=new JPanel();
		nemuro.setLayout(null);
		nemuro.setBounds(650,325,150,80);
		nemuro.setBorder(BorderFactory.createTitledBorder("Nemuro de Reservation"));
		lnemuro=new JTextField(10);	
		lnemuro.setBounds(30,35,90,30);
		nemuro.add(lnemuro);
		
		this.add(nemuro);
		prix_total=obj.prix_totale();
		
		prixtota=new JPanel();
		prixtota.setLayout(null);
		prixtota.setBounds(820,325,150,80);
		prixtota.setBorder(BorderFactory.createTitledBorder("Prix Totale"));

		lprix=new JTextField(10);
		lprix.setBounds(30,35,90,30);
		prixtota.add(lprix);
		this.add(prixtota);
		enregistrer=new JButton("Enregistrer");
		enregistrer.setBounds(871,420,100,30);
		annuler=new JButton("Annuler");
		annuler.setBounds(760,420,100,30);
		this.add(enregistrer);
		this.add(annuler);
		annuler.addActionListener(this :: Annuler);
		valider.addActionListener(this :: Valider);
		enregistrer.addActionListener(this :: Enregistrer);
		
		
		
	}
	
    public void Annuler(ActionEvent e) {
    	int r=JOptionPane.showConfirmDialog(null,"Souhaitez-vous annuler ?","",JOptionPane.YES_NO_OPTION);
    	if(r==JOptionPane.OK_OPTION) {
    	System.exit(0);
    	}
    } 
    
    public String getLnom() {
		return lnom.getText();
	}

	public String getLprenom() {
		return lprenom.getText();
	}

	public String getLtele() {
		return ltele.getText();
	}

	public String getLnemuro() {
		return lnemuro.getText();
	}

	public String getlCIN() {
		return lCIN.getText();
	}

	public void Valider(ActionEvent e) {
    	String nom=lnom.getText();
    	String prenom=lprenom.getText();
    	String tele=ltele.getText();
    	String cin=lCIN.getText();
         
    	if (nom.isEmpty() || prenom.isEmpty() || tele.isEmpty() || cin.isEmpty() ) {
    		
    	    JOptionPane.showMessageDialog(null, "Remplir les champs");
    	    	}
    	else  if(tele.length()!=10)
	    	  JOptionPane.showMessageDialog(null, "Votre nemuro de telephone doit contient 10 nommbres ");
    	else if(tele.substring(0,2).compareTo("06")!=0 )
    		 JOptionPane.showMessageDialog(null, "Saisir un némuro valide");
    	else {
    	    JOptionPane.showMessageDialog(null, "Validation réussie !");
    	    countv=1;
    	   try {
    	    	
    	    String table1="client";
    	    String table2="Reservation";
    	    String table3="detailreservation";
    	    if(connecter.CINExiste(table2, cin)!=0) {
    	  JOptionPane.showMessageDialog(null, "cin existe");
    	    }
    	    else {  String valuesClient="'"+cin+"', '"+nom+"', '"+prenom+"', '"+tele+"'"; 
    	     connecter.insertData(table1,valuesClient);
    	     }
    	    SimpleDateFormat dateforme = new SimpleDateFormat("yyyy MMMM dd");
    	    SimpleDateFormat dateformes = new SimpleDateFormat("yyyy-MM-dd");
    	    String date_arr = dateformes.format(dateforme.parse(dateforme.format(datea)));
    	    String date_dep = dateformes.format(dateforme.parse(dateforme.format(dated)));
    	    //System.out.println(datea);
    	   // System.out.println(date_arr);
    	    int nemurores=0;
    	   // System.out.println(connecter.CINExiste(table2,cin));
    	    if(connecter.CINExiste(table2,cin)!=0) {
    	    nemurores=connecter.CINExiste(table2,cin);
    	    lprix.setText(""+prix_total);
    	    lnemuro.setText(""+nemurores); }
    	    else {
    	    	nemurores=connecter.getAllData(table2);
    	    	nemurores++;
    	    lprix.setText(""+prix_total);
    	    lnemuro.setText(""+nemurores); 
    	    String valuesReservation="'"+nemurores+"','"+cin+"', "+nombre_chambre+", "+nombre_nuit+", '"+date_arr+"', '"+date_dep+"'";
    	    System.out.println(valuesReservation);
    	    connecter.insertData(table2,valuesReservation);
    	    }
    	    System.out.println(nemurores); 
    	   
    	   System.out.println(nombre_chambre);
    	    
	     if(nombre_chambre==1) {
	    	 System.out.println("ok");
//	    	    if(connecter.CINExiste(table2,cin)!=0)
//	    	    	nemurores=connecter.CINExiste(table2,cin);
//	       	    else {
//	       	    	nemurores=connecter.getAllData(table2);
//	       		nemurores++;
//	       	    }
    	   connecter.insertDatadetRes(table3,nemurores,values_detail_Reservation__chambre1);  
	    	 System.out.println(nemurores);

    	     }
    	     else if(nombre_chambre==2) {
    	    	 System.out.println("2 chambre");
//    	    	 if(connecter.CINExiste(table2,cin)!=0)
//    	    		 nemurores=connecter.CINExiste(table2,cin);
//    	       	    else {
//    	       	    	nemurores=connecter.getAllData(table2);
//    	       	    	nemurores++;
//    	       	    }
        	   connecter.insertDatadetRes(table3,nemurores,values_detail_Reservation__chambre1); 
        	   connecter.insertDatadetRes(table3,nemurores,values_detail_Reservation__chambre2); 
    	    	
    	     }
    	     else {
    	    	 if(connecter.CINExiste(table2,cin)!=0)
//    	    		 nemurores=connecter.CINExiste(table2,cin);
//    	       	    else {
//    	       	    	nemurores=connecter.getAllData(table2);
//    	       	    	nemurores++;
//    	       	    }
    	    	 connecter.insertDatadetRes(table3,nemurores,values_detail_Reservation__chambre1); 
          	   connecter.insertDatadetRes(table3,nemurores,values_detail_Reservation__chambre2); 
          	  connecter.insertDatadetRes(table3,nemurores,values_detail_Reservation__chambre3); 
    	    	
    	     }}
  	catch(Exception ee ) {ee.printStackTrace();}
    	    }
    }
    private void Enregistrer(ActionEvent e) {
 	 if(countv==0)
 	     JOptionPane.showMessageDialog(jo,"Les champs n'ont pas été validés !!");
 	 else { 
 		   JOptionPane.showMessageDialog(jo,"Le Client a été Enregistré avec succés");
 		   jo.setVisible(false);
 		   
 	 }                          
 	 }
    
}
