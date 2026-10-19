
/**
 * La clase Premiun, tiene como funcion modelar la contruccion una etiqueta del tipo premiun. Hereda todos los comportamietos y atributos de una clase abstracta de Etiqueta.
 * 
 * 
 * @author Fernandez Fabio Javier y Matias Nicolas Gomez
 * @version 1.0
 */
public class Premiun extends Etiqueta
{
    private int colores;
    
    public Premiun(int p_colores, double p_costo){
        super(p_costo);
        this.setColores(p_colores);
    }
    
      
    /**
     * 
     * Setters y getters, cada uno se encarga de settear el atributo correspondiente y getters nos trae el valor de cada atributo.
     * 
     * @param: cada setteer recibe como parametro una representacion del atributo correspondiente
     * 
     */
    
    private void setColores(int p_colores){
        this.colores = p_colores;
    }
    
    public int getColores(){
        return this.colores;
    }
    
    /**
     * 
     * Calcula el precio de etiquetas del tipo premiun
     * 
     * @param: Un entero que representa la cantidad de etiquetas de este tipo.
     * 
     */
    public double precio(int q){
        int cantidad = q;
        return (this.getCosto() * this.plus()) * cantidad;
    }
    /**
     * 
     * Calcula el adicional segun la cantidad de colores en etiquetas premiun.
     * 
     */
    private double plus(){
        if(this.colores <= 0){
            return 1;
        } else if(this.colores == 1){
            return 1;
        } else if (this.colores == 2) {
            return 1.05;
        } else if(this.colores == 3){
            return 1.07;
        } else {
            return 1 + (this.getColores()*0.03);
        }
    }
    /**
     * 
     * Devuelve el valor String del nombre del tipo de etiqueta especifico a esta clase.
     * 
     */
    protected String tipo(){
        return "Premiun";
    }
    /**
     * 
     * Sobreescribe el metodo heredado toString para adicionar informacion especifca del tipo de etiquetas comunes.
     * 
     */
    public String toString(){
        return super.toString() + " - "  + "Colores: " + this.getColores();
    }
    
    
}