package it.polito.tdp.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ParolaDAO {

	public boolean isPresent(String word) {
		// TODO Auto-generated method stub
		
		try {
			Connection conn = DBConnect.getConnection();
			
			String sql = "SELECT nome FROM parola WHERE nome =?;";
			
			PreparedStatement st = conn.prepareStatement(sql);
			
			//i placeholders ? si contano a partire da 1 non da 0
			st.setString(1,word);
				
			ResultSet res = st.executeQuery();
				
			if (res.next()) {//ossia se c'è una tupla (che è anche l'unica) nella tabella risultante dalla query
				res.close();
				conn.close();
				return true;
			} else {
				res.close();
				conn.close();
				return false;
			}
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return false;
	}
		

	

}
