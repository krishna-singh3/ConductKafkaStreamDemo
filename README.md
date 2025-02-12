To publish message on kafka topic use below API from postman:
http://localhost:8080/api/kafka/publish?topic=my-topic&message=HelloKafka1

After sometime, kafka streams will consume it and print it in uppercase.