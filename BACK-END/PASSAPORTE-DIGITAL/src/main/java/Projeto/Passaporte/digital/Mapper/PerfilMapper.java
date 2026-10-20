package Projeto.Passaporte.digital.Mapper;

import Projeto.Passaporte.digital.Entity.Perfil;
import Projeto.Passaporte.digital.dto.Request.PerfilRequest;
import Projeto.Passaporte.digital.dto.Response.PerfilResponse;
import org.springframework.stereotype.Component;


@Component
public class PerfilMapper {

    public Perfil toEntity(PerfilRequest request) {

        return Perfil.builder()
                .nome(request.nome())
                .build();
    }

    public PerfilResponse toResponse(Perfil perfil) {

        return new PerfilResponse(
                perfil.getId(),
                perfil.getNome()
        );
    }
}
