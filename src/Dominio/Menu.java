package Dominio;

import java.util.Scanner;

public class Menu {
    int opcao;

    {
        Formulario formulario = Formulario.criarFormulario("formulario.txt");
        Usuario usuario = new Usuario();
        Scanner scan = new Scanner(System.in);
        while(opcao != 6){
            System.out.println();
            System.out.println("1 - Cadastrar usuário");
            System.out.println("2 - Listar usuários");
            System.out.println("3 - Adicionar pergunta");
            System.out.println("4 - Deletar pergunta");
            System.out.println("5 - Procurar usuário");
            System.out.println("6 - Encerrar");
            System.out.println();
            opcao = scan.nextInt();

            switch (opcao){
                case 1:
                    usuario.criarUsuario(formulario);
                    Registro.criarDiretorioRegistro();
                    usuario.criarRegistroUsuario();
                    usuario.preencherRegistro();
                    break;
                case 2:
                    System.out.println("Ainda nao implementado");
                    break;
                case 3:
                    formulario.adicionarPerguntas();
                    break;
                case 4:
                    formulario.apagarPerguntas();
                    break;
                case 5:
                    System.out.println("Ainda nao implementado");
                    break;
                case 6:
                    System.out.println("Encerrando");
                    break;
                default:
                    System.out.println("Essa não é uma opção válida, tente novamente: ");
                    opcao = scan.nextInt();
                    break;
            }
        }
    }
}
