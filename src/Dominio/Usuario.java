package Dominio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Usuario {
    String nome;
    String email;
    int idade;
    float altura;
    String[] respostasFormulario;
    File registro;

    Scanner scan = new Scanner(System.in);

    public void criarUsuario(Formulario formulario){
        System.out.println("############################");
        String[] tempRespostasFormulario = new String[formulario.quantidadeDePerguntas];
        respostasFormulario = new String[formulario.quantidadeDePerguntas];
        for(int i = 0; i < formulario.quantidadeDePerguntas; i++){
            System.out.println(formulario.perguntas[i] + ": ");
            tempRespostasFormulario[i] = scan.nextLine();
            respostasFormulario[i] = tempRespostasFormulario[i];
        }
        System.out.println("############################");
        System.out.println("Usuário criado");
        System.out.format("Nome: %s\nEmail: %s\nIdade: %s\nAltura: %s\n", respostasFormulario[0]
        , respostasFormulario[1], respostasFormulario[2], respostasFormulario[3]);
        System.out.println("############################");
    }

    public void criarRegistroUsuario(){
        String nomeConcatenado = respostasFormulario[0].replaceAll("\\s+", "").toUpperCase();
        registro = new File("registros", "1-" + nomeConcatenado + ".txt");
        try{
            registro.createNewFile();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void preencherRegistro(){
        try(FileWriter fw = new FileWriter(registro);
            BufferedWriter bw = new BufferedWriter(fw)){
            for(int i = 0; i < respostasFormulario.length; i++){
                bw.write((i+1) + " - " + respostasFormulario[i] + "\n");
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

}
