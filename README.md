# spring-boot-localstack
This is the basic setup of a spring boot application which will communicate with localstack.

## What it covers?
1) Starting application using gradle with help of docker-compose
2) Using localstack docker container for replicating aws on local machine. To know more about localstack please refer: https://github.com/localstack/localstack
3) Rest endpoint which will create/list S3 bucket(s) in localstack 

## To start appliation
```sh
./gradlew startApp
```

and once started you will see something like below
```sh
+--------------------------+----------------+----------------+
| Name                     | Container Port | Mapping        |
+--------------------------+----------------+----------------+
| spring-boot-localstack_1 | 8080           | localhost:8090 |
+--------------------------+----------------+----------------+
| localstack               | 4572           | localhost:4572 |
| localstack               | 9000           | localhost:9000 |
+--------------------------+----------------+----------------+

BUILD SUCCESSFUL in 38s
7 actionable tasks: 7 executed
```


## To stop application
```sh
./gradlew stopApp
```

## To create S3 bucket
```sh
URL: localhost:8090/buckets
Method: POST
Payload: {
	"bucketName":"some-bucket2"
}

CURL: curl --header "Content-Type: application/json" --request POST --data '{"bucketName":"some-bucket2"}' localhost:8090/buckets
```

## To list S3 buckets
```sh
URL: localhost:8090/buckets
Method: GET


CURL: curl --header "Content-Type: application/json" --request GET localhost:8090/buckets
```
