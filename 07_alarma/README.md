# Ejercicio 7 - Alarma

Esta aplicación es una simulación del funcionamiento de una alarma de seguridad, que utiliza sensores de movimiento para detectar la presencia de posibles intrusos. 

El diagrama de clases adjunto representa la estructura del sistema:

<img src="alarma.png" width="500" />

El programa mostrará un menú como el siguiente:

1. Activar alarma
2. Desactivar alarma (necesario PIN)
3. Consultar sensores
4. Salir

El funcionamiento del sistema es el siguiente:

- Cuando el programa arranca, se genera la alarma y se conectan a ella un número aleatorio de sensores, comprendido entre 1 y 5.
- Cada sensor tiene un umbral específico y aleatorio, comprendido entre 1 y 100.
- Cuando se haga una llamada a la función `hayMovimiento()`, ésta calculará un valor entre 1 y 100 y si es mayor que el umbral del sensor, devolverá que hay movimiento.
- El método `consultarSensores()` consulta todos los sensores activos y, si es necesario, dispara la alarma y da el aviso al número de teléfono almacenado en el sistema, el cual habremos pedido al usuario al arrancar. También informará de qué sensor ha disparado la alarma.

Otros detalles importantes son:

- La alarma dispone de un código PIN de cuatro dígitos que se genera automáticamente al iniciar el programa.
- El usuario dispone de tres intentos para desactivar la alarma antes de que se active por introducir un PIN erróneo.
