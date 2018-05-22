
***EciWar (BackEnd)***
======

*Proyecto desarrollado en el periodo académico 2018-1 por AnonymousGamesECI para el curso Arquitecturas de Software (ARSW)*

  Integrantes de AnonymousGamesECI:
  -------
  - [Juan Nicolas Gomez Moreno](https://github.com/JuanNicolasGomez) - (JuanNicolasGomez)
  - [Nicolas Osorio Arias](https://github.com/Nixperful) - (n.osorio y Nixperful)
  - [Juan David Ramirez Mendoza](https://github.com/CAPJackie) - (rescate rescate, unknown y CAPJackie)
  
  Profesores:
  -------
  ##### Héctor Fabio Cadavid Rengifo (Teórica)
  ##### Santiago Carrillo (Laboratorios)
  

*_Descripción resumida del producto:_*
------- 
ECIWAR es un videojuego multijugador del género top down shooter. Su principal objetivo es ser el sobreviviente final, entre los múltiples usuarios que se encuentren en cada partida, un juego que asegura diversión y acción constante.

*_UI Simulation_*
-------
Para empezar, encontramos el menú de usuario en el cual se puede interactuar para personalizar el nombre de usuario (Nickname) y la sala a la que se quiere acceder

![](img/MenuSS.png)

Como podemos contemplar hay tes elementos de la UI relevantes en el diseño:

1. Este es el campo de entrada en el cual el usuario ingresa su nombre (tal y como se indica aquí).

2. Este botón es para crear un nuevo room, es usado cuando no hay rooms disponibles o cuando los rooms disponibles estan llenos.

3. Es el panel que muestra los rooms que están creados actualmente (están disponibles o no). 	Para unirse a un room hay que dar click en el botón con el nombre “Join”.

Después de haberse unido a alguna sala hay tres posibles escenarios: cuando esta disponible la sala, cuando está ocupada y cuando el usuario es el último en ocupar la sala.


### Escenario 1: Sala disponible

![](img/WaitSS.png)

Tal y como lo indica el mensaje en la UI el usuario debe esperar a que los suficientes jugadores se unan a la partida y de esta manera poder empezar a jugar.

### Escenario 2: Sala llena

![](img/ErrorSS.png)

En este escenario el aplicativo lanza una excepción que desencadena un mensaje de alerta hacia el usuario para impedirle el acceso a la sala.

### Escenario 3: Comienzo de la partida

![](img/GameSS.png)

Para finalizar, cuando el usuario que accede a la sala es el último en ocupar el puesto en la cola, el juego inicia. En la UI del juego hay componentes que no se deben pasar por alto, aquellos componentes son:

1. Player: El jugador cuenta con un arma de corto alcance (Gun) el cual dispara las balas al hacer clic en la UI. Al mover el ratón la posición del jugador va a rotar.
Para moverse el usuario debe usar las teclas WASD o las flechas del teclado.

2. Enemy: En la UI el usuario puede ver a los enemigos vestidos con un traje de camuflaje, los disparos del enemigo son visualizados en la UI del usuario ya que se usa el broker MOM.

3. NickName Box: La UI cuenta con una barra que muestra el nombre o nickname elegido en el menú por el usuario.

4. PickUp: Los PickUps son elementos que el usuario puede recoger pasando por encima de aquellos, el tiempo de respawn es de 5 segundos, hay dos tipos de PickUps:
4.1. Life: el PickUp de live otorga un boost de vida al usuario
4.2. Munition: Este PickUp otorga un boost de balas al usuario que las recoja.

5. Left Players Bar: Este componente es el encargado de mostrar el número de jugadores en el juego restantes, cuando alguien muere envía un mensaje al broker de mensajería el cual se encarga de actualizar el número de jugadores restantes de la UI.

6. Kills Count Bar: Se encarga de mostrar el conteo de asesinatos que ha realizado el usuario, Cuando Un jugador muere envía un mensaje al broker para que se encargue de actualizar la barra de conteo de kills del jugador que lo asesinó.

7. Life Bar: Es la barra encargada de mostrar la vida restante del jugador. Cuando hay colisión entre el jugador y una bala la barra de vida baja ya que la vida del personaje también disminuye, es decir, esta barra se actualiza cada vez que hay una colisión entre el personaje y algún otro componente.

8. Bullets Left Component: Se encarga de mostrar el número de balas restantes que le quedan al usuario. Cada vez que se dispara una bala, la aplicación se encarga de actualizar el número de balas restantes y de la misma forma el número que se muestra en el componente.


*_Diagramas:_*

### Activity Diagram

----------------IMAGEN-----------------


### Components Diagram

----------------IMAGEN-----------------


### Deploy Diagrams

#### Heroku version

----------------IMAGEN-----------------


#### Scalable AWS version

----------------IMAGEN-----------------




### *Una interfaz empresarial que se puede acoplar perfectamente a la que se tiene en servicios académicos, elaborada en PrimeFaces lo cual brinda variedad de herramientas que se aprovecharon de la mejor manera.*

*_Vistas:_*
------- 
[![Heroku](https://wmpics.pics/di-NNAT.png)](https://eciwarapi.herokuapp.com/)

[![CircleCI](https://circleci.com/gh/AnonymousGamesECI/BackendECIWAR.svg?style=svg)](https://circleci.com/gh/AnonymousGamesECI/BackendECIWAR)

[![Codacy Badge](https://api.codacy.com/project/badge/Grade/bf0410d2a5ba4bae83ade3bd59cdceac)](https://www.codacy.com/app/AnonymousGamesEci/EciWar?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=AnonymousGamesECI/EciWar&amp;utm_campaign=Badge_Grade)
