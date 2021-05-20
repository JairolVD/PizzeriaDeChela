/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pizzeriadechela.database.data;

/**
 *
 * @author Anaiza
 */
public class CuentaPerfilDto {
    private String _dni_c;
    private String _nombre;
    private String _apellido_paterno;
    private String _apellido_materno;
    private String _distrito;
    private String _direccion;
    private String _celular;

    public String getDniC() {
        return _dni_c;
    }

    public void setDniC(String _dni_c) {
        this._dni_c = _dni_c;
    }

    public String getNombre() {
        return _nombre;
    }

    public void setNombre(String _nombre) {
        this._nombre = _nombre;
    }

    public String getApellido_paterno() {
        return _apellido_paterno;
    }

    public void setApellido_paterno(String _apellido_paterno) {
        this._apellido_paterno = _apellido_paterno;
    }

    public String getApellido_materno() {
        return _apellido_materno;
    }

    public void setApellido_materno(String _apellido_materno) {
        this._apellido_materno = _apellido_materno;
    }

    public String getDistrito() {
        return _distrito;
    }

    public void setDistrito(String _distrito) {
        this._distrito = _distrito;
    }

    public String getDireccion() {
        return _direccion;
    }

    public void setDireccion(String _direccion) {
        this._direccion = _direccion;
    }

    public String getCelular() {
        return _celular;
    }

    public void setCelular(String _celular) {
        this._celular = _celular;
    }
    
    @Override
    public String toString(){
        return _nombre;
    }
    
    
    
    public CuentaPerfilDto(){
        _dni_c = "";
        _nombre = "";
        _apellido_paterno = "";
        _apellido_materno = "";
        _distrito = "";
        _direccion = "";
        _celular = "";
    }
}
