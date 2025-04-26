package gestion.cursos.proyectogestiondecursos.model;

public class Docente {
    private Long id;
    private String nombre;
    private String apellido;
    private String materia;
    private String curso;

    public Docente() {
    }

    public Docente(String nombre, String apellido, String materia, String curso) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.materia = materia;
        this.curso = curso;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
}
