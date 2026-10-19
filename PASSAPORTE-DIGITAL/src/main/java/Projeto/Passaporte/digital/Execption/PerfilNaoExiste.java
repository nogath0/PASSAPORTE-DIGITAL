package Projeto.Passaporte.digital.Execption;

public class PerfilNaoExiste extends RuntimeException {

    public PerfilNaoExiste() {
        super("Este Perfil não existe");
    }
}
