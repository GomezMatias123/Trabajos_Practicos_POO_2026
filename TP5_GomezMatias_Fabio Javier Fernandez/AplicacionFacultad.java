import java.util.ArrayList;

/**
 * Ejecutable de la clase facultad
 * 
 * @author (Matias Gomez, Fabio Javier Fernandez) 
 * @version (v1.0)
 * 
 */
public class AplicacionFacultad
{
    public static void main(String [] args) {
        
        Cargo cargoSimple = new Cargo("JTP-Programación OO", 800000, 2016, 10);
        SemiExclusivo cargoSemi = new SemiExclusivo("Titular-TFA", 1400000, 2014, 20, 0);
        Exclusivo cargoEx = new Exclusivo(10, 30, "JTP-Analisis de Sistemas", 800000, 2006, 10);
        
        ArrayList<Cargo> cargos = new ArrayList<>();
        
        cargos.add(cargoEx);
        cargos.add(cargoSemi);
        cargos.add(cargoSimple);
        
        Profesor profesor1 = new Profesor(4324, "nombre1", "apellido1", 1400,  "Lic. en titulo1", cargos);
        
        Exclusivo cargoEx2 = new Exclusivo(20, 20, "JTP-Analisis de Sistemas1", 800000, 2006, 30);
        
        Profesor profesor2 = new Profesor(5235, "nombre2", "apellido2", 1402,  "Lic. en titulo2", cargoEx2);
        
        Facultad facultad = new Facultad("UNNNE", profesor1);
        
        facultad.añadirProfesor(profesor2);
        
        facultad.nominaProfesores();
        
        facultad.listarProfesorCargos();
        
    }
}