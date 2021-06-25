package sopra.pokebowl.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sopra.pokebowl.model.Action;
import sopra.pokebowl.model.CategorieAttaque;
import sopra.pokebowl.model.Statut;
import sopra.pokebowl.model.TypeEnum;

@RestController
@RequestMapping("/rest")
@CrossOrigin("*")
public class CommonRestController {
	@GetMapping("/actions")
	public Action[] getActions() {
		return Action.values();
	}
	
	@GetMapping("/categorieAttaques")
	public CategorieAttaque[] getCategorieAttaques() {
		return CategorieAttaque.values();
	}
	
	@GetMapping("/statuts")
	public Statut[] getStatuts() {
		return Statut.values();
	}
	
	@GetMapping("/typeEnums")
	public TypeEnum[] getTypeEnums() {
		return TypeEnum.values();
	}
}
