package as.ProyectoFinalAD.repositories;

import as.ProyectoFinalAD.models.Piloto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PilotoRepository extends JpaRepository<Piloto, Integer> {
    List<Piloto> findByNombreContains(String nombre);
}

