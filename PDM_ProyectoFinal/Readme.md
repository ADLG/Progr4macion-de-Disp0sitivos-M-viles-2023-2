Programación de Dispositivos Móviles 2023-2

Proyecto Final

Integrantes:
ADLG
JGJMP

Se hizo un proyecto en Android Studio y se probó con un emulador con Android 8.1.

Como trabajamos sobre las mismas tareas, la carpeta con el proyecto se llama Tarea2.
Las vistas y los botones deberían funcionar correctamente.
Usamos SQLite ademas de sqlite3 para visualizar la base.
Hicimos una base de datos llamada store.db donde se guardan los datos de los usuarios
registrados en t_user, los productos de su carrito que se guardan en t_item y tambien
hicimos uso de otra tabla con el fin de mostrar el carrito del usuario que se logea.

Tratamos de hacer un servicio de comida por aplicación, dicha app lo que hace es:
Al abrirla se presentan las opciones para iniciar sesión y registrarse.
Al registrarse los datos ingresados de guardan en una tabla llamada t_user.
Al iniciar sesión se presentan 4 tipos de alimentos, 2 bebidas y 1 hamburguesa y 1 espagueti.
Hay dos botones en la pantalla del menú, uno para cerrar la sesión y otro para ver el carrito de compras.
Falto implementar la parte para visualizar muchos carritos en vez de 1.
En la pantalla del carrito existen dos botones, uno para regresar al menú y otro para ordenar.
Si es presionado el botón de ordenar, se redirige a una pantalla con un agradecimiento por la compra
y aparece un botón para volver al menú, donde se puede ordenar de nuevo o salir de dicha sesión.

