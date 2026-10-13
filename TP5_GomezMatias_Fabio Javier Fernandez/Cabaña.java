
/**
 * La clase Cabaña es la abstraccion de un tipo de alojamiento.
 * 
 * @author Fernandez Fabio Javier y Matias Nicolas Gomez
 * @version 1.0
 */
public class Cabaña extends Alojamiento
{
    private int nroHabitaciones;
    /**
     * 
     * Contructor de la clase Cabaña.
     * 
     */
    public Cabaña(String p_nombre, double p_precioBase, int p_diasAlquiler, int p_nHabitaciones){
        super(p_nombre, p_precioBase, p_diasAlquiler);
        this.setNroHabitaciones(p_nHabitaciones);
    }
    
    /**
     * 
     * Setters y getters, cada uno se encarga de settear el atributo correspondiente y getters nos trae el valor de cada atributo.
     * 
     * @param: cada setteer recibe como parametro una representacion del atributo correspondiente
     * 
     */
    
    private void setNroHabitaciones(int p_nHabitaciones){
        this.nroHabitaciones = p_nHabitaciones;
    }
    
    public int getNroHabitaciones(){
        return this.nroHabitaciones;
    }
    
    
    /**
     * 
     * Calcula el costo total segun el tipo de objeto cabaña, agregando el valor 30 por cada habitacion de la cabaña y por cada dia de alojamiento.
     * 
     * 
     */
    public double costo(){
        return super.costo() + (30 * this.getNroHabitaciones() * this.getDiasAlojamiento());
    }
    /**
     * Devuelve un valora a sumar a un total de tipo de alojamiento segun lo que recibe como parametro
     * 
     * @param: Un valor string con el tipo de alojamiento que se esta contando.
     * 
     * 
     */
    
    public int contar(String p_alojamiento){
        if(p_alojamiento.trim().equalsIgnoreCase("cabaña")){
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
        System.out.println("Cabaña con " + this.getNroHabitaciones() + " " + "habitaciones");
        System.out.println("Total: -----> " + " " + "$" + (this.costo() + super.costoServicio()));
    }
    
    
}