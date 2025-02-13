package as.ProyectoFinalAD.controllers;

import as.ProyectoFinalAD.models.ClasificacionRally;
import as.ProyectoFinalAD.services.ClasificacionRallyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/clasificacion_rallys")
public class ClasificacionRallyController {
    @Autowired
    private ClasificacionRallyService clasificacionRallyService;

    @GetMapping
    public List<ClasificacionRally> obtenerTodos(@RequestParam(required = false) Integer rallyId, @RequestParam(required = false) Integer pilotoId) {
        if (rallyId!=null && pilotoId!=null){
            return Collections.singletonList(clasificacionRallyService.obtenerPorPilotoIdYRallyId(rallyId, pilotoId));
        } else if (rallyId!=null) {
            return clasificacionRallyService.obtenerPorRallyId(rallyId);
        } else if (pilotoId!=null) {
            return clasificacionRallyService.obtenerPorPilotoId(pilotoId);
        } else {
            return clasificacionRallyService.obtenerTodos();
        }
    }

    @GetMapping("/{id}")
    public ClasificacionRally obtenerPorId(@PathVariable Integer id) {
        return clasificacionRallyService.obtenerPorId(id);
    }

    @PostMapping
    public ClasificacionRally guardar(@RequestBody ClasificacionRally clasificacion) {
        return clasificacionRallyService.guardar(clasificacion);
    }

    @PutMapping("/{id}")
    public ClasificacionRally actualizar(@PathVariable Integer id, @RequestBody ClasificacionRally clasificacion) {
        clasificacion.setId(id);
        return clasificacionRallyService.actualizar(clasificacion);
    }

    @DeleteMapping("/{id}")
    public void borrar(@PathVariable Integer id) {
        clasificacionRallyService.borrar(id);
    }
}

