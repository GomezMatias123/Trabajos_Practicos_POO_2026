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
       private Calendar fechaIngreso;
       private Empleado jefe;
       
      /**
      * Metodo constructor de la clase Empleado.
      */
    
      public Empleado(long p_cuil, String p_apellido, String p_nombre, double p_importe, 
           int p_anio){
        this.setCuil(p_cuil);
        this.setApellido(p_apellido);
        this.setNombre(p_nombre);
        this.setSueldoBasico(p_importe);
        this.setAnioIngreso(p_anio);
      }
      
      /**
      * Metodo constructor de la clase Empleado.
      */
    
      public Empleado(long p_cuil, String p_apellido, String p_nombre, double p_importe, 
           Calendar p_fecha){
        this.setCuil(p_cuil);
        this.setApellido(p_apellido);
        this.setNombre(p_nombre);
        this.setSueldoBasico(p_importe);
        this.setFechaIngreso(p_fecha);
      }
      
      
      
      public Empleado(long p_cuil, String p_apellido, String p_nombre, double p_importe, 
           Calendar p_fecha, Empleado p_jefe){
        this.setCuil(p_cuil);
        this.setApellido(p_apellido);
        this.setNombre(p_nombre);
        this.setSueldoBasico(p_importe);
        this.setFechaIngreso(p_fecha);
        this.setJefe(p_jefe);
           }
   
         /**
         * Setter y getter los objetos de la clase Empleado
         */ 
        
      private void setJefe(Empleado p_jefe){
          this.jefe= p_jefe;
        }
        
      private void setFechaIngreso(Calendar p_fecha) {
          
           this.fechaIngreso = p_fecha;
      }
        
      private void setCuil(long p_cuil){
        this.cuil = p_cuil;   
      }
      
      private void setApellido(String p_apellido){
        this.apellido = p_apellido;   
      }
      
      private void setNombre(String p_nombre){
        this.nombre = p_nombre;   
      }
      
      private void setSueldoBasico(double p_importe){
        this.sueldoBasico = p_importe;   
      }
      
      private void setAnioIngreso(int p_anio){
          
        this.fechaIngreso = new GregorianCalendar();
        
          
        this.fechaIngreso.set(Calendar.YEAR, p_anio);
        
        
      }
      
       public Empleado getJefe(){
          return this.jefe;
      }
        
      public Calendar getFechaIngreso() {
          
          return this.fechaIngreso;
      }
        
      public long getCuil(){
        return this.cuil;
      }
      
      public String getNombre(){
        return this.nombre;
      }
      
      public String getApellido(){
        return this.apellido;
      }
      
      public double getSueldoBasico(){
        return this.sueldoBasico;
      }
      
      public int getAnioIngreso(){
        return this.fechaIngreso.get(Calendar.YEAR);
      }
      
        /**
         * Metodo antiguedad() devuelve la cantidad en años mediante una cuenta entre el año que
         * ingreso el empleado a la empresa y el año en curso.
         */ 
         
      public int antiguedad(){
        Calendar fechaHoy = new GregorianCalendar();
        int anioHoy = fechaHoy.get(Calendar.YEAR);
        return anioHoy - this.getAnioIngreso();
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
            
         if(this.antiguedad() < 2) {
             return this.getSueldoBasico()*0.02;
         } else {
             if(this.antiguedad() >= 2 && this.antiguedad() < 10){
                  return this.getSueldoBasico()*0.04;
             } else {
                  return this.getSueldoBasico()*0.06;
             }
         }
      }
        
      private double descuento(){
            return (this.getSueldoBasico() * 0.02) + 1500;
      }
        
      public double sueldoNeto(){
            return (this.getSueldoBasico() + this.adicional()) - this.descuento();
      }
        
      /**
      * Implementacion de los metodos nomYape y apeYnom para la correcta
      * impresion de los datos solicitados.
      */
      public String nomYApe(){
                return this.getNombre() + "," + " " + this.getApellido();
                
      }
        
      public String apeYNom(){
            return this.getApellido() + "," + this.getNombre();
            
      }
        
      /**
      * Metodo mostrar() imoprime más en detalle los datos del empleado ya con el suelo neto
      * impreso, en cambio mostrarLinea() es un metodo que imprime de una forma mas resumida y en 
      * una sola linea la informacion del empleado.
      */ 
        
      public void mostrar(){
            System.out.println("Nombre y Apellido: " + this.nomYApe());
            System.out.println("Cuil: " + this.getCuil() + " " + "Antiguedad: " + this.antiguedad() + " " +
            "años de servicio");
            System.out.println("Sueldo Neto: $" + this.sueldoNeto());
            System.out.println(this.getJefe() == null ? "Gerente General" : "Responde a: " +
            this.getJefe().apeYNom());
      }
        
      public String mostrarLinea(){
         return this.getCuil() + " " + this.apeYNom() + "................. $" + this.sueldoNeto();
      }
      
      public boolean esAniversario() {
          Calendar fecha  = Calendar.getInstance();
          
          return this.getFechaIngreso().get(Calendar.DAY_OF_MONTH) ==  fecha.get(Calendar.DAY_OF_MONTH) && 
                 this.getFechaIngreso().get(Calendar.MONTH) == fecha.get(Calendar.MONTH); 
      }
}