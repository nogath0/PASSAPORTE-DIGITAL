package Projeto.Passaporte.digital.Execption;

public class EmailJaCadastradoException extends RuntimeException {

    public EmailJaCadastradoException() {
        super("Este e-mail já está cadastrado");
    }

}
