# rabbittest
rabbitmq test with spring boot



## rabbitmq
rabbitmq가 local에 설치/실행 상태로 진행

rabbitmq docker로 실행 ( docker는 알아서 설치 )

'''
$ docker run --rm -p 5672:5672 -p 15672:15672 --hostname my-rabbit -e RABBITMQ_DEFAULT_USER='trs' -e RABBITMQ_DEFAULT_PASS=anwkddo rabbitmq:3.7.3-management-alpine
'''
