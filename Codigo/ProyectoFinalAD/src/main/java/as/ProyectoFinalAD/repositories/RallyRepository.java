package as.ProyectoFinalAD.repositories;

import as.ProyectoFinalAD.models.Rally;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RallyRepository extends JpaRepository<Rally, Integer> {
    List<Rally> findByNombreContains(String nombre);
    List<Rally> findByCampeonatoId(Integer campeonatoId);
}

