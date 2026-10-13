
/**
 * La clase figura geometrica tiene como funcion modelar la contruccion la figura geometrica permitiendo representar 
 * atributos especificos y su centro con la ayuda de la clase Punto que representara el mismo. Se trata de una clase abstracta
 * que nos ayuda a modelar el comportamiento y atributos generales de todas las clases que heredan sus atributos.
 * 
 * 
 * @author Fernandez Fabio Javier y Matias Nicolas Gomez
 * @version 1.0
 */
public abstract class FiguraGeometrica
{
   private Punto origen;
   
   public FiguraGeometrica(Punto p_origen){
       this.setOrigen(p_origen);
   }
   
   private void setOrigen(Punto p_origen){
       this.origen = p_origen;
   }
   
   public Punto getOrigen(){
       return this.origen;
   }
   
   public abstract String nombreFigura();
   public abstract double superficie();
   
   public void mostrarSuperficie(){
       System.out.println(this.nombreFigura());
       System.out.println("Superficie: " + String.format("%.2f", superficie()));
   }
}
