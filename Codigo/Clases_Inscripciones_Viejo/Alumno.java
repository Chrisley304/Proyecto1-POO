package Clases_Inscripciones_Viejo;

public class Alumno {
    String nombre,apellido,semestre,correo;
    int edad,numCuenta,indice=0;
    static int numeroAlumnos;
    Grupo[] listaGrupos = new Grupo[3];
    int numGrupos = 0;

    public Alumno(String nombre, String apellido, int edad, int numCuenta, String semestre, String correo){
        numeroAlumnos++;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.numCuenta = numCuenta;
        this.semestre = semestre;
        this.correo = correo;
    }

    public void AsignarGrupo(Grupo grupo){
        if(numGrupos != 3){
            listaGrupos[numGrupos] = grupo;
        }else{
            System.out.println("Lo sentimos, el alumno ya llego al limite de inscripciones (3)");
        }
    }

    void mostrarAlumno(){
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido: " + apellido);
        System.out.println("Edad: " + edad);
        System.out.println("Número de cuenta: "+ numCuenta);
        System.out.println("Semestre: " + semestre);
        System.out.println("Correo: " + correo);
    }
}