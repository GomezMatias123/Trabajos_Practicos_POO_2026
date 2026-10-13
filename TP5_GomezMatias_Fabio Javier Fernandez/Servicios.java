
/**
 * La clase servicios es el concepto o abstraccion de los servicios que brinda el alojamiento como extra ademas de hospedar
 * a los pasajeros.
 * 
 * @author Fernandez Fabio Javier y Matias Nicolas Gomez
 * @version 1.0
 */
public class Servicios
{
    //atributos
    private String descripcion;
    private double precio;
    
    
     /**
     * Constructor de la clase Servicios
     * @param: la descripcion del servicio como String y el precio o costo del servicio en tipo double
     */
    public Servicios(String p_descripcion, double p_precio){
        this.setDescripcion(p_descripcion);
        this.setPrecio(p_precio);
    }
    /**
     * 
     * Setters y getters, cada uno se encarga de settear el atributo correspondiente y getters nos trae el valor de cada atributo.
     * 
     * @param: cada setteer recibe como parametro una representacion del atributo correspondiente
     * 
     */
    
    private void setDescripcion(String p_descripcion)
    {
        this.descripcion = p_descripcion;
    }
    
    public String getDescripcion(){
        return this.descripcion;
    }
    
    private void setPrecio(double p_precio)
    {
        this.precio = p_precio;
    }
    
    public double getPrecio(){
        return this.precio;
    }
    
}