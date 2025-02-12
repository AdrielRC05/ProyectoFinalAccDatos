package as.ProyectoFinalAD.controllers;

import as.ProyectoFinalAD.models.ClasificacionRally;
import as.ProyectoFinalAD.services.ClasificacionRallyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clasificacionRallies")
public class ClasificacionRallyController {
    @Autowired
    private ClasificacionRallyService clasificacionRallyService;

    @GetMapping
    public List<ClasificacionRally> obtenerTodos() {
        return clasificacionRallyService.obtenerTodos();
    }

    @GetMapping("/rally/{rallyId}")
    public List<ClasificacionRally> obtenerPorRallyId(@PathVariable Integer rallyId) {
        return clasificacionRallyService.obtenerPorRallyId(rallyId);
    }

    @GetMapping("/piloto/{pilotoId}")
    public List<ClasificacionRally> obtenerPorPilotoId(@PathVariable Integer pilotoId) {
        return clasificacionRallyService.obtenerPorPilotoId(pilotoId);
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

