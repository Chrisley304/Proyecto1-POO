package CodigoP4_Chris;

public class Alumno {
    static int numAlu; 
    
    String nombre;
    String semestre;
    int edad;
    String numCuenta;
    String telefono;
    Domicilio dom;

    public Alumno (String nombre, String semestre , int edad, String numCuenta, String telefono){
        this.nombre = nombre;
        this.semestre = semestre;
        this.edad = edad;
        this.numCuenta = numCuenta;
        this.telefono = telefono;

        numAlu += 1; // Contador de numero de alumnos
    }

    public Alumno(){
        numAlu += 1;
    }

    
    public void AsosiarDomicicilio(String calle, String delegacion, String colonia, String CP, String ciudad) {
        this.dom = new Domicilio(calle, delegacion, colonia, CP, ciudad);
    }

    public void AsosiarDomicicilio(Domicilio dom) {
        this.dom = dom;
    }

    

    public void MostrarAlumno(){
        System.out.printf("Nombre del alumno: %s\n",this.nombre);
        System.out.printf("Semestre: %s\n",this.semestre);
        System.out.printf("Edad: %d\n",this.edad);
        System.out.printf("Numero de cuenta: %s\n",this.numCuenta);
        System.out.printf("Telefono: %s\n",this.telefono);
        dom.MostrarDomicilio();
    }

}
