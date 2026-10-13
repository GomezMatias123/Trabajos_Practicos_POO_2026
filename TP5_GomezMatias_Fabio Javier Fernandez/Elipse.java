
/**
 * La clase Elipse tiene como funcion modelar la contrucion la figura geometrica elipse 
 * permitiendo representar su superficie y representar su centro
 * con la ayuda de la clase Punto que representara el mismo.
 * 
 * @author Fernandez Fabio Javier y Matias Nicolas Gomez
 * @version 1.0
 */
public class Elipse extends FiguraGeometrica
{
    private double rEjeMayor;
    private double sEjeMenor;
    
    
    /**
     * Constructor de la clase Elipse.
     * @param: p_ejeMayor corresponde al eje mayor o radio, p_ejeMenor corresponde al eje menor o superficie,
     * y p_centro que corresponde al centro de la elipse o punto de origen.
     */
    
    public Elipse (double p_ejeMayor, double p_ejeMenor, Punto p_centro){
        super(p_centro);
        setEjeMayor(p_ejeMayor);
        setEjeMenor(p_ejeMenor);
    }
    
     /**
     * 
     * Setters y getters, cada uno se encarga de settear el atributo correspondiente y getters nos trae el valor de cada atributo.
     * 
     * @param: cada setteer recibe como parametro una representacion del atributo correspondiente
     * 
     */
    
    private void setEjeMayor(double p_ejeMayor){
        this.rEjeMayor = p_ejeMayor;
    }
    
    public double getEjeMayor(){
        return this.rEjeMayor;
    }
    
    private void setEjeMenor(double p_ejeMenor){
        this.sEjeMenor = p_ejeMenor;
    }
    
    public double getEjeMenor(){
        return this.sEjeMenor;
    }
    
    /**
     * Imprime el tipo de figuras con que se esta trabajando.
     * 
     */
     public String nombreFigura(){
        return "****** Elipse ******";
    }
    /**
     * Devuelve el resultado del calculo para obtener la superficiete de esta figura en especifico.
     * 
     * @return: devuelve como valor double el valor de la superficie de la figura.
     */
    public double superficie(){
        return  Math.PI * this.getEjeMayor() * this.getEjeMenor();
    }
    /**
     * Imprime las caracteristicas correspondientes a esta clase de figura
     * 
     */
    public void caracteristicas(){
        System.out.println(this.nombreFigura());
        System.out.println("Centro: " + super.getOrigen().coordenadas() + "-" + "-Semieje Mayor: " + 
        this.getEjeMayor() + " - Semieje Menor: " + this.getEjeMenor());
        System.out.println("Superficie: " + this.superficie());
    }
    
    /**
    * desplazar(p_x, p_y) recibe dos valores del tipo de valor double, y se los envia mediante el mensaje del metodo desplazar al atributo origen/centro de la figura que se de clase Punto que 
    * entiende este mensaje por ser parte de su protocolo.
    * 
    * @param: double p_x, double p_y
    * 
    */ 
    
     public void desplazar(double p_x, double p_y){
        super.getOrigen().desplazar(p_x, p_y);        
    }
    
    /**
     * Calcula la distancia entre dos elipse y retorna dicho valor
     * 
     * @param: recibe como parametro una elipse con el cual se calculara la distancia
     * @return: retorna el valor que representa la distancia entre los dos puntos.
     * 
     * 
     */
    
    public double distanciaA(Elipse otraElipse) {
        return this.getOrigen().distanciaA(otraElipse.getOrigen());
    }
    
    /**
     * Obtiene el mayor entre dos Rectangulos y retorna dicho rectangulo
     * 
     * @param: recibe como parametro un Rectangulos
     * @return: retorna el rectangulo con una superficie mayor a otro.
     * 
     * 
     */
    
    
    public Elipse elMayor(Elipse otraElipse){
        if(otraElipse.superficie() > this.superficie()){
            System.out.println("El mayor es el de la de superficie: " + 
             otraElipse.superficie());
            return otraElipse;
        } else {
            System.out.println("El mayor es el de la de superficie: " + 
            this.superficie());
            return this;
        }
    }
    
}