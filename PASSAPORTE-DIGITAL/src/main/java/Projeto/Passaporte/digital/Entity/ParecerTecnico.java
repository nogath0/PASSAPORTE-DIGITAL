package Projeto.Passaporte.digital.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pareceres_tecnicos")
@Getter
@Setter
@NoArgsConstructor
public class ParecerTecnico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "solicitacao_id", nullable = false)
    private Solicitacao solicitacao;

    @Column(name = "parecer_tecnico", nullable = false, length = 600)
    private String parecerTecnico;

    @Column(name = "acoes_corretivas", length = 200)
    private String acoesCorretivas;

    @Column(name = "acoes_preventivas", length = 200)
    private String acoesPreventivas;

    @Column(name = "status_maquina", nullable = false, length = 30)
    private String statusMaquina;
}
