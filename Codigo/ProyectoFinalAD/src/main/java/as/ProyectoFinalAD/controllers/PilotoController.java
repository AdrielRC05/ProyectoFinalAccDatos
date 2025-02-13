package as.ProyectoFinalAD.controllers;

import as.ProyectoFinalAD.models.Piloto;
import as.ProyectoFinalAD.services.PilotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/pilotos")
public class PilotoController {
    @Autowired
    private PilotoService pilotoService;

    @GetMapping
    public List<Piloto> obtenerTodos(@RequestParam(required = false) String nombre, @RequestParam(required = false) Integer id) {

        if (nombre != null && id != null) {
            return pilotoService.obtenerPorNombreYId(nombre, id);
        } else if (nombre != null) {
            return pilotoService.obtenerPorNombre(nombre);
        } else if (id != null) {
            return Collections.singletonList(pilotoService.obtenerPorId(id));
        } else {
            return pilotoService.obtenerTodos();
        }
    }

    @PostMapping
    public Piloto guardar(@RequestBody Piloto piloto) {
        return pilotoService.guardar(piloto);
    }

    @PutMapping("/{id}")
    public Piloto actualizar(@PathVariable Integer id, @RequestBody Piloto piloto) {
        piloto.setId(id);
        return pilotoService.actualizar(piloto);
    }

    @DeleteMapping("/{id}")
    public void borrar(@PathVariable Integer id) {
        pilotoService.borrar(id);
    }
}

