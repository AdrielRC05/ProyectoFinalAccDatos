package as.ProyectoFinalAD.controllers.controllersTemplates;

import as.ProyectoFinalAD.models.Piloto;
import as.ProyectoFinalAD.services.PilotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/pilotos")
public class PilotoMVCController {
    @Autowired
    private PilotoService pilotoService;

    // Obtener todos los pilotos
    @GetMapping
    public String obtenerTodos(Model model) {
        List<Piloto> pilotos = pilotoService.obtenerTodos();
        model.addAttribute("pilotos", pilotos);
        model.addAttribute("piloto", new Piloto());  // Objeto vacío para crear un nuevo piloto
        return "pilotos";  // Template Thymeleaf
    }

    // Crear o editar un piloto
    @PostMapping
    public String guardar(@ModelAttribute Piloto piloto) {
        pilotoService.guardar(piloto);
        return "redirect:/admin/pilotos";  // Redirigir a la lista
    }

    // Mostrar el formulario de edición de un piloto
    @GetMapping("/edit/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        Piloto piloto = pilotoService.obtenerPorId(id);
        if (piloto != null) {
            model.addAttribute("piloto", piloto);  // Pasa el piloto a la vista
            return "editarPiloto";  // Vista para editar piloto
        } else {
            return "redirect:/admin/pilotos";  // Redirige si no encuentra el piloto
        }
    }

    // Guardar cambios (POST)
    @PostMapping("/edit/{id}")
    public String actualizar(@PathVariable Integer id, @ModelAttribute Piloto piloto) {
        piloto.setId(id);  // Se asegura de que el piloto tiene el ID correcto
        pilotoService.actualizar(piloto);  // Actualiza el piloto
        return "redirect:/admin/pilotos";  // Redirige al listado de pilotos
    }

    // Eliminar un piloto
    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable Integer id) {
        pilotoService.borrar(id);
        return "redirect:/admin/pilotos";
    }
}
