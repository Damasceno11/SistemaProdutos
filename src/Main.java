import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<String> nomes = new ArrayList<>();
        ArrayList<Double> valores = new ArrayList<>();

        // Produtos!!!

        nomes.add("Pilsen 330ml"); valores.add(4.99);
        nomes.add("Pilsen 600ml"); valores.add(6.99);
        nomes.add("Pilsen Pet 1,5l"); valores.add(14.99);
        nomes.add("Pilsen chopp 1l"); valores.add(12.50);
        nomes.add("Weiss 330ml"); valores.add(5.99);
        nomes.add("Weiss 600ml"); valores.add(6.99);
        nomes.add("Weiss Pet 1,5l"); valores.add(16.99);
        nomes.add("Weiss chopp 1l"); valores.add(14.50);
        nomes.add("Bock 330ml"); valores.add(6.99);
        nomes.add("Bock 600ml"); valores.add(7.99);
        nomes.add("Bock Pet 1,5l"); valores.add(18.99);
        nomes.add("Bock chopp 1l"); valores.add(16.50);
        nomes.add("IPA 330ml"); valores.add(7.99);
        nomes.add("IPA 600ml"); valores.add(8.99);
        nomes.add("IPÁ Pet 1,5l"); valores.add(20.50);
        nomes.add("IPA chopp 1l"); valores.add(18.50);

        byte menu;

        do{
            System.out.println("\nMenu de Produtos\n" +
                    "1 - Cadastrar um produto\n" +
                    "2 - Listar todos os produtos\n" +
                    "3 - Mostrar o produto mais caro\n" +
                    "4 - Calcular a média de preços\n" +
                    "5 - Listar produtos acima da média" +
                    "0 - Sair\n" +
                    "Escolha uma opção: ");
            menu = sc.nextByte();
            sc.nextLine();

            switch (menu) {
                case 1:
                    System.out.println("Digite o nome do produto: ");
                    String nome = sc.nextLine();

                    if (nomes.contains(nome)){
                        System.out.println("Produto já cadastrado não pode repetir.");
                        break;
                    }

                    System.out.println("Digite um preço: ");
                    double valor = sc.nextDouble();

                    nomes.add(nome);
                    valores.add(valor);
                    System.out.println("Produto cadastrado com sucesso!");
                    break;

                case 2:
                    System.out.println("\nLista de Produtos:");
                    for (int i = 0; i < nomes.size(); i++){
                        System.out.println(nomes.get(i)+ "- R$ " + valores.get(i));
                    }
                    break;

                case 3:
                    if (valores.size() == 0) {
                        System.out.println("Nenhum produto cadastrado.");
                        break;
                    }

                    double maisCaro = valores.get(0);
                    int indiceCaro = 0;
                }
            }
        }



    }
}