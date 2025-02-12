package as.ProyectoFinalAD.controllers;

import as.ProyectoFinalAD.models.ClasificacionCampeonato;
import as.ProyectoFinalAD.services.ClasificacionCampeonatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clasificacionCampeonatos")
public class ClasificacionCampeonatoController {
    @Autowired
    private ClasificacionCampeonatoService clasificacionCampeonatoService;

    @GetMapping
    public List<ClasificacionCampeonato> obtenerTodos() {
        return clasificacionCampeonatoService.obtenerTodos();
    }

    @GetMapping("/campeonato/{campeonatoId}")
    public List<ClasificacionCampeonato> obtenerPorCampeonatoId(@PathVariable Integer campeonatoId) {
        return clasificacionCampeonatoService.obtenerPorCampeonatoId(campeonatoId);
    }

    @GetMapping("/piloto/{pilotoId}")
    public List<ClasificacionCampeonato> obtenerPorPilotoId(@PathVariable Integer pilotoId) {
        return clasificacionCampeonatoService.obtenerPorPilotoId(pilotoId);
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

