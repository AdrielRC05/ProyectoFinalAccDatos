package as.ProyectoFinalAD.repositories;

import as.ProyectoFinalAD.models.Campeonato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CampeonatoRepository extends JpaRepository<Campeonato,Integer> {
    List<Campeonato> findByNombreContains(String nombre);
}
