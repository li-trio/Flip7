# Flip 7

A small command-line Flip 7 game written with Java and Kotlin.

## Requirements

- Java 21
- Gradle
- Kotlin support through the Gradle Kotlin JVM plugin

If Gradle was installed with SDKMAN and your shell cannot find it, run:

```sh
source "$HOME/.sdkman/bin/sdkman-init.sh"
```

## HOWTO

### Run the game

```sh
gradle run
```

You do not have to run `gradle build` before `gradle run`. The `run` task compiles the project first when anything changed, then starts the app.

### Build the project

```sh
gradle build
```

Use this when you want to check that everything compiles and packages correctly without playing the game.

### Clean generated files

```sh
gradle clean
```

This removes Gradle build output from the `build/` directory.

## Project Layout

```text
source/Main.java   # starts the app
source/Game.java   # game loop and input flow
source/Player.java # player hand and scoring
source/Deck.kt     # shuffled deck and card drawing
```

## Input

For yes/no prompts, these inputs are accepted:

- `yes` or `y`
- `no` or `n`

Any other input shows a warning and asks again.
