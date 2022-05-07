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
public class Ejercicio7{

	private final static String nombreBaseDatos = "cientificos";
	private final static String tablas[] = {"cientificos", "proyectos","asignado_a"};
	private final static String atributo = "nombre_completo = 'Fernando Martinez Garcia'";
	private final static String identificador = "DNI = '12345610'";
	private final static String registros[] = {"('12345684', 'Jose González Ruiz'),\r\n"
			+ "('12345685', 'Daniel Fernandez Lujan'),\r\n"
			+ "('12345686', 'Joan Hurtado Martín'),\r\n"
			+ "('12345687', 'Miguel Alcántara Garrido'),\r\n"
			+ "('12345688', 'Gerard Martinez Soja'),\r\n"
			+ "('12345689', 'Marc Marquez Sevilla'),\r\n"
			+ "('12345610', 'Veronika Rexbo Tomico'),\r\n"
			+ "('12345611', 'Constant Tomico Rexbo'),\r\n"
			+ "('12345612', 'Octavi Herraiz Llull'),\r\n"
			+ "('12345613', 'Aida Queralt Lozano');","('0001' , 'EL BILLETE QUE ARDE… ¡Y NO SE QUEMA!', 10),\r\n"
					+ "('0002' , 'CAMINAR SOBRE HUEVOS… ¡SIN ROMPERLOS!', 50),\r\n"
					+ "('0003' , 'VIENDO BAILAR A LAS ONDAS DE SONIDO', 60),\r\n"
					+ "('0004' , 'HAZ GEODAS CON HUEVOS', 30),\r\n"
					+ "('0005' , 'CONVERTIR UNA PASTILLA DE JABÓN DE MARFIL EN UNA PALOMITA MONSTRUOSA', 80),\r\n"
					+ "('0006' , '¡LAS PLANTAS CAMBIAN DE COLOR!', 50),\r\n"
					+ "('0007' , 'HACIENDO ENGORDAR A LOS OSITOS DE GOMA (Y OTRAS COSAS PEORES…)', 15),\r\n"
					+ "('0008' , 'ROCK CANDY CASERO… ¡Y CON UN PALO!', 20),\r\n"
					+ "('0009' , 'UNA PLANTA QUE CRECE EN UN CD', 12),\r\n"
					+ "('0010' , 'AGUJEREAR LA BOLSA SIN QUE SE SALGA EL AGUA', 45);\r\n"
					+ "","('12345684','0010',20),\r\n"
							+ "('12345685','0001',100),\r\n"
							+ "('12345686','0002',24),\r\n"
							+ "('12345687','0003',30),\r\n"
							+ "('12345688','0004',100),\r\n"
							+ "('12345689','0005',20),\r\n"
							+ "('12345610','0006',24),\r\n"
							+ "('12345611','0007',22),\r\n"
							+ "('12345612','0008',68),\r\n"
							+ "('12345613','0009',50)"};
	private final static String scriptTabla[] = {"(\r\n"
			+ "DNI VARCHAR(8),\r\n"
			+ "nombre_completo NVARCHAR(255) NOT NULL,\r\n"
			+ "PRIMARY KEY (DNI)\r\n"
			+ ")ENGINE=InnoDB;","(\r\n"
					+ "id CHAR(4),\r\n"
					+ "nombre NVARCHAR(255) NOT NULL,\r\n"
					+ "horas INT NOT NULL,\r\n"
					+ "PRIMARY KEY (id)\r\n"
					+ ")ENGINE=InnoDB;","(\r\n"
							+ "cientifico VARCHAR(8),\r\n"
							+ "proyecto CHAR(4),\r\n"
							+ "precio INT DEFAULT NULL,\r\n"
							+ "PRIMARY KEY (cientifico , proyecto),\r\n"
							+ "FOREIGN KEY (cientifico) REFERENCES cientificos (DNI)\r\n"
							+ "ON DELETE CASCADE ON UPDATE CASCADE,\r\n"
							+ "FOREIGN KEY (proyecto) REFERENCES proyectos (id)\r\n"
							+ "ON DELETE CASCADE ON UPDATE CASCADE\r\n"
							+ ")ENGINE=InnoDB;"};
	private final static int camposTabla1 = 2;
	private ServicioBD servicioBD;

	/**
	 * @param servicioBD
	 * @param conexion
	 */
	public Ejercicio7(ServicioBD servicioBD) {
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
