package as.ProyectoFinalAD.services;

import as.ProyectoFinalAD.models.Campeonato;
import as.ProyectoFinalAD.repositories.CampeonatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CampeonatoService {
    @Autowired
    private CampeonatoRepository campeonatoRepository;

    public List<Campeonato> obtenerTodos(){
        return campeonatoRepository.findAll();
    }

    public Campeonato obtenerPorId(Integer id){
        return campeonatoRepository.findById(id).orElse(null);
    }

    public List<Campeonato> obtenerPorNombre(String nombre){
        return campeonatoRepository.findByNombreContains(nombre);
    }

    public Campeonato guardar(Campeonato campeonato){
        return campeonatoRepository.save(campeonato);
    }

    public Campeonato actualizar(Campeonato campeonato){
        return campeonatoRepository.save(campeonato);
    }

    public void borrar(Integer id){
        campeonatoRepository.deleteById(id);
    }
}
