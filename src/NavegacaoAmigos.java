public class NavegacaoAmigos {
    private Amigos amigos;
    private int posicaoAtual;

    public NavegacaoAmigos(Amigos amigos) {
        this.amigos = amigos;
        this.posicaoAtual = 0;
    }

    public Amigo primeiro() {
        try {
            posicaoAtual = 0;
            return amigos.getListaDeAmigos().get(posicaoAtual);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Erro: " + e.getMessage());
            return null;
        }
    }

    public Amigo anterior() {
        try {
            if (posicaoAtual > 0) {
                posicaoAtual--;
            }
            return amigos.getListaDeAmigos().get(posicaoAtual);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Erro: " + e.getMessage());
            return null;
        }
    }

    public Amigo proximo() {
        try {
            if (posicaoAtual < amigos.getTotalAmigos()) {
                posicaoAtual++;
            }
            return amigos.getListaDeAmigos().get(posicaoAtual);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Erro: " + e.getMessage());
            return null;
        }
    }

    public Amigo ultimo() {
        try {
            posicaoAtual = amigos.getTotalAmigos();
            return amigos.getListaDeAmigos().get(posicaoAtual);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Erro: " + e.getMessage());
            return null;
        }
    }
}