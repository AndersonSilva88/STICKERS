import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        // CONEXAO HTTP E BUSCAR OS TOP 250 FILMES
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        ExtratorDeConteudoDoIMDB extrator = new ExtratorDeConteudoDoIMDB();

        //String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/NASA-APOD-JamesWebbSpaceTelescope.json";
        //ExtratordeConteudoDaNasa extrator = new ExtratordeConteudoDaNasa();

        ClienteHttp http = new ClienteHttp();
        String json = http.buscaDados(url);

        // EXIBIR E MANIPULAR OS DADOS

        List<Conteudo> conteudos = extrator.extraiConteudo(json);


        GeradoraDeFigurinhas geradora = new GeradoraDeFigurinhas();

        for (int i = 0; i<10; i++) {

            Conteudo conteudo = conteudos.get(i);

            InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
            String nomeArquivo = "saida/" + conteudo.getTitulo() + ".png";

            geradora.cria(inputStream,nomeArquivo);

            System.out.println(conteudo.getTitulo());
            System.out.println();
        }

    }
}