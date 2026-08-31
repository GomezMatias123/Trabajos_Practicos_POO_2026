
/**
 * Write a description of class NuevoCliente here.
 * 
 * @author (Gomez Matias,Fabio Javier Fernandez) 
 * @version (v1.0
 */
public class NuevoCliente
{
public static void main(String []args){
       int DNI = Integer.parseInt(args[0]);
       String apellido = args[1];
       String nombre = args[2];
       double saldo = Double.parseDouble(args[3]);
/**
 * Se instancia un objeto de la clase Cliente llamada "nuevoCliente" y se le ingresa valores a 
 * sus atributos mediante el array args de tipo String, proveniente del metodo ejecutable main 
 * que lo recibe como parametros.
 */
       Cliente nuevoCliente = new Cliente(DNI, apellido, nombre, saldo);
       nuevoCliente.mostrar();
       
/**
* Se prueba el metodo nuevoSaldo y se imprime nuevamente para identificar si el atributo Saldo 
* sufrio la modificacion indicada.
*/
       double nuevoSaldo = Double.parseDouble(args[4]);
       nuevoCliente.nuevoSaldo(nuevoSaldo);
       nuevoCliente.mostrar();
/**
* Se prueba el metodo saldoAgregado y se imprime nuevamente para identificar si el atributo 
* Saldo sufrio la modificacion indicada.
*/       
       double saldoAgregado = Double.parseDouble(args[5]);
       nuevoCliente.agregarSaldo(saldoAgregado);
       nuevoCliente.mostrar();
       
   }
}