
/**
 * La clase Circulo tiene como funcion modelar la contrucion la figura geometrica circulo 
 * permitiendo representar su radio, calcular su permitero, superficie y representar su centro
 * con la ayuda de la clase Punto que representara el mismo.
 * 
 * @author Fernandez Fabio Javier y Matias Nicolas Gomez
 * @version 1.0
 */
public class Circulo extends Elipse
{
    
    /**
     * Constructores de la clase Circulo, se trata de un constructor sobrecargado, dada la
     * capacidad de posee dos constructores que se diferencian con sus parametros
     */
    
    public Circulo(double p_radio, Punto p_centro){
    super(p_radio,p_radio,p_centro);
    }
    
    public Circulo(){
        this(0, new Punto());
    }
        
    /**
     * Imprime el tipo de figuras con que se esta trabajando.
     * 
     */
    public String nombreFigura(){
        return "****** Circulo ******";
    }
    
         /**
         * Calcula el perimetro de un Circulo y retorna dicho valor
         * 
         * @return: retorna el valor que representa el perimetro.
         * 
         * 
         */
    public double perimetro(){
        double perimetro = this.getEjeMayor()*2* Math.PI;
        return Math.round(perimetro*100.0)/100.0;
    }
    
    /**
     * Imprime las caracteristicas correspondientes a esta clase de figura
     * 
     */
    public void caracteristicas(){
        System.out.println(this.nombreFigura());
        System.out.println("Centro: " + super.getOrigen().coordenadas() + " " + "-Radio: " + 
        this.getEjeMayor());
        System.out.println("Superficie: " + this.superficie() + " " + "-Perimetro " + 
        this.perimetro());
    }
    
    
}