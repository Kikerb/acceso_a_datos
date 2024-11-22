package com.example.practica_7_8_rev;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Practica78RevApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Practica78RevApplication.class, args);
		
		////////////////////////////////
		//							  //
		//			Teams			  //
		//							  //
		////////////////////////////////
	
		TeamService teamService = ctx.getBean(TeamService.class);
		
		//1. Insertar uno
		Team team = new Team("Pramac", "Ducati");
		Long idInsertado1 = teamService.insertarTeam(team);
		
		
		//2. Insertar otro
		Team team2 = new Team("GressiningRacing", "Ducati");
		Long idInsertado2 = teamService.insertarTeam(team2);
		
		
		//3. Borrar primero
		teamService.borrarTeam(team);
		
		
		//4. Obtener por id y mostrar por pantalla
		Team teamObtenida = teamService.obtenerTeam(idInsertado2);
		
		if(team != null) {
			System.out.print("Se ha obtenido de la base de datos: " + teamObtenida.getId() + " " + teamObtenida.getName());
		}
		
		
		//5. Actualizar un atributo
		teamService.actualizarTeam(idInsertado2, "DucatiCorse", "Ducati");
		
		
		//6. Obtener por otro atributo y mostrar por pantalla la película 
		List<Team> teamsObtenidas = teamService.obtenerNombresTeams("Ducati");
		System.out.print("Se ha obtenido de la base de datos: " + teamsObtenidas.get(0).getId() + " " + teamsObtenidas.get(0).getName());
		
		
		////////////////////////////////
		//							  //
		//			Pilotos			  //
		//							  //
		////////////////////////////////
		
		PilotoService pilotoService = ctx.getBean(PilotoService.class);
		
		
		//7. Insertar un piloto
		Piloto piloto1 = new Piloto("PeccoBagniania63", team2);
		Long idInsertadoPiloto1 = pilotoService.insertarPiloto(piloto1);
		
		//8. Insertar otro piloto
		Piloto piloto2 = new Piloto("MarcMarquez93", team2);
		Long idInsertadoPiloto2 = pilotoService.insertarPiloto(piloto2);
		
		//9. Borrar el primer piloto.
		pilotoService.borrarPiloto(piloto1);
		
		//10: Obtener por id y mostrar por pantalla el piloto
		Piloto pilotoObtenido = pilotoService.obtenerPiloto(idInsertadoPiloto2);
		
		if(pilotoObtenido != null) {
			System.out.print("Se ha obtenido de la base de datos: " + pilotoObtenido.getId() + " " + pilotoObtenido.getName());
		}
		
		//11. Actualizar un atributo del piloto
		pilotoService.actualizarPiloto(idInsertadoPiloto2, "JorgeMartin89");
		
		//12. Obtener por otro atributo y mostrar por pantalla 
		List<Piloto> pilotosObtenidos = pilotoService.obtenerNombresPilotos("JorgeMartin89");
		System.out.print("Se ha obtenido de la base de datos: " + pilotosObtenidos.get(0).getId() + " " + pilotosObtenidos.get(0).getName());
	}

}
