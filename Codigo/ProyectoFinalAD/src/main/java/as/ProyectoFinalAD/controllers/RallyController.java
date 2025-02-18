package as.ProyectoFinalAD.controllers;

import as.ProyectoFinalAD.models.Rally;
import as.ProyectoFinalAD.services.RallyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/rallys")
@Tag(name = "Rally Controller", description = "Operaciones CRUD para Rally")
public class RallyController {

    @Autowired
    private RallyService rallyService;

    @GetMapping
    @Operation(summary = "Obtener todos los rallies", description = "Obtiene una lista de todos los rallies. Se puede filtrar por id o nombre.")
    public List<Rally> obtenerTodos(
            @Parameter(description = "ID del rally", required = false) @RequestParam(required = false) Integer id,
            @Parameter(description = "Nombre del rally", required = false) @RequestParam(required = false) String nombre) {

        if (id == null && nombre == null) {
            return rallyService.obtenerTodos();
        } else if (id != null) {
            return Collections.singletonList(rallyService.obtenerPorId(id));
        } else {
            return rallyService.obtenerPorNombre(nombre);
        }
    }

    @GetMapping("/campeonato/{campeonatoId}")
    @Operation(summary = "Obtener rallies de un campeonato", description = "Obtiene una lista de todos los rallies de un campeonato específico por ID de campeonato.")
    public List<Rally> obtenerRallysDeCampeonato(
            @Parameter(description = "ID del campeonato", required = true) @PathVariable Integer campeonatoId) {
        return rallyService.obtenerPorCampeonatoId(campeonatoId);
    }

    @PostMapping
    @Operation(summary = "Guardar un nuevo rally", description = "Guarda un nuevo rally en la base de datos.")
    public Rally guardar(
            @Parameter(description = "Datos del rally a guardar", required = true) @RequestBody Rally rally) {
        return rallyService.guardar(rally);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un rally", description = "Actualiza un rally existente en la base de datos.")
    public Rally actualizar(
            @Parameter(description = "ID del rally a actualizar", required = true) @PathVariable Integer id,
            @Parameter(description = "Datos del rally a actualizar", required = true) @RequestBody Rally rally) {
        rally.setId(id);
        return rallyService.actualizar(rally);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Borrar un rally", description = "Borra un rally de la base de datos por su ID.")
    public void borrar(
            @Parameter(description = "ID del rally a borrar", required = true) @PathVariable Integer id) {
        rallyService.borrar(id);
    }
}

