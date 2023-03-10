package bg.softuni.pathfinder.web;

import bg.softuni.pathfinder.model.RouteEntity;
import bg.softuni.pathfinder.service.RouteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	private final RouteService routeService;

	public HomeController(RouteService routeService) {
		this.routeService = routeService;
	}

	@GetMapping("/")
	public String home(Model model) {
		RouteEntity route = routeService.getMostCommented();
		model.addAttribute("mostCommented", route);
		return "index";
	}
}