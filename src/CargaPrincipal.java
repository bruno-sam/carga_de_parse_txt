package CargaClientes;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CargaPrincipal {
	
	public static void main(String args[]) throws IOException, URISyntaxException {
		
		BDConexao bdc = new BDConexao();
		
		Path path = Paths.get("c:\\clientes.txt");

		List<String> linhasArquivo = Files.readAllLines(path);

		//parseia string para inteiro
//		Integer.parseInt(s);
		
//		for (String linha : linhasArquivo) {
//			System.out.println(linha);
//			String query = bdc.montarQuery(new Importa(linha));
//			
//			bdc.salvar(query);
//		}
		
		System.out.println(linhasArquivo.get(0));
		String query = bdc.montarQuery(new Importa(linhasArquivo.get(0)));
		
//		bdc.salvar(query);
		System.out.println(query);
	}
	
}
