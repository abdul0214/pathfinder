# CamundaAssignment
A simple take home assignment from Camunda based on their own BPMN interface


## Running
- To run application through the jar file:
  - make jar file by running  `./gradlew shadowJar` from repo root
  - navigate to jar directory `cd build/libs`
  - run the jar file `java -jar pathfinder-0.0.1-SNAPSHOT-all.jar approveInvoice invoiceProcessed` 
- To run as a gradle application:
  - `gradle bootRun --args="approveInvoice invoiceProcessed" -q`
