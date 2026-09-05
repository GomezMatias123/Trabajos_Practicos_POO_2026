
/**
 * La clase Circulo tiene como funcion modelar la contrucion la figura geometrica circulo 
 * permitiendo representar su radio, calcular su permitero, superficie y representar su centro
 * con la ayuda de la clase Punto que representara el mismo.
 * 
 * @author Fernandez Fabio Javier y Matias Nicolas Gomez
 * @version 1.0
 */
public class Circulo
{
    
    // atributos
   private double radio;
   private Punto centro;
    
   
   /*
     * Constructores de la clase Circulo, se trata de un constructor sobrecargado, dada la
     * capacidad de posee dos constructores que se diferencian con sus parametros
     */
    
    public Circulo(double p_radio, Punto p_centro){
        this.setRadio(p_radio);
        this.setCentro(p_centro);
    }
    
    public Circulo(){
        this.setRadio(0);
        this.setCentro(new Punto());
    }
        
    /*
     * 
     * Setters qe corresponden cada clase, cada uno se encarga de settear el atributo correspondiente
     * 
     * @author Fernandez Fabio Javier y Matias Nicolas Gomez
     * @version 1.0
     * param: cada setteer recibe como parametro una representacion del atributo correspondiente
     * 
     * 
     */
    
    private void setRadio(double p_radio){
        this.radio = p_radio;
    }
    
    private void setCentro(Punto p_centro){
        this.centro = p_centro;
    }
    
    
    /*
     * 
     * los getters que corresponden a cada clase, cada uno se encarga de retornar el atributo correspondiente
     * 
     * @author Fernandez Fabio Javier y Matias Nicolas Gomez
     * @version 1.0
     * return: retornan su correspondiente atributo
     * 
     */
    
    public double getRadio(){
        return this.radio;
    }
    
     public Punto getCentro(){
        return this.centro;
    }
    
    
    /*
     * Usa las coordenadas x e y del orige para desplazar el Circulo
     * 
     * param: recibe como parametro las coordenadas
     * 
     */
    
    public void desplazar(double p_x, double p_y){
        this.centro.desplazar(p_x, p_y);        
    }
    
    /*
     * Calcula el perimetro de un Circulo y retorna dicho valor
     * 
     * return: retorna el valor que representa el perimetro.
     * 
     * 
     */
    
    public double perimetro(){
        double perimetro = this.getRadio()*2* Math.PI;
        return Math.round(perimetro*100.0)/100.0;
    }
    
    /*
     * Calcula el superficie de un Circulo y retorna dicho valor
     * 
     * return: retorna el valor que representa el superficie.
     * 
     * 
     */
    
    public double superficie(){
        double superficie = Math.PI * Math.pow(this.getRadio(), 2);
        return Math.round(superficie*100.0)/100.0;
    }
    
    /*
     * Obtiene el mayor entre dos Circulos y retorna dicho Circulo
     * 
     * param: recibe como parametro un Circulos
     * return: retorna el Circulo con una superficie mayor a otro.
     * 
     * 
     */
    
    public Circulo elMayor(Circulo otroCirculo){
        if(otroCirculo.superficie() > this.superficie()){
            System.out.println("El circulo de mayor superficie es el de radio: " + 
            otroCirculo.getRadio());
            return otroCirculo;
        } else {
            System.out.println("El circulo de mayor superficie es el de radio: " + 
            this.getRadio());
            return this;
        }
    }
    
    /*
     * 
     * Imprime por pantalla los datos solicitados por el cliente
     * 
     * @author Fernandez Fabio Javier y Matias Nicolas Gomez
     * @version 1.0
     * 
     * 
     */
    
    public void caracteristicas(){
        System.out.println("*****Circulo*****");
        System.out.println("Centro: " + this.getCentro().coordenadas() + " " + "-Radio: " + 
        this.getRadio());
        System.out.println("Superficie: " + this.superficie() + " " + "-Perimetro " + 
        this.perimetro());
    }
    
    
}