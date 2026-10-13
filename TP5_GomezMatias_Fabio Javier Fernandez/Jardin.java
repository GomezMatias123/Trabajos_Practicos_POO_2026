import java.util.ArrayList;

/**
 * La clase Jardin tiene como funcion modelar el concepto de un establecimiento jardin, permitiendo representar 
 * atributos especificos y su comportamiento o protocolo de acciones.
 *
 * @author Fernandez Fabio Javier y Matias Nicolas Gomez
 * @version 1.0
 */
public class Jardin
{
    private String nombre;
    private ArrayList<FiguraGeometrica> figuras;
    
    public Jardin(String p_nombre){
        ArrayList<FiguraGeometrica> e = new ArrayList<FiguraGeometrica>();
        this.setNombre(p_nombre);
        this.setFiguras(e);
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
    
    private void setFiguras(ArrayList<FiguraGeometrica> p_figuras){
        this.figuras = p_figuras;
    }
     
    public ArrayList<FiguraGeometrica> getFiguras(){
        return this.figuras;
    }
    
     /**
     * 
     * Metodos solicitados para agregar o quitar objetos de la lista dinamica correspondiente.
     * 
     * @param: Objeto de la clase compatible con los elementos que ingresan a la lista generica.
     * @return: Devuelve un valor booleano correspondiente a la funcion que realiza el metodo.
     */
    public boolean agregarFigura(FiguraGeometrica p_figura) {
        FiguraGeometrica figura = p_figura;
        this.getFiguras().add(figura);
        if(this.getFiguras().contains(figura)){
            return true;
        }else {
            return false;
        }
    }

    public boolean quitarFigura(FiguraGeometrica p_figura) {
        FiguraGeometrica figura = p_figura;
        this.getFiguras().remove(figura);
        if(this.getFiguras().contains(figura)){
            return false;
        }else {
            return true;
        }
    }
    
     /**
     * 
     * Devuelve la cantidad de litros de pintura que se tienen que ocupar para cubrir los metros totales de las figuras a pintar.
     * 
     * @return: Devuelve como valor double, la cantidad de litros de pintura a utilizar.
     * 
     */
    private double cuantosLitros(){
       
        return (cuantosMetros() * 4)/20;
    }
    
    
    /**
     * 
     * Devuelve la cantidad de latas que se tienen que comprar para llegar a la cantidad de pintura suficiente antes calculada.
     * 
     * @return: Devuelve como valor entero, la cantidad latas a comprar.
     * 
     */
    public int cuantasLatas(){
        return (int) Math.ceil(cuantosLitros()/4);
    }
    
    
    /**
     * 
     * Devuelve la cantidad de metros cuardados que se tienen que cubrir segun las figuras a pintar.
     * 
     * @return: Devuelve como valor double, la cantidad de metros cuadrados que ocupan las figuras.
     * 
     */
    public double cuantosMetros(){
        double calcSuperficie = 0;
        for(FiguraGeometrica f : this.getFiguras()){
           calcSuperficie += f.superficie();
        }
        return calcSuperficie;
    }
    
    /**
     * 
     * Utiliza todos los metodos anteriores para poder imprimir un detalle de todas las figuras presentes, sus superficies, la cantidad metros a cubrir con pintura y la cantidad de latas que se 
     * necesitara comprar.
     * 
     * 
     */
    public void detallesFiguras(){
        System.out.println("Presupuesto: " + this.getNombre());
        for(FiguraGeometrica f : this.getFiguras()){
            f.mostrarSuperficie();
        }
        
        System.out.println("------------------------");
        System.out.println("Total a Cubrir: " + String.format("%.2f", this.cuantosMetros()));
        System.out.println("Comprar: " + this.cuantasLatas() + " " + "Latas");
    }
}