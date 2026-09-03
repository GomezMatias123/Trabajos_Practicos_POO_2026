
/**
 * Write a description of class Punto here.
 * 
 * @author (Gomez Matias, Fabio Javier Fernandez) 
 * @version (v1.0
 */
public class Punto
{
    private double X;
    private double Y;
    
    
/**
* Constructores sobrecargados de la clase Punto
*/ 
public Punto(){
    X = 0;
    Y = 0;
}

public Punto(double p_x, double p_y){
    setX(p_x);
    setY(p_y);
}
/**
* Getters y setters de la clase Punto
*/ 
private void setX(double p_x){
    X = p_x;
}
private void setY(double p_y){
    Y = p_y;
}

public double getX(){
    return X;
}
public double getY(){
    return Y;
}

/**
* desplazar(p_x, p_y) recibe dos valores del tipo de valor double, los almacena en varibales 
* duble (dx y dy) mas el valor actual de las coordenadas X e Y del punto, obtendindolas 
* mediante los GETTERS, luego esos valores remplazan a los valores de los atributos X e Y del
* punto simulando su desplazamiento.
*/ 


public void desplazar(double p_dx, double p_dy){
    double dx = getX() + p_dx;
    setX(dx);
    double dy = getY() + p_dy;
    setY(dy);
}

public void mostrar(){
    System.out.println("Punto. X: "+ getX() + "," + " " + "Y: " +getY()); 
}

/**
* coordenadas() devuelve los valores X e Y en formato string, que son una abstraccion de las 
* coordenadas del objeto punto en el plano.
*/ 
public String coordenadas(){
    return "(" + getX() + "," + " " + getY() +")";
}
}