
/**
 * La clase Etiqueta tiene como funcion modelar la contruccion una etiqueta. Se trata de una clase abstracta
 * que nos ayuda a modelar el comportamiento y atributos generales de todas las clases que heredan sus atributos.
 * 
 * 
 * @author Fernandez Fabio Javier y Matias Nicolas Gomez
 * @version 1.0
 */
public abstract class Etiqueta
{
    private double costo;
    
    public Etiqueta(double p_costo){
        this.setCosto(p_costo);
        
    }
    
    private void setCosto(double p_costo){
        this.costo = p_costo;
    }
    
    public double getCosto(){
        return this.costo;
    }
    
    public abstract double precio(int q);
    
    public String toString(){
        return " tipo " + this.tipo() + " - " + "Costo: $" + this.getCosto();
    }
    
    protected abstract String tipo();

    
    
}    