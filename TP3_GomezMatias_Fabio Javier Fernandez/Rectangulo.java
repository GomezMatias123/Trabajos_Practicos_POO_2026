
/**
 * 
 * Abstrae el concepto de rectagulo, se implementan metodos para poder manipular el tamaño, largo
 * y ubicacion del objeto.
 * 
 * @author (Gomez Matias, Fabio Javier Fernandez) 
 * @version (v1.0)
 * 
 */

public class Rectangulo
{
    
    
    private Punto origen;
    private double ancho;
    private double alto;
    
    
    
    /**
     * Constructores de la clase Rectangulo, se trata de un constructor sobrecargado, dada la
     * capacidad de posee dos constructores que se diferencian con sus parametros
     */

    public Rectangulo(Punto p_origen, double p_ancho, double p_alto) {
        
        this.setOrigen(p_origen);
        this.setAncho(p_ancho);
        this.setAlto(p_alto);
        
    }
    
    public Rectangulo(double p_ancho, double p_alto) {
        
        this.setOrigen(new Punto(0,0));
        this.setAncho(p_ancho);
        this.setAlto(p_alto);
        
    }
    
    /**
     * Usa las coordenadas x e y del orige para desplazar el rectangulo
     * 
     * param: recibe como parametro las coordenadas 
     * 
     */
    
    public void desplazar(double p_dx, double p_dy){
        
        this.getOrigen().desplazar(p_dx, p_dy);
        
    }
    
    /**
     * 
     * Imprime por pantalla los datos solicitados por el cliente
     * 
     */
    
    public void caracteristicas(){
        
        System.out.println("*****Rectangulo*****");
        System.out.println("Origen: " + this.getOrigen().coordenadas() + " " + "-Alto: " + 
        this.getAlto() + " - Ancho" + this.getAncho());
        System.out.println("Superficie: " + this.superficie() + " " + "-Perimetro " + 
        this.perimetro());
        
    }
    
    /**
     * Calcula el perimetro de un Rectangulo y retorna dicho valor
     * 
     * return: retorna el valor que representa el perimetro.
     * 
     * 
     */
    
    
    public double perimetro(){
        
        return (this.getAncho() * 2) + (this.getAlto() * 2);
        
    }
    
    /**
     * Calcula el superficie de un Rectangulo y retorna dicho valor
     * 
     * return: retorna el valor que representa el superficie.
     * 
     * 
     */
    
    public double superficie() {
        
        return this.getAncho() * this.getAlto();
    }
    
    /**
     * Calcula la distancia entre dos Rectangulos y retorna dicho valor
     * 
     * param: recibe como parametro un Rectangulos con el cual se calculara la distancia
     * return: retorna el valor que representa la distancia entre los dos puntos.
     * 
     * 
     */
    
    public double distanciaA(Rectangulo otroRectangulo) {
        
        return this.getOrigen().distanciaA(otroRectangulo.getOrigen());
    }
    
    /**
     * Obtiene el mayor entre dos Rectangulos y retorna dicho rectangulo
     * 
     * param: recibe como parametro un Rectangulos
     * return: retorna el rectangulo con una superficie mayor a otro.
     * 
     * 
     */
    
    
    public Rectangulo elMayor(Rectangulo otroRectangulo){
        if(otroRectangulo.superficie() > this.superficie()){
            System.out.println("El Rectangulo de mayor superficie es el de superficie: " + 
             otroRectangulo.superficie());
            return otroRectangulo;
        } else {
            System.out.println("El Rectangulo de mayor superficie es el de superficie: " + 
            this.superficie());
            return this;
        }
    }
    
     /**
     * 
     * Setters qe corresponden cada clase, cada uno se encarga de settear el atributo correspondiente
     * 
     * param: cada setteer recibe como parametro una representacion del atributo correspondiente
     * 
     * 
     */
    
    
    private void setOrigen(Punto p_origen){
        
        this.origen = p_origen;
        
    }
    
    private void setAncho(double p_ancho) {
        
        this.ancho = p_ancho;
        
    }
    
    private void setAlto(double p_alto) {
        
        this.alto = p_alto;
        
    }
    
    /**
     * 
     * los getters que corresponden a cada clase, cada uno se encarga de retornar el atributo correspondiente
     * 
     * @author Fernandez Fabio Javier y Matias Nicolas Gomez
     * @version 1.0
     * return: retornan su correspondiente atributo
     * 
     */
    
    
    
    
    
    public Punto getOrigen() {
        
        return this.origen;
        
    }
    
    public double getAncho() {
        
        return this.ancho;
        
    }
    
    public double getAlto() {
        
        return this.alto;
        
    }
}