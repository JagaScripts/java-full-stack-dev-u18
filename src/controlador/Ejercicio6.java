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
public class Ejercicio6{

	private final static String nombreBaseDatos = "piezas_y_proveedores";
	private final static String tablas[] = {"piezas", "proveedores","suministra"};
	private final static String atributo = "nombre = 'Ruedas'";
	private final static String identificador = "codigo = 1";
	private final static String registros[] = {"(1, 'Batería'),\r\n"
			+ "(2, 'Bombillas'),\r\n"
			+ "(3, 'Discos de frenos'),\r\n"
			+ "(4, 'Parabrisas'),\r\n"
			+ "(5, 'Indicador de presión de neumáticos'),\r\n"
			+ "(6, 'Faros delanteros'),\r\n"
			+ "(7, 'Bujías'),\r\n"
			+ "(8, 'Mando de llave a distancia'),\r\n"
			+ "(9, 'Tiradores de puertas y seguros de cierre'),\r\n"
			+ "(10,'Fusibles');","('000A', 'Tiendas Aurgi'),\r\n"
					+ "('000B', 'Autoexpress'),\r\n"
					+ "('000C', 'Totcar'),\r\n"
					+ "('000D', 'Oscaro'),\r\n"
					+ "('000E', 'Recambios-expres'),\r\n"
					+ "('000F', 'Norauto'),\r\n"
					+ "('000G', 'Rexbo'),\r\n"
					+ "('000H', 'Piezascochesonline'),\r\n"
					+ "('000I', 'Dosochoauto'),\r\n"
					+ "('001J', 'Recambioclasico');","(1, '000A', 75),\r\n"
							+ "(2, '000B', 15),\r\n"
							+ "(3, '000C', 300),\r\n"
							+ "(4, '000D', 20),\r\n"
							+ "(5, '000E', 60),\r\n"
							+ "(6, '000F', 45),\r\n"
							+ "(7, '000G', 15),\r\n"
							+ "(8, '000H', 55),\r\n"
							+ "(9, '000I', 100),\r\n"
							+ "(10,'001J', 35);"};
	private final static String scriptTabla[] = {"(\r\n"
			+ "codigo INT,\r\n"
			+ "nombre NVARCHAR(100) NOT NULL,\r\n"
			+ "PRIMARY KEY (codigo)\r\n"
			+ ")ENGINE=InnoDB;","(\r\n"
					+ "id CHAR(4),\r\n"
					+ "nombre NVARCHAR(100) NOT NULL,\r\n"
					+ "PRIMARY KEY (id)\r\n"
					+ ")ENGINE=InnoDB;","(\r\n"
							+ "codigo_pieza INT,\r\n"
							+ "id_proveedor CHAR(4),\r\n"
							+ "precio INT DEFAULT NULL,\r\n"
							+ "PRIMARY KEY (codigo_pieza, id_proveedor),\r\n"
							+ "FOREIGN KEY (codigo_pieza) REFERENCES piezas (codigo)\r\n"
							+ "ON DELETE CASCADE ON UPDATE CASCADE,\r\n"
							+ "FOREIGN KEY (id_proveedor) REFERENCES proveedores (id)\r\n"
							+ "ON DELETE CASCADE ON UPDATE CASCADE\r\n"
							+ ")ENGINE=InnoDB;"};
	private final static int camposTabla1 = 2;
	private ServicioBD servicioBD;

	/**
	 * @param servicioBD
	 * @param conexion
	 */
	public Ejercicio6(ServicioBD servicioBD) {
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
