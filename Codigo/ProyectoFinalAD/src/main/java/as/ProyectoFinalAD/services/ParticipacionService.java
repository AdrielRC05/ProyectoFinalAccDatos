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

    public List<Participacion> obtenerPilotoIdYCopilotoId(Integer copilotoId, Integer pilotoId) {
        return participacionRepository.findByPilotoIdAndCopilotoId(copilotoId, pilotoId);
    }

    public List<Participacion> obtenerPorRallyIdYPilotoId(Integer pilotoId, Integer rallyId) {
        return participacionRepository.findByRallyIdAndPilotoId(pilotoId, rallyId);
    }

    public List<Participacion> obtenerPorRallyIdYCopilotoId(Integer copilotoId, Integer rallyId) {
        return participacionRepository.findByRallyIdAndCopilotoId(copilotoId, rallyId);
    }

    public List<Participacion> obtenerPorRallyIdYPilotoIdYCopilotoId(Integer copilotoId, Integer pilotoId, Integer rallyId) {
        return participacionRepository.findByRallyIdAndPilotoIdAndCopilotoId(copilotoId, pilotoId, rallyId);
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

