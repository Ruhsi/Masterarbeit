FROM mcr.microsoft.com/mssql/server:2017-latest
EXPOSE 1433
COPY ./create-db.sql .
USER root
ENV MSSQL_DEVELOPER=sa
ENV MSSQL_SA_PASSWORD=Ruhsi@1234
ENV ACCEPT_EULA=Y
RUN chgrp -R 0 /var/opt && \
    chmod -R g=u /var/opt && \
    chown -R 10001:0 /var/opt && \
    ( /opt/mssql/bin/sqlservr --accept-eula & ) | grep -q "Service Broker manager has started" \
&& /opt/mssql-tools/bin/sqlcmd -S localhost -U sa -P Ruhsi@1234 -d master -i create-db.sql