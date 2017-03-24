package br.com.mobilesaude.modelo;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Testes")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity

public class Testes {
	
	String cliente;
	
	
	public Testes(){
		cliente = "Unimed SE";
	}


	public String getCliente() {
		return cliente;
	}


	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	
	
}
