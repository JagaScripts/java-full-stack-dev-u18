/**
 * 
 */
package modelo.gestiondb;

import java.sql.Connection;
import java.sql.Statement;

/**
 * java-full-stack-dev-u18 - modelo.gestiondb - servicioBD
 *
 * @author Jose Antonio González Alcántara
 * 
 * Fecha de creación 29/04/2022
 */
public class ServicioBD implements IObjetoAccesoDatos{
	
	private Connection conexion;
	
	
	
	/**
	 * 
	 */
	public ServicioBD() {
		this.setConexion(conexion);
	}

	/**
	 * @param conexion
	 */
	public ServicioBD(Connection conexion) {
		this.setConexion(conexion);
	}

	@Override
	public void usarDB(String bd) {
	

		
	}

	@Override
	public void crearDB(String bd) {
		
		try {
			System.out.println(this.getConexion().isClosed());
			System.out.println("Conexion: ");
			String query = "CREATE DATABASE IF NOT EXISTS " + bd ;
			Statement statement = this.getConexion().createStatement();
			statement.executeUpdate(query);
		}catch (Exception e) {
			System.out.println("Ha habido un error al crear la Base de datos" + e.getMessage());
		}

	/*at.executeDpda te (Query);eloseConnection(

	MysLCOnne ction ("zoot",. name)

	TOptionPane. ahowNe asageDialog (null, *3e ha creado la base de datos name +" de forma exite
			oatch (3QLException ex)
			Logger.getlogger (Myagt.clanm. getName ())-log (Lerel. aEVERE, null, ex)*/
			
		
	}
	
	/**
	 * @return the conexion
	 */
	public Connection getConexion() {
		return conexion;
	}

	/**
	 * @param conexion the conexion to set
	 */
	public void setConexion(Connection conexion) {
		this.conexion = conexion;
	}
	
}

