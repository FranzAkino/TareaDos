package sv.edu.uesocc.tareados;

/**
 * Created by akino on 04-27-15.
 */
public class Persona {
    private String nombre;
    private String apellido;
    private String email;
    private String dui;
    private int edad;
    private String sexo;

    public Persona(String nombre, String apellido, String email, String dui, int edad, String sexo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.dui = dui;
        this.edad = edad;
        this.sexo = sexo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
}
