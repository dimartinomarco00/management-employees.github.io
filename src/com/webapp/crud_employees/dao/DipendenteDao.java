package com.webapp.crud_employees.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.webapp.crud_employees.model.Dipendente;
import com.webapp.crud_employees.utils.JDBCUtils;

public class DipendenteDao 
{
	private static final String INSERISCI_DIPENDENTE_SQL = 
            "INSERT INTO dipendenti " +
            "(nome, cognome, eta, sesso, data_nascita, email, numero_telefono, salario) VALUES " + 
            "(?, ?, ?, ?, ?, ?,  ?, ?);";

	private static final String SELEZIONA_DIPENDENTE_PER_ID = "SELECT * FROM dipendenti WHERE id = ?";
	private static final String SELEZIONA_TUTTI_I_DIPENDENTI = "SELECT * FROM dipendenti";
	private static final String ELIMINA_DIPENDENTE_PER_ID = "DELETE FROM dipendenti WHERE id = ?;";
	private static final String MODIFICA_DIPENDENTE = "UPDATE dipendenti SET nome = ?, cognome = ?, eta = ?, sesso = ?, data_nascita = ?, email = ?, numero_telefono = ?, salario = ? WHERE id = ?;";
	
	
	public void inserisciDipendente(Dipendente dipendente) 
	{
		try(Connection connection = JDBCUtils.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(INSERISCI_DIPENDENTE_SQL))
		{
			preparedStatement.setString(1, dipendente.getNome());
			preparedStatement.setString(2, dipendente.getCognome());
			preparedStatement.setString(3, dipendente.getEta());
			preparedStatement.setString(4, dipendente.getSesso());
			preparedStatement.setDate(5, JDBCUtils.getSQLDate(dipendente.getDataNascita()));
			preparedStatement.setString(6, dipendente.getEmail());
			preparedStatement.setString(7, dipendente.getNumeroTelefono());
			preparedStatement.setString(8, dipendente.getSalario());
			
			System.out.println(preparedStatement);
			
			preparedStatement.executeUpdate();
		}
		catch(SQLException e)
		{
		   e.printStackTrace();
		}
	}
	
	
	public Dipendente selezionaDipendente(int idDipendente) 
	{
		Dipendente dipendente = null;
		
		try(Connection connection = JDBCUtils.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(SELEZIONA_DIPENDENTE_PER_ID))
		{
			preparedStatement.setInt(1, idDipendente);;
			
			System.out.println(preparedStatement);
			
			ResultSet resultSet = preparedStatement.executeQuery();
		
			while(resultSet.next())
			{
				int id = resultSet.getInt("id");
				String nome = resultSet.getString("nome");
				String cognome = resultSet.getString("cognome");
				String eta = resultSet.getString("eta");
				String sesso = resultSet.getString("sesso");
				
				LocalDate dataNascita = LocalDate.parse(resultSet.getDate("data_nascita").toString());
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy").withLocale(Locale.ITALY);
				String dataNascitaFormattata = dataNascita.format(formatter);
				
				String email = resultSet.getString("email");
				String numeroTelefono = resultSet.getString("numero_telefono");
				String salario = resultSet.getString("salario");
				
		
				dipendente = new Dipendente(id, nome, cognome, eta, sesso, dataNascitaFormattata, email, numeroTelefono, salario);
			}
		}
		catch(SQLException e)
		{
		   e.printStackTrace();
		}
		
		return dipendente;
	}
	
	
	public List<Dipendente> selezionaTuttiIDipendenti() 
	{
		List<Dipendente> dipendente = new ArrayList<>();
		
		try(Connection connection = JDBCUtils.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(SELEZIONA_TUTTI_I_DIPENDENTI))
		{
			System.out.println(preparedStatement);
			
			ResultSet resultSet = preparedStatement.executeQuery();
	
			while(resultSet.next())
			{
				int id = resultSet.getInt("id");
				String nome = resultSet.getString("nome");
				String cognome = resultSet.getString("cognome");
				String eta = resultSet.getString("eta");
				String sesso = resultSet.getString("sesso");
				
				LocalDate dataNascita = LocalDate.parse(resultSet.getDate("data_nascita").toString());
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy").withLocale(Locale.ITALY);
				String dataNascitaFormattata = dataNascita.format(formatter);
				 
				String email = resultSet.getString("email");
				String numeroTelefono = resultSet.getString("numero_telefono");
				String salario = resultSet.getString("salario");
				
				dipendente.add(new Dipendente(id, nome, cognome, eta, sesso, dataNascitaFormattata, email, numeroTelefono, salario));
	       }
	    }
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return dipendente;
	}
	

	public boolean eliminaDipendente(int id) 
	{
		boolean dipendenteEliminato = false;
		
		try(Connection connection = JDBCUtils.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(ELIMINA_DIPENDENTE_PER_ID))
		{
			preparedStatement.setInt(1, id);
			
			System.out.println(preparedStatement);
			
			dipendenteEliminato = preparedStatement.executeUpdate() > 0;
		}
		catch(SQLException e)
		{
		    e.printStackTrace();
		}
		
		return dipendenteEliminato;
	}
	

	public boolean modificaDipendente(Dipendente dipendente) 
	{
		boolean dipendenteModificato = false;
		
		try(Connection connection = JDBCUtils.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(MODIFICA_DIPENDENTE))
		{
			preparedStatement.setString(1, dipendente.getNome());
			preparedStatement.setString(2, dipendente.getCognome());
			preparedStatement.setString(3, dipendente.getEta());
			preparedStatement.setString(4, dipendente.getSesso());
			preparedStatement.setDate(5, JDBCUtils.getSQLDate(dipendente.getDataNascita()));
			preparedStatement.setString(6, dipendente.getEmail());
			preparedStatement.setString(7, dipendente.getNumeroTelefono());
			preparedStatement.setString(8, dipendente.getSalario());
			preparedStatement.setInt(9, dipendente.getId());
			
			System.out.println(preparedStatement);
			
			dipendenteModificato = preparedStatement.executeUpdate() > 0;
		}
		catch(SQLException e)
		{
		    e.printStackTrace();
		}
		
		return dipendenteModificato;
	}
}
