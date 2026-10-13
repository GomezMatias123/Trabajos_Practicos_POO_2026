import java.util.Scanner;

/**
 * La clase Administracion cumple la funcion de ser la clase ejecutable y moldear el concepto de la administracion de jardin, 
 * es donde se van a instanciar los distintos objetos y probar los distintos metodos con las diferentes figuras.
 * 
 * 
 * @author Fernandez Fabio Javier y Matias Nicolas Gomez
 * @version 1.0
 */
public class Administracion
{
    public static void main(String []args){
        Scanner teclado = new Scanner(System.in);
        Jardin jardin = new Jardin("Bichito de luz");
        int opcion = -1;
        
        do{
            mostrarMenu(jardin);
            opcion = teclado.nextInt();
            
            switch(opcion){
                    case 1:
                        ingresarFigura(teclado, jardin);
                        break;
                    case 2:
                        eliminarFigura(teclado, jardin);
                        break;
                    case 3:
                        jardin.detallesFiguras();
                        break;
                    case 0:
                        System.out.println("Cerrando el software");
                        break;
                    default:
                        System.out.println("Valor invalido");
            }
        }while(opcion != 0);
        
    }
    
    public static void mostrarMenu(Jardin p_jardin){
        System.out.println("Sistema administrativo del jardin: " + p_jardin.getNombre());
        System.out.println("1) Agregar figura geometrica para pintar");
        System.out.println("2) Eliminar figura geometrica de la lista");
        System.out.println("3) Imprimir detalle de figuras geometricas de la lista y la cantidad de pintura para comprar");
        System.out.println("0) Cerrar el software");
    }
    
    public static void ingresarFigura(Scanner teclado, Jardin jardin){
        teclado.nextLine();
        System.out.println("Ingrese el tipo de figura que desea ingresar");
        System.out.println("Rectangulo | Cuadrado | Elipse | Circulo | Triangulo");
        String tipo = teclado.nextLine().trim().toLowerCase();
        
        System.out.println("Ingrese la coordenada X del origen de la figura");
        double x = teclado.nextDouble();
        System.out.println("Ingrese la coordenada y del origen de la figura");
        double y = teclado.nextDouble();
        teclado.nextLine();
        Punto origen = new Punto(x, y);
        
        FiguraGeometrica figura = null;
        double base, altura;
        switch (tipo){
            case "rectangulo":
                System.out.println("Base:");
                base = teclado.nextDouble();
                System.out.println("Altura:");
                altura = teclado.nextDouble();
                figura = new Rectangulo(origen, base, altura);
                break;
            case "cuadrado":
                System.out.println("Lados del cuadrado:");
                double lados = teclado.nextDouble();
                figura = new Cuadrado(origen, lados);
                break;
            case "elipse":
                System.out.println("Eje Mayor:");
                double eMayor = teclado.nextDouble();
                System.out.println("Eje Menor:");
                double eMenor = teclado.nextDouble();
                figura = new Elipse(eMayor, eMenor, origen);
                break;
            case "circulo":
                System.out.println("Radio:");
                double radio = teclado.nextDouble();
                figura = new Circulo(radio, origen);
                break;
            case "triangulo":
                System.out.println("Base:");
                base = teclado.nextDouble();
                System.out.println("Altura:");
                altura = teclado.nextDouble();
                figura = new Triangulo(base, altura, origen);
                break;
            default:
                System.out.println("La figura ingresada es invalida");
        }
        
        if(figura != null){
            System.out.println(jardin.agregarFigura(figura) ? "Se agrego con exito la figura" : "Ocurrio un error al intentar ingresar la figura");
        }
        
    }
    
    
    public static void eliminarFigura(Scanner teclado, Jardin jardin){
        teclado.nextLine();
        int i = 0;
        int eleccion = -1;
        for(FiguraGeometrica f : jardin.getFiguras()){
            System.out.println((i+1) + ")");
            f.mostrarSuperficie();
            i++;
        }
        System.out.println("Seleccionar la figura que desee eliminar");
        eleccion = teclado.nextInt();
        System.out.println(jardin.quitarFigura(jardin.getFiguras().get(eleccion - 1)) ? "Se elimino con exito la figura" : "No se logro eliminar la figura");
    }
    
}