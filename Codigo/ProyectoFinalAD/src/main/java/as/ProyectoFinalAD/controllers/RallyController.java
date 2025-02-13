package as.ProyectoFinalAD.controllers;

import as.ProyectoFinalAD.models.Rally;
import as.ProyectoFinalAD.services.RallyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/rallys")
public class RallyController {
    @Autowired
    private RallyService rallyService;

    @GetMapping
    public List<Rally> obtenerTodos(@RequestParam(required = false) Integer id, @RequestParam(required = false) String nombre) {

        if (id == null && nombre == null) {
            return rallyService.obtenerTodos();
        } else if (id != null) {
            return Collections.singletonList(rallyService.obtenerPorId(id));
        } else{
            return rallyService.obtenerPorNombre(nombre);
        }
    }

    @GetMapping("/campeonato/{campeonatoId}")
    public List<Rally> obtenerRallysDeCampeonato(Integer campeonatoId){
        return rallyService.obtenerPorCampeonatoId(campeonatoId);
    }

    @PostMapping
    public Rally guardar(@RequestBody Rally rally) {
        return rallyService.guardar(rally);
    }

    @PutMapping("/{id}")
    public Rally actualizar(@PathVariable Integer id, @RequestBody Rally rally) {
        rally.setId(id);
        return rallyService.actualizar(rally);
    }

    @DeleteMapping("/{id}")
    public void borrar(@PathVariable Integer id) {
        rallyService.borrar(id);
    }
}

