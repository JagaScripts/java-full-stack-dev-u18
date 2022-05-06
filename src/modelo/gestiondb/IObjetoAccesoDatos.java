/**
 * 
 */
package modelo.gestiondb;

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
	
	void crearBaseDatos(String nombreBaseDatos);
	
	void crearTablaBaseDatos(String nombreBaseDatos, String scriptTabla, String tabla);
	
	void usarBaseDatos(String nombreBaseDatos);
	

	/**
	 * Función para insertar objetos.
	 *
	 * @param elemento Elemento con los datos que se desean insertar
	 */
	void crearRegistros(String nombreBaseDatos, String tabla, String registros);
	


    /**
     * Función para actualizar un elemento.
     *
     * @param elemento Elemento con los datos que se desean actualizar.
     */
	void actualizarRegistros(String nombreBaseDatos, String tabla, String atributo, String identificador);

    
    
    /**
     * Función para eliminar un objeto.
     *
     * @param id String valor del filtro.
     */
    void eliminarRegistros(String nombreBaseDatos, String tabla, String identificador);

    /**
     * Función para leer registros de la base de datos.
     *
     * @return List con los objetos cargados.*/
    
    String leerTablaBaseDatos(String nombreBaseDatos, String tabla, int numeroAtributos); 

 

  

}
