package as.ProyectoFinalAD.controllers;

import as.ProyectoFinalAD.models.Rally;
import as.ProyectoFinalAD.services.RallyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rallies")
public class RallyController {
    @Autowired
    private RallyService rallyService;

    @GetMapping
    public List<Rally> obtenerTodos() {
        return rallyService.obtenerTodos();
    }

    @GetMapping("/buscar")
    public List<Rally> obtenerPorNombre(@RequestParam String nombre) {
        return rallyService.obtenerPorNombre(nombre);
    }

    @GetMapping("/{id}")
    public Rally obtenerPorId(@PathVariable Integer id) {
        return rallyService.obtenerPorId(id);
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

