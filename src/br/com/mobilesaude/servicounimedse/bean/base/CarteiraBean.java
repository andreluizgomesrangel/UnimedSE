package br.com.mobilesaude.servicounimedse.bean.base;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import javax.ejb.Stateless;

import br.com.mobilesaude.servicounimedse.bean.CarteiraSE.CarteiraSE;
import sun.util.resources.CalendarData;

public class CarteiraBean extends SrmovbenBean {
	
	public CarteiraSE find( String carteirinha ){
		CarteiraSE plano = new CarteiraSE( );
		String cd_unimed =  carteirinha.substring(0,4) ;
		String cd_carteira_inteira =  carteirinha.substring(4,17) ;
		
		//String table = new String("pub.\"car-ide\"");
		//String query = "select * from "+table+" where \"cd-unimed\" = "+cd_unimed+" and \"cd-carteira-inteira\" = "+cd_carteira_inteira+" ";

		/*String sql = "insert into Clientes " +
	             "(nome,idade,telefone,rua,numero,bairro,cidade,estado,login,senha)" +
	             " values (?,?,?,?,?,?,?,?,?,?)";*/
		
		String query = "select * from pub.\"car-ide\" where \"cd-unimed\" = ? and \"cd-carteira-inteira\" = ?";
		try{
		PreparedStatement stmt = getConnection().prepareStatement(query);
		stmt.setString(1, cd_unimed);
		stmt.setString(2, cd_carteira_inteira);
		
		ResultSet rs = stmt.executeQuery();
		String nr_carteira;
		
		while (rs.next()) {
			//cd_carteira_inteira = rs.getString("cd-carteira-inteira");
			nr_carteira = rs.getString("nr-carteira");
			plano.setCd_carteira_inteira(cd_carteira_inteira);
			plano.setNr_carteira(nr_carteira);
			plano.setCd_unimed(cd_unimed);
		}
		
		}catch (SQLException e) {
			   throw new RuntimeException(e);
		}return plano;
		
	}
	
	public CarteiraSE busca(){
		CarteiraSE plano = new CarteiraSE( );
		   try{
			   
		   PreparedStatement stmt = getConnection().prepareStatement("select * from pub.\"car-ide\" where \"cd-unimed\" = 0108 and \"cd-carteira-inteira\" = 0601260003692 ");
			   // executa um select
			   ResultSet rs = stmt.executeQuery();
			   
			   String cd_carteira_inteira;
			   String nr_carteira;
			   while (rs.next()) {
				   cd_carteira_inteira = rs.getString("cd-carteira-inteira");
				   nr_carteira = rs.getString("nr-carteira");
				  
				   System.out.println(cd_carteira_inteira +" "+nr_carteira);
				   plano.setCd_carteira_inteira(cd_carteira_inteira);
				   plano.setNr_carteira(nr_carteira);
				 }
			   
			   stmt.close();
			   
		   }catch (SQLException e) {
			   throw new RuntimeException(e);
		   }
		   return plano;
	   }
	
	String Sexob_to_SexoS(Boolean cdsexo){
		if(cdsexo==true) return "M";
		return "F";
	}
	
	public CarteiraSE busca2(String carteirinha){
		CarteiraSE plano = new CarteiraSE( );
		String cd_unimed =  carteirinha.substring(0,4) ;
		String cd_carteira_inteira =  carteirinha.substring(4,17) ;
		   try{
			   String query = " select p.\"nm-pessoa\" as nome, "
			   				+ "	p.\"dt-nascimento\" as nasc, "
			   				+ "	p.\"cd-cpf\" as cpf, "
			   				+ "	p.\"cd-cartao-nacional-saude\" as cns, "
			   				+ "	proposta.\"cd-contratante\" as cdContratante, "
			   				+ "	proposta.\"cd-modalidade\" as cdModalidade, "
			   				+ " proposta.\"cd-plano\" as cdPlano,"
			   				+ "	proposta.\"nr-proposta\" as nrProposta, "
			   				+ "	proposta.\"cd-tipo-plano\" as cdTipoPlano, "
			   				+ "	proposta.\"nr-insc-contratante\" as nrInscContrante,"
			   				+ "	proposta.\"nr-insc-contrat-origem\" as nrInscContranteOrigem, "
			   				+ "	proposta.\"cd-contrat-origem\" as cdContratoOrigem,"
			   				+ "	proposta.\"idi-plano-ans\" as idPlanoAns, "
			   				+ "	proposta.\"cd-forma-pagto\" as cdFormaPagamento, "
			   				+ "	proposta.\"nr-ter-adesao\" as nrTermoAdesaoProposta, "
			   				+ " proposta.\"in-tipo-contratacao\" as cdTipoContratacao, "
			   				+ "	proposta.\"mm-ult-reajuste\" as mesUltimoReajuste, "
			   				+ "	proposta.\"in-registro-plano\" as cdRegistroPlano, "
			   				+ "	proposta.\"dt-alteracao-regulam\" as dtAlteracaoRegulamentacao, "
			   				+ " "
			   				+ "	i.\"cd-carteira-inteira\" as matricula, "
			   				+ "	i.\"nr-ter-adesao\" as nrTerAdesao, "
			   				+ "	i.\"nr-carteira\" as via, "
			   				+ "	i.\"dt-validade\" as validade, "
			   				+ "	u.\"lg-carencia\" as possuiCarencia, "
			   				+ "	u.\"lg-bonifica-penaliza\" as possuiBonificaPenaliza, "
			   				+ "	u.\"cd-usuario\" as cdUsuario, "
			   				+ "	u.\"cd-unimed\" as cdUnimed,"
			   				+ "	u.\"cd-unimed-origem\" as cdUnimedOrigem,"
			   				+ "	u.\"cd-unimed-destino\" as cdUnimedDestino, "
			   				+ "	u.\"cd-funcionario\" as cdFuncionario, "
			   				+ "	u.\"cd-grau-parentesco\" as cdGrauParentesco, "
			   				+ "	u.\"in-segmento-assistencial\" as cdSegmentoAssistencial, "
			   				+ "	u.\"idi-plano-ans\" as usuIdPlanoAns, "
			   				+ "	u.\"dt-exclusao-plano\" as dtExclusaoPlano, "
			   				+ "	u.\"lg-sexo\" as cdSexo, "
			   				+ "	u.\"nr-dias\" as nrDias, "
			   				+ "	u.\"cd-titular\" as cdTitular, "
			   				+ "	u.\"in-via-transferencia\" as cdViaTransferencia, "
			   				+ "	u.\"dt-inicio-vinculo-unidade\" as dtInicioVinculo, "
			   				+ "	termo.\"cd-classe-mens\" as cdClasseMensagem, "
			   				+ "	termo.\"dt-inicio\" as p "
			   				+ " "
			   				+ "	from pub.usuario u, pub.\"pessoa-fisica\" p, "
			   				+ "	pub.\"car-ide\" i, pub.endereco e, pub.propost proposta, pub.\"ter-ade\" termo "
			   				+ "	where p.\"id-pessoa\" = u.\"id-pessoa\" "
			   				+ "	and u.\"cd-modalidade\" = i.\"cd-modalidade\" "
			   				+ "	and u.\"nr-ter-adesao\" = i.\"nr-ter-adesao\"  "
			   				+ "	and u.\"cd-usuario\"    = i.\"cd-usuario\" "
			   				+ "	and e.\"id-pessoa\"     = p.\"id-pessoa\"  "
			   				+ "	and e.\"lg-principal\"  = 1  "
			   				+ "	and u.\"cd-modalidade\" = proposta.\"cd-modalidade\" "
			   				+ "	and u.\"nr-proposta\" = proposta.\"nr-proposta\" "
			   				+ "	and termo.\"cd-modalidade\" = proposta.\"cd-modalidade\" "
			   				+ "	and termo.\"nr-ter-adesao\" = proposta.\"nr-ter-adesao\" "
			   				+ " "
			   				+ "	and i.\"cd-unimed\" = ? "
			   				+ "	and i.\"cd-carteira-inteira\" = ? "
			   				+ "	and i.\"nr-carteira\" = (select max(\"nr-carteira\") from pub.\"car-ide\" where \"cd-unimed\" = ? and \"cd-carteira-inteira\" = ? )";
			   
			   //String query = "select * from pub.\"car-ide\" where \"cd-unimed\" = ? and \"cd-carteira-inteira\" = ?";
			   PreparedStatement stmt = getConnection().prepareStatement(query);
			   stmt.setString(1, cd_unimed);
			   stmt.setString(2, cd_carteira_inteira);
			   stmt.setString(3, cd_unimed);
			   stmt.setString(4, cd_carteira_inteira);
			   
			   // executa um select
			   ResultSet rs = stmt.executeQuery();
			   
			   //String cd_carteira_inteira;
			   String nr_carteira, nome, endereco;
			   Boolean sexo;
			   Calendar nascimento = Calendar.getInstance();
			   
			   while (rs.next()) {
				   
				   nr_carteira = rs.getString("via");
				   nome = rs.getString("nome");
				   //endereco = rs.getString("pub.endereco");
				   sexo = rs.getBoolean("cdSexo"); 
				   
				   nascimento.setTime(rs.getDate("nasc"));
				   
				   
				   plano.setNr_carteira(nr_carteira);
				   plano.setNome(nome);
				   //plano.setEndereco(endereco);
				   plano.setSexo( Sexob_to_SexoS(sexo) );
				   plano.setData_nascimento(nascimento);
				 }
			   stmt.close();
		   }catch (SQLException e) {
			   throw new RuntimeException(e);
		   }
		   return plano;
	   }
}