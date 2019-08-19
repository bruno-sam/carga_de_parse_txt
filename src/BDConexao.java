package CargaClientes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BDConexao {

	private static Statement stmt;
	private static Connection con;

	public String montarQuery(Importa importa) {
		StringBuilder sb = new StringBuilder();

		sb.append("INSERT INTO CLIENTESIBM ( ");
		sb.append("codigoCliente , ");
		sb.append("codigoMatriz , ");
		sb.append("razaoSocial , ");
		sb.append("nomeFantasia , ");
		sb.append("endereco , ");
		sb.append("cep , ");
		sb.append("cidade , ");
		sb.append("estado , ");
		sb.append("cgc , ");
		sb.append("cgcCliente , ");
		sb.append("senha , ");
		sb.append("idRegional , ");
		sb.append("idFilial , ");
		sb.append("inscricaoEstadual , ");
		sb.append("contato , ");
		sb.append("cargo , ");
		sb.append("telefone , ");
		sb.append("fax , ");
		sb.append("email , ");
		sb.append("emailcom , ");
		sb.append("dataFiliacao , ");
		sb.append("dataCongelamento , ");
		sb.append("dataAtualizacao , ");
		sb.append("codigoFaturameno , ");
		sb.append("acompanhamento , ");
		sb.append("plano , ");
		sb.append("planoGpe , ");
		sb.append("nomeGpe , ");
		sb.append("cotaGpe , ");
		sb.append("grupoFaturamento , ");
		sb.append("banco , ");
		sb.append("diaVencimento , ");
		sb.append("quantidadeCliente , ");
		sb.append("origemVenda , ");
		sb.append("lancamento , ");
		sb.append("percentual , ");
		sb.append("faturamentoExterno , ");
		sb.append("faturamentoVirado , ");
		sb.append("proximaRemessa , ");
		sb.append("site , ");
		sb.append("regiao , ");
		sb.append("codigoVendedor , ");
		sb.append("codigoSupervisor , ");
		sb.append("codigoEscritorio , ");
		sb.append("codigoFilial , ");
		sb.append("codigoGerenteFilial , ");
		sb.append("codigoRegional , ");
		sb.append("codigoDiretorRegional , ");
		sb.append("historicoCliente , ");
		sb.append("dataAtualizacaoIbm , ");
		sb.append("associacao , ");
		sb.append("codigoCarta , ");
		sb.append("carencia , ");
		sb.append("codDiretorRegionalAnual , ");
		sb.append("codEscriorioAtual , ");
		sb.append("codFilialAtual , ");
		sb.append("codGerenteFilialAtual , ");
		sb.append("codRegionalAtual , ");
		sb.append("codSupervisorAtual , ");
		sb.append("codVendedorAtual , ");
		sb.append("ultimaRemessa , ");
		sb.append("observacao , ");
		sb.append("cdGRP , ");
		sb.append("clienteSincro  ");
		sb.append(Integer.parseInt(importa.getCodigoCliente()) + ",");
		sb.append("'"+importa.getCodigoMatriz()+"'");
		sb.append(importa.getRazaoSocial());
		sb.append(importa.getNomeFantasia());
		sb.append(importa.getEndereco());
		sb.append(importa.getCep());
		sb.append(importa.getCidade());
		sb.append(importa.getEstado());
		sb.append(importa.getCgc());
		sb.append(importa.getCgcCliente());
		sb.append(importa.getSenha());
		sb.append(importa.getIdRegional());
		sb.append(importa.getIdFilial());
		sb.append(importa.getInscricaoEstadual());
		sb.append(importa.getContato());
		sb.append(importa.getCargo());
		sb.append(importa.getTelefone());
		sb.append(importa.getFax());
		sb.append(importa.getEmail());
		sb.append(importa.getEmailcom());
		sb.append("to_date('DD/MM/YYYY', '"+importa.getDataFiliacao()+"',");
		sb.append(importa.getDataCongelamento());
		sb.append(importa.getDataAtualizacao());
		sb.append(importa.getCodigoFaturameno());
		sb.append(importa.getAcompanhamento());
		sb.append(importa.getPlano());
		sb.append(importa.getPlanoGpe());
		sb.append(importa.getNomeGpe());
		sb.append(importa.getCotaGpe());
		sb.append(importa.getGrupoFaturamento());
		sb.append(importa.getBanco());
		sb.append(importa.getDiaVencimento());
		sb.append(importa.getQuantidadeCliente());
		sb.append(importa.getOrigemVenda());
		sb.append(importa.getLancamento());
		sb.append(importa.getPercentual());
		sb.append(importa.getFaturamentoExterno());
		sb.append(importa.getFaturamentoVirado());
		sb.append(importa.getProximaRemessa());
		sb.append(importa.getSite());
		sb.append(importa.getRegiao());
		sb.append(importa.getCodigoVendedor());
		sb.append(importa.getCodigoSupervisor());
		sb.append(importa.getCodigoEscritorio());
		sb.append(importa.getCodigoGerenteFilial());
		sb.append(importa.getCodigoRegional());
		sb.append(importa.getHistoricoCliente());
		sb.append(importa.getDataAtualizacaoIbm());
		sb.append(importa.getAssociacao());
		sb.append(importa.getCodigoCarta());
		sb.append(importa.getCarencia());
		sb.append(importa.getCodDiretorRegionalAnual());
		sb.append(importa.getCodEscriorioAtual());
		sb.append(importa.getCodFilialAtual());
		sb.append(importa.getCodGerenteFilialAtual());
		sb.append(importa.getCodRegionalAtual());
		sb.append(importa.getCodSupervisorAtual());
		sb.append(importa.getCodVendedorAtual());
		sb.append(importa.getUltimaRemessa());
		sb.append(importa.getObservacao());
		sb.append(importa.getCdGRP());
		sb.append(importa.getClienteSincro());

		return sb.toString();
	}

	public void salvar(String query) {
		try {
			inicializarConexaoBD();
			stmt.executeQuery(query);
			System.out.println("Gravado!");
			finalizarConexaoBD();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	private void inicializarConexaoBD() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
//Subsituir User e Pass
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@//192.168.0.1:1527/HMLGO", "user",
				"pass");
		stmt = con.createStatement();
	}

	private void finalizarConexaoBD() {
		try {
			stmt.close();

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
