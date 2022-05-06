/**
 * 
 */
package vista;

import java.sql.Connection;
import java.sql.SQLException;

import modelo.gestiondb.GestionSql;
import modelo.gestiondb.ServicioBD;

/**
 * java-full-stack-dev-u18 - vista - unidad18APP
 *
 * @author Jose Antonio González Alcántara
 * 
 * Fecha de creación 29/04/2022
 */
public class Unidad18APP {

	/**
	 * @param args
	 */
	public static void main(String[] args){
		
		
		Connection conexion = GestionSql.abrirConexion();
		ServicioBD servicioDB = new ServicioBD(conexion);
		servicioDB.crearDB("Prueba");
		if (GestionSql.cerrarConexion(conexion)) {
			System.out.println("Se cierra la aplicación");
			System.exit(0);
		};
		
	}

}
