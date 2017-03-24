package br.com.mobilesaude.servicounimedse.bean.CarteiraSE;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.taglibs.standard.lang.jstl.BooleanLiteral;

@XmlRootElement(name="CarteiraSE")
@XmlAccessorType(XmlAccessType.FIELD)


public class CarteiraSE {
	
	@XmlElement(name = "carteira_codigo")
	private String cd_carteira_inteira;
	
	@XmlElement(name = "carteira_numero")
	private String nr_carteira;
	
	@XmlElement(name = "codigo_unimed")
	private String cd_unimed;
	
	@XmlElement(name = "beneficiario_nome")
	private String nome;
	
	@XmlElement(name="beneficiario_sexo")
	private String sexo;
	
	@XmlElement(name="beneficiario_endereco")
	private String endereco;
	
	@XmlElement(name="Nascimento")
	private Calendar data_nascimento;
	
	public String getCd_carteira_inteira() {
		return cd_carteira_inteira;
	}
	public void setCd_carteira_inteira(String cd_carteira_inteira) {
		this.cd_carteira_inteira = cd_carteira_inteira;
	}
	public String getNr_carteira() {
		return nr_carteira;
	}
	public void setNr_carteira(String nr_carteira) {
		this.nr_carteira = nr_carteira;
	}
	public String getCd_unimed() {
		return cd_unimed;
	}
	public void setCd_unimed(String cd_unimed) {
		this.cd_unimed = cd_unimed;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public Calendar getData_nascimento() {
		return data_nascimento;
	}
	public void setData_nascimento(Calendar data_nascimento) {
		this.data_nascimento = data_nascimento;
	}
	
	
	
}
