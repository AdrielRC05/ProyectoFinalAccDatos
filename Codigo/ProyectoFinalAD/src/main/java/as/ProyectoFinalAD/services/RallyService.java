package as.ProyectoFinalAD.services;

import as.ProyectoFinalAD.models.Rally;
import as.ProyectoFinalAD.repositories.RallyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RallyService {
    @Autowired
    private RallyRepository rallyRepository;

    public List<Rally> obtenerTodos() {
        return rallyRepository.findAll();
    }

    public Rally obtenerPorId(Integer id) {
        return rallyRepository.findById(id).orElse(null);
    }

    public List<Rally> obtenerPorNombre(String nombre) {
        return rallyRepository.findByNombreContains(nombre);
    }

    public Rally guardar(Rally rally) {
        return rallyRepository.save(rally);
    }

    public Rally actualizar(Rally rally) {
        return rallyRepository.save(rally);
    }

    public void borrar(Integer id) {
        rallyRepository.deleteById(id);
    }
}
