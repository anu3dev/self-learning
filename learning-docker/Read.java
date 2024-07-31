/*
 * 
 *
 * *****Getting started with docker****************************************************
 * 
 * 
 * If an application or app is running on my system then we can't say it will run on others as well, it may or may not run on others system, 
 * might be due to different OS or missing dependent software or different versions. This is why concept of Virtulazation came into picture.
 * 
 * Installing an guest OS on the top of host OS with the help of virtual machine is called as virtulazition.
 * Example of virtual machines are VmWare, Hypervisor etc.
 * 
 * We can simply provide guest OS in form of image, anyone can import this image in docker and can run as a container.
 * But here isolation problem comes into picture, like we can't run all the apps on one guest OS, to solve this issue, 
 * we can install multiple guest OS on virtual machine and we can run one image per OS as a container.
 * 
 * Saving a running container creates an Image.
 * 
 * But again problem with virtualization is, it takes a lot of CPU resources because we are providing the whole OS as an image to run,
 * and also there is licencing or pricing issue, so to tackle this problem, Docker came into picture.
 * 
 * 
 * *****Docker Basics******************************************************************
 * 
 * 
 * Docker is a platform or set od tools to achieve containerization.
 * 
 * Docker components:
 * Docker engine -> creating and managing the container and using CMD we can intract with docker engine.
 * Image -> Blueprint of container, it is a light weight file which we share so that other can import this image inside docker and
 * run the container.
 * Docker file -> we mention all the settings and configuration shere.
 * Docker hub -> it is kind of docker app store from where we can pull images of softwares like tomcat, mysql etc.
 * 
 * These containers has their default network setting so we don't need to bother about network things like IP, port etc.
 * 
 * 
 * *****Docker Installation************************************************************
 * 
 * 
 * Open CMD and run command docker --version to check if you already have docker installed.
 * If you see error then open https://www.docker.com/products/docker-desktop/ and download it.
 * If you don't want to download and install then you can also used docker labs online.
 * 
 * You can't delete running image directly, you have to first delete the container and then you can delete image.
 * 
 * 
 * *****Docker basic commands *********************************************************
 * 
 * 
 * Basic commads:
 * docker run hello-world or docker run hello-world:latest -> pull an docker image
 * docker ps -> status of all running container
 * docker ps -a -> status of all container
 * docker images -> show list of available images
 * docker help - list of available commands 
 * 
 * 
 * *****Remove a container*************************************************************
 * 
 * 
 * Remove a container:
 * docker ps -a -> to get the container ID
 * docker rm container ID -> container removed
 * 
 * 
 * *****Remove an image***************************************************************
 * 
 * 
 * Remove an image:
 * docker images -> to get the image ID
 * docker rmi image ID -> image removed
 * 
 * 
 * *****Start a container*************************************************************
 * 
 * 
 * To start container:
 * docker search hello-world -> to search an image in docker hub
 * docker pull hello-world -> pull an image
 * docker images -> get image ID
 * docker create image ID / image name -> will create container and provide container ID
 * docker ps -a -> verify the created conatiner
 * docker stop container ID -> to stop a container
 * docker pause container id -> to pause a container
 * 
 * 
 * *****Docker Architecture************************************************************
 * 
 * 
 * When we want to interact with Docker, we actually interact with docker client and docker client interact wit Docker.
 * Similarly Docker connect with Registry to fetch docker images.
 * Docker client and Registry are part of docker installation only.
 * Docker has few more components like volume, network, container, image, Docker Deamon etc.
 * All the process like running container, pulling images is handled by docker deamon only.
 * 
 *  
 * *****Run a JDK application***************************************************************
 * 
 * 
 * docker search openjdk -> search open jdk image in registry
 * docker pull openjdk -> pull open jdk image
 * docker images -> see list of pulled images
 * docker run -it image ID or name -> start an image withinn a container and run in interactive mode
 * docker ps -> list all the running container
 * docker ps -a -> list all the container
 * 
 * create a spring boot sample project and create a jar
 * 
 * docker ps -> to check container is still running or not
 * docker exec container-name ls -a -> executing a command inside container to see the folder list
 * docker exec container-name ls /tmp -> to see what is inside tmp folder
 * docker cp test.jar container-name:/tmp -> to copy te jar
 * docker exec container-name ls /tmp -> reverify whether jar copied or not.
 * docker commit container-name learn-docker-with-spring:v1 -> if you run it, it will by default open jshell due to default command
 * docker commit --change='CMD ["java","-jar","/tmp/test.jar"]' relaxed_edison learn-docker-with-spring:v2 -> create new build with changed cmd
 * docker commit --change='CMD "java" "-jar" "/tmp/test.jar"' relaxed_edison learn-docker-with-spring:v2 -> sometimes above gives error
 * docker run learn-docker-with-spring:v2 -> run image inside a container
 * 
 * now our jar is running at port:8080 but it is on docker container network, not on machine network, lets expose this to main machine.
 * 
 *  docker run -p 8080:8080 learn-docker-with-spring:v2
 *  
 *  
 *  *****Create docker file in spring boot app and automate the process*********************************************
 *  
 *  
 *  create a Dockerfile (Dockerfile - name should eb exact)
 *  docker build -t learn-docker-with-spring:v3 .
 *  docker run -p 8080:8080 learn-docker-with-spring:v3
 *  
 *  
 *  *****Run multiple container**************************************************************************************
 *  
 *  
 *  now lets create one more spring boot app with postgres, data JPA and spring web.
 *  since we want to run two container now, one with normal spring boot app and other with database,
 *  so we will use docker compose now.
 *  
 *  we have to create docker-compose.yml and run  docker compose up --build inside project folder.
 *  Before running the command, create a spring boot jar build and update db and part in application.properties
 *  
 *  
 *  *****Docker Volume***********************************************************************************************
 *  
 *  
 *  Suppose container is running and user saved some data and, if we re-start the container then those will be lost,
 *  to save the running state of container, we create volume and store those on local system.
 *  
 *  after adding volume, stop the container and re-run, data won't be lost.
 */