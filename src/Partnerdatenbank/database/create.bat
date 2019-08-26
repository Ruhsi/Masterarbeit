docker stop partnerdb
docker rm partnerdb
docker build -t partnerdb .
docker run -d -p 1433:1433 --name partnerdb partnerdb
