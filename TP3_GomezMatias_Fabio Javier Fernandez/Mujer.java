
/**
 * Write a description of class Mujer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mujer {
    
    //atributos
    
    private String nombre;
    private String apellido;
    private int edad;
    private String estadoCivil;
    private Hombre esposo;
    
    //metodos
    
    /**
     * 
    * Metodos constructores perteneciente a la clase mujer, los constructores osbrecargados se diferencian por el use del parametro p_espos 
    * 
    */
    
    public Mujer(String p_nombre, String p_apellido, int p_edad) {
        
        this.setNombre(p_nombre);
        this.setApellido(p_apellido);
        this.setEdad(p_edad);
        this.setEstadoCivil("Soltera");
        
    }
    
    public Mujer(String p_nombre, String p_apellido, int p_edad, Hombre p_esposo){
        
        this.setNombre(p_nombre);
        this.setApellido(p_apellido);
        this.setEdad(p_edad);
        this.casarseCon(p_esposo);
        
    }
    
     /*
     * 
     * 
     * @author Fernandez Fabio Javier y Matias Nicolas Gomez
     * @version 1.0
     * param: representa al conyugue
     * 
     */
    
    
    
    public void casarseCon(Hombre p_hombre) {
        
        this.setEsposo(p_hombre);
        this.setEstadoCivil("Casada");
        
    }
    
    /*
     * 
     * 
     * @author Fernandez Fabio Javier y Matias Nicolas Gomez
     * @version 1.0
     * pone los valores del conyugue en null y cambia el estado civil a divorciado
     * 
     */
    
    public void divorcio() {
        
        this.setEsposo(null);
        this.setEstadoCivil("Divorciada");
        
    }
    
    /*
     * 
     * 
     * @author Fernandez Fabio Javier y Matias Nicolas Gomez
     * @version 1.0
     * retorna un string con los datos solicitados por uno de los clientes
     * 
     */
    
    public String datos() { 
        
        return this.getNombre() + " " + this.getApellido() + " de " + this.getEdad() + " años";
        
    }
    
    /*
     * 
     * Imprime por pantalla los datos solicitados por el cliente
     * 
     * @author Fernandez Fabio Javier y Matias Nicolas Gomez
     * @version 1.0
     * 
     * 
    */
    
    public void mostrarEstadoCivil() {
        
        System.out.println(this.getNombre() + " " + this.getApellido() + " de " + this.getEdad() 
                            + " años - " + this.getEstadoCivil());
                            
    }
    
    /*
     * 
     * Imprime por pantalla los datos solicitados por el cliente
     * 
     * @author Fernandez Fabio Javier y Matias Nicolas Gomez
     * @version 1.0
     * 
     * 
     */
    
    
    public void casadaCon() {
        
        if(this.getEstadoCivil() == "Casada") {
            
            System.out.println(this.datos() + " esta casada con " + this.getEsposo().datos());
        } else {
            
            System.out.print("No se encuentra casada, revise los datos en caso de error");
            this.mostrarEstadoCivil();
            
        }
            
    }
        
        /*
     * 
     * Setters qe corresponden cada clase, cada uno se encarga de settear el atributo correspondiente
     * 
     * @author Fernandez Fabio Javier y Matias Nicolas Gomez
     * @version 1.0
     * param: cada setteer recibe como parametro una representacion del atributo correspondiente
     * 
     * 
     */
    
    
    private void setNombre(String p_nombre) {
        
        this.nombre = p_nombre;
        
    }
    
    private void setApellido(String p_apellido) {
        
        this.apellido = p_apellido;
        
    }
    
    private void setEstadoCivil(String p_EstadoCivil) {
        
        this.estadoCivil= p_EstadoCivil;
        
    }
    
    private void setEsposo(Hombre p_hombre) {
        
        this.esposo = p_hombre;
        
    }
    
    private void setEdad(int p_edad) {
        
        this.edad= p_edad;
        
    }
    
    /*
     * 
     * los getters que corresponden a cada clase, cada uno se encarga de retornar el atributo correspondiente
     * 
     * @author Fernandez Fabio Javier y Matias Nicolas Gomez
     * @version 1.0
     * return: retornan su correspondiente atributo
     * 
     */
    
    public String getNombre() {
        
        return this.nombre;
        
    }
    
    public String getApellido() {
        
        return this.apellido;
        
    }
    
    public int getEdad() {
        
        return this.edad;
        
    }
    
    public Hombre getEsposo() {
        
        return this.esposo;
    }
    
    public String getEstadoCivil() {
        
        return this.estadoCivil;
        
    }
    
}