package weg.projeto.PASSAPORTE_DIGITAL.Service;

import Projeto.Passaporte.digital.Entity.Perfil;
import Projeto.Passaporte.digital.Execption.PerfilJaRegistrado;
import Projeto.Passaporte.digital.Mapper.PerfilMapper;
import Projeto.Passaporte.digital.Repository.PerfilRepository;
import Projeto.Passaporte.digital.dto.Request.PerfilRequest;
import Projeto.Passaporte.digital.dto.Response.PerfilResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PerfilService {

    private final PerfilRepository perfilRepository;
    private final PerfilMapper perfilMapper;

    public PerfilResponse save(PerfilRequest request) {

        if (perfilRepository.existsByNomeIgnoreCase(request.nome().trim())) {
            throw new PerfilJaRegistrado();
        }

        Perfil perfil = perfilMapper.toEntity(request);

        Perfil perfilSalvo = perfilRepository.save(perfil);

        return perfilMapper.toResponse(perfilSalvo);
    }

    public PerfilResponse findById(Long id) {

        Perfil perfil = perfilRepository.findById(id)
                .orElseThrow();

        return perfilMapper.toResponse(perfil);
    }

    public List<PerfilResponse> findAll() {

        return perfilRepository.findAll().stream()
                .map(perfilMapper :: toResponse)
                .toList();
    }

}
