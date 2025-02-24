package as.ProyectoFinalAD.controllers.controllersTemplates;


import as.ProyectoFinalAD.models.Campeonato;
import as.ProyectoFinalAD.services.CampeonatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/campeonatos")
public class CampeonatoMVCControler {

    @Autowired
    private CampeonatoService campeonatoService;

    @GetMapping
    public String obtenerTodos(Model model) {
        List<Campeonato> campeonatos = campeonatoService.obtenerTodos();
        model.addAttribute("campeonatos", campeonatos);
        model.addAttribute("campeonato", new Campeonato());  // Objeto vacío para crear un nuevo campeonato
        return "campeonatos";  // Template Thymeleaf
    }

    // Crear o editar un campeonato
    @PostMapping
    public String guardar(@ModelAttribute Campeonato campeonato) {
        campeonatoService.guardar(campeonato);
        return "redirect:/admin/campeonatos";  // Redirigir a la lista
    }

    // Mostrar el formulario de edición de un campeonato
    @GetMapping("/edit/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        Campeonato campeonato = campeonatoService.obtenerPorId(id);
        if (campeonato != null) {
            model.addAttribute("campeonato", campeonato);  // Pasa el campeonato a la vista
            return "editarCampeonato";  // Vista para editar campeonato
        } else {
            return "redirect:/admin/campeonatos";  // Redirige si no encuentra el campeonato
        }
    }

    // Guardar cambios (POST)
    @PostMapping("/edit/{id}")
    public String actualizar(@PathVariable Integer id, @ModelAttribute Campeonato campeonato) {
        campeonato.setId(id);  // Se asegura de que el campeonato tiene el ID correcto
        campeonatoService.actualizar(campeonato);  // Actualiza el campeonato
        return "redirect:/admin/campeonatos";  // Redirige al listado de campeonatos
    }

    // Eliminar un campeonato
    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable Integer id) {
        campeonatoService.borrar(id);
        return "redirect:/admin/campeonatos";
    }
}
