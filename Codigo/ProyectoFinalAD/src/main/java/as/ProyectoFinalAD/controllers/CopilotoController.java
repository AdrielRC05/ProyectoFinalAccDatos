package as.ProyectoFinalAD.controllers;

import as.ProyectoFinalAD.models.Copiloto;
import as.ProyectoFinalAD.services.CopilotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/copilotos")
public class CopilotoController {
    @Autowired
    private CopilotoService copilotoService;

    @GetMapping
    public List<Copiloto> obtenerTodos() {
        return copilotoService.obtenerTodos();
    }

    @GetMapping("/buscar")
    public List<Copiloto> obtenerPorNombre(@RequestParam String nombre) {
        return copilotoService.obtenerPorNombre(nombre);
    }

    @GetMapping("/{id}")
    public Copiloto obtenerPorId(@PathVariable Integer id) {
        return copilotoService.obtenerPorId(id);
    }

    @PostMapping
    public Copiloto guardar(@RequestBody Copiloto copiloto) {
        return copilotoService.guardar(copiloto);
    }

    @PutMapping("/{id}")
    public Copiloto actualizar(@PathVariable Integer id, @RequestBody Copiloto copiloto) {
        copiloto.setId(id);
        return copilotoService.actualizar(copiloto);
    }

    @DeleteMapping("/{id}")
    public void borrar(@PathVariable Integer id) {
        copilotoService.borrar(id);
    }
}


