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
public class Ejercicio9{

	private final static String nombreBaseDatos = "investigadores";
	private final static String tablas[] = {"facultades", "investigadores","equipos","reserva"};
	private final static String atributo = "nombre = 'Universidad Autonoma de Barcelona'";
	private final static String identificador = "codigo = 1";
	private final static String registros[] = {"(1,\"UAB\"),\r\n"
			+ "(2,\"URV\"),\r\n"
			+ "(3,\"Hardvard\"),\r\n"
			+ "(4,\"Candbridge\"),\r\n"
			+ "(5,\"Universitat de Valencia\"),\r\n"
			+ "(6,\"MIT\"),\r\n"
			+ "(7,\"Cannes\"),\r\n"
			+ "(8,\"UMAA\"),\r\n"
			+ "(9,\"UTL Salke\"),\r\n"
			+ "(10,\"Universida Granada\");","(\"12345684\", \"Jose González Ruiz\", 1),\r\n"
					+ "(\"12345685\", \"Daniel Fernandez Lujan\", 2),\r\n"
					+ "(\"12345686\", \"Joan Hurtado Martín\", 3),\r\n"
					+ "(\"12345687\", \"Miguel Alcántara Garrido\", 4),\r\n"
					+ "(\"12345688\", \"Gerard Martinez Soja\", 5),\r\n"
					+ "(\"12345689\", \"Marc Marquez Sevilla\", 6),\r\n"
					+ "(\"12345610\", \"Veronika Rexbo Tomico\", 7),\r\n"
					+ "(\"12345611\", \"Constant Tomico Rexbo\", 8),\r\n"
					+ "(\"12345612\", \"Octavi Herraiz Llull\", 9),\r\n"
					+ "(\"12345613\", \"Aida Queralt Lozano\", 10);","(\"fase\", \"Equipo10\", 10),\r\n"
							+ "(\"dfsd\", \"Equipo3\", 8),\r\n"
							+ "(\"uER3\", \"Equipo4\", 7),\r\n"
							+ "(\"Sdfa\", \"Equipo5\", 9),\r\n"
							+ "(\"sdfe\", \"Equipo6\", 3),\r\n"
							+ "(\"dfas\", \"Equipo5\", 7),\r\n"
							+ "(\"JKds\", \"Equipo6\", 3),\r\n"
							+ "(\"djdf\", \"Equipo1\", 2),\r\n"
							+ "(\"dssd\", \"Equipo5\", 1),\r\n"
							+ "(\"dass\", \"Equipo1\", 1);","(\"12345684\", \"fase\",'2010-05-10','2010-06-10'),\r\n"
									+ "('12345686', \"dfsd\", '2010-05-23', '2010-06-12'),\r\n"
									+ "(\"12345685\", \"uER3\", \"2010-05-23\", \"2010-06-12\"),\r\n"
									+ "(\"12345687\", \"uER3\", \"2010-05-23\", \"2010-06-12\"),\r\n"
									+ "(\"12345688\", \"sdfe\", \"2010-05-23\", \"2010-06-12\"),\r\n"
									+ "(\"12345689\", \"dssd\", \"2010-05-23\", \"2010-06-12\"),\r\n"
									+ "(\"12345610\", \"JKds\", \"2010-03-23\", \"2010-06-12\"),\r\n"
									+ "(\"12345611\", \"JKds\", \"2010-05-23\", \"2010-06-12\"),\r\n"
									+ "(\"12345612\", \"Sdfa\", \"2010-03-23\", \"2010-06-12\"),\r\n"
									+ "(\"12345613\", \"dass\", \"2010-05-23\", \"2010-04-12\");"};
	private final static String scriptTabla[] = {"(\r\n"
			+ "codigo INT,\r\n"
			+ "nombre NVARCHAR(100) NOT NULL,\r\n"
			+ "PRIMARY KEY (codigo)\r\n"
			+ ")ENGINE=InnoDB;","(\r\n"
					+ "DNI NVARCHAR(8),\r\n"
					+ "nombre_completo NVARCHAR(255) NOT NULL,\r\n"
					+ "facultad INT NOT NULL,\r\n"
					+ "PRIMARY KEY (DNI),\r\n"
					+ "FOREIGN KEY (facultad) REFERENCES facultades (codigo)\r\n"
					+ "ON DELETE CASCADE ON UPDATE CASCADE\r\n"
					+ ")ENGINE=InnoDB;","(\r\n"
							+ "numero_serie CHAR(4),\r\n"
							+ "nombre NVARCHAR(100) NOT NULL,\r\n"
							+ "facultad INT NOT NULL,\r\n"
							+ "PRIMARY KEY (numero_serie),\r\n"
							+ "FOREIGN KEY (facultad) REFERENCES facultades (codigo)\r\n"
							+ "ON DELETE CASCADE ON UPDATE CASCADE\r\n"
							+ ")ENGINE=InnoDB;","(\r\n"
									+ "DNI NVARCHAR(8),\r\n"
									+ "numero_serie CHAR(4),\r\n"
									+ "comienzo DATETIME,\r\n"
									+ "fin DATETIME,\r\n"
									+ "PRIMARY KEY (DNI , numero_serie),\r\n"
									+ "FOREIGN KEY (DNI) REFERENCES investigadores (DNI)\r\n"
									+ "ON DELETE CASCADE ON UPDATE CASCADE,\r\n"
									+ "FOREIGN KEY (numero_serie) REFERENCES equipos (numero_serie)\r\n"
									+ "ON DELETE CASCADE ON UPDATE CASCADE\r\n"
									+ ")ENGINE=InnoDB;"};
	private final static int camposTabla1 = 2;
	private ServicioBD servicioBD;

	/**
	 * @param servicioBD
	 * @param conexion
	 */
	public Ejercicio9(ServicioBD servicioBD) {
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
