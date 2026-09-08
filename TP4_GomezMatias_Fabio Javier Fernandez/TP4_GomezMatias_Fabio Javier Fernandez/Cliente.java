
/**
 * Write a description of class Cliente here.
 * 
 * @author (Gomez Matias, Fabio Javier Fernandez) 
 * @version (v1.0)
 */
public class Cliente
{
    private int nroDNI;
    private String apellido;
    private String nombre;
    private double saldo;
    
    
/**
 * Metodo constructor de la clase cliente.
 */ 

    public Cliente(int p_dni, String p_apellido, String p_nombre, double p_importe){
        setDNI(p_dni);
        setApellido(p_apellido);
        setNombre(p_nombre);
        setSaldo(p_importe);
    }
/**
 * Setter y getter de los objetos de la clase Cliente.
 */ 

private void setDNI(int p_dni) {
    nroDNI = p_dni;
}

private void setApellido(String p_apellido)  {
    apellido = p_apellido;
}

private void setNombre(String p_nombre) {
    nombre = p_nombre;
}

private void setSaldo(double p_importe) {
    saldo = p_importe;
}

public int getDNI(){
    return nroDNI;
}

public String getApellido(){
    return apellido;
}

public String getNombre(){
    return nombre;
}

public double getSaldo(){
    return saldo;
}

/**
 * Metodos para manipular el contenido del atributo saldo dentro de los objetos de la clase
 * Cliente que cuente con dicho atributo.
 */ 

  public double nuevoSaldo(double p_importe){
     return saldo = p_importe;     
  }
  
  public double agregarSaldo(double p_importe){
      return saldo = saldo + p_importe;
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
* Metodo mostrar dedicado a la impresion de los datos en pantalla
*/

public void mostrar(){
    System.out.println("-Cliente-");
    System.out.println("Nombre y Apellido: " +nomYApe() + "(" + getDNI() + ")");
    System.out.println("Saldo: $" + getSaldo());
}
  
}
