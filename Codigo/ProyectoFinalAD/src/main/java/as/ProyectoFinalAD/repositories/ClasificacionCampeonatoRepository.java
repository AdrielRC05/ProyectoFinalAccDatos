package as.ProyectoFinalAD.repositories;

import as.ProyectoFinalAD.models.ClasificacionCampeonato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClasificacionCampeonatoRepository extends JpaRepository<ClasificacionCampeonato, Integer> {
    List<ClasificacionCampeonato> findByCampeonatoId(Integer campeonatoId);
    List<ClasificacionCampeonato> findByPilotoId(Integer pilotoId);
    List<ClasificacionCampeonato> findByCampeonatoIdAndPilotoId(Integer campeonatoId, Integer pilotoId);
}

