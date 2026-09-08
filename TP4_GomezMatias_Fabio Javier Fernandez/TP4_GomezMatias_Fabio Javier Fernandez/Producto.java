
/**
 * La clase producto tiene como funcion modelar los productos de una drogueria,
 * permite operar los mismos y sus valores, asi como mostrarlos por pantalla.
 * 
 * @author Fernandez Fabio Javier y Matias Nicolas Gomez
 * @version 1.0
 */
public class Producto
{
    // atributos
    
    private int codigo;
    private String rubro;
    private String descripcion;
    private double costo;
    private int stock;
    private double porcPtoRepo;
    private int existMinima;
    private Laboratorio laboratorio;

    //metodos
    /*
     * Constructor de la clase Producto, se trata de un constructor sobrecargado, dada la
     * capacidad de posee dos constructores que se diferencian con sus parametros
     * 
     */
    
    public Producto(int p_codigo, String  p_rubro, String p_desc, double p_costo, 
    double p_porcPtoRepo, int p_existMinima, Laboratorio p_laboratorio) {
        
        this.setCodigo(p_codigo);
        this.setRubro(p_rubro);
        this.setDescripcion(p_desc);
        this.setCosto(p_costo);
        this.setStock(0);
        this.setPorcPtoRepo(p_porcPtoRepo);
        this.setExistMinima(p_existMinima);
        this.setLaboratorio(p_laboratorio);
        
    }
    
    public Producto(int p_codigo, String  p_rubro, String p_desc, double p_costo, 
    Laboratorio p_laboratorio){
        
        this.setCodigo(p_codigo);
        this.setRubro(p_rubro);
        this.setDescripcion(p_desc);
        this.setCosto(p_costo);
        this.setStock(0);
        this.setLaboratorio(p_laboratorio);
        
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
    
    public void mostrar() {
        
        this.getLaboratorio().mostrar();
        System.out.println("\nRubro: " + this.getRubro());
        System.out.println("Descripcion: " + this.getDescripcion());
        System.out.println("Precio Costo: " + this.costo );
        System.out.print("Stock: " + this.stock);
        System.out.printf(" - Stock Valorizado: $%.2f%n",  this.stockValorizado());
        
    }
    
    
    
    
    
    /*
     * 
     * Ajusta la cantidad de stock disponible al sumar o restar la cantidad recibida por parametro.
     * 
     * @author Fernandez Fabio Javier y Matias Nicolas Gomez
     * @version 1.0
     * param: recibe la cantidad a restar o sumar.
     * 
     */
    
    public void ajuste( int p_cantidad) {
        
        this.setStock(this.getStock() + p_cantidad);
        
    }
    
    
    
    /*
     * 
     * Calcula el stock valorizado al multiplicar el stock con el costo y añadir una rentabilidad del 12%
     * 
     * @author Fernandez Fabio Javier y Matias Nicolas Gomez
     * @version 1.0
     * return: retorna el valor que representa el stock valorizado 
     * 
     */
    
    public double stockValorizado() {
        
        double rentabilidad = 1.12; //se evita el uso de constantes a traves de variables
        
        return (this.stock * this.costo) * rentabilidad;
        
    }
    
    
    /*
     * 
     * Calcula el precio de lista al añadir una rentabilidad del 12% al costo
     * 
     * @author Fernandez Fabio Javier y Matias Nicolas Gomez
     * @version 1.0
     * return: retorna el valor que representa al precio lista
     * 
     */
    
    public double precioLista(){
        
        double precioAdicional = 1.12; //se evita el uso de constantes a traves de variables
        double resultado = this.costo * precioAdicional;
        return Math.round(resultado * 100.0)/100.0;
        
    }
    
    
    
    /*
     * 
     * Calcula el precio de contado al aplicar un descuento del 5%
     * 
     * @author Fernandez Fabio Javier y Matias Nicolas Gomez
     * @version 1.0
     * return: retorna el valor que representa al precio contado
     * 
     */
    
    public double precioContado() {
        
        double descuento = 0.05;
        double resultado = this.precioLista() - (this.precioLista() * descuento);
        return  Math.round(resultado * 100.0) / 100.0;
        
    }
    
    
    /*
     * 
     * Retorna un string co el siguiente formato "Jabón Deluxe 11.20 10.64"
     * 
     * @author Fernandez Fabio Javier y Matias Nicolas Gomez
     * @version 1.0
     * return: retorna  string con los datos y el formato qe se solicitaron
     * 
     */
    
    public String mostrarLinea() {
        
        return this.getDescripcion() + " " + this.precioLista() + " " + this.precioContado();
        
    }
    
    
     /*
     * 
     * Permite ajustar el porcentaje de punto de reposicion
     * 
     * @author Fernandez Fabio Javier y Matias Nicolas Gomez
     * @version 1.0
     * param: recibe el valor al que se quiere actualizar
     * 
     */
    
    public void ajustarPtoRepo(double p_porce) {
        
        this.setPorcPtoRepo(p_porce);
        
    }
    
     /*
     * 
     * Permite ajustar el valor de existencia minima
     * 
     * @author Fernandez Fabio Javier y Matias Nicolas Gomez
     * @version 1.0
     * param: recibe el valor al que se quiere actualizar
     * 
     */
    
    public void ajustarExistMin(int p_cantidad) {
        
        this.setExistMinima(p_cantidad);
        
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
    
    private void setCodigo (int p_codigo ) {
        
        this.codigo = p_codigo;
    
    }
    
    private void setRubro (String p_rubro ) {
        
        this.rubro = p_rubro;
    
    }
    
    private void setDescripcion (String p_descripcion  ) {
        
        this.descripcion = p_descripcion;
    
    }
    
    private void setCosto (double p_costo ) {
        
        this.costo = p_costo;
    
    }
    
    private void setStock (int p_stock ) {
        
        this.stock = p_stock;
    
    }
    
    private void setPorcPtoRepo (double p_porcPtoRepo) {
        
        this.porcPtoRepo = p_porcPtoRepo;
    
    }
    
    private void setExistMinima (int p_existMinima ) {
        
        this.existMinima = p_existMinima;
    
    }
    
    private void setLaboratorio (Laboratorio p_laboratorio ) {
        
        this.laboratorio = p_laboratorio;
    
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
    
    public int getCodigo() {
        
        return this.codigo;
        
    }
    
    public String getDescripcion() {
        
        return this.descripcion;
        
    }
    
    
    public double getCosto() {
        
        return this.costo;
        
    }
    
    public String getRubro() {
        
        return this.rubro;
        
    }
    
    public int getStock() {
        
        return this.stock;
        
    }
    
    public double getPorcPtoRepo() {
        
        return this.porcPtoRepo;
        
    }
    
    
    public double getExistMinima() {
        
        return this.existMinima;
        
    }
    
    public Laboratorio getLaboratorio () {
        
        return this.laboratorio;
        
    }
} 