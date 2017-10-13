# Ejercicio 9 - Averías

Queremos construir una aplicación que permita gestionar las averías que se producen en los equipos informáticos de las aulas de Arriaga. 

El diagrama de clases que describe la información que tenemos que gestionar es el siguiente:

<img src="averias.png" width="400" />

El programa mostrará un menú como el siguiente:

1. Alta de técnico.
2. Gestión de averías
	1. Nueva avería.
	2. Asignar avería a técnico.
	3. Atender avería.
3. Listados
	1. Listado de averías sin resolver de un técnico.
	2. Listado de todas las averías de un técnico (resueltas y no resueltas).
	3. Listado de todas las averías del sistema y técnico asignado.
4. Salir

El funcionamiento del sistema es el siguiente:

- Los técnicos atienden las averías por orden de llegada.
- Cuando un técnico atiende una avería, esta puede quedar resuelta o no. 
- Si el nivel del técnico es mayor o igual que el de la avería, se resuelve. Si no, no.
- Si la avería se resuelve, deja de estar pendiente.
- Si no se resuelve, vuelve a entrar en la lista de pendientes, en último lugar, disminuyendo en uno el nivel de la avería.

Restricciones: 

- Pueden utilizarse las estructuras de datos que se consideren adecuadas para resolver el problema, justificando la elección.
- No hay límite en el máximo de técnicos y averías diferentes que podemos almacenar en el sistema.
- En las clases del proyecto, sólo se pueden añadir las propiedades estrictamente necesarias para mantener la asociación entre los objetos. Ninguna más.
