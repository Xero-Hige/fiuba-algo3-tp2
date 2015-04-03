# Introducción #

El desarrollo del juego se llevará a cabo en lenguaje Java utilizando el patrón de arquitectura de software MVC (Modelo Vista Controlador).
Para realizar la interfaz gráfica se utilizará el framework [Titiritero](http://code.google.com/p/titiritero).


## Eclipse IDE ##

Para el uso del IDE Eclipse en el desarrollo del juego aconsejamos seguir las especificaciones que pasamos a detallar, de manera de evitar problemas y/o equivocaciones en el manejo y organización de archivos.
Lo primero será crear dos proyectos, uno llamado _"tp2-codigo-fuente"_ y otro llamado _"tp2-pruebas"_. Una vez hecho esto, diríjase a la carpeta del proyecto creada en el workspace. En la carpeta _"src"_ se deberá hacer checkout de la carpeta _tp2-codigo-fuente_ ubicada en el trunk del repositorio. La URL para realizar el checkout será:

`https://fiuba-algo3-tp2.googlecode.com/svn/trunk/tp2-codigo-fuente`

De esta manera, tendremos en el proyecto _tp2-codigo-fuente_ los archivos con el código fuente principal del proyecto.
Ahora deberemos hacer lo mismo con el proyecto _tp2-pruebas_, ingresamos en la carpeta del proyecto y hacemos checkout sobre la carpeta _src_ utilizando la siguiente URL:

`https://fiuba-algo3-tp2.googlecode.com/svn/trunk/tp2-prueba`

Una vez realizado estos simples pasos tendremos separado el código fuente principal y las pruebas de este en dos proyectos diferentes manteniendo así un desarrollo organizado y dinámico.

Por último, nos falta agregar a las librerías de cada proyecto el framework Titiritero. Para esto, recomendamos crear una carpeta _lib_ dentro del workspace actual y luego hacer checkout de la carpeta _lib_ almacenada en el trunk, mediante la siguiente URL:

`https://fiuba-algo3-tp2.googlecode.com/svn/trunk/lib`

Habiendo hecho esto, nos dirigiremos al eclipse, haremos click derecho sobre el proyecto _tp2-codigo-fuente_ e iremos a _Build path/Configure build path_. Una vez que aparezca la ventana de configuración, seleccionaremos la pestaña _Libraries_ (librerías) y luego presionaremos el botón _Add External JARs_. En la ventana de exploración nos dirigiremos a la carpeta _lib_ del workspace y seleccionaremos el archivo _titiritero.jar_. Finalmente presionamos OK, y listo, ya tendremos linkeado el framework a nuestro proyecto. Deben realizarse estos mismos mismos últimos pasos para el proyecto _tp2-pruebas_.