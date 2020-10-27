package CodigoP4_Chris;

public class Domicilio {
    
    String calle;
    String delegacion;
    String colonia;
    String CP;
    boolean peligro;
    String ciudad;

    public Domicilio(){
        
    }

    public Domicilio(String calle, String delegacion, String colonia, String CP, String ciudad){
        setCalle(calle);
        setDelegacion(delegacion);
        setColonia(colonia);
        setPeligro();
        setCP(CP);
        setCiudad(calle);
    }

    public void setCalle(String calle){
        this.calle = calle;
    }

    public void setDelegacion(String delegacion){
        this.delegacion = delegacion;
    }

    public void setColonia(String colonia){
        this.colonia = colonia;
    }

    public void setCP(String CP){
        this.CP = CP;
    }

    public void setCiudad(String calle){
        this.ciudad = calle;
    }

    public void setPeligro(){
        if (delegacion.equals("Iztapalapa") || delegacion.equals("iztapalapa") ){
            this.peligro = true;
        }else{
            this.peligro = false;
        }
    }

    public void HayPeligro(){
        if (this.peligro){
            System.out.println("Peligro: La ubicacion se ubica en Iztapalapa.");
        }else{
            System.out.println("Ubicacion libre de peligro.");
        }
    }

    public void MostrarDomicilio(){
        System.out.println("La direccion del alumno es: ");
        System.out.printf("\tCalle: %s\n",this.calle);
        System.out.printf("\tDelegacion: %s\n",this.delegacion);
        System.out.printf("\tColonia: %s\n",this.colonia);
        System.out.printf("\tCodigo Postal: %s\n",this.CP);
        System.out.printf("\tCiudad: %s\n",this.ciudad);
        HayPeligro();
    }
}
