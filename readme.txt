
docker image build -t kiefinger/msg-api-mp-client:latest .
docker login
docker push kiefinger/msg-api-mp-client:latest

test docker
docker run -it --rm -p 9081:9081 kiefinger/msg-api-mp-client:latest
test
curl localhost:9081/msg-api-mp-demo/System/properties

