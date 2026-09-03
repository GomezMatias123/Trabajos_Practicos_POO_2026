import java.util.GregorianCalendar;
import java.util.Calendar;

/**
 * Write a description of class Empleado here.
 * 
 * @author (Gomez Matias, Fabio Javier Fernandez) 
 * @version (v1.0)
 */
public class Empleado
{
   private long cuil;
   private String apellido;
   private String nombre;
   private double sueldoBasico;
   private int anioIngreso;
   
   /**
 * Metodo constructor de la clase Empleado.
 */
   public Empleado(long p_cuil, String p_apellido, String p_nombre, double p_importe, 
   int p_anio){
       setCuil(p_cuil);
       setApellido(p_apellido);
       setNombre(p_nombre);
       setSueldoBasico(p_importe);
       setAnioIngreso(p_anio);
   }
   
   
 /**
 * Setter y getter los objetos de la clase Empleado
 */ 

    private void setCuil(long p_cuil){
        cuil = p_cuil;   
    }
    private void setApellido(String p_apellido){
        apellido = p_apellido;   
    }
    private void setNombre(String p_nombre){
        nombre = p_nombre;   
    }
    private void setSueldoBasico(double p_importe){
        sueldoBasico = p_importe;   
    }
    private void setAnioIngreso(int p_anio){
        anioIngreso = p_anio;   
    }
    
    private long getCuil(){
        return cuil;
    }
    private String getNombre(){
        return nombre;
    }
    private String getApellido(){
        return apellido;
    }
    private double getSueldoBasico(){
        return sueldoBasico;
    }
    private int getAnioIngreso(){
        return anioIngreso;
    }
/**
 * Metodo antiguedad() devuelve la cantidad en años mediante una cuenta entre el año que
 * ingreso el empleado a la empresa y el año en curso.
 */ 
 
public int antiguedad(){
    Calendar fechaHoy = new GregorianCalendar();
    int anioHoy = fechaHoy.get(Calendar.YEAR);
    return anioHoy - getAnioIngreso();
    }
/**
 * Metodos descuento() y adicional() trabajan con el atributo sueldo basico para realizar los 
 * calculos necesarios para llegar al sueldo neto mediante el metodo sueldoNeto().
 * descuento() realiza el calculo de 2% correspondiente a obra social + 1500 correspondientes 
 * al seguro de vida segun como especifica la consigna para restar al sueldo basico.
 * adicional() devuelve el porcetnaje extra que se suma al sueldo basico segun la antiguedad 
 * del empleado, que se calcula gracias al metodo antiguedad().
 * sueldoNeto() simplemente envia un mensajes al objeto empleado para obtener el sueldo 
 * basico, el adicional segun la antiguedad del empleado y el descuento que se resta para
 * poder obtener el sueldo neto correspondiente segun indica la consigna.
 */ 

private double adicional(){
    
    if(antiguedad() < 2) {
        return getSueldoBasico()*0.02;
    } else {
        if(antiguedad() >= 2 && antiguedad() < 10){
           return getSueldoBasico()*0.04;
        } else {
            return getSueldoBasico()*0.06;
        }
    }
}

private double descuento(){
    return (sueldoBasico * 0.02) + 1500;
}

public double sueldoNeto(){
    return (getSueldoBasico() + adicional()) - descuento();
}

    /**
* Implementacion de los metodos nomYape y apeYnom para la correcta
* impresion de los datos solicitados.
*/
  public String nomYApe(){
        return getNombre() + "," + " " + getApellido();
        
    }
    
  public String apeYNom(){
        return getApellido() + "," + getNombre();
        
    }
    
/**
 * Metodo mostrar() imoprime más en detalle los datos del empleado ya con el suelo neto
 * impreso, en cambio mostrarLinea() es un metodo que imprime de una forma mas resumida y en 
 * una sola linea la informacion del empleado.
 */ 

public void mostrar(){
    System.out.println("Nombre y Apellido: " + nomYApe());
    System.out.println("Cuil: " + getCuil() + " " + "Antiguedad: " + antiguedad() + " " +
    "años de servicio");
    System.out.println("Sueldo Neto: $" + sueldoNeto());
}

public String mostrarLinea(){
 return getCuil() + " " + apeYNom() + "................. $" + sueldoNeto();
}
}