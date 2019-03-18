
package dao;

import conection.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Mensaje;

/**
 *
 * @author Nimrod
 * 
 */
public class MensajeDAO {
    
    private Connection connection;
    private PreparedStatement statement;
    private boolean estadoOperacion;
    
    public Mensaje obtenerMensaje(int idMensaje) throws SQLException {
        ResultSet resultSet = null;
        Mensaje m = new Mensaje();
        String sql = null;
        estadoOperacion = false;
        connection = obtenerConexion();
        
        try {
            connection.setAutoCommit(false);
            sql = "SELECT*FROM mensaje WHERE id_mensaje=?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1,idMensaje);
            
            resultSet = statement.executeQuery();
            
            if(resultSet.next()) {
                m.setIdMensaje(resultSet.getInt(1));
                m.setArbMensaje(resultSet.getString(2));
                m.setCphMensaje(resultSet.getString(3));
                m.setCpsMensaje(resultSet.getString(4));
                m.setDesMensaje(resultSet.getString(5));
                m.setCrbMensaje(resultSet.getString(6));
            }
            
        }catch(SQLException e) {
            e.printStackTrace();
        }
        
        return m;
    }
    
    /*public List<Mensaje> obtenerMensajes() throws SQLException {
        ResultSet resultSet = null;
        List<Mensaje> listaMensajes = new ArrayList<>();
        String sql = null;
        estadoOperacion = false;
        connection = obtenerConexion();
        
        try {
            connection.setAutoCommit(false);
            sql = "SELECT*FROM mensaje";
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery(sql);
            
            while(resultSet.next()) {
                Mensaje m = new Mensaje();
                
                m.setIdMensaje(resultSet.getInt(1));
                m.setArbMensaje(resultSet.getString(2));
                m.setCphMensaje(resultSet.getString(3));
                m.setCpsMensaje(resultSet.getString(4));
                m.setDesMensaje(resultSet.getString(5));
                m.setCrbMensaje(resultSet.getString(6));
                
                listaMensajes.add(m);
            }
            
        }catch(SQLException e) {
            e.printStackTrace();
        }
        
        return listaMensajes;
    }*/
    
    public boolean editar(Mensaje mensaje) throws SQLException {
        String sql = null;
        estadoOperacion = false;
        connection = obtenerConexion();
        
        try {
            connection.setAutoCommit(false);
            sql = "UPDATE mensaje SET arb_mensaje=?,cph_mensaje=?,cps_mensaje=?,des_mensaje=?,crb_mensaje=? WHERE id_mensaje=?";
            
            statement = connection.prepareStatement(sql);
        
            statement.setString(1, mensaje.getArbMensaje());
            statement.setString(2, mensaje.getCphMensaje());
            statement.setString(3, mensaje.getCpsMensaje());
            statement.setString(4, mensaje.getDesMensaje());
            statement.setString(5, mensaje.getCrbMensaje());
            statement.setInt(6, mensaje.getIdMensaje());
            
            statement.executeUpdate();
            
            estadoOperacion = statement.executeUpdate()>0;
        
            connection.commit();
            statement.close();
            connection.close();
        }catch(SQLException e) {
            connection.rollback();
            e.printStackTrace();
        }
        
        return estadoOperacion;
    }
    
    //get connection
    private Connection obtenerConexion() throws SQLException {
        return Conexion.getConnection();
    }
    
}