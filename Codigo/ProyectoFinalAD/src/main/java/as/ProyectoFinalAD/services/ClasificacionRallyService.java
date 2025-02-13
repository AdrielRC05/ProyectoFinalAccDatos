package as.ProyectoFinalAD.services;

import as.ProyectoFinalAD.models.ClasificacionRally;
import as.ProyectoFinalAD.repositories.ClasificacionRallyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClasificacionRallyService {
    @Autowired
    private ClasificacionRallyRepository clasificacionRallyRepository;

    public List<ClasificacionRally> obtenerTodos() {
        return clasificacionRallyRepository.findAll();
    }

    public ClasificacionRally obtenerPorId(Integer id) {
        return clasificacionRallyRepository.findById(id).orElse(null);
    }

    public List<ClasificacionRally> obtenerPorRallyId(Integer rallyId) {
        return clasificacionRallyRepository.findByRallyId(rallyId);
    }

    public List<ClasificacionRally> obtenerPorPilotoId(Integer pilotoId) {
        return clasificacionRallyRepository.findByPilotoId(pilotoId);
    }

    public ClasificacionRally obtenerPorPilotoIdYRallyId(Integer pilotoId, Integer rallyId) {
        return clasificacionRallyRepository.findByPilotoIdAndRallyId(pilotoId, rallyId);
    }

    public ClasificacionRally guardar(ClasificacionRally clasificacion) {
        return clasificacionRallyRepository.save(clasificacion);
    }

    public ClasificacionRally actualizar(ClasificacionRally clasificacion) {
        return clasificacionRallyRepository.save(clasificacion);
    }

    public void borrar(Integer id) {
        clasificacionRallyRepository.deleteById(id);
    }
}

