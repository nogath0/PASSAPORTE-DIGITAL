package Projeto.Passaporte.digital.dto.Request;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Dados recebidos para cadastrar ou atualizar um usuário.")
public record UsuarioRequest(

        @Schema(description = "Nome do usuário.", example = "Ana Silva")
        String nome,

        @Schema(description = "E-mail do usuário.", example = "ana@exemplo.com")
        String email,

        @Schema(description = "Senha recebida na requisição.")
        String senha,

        @Schema(description = "ID do perfil do usuário.", example = "1")
        Long perfil
) {}