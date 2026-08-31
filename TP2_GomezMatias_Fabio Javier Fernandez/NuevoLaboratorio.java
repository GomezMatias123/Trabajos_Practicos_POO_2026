
/**
 * Write a description of class NuevoLaboratorio here.
 * 
 * @author (Gomez Matias, Fabio Javier Fernandez) 
 * @version (v1.0)
 * 
 * Clase con el metodo ejecutable para la clase Laboratorio.
 */
public class NuevoLaboratorio
{
    public static void main(String []args){
        Laboratorio nuevoLaboratorio = new Laboratorio("Colgate S.A.", "Junin 5204", 
        "54-11 -4239-8447");
        
        nuevoLaboratorio.mostrar();
        
        nuevoLaboratorio.nuevaCompraMinima(15000);
        nuevoLaboratorio.nuevoDiaEntrega(10);
        nuevoLaboratorio.mostrar();
    }
}