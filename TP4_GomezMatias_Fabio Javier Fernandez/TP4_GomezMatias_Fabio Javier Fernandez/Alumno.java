
/**
 * Write a description of class Alumno here.
 * 
 * @author (Gomez Matias, Fabio Javier Fernandez) 
 * @version (v1.0)
 */
public class Alumno
{
    private int LU;
    private String nombre;
    private String apellido;
    private double nota1;
    private double nota2;
/**
* Metodo constructor de la clase Alumno.
*/   
  
public Alumno(int p_lu, String p_nombre, String p_apellido){
    setLU(p_lu);
    setNombre(p_nombre);
    setApellido(p_apellido);
    nota1 = 0;
    nota2 = 0;
}
/**
 * Setter y getter de los objetos de la clase Alumno.
 */ 

    private void setLU(int p_lu){
        LU = p_lu;
    }
    private void setApellido(String p_apellido)  {
    apellido = p_apellido;
    }

    private void setNombre(String p_nombre) {
    nombre = p_nombre;
    }
    
    public int getLU(){
        return LU;
    }
    
      public String getNombre(){
        return nombre;
    }
    
      public String getApellido(){
        return apellido;
    }
    
      public double getNota1(){
        return nota1;
    }
    
      public double getNota2(){
        return nota2;
    }
    
    
    
    
/**
 * Reciben por parametro las notas ingresadas respectivas de cada, mediante los parametros del
 * metodo ejecutable de la clase correspondiente "notasAlumnos"
 */ 
    public double setNota1(double p_N1){
        return nota1 = p_N1;
    }
    
    public double setNota2(double p_N2){
        return nota2 = p_N2;
    }
    
    
    
    
    
    
    
    
/**
 * Dentro del metodo aprueba() se determina si el alumno cumple las condiciones necesarias
 * para estar aprobado devolviendo un dato boleano "true", caso contrario devuelve false"
 */ 
    private boolean aprueba(){
        if(promedio() >= 7 && nota1 >= 6 && nota2 >= 6){
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
        return (nota1 + nota2)/2;
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

    public void mostrar(){
        System.out.println("Nombre y Apellido: " + nomYApe());
        System.out.println("L.U.:  " + getLU() + " " + "Notas: " + getNota1() + "-" + 
        getNota2());
        System.out.println("Promedio " + promedio() + " " + leyendaAprueba());
        System.out.println("------------------------------------------------" );
    }
}