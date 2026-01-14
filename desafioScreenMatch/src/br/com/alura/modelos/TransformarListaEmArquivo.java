package br.com.alura.modelos;

import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class TransformarListaEmArquivo {
    public static void listaParaArquivo(List<Titulo> lista, Gson gson) throws IOException {
        FileWriter escrita = new FileWriter("filmes.json");
        escrita.write(gson.toJson(lista));
        escrita.close();

    }
}
