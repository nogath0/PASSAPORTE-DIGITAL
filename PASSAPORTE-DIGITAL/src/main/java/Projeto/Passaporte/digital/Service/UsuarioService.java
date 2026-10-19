package Projeto.Passaporte.digital.Service;


import Projeto.Passaporte.digital.Entity.Perfil;
import Projeto.Passaporte.digital.Entity.Usuario;
import Projeto.Passaporte.digital.Execption.EmailJaCadastradoException;
import Projeto.Passaporte.digital.Mapper.UsuarioMapper;
import Projeto.Passaporte.digital.Repository.PerfilRepository;
import Projeto.Passaporte.digital.Repository.UsuarioRepository;
import Projeto.Passaporte.digital.dto.Request.UsuarioRequest;
import Projeto.Passaporte.digital.dto.Response.UsuarioResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final PerfilRepository perfilRepository;
    private final UsuarioMapper usuarioMapper;

    /**
     * Cadastra um novo usuário no sistema.
     * Verifica se o e-mail já está cadastrado e busca o perfil informado
     * antes de salvar o usuário.
     *
     * @param request dados recebidos para cadastrar o usuário
     * @return dados do usuário cadastrado
     * @throws EmailJaCadastradoException se o e-mail já estiver cadastrado
     */
    public UsuarioResponse save(UsuarioRequest request) {

        if (usuarioRepository.existsByEmail(request.email())) {
            throw new EmailJaCadastradoException();
        }

        Perfil perfil = perfilRepository.findById(request.perfil())
                .orElseThrow();

        Usuario usuario = usuarioMapper.toEntity(request, perfil);

        Usuario usuarioSalvo = usuarioRepository.save(usuario);

        return usuarioMapper.toResponse(usuarioSalvo);
    }

    /**
     * Consulta todos os usuários cadastrados no sistema.
     *
     * @return lista com os dados dos usuários cadastrados
     */
    public List<UsuarioResponse> findAll() {

        return usuarioRepository.findAll().stream()
                .map(usuarioMapper::toResponse)
                .toList();
    }

    /**
     * Consulta um usuário pelo seu identificador.
     *
     * @param id identificador do usuário
     * @return dados do usuário encontrado
     */
    public UsuarioResponse findById(Long id) {

        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow();

        return usuarioMapper.toResponse(usuario);
    }

    /**
     * Atualiza os dados de um usuário existente.
     * Verifica se o usuário existe, se o e-mail não pertence a outro usuário
     * e se o perfil informado está cadastrado.
     *
     * @param request novos dados do usuário
     * @param id identificador do usuário que será atualizado
     * @return dados do usuário atualizado
     * @throws EmailJaCadastradoException se o e-mail pertencer a outro usuário
     */
    public UsuarioResponse update(UsuarioRequest request, Long id) {

        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow();

        if (usuarioRepository.existsByEmailAndIdNot(request.email(), id)) {
            throw new EmailJaCadastradoException();
        }

        Perfil perfil = perfilRepository.findById(request.perfil())
                .orElseThrow();

        usuarioMapper.updateEntity(request, usuario, perfil);

        Usuario usuarioSalvo = usuarioRepository.save(usuario);

        return usuarioMapper.toResponse(usuarioSalvo);
    }

}
