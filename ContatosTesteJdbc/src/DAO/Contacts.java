package DAO;

import java.util.List;

import Models.ContatoModel;

public interface Contacts {
	public void CreateContact(ContatoModel contact);
	public void UpdateContact(ContatoModel contact);
	public void DeleteContact(ContatoModel contact);
	public List<ContatoModel>  GetContacts(String email) throws Exception ;
	public ContatoModel GetContactByEmail(String email) throws Exception ;
}
