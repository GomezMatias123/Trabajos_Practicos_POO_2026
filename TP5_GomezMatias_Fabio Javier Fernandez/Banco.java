import java.util.Scanner;
import java.util.Random;
import java.util.GregorianCalendar;
import java.util.Calendar;
/**
 *  Clase Blanco con el ejecutable para poder enviar mensajes a las demas clases relacionadas (cuenta corriente, caja de ahorro y cuenta bancaria).
 * 
 * @author (Gomez Matias, Fabio Javier Fernandez) 
 * @version (v1.0)
 */
public class Banco
{
        public static void main(String[] args) {
        

        //instanciar Persona (titular)
        System.out.println("----- Registro del titular de las cuentas -----");
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese su nombre");
        String nombre = teclado.nextLine();
        System.out.println("Ingrese su apellido");
        String apellido = teclado.nextLine();
        System.out.println("Ingrese su numero de documento");
        int nroDni = teclado.nextInt();
        
        System.out.println("Ingrese el numero del dia de su nacimiento:");
        int dia = teclado.nextInt();
        System.out.println("Ingrese el numero del mes de nacimiento (1-12):");
        int mes = teclado.nextInt();
        System.out.println("Ingrese su año de nacimiento");
        int anio = teclado.nextInt();
        teclado.nextLine();
        
        Calendar fechaNacimiento = new GregorianCalendar(anio, mes - 1, dia);
        Persona persona = new Persona(nroDni, nombre, apellido, fechaNacimiento);
        
        //  instanciar CajaDeAhorro para el titular
        CajaDeAhorro cajaDeAhorro;
        Random generadorNumeros = new Random();
        int nuevoNroCuenta = generadorNumeros.nextInt(9000) + 1000;
        
        System.out.println("----- Caja de ahorro -----");
        
        System.out.println("ingrese saldo inicial a depositar caso contrario solo coloque el valor: 0");
        double saldoInicial = teclado.nextDouble(); 
        teclado.nextLine();
        if(saldoInicial > 0){
             cajaDeAhorro = new CajaDeAhorro(nuevoNroCuenta, persona, saldoInicial);
        } else {
             cajaDeAhorro = new CajaDeAhorro(nuevoNroCuenta, persona);
        }
        
        CuentaCorriente cuentaCorriente;
        generadorNumeros = new Random();
        nuevoNroCuenta = generadorNumeros.nextInt(9000) + 1000;
        
        System.out.println("----- Cuenta corriente -----");
        
        System.out.println("ingrese saldo inicial a depositar caso contrario solo coloque el valor: 0");
        saldoInicial = teclado.nextDouble(); 
        teclado.nextLine();
        if(saldoInicial > 0){
             cuentaCorriente = new CuentaCorriente(nuevoNroCuenta, persona, saldoInicial);
        } else {
             cuentaCorriente = new CuentaCorriente(nuevoNroCuenta, persona);
        }
        
            
        int opcion = -1;
         do{
            mostrarMenu(persona);
            opcion = teclado.nextInt();
            
            switch(opcion){
                
                case 1:
                    menuCuentaCorriente(teclado, cuentaCorriente);
                    break;
                case 2: 
                    menuCajaAhorro(teclado, cajaDeAhorro);
                    break;
                case 0:
                    System.out.println("Sesion terminada");
                    break;
                    default:
                        System.out.println("Opción inválida.");
            }
        }while(opcion != 0);
         
         
        
    }
    
    private static void mostrarMenu(Persona persona){
            System.out.println("--- Cuenta de banco ---");
           if(persona.esCumpleaños()){
            System.out.println("------------------------------");
            System.out.println("Feliz Cumpleaños Sr/Sra " + persona.nomYApe());
            System.out.println("------------------------------");
            } 
            System.out.println("Titular: ");
            persona.mostrar();
            System.out.println("1) Para ingresar a la Cuenta Corriente");
            System.out.println("2) Para ingresar a la Caja de Ahorro");
            System.out.println("0) Cerrar sesion");
            Calendar fechaHoy = new GregorianCalendar();
            System.out.print("Ingrese opción: ");
    }
        
    private static void menuCuentaCorriente(Scanner teclado, CuentaCorriente cuentaCorriente){
        teclado.nextLine();
        int accion = -1;
        do{
            System.out.println("--- Cuenta Corriente ---");
            cuentaCorriente.mostrar();
            System.out.println("--------------------------");
            System.out.println("1) Depositar dentro del saldo");
            System.out.println("2) Extraer dinero del saldo");
            System.out.println("0) Volver al menu");
            System.out.print("Ingrese opción: ");
            accion = teclado.nextInt();
            
            switch(accion){
                case 1:
                    teclado.nextLine();
                    System.out.println("ingrese el monto a depositar: $");
                    double deposito = teclado.nextDouble();
                    cuentaCorriente.depositar(deposito);
                    break;
                case 2:
                    teclado.nextLine();
                    System.out.println("ingrese el monto a extraer: $");
                    double extraccion = teclado.nextDouble();
                    cuentaCorriente.extraer(extraccion);
                    break;
                case 0:
                    System.out.println("Volviendo al menu principal");
                    break;
                    default:
                        System.out.println("Opción inválida.");
            }
        }while(accion != 0);
    }
    
    private static void menuCajaAhorro(Scanner teclado, CajaDeAhorro cajaDeAhorro){
        teclado.nextLine();
        int accion = -1;
        do{
            System.out.println("--- Caja de ahorro ---");
            cajaDeAhorro.mostrar();
            System.out.println("--------------------------");
            System.out.println("1) Depositar dentro del saldo");
            System.out.println("2) Extraer dinero del saldo");
            System.out.println("0) Volver al menu");
            System.out.print("Ingrese opción: ");
            accion = teclado.nextInt();
            
            switch(accion){
                case 1:
                    teclado.nextLine();
                    System.out.println("ingrese el monto a depositar: $");
                    double deposito = teclado.nextDouble();
                    cajaDeAhorro.depositar(deposito);
                    break;
                case 2:
                    teclado.nextLine();
                    System.out.println("ingrese el monto a extraer: $");
                    double extraccion = teclado.nextDouble();
                    cajaDeAhorro.extraer(extraccion);
                    break;
                case 0:
                    System.out.println("Volviendo al menu principal");
                    break;
                    default:
                        System.out.println("Opción inválida.");
            }
        }while(accion != 0);
    }
    
}