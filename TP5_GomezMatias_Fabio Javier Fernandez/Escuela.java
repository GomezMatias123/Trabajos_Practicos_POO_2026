import java.util.*;
/**
 * Write a description of class Escuela here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Escuela
{
   public  static void main(String [] args) {
       
       Calendar fechaHoy = Calendar.getInstance();
       
       
       Persona persona1 = new Persona(5, "Juan", "Kira", fechaHoy);
       
       
       Alumno alumno1 = new Alumno(1, 6, "Juan", "L", fechaHoy);
       alumno1.setNota1(8);
       alumno1.setNota2(10);
        
       
       persona1.mostrar();
       System.out.println("---------------------------------------------------------");
       alumno1.mostrar();
       
              
   }
}