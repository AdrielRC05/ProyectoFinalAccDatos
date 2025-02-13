package as.ProyectoFinalAD.controllers;

import as.ProyectoFinalAD.models.Participacion;
import as.ProyectoFinalAD.services.ParticipacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/participaciones")
public class ParticipacionController {
    @Autowired
    private ParticipacionService participacionService;

    @GetMapping
    public List<Participacion> obtenerTodos(@RequestParam(required = false) Integer rallyId, @RequestParam(required = false) Integer pilotoId, @RequestParam(required = false) Integer copilotoId) {

        if (rallyId != null && pilotoId != null && copilotoId != null) {
            return participacionService.obtenerPorRallyIdYPilotoIdYCopilotoId(rallyId, pilotoId, copilotoId);
        } else if (rallyId != null && pilotoId != null) {
            return participacionService.obtenerPorRallyIdYPilotoId(pilotoId, rallyId);
        } else if (rallyId != null && copilotoId != null) {
            return participacionService.obtenerPorRallyIdYCopilotoId(copilotoId, rallyId);
        } else if (pilotoId != null && copilotoId != null) {
            return participacionService.obtenerPilotoIdYCopilotoId(copilotoId, pilotoId);
        } else if (rallyId != null) {
            return participacionService.obtenerPorRallyId(rallyId);
        } else if (pilotoId != null) {
            return participacionService.obtenerPorPilotoId(pilotoId);
        } else if (copilotoId != null) {
            return participacionService.obtenerPorCopilotoId(copilotoId);
        } else {
            return participacionService.obtenerTodos();
        }
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

