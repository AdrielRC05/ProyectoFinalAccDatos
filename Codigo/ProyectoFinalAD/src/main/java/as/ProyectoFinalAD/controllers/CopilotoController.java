package as.ProyectoFinalAD.controllers;

import as.ProyectoFinalAD.models.Copiloto;
import as.ProyectoFinalAD.services.CopilotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/copilotos")
public class CopilotoController {
    @Autowired
    private CopilotoService copilotoService;

    @GetMapping
    public List<Copiloto> obtenerTodos(@RequestParam(required = false) String nombre, @RequestParam(required = false) Integer id) {
        if (nombre != null && id != null) {
            return Collections.singletonList(copilotoService.obtenerPorNombreYId(nombre, id));
        } else if (nombre != null) {
            return copilotoService.obtenerPorNombre(nombre);
        } else if (id != null) {
            return Collections.singletonList(copilotoService.obtenerPorId(id));
        } else {
            return copilotoService.obtenerTodos();
        }
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


