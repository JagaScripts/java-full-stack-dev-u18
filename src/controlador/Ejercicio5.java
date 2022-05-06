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
public class Ejercicio5{

	private final static String nombreBaseDatos = "empleados";
	private final static String tablas[] = {"departamentos", "empleados"};
	private final static String atributo = "nombre = 'Altos ejecutivos'";
	private final static String identificador = "codigo = 1";
	private final static String registros[] = {"(14,'IT',65000),(37,'Accounting',15000),(59,'Human Resources',240000),(77,'Research',55000)","(123234877,'Michael','Rogers',14),(152934485,'Anand','Manikutty',14),(222364883,'Carol','Smith',37),(326587417,'Joe','Stevens',37),(332154719,'Mary-Anne','Foster',14),(332569843,'George','O\\'Donnell',77),(546523478,'John','Doe',59),(631231482,'David','Smith',77),(654873219,'Zacary','Efron',59),(745685214,'Eric','Goldsmith',59),(845657233,'Luis','López',14),(845657245,'Elizabeth','Doe',14),(845657246,'Kumar','Swamy',14),(845657266,'Jose','Pérez',77)"};
	private final static String scriptTabla[] = {"(codigo INT, nombre NVARCHAR (100) NOT NULL, presupuesto INT NOT NULL, PRIMARY KEY (codigo))ENGINE=InnoDB;","(DNI NVARCHAR(9), nombre NVARCHAR (100) NOT NULL, apellidos NVARCHAR (255) NOT NULL, departamento INT NOT NULL, PRIMARY KEY (DNI), FOREIGN KEY (departamento) REFERENCES departamentos (codigo) ON DELETE RESTRICT ON UPDATE CASCADE)ENGINE=InnoDB;"};
	
	private ServicioBD servicioBD;

	/**
	 * @param servicioBD
	 * @param conexion
	 */
	public Ejercicio5(ServicioBD servicioBD) {
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
