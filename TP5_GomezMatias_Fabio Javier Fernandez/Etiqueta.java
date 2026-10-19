
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
    
    
    /**
     * 
     * Setters y getters, cada uno se encarga de settear el atributo correspondiente y getters nos trae el valor de cada atributo.
     * 
     * @param: cada setter recibe como parametro una representacion del atributo correspondiente
     * 
     */
    private void setCosto(double p_costo){
        this.costo = p_costo;
    }
    
    public double getCosto(){
        return this.costo;
    }
    
    /**
     * 
     * Metodo abstracto sin implementacion que se realiza o especializa en la clase que hereda sus atributos y metodos.
     * 
     */
    public abstract double precio(int q);
    /**
     * 
     * Imprime la informacion general que necesitan las clases que heredan los atributos y metodos de esta clase abstracta.
     * 
     */
    public String toString(){
        return " tipo " + this.tipo() + " - " + "Costo: $" + this.getCosto();
    }
    /**
     * 
     * Metodo abstracto sin implementacion que se realiza o especializa en la clase que hereda sus atributos y metodos.
     * 
     */
    protected abstract String tipo();

    
    
}    