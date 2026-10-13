import java.util.ArrayList;

/**
 * La clase Gerencia es la abstraccion de la gerencia a cargo de los alojamiento y el registro de los 
 * alquileres.
 * 
 * @author Fernandez Fabio Javier y Matias Nicolas Gomez
 * @version 1.0
 */
public class Gerencia
{
    private String nombre;
    private ArrayList<Alojamiento> alojamientosAlquilados;
    
    /**
     * 
     * Contructor de la clase Gerencia.
     * 
     */
    public Gerencia(String p_nombre){
        this.setNombre(p_nombre);
        ArrayList<Alojamiento> a = new ArrayList<>();
        this.setAlojAlquilados(a);
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
    
    private void setAlojAlquilados(ArrayList<Alojamiento> p_aloj){
        this.alojamientosAlquilados = p_aloj;
    }
    public ArrayList<Alojamiento> getAlojAlquilados(){
        return this.alojamientosAlquilados;
    }
    
    
    /**
     * 
     * Metodos solicitados para agregar o quitar objetos de la lista dinamica correspondiente.
     * 
     * @param: Objeto de la clase compatible con los elementos que ingresan a la lista generica.
     * @return: Devuelve un valor booleano correspondiente a la funcion que realiza el metodo.
     */
    public boolean agregarAlojamiento(Alojamiento p_aloj) {
        Alojamiento a = p_aloj;
        this.getAlojAlquilados().add(a);
        if(this.getAlojAlquilados().contains(a)){
            return true;
        }else {
            return false;
        }
    }

    public boolean quitarAlojamiento(Alojamiento p_aloj) {
        Alojamiento a = p_aloj;
        this.getAlojAlquilados().remove(a);
        if(this.getAlojAlquilados().contains(a)){
            return false;
        }else {
            return true;
        }
    }
    
    /**
     * 
     * Nos permite contar la cantidad de alojamientos alojados de cada tipo.
     * 
     * @param: Un string que identifica el tipo de alojamiento que va a contar para devolver la cantidad que se encuentran alquilados
     * 
     */
    public int contarAlojamiento(String p_alojamiento){
        int total = 0;
        for(Alojamiento a : this.getAlojAlquilados()){
            total += a.contar(p_alojamiento);
        }
        return total;
    }
    
    /**
     * 
     * Imprime la liquidacion de cada alojamiento alquilado.
     * 
     *
     */
    public void liquidar(){
        for(Alojamiento a : this.getAlojAlquilados()){
            System.out.println("------------------");
            a.liquidar();
            System.out.println("------------------");
        }
    }
    /**
     * 
     * Imprime cada liquidacion de todos los alojamientos alquilados y muestra cuantos de cada tipo de alojamiento se encuentran alquilados.
     * 
     *
     */
    public void mostrarLiquidacion(){
        System.out.println("Gerencia " + this.getNombre());
        System.out.println("----------Liquidacion----------");
        this.liquidar();
        System.out.println("Alojamiento tipo Cabaña ---->" + contarAlojamiento("Cabaña"));
        System.out.println("Alojamiento tipo Hotel ---->" + contarAlojamiento("Hotel"));
    }
}