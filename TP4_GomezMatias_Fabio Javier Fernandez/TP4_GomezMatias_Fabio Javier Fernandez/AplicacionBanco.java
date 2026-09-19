import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
/**
 * Modelado de la interfaz publica de la aplicacion para el banco.
 * 
 * @author (Gomez Matias Nicolas, Fernandez Fabio Javier) 
 * @version (v1.0)
 */
public class AplicacionBanco
{
    public static void main(String[] args){
        Localidad localidad = new Localidad("Corrientes", "Corrientes");
        Calendar fecha = new GregorianCalendar(2024, Calendar.MARCH, 15);
        Empleado empleado = new Empleado(532005434,"Perez", "Lorena", 120000, fecha);
        
        Banco banco = new Banco("BBVA", localidad, 32, empleado);
        Scanner teclado = new Scanner(System.in);
        int opcion = -1;
        
        do{
            menuBanco(banco);
            opcion = teclado.nextInt();
            
            switch(opcion){
                case 1:
                    banco.mostrar();
                    break;
                case 2:
                    darAltaEmpleado(teclado, banco);
                    break;
                case 3: 
                    darBajaEmpleado(teclado, banco);
                    break;
                case 4: 
                    agregarCuentaBancaria(teclado, banco);
                    break;
                case 5: 
                    agregarOtraCuentaATitular(teclado, banco);
                    break;
                case 6: 
                    eliminarCuentaBancaria(teclado, banco);
                    break;
                case 7: 
                    banco.mostrarResumen();
                    break;
                case 0:
                    System.out.println("Cerrando el software");
                    break;
                    default:
                        System.out.println("Opción inválida.");
            }
        }while(opcion != 0);
        
        
    }
    
    
    public static void agregarCuentaBancaria(Scanner teclado, Banco banco){
        teclado.nextLine();
        System.out.println("---- Datos del titular ---");
            System.out.println("Ingrese dni del titular: ");
            int dni = teclado.nextInt();
            teclado.nextLine();
            
            System.out.println("Apellido: ");
            String apeTitular = teclado.nextLine();
            
            System.out.println("Nombre: ");
            String nomTitular = teclado.nextLine();
            
            
            System.out.println("Fecha de nacimiento ");
            System.out.println("Dia: ");
            Calendar fechaNacimineto = new GregorianCalendar();
            fechaNacimineto .set(Calendar.DAY_OF_MONTH, teclado.nextInt());
            
            System.out.println("mes: ");
            fechaNacimineto .set(Calendar.MONTH, teclado.nextInt() - 1);
            
            System.out.println("año: ");
            fechaNacimineto.set(Calendar.YEAR, teclado.nextInt());
            Persona titular = new Persona(dni, nomTitular, apeTitular, fechaNacimineto);
            
            System.out.println("ingrese numero de cuenta ");
            int nroCuenta = teclado.nextInt();
            teclado.nextLine();
            
            System.out.println("¿Desea crear la cuenta con un saldo activo? (Y = SI / N= NO");
            String accion = teclado.nextLine();
            
            CuentaBancaria nuevaCuenta;
            if(accion.equals("Y") || accion.equals("y")){
               System.out.println("Ingrese el saldo a la cuenta ");
               double saldo = teclado.nextDouble();
               teclado.nextLine();
               nuevaCuenta = new CuentaBancaria(nroCuenta, titular, saldo);
            } else {
                nuevaCuenta = new CuentaBancaria(nroCuenta, titular);
            }
        
            System.out.println(banco.agregarCuentaBancaria(nuevaCuenta) ? "Cuenta agregada con exito ": "Ocurrio un error al agregar la cuenta");
    }
    
    public static void agregarOtraCuentaATitular(Scanner teclado, Banco banco){
        teclado.nextLine();
        System.out.println("Ingrese el D.N.I. del titular al que desea crear la nueva cuenta");
        int dniBuscado = teclado.nextInt();
        teclado.nextLine();
        
        Persona titularExistente = null;
        
        for(CuentaBancaria t : banco.getCuentas()){
            if( t.getTitular().getDNI() == dniBuscado){
                titularExistente = t.getTitular();
                break;
            }
        }
        
        if (titularExistente == null) {
                System.out.println("No se encontró ningún titular con ese DNI.");
                return;
            }
            
            System.out.println("ingrese numero de cuenta ");
            int nroCuenta = teclado.nextInt();
            teclado.nextLine();
            System.out.println("¿Desea crear la cuenta con un saldo activo? (Y = SI / N= NO");
            String accion = teclado.nextLine();
            
            CuentaBancaria nuevaCuenta;
            if(accion.equals("Y") || accion.equals("y")){
               System.out.println("Ingrese el saldo a la cuenta ");
               double saldo = teclado.nextDouble();
               teclado.nextLine();
               nuevaCuenta = new CuentaBancaria(nroCuenta, titularExistente, saldo);
            } else {
                nuevaCuenta = new CuentaBancaria(nroCuenta, titularExistente);
            }
        
            System.out.println(banco.agregarCuentaBancaria(nuevaCuenta) ? "Cuenta agregada con exito ": "Ocurrio un error al agregar la cuenta");
            
    }
    
    
    public static void eliminarCuentaBancaria(Scanner teclado, Banco banco){
        teclado.nextLine();
        int i = 0;
        System.out.println("--- Lista de cuentas ---");
        for(CuentaBancaria c : banco.getCuentas()){
            System.out.println((i + 1) + ") " + " " + c.toString());
            i++;
        }
        System.out.println("Ingrese el indice de la cuenta a eliminar ");
        int indice = teclado.nextInt();
        teclado.nextLine();
        System.out.println(banco.quitarCuentaBancaria(banco.getCuentas().get(indice - 1)) ? "Se elimino correctamente la cuenta" : "Hubo un error al querer eliminar la cuenta");
    }
    
    
    
    
    
    
    
    
    
    
    public static void menuBanco(Banco banco){
            System.out.println("--- Menu del banco: " + banco.getNombre() +" " + "---");
            System.out.println("1) Mostrar nomina de sueldos a pagar");
            System.out.println("2) Registrar un empleado");
            System.out.println("3) Dar de baja a un empleado");
            System.out.println("4) Agregar Cuenta Bancaria");
            System.out.println("5) Agregar Cuenta Bancaria a un titular ya existente");
            System.out.println("6) Eliminar cuenta Bancaria");
            System.out.println("7) Mostrar resumenes de cuentas bancarias");
            System.out.println("0) Salir");
            System.out.print("Ingrese opción: ");
    }
    
    public static void darAltaEmpleado(Scanner teclado, Banco banco){
        teclado.nextLine();
        
            System.out.println("Ingrese Cuil: ");
            long cuil = teclado.nextLong();
            teclado.nextLine();
            
            System.out.println("Apellido: ");
            String apellido = teclado.nextLine();
            
            System.out.println("Nombre: ");
            String nombre = teclado.nextLine();
            
            System.out.println("Sueldo Basico ");
            double sueldo = teclado.nextDouble();
            
            System.out.println("dia de ingreso: ");
            Calendar fecha = new GregorianCalendar();
            fecha.set(Calendar.DAY_OF_MONTH, teclado.nextInt());
            
            System.out.println("mes de ingreso: ");
            fecha.set(Calendar.MONTH, teclado.nextInt() - 1);
            
            System.out.println("anio de ingreso: ");
            fecha.set(Calendar.YEAR, teclado.nextInt());
            
            Empleado nuevoEmpleado = new Empleado(cuil, apellido, nombre, sueldo, fecha);
            if(banco.agregarEmpleado(nuevoEmpleado)){
               System.out.println("Empleado agregado correctamente.");
            } else {
               System.out.println("Hubo un error al intentar agregar al empleado"); 
            }    
    }
    
    public static void darBajaEmpleado(Scanner teclado, Banco banco){
            teclado.nextLine();
            System.out.println("Ingrese el cuil del empleado a eliminar");
            long cuilDespedido = teclado.nextLong();
            Empleado empleadoDespedido = null;
            for(Empleado e : banco.getEmpleados()){
                if(e.getCuil() == cuilDespedido){
                    empleadoDespedido = e;
                    break;
                }
            }
            
            if (empleadoDespedido == null) {
                System.out.println("No se encontró ningún empleado con ese CUIL.");
                return;
            }
        
            if(banco.quitarEmpleado(empleadoDespedido)){
               System.out.println("Empleado eliminado correctamente.");
            } else {
               System.out.println("Hubo un error al intentar agregar al empleado"); 
            }    
    }
}