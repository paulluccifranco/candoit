Proyecto Cando-IT

Levantar el sistema:
El .jar que se encuenta en la carpeta Docker, fue creado mediante maven package.
En la carpeta docker encontramos el .jar antes mencionado, un docker-compose y el respectivo Build para la imagen de la aplicacion.
Corriendo docker compose en la carpeta Docker levantara los containers necesarios para que la aplicacion funcione sin problema. Tener en cuenta que se expondra el puerto 8080 y se podra acceder mediante http://localhost:8080/Candoit
Los containers de las bases de datos no expondran los puertos al host por lo que no habria conflictos con el uso de puertos
AL iniciar la aplicacion creara un usuario administrador con username: franco  y password: 123456
Solo los usuarios administradores pueden utilizar el ABM de usuarios.



Aclaraciones:
Aclaro que decidi utilizar la base mongo para la persistencia de los datos que se obitenen mediante la api de clima ya que me parecio que ante la cantidad de datos que se podrian llegar a manejar era mucho mas practico y eficiente. Obviamente esto esta pensado desde un punto de vista de que la aplicacion no va a escalar y que la funcionalidad que sirve las localidades y su clima va a ser siempre la misma. En el caso de una aplicacion que se desarrolle para un entorno productivo posiblemente se evaluaria la posibilidad de armar una base relacional o en consecuencia otra estructura de la base mongo.

