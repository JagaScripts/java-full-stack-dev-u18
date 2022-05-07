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
public class Ejercicio8{

	private final static String nombreBaseDatos = "grandes_almacenes";
	private final static String tablas[] = {"cajeros","productos","maquinas_registradoras","venta"};
	private final static String atributo = "nombre_completo = 'Juan Alcántara Fernandez'";
	private final static String identificador = "codigo = '12345610'";
	private final static String registros[] = {"(12345684, 'Jose González Ruiz'),\r\n"
			+ "(12345685, 'Daniel Fernandez Lujan'),\r\n"
			+ "(12345686, 'Joan Hurtado Martín'),\r\n"
			+ "(12345687, 'Miguel Alcántara Garrido'),\r\n"
			+ "(12345688, 'Gerard Martinez Soja'),\r\n"
			+ "(12345689, 'Marc Marquez Sevilla'),\r\n"
			+ "(12345610, 'Veronika Rexbo Tomico'),\r\n"
			+ "(12345611, 'Constant Tomico Rexbo'),\r\n"
			+ "(12345612, 'Octavi Herraiz Llull'),\r\n"
			+ "(12345613, 'Aida Queralt Lozano'),\r\n"
			+ "(12345696, 'Adria Ruiz Esteban');","(1,\"Paneles solares y cargadores\",54),\r\n"
					+ "(2,\"Llaveros inteligentes\",45),\r\n"
					+ "(3,\"Altavoces portátiles\",23),\r\n"
					+ "(4,\"Termómetros para bebés\",98),\r\n"
					+ "(5,\"Asientos de automóvil\",57),\r\n"
					+ "(6,\"Cortaúñas para bebés\",22),\r\n"
					+ "(7,\"Camas para mascotas\",30),\r\n"
					+ "(8,\"Cuencos de alimentación personalizados\",54),\r\n"
					+ "(9,\"Collares de entrenamiento\",34),\r\n"
					+ "(10,\"Mochilas\",34);","(1,1),\r\n"
							+ "(2,2),\r\n"
							+ "(3,3),\r\n"
							+ "(4,4),\r\n"
							+ "(5,5),\r\n"
							+ "(6,6),\r\n"
							+ "(7,7),\r\n"
							+ "(8,8),\r\n"
							+ "(9,9),\r\n"
							+ "(10,10);","(12345684, 1, 7),\r\n"
									+ "(12345688, 3, 5),\r\n"
									+ "(12345684, 2, 4),\r\n"
									+ "(12345688, 5, 4),\r\n"
									+ "(12345684, 7, 4),\r\n"
									+ "(12345688, 9, 4),\r\n"
									+ "(12345684, 10, 4),\r\n"
									+ "(12345684, 8, 3),\r\n"
									+ "(12345696, 7, 2),\r\n"
									+ "(12345688, 1, 1);"};
	private final static String scriptTabla[] = {"(\r\n"
			+ "codigo INT,\r\n"
			+ "nombre_completo NVARCHAR(255) NOT NULL,\r\n"
			+ "PRIMARY KEY (codigo)\r\n"
			+ ")ENGINE=InnoDB;","(\r\n"
			+ "codigo INT,\r\n"
			+ "nombre NVARCHAR(100) NOT NULL,\r\n"
			+ "precio INT NOT NULL,\r\n"
			+ "PRIMARY KEY (codigo)\r\n"
			+ ")ENGINE=InnoDB;","(\r\n"
					+ "codigo INT,\r\n"
					+ "piso INT NOT NULL,\r\n"
					+ "PRIMARY KEY (codigo)\r\n"
					+ ")ENGINE=InnoDB;","(\r\n"
									+ "cajero INT,\r\n"
									+ "maquina INT,\r\n"
									+ "producto INT,\r\n"
									+ "PRIMARY KEY (cajero , maquina, producto),\r\n"
									+ "FOREIGN KEY (cajero) REFERENCES cajeros (codigo)\r\n"
									+ "ON DELETE CASCADE ON UPDATE CASCADE,\r\n"
									+ "FOREIGN KEY (maquina) REFERENCES maquinas_registradoras (codigo)\r\n"
									+ "ON DELETE CASCADE ON UPDATE CASCADE,\r\n"
									+ "FOREIGN KEY (producto) REFERENCES productos (codigo)\r\n"
									+ "ON DELETE CASCADE ON UPDATE CASCADE\r\n"
									+ ")ENGINE=InnoDB;"};
	private final static int camposTabla1 = 2;
	private ServicioBD servicioBD;

	/**
	 * @param servicioBD
	 * @param conexion
	 */
	public Ejercicio8(ServicioBD servicioBD) {
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
