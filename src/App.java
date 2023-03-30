import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {

    public static void main(String[] args) throws Exception {

        // fazer uma conexão HTTP e buscar os top 250 filmes
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        var http = new ClienteHttp();
        String json = http.buscaDados(url);

        // exibir e manipular os dados 
        var extrator = new ExtratorConteudoImdb();
        List<Conteudo> conteudos = extrator.extraiConteudos(json);

        var geradora = new GeradoraDeFigurinhas();

        // for (Map<String,String> conteudo : listaDeConteudos)for each -> seleciona o tipo de elemento de retorno que eu quero : de onde esse elemento vem
            for (int i = 0; i < 3; i++){        
            Conteudo conteudo = conteudos.get(i);       
            InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
            String nomeArquivo = "saida/" + conteudo.getTitulo() + ".png";

            geradora.cria(inputStream, nomeArquivo);

            System.out.println(conteudo.getTitulo());
            System.out.println();
            }
    }
}