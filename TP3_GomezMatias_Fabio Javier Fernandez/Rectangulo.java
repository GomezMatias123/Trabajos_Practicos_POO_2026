
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
    //atributos
    
    private Punto origen;
    private double ancho;
    private double alto;
    

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
    
    public void desplazar(double p_dx, double p_dy){
        
        this.getOrigen().desplazar(p_dx, p_dy);
        
    }
    
    public void caracteristicas(){
        
        System.out.println("*****Rectangulo*****");
        System.out.println("Origen: " + this.getOrigen().coordenadas() + " " + "-Alto: " + 
        this.getAlto() + " - Ancho" + this.getAncho());
        System.out.println("Superficie: " + this.superficie() + " " + "-Perimetro " + 
        this.perimetro());
        
    }
    
    public double perimetro(){
        
        return (this.getAncho() * 2) + (this.getAlto() * 2);
        
    }
    
    public double superficie() {
        
        return this.getAncho() * this.getAlto();
    }
    
    public double distanciaA(Rectangulo otroRectangulo) {
        
        return this.getOrigen().distanciaA(otroRectangulo.getOrigen());
    }
    
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
    
    
    private void setOrigen(Punto p_origen){
        
        this.origen = p_origen;
        
    }
    
    private void setAncho(double p_ancho) {
        
        this.ancho = p_ancho;
        
    }
    
    private void setAlto(double p_alto) {
        
        this.alto = p_alto;
        
    }
    
    
    
    
    
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