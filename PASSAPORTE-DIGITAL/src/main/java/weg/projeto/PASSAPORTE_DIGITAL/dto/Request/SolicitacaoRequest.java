package weg.projeto.PASSAPORTE_DIGITAL.dto.Request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Schema(description = "Dados necessários para registrar uma solicitação de manutenção.")
public record SolicitacaoRequest(

        @NotNull
        @Positive
        @Schema(
                description = "ID da máquina relacionada ao problema.",
                example = "1",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        Long maquinaId,

        @NotBlank
        @Size(max = 30)
        @Schema(
                description = "Tipo do problema ou da solicitação.",
                example = "Problema de funcionamento",
                maxLength = 30,
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        String tipo,

        @NotBlank
        @Size(max = 200)
        @Schema(
                description = "Descrição do problema identificado na máquina.",
                example = "A máquina apresentou um alarme durante a atividade.",
                maxLength = 200,
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        String descricao,

        @NotBlank
        @Size(max = 20)
        @Schema(
                description = "Prioridade atribuída à solicitação.",
                maxLength = 20,
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        String prioridade
) {
}