import java.util.Scanner;
import java.util.ArrayList;
/**
 * Write a description of class RegistroCivil here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class RegistroCivil {
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        
        int centinela = -1;
        
        ArrayList<Mujer> mujeres = new ArrayList<>();
        ArrayList<Hombre> hombres = new ArrayList<>();
        
        
        while (centinela != 0) {
            
            menu();
            
            centinela = teclado.nextInt();
            
            switch(centinela) {
                
                case 1: registrarHombre(hombres, teclado);
                    break;
                case 2: registrarMujer(mujeres,teclado);
                    break;
                case 3: registrarCasados(hombres, mujeres, teclado);
                    break;
                
                
                case 4: realizarCasamiento(hombres, mujeres, teclado);
                    break;
                case 5:
                        realizarUnDivorcio(hombres, teclado);
                    break;
                case 0: System.out.println("Hasta luego!");
                    break;
                default: System.out.println("Algo inesperado sucedio...");
                    break;
                    
            }
        }
        
        
    }
    
    /*
     * 
     * 
     * enseña un menu con las opciones
     */
        
    public static void menu() {
        
        System.out.println("--- Selecione una opcion ---");
        
        
        
        System.out.println("1) Registrar un hombre en el registro civil"); 
        System.out.println("2) Registrar una mujer en el registro civil"); 
        System.out.println("3) Registrar una pareja casada en el registro civil"); 
        System.out.println("4) Realizar un casamiento");   
        System.out.println("5) Realizar un divorcio");
        System.out.println("0) Finalizar");
        
        
    }
    
    /*
     * 
     * 
     * instancia objetos para el constructor que posee el parametro p_esposo/a
     */    
    public static void registrarCasados(ArrayList<Hombre>  p_hombres, ArrayList<Mujer> p_mujeres,
                                        Scanner teclado) {
        
        teclado.nextLine();
        
        System.out.println("nombre: ");
        String nombre = teclado.nextLine();
        
        
        System.out.println("Apellido: ");
        String apellido = teclado.nextLine();
        
        System.out.println("Edad ");
        int edad = teclado.nextInt();
        
        System.out.println("Es usted hombre o mujer? \n1)Hombre \n2)Mujer");
        
        int centinela = teclado.nextInt();
        
        int indiceConyugue;
        Mujer unaMujer;
            
            
        if(centinela == 2) {
            
            do {
                
                System.out.println("-----------------------------------------------------------");
                
                System.out.println("Ingrese el indice de su conyugue: ");
                
                System.out.println("-----------------------------------------------------------");
                
                listaHombres(p_hombres);
                indiceConyugue = teclado.nextInt();
                if(indiceConyugue == 0) {
                   registrarHombre(p_hombres, teclado); 
                }
                
            } while(indiceConyugue == 0);
                
            Hombre unHombre = p_hombres.get(indiceConyugue - 1);
            
            unaMujer = new Mujer(nombre, apellido, edad, unHombre);
            
            unHombre.casarseCon(unaMujer);
            
            p_mujeres.add(unaMujer);
            
        } else {
                
            do {
                
                System.out.println("-----------------------------------------------------------");
                
                System.out.println("Ingrese el indice de su conyugue: ");
                
                System.out.println("-----------------------------------------------------------");
                
                listaMujeres(p_mujeres);
                indiceConyugue = teclado.nextInt();
                if(indiceConyugue == 0) {
                    registrarMujer(p_mujeres, teclado);
                }
                
            } while(indiceConyugue == 0);
            
            unaMujer=p_mujeres.get(indiceConyugue - 1);
            
            Hombre unHombre = new Hombre(nombre, apellido, edad, unaMujer);
            
            unaMujer.casarseCon(unHombre);
            
            p_hombres.add(unHombre);
                
        }
        
        System.out.println("-----------------------------------------------------------");
                
        
       System.out.println("Imprimiento certificado...");
       
       
       System.out.println("-----------------------------------------------------------");
       
       System.out.println("-----------------------------------------------------------");
        
                
       unaMujer.casadaCon();
       
       
       System.out.println("-----------------------------------------------------------");
        
    }
    
    /*
     * 
     * 
     * instancia objetos de la clase hombre sin el parametro p_esposa
     * 
     * 
     */
    
    public static void registrarHombre(ArrayList<Hombre> p_hombres, Scanner teclado) {
        
        teclado.nextLine();
        
        
                
        System.out.println("nombre: ");
        String nombre = teclado.nextLine();
        
        
        System.out.println("Apellido: ");
        String apellido = teclado.nextLine();
        
        System.out.println("Edad ");
        int edad = teclado.nextInt();
        
        p_hombres.add(new Hombre(nombre, apellido, edad));
        
    }
    
    /*
     * 
     * 
     * instancia objetos de la clase mujer sin el pararmetro p_esposo
     * 
     * 
     * 
     */
    
    public static void registrarMujer(ArrayList<Mujer> p_mujeres, Scanner teclado) {
        
        teclado.nextLine();
        
        System.out.println("nombre: ");
        String nombre = teclado.nextLine();
        
        
        System.out.println("Apellido: ");
        String apellido = teclado.nextLine();
        
        System.out.println("Edad ");
        int edad = teclado.nextInt();
        
        p_mujeres.add(new Mujer(nombre, apellido, edad));
        
    }
    
    /*
     * 
     * 
     * simula un casamiento entre dos instancias de los objetos
     * 
     * 
     */
    
    public static void realizarCasamiento(ArrayList<Hombre> p_hombres, ArrayList<Mujer> p_mujeres,
                                        Scanner teclado) {
                                            
       int indiceConyugue;
                                            
        do {
            System.out.println("Seleccione al hombre que se casara: ");
            listaHombres(p_hombres);
            indiceConyugue = teclado.nextInt();
            if(indiceConyugue == 0) {
                registrarHombre(p_hombres, teclado); 
            }
                
        } while(indiceConyugue == 0);
        
        Hombre unHombre = p_hombres.get(indiceConyugue - 1);
        
       do {
                
            System.out.println("Seleccione a la mujer que se casara: ");
            listaMujeres(p_mujeres);
            indiceConyugue = teclado.nextInt();
            if(indiceConyugue == 0) {
                registrarMujer(p_mujeres, teclado);
            }
                
        } while(indiceConyugue == 0);
        
        
       Mujer unaMujer = p_mujeres.get(indiceConyugue - 1);
        
       unHombre.casarseCon(unaMujer);
       unaMujer.casarseCon(unHombre);
       
       System.out.println("-----------------------------------------------------------");
                
        
       System.out.println("Imprimiento certificado...");
       
       
       System.out.println("-----------------------------------------------------------");
       
       System.out.println("-----------------------------------------------------------");
        
                
       unaMujer.casadaCon();
       
       
       System.out.println("-----------------------------------------------------------");
                
                                                
    }
    
    /*
     * 
     * 
     * envia el mensaje divorcio entre dos objetos
     * 
     * 
     * 
     */
    
    public static void realizarUnDivorcio(ArrayList<Hombre> p_hombres, Scanner teclado) {
        
        System.out.println("Seleccion de quien se quiere divorciar o quien se quiere divorciar: ");
        
        listaHombres(p_hombres);
        int indice = teclado.nextInt();
        
        Hombre nuevoDivorciado = p_hombres.get(indice - 1);
        
        if(nuevoDivorciado.getEstadoCivil() != "Casado") {
            
            
            
            System.out.println("Este hombre no esta casado");
            
        } else {
            
            nuevoDivorciado.getEsposa().divorcio();
            nuevoDivorciado.divorcio();
            
            System.out.println("Divorcio finalizado");
            
        }
        
        
    }
    
    /*
     * 
     * lista de las intancias creadas de Hombre
     * 
     * 
     */
    
    public static void listaHombres(ArrayList<Hombre> p_hombres) {
        
        for(int i=0; i<p_hombres.size(); i++) {
            
            Hombre hombreActual = p_hombres.get(i);
            System.out.println("-----------------------------------------------------------");
                
            System.out.print((i + 1) + ")");
                
            hombreActual.mostrarEstadoCivil();

        }
        
        System.out.println("-----------------------------------------------------------");
                
                
        System.out.println("0)No esta registrado");
        
        
        System.out.println("-----------------------------------------------------------");
      
        
        
    }
    
    /*
     * 
     * Lista de las instancias de los objetos Mujer
     * 
     * 
     * 
     */
    
    public static void listaMujeres(ArrayList<Mujer> p_mujer) {
        
        for(int i=0; i<p_mujer.size(); i++) {
            
            Mujer mujerActual = p_mujer.get(i);
            
            System.out.println("-----------------------------------------------------------");
                
            System.out.print((i + 1) + ")");
            
            
             mujerActual.mostrarEstadoCivil();
            
        }
        System.out.println("-----------------------------------------------------------");
                
        System.out.println("0)No esta registrada");
        
        System.out.println("-----------------------------------------------------------");
                
    }
        
        
}