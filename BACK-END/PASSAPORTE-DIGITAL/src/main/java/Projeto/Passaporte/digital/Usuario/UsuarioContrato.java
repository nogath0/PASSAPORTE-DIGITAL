package Projeto.Passaporte.digital.Usuario;

import java.util.List;

public interface UsuarioContrato {

    UsuarioResponse findById(Long id);

    List<UsuarioResponse> findAll();
}
