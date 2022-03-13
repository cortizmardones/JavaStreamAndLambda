import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

//Esta anotación es para evitar que los import que no utilizo se pongan en amarillo
@SuppressWarnings("unused")
public class HolaMundo {

	public static void main(String[] args) {

		Persona personaEsteban = new Persona("Esteban","Bustos",2800);
		Persona personaCarlos = new Persona("Carlos","Ortiz",34);
		Persona personaJaime = new Persona("Jaime","Silva", 20);

		try {
			
			Persona[] listaPersonas = new Persona[3];
			listaPersonas[0] = personaEsteban;
			listaPersonas[1] = personaCarlos;
			listaPersonas[2] = personaJaime;
			
			// Esta linea no funciona si en la clase Persona no tengo implementada la interfaz Comparable<Persona>
			Collections.sort(Arrays.asList(listaPersonas));

			// For Clásico
			for (int i = 0; i < listaPersonas.length; i++) {
				System.out.println("Nombre: " + listaPersonas[i].getNombre());
			}
			System.out.println("");
			
			List <Persona> listaPersonasList = Arrays.asList(listaPersonas);	
			
			try {
				Persona personFiltrada = listaPersonasList.stream()
						.filter(i -> i.getApellido().equalsIgnoreCase("Ortiz") && i.getEdad() <= 1800)
						.findFirst()
						.get();
				System.out.println(personFiltrada.getNombre());
				System.out.println(personFiltrada.getEdad());
			} catch (Exception e) {
				System.out.println("Exception: " + e.getMessage());
				e.getMessage();
			}

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}

	}

}


// For Clásico
//for (int i = 0; i < listaPersonas.length; i++) {
//	System.out.println("Nombre: " + listaPersonas[i].getNombre());
//System.out.println("Nombre: " + listaPersonas[i].getApellido());
//	System.out.println("Nombre: " + listaPersonas[i].getEdad());
//}
//System.out.println("");


// Foreach
//for (Persona p : listaPersonas) {
//	System.out.println("Nombre: " + p.getNombre());
//System.out.println("Nombre: " + p.getApellido());
//	System.out.println("Edad: " + p.getEdad());
//}
//System.out.println("");


// Stream Foreach List/ArrayList
//List <Persona> listaPersonasList = Arrays.asList(listaPersonas);		
//listaPersonasList.stream().forEach((i) -> {
//	System.out.println("Nombre: " + i.getNombre());
//  System.out.println("Nombre: " + i.getApellido());
//	System.out.println("Edad: " + i.getEdad());
//});
//System.out.println("");

// Stream Foreach HashMap
//HashMap<String, String> mapa = new HashMap<String , String>();
//mapa.put("Sony","Play Station 5");
//mapa.put("Microsoft","Xbox One X");
//mapa.put("Nintendo","Nintendo Switch");
//mapa.forEach((k,v) -> {
//	System.out.println("Clave: " + k + " / Valor: " + v);
//});
//System.out.println("");
