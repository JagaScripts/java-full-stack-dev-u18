package modelo.gestiondb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * java-full-stack-dev-u18 - modelo.gestiondb - GsetionSql
 *
 * @author Jose Antonio González Alcántara
 * 
 * Fecha de creación 29/04/2022
 */
public class GestionSql {
	
	 	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	    private static final String SERVER = "jdbc:mysql://192.168.1.13:3306/";
	    //private static final String DATABASE = "actividades";
	    private static final String USERNAME = "remote";
	    private static final String PASSWORD = "Reus_2022";
	    //private static final String OPTIONS = "?useTimezone=true&serverTimezone=UTC";
	    private static Connection connection = null;
	    
	    /**
	     * Constructor mínimo.
	     */
	    public GestionSql() {
	        super();
	    }
	    
	    /**
	     * Método para abrir una conexión a la base de datos.
	     *
	     * @return java.sql.Connection conexión o null.
	     */
	    public static Connection abrirConexion(){
	        try {
	            Class.forName(DRIVER);
	            connection = DriverManager.getConnection(SERVER /*+ DATABASE*/ , USERNAME, PASSWORD);
	            System.out.println("La conexión a la base de datos esta abierta");
	            return connection;
	        } catch (ClassNotFoundException ex) {
	            Logger.getLogger(GestionSql.class.getName()).log(Level.SEVERE, 
	                    SQLErrores.ERROR_SQL_DRIVER, ex);
	        } catch (SQLException ex) {
	            Logger.getLogger(GestionSql.class.getName()).log(Level.SEVERE, 
	                    SQLErrores.ERROR_SQL_ABRIR_CONEXION, ex);
	        }
	        System.out.println("La conexión a la base de datos no se ha establecido");
	        return null;
	    }
	    
	    /**
	     * Función para cerrar una conexión a la base de datos.
	     *
	     */
	    public static boolean cerrarConexion(Connection connection){
	        try {
	            connection.close();
	            System.out.println("La conexión a la base de datos se ha cerrado");
	            return true;
	        } catch (SQLException e) {
	             Logger.getLogger(GestionSql.class.getName()).log(Level.SEVERE,
	                        SQLErrores.ERROR_SQL_CERRAR_CONEXION, e);
	        }
	        
	        return false;
	   }

}
