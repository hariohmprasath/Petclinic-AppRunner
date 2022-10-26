mvn clean install -DskipTests
docker build -t myapp .
docker tag myapp:latest 775448517459.dkr.ecr.us-east-1.amazonaws.com/to-delete:latest
docker push 775448517459.dkr.ecr.us-east-1.amazonaws.com/to-delete:latest
