/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pizzeriadechela.database;

import java.sql.*;
        
// ClassNotFoundException | SQLException e

/**
 *
 * @author Anaiza
 */
public class MysqlBaseDatos {
    
    private Connection _conexion;
    private PreparedStatement _consulta;
    private String _consultaTexto;
    
    private String _nombreBasedatos;
    private String _usuario;
    private String _contrasenia;
    
    
    public MysqlBaseDatos(){
        _consultaTexto = "";
        _nombreBasedatos = "";
        _usuario = "";
        _contrasenia = "";
    }
    
    
    public MysqlBaseDatos setUsername(String valor){
        _usuario = valor;
        return this;
    }
    
    public MysqlBaseDatos setContrasenia(String valor){
        _contrasenia = valor;
        return this;
    }
    
    public MysqlBaseDatos setNombreBasedatos(String valor){
        _nombreBasedatos = valor;
        return this;
    }
    
    public Connection getConexion() {
        try{
            
            if (_conexion != null && !_conexion.isClosed())
                return _conexion;
            
            Class.forName("com.mysql.jdbc.Driver");
            _conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + _nombreBasedatos + "?useSSL=false", _usuario, _contrasenia);
            return _conexion;
        }catch (ClassNotFoundException | SQLException e){
            return null;
        }
    }
    
    
    
    public MysqlBaseDatos crearConsulta(String consulta){
        try{
            _consultaTexto = consulta;
            _consulta = _conexion.prepareStatement(_consultaTexto);
        }catch (SQLException e){
            e.printStackTrace();
        }
        
        return this;
    }

    /*public MysqlBaseDatos crearConsulta(String consulta, String... values){
        try{
            _consultaTexto = consulta;
            _consulta = _conexion.prepareStatement(_consultaTexto);
            for (int i = 0; i < values.length; i++){
                _consulta.setObject(i + 1, values[i]);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        
        return this;
    }*/
    
    public void executar() throws SQLException{
        _consulta.executeUpdate(_consultaTexto);
    }
   
    public ResultSet getResultado(){
        try{
            ResultSet resultado = _consulta.executeQuery(_consultaTexto);
            return resultado;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    
    public void closeConsulta(){
        try{
            _consulta.close();
        }
        catch (SQLException e){
            // Ignorar
        }
    }
    
    public void closeConexion() throws SQLException{
        if (_conexion == null)
            return;
        _conexion.close();
    }
}
