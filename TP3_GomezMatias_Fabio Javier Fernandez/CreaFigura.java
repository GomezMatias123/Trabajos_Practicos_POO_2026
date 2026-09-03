import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import javax.swing.*;
import java.awt.*;


/**
 * La clase CrearFigura tiene como funcion poder crear y manipular las diferentes figuras 
 * geometricas que se van instanciando como objetos de sus respectiva clases y poder enviar 
 * los mensajes para llamar a sus respectivos metodos.
 * 
 * @author Fernandez Fabio Javier y Matias Nicolas Gomez
 * @version 1.0
 */
public class CreaFigura
{
    public static void main(String []args){
        Scanner teclado = new Scanner(System.in);
        ArrayList<Circulo> circulos = new ArrayList<>(); 
        int option = -1;
        
        PanelDibujo panel = new PanelDibujo(circulos);
        JFrame frame = new JFrame("Figuras Geométricas");
        frame.add(panel);
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
            
    do{
        
        mostrarMenu();
        option = teclado.nextInt();
        switch(option){
                case 1:
                    circulos.add(new Circulo());
                    panel.repaint();
                    System.out.println("Círculo creado en (0,0)");
                    break;
                case 2:
                   System.out.print("Ingrese coordenada X: ");
                    double x = teclado.nextDouble();
                    System.out.print("Ingrese coordenada Y: ");
                    double y = teclado.nextDouble();
                    Random unNumero = new Random();
                    double radio = unNumero.nextDouble() * 100.0;
                    double radioFiltrado = Math.round(radio * 100.0)/ 100.0;
                    circulos.add(new Circulo(radioFiltrado, new Punto(x, y)));
                    panel.repaint();
                    System.out.println("Círculo creado en " + 
                    circulos.get(circulos.size() -1).getCentro().coordenadas());
                    break;
                case 3: 
                    desplazarCirculo(circulos, teclado, panel);
                    break;
                case 4:
                    compararTamaño(circulos, teclado);
                    break;
                case 5:
                    medirDistancia(circulos, teclado);
                    break;
                case 0:
                    System.out.println("Finalizando el software");
                    break;
                    default:
                        System.out.println("Opción inválida.");
                    }
        }while(option != 0);
    }
    
    
     private static void mostrarMenu(){
        System.out.println("--- Creador de figuras geometricas ---");
        System.out.println("1) Crear circulo predeterminado (en el punto (0,0) con radio 0)");
        System.out.println("2) Crear circulo en un punto seleccionado y un radio aleatorio");
        System.out.println("3) Elegir un circulo para desplazarlo por los ejes cartesianos");
        System.out.println("4) Comparar tamaño de circulos");
        System.out.println("5) Medir distancias entre circulos");
        System.out.println("0) Cerrar");
        System.out.print("Ingrese opción: ");
    }
    
    private static void desplazarCirculo(ArrayList<Circulo> circulos, Scanner teclado, 
    PanelDibujo panel) {
        teclado.nextLine();
        listaCirculos(circulos);
        int decision = -1;
        System.out.println("Ingrese el circulo que desea trasladar");
        int indiceCirculo = teclado.nextInt();
        Circulo circuloADesplazar = circulos.get(indiceCirculo - 1);
        
        do{
        System.out.println("1) Deslplazar el circulo por los ejes X e Y");
        System.out.println("0) Volver al menu principal"); 
        System.out.println("Coordenadas actuales: " + 
        circuloADesplazar.getCentro().coordenadas());
        teclado.nextLine();
        decision = teclado.nextInt();
        
        switch(decision){
            case 1:
                teclado.nextLine();
                System.out.println("Ingrese la cantidad de variacion para el eje X");
                double x = teclado.nextDouble();
                System.out.println("Ingrese la cantidad de variacion para el eje Y");
                double y = teclado.nextDouble();
                circuloADesplazar.desplazar(x, y);
                panel.repaint();
                break;
            case 0:
                System.out.println("Volviendo al menu...");
                    break;
                    default:
                        System.out.println("Opción inválida.");
        }
        }while(decision!= 0);
        
    }
    
    private static void compararTamaño(ArrayList<Circulo> circulos, Scanner teclado){
        teclado.nextLine();
        listaCirculos(circulos);
        System.out.println("Ingrese circulos a comparar:");
        System.out.println("Circulo A: ");
        int valorCirculoA = teclado.nextInt();
        Circulo circuloA = circulos.get(valorCirculoA - 1);
        teclado.nextLine();
        System.out.println("Circulo b: ");
        int valorCirculoB = teclado.nextInt();
        Circulo circuloB = circulos.get(valorCirculoB - 1);
        
        System.out.println("Circulo mayor: ");
        circuloA.elMayor(circuloB).caracteristicas(); 
    }
    
    
    private static void medirDistancia(ArrayList<Circulo> circulos, Scanner teclado){
    teclado.nextLine();
    listaCirculos(circulos);
    System.out.println("Ingrese los circulos para medir la distancia entre ambos.");
        System.out.println("Circulo A: ");
        int valorCirculoA = teclado.nextInt();
        Circulo circuloA = circulos.get(valorCirculoA - 1);
        teclado.nextLine();
        System.out.println("Circulo B: ");
        int valorCirculoB = teclado.nextInt();
        Circulo circuloB = circulos.get(valorCirculoB - 1);
        
        System.out.println("La distancia es de " + 
        circuloA.getCentro().distanciaA(circuloB.getCentro()) + " " + "unidades" );
    
    
    
    }
    
    private static void listaCirculos(ArrayList<Circulo> circulos){
        if(circulos.isEmpty()){
        System.out.println("--- No se crearon circulos ---");
        return;
    } else {
        System.out.println("-----------------------------------");
        System.out.println("--- Circulos creados y sus ubicaciones ---");
        for(int i = 0;i < circulos.size();i++){
            Circulo circulo = circulos.get(i);
            System.out.println((i+1) + ") ");
            circulo.caracteristicas();
        }
        System.out.println("-----------------------------------");
    }
    }
    
    
}