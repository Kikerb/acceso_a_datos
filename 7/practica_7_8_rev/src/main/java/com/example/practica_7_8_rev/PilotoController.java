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
@RequestMapping("/pilotos")

public class PilotoController {
	
	@Autowired
	private PilotoService pilotoService;
	
	 @Autowired
	    private TeamService teamService;
	
	 @PostMapping
	    public ResponseEntity<?> insertarPiloto(@RequestParam Long idTeam, @RequestBody Piloto piloto) {	       
	        Team team = teamService.obtenerTeam(idTeam);
	        if (team == null) {
	            return new ResponseEntity<>("Team no encontrado para el ID proporcionado: " + idTeam, HttpStatus.NOT_FOUND);
	        }

	        piloto.setTeam(team);

	        Long id = pilotoService.insertarPiloto(piloto);

	        return new ResponseEntity<>(id, HttpStatus.CREATED);
	    }
	 
	 @PutMapping("/{id}/nombre")
		public ResponseEntity<String> updatePiloto(@PathVariable Long id, @RequestParam String nuevoName){
		 Piloto piloto = pilotoService.obtenerPiloto(id);
		 
		 
	        if (piloto == null) {
	            return new ResponseEntity<>("Piloto no encontrado para el ID proporcionado: " + id, HttpStatus.NOT_FOUND);
	        }
	        
	        pilotoService.actualizarPiloto(id, nuevoName);
			 
			return new ResponseEntity<>(HttpStatus.OK);
		}
	 
	 @PutMapping("/{id}/equipo/{id_team}")
		public ResponseEntity<String> updatePilotoIdTeam(@PathVariable Long id, @PathVariable Long id_team){
		 Team team = teamService.obtenerTeam(id_team);
	        if (team == null) {
	            return new ResponseEntity<>("Team no encontrado para el ID proporcionado: " + id_team, HttpStatus.NOT_FOUND);
	        }
	        
		 Piloto piloto = pilotoService.obtenerPiloto(id);
		 
		 
	        if (piloto == null) {
	            return new ResponseEntity<>("Piloto no encontrado para el ID proporcionado: " + id, HttpStatus.NOT_FOUND);
	        }
	        
	        piloto.setTeam(team);
	        
	        pilotoService.actualizarIdTeam(piloto);
			 
			return new ResponseEntity<>(HttpStatus.OK);
		}
	 @DeleteMapping("/{id}")
	    public ResponseEntity<String> borrarPiloto(@PathVariable("id") Long id) {
	        boolean eliminado = pilotoService.borrarPilotoPorId(id);

	        if (eliminado) {
	            return new ResponseEntity<>(HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>("Piloto no encontrado para el ID proporcionado: " + id, HttpStatus.NOT_FOUND);
	        }
	    }
	 @GetMapping("/{id}")
		public ResponseEntity<?> obtenerPilotoId(@PathVariable Long id){
			Piloto piloto = pilotoService.obtenerPiloto(id);
			if (piloto != null) {
				return new ResponseEntity<>(piloto, HttpStatus.OK);
			}else {
				return new ResponseEntity<>("Piloto no encontrado para el ID proporcionado: " + id, HttpStatus.NOT_FOUND);
			}
	 }
	 
	 @GetMapping("/")
		public ResponseEntity<?> obtenerPiloto(){
			List<Piloto> pilotos = pilotoService.obtenerTodoslosPilotos();
			if (pilotos != null && !pilotos.isEmpty()) {
				return new ResponseEntity<>(pilotos, HttpStatus.OK);
			}else {
				return new ResponseEntity<>("Piloto no encontrado", HttpStatus.NOT_FOUND);
			}
		}
	 
	 
}
