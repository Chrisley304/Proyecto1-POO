package Clases_Inscripciones;

import java.util.ArrayList;

public class Grupo {
    int numGrupo;   //No puede ser estatica, porque habra grupos de diferentes materias
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

    private void MostrarHorario(){
        System.out.println("Horas: " + horas);
        System.out.println("Dias:");
        dias.forEach((d) -> System.out.printf("%s\t",d));
    }

    public void MostrarGrupo(){
//        System.out.printf("Materia %s:\n",materia.nombre);
        // No se imprime la informacion de la materia porque eso se hace solo una vez por materia en el main -C
        System.out.println("Grupo " + numGrupo);
        MostrarHorario();
        System.out.println("Salon: " + salon);
        System.out.println("Profesor:");
        System.out.print("\t");profe.MostrarProfesor();
    }

}