package as.ProyectoFinalAD.controllers.controllersTemplates;

import as.ProyectoFinalAD.models.Rally;
import as.ProyectoFinalAD.services.CampeonatoService;
import as.ProyectoFinalAD.services.RallyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/rallies")
public class RallyMVCController {
    @Autowired
    private RallyService rallyService;

    @Autowired
    private CampeonatoService campeonatoService;

    // Obtener todos los rallies
    @GetMapping
    public String obtenerTodos(Model model) {
        List<Rally> rallies = rallyService.obtenerTodos();
        model.addAttribute("rallies", rallies);
        model.addAttribute("rally", new Rally());  // Objeto vacío para crear un nuevo rally
        model.addAttribute("campeonatos", campeonatoService.obtenerTodos());  // Para la relación de campeonato
        return "rallies";  // Template Thymeleaf
    }

    // Crear o editar un rally
    @PostMapping
    public String guardar(@ModelAttribute Rally rally) {
        rallyService.guardar(rally);
        return "redirect:/admin/rallies";  // Redirigir a la lista
    }

    // Mostrar el formulario de edición de un rally
    @GetMapping("/edit/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        Rally rally = rallyService.obtenerPorId(id);
        if (rally != null) {
            model.addAttribute("rally", rally);  // Pasa el rally a la vista
            model.addAttribute("campeonatos", campeonatoService.obtenerTodos());  // Lista de campeonatos
            return "editarRally";  // Vista para editar rally
        } else {
            return "redirect:/admin/rallies";  // Redirige si no encuentra el rally
        }
    }

    // Guardar cambios (POST)
    @PostMapping("/edit/{id}")
    public String actualizar(@PathVariable Integer id, @ModelAttribute Rally rally) {
        rally.setId(id);  // Se asegura de que el rally tiene el ID correcto
        rallyService.actualizar(rally);  // Actualiza el rally
        return "redirect:/admin/rallies";  // Redirige al listado de rallies
    }

    // Eliminar un rally
    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable Integer id) {
        rallyService.borrar(id);
        return "redirect:/admin/rallies";
    }
}
