package basesdatos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Yasmín
 */
public class MetodosBaseDatos {

    /**
     *
     * @param driver Gestiona el acceso a un servidor Mysql
     * ("com.mysql.jdbc.Driver")
     * @param url Nombre del servidor y nombre de la Base de Datos
     * ("jdbc:mysql://localhost/controldestock";)
     * @param user Usuario de la Base de Datos
     * @param password Contraseña de la Base de Datos
     * @param usuario Nombre de usuario para acceder al programa
     * @param pass Contraseña para acceder al programa
     * @return Retorna un 1 si la conexión es exitosa
     */
    public static int empleados_login(String driver, String url, String user, String password, String usuario, String pass) {
        int resultado = 0;

        String SSQL = "SELECT * FROM empleado WHERE nombre = '" + usuario + "'AND  clave ='" + pass + "'";
        ConexionBD cc = new ConexionBD();

        try {
            Connection cn = cc.ConexionBD(driver, url, user, password);
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SSQL);
            if (rs.next()) {
                resultado = 1;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        } finally {
            Connection cn = cc.ConexionBD(driver, url, user, password);
            try {
                cn.close();//Cierra la conexión con la base de datos
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
        return resultado;

    }
    
    /**
     * Método para consultar las filas de una tabla
     * 
     * @param driver Gestiona el acceso a un servidor Mysql
     * ("com.mysql.jdbc.Driver")
     * @param url Nombre del servidor y nombre de la Base de Datos
     * ("jdbc:mysql://localhost/controldestock";)
     * @param user Usuario de la Base de Datos
     * @param password Contraseña de la Base de Datos
     * @param table_name Nombre de la tabla sobre la que se quiere hacer la consulta
     * @param column_name Nombre de la columna 
     * @param valorC  Valor de la columna 
     */
    public void select(String driver, String url, String user, String password, String table_name, String column_name, String valorC) {
        ConexionBD cc = new ConexionBD();
        Connection cn = cc.ConexionBD(driver, url, user, password);
        String selec = "SELECT * FROM " + table_name + "WHERE " + column_name + " = '" + valorC + "'";
        try {
            Statement select = cn.createStatement();
            select.executeQuery(selec);
        } catch (SQLException e) {
            System.out.println("Error al modificar");
        }
    }
    
    /**
     * Método para la inserción de articulos nuevos
     * 
     * @param driver Gestiona el acceso a un servidor Mysql
     * ("com.mysql.jdbc.Driver")
     * @param url Nombre del servidor y nombre de la Base de Datos
     * ("jdbc:mysql://localhost/controldestock";)
     * @param user Usuario de la Base de Datos
     * @param password Contraseña de la Base de Datos
     */
    public void insertArticulos(String driver, String url, String user, String password) {
        ConexionBD cc = new ConexionBD();
        Connection cn = cc.ConexionBD(driver, url, user, password);
        String insrt = "INSERT INTO articulo (idarticulo, descripcion, precio, stock, codcategoria) VALUES (?,?,?,?,?)";
        try {
            Statement insert = cn.createStatement();
            insert.executeUpdate(insrt);
        } catch (SQLException e) {
            System.out.println("Error al modificar");
        }
    }

    /**
     * Método para la modificacion de articulos existentes
     * 
     * @param driver Gestiona el acceso a un servidor Mysql
     * ("com.mysql.jdbc.Driver")
     * @param url Nombre del servidor y nombre de la Base de Datos
     * ("jdbc:mysql://localhost/controldestock";)
     * @param user Usuario de la Base de Datos
     * @param password Contraseña de la Base de Datos
     * @param column_name Nombre de la columna en la BD
     * @param valorC Valor de la columna en la BD
     * @param row_name Nombre de la fila en la BD
     * @param valorR  Valor de la fila en la BD
     */
    public void updateArticulo(String driver, String url, String user, String password, String column_name, String valorC, String row_name, String valorR) {
        ConexionBD cc = new ConexionBD();
        Connection cn = cc.ConexionBD(driver, url, user, password);
        String updte = "UPDATE articulo SET " + column_name + "='" + valorC + "' WHERE " + row_name + "='" + valorR + "'";
        try {
            Statement update = cn.createStatement();
            update.executeUpdate(updte);
        } catch (SQLException e) {
            System.out.println("Error al modificar");
        }
    }

    /**
     * Método para eliminar filas de una tabla
     * 
     * @param driver Gestiona el acceso a un servidor Mysql
     * ("com.mysql.jdbc.Driver")
     * @param url Nombre del servidor y nombre de la Base de Datos
     * ("jdbc:mysql://localhost/controldestock";)
     * @param user Usuario de la Base de Datos
     * @param password Contraseña de la Base de Datos
     * @param table_name Nombre de la tabla sobre la que se quiere eliminar algo
     * @param row_name Nombre de la fila 
     * @param valorR  Valor de la fila
     */
    public void delete(String driver, String url, String user, String password, String table_name, String row_name, String valorR) {
        ConexionBD cc = new ConexionBD();
        Connection cn = cc.ConexionBD(driver, url, user, password);
        String delet = "DELETE FROM " + table_name + " WHERE " + row_name + "='" + valorR + "'";
        try {
            Statement delete = cn.createStatement();
            delete.executeUpdate(delet);
        } catch (SQLException e) {
            System.out.println("Error al modificar");
        }
    }

}
