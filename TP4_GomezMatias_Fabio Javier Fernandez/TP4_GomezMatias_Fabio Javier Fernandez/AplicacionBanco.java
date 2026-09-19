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
                case 0:
                    System.out.println("Cerrando el software");
                    break;
                    default:
                        System.out.println("Opción inválida.");
            }
        }while(opcion != 0);
        
        
    }
    
    public static void menuBanco(Banco banco){
            System.out.println("--- Menu del banco: " + banco.getNombre() +" " + "---");
            System.out.println("1) Mostrar nomina de sueldos a pagar");
            System.out.println("2) Registrar un empleado");
            System.out.println("3) Dar de baja a un empleado");
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