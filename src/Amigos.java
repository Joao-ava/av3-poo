import java.util.ArrayList;

public class Amigos {
    private int totalAmigos = -1;
    private ArrayList<Amigo> listaDeAmigos;

    public Amigos() {
        this.listaDeAmigos = new ArrayList<>();
    }

    public void adicionar(Amigo amigo) {
        totalAmigos++;
        try {
            if (existeEmail(amigo.getEmail())) {
                throw new RuntimeException("O e-mail " + amigo.getEmail() + " já está em uso.");
            }
            listaDeAmigos.add(amigo);
        } catch (RuntimeException e) {
            System.out.println("Erro ao adicionar amigo: " + e.getMessage());
        }
    }

    private boolean existeEmail(String email) {
        for (Amigo amigo : listaDeAmigos) {
            if (amigo.getEmail().equalsIgnoreCase(email)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Amigo> getListaDeAmigos() {
        return listaDeAmigos;
    }

    public int getTotalAmigos() {
        return totalAmigos;
    }
}
