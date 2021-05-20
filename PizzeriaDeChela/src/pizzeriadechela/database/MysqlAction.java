/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pizzeriadechela.database;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import pizzeriadechela.database.data.*;

/**
 *
 * @author Anaiza
 */
public class MysqlAction extends MysqlBaseDatos {
    
    public MysqlAction(){
    }
    
    public Boolean addPedido(PedidosDto dto){
        try{
            this.crearConsulta(
                    "INSERT INTO pizza_detalle (PizzaId, MetodoPago, Tamanio, Cantidad) VALUES" + 
                    "('" + dto.getDetalle().getPizzaId() + "'," +
                    "'"  + dto.getDetalle().getMetodoPago() + "'," +
                    "'"  + dto.getDetalle().getTamanio()+ "'," +        
                    "'"  + dto.getDetalle().getCantidad() + "')"
                ).executar();
            this.closeConsulta();
            
            ResultSet resultado = this.crearConsulta("SELECT MAX(Id) AS Id FROM pizza_detalle").getResultado();
            resultado.next();
            dto.getDetalle().setId(resultado.getInt(1));
            
            this.closeConsulta();
            
            this.crearConsulta(
                    "INSERT INTO pedidos (DNI_C, DNI_V, PizzaDetalleId) VALUES" + 
                    "('" + dto.getDniC()+ "'," +
                    "'"  + dto.getDniV() + "'," +
                    "'"  + dto.getDetalle().getId() + "')"
                ).executar();
            
            resultado = this.crearConsulta("SELECT MAX(Id) AS Id FROM pedidos").getResultado();
            resultado.next();
            dto.setId(resultado.getInt(1));
            this.closeConsulta();
            
            Calendar calendar = Calendar.getInstance();
            String fecha = calendar.getTime().toString();
            
            this.crearConsulta(
                    "INSERT INTO comprobante (PedidoId, Fecha) VALUES" + 
                    "('" + dto.getId() + "'," +
                    "'"  + fecha + "')"
                ).executar();
            
            this.closeConsulta();
            return true;
        } catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    
    public Boolean addCuenta(CuentaDto dto){
        try{
            this.crearConsulta(
                    "INSERT INTO cuentas (DNI, Contrasena, Cargo) VALUES" + 
                    "('" + dto.getDni() + "'," +
                    "'"  +dto.getContrasenia() + "'," +
                    "'"  +dto.getCargo() + "')"
                ).executar();
            
            this.crearConsulta(
                    "INSERT INTO cuenta_perfil (DNI_C, Nombres, Apellido_Paterno, Apellido_Materno, Distrito, Direccion, Celular) VALUES" + 
                    "('" + dto.getDni() + "'," +
                      "'"  + dto.getPerfil().getNombre()+ "'," +
                        "'"  +dto.getPerfil().getApellido_paterno() + "'," +
                        "'"  +dto.getPerfil().getApellido_materno()+ "'," +
                        "'"  +dto.getPerfil().getDistrito() + "'," +
                        "'"  +dto.getPerfil().getDireccion() + "'," +
                        "'"  +dto.getPerfil().getCelular() + "')"
                ).executar();
            this.closeConsulta();
            return true;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    
    public Boolean updateCuenta(CuentaDto dto){
        try{
            this.crearConsulta(
                    "UPDATE cuentas SET " + 
                    "Contrasena='" + dto.getContrasenia() + "'," +
                    "Cargo='" + dto.getCargo() + "' WHERE (DNI= " + dto.getDni() + ")"
                ).executar();
            
            this.crearConsulta(
                    "UPDATE cuenta_perfil SET " + 
                    "Nombres='" + dto.getPerfil().getNombre()+ "'," +
                    "Apellido_Paterno='" + dto.getPerfil().getApellido_paterno() + "'," +
                    "Apellido_Materno='" + dto.getPerfil().getApellido_materno() + "'," +
                    "Distrito='" + dto.getPerfil().getDistrito() + "'," +
                    "Direccion='" + dto.getPerfil().getDireccion() + "'," +
                    "Celular='" + dto.getPerfil().getCelular() + "' WHERE (DNI_C= " + dto.getDni() + ")"
                ).executar();
            this.closeConsulta();
            return true;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    
    public Boolean deleteCuenta(CuentaDto dto){
        try{
            this.crearConsulta("DELETE FROM cuentas WHERE (DNI='"+ dto.getDni() + "')")
                .executar();
            this.closeConsulta();
            return true;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    
    public Boolean deletePedido(PedidosDto dto){
        try{
            this.crearConsulta("DELETE FROM pizza_detalle WHERE (Id='"+ dto.getDetalle().getId() + "')")
                .executar();
            this.closeConsulta();
            return true;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    
    public PedidosDto getPedido(String dni_c, String dni_v){
        try{
            PedidosDto pedidos = new PedidosDto();
            pedidos.setDetalle(new PizzaDetalleDto());
            pedidos.setComprobante(new ComprobanteDto());
            ResultSet resultado = this.crearConsulta(
                    "SELECT * FROM pedidos a JOIN pizza_detalle b ON a.PizzaDetalleId=b.Id JOIN comprobante c ON a.Id=c.PedidoId "
                            + "JOIN pizzas d ON b.PizzaId=d.Id WHERE (DNI_C= '" + dni_c + "' AND DNI_V='" + dni_v + "')").getResultado();
            
            if (!resultado.next())
                return null;
            
            pedidos.setId(resultado.getInt(1));
            pedidos.setDniC(resultado.getString(2));
            pedidos.setDniV(resultado.getString(3));
            pedidos.setPedidoDetalleId(resultado.getInt(4));
            pedidos.getDetalle().setId(resultado.getInt(5));
            pedidos.getDetalle().setPizzaId(resultado.getInt(6));
            pedidos.getDetalle().setMetodoPago(resultado.getByte(7));
            pedidos.getDetalle().setTamanio(resultado.getString(8));
            pedidos.getDetalle().setCantidad(resultado.getByte(9));
            pedidos.getComprobante().setId(resultado.getInt(10));
            pedidos.getComprobante().setPedidoId(resultado.getInt(11));
            pedidos.getComprobante().setFecha(resultado.getString(12));
            pedidos.getDetalle().setPizzas(new PizzasDto());
            pedidos.getDetalle().getPizzas().setId(resultado.getInt(13));
            pedidos.getDetalle().getPizzas().setNombre(resultado.getString(14));
            pedidos.getDetalle().getPizzas().setDescripcion(resultado.getString(15));
            pedidos.getDetalle().getPizzas().setOferta(resultado.getByte(16));
            pedidos.getDetalle().getPizzas().setPrecio(resultado.getDouble(17));
            pedidos.getDetalle().getPizzas().setImagenUrl(resultado.getString(18));
            this.closeConsulta();
            return pedidos;
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    
    public CuentaDto getCuenta( String dni ){
        try{
            CuentaDto cuenta = new CuentaDto();
            CuentaPerfilDto perfil = new CuentaPerfilDto();
            ResultSet resultado = this.crearConsulta(
                    "SELECT * FROM cuentas a JOIN cuenta_perfil b ON a.DNI=b.DNI_C WHERE (a.DNI=" + dni + ")").getResultado();
            
            if (!resultado.next())
                return null;
            
            cuenta.setDni(resultado.getString(1));
            cuenta.setContrasenia(resultado.getString(2));
            cuenta.setCargo(resultado.getByte(3));
            perfil.setDniC(resultado.getString(4));
            perfil.setNombre(resultado.getString(5));
            perfil.setApellido_paterno(resultado.getString(6));
            perfil.setApellido_materno(resultado.getString(7));
            perfil.setDistrito(resultado.getString(8));
            perfil.setDireccion(resultado.getString(9));
            perfil.setCelular(resultado.getString(10));
            cuenta.setPerfil(perfil);
            this.closeConsulta();
            return cuenta;
        }
        catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    
    public ArrayList<CuentaDto> getTrabajadores(){
        try{
            ArrayList<CuentaDto> trabajadores = new ArrayList<CuentaDto>();
            ResultSet resultado = this.crearConsulta(
                    "SELECT * FROM cuentas a JOIN cuenta_perfil b ON a.DNI=b.DNI_C WHERE (a.Cargo=1)"
                ).getResultado();
            
            while (resultado.next()){
                CuentaDto cuenta = new CuentaDto();
                CuentaPerfilDto perfil = new CuentaPerfilDto();
                
                cuenta.setDni(resultado.getString(1));
                cuenta.setContrasenia(resultado.getString(2));
                cuenta.setCargo(resultado.getByte(3));
                perfil.setDniC(resultado.getString(4));
                perfil.setNombre(resultado.getString(5));
                perfil.setApellido_paterno(resultado.getString(6));
                perfil.setApellido_materno(resultado.getString(7));
                perfil.setDistrito(resultado.getString(8));
                perfil.setDireccion(resultado.getString(9));
                perfil.setCelular(resultado.getString(10));
                cuenta.setPerfil(perfil);
                trabajadores.add(cuenta);
            }
            this.closeConsulta();
            return trabajadores;
            
        }catch (Exception e){
            return new ArrayList<CuentaDto>();
        }
    }
    
    public ArrayList<PedidosDto> getPedidos(String dni_c, String dni_v){
        try{
            ArrayList<PedidosDto> pedidos = new ArrayList<PedidosDto>();
            ResultSet resultado = this.crearConsulta(
                    "SELECT * FROM pedidos a JOIN pizza_detalle b ON a.PizzaDetalleId=b.Id JOIN comprobante c ON a.Id=c.PedidoId "
                            + "JOIN pizzas d ON b.PizzaId=d.Id WHERE (DNI_C= '" + dni_c + "' AND DNI_V='" + dni_v + "')").getResultado();
            while (resultado.next()){
                PedidosDto pedido = new PedidosDto();
                pedido.setDetalle(new PizzaDetalleDto());
                pedido.setComprobante(new ComprobanteDto());
                pedido.setId(resultado.getInt(1));
                pedido.setDniC(resultado.getString(2));
                pedido.setDniV(resultado.getString(3));
                pedido.setPedidoDetalleId(resultado.getInt(4));
                pedido.getDetalle().setId(resultado.getInt(5));
                pedido.getDetalle().setPizzaId(resultado.getInt(6));
                pedido.getDetalle().setMetodoPago(resultado.getByte(7));
                pedido.getDetalle().setTamanio(resultado.getString(8));
                pedido.getDetalle().setCantidad(resultado.getByte(9));
                pedido.getComprobante().setId(resultado.getInt(10));
                pedido.getComprobante().setPedidoId(resultado.getInt(11));
                pedido.getComprobante().setFecha(resultado.getString(12));
                pedido.getDetalle().setPizzas(new PizzasDto());
                pedido.getDetalle().getPizzas().setId(resultado.getInt(13));
                pedido.getDetalle().getPizzas().setNombre(resultado.getString(14));
                pedido.getDetalle().getPizzas().setDescripcion(resultado.getString(15));
                pedido.getDetalle().getPizzas().setOferta(resultado.getByte(16));
                pedido.getDetalle().getPizzas().setPrecio(resultado.getDouble(17));
                pedido.getDetalle().getPizzas().setImagenUrl(resultado.getString(18));
                pedidos.add(pedido);
            }
            this.closeConsulta();
            return pedidos;
            
        }catch (Exception e){
            return new ArrayList<PedidosDto>();
        }
    }
    
    public ArrayList<PizzasDto> getPizzas(){
        try{
            ArrayList<PizzasDto> pizzas = new ArrayList<PizzasDto>();
            ResultSet resultado = this.crearConsulta(
                    "SELECT * FROM pizzas LIMIT 0, 1000"
                ).getResultado();
            
            while (resultado.next()){
                PizzasDto pizza = new PizzasDto();
                PizzaDetalleDto detalle = new PizzaDetalleDto();
                
                pizza.setId(resultado.getInt(1));
                pizza.setNombre(resultado.getString(2));
                pizza.setDescripcion(resultado.getString(3));
                pizza.setOferta(resultado.getByte(4));
                pizza.setPrecio(resultado.getDouble(5));
                pizza.setImagenUrl(resultado.getString(6));
                pizzas.add(pizza);
            }
            this.closeConsulta();
            return pizzas;
            
        }catch (Exception e){
            return new ArrayList<PizzasDto>();
        }
    }
    
    public CuentaPerfilDto getCuentaPerfil( String dni ){
        try{
            CuentaPerfilDto dto = new CuentaPerfilDto();
            ResultSet resultado = this.crearConsulta(
                    "SELECT b.* FROM cuentas a JOIN cuenta_perfil b ON a.DNI=b.DNI_C WHERE (a.DNI=" + dni + ")")
                    .getResultado();
            
            if (!resultado.next())
                return null;
            
            dto.setDniC(resultado.getString(1));
            dto.setNombre(resultado.getString(2));
            dto.setApellido_paterno(resultado.getString(3));
            dto.setApellido_materno(resultado.getString(4));
            dto.setDistrito(resultado.getString(5));
            dto.setDireccion(resultado.getString(6));
            dto.setCelular(resultado.getString(7));
            this.closeConsulta();
            return dto;
        }
        catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }
}
