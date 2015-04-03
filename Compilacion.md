# Compilación #

Para la compilación se utilizará el "_Ant_". Para esto simplemente es necesario (habiendo ya instalado el Ant en el sistema) hacer un checkout completo del trunk y luego, desde consola posicionarse en el directorio correspondiente ejecutando el comando _ant_.
Esto generará automáticamente una carpeta _bin_ en la cual se albergarán los archivos _.class_ organizados en la jerarquía de paquetes. Además, se ejecutaran, luego de la compilación, los tests mediante el TestRunner de la librería JUnit incluida en los archivos del repositorio.