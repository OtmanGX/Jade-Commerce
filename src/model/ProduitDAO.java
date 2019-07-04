package model;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import utils.MySqlConnector;
import java.sql.*;


public class ProduitDAO  {
	
	Connection conn;
	ResultSet res ;
        Statement st;
	
	public ProduitDAO() throws ClassNotFoundException, SQLException{
		conn = MySqlConnector.getConnection();
                st = conn.createStatement();
	}

        public Produit GetProduitByID(int id){
                Produit produit = null;
		String req = "select * from produit where id= "+id;
		try {	
                    res = st.executeQuery(req);
                    if(res.next()) {
                        produit  = new Produit(res.getInt(1));
                        produit.setNom(res.getString("nom"));
                        produit.setCouleur(res.getString("couleur"));
                        produit.setPrix(res.getDouble("prix"));
                        produit.setImg(res.getString("img"));
                        produit.setTaille(res.getString("taille"));	}		   
			
		} catch (SQLException e) {
                    e.printStackTrace();
                }
	return produit;
	}

    public ArrayList<Produit> FindProduitByNom(String nom){
		ArrayList<Produit> liste = new ArrayList<>();
                Produit produit = null;
		String req = "select *  from produit where nom like '%"+nom+"%'";
		try {	
                    res = st.executeQuery(req);
			while(res.next()){
                            produit  = new Produit(res.getInt(1));
                            produit.setNom(res.getString("nom"));
                            produit.setCouleur(res.getString("couleur"));
                            produit.setPrix(res.getDouble("prix"));
                            produit.setImg(res.getString("img"));
                            produit.setTaille(res.getString("taille"));
                            System.out.println(produit.getNom());
                            liste.add(produit);
			} 
			
		} catch (SQLException e) {
                    e.printStackTrace();
                }
	return liste;
	}
}
