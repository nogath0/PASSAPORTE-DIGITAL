    package weg.projeto.PASSAPORTE_DIGITAL.Controller;


    import Projeto.Passaporte.digital.Service.UsuarioService;
    import Projeto.Passaporte.digital.dto.Request.UsuarioRequest;
    import Projeto.Passaporte.digital.dto.Response.UsuarioResponse;
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


    @RequiredArgsConstructor
    @RestController
    @RequestMapping("/api/usuarios")
    @Tag(
            name = "Usuários",
            description = "Endpoints para cadastro, consulta e atualização de usuários."
    )
    public class UsuarioController {

        private final UsuarioService usuarioService;

        @PostMapping
        @ResponseStatus(HttpStatus.CREATED)
        @Operation(
                summary = "Cadastrar usuário",
                description = "Cadastra um novo usuário no sistema Passaporte Digital das Máquinas."
        )
        @ApiResponses({
                @ApiResponse(
                        responseCode = "201",
                        description = "Usuário cadastrado com sucesso.",
                        content = @Content(
                                schema = @Schema(implementation = UsuarioResponse.class)
                        )
                ),
                @ApiResponse(
                        responseCode = "409",
                        description = "Já existe um usuário cadastrado com esse e-mail."
                ),
                @ApiResponse(
                        responseCode = "400",
                        description = "Dados da requisição inválidos, quando as validações estiverem configuradas."
                )
        })
        public UsuarioResponse save(
                @Valid @RequestBody UsuarioRequest request) {

            return usuarioService.save(request);
        }

        @GetMapping
        @Operation(
                summary = "Listar usuários",
                description = "Retorna a lista de usuários cadastrados no sistema."
        )
        @ApiResponse(
                responseCode = "200",
                description = "Lista de usuários retornada com sucesso.",
                content = @Content(
                        array = @ArraySchema(
                                schema = @Schema(implementation = UsuarioResponse.class)
                        )
                )
        )
        public List<UsuarioResponse> findAll() {
            return usuarioService.findAll();
        }

        @GetMapping("/{id}")
        @Operation(
                summary = "Consultar usuário por ID",
                description = "Busca os dados de um usuário utilizando seu identificador."
        )
        @ApiResponse(
                responseCode = "200",
                description = "Usuário encontrado.",
                content = @Content(
                        schema = @Schema(implementation = UsuarioResponse.class)
                )
        )
        public UsuarioResponse findById(
                @Parameter(
                        description = "Identificador do usuário.",
                        example = "1",
                        required = true
                )
                @PathVariable Long id) {

            return usuarioService.findById(id);
        }

        @PutMapping("/{id}")
        @Operation(
                summary = "Atualizar usuário",
                description = "Atualiza os dados de um usuário existente."
        )
        @ApiResponses({
                @ApiResponse(
                        responseCode = "200",
                        description = "Usuário atualizado com sucesso.",
                        content = @Content(
                                schema = @Schema(implementation = UsuarioResponse.class)
                        )
                ),
                @ApiResponse(
                        responseCode = "409",
                        description = "O e-mail informado pertence a outro usuário."
                ),
                @ApiResponse(
                        responseCode = "400",
                        description = "Dados da requisição inválidos, quando as validações estiverem configuradas."
                )
        })
        public UsuarioResponse atualizar(
                @Parameter(
                        description = "Identificador do usuário que será atualizado.",
                        example = "1",
                        required = true
                )
                @PathVariable Long id,
                @Valid @RequestBody UsuarioRequest request) {

            return usuarioService.update(request, id);
        }
    }


