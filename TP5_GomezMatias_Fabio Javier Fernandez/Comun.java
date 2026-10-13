
/**
 * La clase Comun, tiene como funcion modelar la contruccion una etiqueta del tipo comun. Hereda todos los comportamietos y atributos de una clase abstracta de Etiqueta.
 * 
 * 
 * @author Fernandez Fabio Javier y Matias Nicolas Gomez
 * @version 1.0
 */
public class Comun extends Etiqueta
{
    private double plus;
    
    public Comun(double p_plus){
        super(100);
        this.setPlus(p_plus);
    }
    
    /**
     * 
     * Setters y getters, cada uno se encarga de settear el atributo correspondiente y getters nos trae el valor de cada atributo.
     * 
     * @param: cada setteer recibe como parametro una representacion del atributo correspondiente
     * 
     */
    
    private void setPlus(double p_plus){
        this.plus = p_plus;
    }
    
    public double getPlus(){
        return this.plus;
    }
    
    public double precio(int q){
        int cantidad = q;
        return (cantidad * this.getCosto() + this.getPlus()) - this.descuento(cantidad);
    }
    
    private double descuento(int q){
        double prePrecio = q * this.getCosto() + this.getPlus();
        
        if(q <= 10){
            return 0;
        } else if (q <= 50){
            return  prePrecio * 0.02;
        } else if (q <= 100){
            return prePrecio * 0.05;
        } else {
            double porcentajeDesc = Math.floor(q / 10) / 100;
            return prePrecio * porcentajeDesc;
        }
    }
    
    protected String tipo(){
        return "Común";
    }
    
    public String toString(){
        return super.toString() + " - "  + "Diseño: $" + this.getPlus();
    }
}