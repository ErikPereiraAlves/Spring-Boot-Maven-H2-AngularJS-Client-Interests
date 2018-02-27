
# Spring Boot micro service with Maven, H2 and AngularJS

  A aplicacao teste foi criada como um micro-servico usando Spring Boot e AngularJS. Eh possivel rodar via IDE (eclipse ou Intellij), clonando-a de meu git hub.


http://localhost:8080/bank/index.html



# Como rodar e testar o micro-servico:

    mvn spring-boot:run

    mvn test


## Via Browser (ou postman)

    3.1 - User(s)


    GET:

       http://localhost:8080/bank/api/v1/users/  (busca todos usuarios)
       http://localhost:8080/bank/api/v1/users/{user_id}   (busca usuario especifico)


    POST:
        http://localhost:8080/bank/api/v1/users/

        example:
             {"userId":1,"userName":"Erik Alves","userLimitCredit":100.00,"userRisk":"B","userInterest":24.475}
    PUT:
        http://localhost:8080/bank/api/v1/users/

        example:   {"userId":1,"userName":"Erik Alves","userLimitCredit":100.00,"userRisk":"B","userInterest":24.475}

    DELETE:
         http://localhost:8080/bank/api/users/{user_id}



    * O calculo dos juros eh gerado pela aplicacao dependendo do tipo de risco do cliente.




