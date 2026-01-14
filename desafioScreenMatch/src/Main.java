import br.com.alura.excecoes.ErroDeCriacaoDeTituloException;
import br.com.alura.modelos.ConversaoDeJSON;
import br.com.alura.modelos.Titulo;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static void main() throws IOException, InterruptedException {
        Scanner leitura = new Scanner(System.in);
        String buscaDeFilme = "";
        List<Titulo> listaDeTitulos = new ArrayList();

        Gson gson = (new GsonBuilder()).setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).setPrettyPrinting().create();

        while(!buscaDeFilme.equalsIgnoreCase("sair")) {
            System.out.print("Digite um filme que deseja buscar: ");
            buscaDeFilme = leitura.nextLine();
            if (buscaDeFilme.equalsIgnoreCase("sair")) {
                break;
            }
            try {
                String json = buscarJsonDoFilme(buscaDeFilme);
                System.out.println(json);

                Titulo tituloConvertido = ConversaoDeJSON.converterJsonEmTitulo(json);

            } catch (ErroDeCriacaoDeTituloException e){
                System.out.println(e.getMensagem());
            }
        }

        System.out.println(listaDeTitulos);
        FileWriter escrita = new FileWriter("filmes.json");
        escrita.write(gson.toJson(listaDeTitulos));
        escrita.close();
    }

    private static String buscarJsonDoFilme(String nomeDoTitulo)
            throws IOException, InterruptedException{
        String chaveAPI = "90aa8218";
        String endereco = "https://www.omdbapi.com/?t=" + nomeDoTitulo.replace(" ", "-") + "&apikey=" + chaveAPI;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }
}
