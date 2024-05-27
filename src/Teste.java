import java.util.Scanner;

public class Teste {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe a quantidade de amigos que você deseja adicionar: ");
        Amigos amigos = new Amigos();

        int quantidade = scanner.nextInt();
        int i = 0;
        while (i < quantidade) {
            System.out.println("Amigo " + (i + 1));
            System.out.println("Nome: ");
            String nomeCompleto = scanner.next();
            System.out.println("Genero: ");
            String genero = scanner.next();
            System.out.println("Idade: ");
            scanner.nextLine();
            int idade = scanner.nextInt();
            System.out.println("email: ");
            String email = scanner.next();
            System.out.println("Escolaridade: ");
            String escolaridade = scanner.next();
            System.out.println("Endereço: ");
            String endereco = scanner.nextLine();
            System.out.println("Número: ");
            // scanner.nextLine();
            int numero = scanner.nextInt();
            System.out.println("Complemento: ");
            String complemento = scanner.next();
            System.out.println("Bairro: ");
            String bairro = scanner.next();
            System.out.println("Cidade: ");
            String cidade = scanner.next();
            System.out.println("Estado: ");
            String estado = scanner.next();
            System.out.println("CEP: ");
            String cep = scanner.next();
            try {
                amigos.adicionar(new Amigo(nomeCompleto, genero, idade, email, escolaridade, endereco, numero, complemento, bairro, cidade, estado, cep));
                i++;
            } catch (AmigoExisteException exception) {
                System.out.println(exception.getMessage());
            }
        }
        System.out.println("Primeiro amigo: " + amigos.primeiro().getNomeCompleto());
        System.out.println("Ultimo amigo: " + amigos.ultimo().getNomeCompleto());
        System.out.println("Lista de amigos");
        for (i = 0; i < quantidade; i++) {
            System.out.println("Amigo " + (i + 1) + ": " + amigos.proximo().getNomeCompleto());
        }
        scanner.close();
    }
}
