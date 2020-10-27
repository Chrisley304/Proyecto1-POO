import java.util.HashMap; 

public class Asignatura{
	String nombre;
	int clave;
	int no_grupos;
	int creditos;
	boolean lab; //laboratorio extra
	//mejor ponerlo en la eleccion (main) o creacion de la asignatura
	String divisiones[] = new String[] { "División de Ciencias Básicas", "División de Ingenierías Civil y Geomática", "División de Ingeniería Eléctrica", "División de Ingeniería en Ciencias de la Tierra","División de Ingeniería Mecánica e Industrial","División de Ciencias Sociales y Humanidades","División de Educación Continua y a Distancia"};
	char tipo; //teoría o laboratorio normal
	String division;
	static int numasignaturas;
	//ASIGNATURAS CON CLAVE
	
	//System.out.println(asignaturas); 

	//Constructor
	public Asignatura(String nombre, int clave, int no_grupos,int creditos,String division,char tipo){
		this.nombre = nombre;
		this.clave = clave;
		this.no_grupos = no_grupos;
		this.creditos = creditos;
		this.division = division;
		this.tipo = tipo;
		this.numasignaturas ++;
	}

	public String getDivision(){
		return this.division;
	}

	public String getNombre(){
		return this.nombre;
	}

	public int getClave(){
		return this.clave;
	}

	public int getNoGrupos(){
		return this.no_grupos;
	}

	public int getCreditos(){
		return this.creditos;
	}

	public char getTipo(){
		return this.tipo;
	}

	/*IDEA PARA DIVISIONES
     List<String> list = Arrays.asList(a); 
  	System.out.println("The list is: " + list); */

  	public void mostrarAsignatura(){
  		System.out.println("ASIGNATURA: " + this.nombre);
  		System.out.println("CLAVE: " + this.clave);
  		System.out.println("NÚMERO DE GRUPOS EXISTENTES: " + this.no_grupos);
  		System.out.println("CRÉDITOS: " + this.creditos);
  		System.out.println("DIVISIÓN:: " + this.division);
  		if(lab){
  			System.out.println("LABORATORIO DE : " + this.nombre + "(L+)");
  		}
  	}



  	//USO EXCLUSIVO DE INSCRIPCIÓN
  	public boolean existeAsignatura(int clave,String materia){
		HashMap<Integer , Asignatura> asignaturas = new HashMap<Integer, String>();
			  //String (Nombre de la materia)
		for(int i = 0;i<numasignaturas;i++){
			asignaturas.put(i,materia.getValue(i));
			
		}
			// Grupos ={ 1890 : {1 : {}, 2: {}, 3:{} } , 2550: {1: {}, 2:{} , 3:{} }}
			


		asignaturas.put(15353535, "Bere");
		asignaturas.put(2, "EDA 2");
		asignaturas.put(3, "Algebra");
		asignaturas.put(4, "Calculo Integral");
		asignaturas.put(5, "Calculo Vectorial");
		asignaturas.put(6, "Programacion Orientada a Objetos");
		asignaturas.put(7, "Redaccion y Exposicion de Temas de Ingeniería");
  		for (int i : asignaturas.keySet()) {
	      	if(i==clave)
  				return true; 		
	    }
	    return false;	
  	}
}