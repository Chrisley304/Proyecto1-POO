package Clases_Inscripcion;

import java.util.ArrayList;

public class Grupo {
    int numGrupo;
    //No puede ser estática, porque habrá grupos de diferentes materias
    String horas;
    ArrayList<String> dias;
    ArrayList<String> alumnos = new ArrayList<>();
    String salon;
    Profesor profe;
    public Asignatura materia;

    public Grupo(int numGrupo, String horas, ArrayList<String> dias, String salon, Profesor profe, Asignatura materia){
        this.numGrupo = numGrupo;
        this.horas = horas;
        this.dias = dias;
        this.salon = salon;
        this.profe = profe;
        this.materia = materia;
    }

    private void MostrarHorario(){
        System.out.println("\tHoras: " + horas);
        System.out.println("\tDias:");
        dias.forEach((d) -> System.out.printf("\t%s",d));
    }

    public void Addalumnos(String numCuenta){
        alumnos.add(numCuenta);
    }

    public void MostrarGrupo(){
        System.out.println("Nombre: " + materia.getNombre());
        System.out.println("\tGrupo " + numGrupo);
        MostrarHorario();
        System.out.println("\t| Salon: " + salon);
        System.out.println("\tProfesor:");
        profe.MostrarProfesor();
        System.out.println("\tAlumnos inscritos " + alumnos.size() + " :" + alumnos.toString());
    }

}