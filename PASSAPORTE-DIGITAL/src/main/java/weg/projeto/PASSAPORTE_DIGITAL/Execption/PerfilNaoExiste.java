package weg.projeto.PASSAPORTE_DIGITAL.Execption;

public class PerfilNaoExiste extends RuntimeException {

    public PerfilNaoExiste() {
        super("Este Perfil não existe");
    }
}
