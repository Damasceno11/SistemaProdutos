import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<String> nomes = new ArrayList<>();
    static ArrayList<Double> valores = new ArrayList<>();
    static ArrayList<Double> litros = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int menu = -1;

        System.out.println("\n---Menu de Produtos de Bebidas---");

        while (menu != 0) {
            menu();

            if (sc.hasNextInt()) {
                menu = sc.nextInt();
                sc.nextLine();
            } else {
                System.out.println("Entrada inválida. Digite um número.");
                sc.nextLine();
                continue;
            }

            switch (menu) {
                case 1:
                    cadastrar(sc);
                    break;

                case 2:
                    listarBebidas();
                    break;

                case 3:
                    bebidaMaisCara();
                    break;

                case 4:
                    media();
                    break;

                case 5:
                    acimaMedia();
                    break;

                case 0:
                    System.out.println("Saindo do programa...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        }

        sc.close();
    }
    public static void menu() {
        System.out.println("1 - Cadastrar uma bebida");
        System.out.println("2 - Listar todas as bebidas");
        System.out.println("3 - Mostrar a bebida mais cara");
        System.out.println("4 - Calcular a média de preços");
        System.out.println("5 - Listar bebidas acima da média");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    public static void cadastrar(Scanner sc) {
        System.out.print("Digite o nome da bebida: ");
        String nome = sc.nextLine();

        System.out.print("Digite a litragem da bebida (ex: 500 para 500ml, 1.5 para 1,5L): ");
        double litro = sc.nextDouble();
        sc.nextLine();

        boolean jaExiste = false;
        for (int i = 0; i < nomes.size(); i++) {
            if (nomes.get(i).equalsIgnoreCase(nome) && litros.get(i).equals(litro)) {
                jaExiste = true;
                break;
            }
        }

        if (jaExiste) {
            System.out.println("Essa bebida com essa litragem já está cadastrada.");
            return;
        }

        System.out.print("Digite o preço da bebida: R$");
        if (sc.hasNextDouble()) {
            double preco = sc.nextDouble();
            sc.nextLine();

            nomes.add(nome);
            litros.add(litro);
            valores.add(preco);
            System.out.println("Bebida cadastrada com sucesso!");
            System.out.println();
        } else {
            System.out.println("Preço inválido.");
            sc.nextLine();
        }
    }

    public static void listarBebidas() {
        if (nomes.isEmpty()) {
            System.out.println("Nenhuma bebida cadastrada.");
        } else {
            System.out.println("\nLista de Bebidas:");
            for (int i = 0; i < nomes.size(); i++) {
                System.out.println(nomes.get(i) + " - " + litros.get(i) + "L - R$ " + valores.get(i));
            }
            System.out.println();
        }
    }

    public static void bebidaMaisCara() {
        if (valores.isEmpty()) {
            System.out.println("Nenhuma bebida cadastrada.");
        } else {
            double max = valores.get(0);
            int indiceMax = 0;
            for (int i = 1; i < valores.size(); i++) {
                if (valores.get(i) > max) {
                    max = valores.get(i);
                    indiceMax = i;
                }
            }
            System.out.println("Bebida mais cara:");
            System.out.println(nomes.get(indiceMax) + " - R$ " + max);
        }
        System.out.println();
    }

    public static void media() {
        if (valores.isEmpty()) {
            System.out.println("Nenhuma bebida cadastrada.");
        } else {
            double soma = 0;
            for (double v : valores) {
                soma += v;
            }
            double media = soma / valores.size();
            System.out.printf("\nMédia de preços: R$%.2f", media);
            System.out.println();
        }
    }

    public static void acimaMedia() {
        if (valores.isEmpty()) {
            System.out.println("Nenhuma bebida cadastrada.");
        } else {
            double soma = 0;
            for (double v : valores) {
                soma += v;
            }
            double media = soma / valores.size();
            System.out.println("Bebidas acima da média:");
            for (int i = 0; i < valores.size(); i++) {
                if (valores.get(i) > media) {
                    System.out.println(nomes.get(i) + " - R$ " + valores.get(i));
                }
            }
        }
        System.out.println();
    }
}
