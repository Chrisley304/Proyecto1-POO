public class Asignatura {
    
    String nombre;
    int clave;
    int creditos;
    boolean laboratorio;
    Profesor profe;

    public Asignatura(){
        
    }

    public Asignatura(String nombre, int clave, int creditos){
        setnombre(nombre);
        setclave(clave);
        setcreditos(creditos);
    }

    public void setnombre(String nombre) {
        this.nombre = nombre;
    }

    public void setclave(int clave) {
        this.clave = clave;
    }

    public void setcreditos(int creditos) {
        this.creditos = creditos;
    }

    public void AsociarProfesor(String nombre, float calificacion, boolean barco){
        this.profe = new Profesor(nombre, calificacion , barco);
    }
    
    public void MostrarAsignatura() {
        System.out.printf("Nombre de la asignatura: %s\n", this.nombre);
        System.out.printf("Clave: %d\n", this.clave);
        System.out.printf("Creditos: %d\n", this.creditos);
        profe.MostrarProfesor();
    }

}
