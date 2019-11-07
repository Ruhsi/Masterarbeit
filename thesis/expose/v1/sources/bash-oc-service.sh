function createSecrets() {
  oc create secret generic ${SECRET_SERVIVE} \
    --from-env-file=./config/${STAGE}/config.properties

  oc create secret generic ${SECRET_SERVIVE_KEYCLOAK} \
    --from-file=./config/${STAGE}/keycloak.json
} # createSecrets

function deleteSecrets() {
  oc delete secret/${SECRET_SERVIVE}
  oc delete secret/${SECRET_SERVIVE_KEYCLOAK}
} # deleteSecrets

function scaleUp() {
  oc scale --replicas=1 dc/${SERVICE_NAME}
} # scaleUp

function scaleDown() {
  oc scale --replicas=0 dc/${SERVICE_NAME}
} # scaleDown
