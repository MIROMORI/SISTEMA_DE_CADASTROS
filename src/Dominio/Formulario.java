package Dominio;

import java.io.*;
import java.util.Scanner;

public class Formulario {
    int quantidadeDePerguntas;
    String[] perguntas;
    String path;
    File file;

    public void adicionarPerguntas(){
        String pergunta;
        Scanner scan = new Scanner(System.in);
        System.out.println("Pergunta: ");
        pergunta = scan.nextLine();
        quantidadeDePerguntas++;
        try(FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw)){
            bw.write(pergunta);
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public void apagarPerguntas(){

    }

    public void printarPerguntas(){
        try(FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr)){
            String linha;
            String[] tempPerguntas = new String[100];
            while((linha = br.readLine()) != null){
                tempPerguntas[quantidadeDePerguntas] = linha;
                quantidadeDePerguntas++;
            }
            perguntas = new String[quantidadeDePerguntas];
            for(int i = 0; i < quantidadeDePerguntas; i++){
                System.out.println(tempPerguntas[i]);
                perguntas[i] = tempPerguntas[i];
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static Formulario criarFormulario(String pathFormulario){
        return new Formulario(pathFormulario);
    }

    private Formulario(String pathFormulario){
        path = pathFormulario;
        file = new File(pathFormulario);
        try {
            file.createNewFile();
            System.out.println("Arquivo criado");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try(FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw)){
            bw.write("1 - Qual é o seu nome completo?\n");
            bw.write("2 - Qual é o seu email para contato?\n");
            bw.write("3 - Qual é a sua idade?\n");
            bw.write("4 - Qual é a sua altura?\n");
            System.out.println("Perguntas bases inseridas no arquivo");
        }catch (IOException e){
            e.printStackTrace();
        }
        printarPerguntas();
    }
}
