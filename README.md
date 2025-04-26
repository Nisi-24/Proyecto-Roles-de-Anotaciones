#Proyecto Roles de Anotaciones

Aplicación web desarrollada con Spring Boot que permite gestionar cursos y docentes en un colegio, implementando seguridad basada en roles y permisos mediante Spring Security (sin base de datos)

Roles y Funcionalidades: ADMIN: CRUD de docentes, agregar cursos, ver todos los cursos y docentes.

DOCENTE: Ver sus cursos asignados y consultar docentes.

ESTUDIANTE: Consultar lista de cursos disponibles.

⚙️ Características: Autenticación básica HTTP con usuarios en memoria.

Control de acceso mediante anotaciones @PreAuthorize.

Contraseñas cifradas con BCryptPasswordEncoder.

Configuración sin estado (STATELESS) y CSRF deshabilitado.

Datos almacenados en memoria (sin base de datos).

Endpoints públicos y protegidos según permisos.
