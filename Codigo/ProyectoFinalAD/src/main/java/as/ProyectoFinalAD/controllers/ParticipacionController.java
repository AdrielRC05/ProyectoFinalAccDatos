package as.ProyectoFinalAD.controllers;

import as.ProyectoFinalAD.models.Participacion;
import as.ProyectoFinalAD.services.ParticipacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/participaciones")
public class ParticipacionController {
    @Autowired
    private ParticipacionService participacionService;

    @GetMapping
    public List<Participacion> obtenerTodos() {
        return participacionService.obtenerTodos();
    }

    @GetMapping("/rally/{rallyId}")
    public List<Participacion> obtenerPorRallyId(@PathVariable Integer rallyId) {
        return participacionService.obtenerPorRallyId(rallyId);
    }

    @GetMapping("/piloto/{pilotoId}")
    public List<Participacion> obtenerPorPilotoId(@PathVariable Integer pilotoId) {
        return participacionService.obtenerPorPilotoId(pilotoId);
    }

    @GetMapping("/copiloto/{copilotoId}")
    public List<Participacion> obtenerPorCopilotoId(@PathVariable Integer copilotoId) {
        return participacionService.obtenerPorCopilotoId(copilotoId);
    }

    @GetMapping("/{id}")
    public Participacion obtenerPorId(@PathVariable Integer id) {
        return participacionService.obtenerPorId(id);
    }

    @PostMapping
    public Participacion guardar(@RequestBody Participacion participacion) {
        return participacionService.guardar(participacion);
    }

    @PutMapping("/{id}")
    public Participacion actualizar(@PathVariable Integer id, @RequestBody Participacion participacion) {
        participacion.setId(id);
        return participacionService.actualizar(participacion);
    }

    @DeleteMapping("/{id}")
    public void borrar(@PathVariable Integer id) {
        participacionService.borrar(id);
    }
}

