package gestion.cursos.proyectogestiondecursos.controller;

import gestion.cursos.proyectogestiondecursos.model.Curso;
import gestion.cursos.proyectogestiondecursos.model.Docente;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@PreAuthorize("denyAll()")
public class GestionController {

    private List<Curso> cursos = new ArrayList<>();
    private List<Docente> docentes = new ArrayList<>();
    private Long cursoId = 1L;
    private Long docenteId = 1L;



    @GetMapping("/cursos")
    @PreAuthorize("hasAuthority('READ_CURSOS')")
    public List<Curso> verCursos() {
        return cursos;
    }

    
    @PostMapping("/cursos")
    @PreAuthorize("hasAuthority('WRITE_CURSOS')")
    public Curso crearCurso(@RequestBody Curso curso) {
        curso.setId(cursoId++);
        cursos.add(curso);
        return curso;
    }

//      System.out.println(Docente nuevo: docente);

    @GetMapping("/docentes")
    @PreAuthorize("hasAuthority('READ_DOCENTES')")
    public List<Docente> verDocentes() {
        return docentes;
    }

    @PostMapping("/docentes")
    @PreAuthorize("hasAuthority('WRITE_DOCENTES')")
    public Docente agregarDocente(@RequestBody Docente docente) {
        docente.setId(docenteId++);
        docentes.add(docente);
        return docente;
    }

    


    @GetMapping("/public")
    @PreAuthorize("permitAll()")
    public String vistaGeneral() {
        return "¡Bienvenido/a a los listados del colegio!";
    }
}
