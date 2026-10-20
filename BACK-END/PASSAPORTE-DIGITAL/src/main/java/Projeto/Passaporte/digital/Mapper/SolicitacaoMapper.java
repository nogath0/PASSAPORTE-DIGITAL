package Projeto.Passaporte.digital.Mapper;

import Projeto.Passaporte.digital.Entity.Maquina;
import Projeto.Passaporte.digital.Entity.Solicitacao;
import Projeto.Passaporte.digital.Entity.Usuario;
import Projeto.Passaporte.digital.dto.Request.SolicitacaoRequest;
import Projeto.Passaporte.digital.dto.Response.SolicitacaoResponse;
import org.springframework.stereotype.Component;

@Component
public class SolicitacaoMapper {

    public Solicitacao toEntity(SolicitacaoRequest request, Usuario solicitante, Maquina maquina) {

        return Solicitacao.builder()
                .solicitante(solicitante)
                .maquina(maquina)
                .tipo(request.tipo())
                .descricao(request.descricao())
                .prioridade(request.prioridade())
                .build();
    }

    public SolicitacaoResponse toResponse(Solicitacao solicitacao) {

        return new SolicitacaoResponse(
                solicitacao.getId(),
                solicitacao.getNumero(),
                solicitacao.getSolicitante().getId(),
                solicitacao.getMaquina().getId(),
                solicitacao.getResponsavel() != null
                        ? solicitacao.getResponsavel().getId()
                        : null,
                solicitacao.getTipo(),
                solicitacao.getDescricao(),
                solicitacao.getPrioridade(),
                solicitacao.getStatus(),
                solicitacao.getCriadoEm()
        );
    }
}