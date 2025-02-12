package as.ProyectoFinalAD.controllers;

import as.ProyectoFinalAD.models.Piloto;
import as.ProyectoFinalAD.services.PilotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pilotos")
public class PilotoController {
    @Autowired
    private PilotoService pilotoService;

    @GetMapping
    public List<Piloto> obtenerTodos() {
        return pilotoService.obtenerTodos();
    }

    @GetMapping("/buscar")
    public List<Piloto> obtenerPorNombre(@RequestParam String nombre) {
        return pilotoService.obtenerPorNombre(nombre);
    }

    @GetMapping("/{id}")
    public Piloto obtenerPorId(@PathVariable Integer id) {
        return pilotoService.obtenerPorId(id);
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

