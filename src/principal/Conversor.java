package principal;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Conversor {

    public DadosMoeda converterMoedas(String moedaBase, String moedaFinal, String valor) {
        String url = "https://v6.exchangerate-api.com/v6/7ca465b4371e15aa73c1ea9f/pair/" + moedaBase + "/" + moedaFinal + "/" + valor;

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            return new Gson().fromJson(response.body(), DadosMoeda.class);

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Não foi possível converter os valores", e);
        }
    }
}
