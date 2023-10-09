package Connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Connexion { 
	static Connection mycn;
	String url="jdbc:mysql://localhost:3306/projet_hotel";
	public Connexion() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			try {
				mycn=DriverManager.getConnection(url,"root","");
				System.out.println("connexion etablie");
//				Statement s=mycn.createStatement();
//				String in="Insert into user values('n111','cjh')";
//				s.executeUpdate(in);
			
			} catch (SQLException e) {
				// TODO Auto-gene rated catch block
				e.printStackTrace();
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void disconnect() {
		// TODO Auto-generated method stub
		try {
			mycn.close();
			//JOptionPane.showMessageDialog(null, "Deconexion avec succes");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int getAllData(String table) {
		ResultSet res=null;int dernieridreservation=0;
		String req="SELECT Max(numeroRes) FROM "+table;
		try {
			Statement st=mycn.createStatement();
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
	public ResultSet  getAllData(String table, int numCh) {
		ResultSet res=null;
		String req="SELECT idReservation FROM "+table+"order by idReservation LIMIT 1";
		try {
			Statement st=mycn.createStatement();
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
	
	public void insertDatadetRes(String table, int r, String values) {
	     String req = "INSERT INTO " + table + "(numeroRes,idCategorie,NumeroCh,nbAdultes,nbEnfants) VALUES(" + r + ", " + values + ")";
	     try {
	         Statement st = mycn.createStatement();
	         st.executeUpdate(req);
	     } catch (SQLException e) {
	         e.printStackTrace();
	     }
	 }
	public void insertData(String table, String values) {
	    String req = "INSERT INTO " + table + " VALUES(" + values + ")";
	    try {
	        Statement st = mycn.createStatement();
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
					Statement st=mycn.createStatement();
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
//Fonction qui permet de verifier est ce que le numero de reservation existe dans la table Reservation 
		public boolean reservationEffectuee(String table, int numRes) {
			 ResultSet res=null;
			 String req="SELECT * FROM "+ table +" WHERE numReservation = " + numRes;
			 try {
					Statement st=mycn.createStatement();
					res=st.executeQuery(req);
				 if (res.next()) {
            JOptionPane.showMessageDialog(null, "Le numero de reservation " + numRes + " existe ");
					 return true;
	            }	
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			       return false;
			
		}
		public void CINEdiminue(String table, String cin) {
		    int numeres = 0;
		    ResultSet res = null;
		    String req = "SELECT numeroRes FROM " + table + " WHERE cin = '" + cin+"'";
		    try {
		        Statement st = mycn.createStatement();
		        res = st.executeQuery(req);

		        if (res.next()) {
		            numeres = res.getInt("numeroRes");
//		            numeres--; // On diminue la valeur de numeres de 1
//		            numeres--;
		            String updateReq = "UPDATE detailreservation SET numeroRes = " + numeres ;
		            st.executeUpdate(updateReq);
		        } else {
		            System.out.println("ok");
		        }
		    } catch (SQLException e) {
		       e.printStackTrace();
		    }
}
		
		public int Numch(int id) {
			int nemuro=0;
			ResultSet res=null;
			String req;
			if(id==1) {
			req="SELECT numeroCh from  Chambre where etat='Hors Service' AND numeroCh between 1 and 10 AND idCategorie=1 LIMIT 1";
			}
			else if(id==2) {
			 req="SELECT numeroCh from  Chambre where etat='Hors Service' AND numeroCh between 11 and 20 AND idCategorie=2 LIMIT 1";
			}
			else
			 req="SELECT numeroCh from  Chambre where etat='Hors Service' AND numeroCh between 21 and 30 AND idCategorie=3 LIMIT 1";
			
			try {
				Statement sim=mycn.createStatement();
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
		public void updateetat( int numeroCh) {

			String req = "UPDATE Chambre SET etat='En Service' WHERE numeroCh="+ numeroCh;
			try {
				Statement st=mycn.createStatement();
				st.executeUpdate(req);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
		}
			
		
}
