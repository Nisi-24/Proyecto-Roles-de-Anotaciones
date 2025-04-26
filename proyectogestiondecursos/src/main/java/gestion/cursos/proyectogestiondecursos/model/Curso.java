package gestion.cursos.proyectogestiondecursos.model;

public class Curso {
    private Long id;
    private String materia;
    private String curso;

    public Curso() {}

    public Curso(String materia, String curso) {
        this.materia = materia;
        this.curso = curso;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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


