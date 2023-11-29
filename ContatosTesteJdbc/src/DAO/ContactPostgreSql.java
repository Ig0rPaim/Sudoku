package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Models.ContatoModel;
import connections.ConnectionPostgreSql;

public class ContactPostgreSql implements Contacts{
	private ConnectionPostgreSql conn;
	private PreparedStatement prep;
	
	public ContactPostgreSql() {
		conn = new ConnectionPostgreSql();
	}

	public void CreateContact(ContatoModel contact) {
		try{
			this.prep = conn
					.getConn()
					.prepareStatement(
					"INSERT INTO contatos (Name, Number, Email)"
					+ "VALUES(?, ?, ?)");
			this.prep.setString(1, contact.getName());
			this.prep.setString(2, contact.getNumber());
			this.prep.setString(3, contact.getEmail());
			this.prep.executeUpdate();
		} catch (SQLException er){
			er.printStackTrace();
		}
	}

	public void UpdateContact(ContatoModel contact) {
		try{
			this.prep = conn
					.getConn()
					.prepareStatement("UPDATE contatos"
									 + "SET Name = ?"
									 + "Number = ?"
									 + "Email = ?"
									 + "WHERE Email = ?");
					
			this.prep.setString(1, contact.getName());
			this.prep.setString(2, contact.getNumber());
			this.prep.setString(3, contact.getEmail());
			this.prep.setString(4, contact.getEmail());
			this.prep.executeUpdate();
		} catch (SQLException er){
			er.printStackTrace();
		}	
	}

	public void DeleteContact(ContatoModel contact) {
		try {
			this.prep = conn
					.getConn()
					.prepareStatement("DELETE"
							        + "FROM contatos"
							        + "WHERE Email = ?");
			this.prep.setString(1, contact.getEmail());
			this.prep.executeUpdate();
		} catch (SQLException er) {
			er.printStackTrace();
		}
	}

	public List<ContatoModel> GetContacts(String email) throws Exception {
		try {
			List<ContatoModel> conts = new ArrayList<ContatoModel>();
			this.prep = conn
					.getConn()
					.prepareStatement("SELECT *"
							        + "FROM contatos");
			ResultSet result = prep.executeQuery();
			while(result.next()) {
				ContatoModel cont = new ContatoModel(
						result.getString("Name"),
						result.getString("Number"),
						result.getString("Email")
						);
				conts.add(cont);
				return conts;
			}
			throw new Exception("Invalid Email");
		} catch (SQLException er) {
			er.printStackTrace();
		}
		return null;
	}

	public ContatoModel GetContactByEmail(String email) throws Exception {
		try {
			this.prep = conn
					.getConn()
					.prepareStatement("SELECT *"
							        + "FROM contatos"
							        + "WHERE Email = ?");
			this.prep.setString(0, email);
			ResultSet result = prep.executeQuery();
			if(result.next()) {
				ContatoModel cont = new ContatoModel(
						result.getString("Name"),
						result.getString("Number"),
						result.getString("Email")
						);
				return cont;
			}
			throw new Exception("Invalid Email");
		} catch (SQLException er) {
			er.printStackTrace();
		}
		return null;
	}

}
