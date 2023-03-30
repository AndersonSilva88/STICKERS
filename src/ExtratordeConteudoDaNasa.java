import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratordeConteudoDaNasa {

    public List<Conteudo> extraiConteudos(String json) {
        
        // EXTRAIR OS DADOS QUE INTERESSAM (TITULO, POSTER, CLASSIFICACAO)
        JsonParse parser = new JsonParse();
        List<Map<String, String>> listaDeAtributos = parser.parse(json);
        
        List<Conteudo> conteudos = new ArrayList<>();
        
        // popular a lista de conteudos
        for (Map<String, String> atributos : listaDeAtributos) {
            String titulo = atributos.get("title");
            String urlImagem = atributos.get("url");
            Conteudo conteudo = new Conteudo(titulo, urlImagem);

            conteudos.add(conteudo);
        }
        
        return conteudos;
    }
}
