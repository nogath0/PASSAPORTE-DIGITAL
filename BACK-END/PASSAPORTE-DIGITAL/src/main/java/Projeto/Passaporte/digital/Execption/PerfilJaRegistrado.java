package Projeto.Passaporte.digital.Execption;

public class PerfilJaRegistrado extends RuntimeException {

    public PerfilJaRegistrado() {
        super("Perfis ja cadastrados");
    }
}
