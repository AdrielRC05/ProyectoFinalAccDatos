package as.ProyectoFinalAD.controllers;

import as.ProyectoFinalAD.models.Campeonato;
import as.ProyectoFinalAD.services.CampeonatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/campeonatos")
public class CampeonatoController {
    @Autowired
    private CampeonatoService campeonatoService;

    @GetMapping
    public List<Campeonato> obtenerTodos(@RequestParam (required = false) String nombre, @RequestParam (required = false) Integer id){
        if (nombre == null && id == null) {
            return campeonatoService.obtenerTodos();
        } else if (nombre != null && id == null) {
            return campeonatoService.obtenerPorNombre(nombre);
        } else if (nombre == null) {
            return Collections.singletonList(campeonatoService.obtenerPorId(id));
        } else {
            return campeonatoService.obtenerPorNombre(nombre);
        }
    }

    @PostMapping
    public Campeonato guardar(@RequestBody Campeonato campeonato){
        return campeonatoService.guardar(campeonato);
    }

    @PutMapping("/{id}")
    public Campeonato actualizar(@PathVariable Integer id, @RequestBody Campeonato campeonato){
        campeonato.setId(id);
        return campeonatoService.actualizar(campeonato);
    }

    @DeleteMapping("/{id}")
    public void borrar(@PathVariable Integer id){
        campeonatoService.borrar(id);
    }
}
