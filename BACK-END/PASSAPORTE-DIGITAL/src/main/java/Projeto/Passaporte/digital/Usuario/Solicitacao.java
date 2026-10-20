package Projeto.Passaporte.digital.Usuario;


import Projeto.Passaporte.digital.Entity.Maquina;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "solicitacoes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Solicitacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 20)
    private String numero;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "solicitante_id", nullable = false)
    private Usuario solicitante;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "maquina_id", nullable = false)
    private Maquina maquina;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "responsavel_id")
    private Usuario responsavel;

    @Column(nullable = false, length = 30)
    private String tipo;

    @Column(nullable = false, length = 200)
    private String descricao;

    @Column(nullable = false, length = 20)
    private String prioridade;

    @Column(nullable = false, length = 30)
    private String status;

    @Column(name = "criado_em", nullable = false)
    private LocalDateTime criadoEm;
}

