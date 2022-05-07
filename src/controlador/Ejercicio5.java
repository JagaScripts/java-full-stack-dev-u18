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
public class Ejercicio5{

	private final static String nombreBaseDatos = "directores";
	private final static String tablas[] = {"despachos", "directores"};
	private final static String atributo = "capacidad = 30";
	private final static String identificador = "numero = 1";
	private final static String registros[] = {"(1,20), \r\n"
			+ "(2,5), \r\n"
			+ "(3,15), \r\n"
			+ "(4,35), \r\n"
			+ "(5,25), \r\n"
			+ "(6,5), \r\n"
			+ "(7,25), \r\n"
			+ "(8,20), \r\n"
			+ "(9,15), \r\n"
			+ "(10,10), \r\n"
			+ "(11,20);","('12345684', 'Jose A', DEFAULT, 1),\r\n"
					+ "('12345685', 'Daniel', '12345684', 2),\r\n"
					+ "('12345686', 'Joan', '12345684', 3),\r\n"
					+ "('12345687', 'Miguel', '12345684', 10),\r\n"
					+ "('12345688', 'Gerard', '12345684', 4),\r\n"
					+ "('12345689', 'Marc', '12345688', 8),\r\n"
					+ "('12345610', 'Veronika', '12345686', 5),\r\n"
					+ "('12345611', 'Constant', '12345686', 9),\r\n"
					+ "('12345612', 'Octavi', '12345686', 6),\r\n"
					+ "('12345613', 'Aida', '12345686', 6),\r\n"
					+ "('12345696', 'Adria', '12345688', 4);"};
	private final static String scriptTabla[] = {"(\r\n"
			+ "numero INT,\r\n"
			+ "capacidad INT NOT NULL,\r\n"
			+ "PRIMARY KEY (numero)\r\n"
			+ ")ENGINE=InnoDB;","(\r\n"
					+ "DNI VARCHAR(8),\r\n"
					+ "nombre_completo NVARCHAR(255) NOT NULL,\r\n"
					+ "DNI_jefe VARCHAR(8) DEFAULT NULL,\r\n"
					+ "despacho INT DEFAULT NULL,\r\n"
					+ "PRIMARY KEY (DNI),\r\n"
					+ "FOREIGN KEY (despacho) REFERENCES despachos (numero)\r\n"
					+ "ON DELETE SET NULL ON UPDATE CASCADE,\r\n"
					+ "FOREIGN KEY (DNI_jefe) REFERENCES directores (DNI)\r\n"
					+ "ON DELETE SET NULL ON UPDATE CASCADE\r\n"
					+ ")ENGINE=InnoDB;"};
	private final static int camposTabla1 = 2;
	private ServicioBD servicioBD;

	/**
	 * @param servicioBD
	 * @param conexion
	 */
	public Ejercicio5(ServicioBD servicioBD) {
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
