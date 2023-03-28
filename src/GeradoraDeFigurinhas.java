import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class GeradoraDeFigurinhas {

    void cria() throws IOException {

        // leitura da imagem
        //InputStream inputStream = new FileInputStream(new File("img/filme.jpg"));
        InputStream inputStream = new URL("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/MostPopularTVs_1.jpg")
                .openStream();
        BufferedImage imageOriginal = ImageIO.read(inputStream);

        // cria nova imagem em memória com transparência e com tamanho novo
        int largura = imageOriginal.getWidth();
        int altura = imageOriginal.getHeight();
        int novaAltura = altura + 200;
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        // copiar a imagem original para nova imagem (em memória)
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imageOriginal, 0, 0, null);

        // configurar a fonte
        Font fonte = new Font(Font.SANS_SERIF, Font.BOLD, 64);
        graphics.setColor(Color.YELLOW);
        graphics.setFont(fonte);

        // escrever uma frase na nova imagem
        graphics.drawString("JACUUUUUU", 100, novaAltura - 100);

        //escrever a nova imagem em um arquivo
        ImageIO.write(novaImagem,"png", new File("saida/figurinha.png"));
    }

    public static void main(String[] args) throws IOException {

        GeradoraDeFigurinhas geradora = new GeradoraDeFigurinhas();

        geradora.cria();
    }
}
