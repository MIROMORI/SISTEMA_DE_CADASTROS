package Dominio;

import java.io.File;

public class Registro {
    Usuario[] usuario;
    static String path = "registros";
    static int quantidadeRegistros = 0;

    public static void criarDiretorioRegistro(){
        if(quantidadeRegistros == 0){
            File file = new File(path);
            file.mkdir();
        }
    }
}
