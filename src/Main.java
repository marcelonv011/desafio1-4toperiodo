import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static List<Pessoa> pessoas = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);


    public static void main(String[] args){

        int opcao;

        do {

        opcao = menuInicial();

            switch (opcao) {
                case 1: inserirPessoas(); break;
                case 2: listarPessoas(); break;
                case 3: buscarPorNome(); break;
                default:
                    System.out.println("opcao invalida");

            }
        } while(opcao != 4);




    }

    private static void listarPessoas(){
        System.out.println("-----------Lista de pessoas------");
        for (int i = 0; i < pessoas.size(); i++){
            System.out.println("Nome: " + pessoas.get(i).getNome());
            System.out.println("Idade: " + pessoas.get(i).getIdade());
            for (int j = 0; j < pessoas.get(i).getEnderecos().size(); j++) {
                System.out.println("A rua do endereco: " +(j+1)+ "é: " + pessoas.get(i).getEnderecos().get(j).getRua());
                System.out.println("O numero do endereco: " + (j+1) + "é: " + pessoas.get(i).getEnderecos().get(j).getNumero());
            }
        }
    }

    private static void inserirPessoas(){
        System.out.println();
        System.out.println("Digite o nome");
        String nome = sc.next();
        System.out.println("Digite a idade");
        int idade = sc.nextInt();
        System.out.println("Deseja cadastrar um endereco?");
        boolean end = sc.nextBoolean();

        List<Endereco> enderecos = new ArrayList<>();

        while (end ) {
            System.out.println("Digite a rua");
            String rua =  sc.next();
            System.out.println("Digite o numero");
            int numero = sc.nextInt();
            enderecos.add(new Endereco(rua, numero));

            System.out.println("Deseja cadastrar um endereco");
            System.out.println("Digite 0 para nao e 1 para sim");
            end = sc.nextBoolean();
        }

        pessoas.add(new Pessoa(nome, idade, enderecos));

    }

    public static void buscarPorNome(){
        System.out.println("Digite o nome a ser pesquisado: ");
        String nomePesquisar = sc.next();
        int aux = -1;

        for (int i = 0; i < pessoas.size(); i++) {
            if(pessoas.get(i).getNome().equalsIgnoreCase(nomePesquisar)); {
                aux = i;
            }

        }
        if(aux >= 0) {
            System.out.println("Nome da pessoa é: " + pessoas.get(aux).getNome());
            System.out.println("Idade da pessoa é: " + pessoas.get(aux).getIdade());
            for (int j = 0; j < pessoas.get(aux).getEnderecos().size(); j++) {
                System.out.println("A rua do endereco: " +(j+1)+ "é: " + pessoas.get(aux).getEnderecos().get(j).getRua());
                System.out.println("O numero do endereco: " + (j+1) + "é: " + pessoas.get(aux).getEnderecos().get(j).getNumero());
            }
        } else {
            System.out.println("Ningum nome encontrado");
        }
    }
    public static int menuInicial(){
        System.out.println("1- Inserir pessoa");
        System.out.println("2- Listar pessoas");
        System.out.println("3- Buscar pelo nome");
        System.out.println("4- Sair");
        System.out.println();
        System.out.println("Digite a opcao desejada");


        return sc.nextInt();

    }

}
