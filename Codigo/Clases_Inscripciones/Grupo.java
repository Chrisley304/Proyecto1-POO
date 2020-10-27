package Clases_Inscripciones;

import CodigoP4_Chris.Asignatura;
import CodigoP4_Chris.Profesor;
import java.util.Hashtable;

public class Grupo {
    int numGrupo;   //No puede ser estatica, porque habra grupos de diferentes materias
    Hashtable<String, String> Horarios = new Hashtable<>();
    String salon;
    Profesor profe;
    Asignatura materia;

    public Grupo(int numGrupo, String horas, String dias, String salon, Profesor profe, Asignatura materia){
        this.numGrupo = numGrupo;
        this.Horarios.put("Dias",dias);
        this.Horarios.put("Horas",horas);
        this.salon = salon;
        this.profe = profe;
        this.materia = materia;
    }

}