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
public class CuentaDto {
    private String _dni;
    private String _contrasenia;
    private Byte _cargo;
    
    private CuentaPerfilDto _perfil;

    public String getDni() {
        return _dni;
    }

    public void setDni(String _dni) {
        this._dni = _dni;
    }

    public String getContrasenia() {
        return _contrasenia;
    }

    public void setContrasenia(String _contrasenia) {
        this._contrasenia = _contrasenia;
    }

    public Byte getCargo() {
        return _cargo;
    }

    public void setCargo(Byte _cargo) {
        this._cargo = _cargo;
    }

    public CuentaPerfilDto getPerfil() {
        return _perfil;
    }

    public void setPerfil(CuentaPerfilDto _perfil) {
        this._perfil = _perfil;
    }
    
    @Override
    public String toString(){
        return _perfil.getNombre() + " " + _perfil.getApellido_paterno() + " " + _perfil.getApellido_materno();
    }
    
    
    public CuentaDto(){
    }
}
