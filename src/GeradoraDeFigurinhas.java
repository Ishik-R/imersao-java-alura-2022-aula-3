import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;

import javax.imageio.ImageIO;

public class GeradoraDeFigurinhas {

    void gerar(InputStream inputStream, String titulo, String classificacao) throws Exception {

        // leitura da imagem
        BufferedImage imagemOriginal = ImageIO.read(inputStream);

        // criar uma nova imagem em memória com transparência e tamanho novo
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 220;

        System.out.println("Original: altura - " + altura + "px / largura - " + largura + "px");

        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        // copiar a imagem original para uma nova imagem (em memória)
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);

        // configurando a fonte
        var fonte = new Font("Comic Sans MS", Font.BOLD, 100);
        FontMetrics medidasFonte = graphics.getFontMetrics(fonte);
        graphics.setFont(fonte);
        graphics.setColor(Color.YELLOW);

        // definir texto personalizado de acordo com a classificação
        String textoAvaliacao = classificacao + ": ";
        if (Float.parseFloat(classificacao) >= 9.2) {
            textoAvaliacao += "SHOW!";          
        } else if (Float.parseFloat(classificacao) >= 9.0) {
            textoAvaliacao += "só magia top!";  
        } else if (Float.parseFloat(classificacao) >= 8.5) {
            textoAvaliacao += "doidera!";
        } else if (Float.parseFloat(classificacao) >= 8.0) {
            textoAvaliacao += "sopinha de abóbora";
        } else if (Float.parseFloat(classificacao) >= 6.0) {
            textoAvaliacao += "muito diálogo";
        } else if (Float.parseFloat(classificacao) >= 4.0) {
            textoAvaliacao += "nada a ver";
        } else {
            textoAvaliacao += "tá certa a indignação";
        }

        // definir imagem personalizada de acordo com a classificação

        // descrever a classificação na imagem
        graphics.drawString(textoAvaliacao, (largura - medidasFonte.stringWidth(textoAvaliacao))/2, novaAltura - 100);

        // escrever a imagem em um novo arquivo
        String nomeArquivo = titulo.replace(":", "-") + ".png";
        ImageIO.write(novaImagem, "png", new File(nomeArquivo));
    }

}
