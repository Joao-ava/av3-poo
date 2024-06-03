import java.util.ArrayList;

public class Amigos {
    private int atual = -1;
    private ArrayList<Amigo> listaDeAmigos;

    public Amigos() {
        this.listaDeAmigos = new ArrayList<>();
    }

    public void adicionar(Amigo amigo) throws AmigoExisteException {
        if (existeEmail(amigo.getEmail())) {
            throw new AmigoExisteException(amigo);
        }
        listaDeAmigos.add(amigo);
    }

    public void excluir(Amigo amigo) {
        listaDeAmigos.remove(amigo);
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
        return listaDeAmigos.size();
    }

    public Amigo primeiro() throws IndexOutOfBoundsException {
        return listaDeAmigos.get(0);
    }

    public Amigo anterior() throws IndexOutOfBoundsException {
        if (atual < 0) {
            throw new IndexOutOfBoundsException();
        }
        atual--;
        return listaDeAmigos.get(atual);
    }

    public Amigo proximo() throws IndexOutOfBoundsException {
        if (atual > listaDeAmigos.size()) {
            throw new IndexOutOfBoundsException();
        }
        atual++;
        return listaDeAmigos.get(atual);
    }

    public Amigo ultimo() {
        return listaDeAmigos.get(listaDeAmigos.size() - 1);
    }
}
