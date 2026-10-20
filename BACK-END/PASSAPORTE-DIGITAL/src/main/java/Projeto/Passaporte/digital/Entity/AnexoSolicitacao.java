package Projeto.Passaporte.digital.Entity;


import Projeto.Passaporte.digital.Usuario.Solicitacao;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "anexos_solicitacao")
@Getter
@Setter
@NoArgsConstructor
public class AnexoSolicitacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "solicitacao_id", nullable = false)
    private Solicitacao solicitacao;

    @Column(name = "url_arquivo", nullable = false, length = 500)
    private String urlArquivo;

    @Column(name = "tamanho_bytes", nullable = false)
    private Long tamanhoBytes;
}
