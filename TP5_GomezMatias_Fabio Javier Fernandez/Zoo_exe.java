import java.util.HashSet;
import java.util.*;

/**
 * ejecutable de la clase Zoologico
 * 
 * @author (Matias Gomez, Fabio Javier Fernandez) 
 * @version (v1.0)
 * 
 */
public class Zoo_exe
{
    public static void main(String [] args) {
        
        Zoologico zoo = new Zoologico("El Caribú");
        
        Calendar fecha1 = new GregorianCalendar();
        Calendar fecha2 = new GregorianCalendar();
        Calendar fecha3 = new GregorianCalendar();
        
        Persona persona1 = new Persona(87487623, "Juan", "Juanez", 1961);
        Persona persona2 = new Persona(23489233, "Carl", "Jonson", 1961);
        Persona persona3 = new Persona(87487623, "Mike", "Myers", 1961);
        
        fecha1.set(22, 10, 2024);
        
        Individuo individuo1 = new Individuo("Juan", fecha1,  persona1);
        Individuo individuo2 = new Individuo("Carl", fecha1,  persona2);
        Individuo individuo3 = new Individuo("Mike", fecha1,  persona3);
        
        HashSet<Individuo> individuos = new HashSet<>();
        
        individuos.add(individuo2);
        individuos.add(individuo3);
        
        Delegacion del = new Delegacion("PAMI", fecha1, individuos);
        
        zoo.nuevoVisitante(individuo1);
        zoo.nuevoVisitante(del);
        
        System.out.println("-----------------------------------------------");
        zoo.listarVisitantePorFecha(fecha1);
        fecha2.set(1, 10, 2024);
        fecha3.set(30, 10, 2024);
        
        System.out.println("-----------------------------------------------");
        
        System.out.println("Recaudaciones: " + zoo.recaudaciones(fecha2, fecha3));
        
        System.out.println("-----------------------------------------------");
        
        zoo.listarTipoVisitantePorFecha(fecha1, del.tipoVisitante());
        
        
        
        
    }
}