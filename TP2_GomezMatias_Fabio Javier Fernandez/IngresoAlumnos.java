
/**
 * Write a description of class IngresoAlumnos here.
 * 
 * @author (Gomez Matias, Fabio Javier Fernandez) 
 * @version (v1.0)
 */
public class IngresoAlumnos
{
    public static void main(String []args){
        int LU = Integer.parseInt(args[0]);
        String apellido = args[1];
        String nombre = args[2];
        double nota1 = Double.parseDouble(args[3]);
        double nota2 = Double.parseDouble(args[4]);
        Alumno nuevoAlumno = new Alumno(LU, apellido, nombre);
        
/**
 * Write a description of class IngresoAlumnos here.
 * Se imprime los datos del alumno con las notas inicializadas en 0.
 */
        nuevoAlumno.mostrar();
        
        nuevoAlumno.setNota1(nota1);
        nuevoAlumno.setNota2(nota2);
        /**
 * Write a description of class IngresoAlumnos here.
 * Se imprime los datos del alumno con las notas con los valores que ingresaron por paramentos 
 * en el metodo main.
 */
        nuevoAlumno.mostrar();
    }
}