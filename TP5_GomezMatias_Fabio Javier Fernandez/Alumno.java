import java.util.*;
/**
 * Es una abstraccion de la clase alumno actualizada para heredar la clase persona
 * 
 * @author (Gomez Matias, Fabio Javier Fernandez) 
 * @version (v2.0)
 */
public class Alumno extends Persona
{
    private int LU;
    private double nota1;
    private double nota2;
    /**
    * Metodo constructor de la clase Alumno.
    */   
      
    public Alumno(int p_lu, int p_dni, String p_nombre, String p_apellido, Calendar p_fecha){
        
        super(p_dni, p_nombre, p_apellido, p_fecha);
        this.setLU(p_lu);
        this.nota1 = 0;
        this.nota2 = 0;
    }
    
    
    public Alumno(int p_lu, int p_dni, String p_nombre, String p_apellido, int p_anio){
        
        super(p_dni, p_nombre, p_apellido, p_anio);
        this.setLU(p_lu);
        this.nota1 = 0;
        this.nota2 = 0;
    }
    
    
    
    /**
     * Setter y getter de los objetos de la clase Alumno.
     */ 
    
    private void setLU(int p_lu){
        
         this.LU = p_lu;
         
    }
        
    public int getLU(){
        
        return this.LU;
        
    }
    
      public double getNota1(){
        return this.nota1;
    }
    
      public double getNota2(){
        return this.nota2;
    }
    
    /**
     * Reciben por parametro las notas ingresadas respectivas de cada, mediante los parametros del
     * metodo ejecutable de la clase correspondiente "notasAlumnos"
     */ 
    public double setNota1(double p_N1){
        return this.nota1 = p_N1;
    }
    
    public double setNota2(double p_N2){
        return this.nota2 = p_N2;
    }    
    
    /**
     * Dentro del metodo aprueba() se determina si el alumno cumple las condiciones necesarias
     * para estar aprobado devolviendo un dato boleano "true", caso contrario devuelve false"
     */ 
    private boolean aprueba(){
        if(this.promedio() >= 7 && this.nota1 >= 6 && this.nota2 >= 6){
            return true;
        } else{
            return false;
        }
    }
    
    /**
     * Segun el dato obtenido en el metodo aprueba() imprime la leyenda correspondiente si esta
     * aprobado o desaprobado.
     */ 
    private String leyendaAprueba(){
        if(aprueba()){
            return "APROBADO";
        } else {
            return "DESAPROBADO";
        }
    }
    
    /**
     * Determina mediante un calculo de las notas de cada alumno su promedio.
     */    
     
    public double promedio(){
        
        return (this.nota1 + this.nota2)/2;
        
    }

    /**
     * 
     * imprime en pantalla los datos solicitados
     * 
     * 
     */
    public void mostrar(){
      
        super.mostrar();
        System.out.println("L.U.:  " + this.getLU() + " " + "Notas: " + this.getNota1() + "-" + 
        this.getNota2());
        System.out.println("Promedio " + promedio() + " " + leyendaAprueba());
        
    }
}