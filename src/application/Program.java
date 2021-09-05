package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.protocol.Resultset;

import db.DB;

public class Program {

	public static void main(String[] args) {
		
		Connection conn = null;
		Statement st = null;
        ResultSet rs = null;
		
		try {
			conn = DB.getConnection(); //conceta ao banco de dados
			st = conn.createStatement(); // INSTANCIEI UM OBJETO 
			
			rs = st.executeQuery("select * from department");
			
			while(rs.next()) { //NEXT()-> COMANDO SQL PRA RODAR TODA TABELA
				System.out.println(rs.getInt("Id") + " , " + rs.getString("Name")); // LENDO TODA TABELA PELOS ID'S(INT) E OS NOMES(STRING), POSIÇÃO POR POSIÇÃO
				
			}
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		   finally {
			   DB.closeResultSet(rs);
			   DB.closeStatement(st);
			   DB.closeConnection();
		   }
		}
		
	}


