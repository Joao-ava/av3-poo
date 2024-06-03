import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListagemAmigos extends JFrame {

    private Amigos amigos;
    private JPanel listaPanel;
    private Armazenamento armazenamento;

    public ListagemAmigos() {
        setTitle("Listagem de Amigos");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        armazenamento = new Armazenamento();
        amigos = armazenamento.carregar();

        listaPanel = new JPanel();
        listaPanel.setLayout(new BoxLayout(listaPanel, BoxLayout.Y_AXIS));

        JScrollPane scrollPane = new JScrollPane(listaPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        CadastroAmigos cadastro = new CadastroAmigos(this);

        JButton btnAdicionarAmigo = new JButton("Adicionar Amigo");
        btnAdicionarAmigo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastro.setVisible(true);
            }
        });

        add(scrollPane, BorderLayout.CENTER);
        add(btnAdicionarAmigo, BorderLayout.SOUTH);
        atualizarLista();

        setVisible(true);
    }

    public void adicionarAmigo(Amigo amigo) throws AmigoExisteException {
        amigos.adicionar(amigo);
        armazenamento.salvar(amigos);
        atualizarLista();
    }

    private void atualizarLista() {
        listaPanel.removeAll();
        for (Amigo amigo : amigos.getListaDeAmigos()) {
            JPanel amigoPanel = new JPanel();
            amigoPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

            JLabel nomeLabel = new JLabel("Nome: " + amigo.getNomeCompleto());
            JLabel emailLabel = new JLabel("E-mail: " + amigo.getEmail());
            JButton excluirButton = new JButton("Excluir");

            excluirButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    amigos.excluir(amigo);
                    armazenamento.salvar(amigos);
                    atualizarLista();
                }
            });

            amigoPanel.add(nomeLabel);
            amigoPanel.add(emailLabel);
            amigoPanel.add(excluirButton);
            listaPanel.add(amigoPanel);
        }
        listaPanel.revalidate();
        listaPanel.repaint();
    }

    // private void adicionarAmigo() {
    //     JTextField nomeField = new JTextField(10);
    //     JTextField emailField = new JTextField(10);
    //     JPanel panel = new JPanel(new GridLayout(0, 1));
    //     panel.add(new JLabel("Nome:"));
    //     panel.add(nomeField);
    //     panel.add(new JLabel("E-mail:"));
    //     panel.add(emailField);

    //     int result = JOptionPane.showConfirmDialog(null, panel, "Adicionar Amigo",
    //             JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
    //     if (result == JOptionPane.OK_OPTION) {
    //         String nome = nomeField.getText();
    //         String email = emailField.getText();
    //         if (!nome.isEmpty() && !email.isEmpty()) {
    //             // amigos.add(new Amigo(nome, email));
    //             atualizarLista();
    //         } else {
    //             JOptionPane.showMessageDialog(this, "Nome e e-mail não podem estar vazios.", "Erro",
    //                     JOptionPane.ERROR_MESSAGE);
    //         }
    //     }
    // }
}
