
/**
 * La clase hotel es la abstraccion de un tipo de alojamiento.
 * 
 * @author Fernandez Fabio Javier y Matias Nicolas Gomez
 * @version 1.0
 */
public class Hotel extends Alojamiento
{
    private String tipoHabitacion;
    
    /**
     * 
     * Contructor de la clase Hotel.
     * 
     */    
    public Hotel(String p_nombre, double p_precioBase, int p_diasAlquiler, String p_habitacion)
    {
        super(p_nombre, p_precioBase, p_diasAlquiler);
        this.setTipoHabitacion(p_habitacion);
    }
    
    /**
     * 
     * Setters y getters, cada uno se encarga de settear el atributo correspondiente y getters nos trae el valor de cada atributo.
     * 
     * @param: cada setteer recibe como parametro una representacion del atributo correspondiente
     * 
     */
    
    private void setTipoHabitacion(String p_habitacion){
        this.tipoHabitacion = p_habitacion;
    }
    
    public String getTipoHabitacion(){
        return this.tipoHabitacion;
    }
    
    
        /**
         * 
         * Calcula el costo total segun el tipo de objeto hotel agregando el costo extra por el tipo de habitación.
         * 
         */
    public double costo(){
        if(this.getTipoHabitacion().trim().equalsIgnoreCase("single")){
            return super.costo() + (20*this.getDiasAlojamiento());           
        }else {
            return super.costo() + (35*this.getDiasAlojamiento());
        }
    }
    /**
     * Devuelve un valora a sumar a un total de tipo de alojamiento segun lo que recibe como parametro
     * 
     * @param: Un valor string con el tipo de alojamiento que se esta contando.
     * 
     * 
     */
    
    public int contar(String p_alojamiento){
        if(p_alojamiento.trim().equalsIgnoreCase("hotel")){
            return 1;
        }else {
            return 0;
        }
    }
    
    /**
     * Imprime la informacion basica sobre la liquidacion de un alojamiento.
     */
    public void liquidar(){
        super.liquidar();
        System.out.println("Habitacion " + this.getTipoHabitacion());
        System.out.println("Total: -----> " + " " + "$" + (this.costo() + super.costoServicio()));
    }
    
    
   
}