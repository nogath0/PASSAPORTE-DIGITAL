package weg.projeto.PASSAPORTE_DIGITAL.Repository;

import Projeto.Passaporte.digital.Entity.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerfilRepository extends JpaRepository<Perfil, Long> {

    boolean existsByNomeIgnoreCase(String nome);
}
