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
        try(FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw)){
            bw.write(pergunta + "\n");
        }catch (IOException e){
            e.printStackTrace();
        }
        printarPerguntas();

    }

    public void apagarPerguntas(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Apagar pergunta de número: ");
        int perguntaDeletada = scan.nextInt();
        //criar novo arquivo temporario
        File tempFormulario = new File("tempFormulario.txt");
        try{
            tempFormulario.createNewFile();
        }catch (IOException e){
            e.printStackTrace();
        }
        try(FileWriter fw = new FileWriter(tempFormulario);
        BufferedWriter bw = new BufferedWriter(fw)){
            for(int i=0;i<quantidadeDePerguntas;i++){
                if(i != perguntaDeletada - 1 && i > 4) {
                    bw.write(perguntas[i] + "\n");
                    bw.flush();
                    File formulario = new File("formulario.txt");
                    try{
                        formulario.delete();
                        tempFormulario.renameTo(formulario);
                    }catch (SecurityException e){
                        e.printStackTrace();
                    }
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public void printarPerguntas(){
        try(FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr)){
            String linha;
            String[] tempPerguntas = new String[100];
            quantidadeDePerguntas = 0;
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
