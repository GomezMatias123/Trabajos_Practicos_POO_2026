
/**
 * Abstraccion del concepto de un laboratorio con sus datos necesarios para su identificacion
 * y manipulacion junto con otras clases que trabajan en conjunto.
 * 
 * @author (Gomez Matias, Fabio Javier Fernandez) 
 * @version (v1.0)
 */
public class Laboratorio
{
  private String nombre;
  private String domicilio;
  private String telefono;
  private int compraMinima;
  private int diaEntrega;
  
  
    /**
    * Metodo constructor perteneciente a la clase laboratorio, se utiliza dos constructores gracias 
    * a la posibildad de poder sobrecargarlos y diferenciarlos con sus parametros al recibir una 
    * cantidad diferentes a pesar de ser los mismos parametros que se envian.
    */

    public Laboratorio(String p_nombre, String p_domicilio, String p_telefono, int p_compraMin, 
    int p_diaEnt){
        
        setNombre(p_nombre);
        setDomicilio(p_domicilio);
        setTelefono(p_telefono);
        setCompraMin(p_compraMin);
        setDiaEntrega(p_diaEnt);  
    }
    
    public Laboratorio(String p_nombre, String p_domicilio, String p_telefono){
        
        setNombre(p_nombre);
        setDomicilio(p_domicilio);
        setTelefono(p_telefono);
    }
    
    /**
    * Setter correspondientes para poder instanciar objetos y darle los valores a sus atributos.
    *
    */
    
    private void setNombre(String p_nombre){
        nombre = p_nombre;
    }
    
    private void setDomicilio(String p_domicilio){
        domicilio = p_domicilio;
    }
    
    private void setTelefono(String p_telefono){
        telefono = p_telefono;
    }
    
        private void setCompraMin(int p_compraMin){
        compraMinima = p_compraMin;
    }
    
        private void setDiaEntrega(int p_diaEnt){
        diaEntrega = p_diaEnt;
    }
  
       /**
    * Getters correspondientes para poder obtener los datos/valores de los atributos de los objetos
    * de la clase.
    *
    */ 

    public String getNombre(){
        return nombre;
    }
    public String getDomicilio(){
        return domicilio;
    }
    public String getTelefono(){
        return telefono;
    }
    public int getCompraMin(){
        return compraMinima;
    }
    public int getDiaEntrega(){
        return diaEntrega;
    }
    
       /**
    * Metodos nuevaCompraMinima y nuevoDiaEntrega que permiten modificar los atributos del objeto
    * instanciado, funciona como prevencion ante cambios de politicas o reglas de negocio 
    * de la empresa que puedan cambiar con el tiempo.
    */ 
    
    public void nuevaCompraMinima(int p_compraMin){
        setCompraMin(p_compraMin);
    }
        
    public void nuevoDiaEntrega(int p_diaEnt){
        setDiaEntrega(p_diaEnt);  
    }
        
       /**
    * Metodos mostrar para imprmir toda la informacion en el formato indicado de la empresa/
    * laboratorio.
    */ 
    
    public void mostrar(){
        System.out.println("Laboratorio: " + " " + getNombre());
        System.out.println("Domicilio: " + " " + getDomicilio() + " " + "Telefono: " + " " + 
        getTelefono());
        System.out.println("Compra Minima: $" + getCompraMin() + " " + "Dia de entrega: " +
        " " + getDiaEntrega() + " " + "de cada mes");
    
    }
    
}