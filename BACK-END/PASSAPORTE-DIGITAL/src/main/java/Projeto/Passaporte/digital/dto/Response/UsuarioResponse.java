package Projeto.Passaporte.digital.dto.Response;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Dados do usuário retornados pela API.")
public record UsuarioResponse(

        @Schema(description = "ID do usuário.", example = "1")
        Long id,

        @Schema(description = "Nome do usuário.", example = "Ana Silva")
        String nome,

        @Schema(description = "E-mail do usuário.", example = "ana@exemplo.com")
        String email,

        @Schema(description = "Nome do perfil.", example = "ALUNO")
        String perfil
) {
}