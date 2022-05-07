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
public class Ejercicio1{

	private final static String nombreBaseDatos = "tienda_informatica";
	private final static String tablas[] = {"fabricantes", "articulos"};
	private final static String atributo = "nombre = 'Asus'";
	private final static String identificador = "codigo = 1";
	private final static String registros[] = {"(1,'Sony'),(2,'Creative Labs'),(3,'Hewlett-Packard'),(4,'Iomega'),(5,'Fujitsu'),(6,'Winchester')","(1,'Hard drive',240,5),(2,'Memory',120,6),(3,'ZIP drive',150,4),(4,'Floppy disk',5,6),(5,'Monitor',240,1),(6,'DVD drive',180,2),(7,'CD drive',90,2),(8,'Printer',270,3),(9,'Toner cartridge',66,3),(10,'DVD burner',180,2)"};
	private final static String scriptTabla[] = {"(\r\n"
			+ "codigo INT NOT NULL,\r\n"
			+ "nombre NVARCHAR (100) NOT NULL,\r\n"
			+ "PRIMARY KEY (codigo)\r\n"
			+ ")ENGINE=InnoDB;","(\r\n"
					+ "codigo INT,\r\n"
					+ "nombre NVARCHAR (100) NOT NULL,\r\n"
					+ "precio INT NOT NULL,\r\n"
					+ "fabricante INT NOT NULL,\r\n"
					+ "PRIMARY KEY (codigo),\r\n"
					+ "FOREIGN KEY (fabricante) REFERENCES fabricantes (codigo)\r\n"
					+ "ON DELETE CASCADE ON UPDATE CASCADE\r\n"
					+ ")ENGINE=InnoDB;"};
	private final static int camposTabla1 = 2;
	private ServicioBD servicioBD;

	/**
	 * @param servicioBD
	 * @param conexion
	 */
	public Ejercicio1(ServicioBD servicioBD) {
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
