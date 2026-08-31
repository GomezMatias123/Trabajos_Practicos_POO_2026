
/**
 * Write a description of class NuevaPersona here.
 * 
 * @author (Gomez Matias, Fabio Javier Fernandez) 
 * @version (v1.0)
 * Clase con el metodo ejecutable para probar la clase Persona, instanciar objetos de la misma
 * y probar sus metodos implementados.
 */
public class NuevaPersona
{
    public static void main(String []args){
        Persona nuevaPersona = new Persona(35123456, "Juan", "Perez", 2004);
        
        
        nuevaPersona.mostrar();
    }
}