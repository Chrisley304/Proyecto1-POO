package Clases_Inscripciones;

import CodigoP4_Chris.Asignatura;
import CodigoP4_Chris.Profesor;

import java.util.ArrayList;
import java.util.Hashtable;

public class Grupo {
    int numGrupo;   //No puede ser estatica, porque habra grupos de diferentes materias
    String horas;
    ArrayList<String> dias;
    String salon;
    Profesor profe;
    Asignatura materia;

    public Grupo(int numGrupo, String horas, ArrayList<String> dias, String salon, Profesor profe, Asignatura materia){
        this.numGrupo = numGrupo;
        this.horas = horas;
        this.dias = dias;
        this.salon = salon;
        this.profe = profe;
        this.materia = materia;
    }

}