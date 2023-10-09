package PackageInterfaceAgent;

import java.awt.Component;
import java.awt.Desktop;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.RectangleReadOnly;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.codec.Base64.InputStream;

//import com.itextpdf.text.Document;
//import com.itextpdf.text.DocumentException;
//import com.itextpdf.text.Image;
//import com.itextpdf.text.PageSize;
//import com.itextpdf.text.Paragraph;
//import com.itextpdf.text.RectangleReadOnly;
//import com.itextpdf.text.pdf.PdfPTable;
//import com.itextpdf.text.pdf.PdfWriter;
//
////import javax.swing.text.Document;
////import javax.swing.text.*;
////import java.io.*;
//import java.sql.*;
//import com.itextpdf.*;
//import com.itextpdf.text.*;
//import com.itextpdf.text.pdf.*;
//
//import com.itextpdf.text.DocumentException;
//import com.itextpdf.text.Image;
//import com.itextpdf.text.Paragraph;
//import com.itextpdf.text.pdf.PdfWriter;
//import com.mysql.cj.xdevapi.AddResultBuilder; 

public class ControllerRecap {

	ViewRecap viewRecap;
	
	
	ControllerRecap(){
		
		viewRecap = new ViewRecap();
		
		
		viewRecap.imprimer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
		
		    String message = "L'impression de votre document a été effectuée avec succès !\n"
	                       + "Vous pouvez maintenant retrouver le document imprimé au format PNG.\n"
	                       + "Merci d'avoir utilisé notre application.";
	        JOptionPane.showMessageDialog(null, message);
				
				//afficherPdf();
				captureAndConvert(viewRecap, "interface.pdf");
				
				viewRecap.setVisible(false);
				
				//new InterfacePrincipaleAgent();
				
			}
		});
		
		viewRecap.quitter.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
		int rep=JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment fermer cette interface ?","Quitter",JOptionPane.YES_NO_OPTION);
			if(rep==JOptionPane.OK_OPTION)	
		        viewRecap.setVisible(false);
			}
		});
		
   
	}
	
	 public void calculerChamps(int nbCh,int numCh1,String categorie1,int nbAdu1,int nbEnf1,double prix1,
			                             int numCh2,String categorie2,int nbAdu2,int nbEnf2,double prix2,
			                             int numCh3,String categorie3,int nbAdu3,int nbEnf3,double prix3,String saison) {
		  
		    //  int nbCh=3;
			  for(int i=0;i<nbCh;i++) {
				  
				  if(i==0)    viewRecap.afficherChambre1(numCh1, categorie1, nbAdu1, nbEnf1, saison,prix1);
				  
				  if(i==1) {  viewRecap.afficherChambre1(numCh1, categorie1, nbAdu1, nbEnf1, saison,prix1);
				  			  viewRecap.afficherChambre2(numCh2, categorie2, nbAdu2, nbEnf2, saison,prix2);
				  }
				 
				  if(i==2) {    viewRecap.afficherChambre1(numCh1, categorie1, nbAdu1, nbEnf1, saison,prix1);
				  viewRecap.afficherChambre2(numCh2, categorie2, nbAdu2, nbEnf2, saison,prix2);
				  viewRecap.afficherChambre3(numCh3, categorie3, nbAdu3, nbEnf3, saison,prix3);
				  
				
				  }
			  }}
	
	public void afficherInfoPersonnel(int numRes, String cinT, String nomT, String prenomT, String telT) {
		
		viewRecap.afficherInfoClient(numRes,cinT,nomT,prenomT,telT);
		
	}
	
//	  public void calculerChamps() {
//		  
//	      int nbCh=2;
//		  for(int i=0;i<nbCh;i++) {
//			  
//			  if(i==0)  viewRecap.afficherChambre1();
//			  if(i==1) {  viewRecap.afficherChambre1();
//			              viewRecap.afficherChambre2();
//			  }
//			 
//			  if(i==2) {    viewRecap.afficherChambre1();
//			  				viewRecap.afficherChambre2();
//			  			    viewRecap.afficherChambre3();
//			  
//			
//			  }
//		  }}
	
	
		
		
//	public void afficherPdf() {
//		
//		Document document= new Document();
////		Connexion connexion= new Connexion();
////		ViewFacture viewFacture=new ViewFacture();
////		
////		
////		try {
////		 PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\hp\\Desktop\\java\\Recap.pdf"));
////		 document.open();
////		 
////		 
////		 
////		
////		 document.add(new Paragraph("Récapulatif des Données de Réservation : "));
////		//  Image img=Image.getInstance("C:\\\\Users\\\\hp\\\\Desktop\\\\java\\test.png");
////		//  document.add(img);
////		
////	      
////		 document.close();
////		 Desktop.getDesktop().open(new File("C:\\Users\\hp\\Desktop\\java\\Recap.pdf"));
////		}
////		
////		catch(FileNotFoundException e) {e.getMessage();}
////		catch(DocumentException e) {e.getMessage();}
////		catch(IOException e) {e.getMessage();}
////		
////	}
		
	/*  public static void captureAndConvert(Component component, String filePath) {
	        try {
	            // Capture de l'interface graphique en tant qu'image
	            BufferedImage image = new BufferedImage(component.getWidth(), component.getHeight(), BufferedImage.TYPE_INT_RGB);
	            Graphics2D graphics = image.createGraphics();
	            component.print(graphics);
	            graphics.dispose();
	            //ImageIO.write(image, "png", new FileOutputStream("C:\\Users\\Abdessamad\\OneDrive\\Bureau\\JAVATEST\\screenshotJAVA.png"));
	            	
	            
	          // Créer un objet de fichier à partir d'un chemin relatif
	            File outputFile = new File("screenshotJAVA.png");
	          // Écrire les données de l'image dans le fichier de sortie
	            ImageIO.write(image, "png", outputFile);
	            
	            
	            // Conversion de l'image en PDF
	       /*    Document document = new Document(new RectangleReadOnly(PageSize.A4));
	            PdfWriter.getInstance(document, new FileOutputStream(filePath));
	            document.open();
	            Image pdfImage = Image.getInstance("C:\\Users\\Abdessamad\\OneDrive\\Bureau\\JAVATEST\\screenshotJAVA.png");
	            
	            document.add(pdfImage);
	            document.close();            * /
	            
	          //  Desktop.getDesktop().open(new File("C:\\Users\\Abdessamad\\OneDrive\\Bureau\\JAVATEST\\screenshotJAVA.png"));
	              Desktop.getDesktop().open(new File("screenshotJAVA.png"));
	            
	            // Suppression du fichier d'image temporaire
	            new File("screenshotJAVA.png").delete();
	        } catch (Exception e) {
	            e.printStackTrace();
	        } 
	    }  */
	  
	  
	  public static void captureAndConvert(Component component, String filePath) {
		    try {
		        // Capture de l'interface graphique en tant qu'image
		        BufferedImage image = new BufferedImage(component.getWidth(), component.getHeight(), BufferedImage.TYPE_INT_RGB);
		        Graphics2D graphics = image.createGraphics();
		        component.print(graphics);
		        graphics.dispose();
		        
		        // Vérifier si le dossier L_impression existe et le créer s'il n'existe pas
		    /*    File outputDir = new File("L_impression");
		        if (!outputDir.exists()) {
		            outputDir.mkdir();
		        } */

		        // Créer un objet de fichier à partir d'un chemin relatif dans le package L_impression
		        File outputFile = new File("src/L_impression/screenshotFacture.png");
		        // Écrire les données de l'image dans le fichier de sortie
		        ImageIO.write(image, "png", outputFile);

		        Desktop.getDesktop().open(outputFile);

		    } catch (Exception e) {
		        e.printStackTrace();
		    } 
		}
	  
   
	   public void afficherPrixTot(double prixTot) {

		   viewRecap.afficherPrixTotal(prixTot);}
	   
	   public void afficherPrixReduction(double prixRed) {

		   viewRecap.afficherPrixReduction(prixRed);}
	
}