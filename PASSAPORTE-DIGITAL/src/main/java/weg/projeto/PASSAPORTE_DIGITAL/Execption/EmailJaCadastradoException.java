package weg.projeto.PASSAPORTE_DIGITAL.Execption;

public class EmailJaCadastradoException extends RuntimeException {

    public EmailJaCadastradoException() {
        super("Este e-mail já está cadastrado");
    }

}
