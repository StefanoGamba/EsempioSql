package it.polito.tdp.EsempioSql.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.EsempioSql.model.Station;

public class BabsDAO { // (Data Access Object)
	
	public List<Station> listStation(){
		
		List<Station> listStation = new ArrayList<>();
		String sql = "SELECT station_id, name, dockcount, landmark FROM station ORDER BY name";
		
		try {
			
			Connection conn = DBconnect.getConnection();
			
			PreparedStatement st = conn.prepareStatement(sql);
			
			ResultSet res = st.executeQuery();
			
			while(res.next()) {
				Station s = new Station(res.getInt("station_id"), res.getString("name"), res.getInt("dockcount"), res.getString("landmark"));
				listStation.add(s);
			}
			
			st.close();
			
			conn.close();
			
			return listStation;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	public List<Station> listStationByLandmark(String landmark){
		
		List<Station> listStation = new ArrayList<>();
		String sql = "SELECT station_id, name, dockcount, landmark FROM station WHERE landmark = ? ORDER BY name";
		
		try {
			
			Connection conn = DBconnect.getConnection();
			
			PreparedStatement st = conn.prepareStatement(sql);
			
			st.setString(1, landmark);
			
			ResultSet res = st.executeQuery();
			
			while(res.next()) {
				Station s = new Station(res.getInt("station_id"), res.getString("name"), res.getInt("dockcount"), res.getString("landmark"));
				listStation.add(s);
			}
			
			st.close();
			
			conn.close();
			
			return listStation;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
	
}
