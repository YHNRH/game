game/Player.class: game/Player.java
	javac game/Player.java

game/GameObject.class: game/GameObject.java
	javac game/GameObject.java

game/World.class: game/World.java
	javac game/World.java

game/Tree.class: game/Tree.java
	javac game/Tree.java

Game.class: Game.java
	javac Game.java

build: game/Player.class game/GameObject.class game/Tree.class game/World.class Game.class

run: build
	java Game
