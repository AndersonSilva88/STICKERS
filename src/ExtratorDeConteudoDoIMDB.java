import java.util.List;
import java.util.Map;

public class ExtratorDeConteudoDoIMDB implements  ExtratorDeConteudo {


    @Override
    public List<Conteudo> extraiConteudo(String json) {

        JsonParse parser = new JsonParse();
        List<Map<String,String>> listaDeAtributos = parser.parse(json);

        return  listaDeAtributos.stream()
                .map(atributos -> new Conteudo(atributos.get("title"), atributos.get("image")
                        .replaceAll("(@+)(.*).jpg$", "$1.jpg")))
                .toList();
    }
}
