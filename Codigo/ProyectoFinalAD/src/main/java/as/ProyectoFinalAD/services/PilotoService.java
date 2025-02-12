package as.ProyectoFinalAD.services;

import as.ProyectoFinalAD.models.Piloto;
import as.ProyectoFinalAD.repositories.PilotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PilotoService {
    @Autowired
    private PilotoRepository pilotoRepository;

    public List<Piloto> obtenerTodos() {
        return pilotoRepository.findAll();
    }

    public Piloto obtenerPorId(Integer id) {
        return pilotoRepository.findById(id).orElse(null);
    }

    public List<Piloto> obtenerPorNombre(String nombre) {
        return pilotoRepository.findByNombreContains(nombre);
    }

    public Piloto guardar(Piloto piloto) {
        return pilotoRepository.save(piloto);
    }

    public Piloto actualizar(Piloto piloto) {
        return pilotoRepository.save(piloto);
    }

    public void borrar(Integer id) {
        pilotoRepository.deleteById(id);
    }
}

