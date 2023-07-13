package com.webapp.crud_employees.model;

import java.time.LocalDate;

public class Dipendente 
{
    private int id;
    private String nome;
    private String cognome;
    private String eta;
    private String sesso;
    private String dataNascita;
    private String email;
    private String numeroTelefono;
    private String salario;
    
    public Dipendente()
    {
    	
    }

	public Dipendente(int id, String nome, String cognome, String eta, String sesso, String dataNascita, String email, String numeroTelefono, String salario) 
	{
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.eta = eta;
		this.sesso = sesso;
		this.dataNascita = dataNascita;
		this.email = email;
		this.numeroTelefono = numeroTelefono;
		this.salario = salario;
	}
    
    public Dipendente(String nome, String cognome, String eta, String sesso, String dataNascita, String email, String numeroTelefono, String salario) 
	{
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.eta = eta;
		this.sesso = sesso;
		this.dataNascita = dataNascita;
		this.email = email;
		this.numeroTelefono = numeroTelefono;
		this.salario = salario;
	}

	public int getId() 
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}

	public String getNome() 
	{
		return nome;
	}

	public void setNome(String nome) 
	{
		this.nome = nome;
	}

	public String getCognome() 
	{
		return cognome;
	}

	public void setCognome(String cognome) 
	{
		this.cognome = cognome;
	}

	public String getEta() 
	{
		return eta;
	}

	public void setEta(String eta) 
	{
		this.eta = eta;
	}

	public String getSesso() 
	{
		return sesso;
	}

	public void setSesso(String sesso) 
	{
		this.sesso = sesso;
	}

	public String getDataNascita() 
	{
		return dataNascita;
	}

	public void setDataNascita(String dataNascita) 
	{
		this.dataNascita = dataNascita;
	}

	public String getEmail() 
	{
		return email;
	}

	public void setEmail(String email) 
	{
		this.email = email;
	}

	public String getNumeroTelefono() 
	{
		return numeroTelefono;
	}

	public void setNumeroTelefono(String numeroTelefono) 
	{
		this.numeroTelefono = numeroTelefono;
	}

	public String getSalario() 
	{
		return salario;
	}

	public void setSalario(String salario) 
	{
		this.salario = salario;
	}
}
