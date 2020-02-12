# Functional Specification  - Adam Corbin Spring 2020
## Application Requirements
### Functional Requirements
1. The system shall generate a path given a start point, and end point, and the selected algorithm
2. The system shall let the user know if a path is not possible to be created
3. The system shall have the ability to clear the current paths 
4. The system shall keep track of history of each simulation during a given session
5. The system shall have the ability to select 2 points from the history
6. The system shall provide statistics on the different algorithms
7. The system shall provide the recommended algorithm for the given simulation
8. The system shall find worst case scenario for each algorithm given the scenario

### UI Requirements
1. The UI shall be able to select a starting point and an end point
2. The UI shall have a button to start the simulation
3. The UI shall be able to see the algorithms behave over time where a human can visually see
4. The UI shall be able to see multiple algorithms running at the same time to see the differences
5. The UI shall have the ability to auto pick the 2 points
6. The UI shall have the ability to select which algorithms to use for the simulation
 
## Use Cases
### Path found
1. The user selects the start and end points and uses default algorithm
2. The system will compute the path generation
3. The system will display a successful path
### Path not found
1. After #2 from Path Found, the system will display a path could not be found 

### Computer generated path found
1. The user selects for the system to pick 2 random points on the graph
2. The system picks 2 random points
3. The system will compute the path generation
4. The system will display a successful path

### Computer generated path not found
1. After #3 from Computer generated path found, the system will display a path could not be found

### Selecting different Algorithm
1. The user selects the start and end points
2. The user changes the default algorithm to another selection
3. The system will compute the path generation
4. The system will display the successful path 

### Selecting points from history
1. The user will pick from this history list to switch back to
2. The system will regenerate the path from the history
3. The system will display the generated path 

### Compare algorithms 
1. The user will select all the algorithms to run for the simulation
2. The user will pick the 2 points
3. The system will generate the paths for each algorithm
4. The system will display a ranking order between each algorithm with some statistics.  

