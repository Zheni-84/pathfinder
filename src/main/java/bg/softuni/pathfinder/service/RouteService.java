package bg.softuni.pathfinder.service;

import bg.softuni.pathfinder.model.RouteEntity;
import bg.softuni.pathfinder.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteService {

	private final RouteRepository routeRepository;

	public RouteService(RouteRepository routeRepository) {
		this.routeRepository = routeRepository;
	}

	public RouteEntity getMostCommented() {
		RouteEntity routeEntity = routeRepository.getMostCommented().get(0);
		return routeEntity;
	}
}