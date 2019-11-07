function createService() {
  oc new-app -f ./postgres-full.json \
    -p "APP_NAME=${APP}" \
    -p "DATABASE_SERVICE_NAME=${DB_SERVICE}" \
    -p "POSTGRESQL_USER=${USER}" \
    -p "POSTGRESQL_PASSWORD=${PWD}" \
    -p "POSTGRESQL_DATABASE=${DB_NAME}" \
    -p "VOLUME_CAPACITY=${VOL_LIM}" \
    -p "POSTGRESQL_VERSION=${VERSION}"
} # createService

function deleteService() {
  oc delete all -l app=${APP}
  oc delete pvc/${DB_SERVICE}
} # deleteService
