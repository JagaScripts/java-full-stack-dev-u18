/**
 * 
 */
package vista;

import java.sql.Connection;
import controlador.Ejercicio1;
import controlador.Ejercicio2;
import controlador.Ejercicio3;
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
		
		
		
		String  textoMuestra;
		Connection conexion = GestionSql.abrirConexion();
		ServicioBD servicioDB = new ServicioBD(conexion);
		
		System.out.println("Ejercicio1 Tienda informatica");
		Ejercicio1 ejercicio1 = new Ejercicio1(servicioDB);
		textoMuestra = ejercicio1.leerBaseDeDatos();
		System.out.println("Imprimimos la tabla");
		System.out.println(textoMuestra);
		ejercicio1.actualizarRegistros();
		textoMuestra = ejercicio1.leerBaseDeDatos();
		System.out.println("Imprimimos la tabla registro actualizado");
		System.out.println(textoMuestra);
		ejercicio1.eliminarRegistros();
		textoMuestra = ejercicio1.leerBaseDeDatos();
		System.out.println("Imprimimos la tabla registro eliminado");
		System.out.println(textoMuestra);
		ejercicio1.eliminarBaseDatos();
		
		System.out.println("Ejercicio2 Tienda informatica");
		Ejercicio2 ejercicio2 = new Ejercicio2(servicioDB);
		textoMuestra = ejercicio2.leerBaseDeDatos();
		System.out.println("Imprimimos la tabla");
		System.out.println(textoMuestra);
		ejercicio2.actualizarRegistros();
		textoMuestra = ejercicio2.leerBaseDeDatos();
		System.out.println("Imprimimos la tabla registro actualizado");
		System.out.println(textoMuestra);
		ejercicio2.eliminarRegistros();
		textoMuestra = ejercicio2.leerBaseDeDatos();
		System.out.println("Imprimimos la tabla registro eliminado");
		System.out.println(textoMuestra);
		ejercicio2.eliminarBaseDatos();
		
		System.out.println("Ejercicio3 Tienda informatica");
		Ejercicio3 ejercicio3 = new Ejercicio3(servicioDB);
		textoMuestra = ejercicio3.leerBaseDeDatos();
		System.out.println("Imprimimos la tabla");
		System.out.println(textoMuestra);
		ejercicio3.actualizarRegistros();
		textoMuestra = ejercicio3.leerBaseDeDatos();
		System.out.println("Imprimimos la tabla registro actualizado");
		System.out.println(textoMuestra);
		ejercicio3.eliminarRegistros();
		textoMuestra = ejercicio3.leerBaseDeDatos();
		System.out.println("Imprimimos la tabla registro eliminado");
		System.out.println(textoMuestra);
		ejercicio3.eliminarBaseDatos();
		
		if (GestionSql.cerrarConexion(conexion)) {
			System.out.println("Se cierra la aplicación");
			System.exit(0);
		};
		
	}

}
