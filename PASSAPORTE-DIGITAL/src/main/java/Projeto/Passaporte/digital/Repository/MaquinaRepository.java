package Projeto.Passaporte.digital.Repository;

import Projeto.Passaporte.digital.Entity.Maquina;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaquinaRepository extends JpaRepository<Maquina, Long> {
    boolean existsByCodigo(String codigo);
}
