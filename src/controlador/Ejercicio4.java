/**
 * 
 */
package controlador;


import modelo.gestiondb.ServicioBD;

/**
 * java-full-stack-dev-u18 - controlador - Ejercicio1
 *
 * @author Jose Antonio González Alcántara
 * 
 * Fecha de creación 06/05/2022
 */
public class Ejercicio4{

	private final static String nombreBaseDatos = "peliculas_y_salas";
	private final static String tablas[] = {"peliculas", "salas"};
	private final static String atributo = "nombre = 'Sala 1'";
	private final static String identificador = "codigo = 1";
	private final static String registros[] = {"(1,'Citizen Kane','PG'),(2,'Singin\\' in the Rain','G'),(3,'The Wizard of Oz','G'),(4,'The Quiet Man',NULL),(5,'North by Northwest',NULL),(6,'The Last Tango in Paris','NC-17'),(7,'Some Like it Hot','PG-13'),(8,'A Night at the Opera',NULL),(9,'Citizen King','G');","(1,'Odeon',5),(2,'Imperial',1),(3,'Majestic',NULL),(4,'Royale',6),(5,'Paraiso',3),(6,'Nickelodeon',NULL);"};
	private final static String scriptTabla[] = {"(codigo INT, nombre NVARCHAR(100) NOT NULL,calificacionedad VARCHAR(30) DEFAULT NULL,PRIMARY KEY (codigo))ENGINE=InnoDB;","(codigo INT,nombre NVARCHAR(100) NOT NULL,pelicula INT DEFAULT NULL,PRIMARY KEY (codigo),FOREIGN KEY (pelicula) REFERENCES peliculas (codigo)ON DELETE SET NULL ON UPDATE CASCADE)ENGINE=InnoDB;"};
	private final static int camposTabla1 = 3;
	private ServicioBD servicioBD;

	/**
	 * @param servicioBD
	 * @param conexion
	 */
	public Ejercicio4(ServicioBD servicioBD) {
		this.servicioBD = servicioBD;
		this.eliminarBaseDatos();
		this.servicioBD.crearBaseDatos(nombreBaseDatos);
		for (int i = 0; i < tablas.length; i++) {
			this.servicioBD.crearTablaBaseDatos(nombreBaseDatos, scriptTabla[i], tablas[i]);
			this.servicioBD.crearRegistros(nombreBaseDatos, tablas[i], registros[i]);
			
		}
		
	}
	
	public String leerBaseDeDatos() {
		
		return this.servicioBD.leerTablaBaseDatos(nombreBaseDatos, tablas[0], camposTabla1);
		
	}
	
	public void actualizarRegistros() {
		
		this.servicioBD.actualizarRegistros(nombreBaseDatos, tablas[0], atributo, identificador);
		
	}
	
	
	public void eliminarRegistros() {
		
		this.servicioBD.eliminarRegistros(nombreBaseDatos, tablas[0], identificador);
	}
	
	public void eliminarBaseDatos() {
		
		this.servicioBD.eliminarBaseDatos(nombreBaseDatos);
	}
	
}
