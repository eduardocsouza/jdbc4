package aplicacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import db.DB;

public class Programa {

	public static void main(String[] args) {

		Connection conn = null;
		PreparedStatement st = null;
		
			try {
				conn = DB.getConnection();
				st = conn.prepareStatement(
						"UPDATE seller "
						+ "SET BaseSalary = BaseSalary + ? "
						+ "WHERE "
						+ "(Name = ?)");
				
				st.setDouble(1, 200.00);
				st.setString(2, "dudu");
				
				int linhas = st.executeUpdate();
				System.out.println("Alinhas alterada: " + linhas);
			}
			catch(SQLException e) {
				e.printStackTrace();				
			}
			finally {
				DB.closeStatement(st);
				DB.closeConnetion();
			}
	}	
}
