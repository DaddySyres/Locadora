package model.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import connection.ConnectionFactory;
import model.bean.Cliente;
import model.bean.Cliente;



public class ClienteDAO {
	public void create(Cliente c) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement("INSERT INTO cliente (cNome, cCPF, cEmail, cTelefone, cEndereco) VALUES (?,?,?,?,?);");
			stmt.setString(1, c.getcNome());
			stmt.setString(2,c.getcCPF());
			stmt.setString(3,c.getcEmail());
			stmt.setString(4,c.getcTelefone());
			stmt.setString(5,c.getcEndereco());
			
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "Cadastro na tabela c concluido!");
		}
		catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro no salvar no banco, tabela c: " + e);
			
	}
	finally {
		ConnectionFactory.closeConnection(con, stmt);
	}
		
}

	public List<Cliente> read() {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null; 
		ResultSet rs = null;
		List<Cliente> cs = new ArrayList<>();
		
		try {
			stmt = con.prepareStatement("SELECT * FROM cliente;");
			rs = stmt.executeQuery();
			while(rs.next()) {
				Cliente c = new Cliente();
				c.setcId(rs.getInt("cId"));
				c.setcNome(rs.getString("cNome"));
				c.setcCPF(rs.getString("cCPF"));
				c.setcEmail(rs.getString("cEmail"));
				c.setcTelefone(rs.getString("cTelefone"));
				c.setcEndereco(rs.getString("cEndereco"));
				cs.add(c);
			}
		}
		
		catch(SQLException e){
			JOptionPane.showMessageDialog(null, "erro ao buscar os informaçoes no banco:" + e);
			e.printStackTrace();	
		}
		
		finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		return cs;
	}
	
	
	public Cliente read(int id){
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Cliente c = new Cliente();
		
		try {
			stmt = con.prepareStatement("SELECT * FROM cliente WHERE cId=? Limit 1");
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			if(rs != null && rs.next()) {
				c.setcId(rs.getInt("cId"));
				c.setcNome(rs.getString("cNome"));
				c.setcCPF(rs.getString("cCPF"));
				c.setcEmail(rs.getString("cEmail"));
				c.setcTelefone(rs.getString("cTelefone"));
				c.setcEndereco(rs.getString("cEndereco"));
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		return c;
	}

	public void  update(Cliente c) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		
		try {
			stmt = con.prepareStatement("UPDATE `cliente` SET `cNome`=?,`cCPF`=?,`cEmail`=?,`cTelefone`=?,`cEndereco`=? WHERE `cId`=? LIMIT 1");
			stmt.setString(1, c.getcNome());
			stmt.setString(2, c.getcCPF());
			stmt.setString(3, c.getcEmail());
			stmt.setString(4, c.getcTelefone());
			stmt.setString(5, c.getcEndereco());
			stmt.setInt(6, c.getcId());
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(null,"Banco de dado atualizado com sucesso!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"Erro ao Atualizar o Banco de Dados " + e);
			e.printStackTrace();
		}
		finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}
	
	public void delete(Cliente c) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement("DELETE FROM Cliente WHERE cId =?");
			stmt.setInt(1, c.getcId());
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "Cliente deletado com sucesso!");
			
		} catch(SQLException e){
			JOptionPane.showMessageDialog(null, "Erro ao delatar: " + e);
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(con);	
		}
	}
	
}
	
	

 