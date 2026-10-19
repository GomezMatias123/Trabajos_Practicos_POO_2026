
/**
 * Clase ejecutable de la clases cocinas, heladera y lavarropas
 * 
 * @author (Matias Gomez, Fabio Javier Fernandez) 
 * @version (v1.0)
 * 
 */
public class Comercio
{
    
    public static void main(String [] args) {
        
        Cocina cocina = new Cocina("Ferrari", 200000, 15, 4, 1000, "100*20*1000");
        Heladera heladera1 = new Heladera("Volkswagen", 200000, 10, 10, 2, false);
        Heladera heladera2 = new Heladera("Volkswagen", 200000, 10, 10, 2, true);
        
        Lavarropas lavarropa1 = new Lavarropas("Peugeot", 200000, 19, 2, 10, false);
        Lavarropas lavarropa2 = new Lavarropas("Peugeot", 200000, 19, 2, 10, true);
        
        cocina.imprimir();
        System.out.println("Valor Cuota: " + cocina.cuotaCredito(10, 2));
        System.out.println("Valor Cuota Con Adicionales: " + cocina.creditoConAdicional(10, 2));
        
        heladera1.imprimir();
        System.out.println("Valor Cuota: " + heladera1.cuotaCredito(10, 2));
        System.out.println("Valor Cuota Con Adicionales: " + heladera1.creditoConAdicional(10, 2));
        
        heladera2.imprimir();
        System.out.println("Valor Cuota: " + heladera2.cuotaCredito(10, 2));
        System.out.println("Valor Cuota Con Adicionales: " + heladera2.creditoConAdicional(10, 2));
        
        lavarropa1.imprimir();
        System.out.println("Valor Cuota: " + lavarropa1.cuotaCredito(10, 2));
        System.out.println("Valor Cuota Con Adicionales: " + lavarropa1.creditoConAdicional(10, 2));
        
        lavarropa2.imprimir();
        System.out.println("Valor Cuota: " + lavarropa2.cuotaCredito(10, 2));
        System.out.println("Valor Cuota Con Adicionales: " + lavarropa2.creditoConAdicional(10, 2));
        
        
    
    
    }
}