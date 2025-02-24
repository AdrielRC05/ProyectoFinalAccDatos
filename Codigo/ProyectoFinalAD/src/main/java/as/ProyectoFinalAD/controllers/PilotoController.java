package as.ProyectoFinalAD.controllers;

import as.ProyectoFinalAD.models.DTOs.RallyDTO;
import as.ProyectoFinalAD.models.Participacion;
import as.ProyectoFinalAD.models.Piloto;
import as.ProyectoFinalAD.repositories.ParticipacionRepository;
import as.ProyectoFinalAD.services.PilotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pilotos")
public class PilotoController {
    @Autowired
    private PilotoService pilotoService;

    @Autowired
    private ParticipacionRepository participacionRepository;

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

    @GetMapping("/{id}/rallys")
    public List<RallyDTO> obtenerRallysDelPiloto(@PathVariable("id") int pilotoId) {
        List<Participacion> participaciones = participacionRepository.findByPilotoId(pilotoId);
        return participaciones.stream()
                .map(participacion -> new RallyDTO(
                        participacion.getRally().getId(),
                        participacion.getRally().getNombre(),
                        participacion.getRally().getLocalizacion(),
                        participacion.getRally().getFechaCelebracion()))
                .collect(Collectors.toList());
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

