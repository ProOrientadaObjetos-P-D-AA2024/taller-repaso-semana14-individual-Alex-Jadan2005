
package modelo;
public class datos {
    public String nombre;
    public String cedula;
    public String correo;
    public String telefono;

    public datos(String nombre, String cedula, String correo, String telefono) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.correo = correo;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    @Override
    public String toString(){
        String Data=String.format("Nombre: %s"+" Cedula: %s"+" Correo: %s"+" Telefono: %s%n",getNombre(),getCedula(),getCorreo(),getTelefono());
        return Data;
    }
    
}
