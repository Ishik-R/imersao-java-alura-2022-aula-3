import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {

        // Realizar a conexão HTTP e reconhecer o arquivo JSON, buscando o top 250 filmes do imDb.
        String url = "https://api.mocki.io/v2/549a5d8b/Top250Movies";

        URI endereco = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();

        // Extrair os dados pertinentes: título, poster e a avaliação.
        var parser = new JsonParser(); 
        List<Map<String, String>> listaDeFilmes = parser.parse(body);

        // Exibir os dados extraídos.
        var geradora = new GeradoraDeFigurinhas();

        for (Map<String, String> filme : listaDeFilmes) {
            String rank = filme.get("rank");
            String title = filme.get("title");
            String urlImagem = filme.get("image");
            String rating = filme.get("imDbRating");
            
            System.out.println("#" + rank + ": \u001b[1m" + title + "\u001b[m - " + rating);
            for (int i=0; i<Math.round(Float.parseFloat(filme.get("imDbRating"))); i++) {
                System.out.print("\u2B50");
            }

            InputStream inputStream = new URL(urlImagem).openStream();
            geradora.gerar(inputStream, title, rating);

            System.out.println();
        }
       
    }
}
