# rchat

rChat is a whatsapp like chat application. Users can register and start adding friends to have conversations. Some of the functionalities involved are one-2-one chat, text oriented chat, (images and files sharing will be added later), searching for registered users, sending contact requests to other users, authorization and authentication.

Messages are sent over Websocket. Initially thought of using long polling but couldn't help myself from trying out new protocol which I am obsessed with btw. Messages are sent over unencrypted websocket. Encryption will be added soon. SockJs was used for fallback options. 

It is a Spring Boot based application and most of the functionalities are exposed via REST apis. Spring security Oauth2 with JWT is used for token bases authentication. Hiberante is as ORM along with JPA for data operations. MySql is used as database(thinking to use MongoDb may be later). 

Spring Websocket is used for bidirectional communication. Spring Websocket comes with SockJs out of the box and STOMP is used for handling messages. 

Maven is used as build tool. 'mvn clean install' can build the project.

#Socket programming
#Spring Boot
#RESTful API's
#Spring security
#Oauth2.0
#JWT  
