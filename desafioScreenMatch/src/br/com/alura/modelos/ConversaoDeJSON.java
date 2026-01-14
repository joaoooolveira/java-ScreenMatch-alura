package br.com.alura.modelos;

import br.com.alura.excecoes.ErroDeCriacaoDeTituloException;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

public class ConversaoDeJSON {
    public static Titulo converterJsonEmTitulo(String jsonDoFilme)
            throws IOException, InterruptedException {
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        TituloOMDB meuTituloOMDB = gson.fromJson(jsonDoFilme, TituloOMDB.class);
        Titulo tituloDoFilme = new Titulo(meuTituloOMDB);
        return tituloDoFilme;

    }
}
