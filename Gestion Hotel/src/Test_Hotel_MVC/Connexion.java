package Test_Hotel_MVC;
import java.sql.*;
import java.text.SimpleDateFormat;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import PackageAjouterReservation.Ajouter_RES;

public class Connexion {
	static Connection myCnx;
	String url,pilote;
	static LinkedList listNumCh=new LinkedList<>();
	public Connexion() {
	try {
		pilote=new String("com.mysql.cj.jdbc.Driver");
		Class c=Class.forName(pilote);
		url = new String("jdbc:mysql://127.0.0.1/myBD_Hotel?serverTimezone=UTC");
		myCnx = DriverManager.getConnection(url,"root","");
		} 
	catch( ClassNotFoundException e) {
			System.err.println("Erreur lors du chargement du pilote : " + e); 
		}
	 catch (SQLException e) {
		System.err.println("Erreur de syntaxe SQL :" + e);
	} 
	
	}
	public void connect() throws SQLException {
		try {
//			myCnx = DriverManager.getConnection(url,"lstinfo","lst2023");
			myCnx = DriverManager.getConnection(url,"root","");
			//JOptionPane.showMessageDialog(null, "CONNEXION ETABLIE","Connextion",JOptionPane.WARNING_MESSAGE);
			
		} catch (SQLException e) {
			System.err.println("Erreur de syntaxe SQL :" + e);
		} 		
	}
	
	public void disconnect() {
		// TODO Auto-generated method stub
		try {
			myCnx.close();
			//JOptionPane.showMessageDialog(null, "Deconexion avec succes");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 
	public ResultSet getAllData(String table) {
		ResultSet res=null;
		String req="SELECT * FROM "+table;
		try {
			Statement st=myCnx.createStatement();
			res=st.executeQuery(req);
			//res.close();
			//myCnx.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return res;
		
		    //res.close();
		    // vous pouvez également fermer la connexion à la base de données
		   // myCnx.close();
	}
	
	public int getAllDataDerIdRes(String table) {
		ResultSet res=null;int dernieridreservation=0;
		String req="SELECT Max(numeroRes) FROM "+table;
		try {
			Statement st=myCnx.createStatement();
			res=st.executeQuery(req);
			if(res.next()) {
				
				dernieridreservation=res.getInt(1); 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//System.out.println("erreur");
		}
			
		return dernieridreservation;
	}
	
	public ResultSet  getAllDataIdRes(String table, int numCh) {
		ResultSet res=null;
		String req="SELECT idReservation FROM "+table+"order by idReservation LIMIT 1";
		try {
			Statement st=myCnx.createStatement();
			res=st.executeQuery(req);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			try {
				res.next();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return res;
	}
	
	public ResultSet getAllData(String table, int numCh) {
		ResultSet res=null;
		String req="SELECT * FROM "+table+" Where numeroCh="+numCh;
		try {
			Statement st=myCnx.createStatement();
			res=st.executeQuery(req);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return res;
	}
	
	public ResultSet getAllData(String data,String tables, String conditions) {
		ResultSet res=null;
		String req="SELECT "+data+ " FROM "+tables+" Where " + conditions;
		try {
			Statement st=myCnx.createStatement();
			res=st.executeQuery(req);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return res;
	}
	
	
	public void updateData(String table, String values, String condition) {
//		String req = "UPDATE " + table + " SET etage = " + etage + ", nbLits = " + nbLits + ", categorie = '" + categorie + "' WHERE numChambre = " + numCham;
		String req = "UPDATE " + table + " SET "+values+ " WHERE "+ condition;
		try {
			Statement st=myCnx.createStatement();
			st.executeUpdate(req);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	
	public void deleteData(String table, String condition) {
		String req = "DELETE FROM " + table + " WHERE "+ condition;
		try {
			Statement st=myCnx.createStatement();
			st.executeUpdate(req);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	
	public void insertDatadetRes(String table, int r, String values) {
	     String req = "INSERT INTO " + table + "(numeroRes,idCategorie,NumeroCh,nbAdultes,nbEnfants) VALUES(" + r + ", " + values + ")";
	     try {
	         Statement st = myCnx.createStatement();
	         st.executeUpdate(req);
	     } catch (SQLException e) {
	         e.printStackTrace();
	     }
	 }
	
	public void insertData(String table, String values) {
	    String req = "INSERT INTO " + table + " VALUES(" + values + ")";
	    try {
	        Statement st = myCnx.createStatement();
	        st.executeUpdate(req);
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	public void insertDataFacture(String table, String values) {
	    String req = "INSERT INTO " + table + " (numeroRes,prixTotal,typePayement) VALUES(" + values + ")";
	    try {
	        Statement st = myCnx.createStatement();
	        st.executeUpdate(req);
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	//Fonction qui permet de verifier est ce que le numero de chambre existe dans la table Chambre 
	public int CINExiste(String table, String cin) {
		int numeres=0;
		 ResultSet res=null;
		 String req="SELECT numeroRes FROM "+table+" WHERE cin = '"+cin+"'";
		 try {
				Statement st=myCnx.createStatement();
				res=st.executeQuery(req);
			
          
				 if(res.next()) {
					 
						numeres=res.getInt(1);
					}  
				//JOptionPane.showMessageDialog(null, "Le numero de reservation " +cin + " existe ");
				 return numeres;
           	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				System.out.println(" non existe");
			}
		       return 0;
		
	}
	
	public void CINEdiminue(String table, String cin) {
	    int numeres = 0;
	    ResultSet res = null;
	    String req = "SELECT numeroRes FROM " + table + " WHERE cin = '" + cin+"'";
	    try {
	        Statement st = myCnx.createStatement();
	        res = st.executeQuery(req);

	        if (res.next()) {
	            numeres = res.getInt("numeroRes");
//	            numeres--; // On diminue la valeur de numeres de 1
//	            numeres--;
	            String updateReq = "UPDATE detailreservation SET numeroRes = " + numeres ;
	            st.executeUpdate(updateReq);
	        } else {
	            System.out.println("ok");
	        }
	    } catch (SQLException e) {
	       e.printStackTrace();
	    }
}
	
	public void updateEtatChambre(String table, String values, String condition) {
		String req = "UPDATE " + table + " SET "+values+ " WHERE "+ condition;
		try {
			Statement st=myCnx.createStatement();
			st.executeUpdate(req);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public String etatChambre(String table, int condition) {
		// Récupérer l'état actuel de la chambre depuis la base de données
	    String etatChambre = "";
	    try {
        String query = "SELECT etatCh FROM "+ table+" WHERE numeroCh = " + condition;
        Statement st=myCnx.createStatement();
        ResultSet result = st.executeQuery(query);
        if (result.next()) {
            etatChambre = result.getString("etatCh");
        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      return etatChambre;
	}
	
	public boolean FactureExiste(String table, int numRes) {
		 ResultSet res=null;
		 String req="SELECT * FROM "+ table +" WHERE numeroRes = " + numRes;
		 try {
				Statement st=myCnx.createStatement();
				res=st.executeQuery(req);
			 if (res.next()) {
//            JOptionPane.showMessageDialog(null, "Le numéro de chambre " + numCham + " existe déjà.");
				 return true;
            }	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		       return false;
		
	}
	

//Fonction qui permet de verifier est ce que le numero de chambre existe dans la table Chambre 
	public boolean chambreExiste(String table, int numCham) {
		 ResultSet res=null;
		 String req="SELECT * FROM "+ table +" WHERE numeroCh = " + numCham;
		 try {
				Statement st=myCnx.createStatement();
				res=st.executeQuery(req);
			 if (res.next()) {
//             JOptionPane.showMessageDialog(null, "Le numéro de chambre " + numCham + " existe déjà.");
				 return true;
             }	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		       return false;
		
	}
	
//Fonction qui permet de verifier est ce que le numero de reservation existe dans la table Reservation 
	public boolean reservationEffectuee(String table, int numRes) {
		 ResultSet res=null;
		 String req="SELECT * FROM "+ table +" WHERE numeroRes = " + numRes;
		 try {
				Statement st=myCnx.createStatement();
				res=st.executeQuery(req);
			 if (res.next()) {
//            JOptionPane.showMessageDialog(null, "Le numéro de reservation " + numRes + " existe ");
				 return true;
            }	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		       return false;
		
	}
	
	public int nombreChambre(String table, int numRes) {
	    int nbrChambre = 0;
	    String req = "SELECT COUNT(idReservation) FROM " + table + " WHERE numeroRes = " + numRes;
	    try {
	        Statement st = myCnx.createStatement();
	        ResultSet rs = st.executeQuery(req);
	        if (rs.next()) {
	        	nbrChambre = rs.getInt(1);
	        }
	        rs.close();
	        st.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return 	nbrChambre;    
	}
	
	//fonction qui supprime les reservations dans la table reservation et detailreservation va executer a pres apprendre les numch
	public void Delete_Res_DetRes(int numres) {
		String req="Delete FROM detailReservation WHERE numeroRes = " + numres;
		String req2="Delete FROM reservation WHERE numeroRes = "+ numres;
		 try {
				Statement st=myCnx.createStatement();
				st.executeUpdate(req);
				st.executeUpdate(req2);
           

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
	
	public LinkedList<Integer> listNumeroChambres(int numRes) {
		ResultSet res=null;
		String req="SELECT numeroCh FROM detailReservation WHERE numeroRes="+numRes+" LIMIT 3";
		
		try {
			Statement st=myCnx.createStatement();
			res=st.executeQuery(req);
           for(int i=1; i<=res.getMetaData().getColumnCount();i++) {
        	   while(res.next()) {
        		   listNumCh.add(Integer.parseInt(res.getString("numeroCh")));
        	   }
           }
             return listNumCh;
           
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
	public void deletClient( String cin) {
		String req = "DELETE FROM Client WHERE CIN ='"+cin+"'";
		try {
			Statement st=myCnx.createStatement();
			st.executeUpdate(req);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
	
	public int nombreRes(int numRes) {
		ResultSet res=null;	
		String req2="Select COUNT(numeroRes) FROM reservation WHERE CIN = '"+CinRes(numRes)+"'";
			int nomRes=0;
		try {
			Statement st=myCnx.createStatement();
			res=st.executeQuery(req2);
			if(res.next())
				nomRes=res.getInt(1);
			return nomRes;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}	
	public String CinRes(int numRes) {
		ResultSet res=null;
		String req="Select CIN FROM reservation where numeroRes="+numRes;
			String Cin=null;
			
		try {
			Statement st=myCnx.createStatement();
			res=st.executeQuery(req);
			if(res.next())
	        Cin= res.getString("CIN");
		  return Cin;
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}	

	//Modifier Chambre de la reservation :
	public int Numch(int id) {
		int nemuro=0;
		ResultSet res=null;
		String req;
		if(id==1) {
		req="SELECT numeroCh from  Chambre where etatCh='Hors Service' AND numeroCh between 1 and 5 AND idCategorie=1 LIMIT 1";
		}
		else if(id==2) {
		 req="SELECT numeroCh from  Chambre where etatCh='Hors Service' AND numeroCh between 6 and 10 AND idCategorie=2 LIMIT 1";
		}
		else
		 req="SELECT numeroCh from  Chambre where etatCh='Hors Service' AND numeroCh between 11 and 15 AND idCategorie=3 LIMIT 1";
		
		try {
			Statement sim=myCnx.createStatement();
			res=sim.executeQuery(req);
			if(res.next())
			nemuro=res.getInt(1);	
				return nemuro; 
		}
		catch(Exception ee) { 
			ee.printStackTrace();
		}
		return 0;
	}   
	public void updateEtatHorsSer( int numeroCh) {

		String req = "UPDATE Chambre SET etatCh='Hors Service' WHERE numeroCh="+ numeroCh;
		try {
			Statement st=myCnx.createStatement();
			st.executeUpdate(req);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
	
	public void updateEtatEnSer(int numeroCh) {

		String req = "UPDATE Chambre SET etatCh='En Service' WHERE numeroCh="+ numeroCh;
		try {
			Statement st=myCnx.createStatement();
			st.executeUpdate(req);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	
	
	public Date dateArrivee(int numRes) {
		ResultSet res=null;
		String req="SELECT dateArrivee FROM Reservation WHERE numeroRes= "+numRes;
		Date dateArr=null;
		try {
			Statement st=myCnx.createStatement();
			res=st.executeQuery(req);
		  
		 while(res.next()) {
			  dateArr=res.getDate(1); }
		 
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		   return dateArr;
	}
		
	   public String saison(int numRes) {
		    String  saison1="basse-saison";
		    String  saison2="moyenne-saison";
		    String  saison3="haute-saison";
	  	    SimpleDateFormat dateformes = new SimpleDateFormat("yyyy-MM-dd");
	  	    String date_arr;
			date_arr = dateformes.format(dateArrivee(numRes));
		     if(date_arr.compareTo("2023-01-1")>=0 && date_arr.compareTo("2023-04-1")<0) { return saison1;}
		     else  if(date_arr.compareTo("2023-04-1")>=0 && date_arr.compareTo("2023-08-1")<0) { return saison2;}
		     else   { return saison3;}
	  }	

   public double recalculerPrixCh(int numRes, int nvCat, int nvNbAdu, int nvNbEnf) {
	   //Chambre simple == 500 Dh   //basse-saison : augmentation de 5% 
	  //Chambre double == 1000 Dh   //moyenne-saison : augmentation de 20%
	 //Chambre suite == 1200 Dh     //haute-saison : augmentation de 50%
	   // 2 Enfants = prix*50%  // 2 Adultes = prix*2 
	   
	   double prixChambre=0, prixChSimple=500, prixChDouble=1000, prixChSuite=1200;
	   
	   if(nvCat==1) {
		   if( nvNbAdu==2 && nvNbEnf==2) { prixChambre=(prixChSimple*2)+250; }
			  else if ( nvNbAdu==2 && (nvNbEnf==0 || nvNbEnf==1) ) { prixChambre=(prixChSimple*2);}
			    else if ( nvNbAdu==1 && nvNbEnf==2) { prixChambre=prixChSimple+250;}
		             else  { prixChambre=prixChSimple;} }
		   
		   if(nvCat==2) {
			   if( nvNbAdu==2 && nvNbEnf==2) { prixChambre=(prixChDouble*2)+500; }
				  else if ( nvNbAdu==2 && (nvNbEnf==0 || nvNbEnf==1) ) { prixChambre=(prixChDouble*2);}
				    else if ( nvNbAdu==1 && nvNbEnf==2) { prixChambre=prixChDouble+500;}
			             else  { prixChambre=prixChDouble;} }
			   
			   if(nvCat==3) {
				   if( nvNbAdu==2 && nvNbEnf==2) { prixChambre=(prixChSuite*2)+600; }
					  else if ( nvNbAdu==2 && (nvNbEnf==0 || nvNbEnf==1) ) { prixChambre=(prixChSuite*2);}
					    else if ( nvNbAdu==1 && nvNbEnf==2) { prixChambre=prixChSuite+600;}
				             else  { prixChambre=prixChSuite;} }
	   
///////La Saison :
		  // Ajouter_RES obj=new Ajouter_RES();
		  // obj.setVisible(false);
		 //  String saison=obj.saison();
			   
		   if(saison(numRes).compareTo("basse-saison")==0) prixChambre+=prixChambre*0.05;//augmentation de  5%
		    else if(saison(numRes).compareTo("moyenne-saison")==0) prixChambre+=prixChambre*0.2;//augmentation de  20%
		           else   prixChambre+=prixChambre*0.5;//augmentation de  50%
			   
	                 return prixChambre;
   }
   
   public double calculerPrixTotal(int numRes) {
	     double prixTotal=0; 
	     ResultSet res=null;
	     String req="SELECT SUM(PCh.prixChambre) FROM PrixChambre PCh, DetailReservation DR WHERE PCh.idCategorie=DR.idCategorie AND PCh.numeroCh=DR.numeroCh AND DR.numeroRes="+numRes;             
	   
	     try {
				Statement st=myCnx.createStatement();
				res=st.executeQuery(req);
				
				while (res.next()) {
					
					prixTotal=res.getDouble(1);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	   
	            return prixTotal;
	   
   }
   
   public double calculerPrixReduction(int numRes) {
	     double prixTotal=calculerPrixTotal(numRes); 
	     double prixReduction=0;
	     int nbNuits=0;
	     ResultSet res=null;
	     String req="SELECT nbNuits FROM Reservation WHERE numeroRes="+numRes;             
	   
	     try {
				Statement st=myCnx.createStatement();
				res=st.executeQuery(req);
				
				while (res.next()) {
					
					nbNuits=res.getInt(1);
				}
				
				if(nbNuits>=4)
					prixReduction=prixTotal-prixTotal*0.05;
				else 
					prixReduction=prixTotal;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	            return prixReduction; 
 }
   
   public int getReferenceFact(int numRes) {
	   int reference=0;
	     ResultSet res=null;
	     String req="SELECT reference FROM Facture WHERE numeroRes="+numRes;             
	     try {
				Statement st=myCnx.createStatement();
				res=st.executeQuery(req);
				
				while (res.next()) {
					reference=res.getInt(1);
				}	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	            return reference; 
	   
   }
   
   public int getReferenceFactTypeCheq(int numRes) {
	   int reference=0;
	     ResultSet res=null;
	     String req="SELECT reference FROM Facture WHERE typePayement='Cheque' AND numeroRes="+numRes;             
	     try {
				Statement st=myCnx.createStatement();
				res=st.executeQuery(req);
				
				while (res.next()) {
					reference=res.getInt(1);
				}	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	            return reference; 
	   
   }
   





}
