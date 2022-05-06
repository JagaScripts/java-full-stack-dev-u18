/**
 * 
 */
package modelo.gestiondb;

import java.util.Hashtable;
import java.util.List;

/**
 * java-full-stack-dev-u18 - modelo.gestiondb - IObjetoAccesoDatos
 *
 * @author Jose Antonio González Alcántara
 * 
 * Fecha de creación 29/04/2022
 * 
 * Interfaz que define las operaciones de interacción con la base de datos.
 * * @param <T> Tipo de datos que manejará.
 * 
 */
public interface IObjetoAccesoDatos {
	
	void usarDB(String bd);

	/**
	 * Función para insertar objetos.
	 *
	 * @param elemento Elemento con los datos que se desean insertar
	 */
	void crearDB(String bd);

    /**
     * Función para actualizar un elemento.
     *
     * @param elemento Elemento con los datos que se desean actualizar.
     */
   //void cearTabla(String db, String nombre, Hashtable<String, String> tablaPropiedades);

    //void crearRegistros();
    
    /**
     * Función para eliminar un objeto.
     *
     * @param id String valor del filtro.
     */
    //void eliminarRegistros(String id);

    /**
     * Función para cargar todos los objeto.
     *
     * @return List con los objetos cargados.
    
    List<> listarTodos(); */

    /**
     * Función para buscar por dni.
     *
     * @param id String valor del filtro.
     * @return T elemento con los datos asociados que cumplen el criterio.
     
    T obtener(String id);*/

    /**
     * Función que enlaza un ResultSet con un objeto.
     *
     * @param resultSet ResultSet a enlazar
     * @return T elemento con los datos asociados.
  
    T enlazar(ResultSet resultSet);   */
    

}
