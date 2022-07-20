import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.awt.Color;
import java.awt.Font;

import javax.imageio.ImageIO;

public class GeradoraDeFigurinhas {
    
    void gerar() throws Exception{
        // leitura da imagem
        InputStream inputStream = new URL("https://m.media-amazon.com/images/M/MV5BMDA1ZWI4ZDItOTRlYi00OTUxLWFlNWQtMzM5NDI0YjA4ZGI2XkEyXkFqcGdeQXVyMjUzOTY1NTc@.jpg").openStream();
        BufferedImage imagemOriginal = ImageIO.read(inputStream);

        // criar uma nova imagem em memória com transparência e tamanho novo
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;

        System.out.println("altura: " + altura);
        System.out.println("largura: " + largura);

        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        // copiar a imagem original para uma nova imagem (em memória)
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);

        // configurando a fonte
        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 100);
        graphics.setFont(fonte);
        graphics.setColor(Color.YELLOW);

        // escrever uma frase na nova imagem
        graphics.drawString("TOPZERA", 0, novaAltura - 100);

        // escrever a imagem em um novo arquivo
        ImageIO.write(novaImagem, "png", new File("saida/figurinha.png"));
    }

    public static void main(String[] args) throws Exception {
        var geradora = new GeradoraDeFigurinhas();
        geradora.gerar();
    }
}
