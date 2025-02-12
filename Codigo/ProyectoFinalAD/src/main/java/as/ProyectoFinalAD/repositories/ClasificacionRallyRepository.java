package as.ProyectoFinalAD.repositories;

import as.ProyectoFinalAD.models.ClasificacionRally;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClasificacionRallyRepository extends JpaRepository<ClasificacionRally, Integer> {
    List<ClasificacionRally> findByRallyId(Integer rallyId);
    List<ClasificacionRally> findByPilotoId(Integer pilotoId);
}

