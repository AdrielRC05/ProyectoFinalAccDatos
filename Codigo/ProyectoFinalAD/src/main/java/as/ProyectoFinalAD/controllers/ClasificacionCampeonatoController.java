package as.ProyectoFinalAD.controllers;

import as.ProyectoFinalAD.models.ClasificacionCampeonato;
import as.ProyectoFinalAD.services.ClasificacionCampeonatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/clasificacion_campeonatos")
public class ClasificacionCampeonatoController {
    @Autowired
    private ClasificacionCampeonatoService clasificacionCampeonatoService;

    @GetMapping
    public List<ClasificacionCampeonato> obtenerTodos(@RequestParam(required = false) Integer campeonatoId, @RequestParam(required = false) Integer pilotoId) {
        if (campeonatoId != null && pilotoId != null) {
            return clasificacionCampeonatoService.obtenerPorPilotoYCampeonato(campeonatoId, pilotoId);
        } else if (campeonatoId != null) {
            return clasificacionCampeonatoService.obtenerPorCampeonatoId(campeonatoId);
        } else if (pilotoId != null) {
            return clasificacionCampeonatoService.obtenerPorPilotoId(pilotoId);
        } else {
            return clasificacionCampeonatoService.obtenerTodos();
        }
    }

    @GetMapping("/{id}")
    public ClasificacionCampeonato obtenerPorId(@PathVariable Integer id) {
        return clasificacionCampeonatoService.obtenerPorId(id);
    }

    @PostMapping
    public ClasificacionCampeonato guardar(@RequestBody ClasificacionCampeonato clasificacion) {
        return clasificacionCampeonatoService.guardar(clasificacion);
    }

    @PutMapping("/{id}")
    public ClasificacionCampeonato actualizar(@PathVariable Integer id, @RequestBody ClasificacionCampeonato clasificacion) {
        clasificacion.setId(id);
        return clasificacionCampeonatoService.actualizar(clasificacion);
    }

    @DeleteMapping("/{id}")
    public void borrar(@PathVariable Integer id) {
        clasificacionCampeonatoService.borrar(id);
    }
}

