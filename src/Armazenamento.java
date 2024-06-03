import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Armazenamento {
    private String nomeArquivo = "amigos.txt";

    public Amigos carregar() {
        Amigos amigos = new Amigos();

        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(";");
                if (partes.length < 1) continue;
                try {
                    String nomeCompleto = partes[0].trim();
                    String genero = partes[1].trim();
                    int idade = Integer.parseInt(partes[2].trim());
                    String email = partes[3].trim();
                    String escolaridade = partes[4].trim();
                    String endereco = partes[5].trim();
                    int numero = Integer.parseInt(partes[6].trim());
                    String complemento = partes[7].trim();
                    String bairro = partes[8].trim();
                    String cidade = partes[9].trim();
                    String estado = partes[10].trim();
                    String cep = partes[11].trim();
                    Amigo novoAmigo = new Amigo(nomeCompleto, genero, idade, email, escolaridade, endereco, numero, complemento, bairro, cidade, estado, cep);
                    amigos.adicionar(novoAmigo);
                } catch (AmigoExisteException exception) {}
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }

        return amigos;
    }

    public void salvar(Amigos amigos) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            ArrayList<String> content = new ArrayList<String>();
            for (Amigo amigo: amigos.getListaDeAmigos()) {
                ArrayList<String> line = new ArrayList<String>();
                line.add(amigo.getNomeCompleto());
                line.add(amigo.getGenero());
                line.add(String.valueOf(amigo.getIdade()));
                line.add(amigo.getEmail());
                line.add(amigo.getEscolaridade());
                line.add(amigo.getEndereco());
                line.add(String.valueOf(amigo.getNumero()));
                line.add(amigo.getComplemento());
                line.add(amigo.getBairro());
                line.add(amigo.getCidade());
                line.add(amigo.getEstado());
                line.add(amigo.getCep());
                content.add(String.join(";", line));
            }
            writer.write(String.join("\n", content));
        } catch (IOException e) {}
    }
}
