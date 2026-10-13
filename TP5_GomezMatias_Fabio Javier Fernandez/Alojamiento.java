import java.util.ArrayList;

/**
 *La clase abstracta Alojamiento nos birnda el protocolo y atributos generales para cada tipo de alojamiento
 *
 * 
 * @author Fernandez Fabio Javier y Matias Nicolas Gomez
 * @version 1.0
 */
public abstract class Alojamiento
{
    private String nombre;
    private double precioBase;
    private int diasAlquiler;
    private ArrayList<Servicios> servicios;
    
    
    /**
     * Contructor de la clase abstracta alojamiento, da los principale atributos que deben seguir los objetos que hereden esta clase
     * 
     * @param: Recibe un string como nombre, un valor double para precio base y un int par representar la cantidad de dias de alojamiento.
     */
    public Alojamiento(String p_nombre, double p_precioBase, int p_diasAlquiler){
        ArrayList<Servicios> s = new ArrayList<>();
        this.setNombre(p_nombre);
        this.setPrecioBase(p_precioBase);
        this.setDiasAlojamiento(p_diasAlquiler);
        this.setServicios(s);
    }
    
    /**
     * 
     * Setters y getters, cada uno se encarga de settear el atributo correspondiente y getters nos trae el valor de cada atributo.
     * 
     * @param: cada setteer recibe como parametro una representacion del atributo correspondiente
     * 
     */
    
    private void setNombre(String p_nombre){
        this.nombre = p_nombre;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    private void setPrecioBase(double p_precioBase){
        this.precioBase = p_precioBase;
    }
    
    public double getPrecioBase(){
        return this.precioBase;
    }
    
    private void setDiasAlojamiento(int p_diasAlquiler){
        this.diasAlquiler = p_diasAlquiler;
    }
    
    public int getDiasAlojamiento(){
        return this.diasAlquiler;
    }
    
    private void setServicios(ArrayList<Servicios> p_servicios){
        this.servicios = p_servicios;
    }
    
    public ArrayList<Servicios> getServicios(){
        return this.servicios;
    }
    
    /**
     * 
     * Metodos solicitados para agregar o quitar objetos de la lista dinamica correspondiente.
     * 
     * @param: Objeto de la clase compatible con los elementos que ingresan a la lista generica.
     * @return: Devuelve un valor booleano correspondiente a la funcion que realiza el metodo.
     */
    public boolean agregarServicio(Servicios p_servicio) {
        Servicios s = p_servicio;
        this.getServicios().add(s);
        if(this.getServicios().contains(s)){
            return true;
        }else {
            return false;
        }
    }

    public boolean quitarServicio(Servicios p_servicio) {
        Servicios s = p_servicio;
        this.getServicios().remove(s);
        if(this.getServicios().contains(s)){
            return false;
        }else {
            return true;
        }
    }
    /**
     * Metodo abstracto que reescribira cada tipo de objeto que hereda de la clase Alojamiento
     * 
     * @param: un String para identificar al tipo de alojamiento.
     */
    
    public abstract int contar(String p_alojamiento);
    
    /**
     * Metodo base para calcular el costo de todos los objetos que hereden los metodos y atributos de la clase abstracta Alojamiento.
     * 
     * @param: un String para identificar al tipo de alojamiento.
     * 
     */
    
    public double costo(){
        
        return this.getPrecioBase()*this.getDiasAlojamiento();
    }
        
    /**
     * Lista todos los servicios que el alojamiento tiene activo o en uso.
     * 
     */
    public void listarServicios(){ 
            if(this.getServicios().isEmpty()){
                System.out.println("El huesped no hizo uso de ningun servicio");
            }else {
            System.out.println("*** Lista de servicios ***");
            for(Servicios s : this.getServicios()){
                System.out.println(s.getDescripcion() + " ----------- " + s.getPrecio());
            }
        }
    }
    /**
     * Realiza el caulculo total del costo de los servicio.
     * 
     * @return: Devuelve el valor total correspondiente al costo de todos los servicios de un alojamiento.
     * 
     */
    public double costoServicio(){
        double total = 0;
        
            for(Servicios s : this.getServicios()){
                    total += s.getPrecio();
                }
          
        return total;
    }
    
    
    /**
     * Imprime la informacion basica sobre la liquidacion de un alojamiento.
     */
    public void liquidar(){
        System.out.println("Alojamiento: " + this.getNombre());
        System.out.println("Costo por " + this.getDiasAlojamiento() + " dias: " + "$" + this.costo() + " " + "alquiler");
        this.listarServicios();
    }
    
    
}