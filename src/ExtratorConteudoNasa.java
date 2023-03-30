import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorConteudoNasa {
    List<Conteudo> extraiConteudos(String json){
        // extrair só os dados que interessam (titulo, poster, classificação)
        var parser = new JsonParser();
        List<Map<String, String>> listaDeAtributos = parser.parse(json);
        List<Conteudo> listaConteudos = new ArrayList<>();
        //popular a lista de conteudos
        for (Map<String,String> atributos : listaDeAtributos) {
            String titulo = atributos.get("title");
            String urlImagem = atributos.get("url");
            var conteudo = new Conteudo(titulo, urlImagem);

            listaConteudos.add(conteudo);
        }

        
        return listaConteudos;
    }
}
