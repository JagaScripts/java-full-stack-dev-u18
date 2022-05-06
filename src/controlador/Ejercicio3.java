/**
 * 
 */
package controlador;

import java.sql.Connection;

import modelo.gestiondb.GestionSql;
import modelo.gestiondb.ServicioBD;

/**
 * java-full-stack-dev-u18 - controlador - Ejercicio1
 *
 * @author Jose Antonio González Alcántara
 * 
 * Fecha de creación 06/05/2022
 */
public class Ejercicio3{

	private final static String nombreBaseDatos = "almacenes";
	private final static String tablas[] = {"almacenes", "cajas"};
	private final static String atributo = "lugar = 'China'";
	private final static String identificador = "codigo = 1";
	private final static String registros[] = {"(1,'Valencia',3),(2,'Barcelona',4),(3,'Bilbao',7),(4,'Los Angeles',2),(5,'San Francisco',8)","('0MN7','Rocks',180,3),('4H8P','Rocks',250,1),('4RT3','Scissors',190,4),('7G3H','Rocks',200,1),('8JN6','Papers',75,1),('8Y6U','Papers',50,3),('9J6F','Papers',175,2),('LL08','Rocks',140,4),('P0H6','Scissors',125,1),('P2T6','Scissors',150,2),('TU55','Papers',90,5)"};
	private final static String scriptTabla[] = {"(codigo INT, lugar NVARCHAR(255) NOT NULL, capacidad INT NOT NULL, PRIMARY KEY (codigo))ENGINE=InnoDB;","(num_referencia NVARCHAR(5),contenido NVARCHAR(255) NOT NULL,valor INT NOT NULL,almacen INT NOT NULL, PRIMARY KEY (num_referencia),FOREIGN KEY (almacen) REFERENCES almacenes (codigo)ON DELETE CASCADE ON UPDATE CASCADE) ENGINE=InnoDB;"};
	
	private ServicioBD servicioBD;

	/**
	 * @param servicioBD
	 * @param conexion
	 */
	public Ejercicio3(ServicioBD servicioBD) {
		this.servicioBD = servicioBD;
		this.servicioBD.crearBaseDatos(nombreBaseDatos);
		for (int i = 0; i < tablas.length; i++) {
			this.servicioBD.crearTablaBaseDatos(nombreBaseDatos, scriptTabla[i], tablas[i]);
			this.servicioBD.crearRegistros(nombreBaseDatos, tablas[i], registros[i]);
			
		}
		
	}
	
	public String leerBaseDeDatos() {
		
		return this.servicioBD.leerTablaBaseDatos(nombreBaseDatos, tablas[0], tablas.length);
		
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
