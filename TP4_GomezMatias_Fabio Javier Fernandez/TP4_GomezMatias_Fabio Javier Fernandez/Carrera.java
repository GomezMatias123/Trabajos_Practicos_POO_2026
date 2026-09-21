
/**
 * Modelado de la interfaz publica de clase curso
 * 
 * @author (Gomez Matias Nicolas, Fernandez Fabio Javier) 
 * @version (v1.0)
 */
public class Carrera{
    
     public static void main(String  [] args) {
        
        Curso curso1 = new Curso("4toA");
    
        Alumno alumno = new Alumno(32555, "Pedro", "Gomez");
        
        alumno.setNota1(7); 
        alumno.setNota2(9);
    
        curso1.inscribirAlumno(alumno);
        
        alumno = new Alumno(23564, "Maria", "Vasquez");
        
        alumno.setNota1(8); 
        alumno.setNota2(10);
        
        curso1.inscribirAlumno(alumno);
        
        alumno = new Alumno(30123, "Juan", "Rombo");
        
        alumno.setNota1(1); 
        alumno.setNota2(9);
        
        curso1.inscribirAlumno(alumno);
        
        alumno = new Alumno(32655, "Marcela", "Rinea");
        
        alumno.setNota1(6); 
        alumno.setNota2(6.92);
        
        curso1.inscribirAlumno(alumno);
        
        curso1.mostrarInscriptos();
        
        System.out.println("Se ha quitado al alumno:" + curso1.quitarAlumno(32555).nomYApe());

        
        
        System.out.println(curso1.estaInscripto(32555) == false ? 
        "\nEl alumno que busca no se encuentra inscripto\n" : "\nEl alumno que busca esta inscripto\n");
        
        curso1.mostrarInscriptos();
        
        curso1.buscarAlumno(23564);
        
        curso1.imprimirPromedioDeAlumno(30123);
        
    
    }
    
    
    
}