package as.ProyectoFinalAD.repositories;

import as.ProyectoFinalAD.models.Copiloto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CopilotoRepository extends JpaRepository<Copiloto, Integer> {
    List<Copiloto> findByNombreContains(String nombre);
    Copiloto findByNombreAndId(String nombre, Integer id);
}

