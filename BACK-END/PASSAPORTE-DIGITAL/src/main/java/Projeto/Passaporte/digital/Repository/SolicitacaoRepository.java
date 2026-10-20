package Projeto.Passaporte.digital.Repository;

import Projeto.Passaporte.digital.Usuario.Solicitacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolicitacaoRepository extends JpaRepository<Solicitacao, Long> {
}
