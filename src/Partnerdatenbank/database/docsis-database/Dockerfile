FROM microsoft/mssql-server-linux
EXPOSE 1433
##COPY ./create-db.sql .
ENV MSSQL_SA_PASSWORD=Ruhsi@1234
ENV ACCEPT_EULA=Y
#RUN ( /opt/mssql/bin/sqlservr --accept-eula & ) | grep -q "Service Broker manager has started" \
#&& /opt/mssql-tools/bin/sqlcmd -S localhost -U sa -P Ruhsi@1234 -d master -i create-db.sql