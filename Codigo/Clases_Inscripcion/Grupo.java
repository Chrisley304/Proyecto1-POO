package Clases_Inscripcion;

import java.util.ArrayList;

public class Grupo {
    int numGrupo;
    //No puede ser estatica, porque habra grupos de diferentes materias
    String horas;
    ArrayList<String> dias;
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

    public int getNumGrupo() {
        return this.numGrupo;
    }


    public Asignatura getAsignatura (){
        return this.materia;
    }

    private void MostrarHorario(){
        System.out.println("\tHoras: " + horas);
        System.out.println("\tDias:");
        dias.forEach((d) -> System.out.printf("\t%s",d));
    }

    public void MostrarGrupo(){
//        System.out.printf("Materia %s:\n",materia.nombre);
        // No se imprime la informacion de la materia porque eso se hace solo una vez por materia en el main -C
        System.out.println("Nombre: " + materia.getNombre());
        System.out.println("\tGrupo " + numGrupo);
        MostrarHorario();
        System.out.println("\tSalon: " + salon);
        System.out.println("\tProfesor:");
        profe.MostrarProfesor();
    }

}