import java.util.ArrayList;
import java.util.*;
import java.util.Scanner;
/**
 * Write a description of class Empresa here.
 * 
 * @author (Gomez Matias, Fabio Javier Fernandez) 
 * @version (v1.0)
 */
public class Empresa {
    public static void main(String []args){
        
    /**
     * Se utilizó la clase "ArrayList<Empleado> empleados = new ArrayList<>();" de la libreria 
     * "java.util.ArrayList;" en lugar de la sintaxis comun de lista/arrays Empleado[] empleados = 
     * new Empleado[10];", porque a diferencia de la manera nativa de hacer arrays en java, la 
     * la clase "ArrayList" su ventaja es que crece y se achica dinamicamente, muy util si por 
     * ejemplo como en este problema, no sabemos especificamente cuanto empleados se necesita 
     * almacenar, no podemos depender de una lista de tamaño fijo para almacenar datos.
     */ 
            Scanner teclado = new Scanner(System.in);
            ArrayList<Empleado> empleados = new ArrayList<>();
            int opcion = -1;
            
     /**
     * Se diseño la logica de un menu basico, para poder hacer mas interactivo el programa,
     * se utiliza el metodo/bucle do-while combinado con el switch() para lograr que el usuario
     * pueda moverse entre opciones a su eleccion con numeros enteros que indiquen que acciones
     * realiza.
     */ 
        do{
            mostrarMenu();
            opcion = teclado.nextInt();
            
            switch(opcion){
                case 1:
                    ingresoEmpleado(teclado, empleados);
                    break;
                case 2:
                    mostrarEmpleados(empleados);
                    break;
                case 3: 
                    mostrarLineaEmpleados(teclado, empleados);
                    break;
                case 4:
                    mostrarDetalleEmpleado(teclado, empleados);
                    break;
                case 5:
                    permisoEmpleado(teclado, empleados);
                case 0:
                    System.out.println("Finalizando el software");
                    break;
                    default:
                        System.out.println("Opción inválida.");
            }
        }while(opcion != 0);
        
        
        
    }
    /**
     * En esta seccion los metodos utilizan static al igual que el main, no por que sean metodos
     * ejecutables. Al ser metodos que se utilizan sin instanciar objetos, o que no pertenecen al
     * contexto de ningun objeto precisan ser metodos static, si lo quitaramos nos daria un error
     * como "non-static method mostrarMenu() cannot be referenced from a static context".
     * mostarMenu() realiza la impresion para hacer visual el menu y como utilizarlo.
     */ 
        
        private static void mostrarMenu(){
            System.out.println("--- MENÚ REGISTRO EMPLEADOS ---");
            System.out.println("1) Registrar un empleado");
            System.out.println("2) Mostrar lista de empleados");
            System.out.println("3) Mostrar Linea");
            System.out.println("4) Mostrar empleado en detalle");
            System.out.println("0) Salir");
            System.out.print("Ingrese opción: ");
        }
        
    /**
     * ingresoEmpleado(teclado, empleados) recibo la entrada por teclado que usamos para elegir
     * las opciones en el menu, y para que cada metodo no tenga que crear su propio scanner cuando
     * lo necesite, se reutiliza el que creamos dentro del metodo main enviandolo por parametro,
     * tambien recibe el arraylist empleados, primero completamos todas las variables que nos pide
     * con las entradas del teclado (teclado.nextLine que colocamos entre algunas entradas de
     * teclado nos permite asegurarnos que no quede ningun "\n" salto de linea despues de que 
     * utilizamos text.nextInt al elegir una opcion en el menu) y las enviamos como parametros 
     * para instanciar un objeto de tipo Empleado llamado nuevoEmpleado. Luego con el metodo add()
     * de la clase ArrayList lo introducimos al array empleados.
     */ 
        
        
        
        private static void ingresoEmpleado(Scanner teclado, ArrayList<Empleado> empleados){
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
            empleados.add(nuevoEmpleado);
            System.out.println("Empleado agregado correctamente.");
        }
        
    /**
     * mostrarEmpleados() primero con un if que usa el valor booleano que devuelve el metodo 
     * isEmpty (true o false) perteneciente a la clase ArrayList, devuelve que la lista de 
     * empleados esta vacia si es true, caso contrario imprime la lista de empleados mediante un
     * for, que realiza las iteraciones con un valor entero llamado "i" hasta que sea igual al 
     * tamaño o longitud de nuestra array empleados, utilizando el metodo size() de la clase
     * ArrayList. Para obtener los datos empleado, se guarda en una variable del tipo Empleado 
     * llamada "empleado" que con el metodo get(i) obtiene el empleado del array, segun el valor i 
     * de la iteración.
     * Para imprimir cada empleado se reutiliza el metodo mostrarLinea() perteneciente a la clase 
     * empleado.
     */ 
        
        private static void mostrarEmpleados(ArrayList<Empleado> empleados){
            if(empleados.isEmpty()){
            System.out.println("--- Lista vacia ---");
            return;
        } else {
            System.out.println("-----------------------------------");
            System.out.println("--- Listado de empleados ---");
            for(int i = 0;i < empleados.size();i++){
                Empleado empleado = empleados.get(i);
                System.out.println((i+1) + ") " + empleado.mostrarLinea());
            }
            System.out.println("-----------------------------------");
        }
    }
    
    /**
     * mostrarLineaEmpleados() Imprime un empleado espeficico segun el indice del array,
     * visualmente al imprmir la lista completa, vemos que la lista empieza con la posicion 1, con
     * lo cual se busca que al ejecutar este metodo, el usuario si quiere ver por ejemplo al 
     * empleado de la posicion 1, pueda colocar 1 y que venga a pantalla la informacion correcta,
     * como los arrays comienzan en la posicion 0 al estar en un lenguaje de base 0, al indice que
     * ingresa el usuario por ejemplo 1 (para ver la posicion 1) se le resta 1 para que traiga la 
     * informacion correcta que seria de la posicion 0, que es el correcto comienzo del indice del 
     * array/lista empleados.
     */ 
    
    private static void mostrarLineaEmpleados(Scanner teclado, ArrayList<Empleado> empleados){
        teclado.nextLine();
                if(empleados.isEmpty()){
            System.out.println("--- Lista vacia ---");
            return;
        } else {
            System.out.println("Ingrese numero de indice del empleado: ");
            int indiceEmpleado = teclado.nextInt();
              Empleado empleado = empleados.get(indiceEmpleado - 1);
              System.out.println("-----------------------------------");
              System.out.println(indiceEmpleado + ") " + empleado.mostrarLinea());
              System.out.println("-----------------------------------");
        }
    }
    
    /**
     * mostrarDetalleEmpleados() Imprime un empleado espeficico con informacion extra segun el 
     * indice del array, el usuario si quiere ver por ejemplo al empleado de la posicion 1, 
     * puede colocar 1 y que venga a pantalla la informacion correcta.
     * como los arrays comienzan en la posicion 0 al estar en un lenguaje de base 0, al indice que
     * ingresa el usuario por ejemplo 1 (para ver la posicion 1) se le resta 1 para que traiga la 
     * informacion correcta que seria de la posicion 0, que es el correcto comienzo del indice del 
     * array/lista empleados. Utiliza el metodo mostrar() de la clase "Empleado".
     */ 
    
    private static void mostrarDetalleEmpleado(Scanner teclado, ArrayList<Empleado> empleados){
        teclado.nextLine();
                if(empleados.isEmpty()){
            System.out.println("--- Lista vacia ---");
            return;
        } else {
            System.out.println("Ingrese numero de indice del empleado: ");
            int indiceEmpleado = teclado.nextInt();
              Empleado empleado = empleados.get(indiceEmpleado - 1);
              System.out.println("-----------------------------------");
              System.out.println(indiceEmpleado + ")");
              empleado.mostrar();
              System.out.println("-----------------------------------");
        }
    }
    
    private static void permisoEmpleado(Scanner teclado, ArrayList<Empleado> empleados){
        teclado.nextLine();
        if(empleados.isEmpty()){
            System.out.println("--- Lista vacia ---");
            return;
        } else {
            System.out.println("Ingrese numero de indice del empleado: ");
            int indiceEmpleado = teclado.nextInt();
              Empleado empleado = empleados.get(indiceEmpleado - 1);
              if(empleado.esAniversario()) {
                  System.out.println("-----------------------------------");
                  System.out.println(indiceEmpleado + ")");
                  empleado.mostrar();
                  System.out.println("Este dia es tu aniversario! Puedes salir temprano.");
                  System.out.println("-----------------------------------");
                  
              }
        }
    }
        
    }
