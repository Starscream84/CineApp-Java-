# CineApp

Aplicación de escritorio para la gestión de un cine: permite administrar el catálogo de **películas** y programar sus **funciones** (fecha, hora, sala y precio).

Trabajo práctico final de la materia, carrera de Desarrollo de Software — Instituto IDRA.

## Funcionalidades

**Películas**
- Alta, listado, edición y baja.
- Género y clasificación (ATP, +13, +16, +18) se eligen de una lista.
- Validaciones: título obligatorio, duración mayor a 0, año entre 1888 y el año actual + 2.
- No se puede eliminar una película que tiene funciones programadas.

**Funciones**
- Alta, listado, edición y baja.
- Cada función está asociada a una película existente.
- Validaciones: película y sala obligatorias, fecha en formato `dd/mm/aaaa` y no anterior a hoy, hora en formato `hh:mm`, precio mayor a 0.
- El listado se muestra ordenado por fecha y hora.

## Tecnologías

| Tecnología | Versión |
|---|---|
| Java | 25 |
| Maven | 3.x |
| Swing (diseñado con el editor de NetBeans) | — |
| Jakarta Persistence (JPA) con Hibernate | 6.6 |
| MySQL | 8.x o superior |
| MySQL Connector/J | 9.5 |

## Arquitectura

El proyecto sigue el patrón **MVC** con una capa **DAO** para el acceso a datos:

```
src/main/java
├── com/mycompany/cineapp/CineApp.java   Punto de entrada: crea la conexión, los DAO y abre el menú
├── model/                               Entidades JPA: Movie y Showtime
│   └── usecase/                         Casos de uso de películas y sus validaciones
├── dao/                                 Interfaces DAO y sus implementaciones con JPA
├── controller/                          Controladores: conectan cada vista con el modelo
└── view/                                Ventanas Swing (solo muestran datos y exponen sus componentes)
```

- **Vista → Controlador → Caso de uso → DAO → Base de datos** en el módulo de películas.
- En el módulo de funciones, el controlador valida los datos y usa el DAO directamente.
- La relación entre ambas entidades es `@ManyToOne`: muchas funciones pueden pertenecer a una misma película (`showtimes.movie_id` → `movies.id`).
- Los errores de JPA se envuelven en `DAOException`, de modo que las capas superiores no dependen de la tecnología de persistencia.

## Requisitos

- JDK 25
- Maven 3.x (incluido en NetBeans)
- MySQL en ejecución en `localhost:3306`
- Recomendado: Apache NetBeans

## Configuración

### 1. Crear la base de datos

```sql
CREATE DATABASE cinema;
```

Las tablas **no hace falta crearlas**: Hibernate genera `movies` y `showtimes` automáticamente la primera vez que se ejecuta la aplicación (`hibernate.hbm2ddl.auto = update`).

### 2. Usuario y contraseña de MySQL

`src/main/resources/META-INF/persistence.xml` trae credenciales de ejemplo (`root` / `root`). Para usar las propias sin modificar ese archivo, se pasan como propiedades del sistema al ejecutar:

```
-Ddb.user=TU_USUARIO -Ddb.password=TU_CONTRASEÑA
```

`-Ddb.user` es opcional: si no se indica, se usa `root`.

**En NetBeans:** clic derecho en el proyecto → *Properties* → *Run* → *VM Options*, y escribir por ejemplo:

```
-Ddb.password=TU_CONTRASEÑA
```

NetBeans guarda esa configuración en `nbactions.xml`, que está excluido del repositorio en `.gitignore`.

## Ejecución

**Desde NetBeans:** *Clean and Build* y luego *Run* (F6).

**Desde la terminal**, en la carpeta del proyecto:

```bash
mvn clean compile exec:java -Ddb.password=TU_CONTRASEÑA
```

Si MySQL no está en ejecución o las credenciales son incorrectas, la aplicación muestra un mensaje de error y se cierra.

## Autores

- Matías Rosas
- Camila Larsen
- Matías Nerli
