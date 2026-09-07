import java.util.Scanner;
import java.util.Random;
/**
 *  Clase Gestion Hospital, es la clase donde se encuentra el ejecutable para instanciar los objetos hosptial, paciente y ambas localidades de clase Localidad de los objetos de clase Paciente.
 * 
 * @author (Gomez Matias, Fabio Javier Fernandez) 
 * @version (v1.0)
 */
public class GestionHospita
{
        public static void main(String[] args) {
        
        
        Scanner teclado = new Scanner(System.in);
        System.out.println("----- Registro del paciente ----");
        System.out.println("Ingrese el nombre completo");
        String nombre = teclado.nextLine();
        System.out.println("Ingrese el domicilio");
        String domicilio = teclado.nextLine();
        
        System.out.println("Localidad donde Nacio");
        System.out.println("Ingrese el nombre");
        String nombreLocalidad = teclado.nextLine();
        System.out.println("Ingrese la provincia");
        String provincia = teclado.nextLine();
        
        Localidad localidadNacido = new Localidad(nombreLocalidad, provincia);
        
        System.out.println("Localidad donde vive");
        System.out.println("Ingrese el nombre");
        nombreLocalidad = teclado.nextLine();
        System.out.println("Ingrese la provincia");
        provincia = teclado.nextLine();
        
        Localidad localidadVive = new Localidad(nombreLocalidad, provincia);
        System.out.println("Numero de historia clinica generado");
        Random generadorNumeros = new Random();
        int nroHistoriaClinica = generadorNumeros.nextInt(9000) + 1000;
        
        Paciente paciente = new Paciente(nroHistoriaClinica, nombre, domicilio, localidadNacido, localidadVive);
        
        System.out.println("----- Datos del hospital ----");        
        System.out.println("ingrese nombre del hospital");
        String nombreHospital = teclado.nextLine();
        System.out.println("ingrese nombre del director");
        String nombreDirector = teclado.nextLine();
        
        Hospital hospital = new Hospital(nombreHospital, nombreDirector);
        
        hospital.consultaDatosFiliatorios(paciente);
        System.out.println("-----------------------------------"); 
        System.out.println(paciente.cadenaDeDatos());
        
        
    }

}