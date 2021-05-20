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
public class PizzasDto {
    private Integer _id;
    private String _nombre;
    private String _descripcion;
    private Byte _oferta;
    private Double _precio;
    private String _imagenUrl;

    public Integer getId() {
        return _id;
    }

    public void setId(Integer _id) {
        this._id = _id;
    }

    public String getNombre() {
        return _nombre;
    }

    public void setNombre(String _nombre) {
        this._nombre = _nombre;
    }

    public String getDescripcion() {
        return _descripcion;
    }

    public void setDescripcion(String _descripcion) {
        this._descripcion = _descripcion;
    }

    public Byte getOferta() {
        return _oferta;
    }

    public void setOferta(Byte _oferta) {
        this._oferta = _oferta;
    }

    public Double getPrecio() {
        return _precio;
    }

    public void setPrecio(Double _precio) {
        this._precio = _precio;
    }

    public String getImagenUrl() {
        return _imagenUrl;
    }

    public void setImagenUrl(String _imagenUrl) {
        this._imagenUrl = _imagenUrl;
    }
    
    @Override
    public String toString(){
        return _nombre + "-" + _descripcion;
    }
    
    public PizzasDto(){
    }
}
