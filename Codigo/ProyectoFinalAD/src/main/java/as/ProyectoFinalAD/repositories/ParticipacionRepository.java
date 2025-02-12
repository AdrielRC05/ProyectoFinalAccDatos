package as.ProyectoFinalAD.repositories;

import as.ProyectoFinalAD.models.Participacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParticipacionRepository extends JpaRepository<Participacion, Integer> {
    List<Participacion> findByRallyId(Integer rallyId);
    List<Participacion> findByPilotoId(Integer pilotoId);
    List<Participacion> findByCopilotoId(Integer copilotoId);
}

