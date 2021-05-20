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
public class PedidosDto {
    private Integer _id;
    private String _dni_c;
    private String _dni_v;
    private Integer _pedidoDetalleId;
    private PizzaDetalleDto _detalle;
    private ComprobanteDto _comprobante;

    public Integer getId() {
        return _id;
    }

    public void setId(Integer _id) {
        this._id = _id;
    }

    public String getDniC() {
        return _dni_c;
    }

    public void setDniC(String _dni_c) {
        this._dni_c = _dni_c;
    }

    public String getDniV() {
        return _dni_v;
    }

    public void setDniV(String _dni_v) {
        this._dni_v = _dni_v;
    }

    public Integer getPedidoDetalleId() {
        return _pedidoDetalleId;
    }

    public void setPedidoDetalleId(Integer _pedidoDetalleId) {
        this._pedidoDetalleId = _pedidoDetalleId;
    }

    public PizzaDetalleDto getDetalle() {
        return _detalle;
    }

    public void setDetalle(PizzaDetalleDto _detalle) {
        this._detalle = _detalle;
    }

    public ComprobanteDto getComprobante() {
        return _comprobante;
    }

    public void setComprobante(ComprobanteDto _comprobante) {
        this._comprobante = _comprobante;
    }
    
    @Override
    public String toString(){
        return getDniC() + "|" + getDetalle().getPizzas().toString();
    }
    
    public PedidosDto(){
    }
}
