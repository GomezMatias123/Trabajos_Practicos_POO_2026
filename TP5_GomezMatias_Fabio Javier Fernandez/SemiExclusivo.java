import java.util.Scanner;
/**
 * Clase que hereda de la clase cargo, es una abstraccion de uno semiexclusivo
 * 
 * @author (Matias Gomez, Fabio Javier Fernandez) 
 * @version (v1.0)
 * 
 */
public class SemiExclusivo extends Cargo
{
    //atributos
    
    private int horasDeInvestigacion;
    
    /**
     * 
     * Es un constructor de la clase SemiExclusivo
     * 
     */
    
    public SemiExclusivo(String p_nombreCargo, double p_sueldo, int p_anio, int p_horasDocencia, int p_horasInvestigacion) {
        
        super(p_nombreCargo, p_sueldo, p_anio, 0);
        
        Scanner teclado = new Scanner(System.in);
        
        this.setHorasDeDocencia(p_horasDocencia);
        
        this.setHorasDeInvestigacion(p_horasInvestigacion);
        
        
    }
    
    /**
     * 
     * imprime en pantalla los datos solicitados
     * 
     */
    
    
    public void mostrarCargo() {
        
        super.mostrarCargo();
        
        
        System.out.println("----Cargo de caracter SemiExclusivo----");
        System.out.println("Horas de Investigacion: " + this.getHorasDeInvestigacion());
        
    }
    
    /**
     * 
     * setters y getters que corresponden
     * 
     */
    
    public void  setHorasDeDocencia(int p_horasDoc) {
        
        Scanner teclado = new Scanner(System.in);     
            
        while (p_horasDoc <= 10 || p_horasDoc > 20) {
            
            System.out.println("Este cargo no puede tener mas de 20 horas asignadas y debe tener 10 horas de docencia, ingrese un valor valido");
            p_horasDoc = teclado.nextInt();
            
        }
        
        this.horasDeDocencia = p_horasDoc;
    }
    
    private void setHorasDeInvestigacion(int p_horasInv) {
        
          Scanner teclado = new Scanner(System.in); 
        
          while(this.getHorasDeDocencia() + p_horasInv > 20) {
                
                System.out.println("Este cargo no puede tener mas de 20 horas asignadas, ingrese un valor valido");
                p_horasInv = teclado.nextInt();
            
            } 
            
          this.horasDeInvestigacion = p_horasInv;
            
        
        
    }
    
    public int getHorasDeInvestigacion() {
        
        return this.horasDeInvestigacion;
        
    }
}