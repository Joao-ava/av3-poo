public class AmigoExisteException extends Exception {
    AmigoExisteException(Amigo amigo) {
        super("O e-mail " + amigo.getEmail() + " já está em uso.");
    }
}
