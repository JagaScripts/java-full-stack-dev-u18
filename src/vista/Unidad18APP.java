/**
 * 
 */
package vista;

import java.sql.Connection;
import controlador.Ejercicio1;
import controlador.Ejercicio2;
import controlador.Ejercicio3;
import controlador.Ejercicio4;
import controlador.Ejercicio5;
import controlador.Ejercicio6;
import controlador.Ejercicio7;
import controlador.Ejercicio8;
import controlador.Ejercicio9;
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
		
		System.out.println("Ejercicio2 empleados");
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
		
		System.out.println("Ejercicio3 alamacenes");
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
		
		System.out.println("Ejercicio4 películas y salas");
		Ejercicio4 ejercicio4 = new Ejercicio4(servicioDB);
		textoMuestra = ejercicio4.leerBaseDeDatos();
		System.out.println("Imprimimos la tabla");
		System.out.println(textoMuestra);
		ejercicio4.actualizarRegistros();
		textoMuestra = ejercicio4.leerBaseDeDatos();
		System.out.println("Imprimimos la tabla registro actualizado");
		System.out.println(textoMuestra);
		ejercicio4.eliminarRegistros();
		textoMuestra = ejercicio4.leerBaseDeDatos();
		System.out.println("Imprimimos la tabla registro eliminado");
		System.out.println(textoMuestra);

		
		System.out.println("Ejercicio5 directores");
		Ejercicio5 ejercicio5 = new Ejercicio5(servicioDB);
		textoMuestra = ejercicio5.leerBaseDeDatos();
		System.out.println("Imprimimos la tabla");
		System.out.println(textoMuestra);
		ejercicio5.actualizarRegistros();
		textoMuestra = ejercicio5.leerBaseDeDatos();
		System.out.println("Imprimimos la tabla registro actualizado");
		System.out.println(textoMuestra);
		ejercicio5.eliminarRegistros();
		textoMuestra = ejercicio5.leerBaseDeDatos();
		System.out.println("Imprimimos la tabla registro eliminado");
		System.out.println(textoMuestra);
	
		
		System.out.println("Ejercicio6 piezas y proveedores");
		Ejercicio6 ejercicio6 = new Ejercicio6(servicioDB);
		textoMuestra = ejercicio6.leerBaseDeDatos();
		System.out.println("Imprimimos la tabla");
		System.out.println(textoMuestra);
		ejercicio6.actualizarRegistros();
		textoMuestra = ejercicio6.leerBaseDeDatos();
		System.out.println("Imprimimos la tabla registro actualizado");
		System.out.println(textoMuestra);
		ejercicio6.eliminarRegistros();
		textoMuestra = ejercicio6.leerBaseDeDatos();
		System.out.println("Imprimimos la tabla registro eliminado");
		System.out.println(textoMuestra);
	
		
		System.out.println("Ejercicio7 cientificos");
		Ejercicio7 ejercicio7 = new Ejercicio7(servicioDB);
		textoMuestra = ejercicio7.leerBaseDeDatos();
		System.out.println("Imprimimos la tabla");
		System.out.println(textoMuestra);
		ejercicio7.actualizarRegistros();
		textoMuestra = ejercicio7.leerBaseDeDatos();
		System.out.println("Imprimimos la tabla registro actualizado");
		System.out.println(textoMuestra);
		ejercicio7.eliminarRegistros();
		textoMuestra = ejercicio7.leerBaseDeDatos();
		System.out.println("Imprimimos la tabla registro eliminado");
		System.out.println(textoMuestra);
		
		
		System.out.println("Ejercicio8 Grandes almacenes");
		Ejercicio8 ejercicio8 = new Ejercicio8(servicioDB);
		textoMuestra = ejercicio8.leerBaseDeDatos();
		System.out.println("Imprimimos la tabla");
		System.out.println(textoMuestra);
		ejercicio8.actualizarRegistros();
		textoMuestra = ejercicio8.leerBaseDeDatos();
		System.out.println("Imprimimos la tabla registro actualizado");
		System.out.println(textoMuestra);
		ejercicio8.eliminarRegistros();
		textoMuestra = ejercicio8.leerBaseDeDatos();
		System.out.println("Imprimimos la tabla registro eliminado");
		System.out.println(textoMuestra);
		
		
		System.out.println("Ejercicio9 Investigadores");
		Ejercicio9 ejercicio9 = new Ejercicio9(servicioDB);
		textoMuestra = ejercicio9.leerBaseDeDatos();
		System.out.println("Imprimimos la tabla");
		System.out.println(textoMuestra);
		ejercicio9.actualizarRegistros();
		textoMuestra = ejercicio9.leerBaseDeDatos();
		System.out.println("Imprimimos la tabla registro actualizado");
		System.out.println(textoMuestra);
		ejercicio9.eliminarRegistros();
		textoMuestra = ejercicio9.leerBaseDeDatos();
		System.out.println("Imprimimos la tabla registro eliminado");
		System.out.println(textoMuestra);

		
		if (GestionSql.cerrarConexion(conexion)) {
			System.out.println("Se cierra la aplicación");
			System.exit(0);
		};
		
	}

}
