package as.ProyectoFinalAD.controllers.controllersTemplates;

import as.ProyectoFinalAD.models.Copiloto;
import as.ProyectoFinalAD.services.CopilotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/copilotos")
public class CopilotoMVCController {
    @Autowired
    private CopilotoService copilotoService;

    // Obtener todos los copilotos
    @GetMapping
    public String obtenerTodos(Model model) {
        List<Copiloto> copilotos = copilotoService.obtenerTodos();
        model.addAttribute("copilotos", copilotos);
        model.addAttribute("copiloto", new Copiloto());  // Objeto vacío para crear un nuevo copiloto
        return "copilotos";  // Template Thymeleaf
    }

    // Crear o editar un copiloto
    @PostMapping
    public String guardar(@ModelAttribute Copiloto copiloto) {
        copilotoService.guardar(copiloto);
        return "redirect:/admin/copilotos";  // Redirigir a la lista
    }

    // Mostrar el formulario de edición de un copiloto
    @GetMapping("/edit/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        Copiloto copiloto = copilotoService.obtenerPorId(id);
        if (copiloto != null) {
            model.addAttribute("copiloto", copiloto);  // Pasa el copiloto a la vista
            return "editarCopiloto";  // Vista para editar copiloto
        } else {
            return "redirect:/admin/copilotos";  // Redirige si no encuentra el copiloto
        }
    }

    // Guardar cambios (POST)
    @PostMapping("/edit/{id}")
    public String actualizar(@PathVariable Integer id, @ModelAttribute Copiloto copiloto) {
        copiloto.setId(id);  // Se asegura de que el copiloto tiene el ID correcto
        copilotoService.actualizar(copiloto);  // Actualiza el copiloto
        return "redirect:/admin/copilotos";  // Redirige al listado de copilotos
    }

    // Eliminar un copiloto
    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable Integer id) {
        copilotoService.borrar(id);
        return "redirect:/admin/copilotos";
    }
}
