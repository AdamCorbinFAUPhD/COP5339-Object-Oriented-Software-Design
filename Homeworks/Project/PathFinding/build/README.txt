# How to build and run project
- Using IntelliJ you can go to AlgorithmController and press the green play button on in the code margins
https://i.imgur.com/lUgKKzD.png
- Building the Jar by using the fatJar target for Gradle: https://i.imgur.com/lyUmb68.png
- From the gradle commandline you can run "gradle :compileJava :classes :fatJar"

# Jar location : build/libs/PathFinding-all-1.0-SNAPSHOT.jar

# How to use
 - Click on New Graph to generate a new graph with new blocking tiles
 - Select which Algorithm you want to use for visual run
 - Click Generate Random path for easy use
 - modify the text coordinates for a new path
 - Change the Algorithm and click Generate Path to see the differences

 - Click Compute Comparison to run simulation. This can take a few seconds(10-20 seconds) to finish.
    - Graph will display the differences between the Algorithms