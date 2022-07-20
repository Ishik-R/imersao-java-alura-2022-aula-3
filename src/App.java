import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {

        // Realizar a conexão HTTP e reconhecer o arquivo JSON, buscando o top 250 filmes do imDb.
        String url = "https://alura-filmes.herokuapp.com/conteudos";

        URI endereco = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();

        // Extrair os dados pertinentes: título, poster e a avaliação.
        var parser = new JsonParser(); 
        List<Map<String, String>> listaDeFilmes = parser.parse(body);

        // Exibir os dados extraídos.
        for (Map<String, String> filme : listaDeFilmes) {
            System.out.println("#" + filme.get("rank") + ": \u001b[1m" + filme.get("title"));
            System.out.println("\u001b[mPoster: " + filme.get("image"));
            System.out.println("Classificação: " + filme.get("imDbRating"));
            for (int i=0; i<Math.round(Float.parseFloat(filme.get("imDbRating"))); i++) {
                System.out.print("\u2B50");
            }
            System.out.println();
        }

    }
}
