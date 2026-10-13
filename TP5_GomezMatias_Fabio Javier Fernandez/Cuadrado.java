
/**
 * Abastraccion de la figura geometrica cuadrado, que hereda atributos y metodos de la clase rectangulo
 * siendo que un cuadrado es un rectangulo pero no todo rectangulo es un cuadrado.
 * 
 * @author (Gomez Matias, Fabio Javier Fernandez) 
 * @version (v1.0)
 */
public class Cuadrado extends Rectangulo
{

    public Cuadrado(Punto p_origen, double p_lado) {
        super(p_origen, p_lado, p_lado);
    }
    /**
     * Imprime el tipo de figuras con que se esta trabajando.
     * 
     */
    public String nombreFigura(){
        return "****** Cuadrado ******";
    }
    
    /**
     * Imprime las caracteristicas espeficas de la figura correspondiente a esta clase.
     * 
     */
    public void caracteristicas(){
        nombreFigura();
        System.out.println("Origen: " + this.getOrigen().coordenadas() + " " + "-Lado: " + 
        this.getAlto());
        System.out.println("Superficie: " + this.superficie() + " " + "-Perimetro " + 
        this.perimetro());
    }
    
    
}