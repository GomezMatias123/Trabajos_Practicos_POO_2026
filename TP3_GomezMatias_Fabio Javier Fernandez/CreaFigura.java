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
        /**
         * Instancia del objeto de la clase Scanner, los array list para tener una lista dinamica una especificamente para los objetos de clase Circulo y otro para los objetos
         * de clase Rectangulo.
         */
            Scanner teclado = new Scanner(System.in);
            ArrayList<Circulo> circulos = new ArrayList<>(); 
            ArrayList<Rectangulo> rectangulos = new ArrayList<>(); 
            int option = -1;
           
        /**
         * Se instancia un objeto de la clase PanelDibujo donde se pasa todo lo necesario para dibujar la interfaz grafica de los ejez cartesianos y las figuras geometricas
         * 
         * param: recibe como parametro los arrays de circulos y rectangulos.
         * 
         * El objeto frame de la clase JFrame es de la libreria java.swing que nos permite crear la ventana donde dibujar las figuras geometricas
         * recibe como parametro el titulo de la ventana.
         * 
         */
            
            PanelDibujo panel = new PanelDibujo(circulos, rectangulos);
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
                    case 6:
                        System.out.print("Ingrese el alto: ");
                        double alto = teclado.nextDouble();
                        
                        System.out.print("Ingrese el ancho: ");
                        double ancho = teclado.nextDouble();
                        
                        rectangulos.add(new Rectangulo(ancho, alto));
                        panel.repaint();
                        break;
                    case 7:
                        System.out.print("Ingrese el alto: ");
                        alto = teclado.nextDouble();
                        
                        System.out.print("Ingrese el ancho: ");
                        ancho = teclado.nextDouble();
                        
                        System.out.print("Ingrese coordenada X del origen: ");
                        x = teclado.nextDouble();
                        System.out.print("Ingrese coordenada Y del origen: ");
                        y = teclado.nextDouble();
                        
                        rectangulos.add(new Rectangulo(new Punto(x, y), ancho, alto));
                        panel.repaint();
                        break;
                    case 8: 
                        desplazarRectangulo(rectangulos, teclado, panel);
                        break;
                    case 9:
                        compararRectangulo(rectangulos, teclado);
                        break;
                    case 10:
                        distanciaARectangulo(rectangulos, teclado);
                        break;   
                    case 0:
                        System.out.println("Finalizando el software");
                        break;
                        default:
                            System.out.println("Opción inválida.");
                        }
            }while(option != 0);
    }
       
        /**
         * Imprime un menu para brindar las indicaciones al usuario para que pueda moverse a travez de las opciones del programa-
         * 
         * param: ----
         * return: ----
         * 
         */
    
     private static void mostrarMenu(){
        System.out.println("--- Creador de figuras geometricas ---");
        System.out.println("1) Crear circulo predeterminado (en el punto (0,0) con radio 0)");
        System.out.println("2) Crear circulo en un punto seleccionado y un radio aleatorio");
        System.out.println("3) Elegir un circulo para desplazarlo por los ejes cartesianos");
        System.out.println("4) Comparar tamaño de circulos");
        System.out.println("5) Medir distancias entre circulos");
        System.out.println("6) Crear un rectangulo (en el punto (0,0)");
        System.out.println("7) Crear un rectangulo en un punto seleccionado");
        System.out.println("8) Elegir un rectangulo para desplazarlo por los ejes cartesianos");
        System.out.println("9) Comparar tamaño de rectangulos");
        System.out.println("10) Medir distancias entre rectangulos");
        System.out.println("0) Cerrar");
        System.out.print("Ingrese opción: ");
    }
    
        /**
         * Permite desplazar el circulo trasladando su punto o centro entre las coordenadas de los ejes cartesianso.
         * 
         * param: Recibe como parametros el conjunto de todos los circulos creados, el objeto teclado del tipo scanner que nos permite movernos por el menu de opciones
         * y el objeto panel que nos ayuda a redibujar la figura despues que se traslada a otro punto del plano.
         * return: void.
         * 
         * 
         */
    private static void desplazarCirculo(ArrayList<Circulo> circulos, Scanner teclado, PanelDibujo panel) {
         if(!listaCirculos(circulos)){
            return;
        } else {
            teclado.nextLine();
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
    }      
    
    /**
         * Permite desplazar el rectangulo trasladando su punto o esquina inferior izquierda entre las coordenadas de los ejes cartesianso.
         * 
         * param: Recibe como parametros el conjunto de todos los rectangulos creados, el objeto teclado del tipo scanner para movernos por el menu 
         * y el objeto panel que nos ayuda a redibujar la figura despues que se traslada a otro punto del plano.
         * return: void.
         * 
         * 
         */
     private static void desplazarRectangulo(ArrayList<Rectangulo> rectangulos, Scanner teclado, PanelDibujo panel) 
     {
        if(!listaRectangulos(rectangulos)){
            return;
            } else {

            teclado.nextLine();
            int decision = -1;
            System.out.println("Ingrese el rectangulo que desea trasladar");
            int indiceRectangulo= teclado.nextInt();
            Rectangulo rectanguloADesplazar = rectangulos.get(indiceRectangulo- 1);
            
            do{
            System.out.println("1) Deslplazar el circulo por los ejes X e Y");
            System.out.println("0) Volver al menu principal"); 
            System.out.println("Coordenadas actuales: " + 
            rectanguloADesplazar.getOrigen().coordenadas());
            teclado.nextLine();
            decision = teclado.nextInt();
            
            switch(decision){
                case 1:
                    teclado.nextLine();
                    System.out.println("Ingrese la cantidad de variacion para el eje X");
                    double x = teclado.nextDouble();
                    System.out.println("Ingrese la cantidad de variacion para el eje Y");
                    double y = teclado.nextDouble();
                    rectanguloADesplazar.getOrigen().desplazar(x, y);
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
    }
    
    
        /**
         * Compara el tamaño de dos circulos creados en base a su superficie, el de mayor superficie se imprime un mensaje con sus radio y sus demas datos.
         * 
         * param: Recibe como parametros el conjunto de todos los circulos creados y el objeto teclado del tipo scanner para movernos por el menu.
         * return: void.
         * 
         * 
         */
    
        private static void compararTamaño(ArrayList<Circulo> circulos, Scanner teclado){
             if(!listaCirculos(circulos)){
                return;
            } else {
            
            teclado.nextLine();
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
    }
    
    
        /**
         * Compara el tamaño de dos rectangulos creados en base a su superficie, el de mayor superficie se imprime un mensaje con datos.
         * 
         * param: Recibe como parametros el conjunto de todos los rectangulos creados y el objeto teclado del tipo scanner para movernos por el menu.
         * return: void.
         * 
         * 
         */
    private static void compararRectangulo(ArrayList<Rectangulo> rectangulos, Scanner teclado){
        if(!listaRectangulos(rectangulos)){
            return;
            } else {

            teclado.nextLine();
            System.out.println("Ingrese rectangulos a comparar:");
            System.out.println("rectangulo A: ");
            int valorRectanguloA= teclado.nextInt();
            Rectangulo RectanguloA = rectangulos.get(valorRectanguloA- 1);
            teclado.nextLine();
            System.out.println("rectangulo b: ");
            int valorRectanguloB = teclado.nextInt();
            Rectangulo RectanguloB = rectangulos.get(valorRectanguloB - 1);
            
            System.out.println("Circulo mayor: ");
            RectanguloA.elMayor(RectanguloB).caracteristicas(); 
        }
    }   
    
        /**
         * Mide la distancia entre dos rectangulos.
         * 
         * param: Recibe como parametros el conjunto de todos los rectangulos creados y el objeto teclado del tipo scanner para movernos por el menu.
         * return: void.
         * 
         * 
         */
    
    private static void distanciaARectangulo(ArrayList<Rectangulo> rectangulos, Scanner teclado){
        if(!listaRectangulos(rectangulos)){
            return;
            } else {
            teclado.nextLine();
            System.out.println("Ingrese los circulos para medir la distancia entre ambos.");
            System.out.println("rectangulo A: ");
            int valorRectanguloA = teclado.nextInt();
            Rectangulo RectanguloA = rectangulos.get(valorRectanguloA - 1);
            teclado.nextLine();
            System.out.println("rectangulo B: ");
            int valorRectanguloB = teclado.nextInt();
            Rectangulo RectanguloB = rectangulos.get(valorRectanguloB - 1);
                    
            System.out.println("La distancia es de " + 
            RectanguloA.getOrigen().distanciaA(RectanguloB.getOrigen()) + " " + "unidades" );
        }
    }
    
    
        /**
         * Mide la distancia entre dos circulos.
         * 
         * param: Recibe como parametros el conjunto de todos circulos creados y el objeto teclado del tipo scanner para movernos por el menu.
         * return: void.
         * 
         * 
         */
    
        private static void medirDistancia(ArrayList<Circulo> circulos, Scanner teclado){
            if(!listaCirculos(circulos)){
                return;
            } else {
            
            
            teclado.nextLine();
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
    }
    
    
        /**
         * En lista todos los rectangulos creados mediante la iteracion hecha con un for, caso contrario imprime que no se crearon figuras en esta lista.
         * 
         * param: Recibe como parametros el conjunto de todos rectangulos creados.
         * return: void.
         * 
         * 
         */
    private static boolean listaRectangulos(ArrayList<Rectangulo> rectangulos){
            if(rectangulos.isEmpty()){
            System.out.println("--- No se crearon rectangulos ---");
            return false;
        } else {
            System.out.println("-----------------------------------");
            System.out.println("--- Circulos creados y sus ubicaciones ---");
            for(int i = 0;i < rectangulos.size();i++){
                Rectangulo rectangulo = rectangulos.get(i);
                System.out.println((i+1) + ") ");
                rectangulo.caracteristicas();
            }
            System.out.println("-----------------------------------");
            return true;
        }
    }
        
        /**
         * En lista todos los circulos creados mediante la iteracion hecha con un for, caso contrario imprime que no se crearon figuras en esta lista.
         * 
         * param: Recibe como parametros el conjunto de todos circulos creados.
         * return: void.
         * 
         * 
         */
    private static boolean listaCirculos(ArrayList<Circulo> circulos){
            if(circulos.isEmpty()){
            System.out.println("--- No se crearon circulos ---");
            return false;
        } else {
            System.out.println("-----------------------------------");
            System.out.println("--- Circulos creados y sus ubicaciones ---");
            for(int i = 0;i < circulos.size();i++){
                Circulo circulo = circulos.get(i);
                System.out.println((i+1) + ") ");
                circulo.caracteristicas();
            }
            System.out.println("-----------------------------------");
            return true;
        }
    }
    
 }