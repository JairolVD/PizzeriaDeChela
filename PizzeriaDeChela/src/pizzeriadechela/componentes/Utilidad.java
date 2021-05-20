package pizzeriadechela.componentes;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Anaiza
 */
public class Utilidad {
    
    private static Boolean validarTamanio(String valor, int min, int max){
        return !(valor.length() < min || valor.length() > max);
    }
    
    private static Boolean validarSoloLetras(String valor){
        for (int i = 0; i < valor.length(); i++)
	{
            char caracter = valor.toUpperCase().charAt(i);
			int valorASCII = (int)caracter;
			if (valorASCII != 165 && (valorASCII < 65 || valorASCII > 90))
				return false;
	}
        return true; // Son solo letras
    }
    
    private static Boolean validarSoloNumeros(String valor){
        for (int i = 0; i < valor.length(); i++)
	{
            char caracter = valor.toUpperCase().charAt(i);
			int valorASCII = (int)caracter;
			if (valorASCII < 48 || valorASCII > 57)
				return false;
	}
        return true;
    }
    
    public static Boolean validarDNI(String dni){
        return (validarTamanio(dni, 8, 8) && validarSoloNumeros(dni));
    }
    
    public static String getCadena(char[] chars){
        return new String(chars);
    }
    
    public static Boolean validarContrasenia(String contra){
        return validarTamanio(contra, 4, 16);
    }
    
    public static Boolean validarContrasenias(String value1, String value2){
        if (!validarContrasenia(value1) && !validarContrasenia(value2))
            return false;
        
        return value1.equals(value2);
    }
    
    public static Boolean validarNombres(String nombres){
        return (validarTamanio(nombres.replace(" ", ""), 4, 30) && validarSoloLetras(nombres.replace(" ", "")));
    }
    
    public static Boolean validarApellido(String apellido){
        return (validarTamanio(apellido, 3, 30) && validarSoloLetras(apellido));
    }
    
    public static Boolean validarDistrito(String distrito){
        return (validarTamanio(distrito, 4, 30) && validarSoloLetras(distrito));
    }
    
    public static Boolean validarDireccion(String direccion){
        return (validarTamanio(direccion, 4, 100));
    }
    
    public static Boolean validarCelular(String celular){
        return (validarTamanio(celular, 9, 9) && validarSoloNumeros(celular));
    }
    
    public static Boolean validarCantidad(String cantidad){
        return (validarTamanio(cantidad, 1, 2) && validarSoloNumeros(cantidad));
    }
    
    public static Boolean validarCargoTrabajador(String cargo){
        try {
		Byte value = Byte.parseByte(cargo);
                if (value < 1)
                    return false;
                
		return true;
	} catch (NumberFormatException nfe){
		return false;
	}
    }
    
    public static Byte toByte(String valor){
        try {
		return Byte.parseByte(valor);
	} catch (NumberFormatException nfe){
		return 0;
	}
    }
}
