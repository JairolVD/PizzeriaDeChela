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
public class ComprobanteDto {
    private Integer _id;
    private Integer _pedidoId;
    private PedidosDto _pedido;
    
    private String _fecha;

    public Integer getId() {
        return _id;
    }

    public void setId(Integer _id) {
        this._id = _id;
    }

    public Integer getPedidoId() {
        return _pedidoId;
    }

    public void setPedidoId(Integer _pedidoId) {
        this._pedidoId = _pedidoId;
    }

    public String getFecha() {
        return _fecha;
    }

    public void setFecha(String _fecha) {
        this._fecha = _fecha;
    }

    public PedidosDto getPedido() {
        return _pedido;
    }

    public void setPedido(PedidosDto _pedido) {
        this._pedido = _pedido;
    }
    
    public ComprobanteDto(){
    }
}
