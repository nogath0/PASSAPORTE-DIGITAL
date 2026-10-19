package weg.projeto.PASSAPORTE_DIGITAL.dto.Response;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

@Schema(description = "Dados de uma solicitação de manutenção retornados pela API.")
public record SolicitacaoResponse(

        @Schema(
                description = "Identificador da solicitação.",
                example = "1"
        )
        Long id,

        @Schema(
                description = "Número único de identificação da solicitação."
        )
        String numero,

        @Schema(
                description = "ID do usuário que abriu a solicitação.",
                example = "1"
        )
        Long solicitanteId,

        @Schema(
                description = "ID da máquina relacionada à solicitação.",
                example = "1"
        )
        Long maquinaId,

        @Schema(
                description = "ID do usuário responsável pela solicitação. Pode ser nulo enquanto não houver responsável."
        )
        Long responsavelId,

        @Schema(
                description = "Tipo do problema registrado."
        )
        String tipo,

        @Schema(
                description = "Descrição do problema."
        )
        String descricao,

        @Schema(
                description = "Prioridade da solicitação."
        )
        String prioridade,

        @Schema(
                description = "Status atual da solicitação.",
                example = "EM_ANALISE"
        )
        String status,

        @Schema(
                description = "Data e hora em que a solicitação foi criada.",
                example = "2026-10-14T14:30:00"
        )
        LocalDateTime criadoEm
) {
}