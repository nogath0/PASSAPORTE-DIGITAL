package weg.projeto.PASSAPORTE_DIGITAL.Controller;


import Projeto.Passaporte.digital.Service.PerfilService;
import Projeto.Passaporte.digital.dto.Request.PerfilRequest;
import Projeto.Passaporte.digital.dto.Response.PerfilResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/perfis")
@RequiredArgsConstructor
@Tag(
        name = "Perfis",
        description = "Endpoints para cadastro e consulta de perfis."
)


public class PerfilController {

    private final PerfilService perfilService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(
            summary = "Cadastrar perfil",
            description = "Cadastra um novo perfil no sistema."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "Perfil cadastrado com sucesso.",
                    content = @Content(
                            schema = @Schema(
                                    implementation = PerfilResponse.class
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "409",
                    description = "O perfil já está cadastrado."
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Dados da requisição inválidos."
            )
    })
    public PerfilResponse save(
            @Valid @RequestBody PerfilRequest request) {

        return perfilService.save(request);
    }

    @GetMapping
    @Operation(
            summary = "Listar perfis",
            description = "Retorna todos os perfis cadastrados no sistema."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Lista de perfis retornada com sucesso.",
            content = @Content(
                    array = @ArraySchema(
                            schema = @Schema(
                                    implementation = PerfilResponse.class
                            )
                    )
            )
    )
    public List<PerfilResponse> findAll() {
        return perfilService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Consultar perfil por ID",
            description = "Busca um perfil específico pelo seu identificador."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Perfil encontrado.",
                    content = @Content(
                            schema = @Schema(
                                    implementation = PerfilResponse.class
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Perfil não encontrado."
            )
    })
    public PerfilResponse findById(
            @Parameter(
                    description = "Identificador do perfil.",
                    example = "1",
                    required = true
            )
            @PathVariable Long id) {

        return perfilService.findById(id);
    }
}
