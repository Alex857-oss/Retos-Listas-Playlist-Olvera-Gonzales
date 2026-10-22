# Retos con listas simples, dobles y circulares
## Integrantes
- José Alejandro Olvera Lugo
- Gonzalez hernandez Juan Eduardo
## Datos de la actividad
Estructura de datos, Gabriel Barrón Rodriguez, 22/10/2026, versión asignada (B).
## Conceptos aprendidos 
Lista Simplemente Enlazada
Es una secuencia de elementos donde cada uno guarda su dato y solo un enlace al siguiente elemento; el último apunta a "nada" (nulo). No hay forma de ir hacia atrás directamente.
Ventajas
Estructura muy simple, fácil de implementar.
No desperdicia memoria: se crean elementos solo cuando se necesitan.
Insertar o eliminar al principio es muy rápido, sin mover otros elementos.
Desventajas
Solo se puede recorrer hacia adelante; no se puede volver atrás sin empezar desde el inicio.
Para acceder a un elemento hay que recorrer desde el principio, es lenta si el elemento está lejos.
No se puede acceder directamente a una posición (hay que ir uno por uno).
Ejemplo real
Una cola de impresión: los trabajos van llegando y se procesan en orden, uno tras otro, y solo se conoce cuál sigue.
Lista Doblemente Enlazada
Cada elemento tiene tres partes: el dato, un enlace al elemento anterior y un enlace al siguiente. Así se puede avanzar y retroceder libremente.
Ventajas
Se recorre en ambas direcciones, más flexible.
Insertar o eliminar un elemento es más fácil porque ya se sabe quién está antes y después.
Si se pierde la referencia inicial, se puede recorrer desde el final hacia el principio.
Desventajas
Ocupa más memoria por cada elemento (guarda dos enlaces en lugar de uno).
Ligeramente más compleja de programar: hay que actualizar dos enlaces cada vez que se modifica.
Ejemplo real
El historial de navegador: puedes ir hacia adelante y hacia atrás entre páginas visitadas.
Reproductor de música con botones de anterior / siguiente.
Lista Circular
Puede ser simple o doble, pero la diferencia es que el último elemento se conecta de vuelta al primero, formando un bucle —ningún elemento apunta a "nada".
Ventajas
Se puede recorrer sin llegar al final; el ciclo no se interrumpe.
Es muy práctica para procesos que se repiten constantemente.
Si se tiene la referencia a cualquier nodo, se puede llegar a todos los demás.
Desventajas
Hay que tener cuidado con los bucles infinitos al recorrerla (si no se controla, nunca se detiene).
Más compleja de gestionar: hay que recordar dónde se empezó para no dar vueltas siempre.
No es adecuada cuando los elementos tienen un principio y un final definidos.
## Reto 1
- Explicación en codigo
- Capturas en carpeta
## Reto 2
Explicación en codigo
Capturas en carpeta
## Reto 3
Explicación en codigo
Capturas en carpeta
## Reflexión final (mínimo 5 líneas por pregunta)
1. Punteros en lista doble
En lista doble se actualizan dos enlaces por lado: el siguiente del anterior y el anterior del siguiente,
además de ajustar el inicio o fin si corresponde. En la simple solo se cambia el siguiente del nodo anterior.
La diferencia es que la doble mantiene conexión en ambas direcciones, así que ambas deben quedar correctas para poder avanzar y retroceder sin errores.
3. Casos vacío / un nodo
Si no se validan, se intenta acceder a posiciones inexistentes y el programa falla.
Con un solo nodo, al borrarlo hay que poner el inicio en nulo; si se olvida, queda una referencia fantasma.
Lo solucionamos agregando condiciones específicas al inicio de cada función: primero comprobamos si está vacía y luego si hay un solo elemento,
tratándolos aparte.
5. while (actual != null) en lista circular
Provoca un bucle infinito, porque el último nodo apunta al primero y jamás se llega a nulo.
El recorrido nunca termina y el programa se queda bloqueado. Para evitarlo, se guarda el nodo de inicio y se detiene al volver a encontrarlo,
o se usa un contador con la cantidad de elementos.
7. ¿Cuándo elegir cada una?
Simple: procesos en un solo sentido, colas o pilas, cuando importa ahorrar memoria y simplicidad.
Doble: si se necesita ir hacia adelante y atrás, como historiales o reproductores, aunque use algo más de memoria.
Circular: tareas repetitivas sin fin fijo: semáforos, reparto de tareas o ciclos continuos.
8. Lo más difícil y solución
Lo más difícil fue no perder la referencia a los nodos al cambiar punteros, sobre todo en lista doble y circular.
Lo resolvimos dibujando los esquemas en papel antes de programar y trabajando en equipo: una escribía y la otra revisaba paso a paso,
detectando errores que solas no habríamos visto.
## Cómo compilar y ejecutar
Comandos javac/java usados.
javac Reto1.java
java Reto1
javac Reto2.java
java Reto2
javac Reto3.java
java Reto3

