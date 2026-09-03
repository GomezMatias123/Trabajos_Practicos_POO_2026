
/**
 * La clase GestionStock nos va a permitir instanciar los objetos necesarios para probar poder
 * enviar mensajes y probar los metodos. Aqui se encuentra el metodo ejecutable main, como 
 * señala el trabajo se pasara los datos como constantes.
 * 
 * @author (Fernandez Fabio Javier y Matias Nicolas Gomez) 
 * @version (1.0)
 */
public class GestionStock
{
    public static void main(String []args){
        Producto productos = new Producto(1,"Perfumeria","Jabón Deluxe", 5.25, new Laboratorio(
        "Colgate S.A", "Scalabrini Ortiz 5524", "54-11 -4239-8447"));
        
        productos.ajuste(500);
        
        System.out.println("Nueva promoción de un laboratorio:");
        
        productos.mostrar();
        System.out.println("-----------------------------------------------------------");
        System.out.println("Productos mal estibados se reduzco en stock en 200 unidades");
        
        productos.ajuste(-200);
        
        productos.mostrar();
        
        System.out.println("-----------------------------------------------------------");
        System.out.println(productos.mostrarLinea());
        
        
    }
}