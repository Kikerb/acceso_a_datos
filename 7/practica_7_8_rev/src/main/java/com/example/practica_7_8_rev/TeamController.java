package com.example.practica_7_8_rev;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teams")
public class TeamController {
	@Autowired
	private TeamService teamService;
	
	
	@PostMapping
	public ResponseEntity<Long> insertTeam(@RequestBody Team team){
		Long id = teamService.insertarTeam(team);
		
		return new ResponseEntity<>(id, HttpStatus.CREATED);	
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> updateTeam(@PathVariable Long id, @RequestParam String nuevoName,  @RequestParam String nuevoFactory){
		teamService.actualizarTeam(id, nuevoName, nuevoFactory);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Team> obtenerTeamId(@PathVariable Long id){
		Team team = teamService.obtenerTeam(id);
		if (team != null) {
			return new ResponseEntity<>(team, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	@GetMapping("/")
	public ResponseEntity<List<Team>> obtenerTeam(){
		List<Team> teams = teamService.obtenerTodoTeams();
		if (teams != null && !teams.isEmpty()) {
			return new ResponseEntity<>(teams, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping("/factory/{factory}")
    public ResponseEntity<List<Team>> obtenerEquiposPorFactory(@PathVariable("factory") String factory) {
        List<Team> teams = teamService.obtenerNombresTeams(factory);

        if (teams != null && !teams.isEmpty()) {
            return new ResponseEntity<>(teams, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
	
	@DeleteMapping("/{id}")
    public ResponseEntity<Void> borrarTeam(@PathVariable("id") Long id) {
        boolean eliminado = teamService.borrarTeamPorId(id);

        if (eliminado) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
        }
    }
	
	
}
