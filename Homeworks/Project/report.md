---
title: Path Finding Algorithm Analysis, Spring 2020 
subtitle: Group 2 - Object Oriented Software Design
author: >
    Adam Corbin (acorbin3@fau.edu)

date: March 2020
include-before:
- '`\newpage{}`{=latex}'
toc: true
numbersections: true
geometry: margin=2.5cm
urlcolor: blue
header-includes: |
    \usepackage{fancyhdr}
    \pagestyle{fancy}
    \lfoot{14 March 2020}
    \rfoot{Page \thepage}
---

# Path Finding Algorithm Analysis, Spring 2020 
## Group 2 - Object Oriented Software Design
## Adam Corbin - March 2020

# Functional Specification  
# Description
This application will dive into the different types of path finding algorithms games use in order to come up with the generated path when a character or player selects a destination position. This project will have a visual progression of the algorithms so that a human can see how well they preform between each other. I would like to evaluate different situations to find positives and negatives between the algorithms such as best case and worst-case scenarios. Statistic analysis will also be done to evaluate how well they rank between each other.

## List of things that this program will do
- Visual graph representing at least 1 or more algorithms running over time
- A way to view the results between the different algorithm
- A way for a human to pick start and destination points.
- A way to auto pick start and destination points

This will run on Windows 10 OS using Swing
## Intended users
• Any game developers who want to consider different options for path finding.
• Anyone who wants to understand how path finding algorithms work.
# Application Requirements

### Functional Requirements

1. **F.R-1**: The system shall generate a path given a start point, and end point, and the selected algorithm
2. **F.R-2**: The system shall let the user know if a path is not possible to be created
3. **F.R-3**: The system shall have the ability to clear the current paths 
4. **F.R-4**: The system shall keep track of history of each simulation during a given session
5. **F.R-5**: The system shall have the ability to select 2 points from the history
6. **F.R-6**: The system shall provide statistics on the different algorithms
7. **F.R-7**: The system shall provide the recommended algorithm for the given simulation
8. **F.R-8**: The system shall find worst case scenario for each algorithm given the scenario

### UI Requirements

1. **UI.R-1**: The UI shall be able to select a starting point and an end point
2. **UI.R-2**: The UI shall have a button to start the simulation
3. **UI.R-3**: The UI shall be able to see the algorithms behave over time where a human can visually see
4. **UI.R-4**: The UI shall be able to see multiple algorithms running at the same time to see the differences
5. **UI.R-5**: The UI shall have the ability to auto pick the 2 points
6. **UI.R-6**: The UI shall have the ability to select which algorithms to use for the simulation

# Use Cases

### UC-1: User selects a  path
1. The user selects the start and end points and uses default algorithm
2. The system computes the path generation
3. The system displays a successful path
### UC-2: User selects a path

#### Variation #1:  Invalid path
1. After step 2 , the system displays the path could not be found 

### UC-3: Computer generates path 
1. The user selects for the system to pick 2 random points on the graph
2. The system picks 2 random points
3. The system computes the path generation
4. The system displays a successful path

### UC-4: Computer generates path 

#### Variation #1: Invalid path
1. After step 2, the system displays that the path could not be found

### UC-5: User selects a different algorithm
1. The user selects the start and end points
2. The user changes the default algorithm to another selection
3. The system computes the path generation
4. The system displays the successful path 

### User selects points from history
1. The user picks from this history list to switch back to
2. The system regenerates the path from the history
3. The system displays the generated path 

### UC-6: System populates algorithm comparator  
1. The user selects all the algorithms to run for the simulation
2. The user picks the 2 points
3. The system generates the paths for each algorithm
4. The system displays a ranking order between each algorithm with some statistics. 

# User Interface
## Mockup
![mockup](images/mockup.PNG)
Link: https://gomockingbird.com/projects/v95sylo/4gXVnC

# Design Specification 

## CRC cards

### Tile
- Responsibilities
	- Coordinate on a map that is used to represent a node or a position
- Collaborators
	- Path
### Path
- Responsibilities
	- An ordered list of tiles that will be used to represent chain of tiles to get from start to finish
- Collaborators
	- Tile
	- Algorithm
	- AlgorithmController
### Algorithm 
- Responsibilities
	- Steps to find a path between a departure and destination position
- Collaborators
	- AlgorithmController
	- Path
### Grid 
- Responsibilities
	- Showing start and end tiles of a path
	- showing the different paths for the algorithms
	- Showing the visited tiles of the algorithms
- Collaborators
	- GUI
	- Path
	- Tile
### GridTile
- Responsibilities
	- Keeping track of what colors should the tile display in the grid
	- collision flag of the tile
- Collaborators
	- Grid

### AlgorithmController
- Responsibilities
	- Keeping track which algorithms are selected
	- Running the simulations
	- Keeps track of past history of the departure and destination tiles
	- Simulator that runs the algorithms and collects the comparative results
	- Keeps track of the tiles visited while going through the algorithm
	- Keeps track of optimized path for each algorithm 
- Collaborators
	- GUI
	- Grid
	- Algorithm
### GUI 

- Responsibilities
	- Displaying the grid
	- Displaying the start and end positions
	- Selectable algorithms
	- Displaying the comparison results of the different algorithms
	- Selectable history of past start and end positions	
- Collaborators
	- AlgorithmController
## UML Diagrams

### Class diagram key

```mermaid
classDiagram
classA --|> classB : Inheritance
classC --* classD : Composition
classE --o classF : Aggregation
classG --> classH : Association
classI -- classJ : Link(Solid)
classK ..> classL : Dependency
classM ..|> classN : Realization
classO .. classP : Link(Dashed)
```
### Class diagrams

```mermaid
classDiagram

class Tile
Tile: +y: Int
Tile: +y: Int

class Path
Path: +tiles: ArrayList<Tile>
Path: +getDeparture(): Tile
Path: +getDestination(): Tile

class Algorithm
Algorithm: +name: String
Algorithm: +visitedTiles: ArrayList<Tile>
Algorithm: +computeOptimalPath(start: Tile, end: Tile): Path
Algorithm: +getVisitedTiles(): ArrayList<Tile>


class Color
Color: +rgb: Int

class AlgorithmStats
AlgorithmStats: +algorithmName: String
AlgorithmStats: +runtime: Long
AlgorithmStats: +ramUsage: Long
AlgorithmStats: +pathLength: Int
AlgorithmStats: +visitedTiles: Int

class GridTile
GridTile: +color: Color
GridTile: +position: Tile
GridTile: +collisionFlag: Int

class Grid
Grid: +tiles: ArrayList<GridTile>
Grid: +updateGrid(tiles: ArrayList<GridTile>)
Grid: -colorTile(tile: Tile, color: Color)
Grid: +clearGraph()

class AlgorithmController
AlgorithmController: +startPosition: Tile
AlgorithmController: +endPosition: Tile
AlgorithmController: +history: ArrayList<Tile[]>
AlgorithmController: +enabledAlgorithms: Map<String,Boolean>
AlgorithmController: +gridData: Grid
AlgorithmController: +latestAlgorithmStats: ArrayList<AlgorithmStats>
AlgorithmController: +algorithms: ArrayList<Algorithm>

AlgorithmController: +runSimulation(test:String)
AlgorithmController: +setStartPosition(tile: Tile)
AlgorithmController: +endStartPosition(tile: Tile)
AlgorithmController: +setAlgorithmEnabled(algorithmName: String)
AlgorithmController: +generateRandomPositions()

class GUI
GUI: +updateStartPosition(tile: Tile)
GUI: +updateEndPosition(tile: Tile)
GUI: +updateHistory(history: ArrayList<Tile[]>)
GUI: +updateEnabledAlgorithms(enabledAlgorithms: Map<String,Boolen>)
GUI: +refreshGrid(grid:Grid)
GUI: +updateAlgoStats(stats: ArrayList<AlgorithmStats>)

AlgorithmController *-- "1..1" Grid
Grid *-- "1..*" GridTile
GridTile --|> Tile : Inhertance
GridTile o-- "1.1" Color

 
AlgorithmController *-- "1.*" Algorithm
Algorithm ..> Path
Path o-- "2..*" Tile
AlgorithmController ..> GUI
AlgorithmController *-- "1.*" AlgorithmStats
```

### Sequence Diagrams

#### Path found
```mermaid
sequenceDiagram
participant User
participant GUI
participant AlgorithmController
participant Algorithm

Note over User: Enter start position
activate User
User  ->>+ AlgorithmController : setStartPosition
activate GUI
AlgorithmController ->>- GUI : updateStartPosition
deactivate GUI
Note over User: Enter end position


User ->>+ AlgorithmController : setEndPosition
activate GUI
AlgorithmController ->>- GUI : updateEndPosition
deactivate GUI
Note over User: Click run button

User ->>+ AlgorithmController : runSimulation 
AlgorithmController ->> Algorithm  : computeOptimalPath
activate Algorithm
deactivate Algorithm
AlgorithmController ->> Algorithm  : getVisitedTiles
activate Algorithm
deactivate Algorithm
AlgorithmController ->> Grid : updateGrid
activate Grid
deactivate Grid
AlgorithmController ->> GUI : refreshGrid
activate GUI
deactivate GUI
AlgorithmController ->>- GUI : updateAlgoStats
activate GUI
deactivate GUI
Note over User: The stats will now be visible to see if path was found
deactivate User

```

#### Computer generated path found
```mermaid
sequenceDiagram
participant User
participant GUI
participant AlgorithmController

Note over User: Generate Random start & end positions clicked
activate User
User  ->>+ AlgorithmController : generateRandomPositions

AlgorithmController ->> GUI : updateStartPosition
activate GUI
deactivate GUI

AlgorithmController ->>- GUI : updateEndStartPosition
activate GUI
deactivate GUI
Note over User: Click run button

User ->>+ AlgorithmController : runSimulation 
AlgorithmController ->> Algorithm  : computeOptimalPath
activate Algorithm
deactivate Algorithm
AlgorithmController ->> Algorithm  : getVisitedTiles
activate Algorithm
deactivate Algorithm
AlgorithmController ->> Grid : updateGrid
activate Grid
deactivate Grid
AlgorithmController ->> GUI : refreshGrid
activate GUI
deactivate GUI
AlgorithmController ->>- GUI : updateAlgoStats
activate GUI
deactivate GUI
Note over User: The stats will now be visible to see if path was found
deactivate User

```
#### Selecting different Algorithm
```mermaid
sequenceDiagram
participant User
participant GUI
participant AlgorithmController

Note over User: selects a new algorithm
activate User
User  ->>+ AlgorithmController : setAlgorithmEnabled
activate GUI
AlgorithmController ->>- GUI : updateEnabledAlgorithms
deactivate GUI
deactivate User

```
#### Compare algorithms
```mermaid
sequenceDiagram
participant User
participant GUI
participant AlgorithmController
participant Algorithm

Note over User: Enter start position
activate User
User  ->>+ AlgorithmController : setStartPosition
activate GUI
AlgorithmController ->>- GUI : updateStartPosition

Note over User: Enter end position
deactivate GUI

User ->>+ AlgorithmController : setEndPosition
activate GUI
AlgorithmController ->>- GUI : updateEndPosition

Note over User: Click run button
deactivate GUI
User ->>+ AlgorithmController : runSimulation 
AlgorithmController ->> Algorithm  : computeOptimalPath
activate Algorithm
deactivate Algorithm
AlgorithmController ->> Algorithm  : getVisitedTiles
activate Algorithm
deactivate Algorithm
AlgorithmController ->> Grid : updateGrid
activate Grid
deactivate Grid
AlgorithmController ->> GUI : refreshGrid
activate GUI
deactivate GUI
AlgorithmController ->>- GUI : updateAlgoStats
activate GUI
deactivate GUI
Note over User: The stats will now be visible
Note over User: Table will show comparisons between algorithms 
deactivate User

```

### State Diagrams
#### Path Found
```mermaid
stateDiagram
[*] --> Inilization
Inilization --> Ready : Enter Start and End positions
Ready --> Processing : Press compute path
Processing --> Complete : Display results
Complete --> Inilization : Restart
```
#### Computer Generated Path found
```mermaid
stateDiagram
[*] --> Inilization
Inilization --> Ready : Press Generate start/end positions
Ready --> Processing : Press compute path
Processing --> Complete : Display results
Complete --> Inilization : Restart
```

#### Select Different Algorithm
```mermaid
stateDiagram
[*] --> Inilization
Inilization --> Inilization : Select algorithms

```
#### Path not found found
```mermaid
stateDiagram
[*] --> Inilization
Inilization --> Ready : Enter Start and End positions
Ready --> Processing : Press compute path
Processing --> Complete : Display no path found
Complete --> Inilization : Restart
```

# Glossary

- **Path Algorithm** - A set of instructions to iterate over the points to find a way from point A to point B
- **Start, departure point** - the first node in the path
- **End, destination point** - the last node in the path
- **Node, Tile, Point** - Each term here represents an coordinate in a 2 dimensional graph. They will be used in a group to represent a path
- **Path** - a group of nodes,tiles,points that make up an array of elements used describe how to get from point A to point B
- **Results** - a comparison between multiple algorithms
- **History** - A list of start and end points that were chosen by the user or generated by the computer

