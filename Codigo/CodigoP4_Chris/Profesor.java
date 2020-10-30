package CodigoP4_Chris;

public class Profesor {
    static int numProf;

    String nombre;
    float calificacion;
    boolean barco; // Si es barco sera true, si no sera false
    Asignatura materia;
    
    public Profesor (String nombre, float calificacion , boolean barco){
        this.nombre = nombre;
        this.calificacion = calificacion;
        this.barco = barco;

        numProf += 1; // Contador de numero de profesores
    }

    public Profesor(){
        numProf += 1;
    }
    
    public void EsBarco(){
        if (this.barco) {
            System.out.println("El profesor ES barco");
        } else {
            System.out.println("El profesor NO es barco");
        }
    }

    public void MostrarProfesor(){
        System.out.printf("Nombre del Profesor: %s\n",nombre);
        System.out.printf("Calificacion del profesor: %f\n",calificacion);
        EsBarco();
    }
}
