import java.util.*;

/**
 * Clase que hereda de la clase cargo, es una abstraccion de uno exclusivo
 * 
 * @author (Matias Gomez, Fabio Javier Fernandez) 
 * @version (v1.0)
 */
public class Exclusivo extends Cargo
{
   
    
    //atributos
    
    private int horasDeInvestigacion;
    private int horasDeExtension;
    
    /**
     * 
     * Es un constructor de la clase Exclusivo
     * 
     */
    
    public Exclusivo( int p_horasInv, int p_horasEx, String p_nombre, double p_sueldo, int p_anio, int p_horasCargo) {
        
        super(p_nombre, p_sueldo, p_anio, 0);
        this.setHorasDeDocencia(p_horasCargo);
        this.setHorasDeInvestigacion(p_horasInv);
        this.setHorasDeExtension(p_horasEx);
        
    }
    
    /**
     * 
     * imprime en pantalla los datos solicitados
     * 
     */
    
    
    public void mostrarCargo() {
        
        super.mostrarCargo();
        System.out.println("----Cargo de caracter Exclusivo----");
        System.out.println("Horas investigacion: " + this.getHorasDeInvestigacion());
        System.out.println("Horas Extension: " +    this.getHorasDeExtension());
        
    }
    
    /**
     * 
     * setters y getters que corresponden
     * 
     */
    
    private void setHorasDeDocencia(int p_horas) {
        
        this.horasDeDocencia = p_horas;
        
    }
    
    
    private void setHorasDeInvestigacion(int p_horasInv) {
        
        this.horasDeInvestigacion = p_horasInv;
        
    }
    
    
    private void setHorasDeExtension(int p_horasEx) {
        
        this.horasDeExtension = p_horasEx;
        
    }
    
    public int getHorasDeInvestigacion() {
        
        return this.horasDeInvestigacion;
        
    }
    
    public int getHorasDeExtension() {
        
        return this.horasDeExtension;
        
    }
    
}