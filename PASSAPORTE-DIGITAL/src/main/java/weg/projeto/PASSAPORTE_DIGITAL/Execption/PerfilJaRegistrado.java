package weg.projeto.PASSAPORTE_DIGITAL.Execption;

public class PerfilJaRegistrado extends RuntimeException {

    public PerfilJaRegistrado() {
        super("Perfis ja cadastrados");
    }
}
