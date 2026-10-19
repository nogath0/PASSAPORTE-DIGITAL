package weg.projeto.PASSAPORTE_DIGITAL.Mapper;

import Projeto.Passaporte.digital.Entity.Perfil;
import Projeto.Passaporte.digital.Entity.Usuario;
import Projeto.Passaporte.digital.dto.Request.UsuarioRequest;
import Projeto.Passaporte.digital.dto.Response.UsuarioResponse;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    public Usuario toEntity(UsuarioRequest request , Perfil perfil) {

        return Usuario.builder()
                .nome(request.nome())
                .email(request.email())
                .senhaHash(request.senha())
                .perfil(perfil)
                .build();
    }

    public UsuarioResponse toResponse(Usuario usuario) {

        return new UsuarioResponse(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getPerfil().getNome()
        );
    }

    public void updateEntity(UsuarioRequest request , Usuario usuario , Perfil perfil) {

        usuario.setNome(request.nome());
        usuario.setEmail(request.email());
        usuario.setSenhaHash(request.senha());
        usuario.setPerfil(perfil);

    }
}
