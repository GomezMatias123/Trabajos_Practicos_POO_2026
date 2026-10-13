import java.util.Scanner;

/**
 * La clase AdministracionGerencia es la abstraccion de la gerencia a cargo de los alojamiento y el registro de los 
 * alquileres.
 * 
 * @author Fernandez Fabio Javier y Matias Nicolas Gomez
 * @version 1.0
 */
public class AdministracionGerencia
{
    public static void main(String[]args){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese su nombre completo como gerente");
        String nombreGerente = teclado.nextLine();
        Gerencia gerente = new Gerencia(nombreGerente);
        
        int opcion = -1;
        
        do{
        mostrarMenu(gerente);
        opcion = teclado.nextInt();
        switch(opcion){
            case 1:
                alquilar(teclado, gerente);
                break;
            case 2:
                cancelarAlquiler(teclado, gerente);
                break;
            case 3:
                gerente.mostrarLiquidacion();
                break;
            case 0:
                System.out.println("Cerrando el software");
                break;
            default:
                System.out.println("Valor invalido");
        }
        
        
        }while(opcion != 0);
    }
    /**
     * 
     * Imprime el menu para guiar al usuario entre las diferentes opciones.
     * 
     */
    public static void mostrarMenu(Gerencia p_gerente){
        System.out.println("Bienvenido: " + p_gerente.getNombre() + " " + "/Gerente");
        System.out.println("1) Confirmar alquiler");
        System.out.println("2) Cancelar alquiler");
        System.out.println("3) Imprimir liquidaciones pendientes");
        System.out.println("0) Cerrar el software");
    }
    /**
     * 
     * Permite agregar un alojamiento a la lista de alquilados.
     * 
     * @param: teclado para ingresar toda la informacion por teclado, y gerente el objeto que gestiona toda la lista de alojamientos alquilados.
     * 
     */
    
    
    public static void alquilar(Scanner teclado, Gerencia gerente){
        teclado.nextLine();
        System.out.println("¿Desea alquilar una -cabaña- o en un -hotel-?");
        String alquiler = teclado.nextLine().trim().toLowerCase();
        Alojamiento alojamiento = null;
        String nombre = null;
        String respuesta = null;
        double precioBase = 0;
        int diasAlquiler = 0;
        
        switch(alquiler){
            case "cabaña":
                System.out.println("Ingrese el nombre de la cabaña");
                nombre = teclado.nextLine();
                System.out.println("Ingrese el costo por dia de alquiler");
                precioBase = teclado.nextDouble();
                System.out.println("Ingrese la cantidad de dias de alquiler");
                diasAlquiler = teclado.nextInt();
                int habitaciones;
                do{
                    System.out.println("Estan disponibles cabañas con 1 | 2 | 3 habitaciones ¿cuantas se necesita?");
                    habitaciones = teclado.nextInt();
                    if(habitaciones < 1 || habitaciones > 3){
                         System.out.println("Cantidad invalida");
                    }
                }while(habitaciones < 1 || habitaciones > 3);
                teclado.nextLine();
                alojamiento = new Cabaña(nombre, precioBase, diasAlquiler, habitaciones);
                System.out.println("¿Desea agregar algun servicio extra?(Y=Si | N = No");
                respuesta = teclado.nextLine().trim().toLowerCase();
                if(respuesta.equals("y")){
                    ingresarServicios(teclado,alojamiento);
                }
                break;
            case "hotel":
                System.out.println("Ingrese el nombre del hotel");
                nombre = teclado.nextLine();
                System.out.println("Ingrese el costo por dia de alquiler");
                precioBase = teclado.nextDouble();
                System.out.println("Ingrese la cantidad de dias de alquiler");
                diasAlquiler = teclado.nextInt();
                teclado.nextLine();
                String tipoHabitacion;
                do{
                    System.out.println("Ingrese el tipo de habitacion (Single | Doble)");
                    tipoHabitacion = teclado.nextLine().trim().toLowerCase();
                    if(!tipoHabitacion.equals("single") && !tipoHabitacion.equals("doble")){
                         System.out.println("Tipo invalido, ingrese Single o Doble");
                    }
                }while(!tipoHabitacion.equals("single") && !tipoHabitacion.equals("doble"));
                alojamiento = new Hotel(nombre, precioBase, diasAlquiler, tipoHabitacion);
                System.out.println("¿Desea agregar algun servicio extra?(Y=Si | N = No");
                respuesta = teclado.nextLine().trim().toLowerCase();
                if(respuesta.equals("y")){
                    ingresarServicios(teclado,alojamiento);
                }
                break;
            default:
                System.out.println("Tipo de alojamiento invalido.");   
        }
        
        if(alojamiento != null){
            System.out.println(gerente.agregarAlojamiento(alojamiento) ? "Se alquilo el establecimiento con exito" : "Ocurrio un error al querer confirmar el alquiler");
        }
    }
    
    /**
     * 
     * Permite agregar diferentes servicios extras correspondientes a cada alojamiento.
     * 
     */    
    public static void ingresarServicios(Scanner teclado, Alojamiento aloj){
        int eleccion = -1;
        
        do{
        System.out.println("1)Ingresar Servicio");
        System.out.println("0)Dejar de agregar servicios");
        eleccion = teclado.nextInt();
        teclado.nextLine();
        
            switch(eleccion){
                case 1: 
                    System.out.println("Ingrese descripcion del servicio");
                    String servicioDesc = teclado.nextLine();
                    System.out.println("Ingrese el costo del servicio");
                    double costoServicio = teclado.nextDouble();
                    teclado.nextLine();
                    Servicios s = new Servicios(servicioDesc,costoServicio);
                    aloj.agregarServicio(s);
                    break;
                case 0:
                    System.out.println("Volviendo al menu principal");
                    break;
                default:
                    System.out.println("Valor invalido");
            }
            
        }while(eleccion != 0);
    }
    /**
     * 
     * Nos permite cancelar un alquiler que este presente en la lista de alquilados.
     * 
     * @param: teclado para ingresar toda la informacion por teclado, y gerente el objeto que gestiona toda la lista de alojamientos alquilados.
     * 
     */
    
    public static void cancelarAlquiler(Scanner teclado, Gerencia gerente){
        teclado.nextLine();
        int i = 0;
        
        if(gerente.getAlojAlquilados().isEmpty()){
            System.out.println("No existen alquileres pendientes de liquidar");
            return;
        }
        
        for(Alojamiento a : gerente.getAlojAlquilados()){
            System.out.println((i+1) + ")");
            a.liquidar();
            i++;
        }
        
        System.out.println("Indique el alquiler que se desea cancelar de la lista");
        int indiceAlquileres = teclado.nextInt();
        teclado.nextLine();
        if(indiceAlquileres < 1 || indiceAlquileres > gerente.getAlojAlquilados().size()){
        System.out.println("Indice invalido");
        return;
        }
        
        Alojamiento alquilerCancelado = gerente.getAlojAlquilados().get(indiceAlquileres - 1);
       
        System.out.println(gerente.quitarAlojamiento(alquilerCancelado)
        ? "Se elimino el alquiler de la lista de pendientes" 
        : "Ocurrio un error al tratar de eliminar el alquiler de pendientes");
    }
}