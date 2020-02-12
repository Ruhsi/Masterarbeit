docker stop docsisdb
docker rm docsisdb
docker build -t docsisdb .
docker run -d -p 1434:1433 --name docsisdb docsisdb
