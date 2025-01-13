# Proyecto Horóscopo Chino

¡Bienvenido(a) a **Horóscopo**! Este proyecto es una aplicación web desarrollada en **Java** (usando **Servlets**, **JSP**, y **JDBC** para la conexión a Oracle) que permite:

1. **Registrar usuarios** con sus datos y fecha de nacimiento.  
2. **Calcular** automáticamente el signo del horóscopo chino del usuario y almacenarlo.  
3. **Iniciar sesión** con el usuario registrado.  
4. **Consultar** el signo chino y otras operaciones (buscar, modificar, eliminar usuarios).  

---

## Tabla de Contenidos
1. [Requisitos](#requisitos)  
2. [Instalación y Configuración](#instalación-y-configuración)  
3. [Estructura del Proyecto](#estructura-del-proyecto)  
4. [Uso de la Aplicación](#uso-de-la-aplicación)  
6. [Créditos](#créditos)  

---

## Requisitos

- **Java JDK** 17 (o superior).  
- **Apache Tomcat** 10.1 / 11.0 (o compatible con Jakarta Servlet 5.0/6.0).  
- **Oracle** (base de datos).  
- **Eclipse IDE** (o cualquier IDE compatible con proyectos web en Java).  

Archivos JAR externos necesarios en `WEB-INF/lib`:
- `jakarta.servlet-api-6.1.0.jar`  
- `jakarta.servlet.jsp.jstl-3.0.1.jar`  
- `ojdbc8.jar` (para la conexión con Oracle)

---

## Instalación y Configuración

1. **Clona** o **descarga** este repositorio en tu máquina local:
   ```bash
   git clone https://github.com/tu-usuario/horoscopo.git
   
2. Abre el proyecto en Eclipse:
- Ve a File > Import > Existing Projects into Workspace.
- Selecciona la carpeta donde clonaste el repositorio y finaliza.

3. Configura Apache Tomcat (v10.1 o v11) en Eclipse:
- Ve a **Window > Preferences > Server > Runtime Environments > Add**.
- Selecciona la versión de Tomcat que tengas instalada y apunta a la carpeta donde esté Tomcat.

4. Agrega los JARs necesarios:
Coloca los siguientes archivos en la carpeta `WebContent/WEB-INF/lib` o agrégalos al **build path** de tu proyecto:

- `jakarta.servlet-api-6.1.0.jar`
- `jakarta.servlet.jsp.jstl-3.0.1.jar`
- `ojdbc8.jar`

5. Crea la base de datos en Oracle:
Ejecuta el siguiente script SQL para crear la tabla `PERSONA`:
SQL
`CREATE TABLE PERSONA (
    NOMBRE VARCHAR2(100 BYTE),
    USUARIO VARCHAR2(100 BYTE),
    EMAIL VARCHAR2(100 BYTE),
    FECHA_NACIMIENTO DATE,
    PASSWORD VARCHAR2(255 BYTE),
    ANIMAL_HOROSCOPO VARCHAR2(50 BYTE) NOT NULL
);`
Asegúrate de ajustar el usuario y la contraseña en tu archivo de consión.

5. Ejecuta el proyecto en Eclipse:
- Haz clic derecho sobre el proyecto y selecciona Run As > Run on Server.
- Selecciona tu servidor Tomcat y haz clic en Finish.

---

## Estructura del Proyecto

1. **Clona** o **descarga** este repositorio en tu máquina local:
   ```bash
   Horoscopo
   ├── src
   │   └── com
   │       └── horoscopo
   │           ├── dao
   │           │   ├── UsuarioDAO.java
   │           │   ├── UsuarioDAOImpl.java
   │           │   └── ...
   │           ├── modelo
   │           │   ├── Usuario.java
   │           │   ├── Horoscopo.java
   │           │   └── ...
   │           ├── procesaconexion
   │           │   └── ConexionManager.java
   │           └── servlets
   │               ├── LoginServlet.java
   │               ├── RegistroServlet.java
   │               ├── ConsultarHoroscopoServlet.java
   │               └── ...
   ├── WebContent
   │   ├── META-INF
   │   ├── WEB-INF
   │   │   ├── lib
   │   │   │   ├── jakarta.servlet-api-6.1.0.jar
   │   │   │   ├── jakarta.servlet.jsp.jstl-3.0.1.jar
   │   │   │   └── ojdbc8.jar
   │   │   ├── web.xml
   │   ├── css
   │   │   └── estilos.css (opcional)
   │   ├── login.jsp
   │   ├── registro.jsp
   │   ├── menu.jsp
   │   ├── conocerSigno.jsp
   │   ├── buscarUsuario.jsp
   │   ├── modificarUsuario.jsp
   │   └── eliminarUsuario.jsp
   └── README.md

---

## Uso de la Aplicación

1. Inicia la aplicación en tu navegador:
- Normalmente, se accede a:
http://localhost:8080/Horoscopo/
(o el contexto que hayas configurado en Eclipse).

2. Pantalla de Login:
- Ingresa tu usuario y password.
- Si no estás registrado, haz clic en "¿No tienes cuenta? Regístrate".

3. Pantalla de Registro:
- Completa tus datos y la fecha de nacimiento.
- El sistema calculará tu signo chino y lo guardará automáticamente.

4. Menú principal (una vez logueado):
- Conocer tu signo zodiacal (te muestra el signo calculado). 
- Buscar usuarios (por username).
- Modificar tu usuario (cambios de email, fecha nacimiento, etc.).
- Eliminar tu usuario (borrar tu cuenta de la BD).

5. Cerrar Sesión:
- Simplemente regresa al login.jsp o invalida la sesión según tu implementación.

---

## Créditos

Si encuentras mejoras o deseas contribuir, no dudes en abrir un **Pull Request** o **Issue** en el repositorio.

### Nota:
Este proyecto es un ejemplo didáctico y **no incluye seguridad avanzada** (no encripta contraseñas ni maneja roles).  
Se recomienda utilizar frameworks como **Spring** o **Jakarta EE** junto con buenas prácticas de seguridad para proyectos de producción.
