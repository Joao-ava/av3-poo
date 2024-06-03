import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

    public class CadastroAmigos extends JFrame {

        public CadastroAmigos(ListagemAmigos listagemAmigos) {
            setTitle("Cadastro de Amigos");
            setSize(400, 700);
            setLocationRelativeTo(null);

            JPanel panel = new JPanel(new GridLayout(0, 1));

            JTextField nomeField = new JTextField(20);
            JTextField generoField = new JTextField(20);
            JTextField idadeField = new JTextField(20);
            JTextField emailField = new JTextField(20);
            JTextField escolaridadeField = new JTextField(20);
            JTextField enderecoField = new JTextField(20);
            JTextField numeroField = new JTextField(20);
            JTextField complementoField = new JTextField(20);
            JTextField bairroField = new JTextField(20);
            JTextField cidadeField = new JTextField(20);
            JTextField estadoField = new JTextField(20);
            JTextField cepField = new JTextField(20);

            panel.add(new JLabel("Nome Completo:"));
            panel.add(nomeField);
            panel.add(new JLabel("Gênero:"));
            panel.add(generoField);
            panel.add(new JLabel("Idade:"));
            panel.add(idadeField);
            panel.add(new JLabel("E-mail:"));
            panel.add(emailField);
            panel.add(new JLabel("Escolaridade:"));
            panel.add(escolaridadeField);
            panel.add(new JLabel("Endereço:"));
            panel.add(enderecoField);
            panel.add(new JLabel("Número:"));
            panel.add(numeroField);
            panel.add(new JLabel("Complemento:"));
            panel.add(complementoField);
            panel.add(new JLabel("Bairro:"));
            panel.add(bairroField);
            panel.add(new JLabel("Cidade:"));
            panel.add(cidadeField);
            panel.add(new JLabel("Estado:"));
            panel.add(estadoField);
            panel.add(new JLabel("CEP:"));
            panel.add(cepField);

            JButton btnAdicionar = new JButton("Adicionar");
            btnAdicionar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        String nomeCompleto = nomeField.getText();
                        String genero = generoField.getText();
                        int idade = Integer.parseInt(idadeField.getText());
                        String email = emailField.getText();
                        String escolaridade = escolaridadeField.getText();
                        String endereco = enderecoField.getText();
                        int numero = Integer.parseInt(numeroField.getText());
                        String complemento = complementoField.getText();
                        String bairro = bairroField.getText();
                        String cidade = cidadeField.getText();
                        String estado = estadoField.getText();
                        String cep = cepField.getText();

                        Amigo novoAmigo = new Amigo(nomeCompleto, genero, idade, email, escolaridade, endereco, numero, complemento, bairro, cidade, estado, cep);
                        listagemAmigos.adicionarAmigo(novoAmigo);

                        JOptionPane.showMessageDialog(null, "Amigo adicionado com sucesso!");

                        // Limpar os campos após a adição
                        nomeField.setText("");
                        generoField.setText("");
                        idadeField.setText("");
                        emailField.setText("");
                        escolaridadeField.setText("");
                        enderecoField.setText("");
                        numeroField.setText("");
                        complementoField.setText("");
                        bairroField.setText("");
                        cidadeField.setText("");
                        estadoField.setText("");
                        cepField.setText("");

                        setVisible(false);
                    } catch (AmigoExisteException amigoExisteException) {
                        JOptionPane.showMessageDialog(null, amigoExisteException.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                    } catch (NumberFormatException numberFormatException) {
                        JOptionPane.showMessageDialog(null, "Idade e número devem ser valores numéricos.", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });

            panel.add(btnAdicionar);
            add(panel);
        }
    }


