package as.ProyectoFinalAD.services;

import as.ProyectoFinalAD.models.ClasificacionCampeonato;
import as.ProyectoFinalAD.repositories.ClasificacionCampeonatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClasificacionCampeonatoService {
    @Autowired
    private ClasificacionCampeonatoRepository clasificacionCampeonatoRepository;

    public List<ClasificacionCampeonato> obtenerTodos() {
        return clasificacionCampeonatoRepository.findAll();
    }

    public ClasificacionCampeonato obtenerPorId(Integer id) {
        return clasificacionCampeonatoRepository.findById(id).orElse(null);
    }

    public List<ClasificacionCampeonato> obtenerPorCampeonatoId(Integer campeonatoId) {
        return clasificacionCampeonatoRepository.findByCampeonatoId(campeonatoId);
    }

    public List<ClasificacionCampeonato> obtenerPorPilotoId(Integer pilotoId) {
        return clasificacionCampeonatoRepository.findByPilotoId(pilotoId);
    }

    public ClasificacionCampeonato guardar(ClasificacionCampeonato clasificacion) {
        return clasificacionCampeonatoRepository.save(clasificacion);
    }

    public ClasificacionCampeonato actualizar(ClasificacionCampeonato clasificacion) {
        return clasificacionCampeonatoRepository.save(clasificacion);
    }

    public void borrar(Integer id) {
        clasificacionCampeonatoRepository.deleteById(id);
    }
}
