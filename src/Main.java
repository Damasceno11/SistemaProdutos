import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static ArrayList<String> nomes = new ArrayList<>();
    static ArrayList<Double> valores = new ArrayList<>();
    static ArrayList<Double> litros = new ArrayList<>();
    static HashMap<Double,String> medidaDaLitragem = new HashMap<>();

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
                case 6:
                    removerNome(sc);
                    break;
                case 7:
                    atualizaPreco(sc);
                    break;
                case 8:
                    somaTotal();
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
        System.out.println("6 - Remover por nome");
        System.out.println("7 - Atualizar preço");
        System.out.println("8 - Soma total das bebidas");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    public static void cadastrar(Scanner sc) {
        System.out.print("Digite o nome da bebida: ");
        String nome = sc.nextLine();

        double litro = 0;
        String medida = "";
        boolean litragemValida = false;
        while (!litragemValida) {
            try {
                System.out.print("Digite a litragem da bebida (ex: 500 para 500ml, 1.5 para 1,5L): ");
                litro = sc.nextDouble();
                sc.nextLine();

                System.out.println("Digite a medida da litragem (ex: ML, L): ");
                medida = sc.nextLine();
                litragemValida = true;
            } catch (InputMismatchException e) {
                System.out.println("Erro: Por favor, digite somente números para a litragem.");
                sc.nextLine();
            }
        }

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

        double preco = 0;
        boolean precoValido = false;
        while (!precoValido) {
            System.out.print("Digite o preço da bebida: R$");
            try {
                preco = sc.nextDouble();
                sc.nextLine();
                if (preco > 0) {
                    precoValido = true;
                } else {
                    System.out.println("Erro: O preço deve ser maior que zero. Digite um valor válido.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro: Por favor, digite somente números para o preço.");
                sc.nextLine();
            }
        }

        nomes.add(nome);
        litros.add(litro);
        medidaDaLitragem.put(litro,medida);
        valores.add(preco);
        System.out.println("Bebida cadastrada com sucesso!");
        System.out.println();
    }

    public static void listarBebidas() {
        if (nomes.isEmpty()) {
            System.out.println("Nenhuma bebida cadastrada.");
        } else {
            System.out.println("\nLista de Bebidas:");
            for (int i = 0; i < nomes.size(); i++) {
                System.out.println(nomes.get(i) + " - " + litros.get(i) + " "+ medidaDaLitragem.get(litros.get(i)) + " - R$ " + valores.get(i));
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
            System.out.printf("Média de preços: R$%.2f", media);
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
            System.out.println("Média de preços: R$ " + media);
            System.out.println("Bebidas acima da média:");

            boolean encontrou = false;
            for (int i = 0; i < valores.size(); i++) {
                if (valores.get(i) > media) {
                    System.out.println(nomes.get(i) + " - R$ " + valores.get(i));
                    encontrou = true;
                }
            }

            if (!encontrou) {
                System.out.println("Nenhuma bebida acima da média!");
            }
        }
        System.out.println();
    }

    public static void removerNome(Scanner sc) {
        if (nomes.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
            return;
        }

        String nomeRemover;

        while (true) {
            System.out.print("Digite o nome do produto que deseja remover: ");
            nomeRemover = sc.nextLine();

            int i;
            for (i = 0; i < nomes.size(); i++) {
                if (nomes.get(i).equalsIgnoreCase(nomeRemover)) {
                    break;
                }
            }

            if (i < nomes.size()) {
                break;
            } else {
                System.out.println("Bebida não encontrada. Tente novamente.");
            }
        }

        double litroRemover = 0;
        boolean litragemValida = false;
        while (!litragemValida) {
            try {
                System.out.print("Digite a litragem do produto (ex: 500 ou 1.5): ");
                litroRemover = sc.nextDouble();
                sc.nextLine();
                litragemValida = true;
            } catch (InputMismatchException e) {
                System.out.println("Erro: Digite um valor numérico para a litragem.");
                sc.nextLine();
            }
        }

        boolean encontrado = false;

        for (int i = 0; i < nomes.size(); i++) {
            if (nomes.get(i).equalsIgnoreCase(nomeRemover) && litros.get(i).equals(litroRemover)) {
                nomes.remove(i);
                litros.remove(i);
                valores.remove(i);
                medidaDaLitragem.remove(litroRemover);
                encontrado = true;
                System.out.println("Produto removido com sucesso!");
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Produto com essa litragem não encontrado.");
        }
    }

    public static void atualizaPreco(Scanner sc) {
        if (valores.isEmpty()) {
            System.out.println("Nenhuma bebida cadastrada.");
            return;
        }

        String nomeAtualizar;
        while (true) {
            System.out.print("Digite o nome da bebida que deseja atualizar o preço: ");
            nomeAtualizar = sc.nextLine();

            int i;
            for (i = 0; i < nomes.size(); i++) {
                if (nomes.get(i).equalsIgnoreCase(nomeAtualizar)) {
                    break;
                }
            }

            if (i < nomes.size()) {
                break; // Nome encontrado
            } else {
                System.out.println("Bebida não encontrada. Tente novamente.");
            }
        }

        double litragem = 0;
        boolean litragemEncontrada = false;

        // Loop para pedir litragem até achar a correta para o nome informado
        while (!litragemEncontrada) {
            try {
                System.out.print("Digite a litragem da bebida (ex: 500 ou 1.5): ");
                litragem = sc.nextDouble();
                sc.nextLine();

                // Verifica se existe essa litragem para o nome informado
                litragemEncontrada = false;
                for (int i = 0; i < nomes.size(); i++) {
                    if (nomes.get(i).equalsIgnoreCase(nomeAtualizar) && litros.get(i).equals(litragem)) {
                        litragemEncontrada = true;
                        break;
                    }
                }

                if (!litragemEncontrada) {
                    System.out.println("Produto com essa litragem não encontrado. Tente novamente.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Erro: Digite um número válido.");
                sc.nextLine();
            }
        }

        // Aqui já temos nome e litragem válidos, vamos pedir o novo preço

        boolean precoAtualizado = false;
        while (!precoAtualizado) {
            System.out.print("Digite o novo preço: R$");
            try {
                double novoPreco = sc.nextDouble();
                sc.nextLine();

                if (novoPreco > 0) {
                    // Atualiza o preço no índice correto
                    for (int i = 0; i < nomes.size(); i++) {
                        if (nomes.get(i).equalsIgnoreCase(nomeAtualizar) && litros.get(i).equals(litragem)) {
                            valores.set(i, novoPreco);
                            System.out.println("Preço atualizado com sucesso!");
                            precoAtualizado = true;
                            break;
                        }
                    }
                } else {
                    System.out.println("Erro: O preço deve ser maior que zero.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro: Digite um número válido para o preço.");
                sc.nextLine();
            }
        }
    }

    public static void somaTotal() {
        if (valores.isEmpty()) {
            System.out.println("Nenhuma bebida cadastrada.");
        } else {
            double soma = 0;
            for (double valortotal : valores) {
                soma += valortotal;
            }
            System.out.printf("Valor total de todos os produtos: R$%.2f%n", soma);
        }
        System.out.println();
    }
}