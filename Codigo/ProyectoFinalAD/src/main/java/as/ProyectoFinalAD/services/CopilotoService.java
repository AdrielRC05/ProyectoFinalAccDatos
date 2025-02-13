package as.ProyectoFinalAD.services;

import as.ProyectoFinalAD.models.Copiloto;
import as.ProyectoFinalAD.repositories.CopilotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CopilotoService {
    @Autowired
    private CopilotoRepository copilotoRepository;

    public List<Copiloto> obtenerTodos() {
        return copilotoRepository.findAll();
    }

    public Copiloto obtenerPorId(Integer id) {
        return copilotoRepository.findById(id).orElse(null);
    }

    public List<Copiloto> obtenerPorNombre(String nombre) {
        return copilotoRepository.findByNombreContains(nombre);
    }

    public Copiloto obtenerPorNombreYId(String nombre, Integer id) {
        return copilotoRepository.findByNombreAndId(nombre, id);
    }

    public Copiloto guardar(Copiloto copiloto) {
        return copilotoRepository.save(copiloto);
    }

    public Copiloto actualizar(Copiloto copiloto) {
        return copilotoRepository.save(copiloto);
    }

    public void borrar(Integer id) {
        copilotoRepository.deleteById(id);
    }
}
