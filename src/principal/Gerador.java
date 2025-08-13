package principal;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class Gerador {
    public void salvaJson(DadosMoeda moedas) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter escrita = new FileWriter( moedas +".json");
        escrita.write(gson.toJson(moedas));
        escrita.close();
    }
}
