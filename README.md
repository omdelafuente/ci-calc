### Para levantar el entorno de integración
_____________________

Ejecutar ``docker-compose up -d `` dentro de la carpeta *docker* y esperar a que los contenedores se levanten.

Jenkins escucha en *localhost:8082*. Primero habrá que desbloquearlo introduciendo la contraseña que se encuentra en la consola en la que se ha levantado Jenkins o en */var/jenkins_home/secrets/initialAdminPassword*.

Para configurar Jenkins:

- Install suggested plugins y esperar a que se instalen todos los plugins.
- En Create first admin user se introduce `admin` en todos los campos y `admin@admin.com`en el correo (u otros datos de preferencia).
- Estando ya en el Panel de control, vamos a Administrar Jenkins y a Global Tool Configuration.   
JDK:  
Nombre: Java8  
Instalar automáticamente  
Java SE Development Kit 8u181  
Check Estoy deacuerdo con el acuerdo de licencia de kit de desarrollo de 'Java SE'  
(Hay que autenticarse con una cuenta de Oracle)  
Maven:  
Nombre: Maven3.5.4
Check Instalar automáticamente  
Instalar desde Apache Versión 3.5.4

Hecho esto, pasamos a configurar el proyecto para automatizar el proceso de integración:
- En el Panel de control vamos a Nueva tarea, le ponemos de nombre ci-calc y Crear un proyecto de estilo libre.
- Configurar el origen del código fuente y pegamos en Repository URL la dirección del repositorio donde se encuentra nuestro código (por ejemplo, *https://github.com/omdelafuente/ci-calc.git*)
- Después, Ejecutar -> Añadir un nuevo paso -> Ejecutar tareas 'maven' de nivel superior, seleccionamos la versión de maven configurada y en Goles añadimos `clean install -Pjenkins`.
- De nuevo, Ejecutar -> Añadir un nuevo paso -> Ejecutar tareas 'maven' de nivel superior, seleccionamos la versión de maven configurada y en Goles añadimos `sonar:sonar -Pjenkins`.
- Para añadir el despliegue al repositorio de Nexus, Ejecutar -> Añadir un nuevo paso -> Ejecutar tareas 'maven' de nivel superior, seleccionamos la versión de maven configurada y en Goles añadimos `package deploy:deploy -s docker/settings.xml -Pjenkins`.
- Por último, para desplegar el proyecto construido al servidor Tomcat, Ejecutar -> Añadir un nuevo paso -> Ejecutar tareas 'maven' de nivel superior, seleccionamos la versión de maven configurada y en Goles añadimos `cp /var/jenkins_home/workspace/ci-calc/target/ci-calc.war /var/war`.

Finalmente, se puede acceder a la aplicación mediante *localhost:8080/ci-calc/calculadora*. Los resultados del análisis de SonarQube se pueden ver en *localhost:9000* y el repositorio de Nexus en *localhost:8081/nexus*. 