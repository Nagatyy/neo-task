#### Neobank Coding Challenge

##### This document outlines the ways you can run this API
#
#### Option 1: Run using mvn
1. Assuming you have mvn installed on your cli, navigate to the root of the project (where this README is located) and run:
```mvn clean install```
2. After the JAR is built, you should see a target directory. Inside that directory, there should be a JAR called neo-task-0.0.1-SNAPSHOT.jar. You can then run it (again from the root of the project) using:
```./mvnw package && java -jar target/neo-task-0.0.1-SNAPSHOT.jar```

#### Option 2: Run by pulling Docker Image
##### Lets say you didnt like option 1. You dont want to install maven because you prefer gradle. Fine. Just pull the docker image and run it.
1. Run the following command to pull the image:
```docker pull nagatyy/neo-task-image```
2. Once the image is pulled, you can run the container with the following command:
```docker run --name neo-task-container -p 8080:8080 -d nagatyy/neo-task-image:latest```

##### You should now be able to checkout all the watches your heart desires.
##### Note: I am  prepopulating the DB tables with the sample data provided in the challenge (see data.sql file) 
##### Note2: API will run on port 8080