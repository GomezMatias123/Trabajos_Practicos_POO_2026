
/**
 * La clase Triangulo tiene como funcion modelar la contruccion la figura geometrica de un triangulo 
 * permitiendo representar atributos especificos y su centro con la ayuda de la clase Punto que representara el mismo.
 * 
 * @author Fernandez Fabio Javier y Matias Nicolas Gomez
 * @version 1.0
 */
public class Triangulo extends FiguraGeometrica
{
    private double base;
    private double altura;
    
    public Triangulo (double p_base, double p_altura, Punto p_origen){
        super(p_origen);
        setBase(p_base);
        setAltura(p_altura);
    }
    
    /**
    * Getters y setter
    */ 
   
    private void setBase(double p_base){
        this.base = p_base;
    }
    
    public double getBase(){
        return this.base;
    }
    
    private void setAltura(double p_altura){
        this.altura = p_altura;
    }
    
    public double getAltura(){
        return this.altura;
    }
    
    
    /**
     * Imprime el tipo de figuras con que se esta trabajando.
     * 
     */
    
    public String nombreFigura(){
        return "****** Triangulo ******";
    }
    
     /**
     * Devuelve el resultado del calculo para obtener la superficiete de esta figura en especifico.
     * 
     * @return: devuelve como valor double el valor de la superficie de la figura.
     */
    
    public double superficie() {
        return (this.getBase() * this.getAltura())/2;
    }
    
    
    
}