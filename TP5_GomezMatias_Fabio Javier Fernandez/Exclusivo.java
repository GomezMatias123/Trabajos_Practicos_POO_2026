import java.util.*;

/**
 * Write a description of class Exclusivo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Exclusivo extends Cargo
{
   
    
    //atributos
    
    int horasDeInvestigacion;
    int horasDeExtension;
    
    public Exclusivo( int p_horasInv, int p_horasEx, String p_nombre, double p_sueldo, int p_anio, int p_horasCargo) {
        
        super(p_nombre, p_sueldo, p_anio, p_horasCargo);
        this.setHorasDeInvestigacion(p_horasInv);
        this.setHorasDeExtension(p_horasEx);
        
    }
    
    public void mostrarCargo() {
        
        super.mostrarCargo();
        System.out.println("----Cargo de caracter Exclusivo----");
        System.out.println("Horas investigacion: " + this.getHorasDeInvestigacion());
        System.out.println("Horas Extension: " +    this.getHorasDeExtension());
        
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