# CamundaAssignment
A simple take home assignment from Camunda based on their own BPMN interface


## Running
- To run application through the jar file:
  - make jar file by running  `./gradlew shadowJar` from repo root
  - navigate to jar directory `cd build/libs`
  - run the jar file `java -jar pathfinder-0.0.1-SNAPSHOT-all.jar approveInvoice invoiceProcessed` 
- To run as a gradle application:
  - `gradle bootRun --args="approveInvoice invoiceProcessed" -q`

## Additional Questions

 - How long did it take you to solve the exercise?
   - It took me 3-4 hours to do this assignment
  - What are some edge cases that you might not have considered yet?
    - There may be multiple routes b/w a source and target node that I have not covered.
  - What kind of problems/limitations can you think of in terms of your implementation?
    -  I have not covered the reverse path. i.e. what if source and target nodes are reversed such as `java -jar pathfinder-0.0.1-SNAPSHOT-all.jar invoiceProcessed approveInvoice`
    - No support to present & find alternate paths
    - No support to find/confirm the shortest path 

