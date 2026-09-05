import java.util.Scanner;
/**
 *  La clase GestionStock nos va a permitir instanciar los objetos necesarios para probar poder
 * enviar mensajes y probar los metodos. Aqui se encuentra el metodo ejecutable main, como 
 * señala el trabajo se ingrsaran datos a traves del teclado del usuario.
 * 
 * @author (Fernandez Fabio Javier y Matias Nicolas Gomez) 
 * @version (1.0)
 */
public class Secretaria
{
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        
        int centinela = -1;
        
        Escuela escuela;
        Docente docente;
        
        while (centinela != 0) {
            
            menu();
            
            centinela = teclado.nextInt();
            
            switch(centinela) {
                
                case 1: escuela =ingresarEscuela(teclado);
                    escuela.imprimirRecibo(ingresarDocente(teclado));
                        
                    break;
                case 0: System.out.println("Hasta luego!");
                    break;
                default: System.out.println("Algo inesperado sucedio...");
                    break;
                    
            }
        }
        
        
    }
        
    public static void menu() {
        
        System.out.println("--- Selecione una opcion ---");
        
        
        
        System.out.println("1) Emitir un recibo de un docente"); 
        System.out.println("0) Finalizar");
        
        
    }
    
    public static Escuela ingresarEscuela(Scanner teclado) {
        teclado.nextLine();
        System.out.println("nombre del colegio: ");
        String nombre = teclado.nextLine();
        
        System.out.println("domicilio: ");
        String domicilio = teclado.nextLine();
        
        System.out.println("Director ");
        String director = teclado.nextLine();
        
        Escuela nuevaEscuela = new Escuela(nombre, domicilio, director);
        System.out.println("Escuela ingresada correctamente.");
        
        return nuevaEscuela;
    }
    
    public static Docente ingresarDocente(Scanner teclado) {
    
        System.out.println("Ingrese Nombre del docente: ");
        String nombre = teclado.nextLine();
        
        System.out.println("grado: ");
        String grado = teclado.nextLine();
        
        System.out.println("Sueldo Basico ");
        double sueldoBasico = teclado.nextDouble();
        
        System.out.println("Asignacion familiar: ");
        double asignacionFamiliar = teclado.nextDouble();
        
        Docente nuevoDocente = new Docente(nombre, grado, sueldoBasico, asignacionFamiliar);
        System.out.println("Docente agregado correctamente.");
        
        return nuevoDocente;
    
    }
}