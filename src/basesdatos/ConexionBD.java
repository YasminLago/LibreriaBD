package basesdatos;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Yasmín
 */
public class ConexionBD {
    
    Connection conectar=null; 
    
    /**
     * Metodo que conecta la base de datos con el programa y carga los drivers
     * 
     * @param driver Gestiona el acceso a un servidor Mysql ("com.mysql.jdbc.Driver")
     * @param url Nombre del servidor y nombre de la Base de Datos ("jdbc:mysql://localhost/controldestock";)
     * @param user Usuario de la Base de Datos
     * @param pass Contraseña de la Base de Datos
     * @return Retorna la conexión con la Base de datos
     */
    public Connection ConexionBD(String driver, String url,String user, String pass){
        try {
            Class.forName(driver);
            conectar=DriverManager.getConnection(url,user,pass);
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
        return conectar;
    }
}
