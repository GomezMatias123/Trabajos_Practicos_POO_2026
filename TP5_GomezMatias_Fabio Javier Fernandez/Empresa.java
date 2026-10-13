import java.util.GregorianCalendar;
import java.util.Calendar;

/**
 * Clase ejecutable Empresa para instaciar a los los objetos del tipo empleado
 * 
 * @author (Gomez Matias, Fabio Javier Fernandez) 
 * @version (v1.0)
 */
public class Empresa
{
  public static void main(String[]args){
      
      Calendar fecha = new GregorianCalendar(1999, Calendar.AUGUST, 19);
      
      Persona persona = new Persona(41949991, "Matias", "Gomez", fecha);
      System.out.println("Persona: ");
      persona.mostrar();
      
      Calendar fechaIngreso = Calendar.getInstance();
      Empleado empleado = new Empleado(41949991, "Matias", "Gomez", fecha, 19499919, 300000, 2020);
      System.out.println("Empleado: ");
      empleado.mostrar();
  }
}