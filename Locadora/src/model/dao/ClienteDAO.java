package model.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import connection.ConnectionFactory;
import model.bean.Cliente;



public class ClienteDAO {
	public void create(Cliente c) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement("INSERT INTO Cliente (cName, cSurname, cEmail, cPhone, cAddress) VALUES (?,?,?,?,?);");
			stmt.setString(1, c.getcName());
			stmt.setString(2,c.getcSurname());
			stmt.setString(3,c.getcEmail());
			stmt.setString(4,c.getcPhone());
			stmt.setString(5,c.getcAddress());
			
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "Cadastro na tabela cliente concluido!");
		}
		catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro no salvar no banco, tabela cliente: " + e);
			
		}
		finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
		
	}
	
	
}
 