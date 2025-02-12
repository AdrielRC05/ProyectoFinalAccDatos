package as.ProyectoFinalAD.services;

import as.ProyectoFinalAD.models.Participacion;
import as.ProyectoFinalAD.repositories.ParticipacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipacionService {
    @Autowired
    private ParticipacionRepository participacionRepository;

    public List<Participacion> obtenerTodos() {
        return participacionRepository.findAll();
    }

    public Participacion obtenerPorId(Integer id) {
        return participacionRepository.findById(id).orElse(null);
    }

    public List<Participacion> obtenerPorRallyId(Integer rallyId) {
        return participacionRepository.findByRallyId(rallyId);
    }

    public List<Participacion> obtenerPorPilotoId(Integer pilotoId) {
        return participacionRepository.findByPilotoId(pilotoId);
    }

    public List<Participacion> obtenerPorCopilotoId(Integer copilotoId) {
        return participacionRepository.findByCopilotoId(copilotoId);
    }

    public Participacion guardar(Participacion participacion) {
        return participacionRepository.save(participacion);
    }

    public Participacion actualizar(Participacion participacion) {
        return participacionRepository.save(participacion);
    }

    public void borrar(Integer id) {
        participacionRepository.deleteById(id);
    }
}

