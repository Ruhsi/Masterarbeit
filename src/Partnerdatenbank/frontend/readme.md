# Partnerdatenbank Frontend

### User
Username: Ruhsi \
Password: chrisi

### Start local
<code>npm install</code> \
<code>ng serve</code>

### Deploy in OpenShift
<code>npx nodeshift --strictSSL=false 
--dockerImage=nodeshift/ubi8-s2i-web-app 
--imageTag=10.x --build.env OUTPUT_DIR=dist/
      frontend --expose</code>
