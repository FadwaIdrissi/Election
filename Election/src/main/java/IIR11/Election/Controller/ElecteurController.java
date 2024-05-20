package IIR11.Election.Controller;

import IIR11.Election.dao.Entities.Electeur;
import IIR11.Election.service.ElecteurService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/electeurs")
public class ElecteurController {

    @Autowired
    private ElecteurService electeurService;

    @GetMapping
    public String listElecteurs(Model model) {
        List<Electeur> electeurs = electeurService.findAll();
        model.addAttribute("electeurs", electeurs);
        return "electeurs/list";
    }

    @GetMapping("/add")
    public String addElecteurForm(Model model) {
        model.addAttribute("electeur", new Electeur());
        return "electeurs/add";
    }

    @PostMapping
    public String saveElecteur(@Valid @ModelAttribute Electeur electeur, BindingResult result) {
        if (result.hasErrors()) {
            return "electeurs/add";
        }
        electeurService.save(electeur);
        return "redirect:/electeurs";
    }

    @GetMapping("/edit/{id}")
    public String editElecteurForm(@PathVariable Long id, Model model) {
        Optional<Electeur> electeur = Optional.ofNullable(electeurService.findById(id));
        if (electeur.isPresent()) {
            model.addAttribute("electeur", electeur.get());
            return "electeurs/edit";
        } else {
            return "redirect:/electeurs?error=NotFound";
        }
    }

    @PostMapping("/edit/{id}")
    public String updateElecteur(@PathVariable Long id, @Valid @ModelAttribute Electeur electeur, BindingResult result) {
        if (result.hasErrors()) {
            return "electeurs/edit";
        }
        Optional<Electeur> existingElecteur = Optional.ofNullable(electeurService.findById(id));
        if (existingElecteur.isPresent()) {
            Electeur updatedElecteur = existingElecteur.get();
            updatedElecteur.setNomElecteur(electeur.getNomElecteur());
            // Copy other properties from electeur to updatedElecteur as needed
            electeurService.save(updatedElecteur);
            return "redirect:/electeurs";
        } else {
            return "redirect:/electeurs?error=NotFound";
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteElecteur(@PathVariable Long id) {
        electeurService.delete(id);
        return "redirect:/electeurs";
    }
}
