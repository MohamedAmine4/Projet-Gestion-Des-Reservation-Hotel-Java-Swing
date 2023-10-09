package Ajouter_Reservation_1;



import Main.Frame;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Objects;

import javax.swing.BorderFactory;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import Ajouter_Reservation_2.Ajouter_info_pers;
import Connexion.Connexion;

public class Ajouter_RES extends JPanel  {

	Connexion connecter=new Connexion();
	double prix_s=500,prix_total=0,prix_reduction=0;
	double prixch1=0,prixch2=0,prixch3=0;
	//int id_Reservation=connecter.getAllData("detailreservation");
	 
	double prix_d=1000,prix_su=1200;
	int nbr_adulte1,nbr_adulte2,nbr_adulte3;
	String value_chambre1,value_chambre2,value_chambre3;
	private static int r=75,r2=75,r3=75;
	private int count=0,enre1=0,enre2=0,enre3=0;
  private JDateChooser datea,dated;
	  Frame j1=new Frame();
	  Frame j2=new Frame();
	  Frame j3=new Frame();
	JLabel date_arriver,date_depart,nombre_adulte,nombre_enfant;
	JButton btnajouter,btnretour,btnverifier,btnplus,btnmoins,btnplus2,btnmoins2,btnenregistrer2,btnenregistrer1,btnannuler2;
	JButton btnplus3,btnmoins3,btnenregistrer3,btnannuler3;
	JRadioButton chambre_s,chambre_d,suite ,chambre_s2,chambre_d2,suite2 ,chambre_s3,chambre_d3,suite3;
	JComboBox nombradu,newAgeComboBox ;
	JTextField btwnpm,btwnpm2,btwnpm3;
	JTextField adulte_1,adulte_2,adulte_3;
	String [] nombradulte= {"1","2"};
	String [] agee= {"Age de l'enfant","0","1","2","3","4","5","6","7","8","9","10","11","12"};
	public JPanel chambre1,chambre2,chambre3;
	ButtonGroup btn,btnadulte,btn2,btn3;
	public Ajouter_RES() {
		j3.setLayout(null);
		 j3.setBounds(225,130,1000,450);
		j2.setLayout(null);
		 j2.setBounds(225,130,1000,450);
	j1.add(this);
	j1.setTitle("Ajouter Reservation");
	j1.setVisible(true);
	 this.setLayout(null);
	 this.setBounds(225,130,1000,500);
	 datea=new JDateChooser();
	 datea.setBounds(765,15,200,20);
	 dated=new JDateChooser();
	 dated.setBounds(765,40,200,20);
	    date_arriver=new JLabel("Date d'arriver");
		date_depart=new JLabel("Date de depart");
		btnajouter=new JButton("Ajouter une Chambre");
		btnajouter.setBounds(765,68,200,20);
		date_depart.setBounds(80,22,100,80);
		date_arriver.setBounds(80,1,100,80);
		this.add(datea);
		this.add(dated);
		this.add(date_arriver);
		this.add(date_depart);
		this.add(btnajouter);
		//chambre
			chambre1=new JPanel();chambre1.setLayout(null);
		chambre1.setBorder(BorderFactory.createTitledBorder("Chambre 1"));
		chambre1.setBounds(70,90,900,300);
		chambre_s=new JRadioButton("chambre simple");
		chambre_s.setBounds(70,20,180,20);
		chambre_s.setSelected(true);
		chambre_d=new JRadioButton("chambre double");
		chambre_d.setBounds(400,20,180,20);
		suite=new JRadioButton("suite");
		suite.setBounds(750,20,100,20);
		btn=new ButtonGroup();
		btn.add(chambre_s);
		btn.add(chambre_d);
		btn.add(suite);
		nombre_adulte=new JLabel("Nombre d'adultes");
		nombre_adulte.setBounds(75,80,100,20);
//		adulte_1=new JRadioButton("1");
//		adulte_1.setBounds(700,80,90,20);
//		adulte_2=new JRadioButton("2");
//		adulte_2.setBounds(790,80,200,20);
//		btnadulte=new ButtonGroup();
//		btnadulte.add(adulte_1);
//		btnadulte.add(adulte_2);
		//nombradu=new JComboBox(nombradulte);
		//nombradu.setBounds(690,80,200,20);
		adulte_1=new JTextField(5);
		adulte_1.setBounds(765,80,90,20);
		nombre_enfant=new JLabel("Nombre d'enfants");
		nombre_enfant.setBounds(75,150,150,20);
		btnmoins=new JButton("-");
		btnmoins.setBounds(700,150,40,20);
	
		btwnpm=new JTextField(5);
		btwnpm.setBounds(765,150,40,20);
		btwnpm.setText("0");
		btnplus=new JButton("+");
		btnplus.setBounds(825,150,45,20);
	     btnenregistrer1=new JButton("Enregister");
		btnenregistrer1.setBounds(780,260,100,30);
    //age=new JComboBox(agee);
	//	age.setBounds(75,240,150,20);
		chambre1.add(chambre_s);
		chambre1.add(chambre_d);
		chambre1.add(suite);
		chambre1.add(nombre_adulte);
		chambre1.add(adulte_1);
		//chambre1.add(adulte_2);
		chambre1.add(nombre_enfant);
		chambre1.add(btnmoins);
		chambre1.add(btwnpm);
		chambre1.add(btnplus);
		chambre1.add(btnenregistrer1);
		//chambre1.add(age);
		this.add(chambre1);
		
		btnretour=new JButton("Retour");
		btnretour.setBounds(760,400,100,30);
		btnverifier=new JButton("Verifier");
		btnverifier.setBounds(870,400,100,30);
		this.add(btnretour);
		this.add(btnverifier);
		//////////////////////////////////////////////////  Chambre2     /////////////////////////////////////////////
		chambre2=new JPanel();chambre2.setLayout(null);
		chambre2.setBorder(BorderFactory.createTitledBorder("Chambre 2"));
		chambre2.setBounds(40,10,900,300);
		chambre_s2=new JRadioButton("chambre simple");
		chambre_s2.setBounds(70,20,180,20);
		chambre_s2.setSelected(true);
		chambre_d2=new JRadioButton("chambre double");
		chambre_d2.setBounds(400,20,180,20);
		suite2=new JRadioButton("suite");
		suite2.setBounds(750,20,100,20);
		btn2=new ButtonGroup();
		btn2.add(chambre_s2);
		btn2.add(chambre_d2);
		btn2.add(suite2);
		nombre_adulte=new JLabel("Nombre d'adultes");
		nombre_adulte.setBounds(75,80,100,20);
//		adulte_1=new JRadioButton("1");
//		adulte_1.setBounds(700,80,90,20);
//		adulte_2=new JRadioButton("2");
//		adulte_2.setBounds(790,80,200,20);
//		btnadulte=new ButtonGroup();
//		btnadulte.add(adulte_1);
//		btnadulte.add(adulte_2);
		//nombradu=new JComboBox(nombradulte);
		//nombradu.setBounds(690,80,200,20);
		adulte_2=new JTextField(5);
		adulte_2.setBounds(765,80,90,20);
		nombre_enfant=new JLabel("Nombre d'enfants");
		nombre_enfant.setBounds(75,150,150,20);
		btnmoins2=new JButton("-");
		btnmoins2.setBounds(700,150,40,20);

		btwnpm2=new JTextField(5);
		btwnpm2.setBounds(765,150,40,20);
		btwnpm2.setText("0");
		btnplus2=new JButton("+");
		btnplus2.setBounds(825,150,45,20);
		 btnenregistrer2=new JButton("Enregister");
			btnenregistrer2.setBounds(780,260,100,30);
			 btnannuler2=new JButton("Annuler");
				btnannuler2.setBounds(660,260,100,30);
    //age=new JComboBox(agee);
	//	age.setBounds(75,240,150,20);
		chambre2.add(chambre_s2);
		chambre2.add(chambre_d2);
		chambre2.add(suite2);
		chambre2.add(nombre_adulte);
		chambre2.add(adulte_2);
		//chambre2.add(adulte_2);
		chambre2.add(nombre_enfant);
		chambre2.add(btnmoins2);
		chambre2.add(btwnpm2);
		chambre2.add(btnplus2);
		chambre2.add(btnenregistrer2);
		chambre2.add(btnannuler2);
	
		//////////////////////////////////////////////////  Chambre3    /////////////////////////////////////////////
		chambre3=new JPanel();chambre3.setLayout(null);
		chambre3.setBorder(BorderFactory.createTitledBorder("Chambre 3"));
		chambre3.setBounds(40,10,900,300);
		chambre_s3=new JRadioButton("chambre simple");
		chambre_s3.setBounds(70,20,180,20);
		chambre_s3.setSelected(true);
		chambre_d3=new JRadioButton("chambre double");
		chambre_d3.setBounds(400,20,180,20);
		suite3=new JRadioButton("suite");
		suite3.setBounds(750,20,100,20);
		btn3=new ButtonGroup();
		btn3.add(chambre_s3);
		btn3.add(chambre_d3);
		btn3.add(suite3);
		nombre_adulte=new JLabel("Nombre d'adultes");
		nombre_adulte.setBounds(75,80,100,20);
		//nombradu=new JComboBox(nombradulte);
		//nombradu.setBounds(690,80,200,20);
//		adulte_1=new JRadioButton("1");
//		adulte_1.setBounds(700,80,90,20);
//		adulte_2=new JRadioButton("2");
//		adulte_2.setBounds(790,80,200,20);
//		btnadulte=new ButtonGroup();
//		btnadulte.add(adulte_1);
//		btnadulte.add(adulte_2);
		adulte_3=new JTextField(5);
		adulte_3.setBounds(700,80,90,20);
		nombre_enfant=new JLabel("Nombre d'enfants");
		nombre_enfant.setBounds(75,150,150,20);
		btnmoins3=new JButton("-");
		btnmoins3.setBounds(700,150,40,20);

		btwnpm3=new JTextField(5);
		btwnpm3.setBounds(765,150,40,20);
		btwnpm3.setText("0");
		btnplus3=new JButton("+");
		btnplus3.setBounds(825,150,45,20);
		 btnenregistrer3=new JButton("Enregister");
			btnenregistrer3.setBounds(780,260,100,30);
			 btnannuler3=new JButton("Annuler");
				btnannuler3.setBounds(660,260,100,30);
    //age=new JComboBox(agee);
	//	age.setBounds(75,240,150,20);
		chambre3.add(chambre_s3);
		chambre3.add(chambre_d3);
		chambre3.add(suite3);
		chambre3.add(nombre_adulte);
		chambre3.add(adulte_3);
		//chambre3.add(adulte_2);
		chambre3.add(nombre_enfant);
		chambre3.add(btnmoins3);
		chambre3.add(btwnpm3);
		chambre3.add(btnplus3);
		chambre3.add(btnenregistrer3);
		chambre3.add(btnannuler3);
		
		
		btnverifier.addActionListener(this::Verifier );
	    btnplus.addActionListener(this :: Augmenterplus);
	    btnmoins.addActionListener(this :: Diminuermoins);
	    btnajouter.addActionListener(this :: Ajouter_une_chambre);
		btnplus2.addActionListener(this :: Augmenterplus);
	    btnmoins2.addActionListener(this :: Diminuermoins);
	    btnannuler2.addActionListener(this :: Annuler);
	    btnplus3.addActionListener(this :: Augmenterplus);
	    btnmoins3.addActionListener(this :: Diminuermoins);
	    btnannuler3.addActionListener(this :: Annuler);
	    btnenregistrer1.addActionListener(this :: Enregistrer);
	    btnenregistrer2.addActionListener(this :: Enregistrer);
	    btnenregistrer3.addActionListener(this :: Enregistrer);
	
	}
	
	
	public Date getDatea() {
		return datea.getDate();
	}


	public Date getDated() {
		return dated.getDate();
	}


	public String getValue_chambre1() {
		return value_chambre1;
	}

	public String getValue_chambre2() {
		return value_chambre2;
	}

	public String getValue_chambre3() {
		return value_chambre3;
	}

	public JTextField getBtwnpm() {
		return btwnpm;
	}

	public void setBtwnpm(JTextField btwnpm) {
		this.btwnpm = btwnpm;
	}

	public JButton getBtnverifier() {
		return btnverifier;
	}

//	public JComboBox getNombradu() {
//		return nombradu;
//	}
	private void Ajouter_une_chambre(ActionEvent e) {
	     count++;
		
		if(enre1==0) {count --;
			           JOptionPane.showMessageDialog(null,"Enregister la chambre 1 !!");}
		else if(count==1) {	j2.setTitle("Reservation de Chambre 2");
			j2.setVisible(true);
			j2.add(chambre2);	}
		else {if(enre2==1) {j3.setTitle("Reservation de Chambre 3");
			j3.setVisible(true);
			j3.add(chambre3);	}
		else 	JOptionPane.showMessageDialog(null,"Enregister la chambre 2 !!");
				}}
	private void Verifier(ActionEvent e) {
//		dated
		Date date_arr=datea.getDate();
		Date date_de=dated.getDate();
  if(date_arr==null || date_de==null) {
     		JOptionPane.showMessageDialog(j1, "Saisir les dates !!");
                       	}
     
    else {
     		if( date_arr.compareTo( new Date())<0|| date_de.compareTo(date_arr)<0)
     			JOptionPane.showMessageDialog(j1, "Saisir une date valable");
     		
     		    else {  	
     			     if(enre1==0)
     				    JOptionPane.showMessageDialog(j1, "Enregistrer la chambre 1 !!");
     			     
     			     else {
		                    j1.setVisible(false);
		                      new Ajouter_info_pers(this);
	                         }
     			
     		           
     		          }
       }	
     	
   
     	                                  }
	
   private void Augmenterplus(ActionEvent e) {
	 Object s=e.getSource();
	 if(s==btnplus) {
	   int c=Integer.parseInt(btwnpm.getText());
	   int a=c;
	  
	  if (a<2) {  a++;
	   btwnpm.setText(""+a);
	   String [] agee1= {"Age de l'enfant "+a,"1","2","3","4","5","6","7","8","9","10","11","12"};
	   newAgeComboBox = new JComboBox(agee1);
	   newAgeComboBox.setBounds(r, 240, 150, 20); 
	   r+=155;
	   chambre1.add(newAgeComboBox);
	   chambre1.revalidate();
	   chambre1.repaint();}
	 }
	  
	  else  if(s==btnplus2) {
		   int c2=Integer.parseInt(btwnpm2.getText());
		   int a2=c2;
		  
		  if (a2<2) {  a2++;
		   btwnpm2.setText(""+a2);
		   String [] agee1= {"Age de l'enfant "+a2,"1","2","3","4","5","6","7","8","9","10","11","12"};
		   newAgeComboBox = new JComboBox(agee1);
		   newAgeComboBox.setBounds(r2, 240, 150, 20); 
		   r2+=155;
		   chambre2.add(newAgeComboBox);
		   chambre2.revalidate();
		   chambre2.repaint();}
	   }
	  else  if(s==btnplus3) {
		   int c3=Integer.parseInt(btwnpm3.getText());
		   int a3=c3;
		  
		  if (a3<2) {  a3++;
		   btwnpm3.setText(""+a3);
		   String [] agee1= {"Age de l'enfant "+a3,"1","2","3","4","5","6","7","8","9","10","11","12"};
		   newAgeComboBox = new JComboBox(agee1);
		   newAgeComboBox.setBounds(r3, 240, 150, 20); 
		   r3+=155;
		   chambre3.add(newAgeComboBox);
		   chambre3.revalidate();
		   chambre3.repaint();}
	   }
	  }
   private void Diminuermoins(ActionEvent e) {
	 Object s=e.getSource();
	 if(s==btnmoins) {
	   int c=Integer.parseInt(btwnpm.getText());
	    int a=c;
		   a--;
		   if (a<0) {
		   btwnpm.setText(""+0);
		   
		   }
		   else { 
			   r-=155;
			   btwnpm.setText(""+a);
		  chambre1.remove(newAgeComboBox); 
	       chambre1.revalidate();
		   chambre1.repaint();  
		   }}
	 else if(s==btnmoins2) {
		   int c2=Integer.parseInt(btwnpm2.getText());
		    int a2=c2;
			   a2--;
			   if (a2<0) {
			   btwnpm2.setText(""+0);
			   
			   }
			   else { 
				   r2-=155;
				   btwnpm2.setText(""+a2);
			  chambre2.remove(newAgeComboBox); 
		       chambre2.revalidate();
			   chambre2.repaint();  
			   }}
	 else if(s==btnmoins3) {
		   int c3=Integer.parseInt(btwnpm3.getText());
		    int a3=c3;
			   a3--;
			   if (a3<0) {
			   btwnpm3.setText(""+0);
			   
			   }
			   else { 
				   r3-=155;
				   btwnpm3.setText(""+a3);
			  chambre3.remove(newAgeComboBox); 
		       chambre3.revalidate();
			   chambre3.repaint();  
			   }}
		   }
   private void Enregistrer(ActionEvent e) {
	   int r=connecter.getAllData("Reservation");
	    r++;
	   Object s=e.getSource();
	  
/////////////////////////enregistrer chambre 1////////////////////////////////////
	   if(s==btnenregistrer1) {	 
		   int nbrEnfant=Integer.parseInt(btwnpm.getText());  
		   int nbrAdulte=Integer.parseInt(adulte_1.getText()); 
		  
	  
   if(Integer.parseInt(adulte_1.getText())>2 || Integer.parseInt(adulte_1.getText())<=0 || adulte_1.getText().isEmpty() ) { 
		   JOptionPane.showMessageDialog(null,"saisir un nombre d'adulte valide soit 1 ou 2 ");
		   adulte_1.setText(""); }
	  
		 else {
			     enre1++;
			   JOptionPane.showMessageDialog(null,"La Chambre 1 a été Enregistré avec succés ");
			
			  
			     if(chambre_s.isSelected()) {
			    	 int categorie=1;
			    	int numch= connecter.Numch(categorie);
			    	if(numch==0) JOptionPane.showMessageDialog(null, "cette chambre de nemuro "+numch+" est indisponible");
			    	 
			    	 else {
			    		 JOptionPane.showMessageDialog(null, "votre nemuro de chambre est  "+numch+" avec categorie "+categorie);
			    		 connecter.updateetat(numch);
					 System.out.println("adulte"+ nbrAdulte);
					  System.out.println("enfant"+ nbrEnfant);
					  value_chambre1="'"+1+"', "+ numch+", "+nbrAdulte+", '"+nbrEnfant+"'"; 
					  System.out.println(value_chambre1);
					  
					  if( nbrAdulte==2 && nbrEnfant==2) { prix_s=(prix_s*2)+250; }
						  else if ( nbrAdulte==2 && nbrEnfant==1) { prix_s=(prix_s*2);}
						    else if ( nbrAdulte==1 && nbrEnfant==2) { prix_s+=250;}
					  else  { prix_s=prix_s;} 
						     
						    
						     if(saison().compareTo("basse-saison")==0) prix_s+=prix_s*0.05;//augmenter de  5%
						     else if(saison().compareTo("moyenne-saison")==0) prix_s+=prix_s*0.2;//augmenter de  20%
						     else   prix_s+=prix_s*0.5;//augmenter de  50%
						        prixch1=prix_s;
						        prix_s=500;
						       System.out.println(prixch1 +"DH");
						       System.out.println("categorie 1");
			    }}
			  
			  else if(chambre_d.isSelected()) {  
				  int categorie=2;
			    	int numch= connecter.Numch(categorie);
			    	if(numch==0) JOptionPane.showMessageDialog(null, "cette chambre de nemuro "+numch+" est indisponible");
			    	 
			    	 else {
			    		 JOptionPane.showMessageDialog(null, "votre nemuro de chambre est  "+numch+" avec categorie "+categorie);
			    		 connecter.updateetat(numch);
				  System.out.println("categorie 2");
				      System.out.println("adulte"+ nbrAdulte);
					  System.out.println("enfant"+ nbrEnfant);
					  if( nbrAdulte==2 && nbrEnfant==2) { prix_d=(prix_d*2)+250; }
					  else if ( nbrAdulte==2 && nbrEnfant==1) { prix_d=(prix_d*2);}
					    else if (nbrAdulte==1 && nbrEnfant==2) { prix_d+=250;}
				  else  { prix_d=prix_d;} 
					     if(saison().compareTo("basse-saison")==0) prix_d+=prix_d*0.05;//augmenter de  5%
					     else if(saison().compareTo("moyenne-saison")==0) prix_d+=prix_d*0.2;//augmenter de  20%
					     else   prix_d+=prix_d*0.5;//augmenter de  50%
					        prixch1=prix_d;
					        prix_d=1000;
					       System.out.println(prixch1 +"DH");
					       value_chambre1="'"+2+"', "+ numch+", "+nbrAdulte+", '"+nbrEnfant+"'";  
			    	 }                      }
			  
			     else {
			    	 int categorie=3;
				    	int numch= connecter.Numch(categorie);
				    	if(numch==0) JOptionPane.showMessageDialog(null, "cette chambre de nemuro "+numch+" est indisponible");
				    	 
				    	 else {
				    		 JOptionPane.showMessageDialog(null, "votre nemuro de chambre est  "+numch+" avec categorie "+categorie);
				    		 connecter.updateetat(numch);
			    	 if( nbrAdulte==2 && nbrEnfant==2) { prix_su=(prix_su*2)+250; }
					  else if ( nbrAdulte==2 && nbrEnfant==1) { prix_su=(prix_su*2);}
					    else if (nbrAdulte==1 && nbrEnfant==2) { prix_su+=250;}
				  else  { prix_su=prix_su;} 
					     
					    
					     if(saison().compareTo("basse-saison")==0) prix_su+=prix_su*0.05;//augmenter de  5%
					     else if(saison().compareTo("moyenne-saison")==0) prix_su+=prix_su*0.2;//augmenter de  20%
					     else   prix_su+=prix_su*0.5;//augmenter de  50%
					        prixch1=prix_su;
					        prix_su=1200;
					       System.out.println(prixch1 +"DH");
					       value_chambre1="'"+3+"', "+ numch+", "+nbrAdulte+", '"+nbrEnfant+"'";   
					  }
				    	}
				   
   }
   }                    
	  
	   
	   
/////////////////////////enregistrer chambre 2////////////////////////////////////
	   
	   else   if(s==btnenregistrer2) {
		   
					int nbrAdulte=Integer.parseInt(adulte_2.getText()); 
					   int nbrEnfant=Integer.parseInt(btwnpm2.getText()); 
					   if(Integer.parseInt(adulte_1.getText())>2 || Integer.parseInt(adulte_1.getText())<=0 || adulte_1.getText().isEmpty() ) { 
						   JOptionPane.showMessageDialog(null,"saisir un nombre d'adulte valide soit 1 ou 2 ");
						   adulte_1.setText(""); }
					  
						 else {
				   enre2++;
				   JOptionPane.showMessageDialog(j2,"La Chambre 2 a été Enregistré avec succés ");
				   j2.setVisible(false);
				     System.out.println(nbrAdulte);
				   if(chambre_s2.isSelected()) {
					   int categorie=1;
				    	int numch= connecter.Numch(categorie);
				    	if(numch==0) JOptionPane.showMessageDialog(null, "cette chambre de nemuro "+numch+" est indisponible");
				    	 
				    	 else {
				    		 JOptionPane.showMessageDialog(null, "votre nemuro de chambre est  "+numch+" avec categorie "+categorie);
				    		 connecter.updateetat(numch);
					   if( nbrAdulte==2 && nbrEnfant==2) { prix_s=(prix_s*2)+250; }
						  else if ( nbrAdulte==2 && nbrEnfant==1) { prix_s=(prix_s*2);}
						    else if (nbrAdulte==1 && nbrEnfant==2) { prix_s+=250;}
					  else  { prix_s=prix_s;} 
						     
						    
						     if(saison().compareTo("basse-saison")==0) prix_s+=prix_s*0.05;//augmenter de  5%
						     else if(saison().compareTo("moyenne-saison")==0) prix_s+=prix_s*0.2;//augmenter de  20%
						     else   prix_s+=prix_s*0.5;//augmenter de  50%
						        prixch2=prix_s;
						        prix_s=1000;
						       System.out.println(prixch2 +"DH");
						       System.out.println("categorie 1");
						       value_chambre2="'"+1+"', "+ numch+", "+nbrAdulte+", '"+nbrEnfant+"'";  
						       }}
				   
				   
				   else if(chambre_d2.isSelected()) {
					   int categorie=2;
				    	int numch= connecter.Numch(categorie);
				    	if(numch==0) JOptionPane.showMessageDialog(null, "cette chambre de nemuro "+numch+" est indisponible");
				    	 
				    	 else {
				    		 JOptionPane.showMessageDialog(null, "votre nemuro de chambre est  "+numch+" avec categorie "+categorie);
				    		 connecter.updateetat(numch);
					   if( nbrAdulte==2 && nbrEnfant==2) { prix_d=(prix_d*2)+250; }
						  else if ( nbrAdulte==2 && nbrEnfant==1) { prix_d=(prix_d*2);}
						    else if (nbrAdulte==1 && nbrEnfant==2) { prix_d+=250;}
					  else  { prix_d=prix_d;} 
						     
						    
						     if(saison().compareTo("basse-saison")==0) prix_d+=prix_d*0.05;//augmenter de  5%
						     else if(saison().compareTo("moyenne-saison")==0) prix_d+=prix_d*0.2;//augmenter de  20%
						     else   prix_d+=prix_d*0.5;//augmenter de  50%
						        prixch2=prix_d;
						        prix_d=1000;
						       System.out.println(prixch2 +"DH");
					   System.out.println("categorie 2");
					   value_chambre2="'"+2+"', "+ numch+", "+nbrAdulte+", '"+nbrEnfant+"'"; 
						       }
				   }
				   
				   else {
					   int categorie=3;
				    	int numch= connecter.Numch(categorie);
				    	if(numch==0) JOptionPane.showMessageDialog(null, "cette chambre de nemuro "+numch+" est indisponible");
				    	 
				    	 else {
				    		 JOptionPane.showMessageDialog(null, "votre nemuro de chambre est  "+numch+" avec categorie "+categorie);
				    		 connecter.updateetat(numch);
					   if( nbrAdulte==2 && nbrEnfant==2) { prix_su=(prix_su*2)+250; }
						  else if ( nbrAdulte==2 && nbrEnfant==1) { prix_su=(prix_su*2);}
						    else if (nbrAdulte==1 && nbrEnfant==2) { prix_su+=250;}
					  else  { prix_su=prix_su;} 
						     
						    
						     if(saison().compareTo("basse-saison")==0) prix_su+=prix_su*0.05;//augmenter de  5%
						     else if(saison().compareTo("moyenne-saison")==0) prix_su+=prix_su*0.2;//augmenter de  20%
						     else   prix_su+=prix_su*0.5;//augmenter de  50%
						        prixch2=prix_su;
						        prix_su=1200;
						       System.out.println(prixch2 +"DH");
						       System.out.println("categorie 3");
						       value_chambre3="'"+3+"', "+ numch+", "+nbrAdulte+", '"+nbrEnfant+"'"; 
					 }
                            }}}
	   /////////////////////////enregistrer chambre 3////////////////////////////////////
	   
	   else if(s==btnenregistrer3) {
		     enre3++;
		     int nbrAdulte=Integer.parseInt(adulte_3.getText()); 
			   int nbrEnfant=Integer.parseInt(btwnpm3.getText()); 
			   if(Integer.parseInt(adulte_1.getText())>2 || Integer.parseInt(adulte_1.getText())<=0 || adulte_1.getText().isEmpty() ) { 
				   JOptionPane.showMessageDialog(null,"saisir un nombre d'adulte valide soit 1 ou 2 ");
				   adulte_1.setText(""); }
			  
				 else {
		   JOptionPane.showMessageDialog(j3,"La Chambre 3 a été Enregistré avec succés ");
		   j3.setVisible(false);
		  System.out.println(nbrAdulte);
		  if(chambre_s3.isSelected()) {
			  int categorie=1;
		    	int numch= connecter.Numch(categorie);
		    	if(numch==0) JOptionPane.showMessageDialog(null, "cette chambre de nemuro "+numch+" est indisponible");
		    	 
		    	 else {
		    		 JOptionPane.showMessageDialog(null, "votre nemuro de chambre est  "+numch+" avec categorie "+categorie);
		    		 connecter.updateetat(numch);
			  if( nbrAdulte==2 && nbrEnfant==2) { prix_s=(prix_s*2)+250; }
			  else if ( nbrAdulte==2 && nbrEnfant==1) { prix_s=(prix_s*2);}
			    else if (nbrAdulte==1 && nbrEnfant==2) { prix_s+=250;}
		  else  { prix_s=prix_s;} 
			     if(saison().compareTo("basse-saison")==0) prix_s+=prix_s*0.05;//augmenter de  5%
			     else if(saison().compareTo("moyenne-saison")==0) prix_s+=prix_s*0.2;//augmenter de  20%
			     else   prix_s+=prix_s*0.5;//augmenter de  50%
			        prixch3=prix_s;
			        prix_s=500;
			       System.out.println(prixch3 +"DH");
			       value_chambre3="'"+1+"', "+ numch+", "+nbrAdulte+", '"+nbrEnfant+"'"; 
		  }
		  }
		  
		   else if(chambre_d3.isSelected()) {
			   int categorie=2;
		    	int numch= connecter.Numch(categorie);
		    	if(numch==0) JOptionPane.showMessageDialog(null, "cette chambre de nemuro "+numch+" est indisponible");
		    	 
		    	 else {
		    		 JOptionPane.showMessageDialog(null, "votre nemuro de chambre est  "+numch+" avec categorie "+categorie);
		    		 connecter.updateetat(numch);
			   if( nbrAdulte==2 && nbrEnfant==2) { prix_d=(prix_d*2)+250; }
				  else if ( nbrAdulte==2 && nbrEnfant==1) { prix_d=(prix_d*2);}
				    else if (nbrAdulte==1 && nbrEnfant==2) { prix_d+=250;}
			  else  { prix_d=prix_d;} 
				     
				    
				     if(saison().compareTo("basse-saison")==0) prix_d+=prix_d*0.05;//augmenter de  5%
				     else if(saison().compareTo("moyenne-saison")==0) prix_d+=prix_d*0.2;//augmenter de  20%
				     else   prix_d+=prix_d*0.5;//augmenter de  50%
				        prixch3=prix_d;
				        prix_d=1000;
				       System.out.println(prixch2 +"DH");
				       value_chambre3="'"+2+"', "+ numch+", "+nbrAdulte+", '"+nbrEnfant+"'";  
			   }}
		  
		  
		   else {
			   int categorie=3;
		    	int numch= connecter.Numch(categorie);
		    	if(numch==0) JOptionPane.showMessageDialog(null, "cette chambre de nemuro "+numch+" est indisponible");
		    	 
		    	 else {
		    		 JOptionPane.showMessageDialog(null, "votre nemuro de chambre est  "+numch+" avec categorie "+categorie);
		    		 connecter.updateetat(numch);
			   if( nbrAdulte==2 && nbrEnfant==2) { prix_su=(prix_su*2)+250; }
				  else if ( nbrAdulte==2 && nbrEnfant==1) { prix_su=(prix_su*2);}
				    else if (nbrAdulte==1 && nbrEnfant==2) { prix_su+=250;}
			  else  { prix_su=prix_su;} 
				     
				    
				     if(saison().compareTo("basse-saison")==0) prix_su+=prix_su*0.05;//augmenter de  5%
				     else if(saison().compareTo("moyenne-saison")==0) prix_su+=prix_su*0.2;//augmenter de  20%
				     else   prix_su+=prix_su*0.5;//augmenter de  50%
				        prixch3=prix_su;
				        prix_su=1200;
				       System.out.println(prixch3 +"DH");			   
				       value_chambre3="'"+3+"', "+ numch+", "+nbrAdulte+", '"+nbrEnfant+"'"; 
		   }
		    }}}
	   
	   
   }
   private void Annuler(ActionEvent e) {
	   Object s=e.getSource();
   	int h=JOptionPane.showConfirmDialog(null,"Souhaitez-vous annuler ?","",JOptionPane.YES_NO_OPTION);
   	if(h==JOptionPane.OK_OPTION) {
//   	 Window window = SwingUtilities.getWindowAncestor(annuler);
//        window.dispose();
   		if(s==btnannuler2) {
   			count--;
   	
   j2.setVisible(false);
   }
   		else {
   			count=0;
   			j3.setVisible(false);
   			
   	}
   		}
   } 
   public int nombreChambre() {
	   count=enre1+enre2+enre3;
		 return count;
	 }
   public long diffDate() {
	   LocalDate date1 = dated.getDate().toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();
	   LocalDate date2 = datea.getDate().toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();
	   long diff=ChronoUnit.DAYS.between(date2, date1);
	  return diff;
   }
   public String saison() {
	    String  saison1="basse-saison";
	    String  saison2="moyenne-saison";
	    String  saison3="haute-saison";
  	    SimpleDateFormat dateformes = new SimpleDateFormat("yyyy-MM-dd");
  	    String date_arr;
		date_arr = dateformes.format(this.getDatea());
	     if(date_arr.compareTo("2023-01-1")>=0 && date_arr.compareTo("2023-04-1")<0) { return saison1;}
	     else  if(date_arr.compareTo("2023-04-1")>=0 && date_arr.compareTo("2023-08-1")<0) { return saison2;}
	     else   { return saison3;}
	     
   }
   public double prix_totale() {
	   prix_total=prixch1+prixch2+prixch3;
	   return prix_total;
   }
   public double prixReduction() {
	   if(diffDate()>=4) {prix_reduction=(diffDate()*prix_total)-(prix_total*0.2);}//diminuer de 20%
	     else {prix_reduction*=diffDate();}
	   return prix_reduction;
   }
   }
   

