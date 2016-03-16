package com.comparator.engine;

import com.comparator.engine.enumerator.ChangeType;
import com.comparator.engine.logic.json.impl.JSONCompareAndMapsJobsInterfacesImpl;
import com.comparator.engine.logic.json.impl.JSONDataOperationsImpl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        try {
            String jsonFirst = "{\"kind\":\"Template\",\"kind1\":\"Template\",\"apiVersion\":\"v2\",\"metadata\":{\"name\":\"cakephp-mysql-example\",\"namespace\":\"openshift\",\"selfLink\":\"/oapi/v1/namespaces/openshift/templates/cakephp-mysql-example\",\"uid\":\"d88de388-b9cf-11e5-ae53-fa163ea229fa\",\"creationTimestamp\":\"2016-01-13T08:30:04Z\",\"annotations\":{\"description\":\"An example CakePHP application with a MySQL database\",\"iconClass\":\"icon-php\",\"tags\":\"instant-app,php,cakephp,mysql\"},\"resourceVersion\":\"2044214\"},\"objects\":[{\"kind\":\"Service\",\"apiVersion\":\"v1\",\"metadata\":{\"name\":\"cakephp-mysql-example\",\"annotations\":{\"description\":\"Exposes and load balances the application pods\"}},\"spec\":{\"triggers\":[],\"selector\":{\"name\":\"cakephp-mysql-example\"},\"ports\":[{\"name\":\"web\",\"port\":8080,\"targetPort\":8080}],\"accessModes\":[]}},{\"kind\":\"Route\",\"apiVersion\":\"v1\",\"metadata\":{\"name\":\"cakephp-mysql-example\"},\"spec\":{\"triggers\":[],\"ports\":[],\"host\":\"${APPLICATION_DOMAIN}\",\"accessModes\":[],\"to\":{\"kind\":\"Service\",\"name\":\"cakephp-mysql-example\"}}},{\"kind\":\"ImageStream\",\"apiVersion\":\"v1\",\"metadata\":{\"name\":\"cakephp-mysql-example\",\"annotations\":{\"description\":\"Keeps track of changes in the application image\"}}},{\"kind\":\"BuildConfig\",\"apiVersion\":\"v1\",\"metadata\":{\"name\":\"cakephp-mysql-example\",\"annotations\":{\"description\":\"Defines how to build the application\"}},\"spec\":{\"strategy\":{\"sourceStrategy\":{\"from\":{\"kind\":\"ImageStreamTag\",\"name\":\"php:5.6\",\"namespace\":\"openshift\"}},\"type\":\"Source\"},\"triggers\":[{\"type\":\"ImageChange\"},{\"type\":\"ConfigChange\"},{\"type\":\"GitHub\",\"github\":{\"secret\":\"${GITHUB_WEBHOOK_SECRET}\"}}],\"ports\":[],\"source\":{\"contextDir\":\"${CONTEXT_DIR}\",\"git\":{\"ref\":\"${SOURCE_REPOSITORY_REF}\",\"uri\":\"${SOURCE_REPOSITORY_URL}\"},\"type\":\"Git\"},\"output\":{\"to\":{\"kind\":\"ImageStreamTag\",\"name\":\"cakephp-mysql-example:latest\"}},\"accessModes\":[]}},{\"kind\":\"DeploymentConfig\",\"apiVersion\":\"v1\",\"metadata\":{\"name\":\"cakephp-mysql-example\",\"annotations\":{\"description\":\"Defines how to deploy the application server\"}},\"spec\":{\"strategy\":{\"type\":\"Rolling\",\"recreateParams\":{\"pre\":{\"failurePolicy\":\"Abort\",\"execNewPod\":{\"command\":[\"./migrate-database.sh\"],\"containerName\":\"cakephp-mysql-example\"}}}},\"triggers\":[{\"type\":\"ImageChange\",\"imageChangeParams\":{\"automatic\":true,\"containerNames\":[\"cakephp-mysql-example\"],\"from\":{\"kind\":\"ImageStreamTag\",\"name\":\"cakephp-mysql-example:latest\"}}},{\"type\":\"ConfigChange\"}],\"replicas\":1,\"selector\":{\"name\":\"cakephp-mysql-example\"},\"template\":{\"metadata\":{\"name\":\"cakephp-mysql-example\",\"labels\":{\"name\":\"cakephp-mysql-example\"}},\"spec\":{\"containers\":[{\"name\":\"cakephp-mysql-example\",\"image\":\"cakephp-mysql-example\",\"ports\":[{\"containerPort\":8080}],\"env\":[{\"name\":\"DATABASE_SERVICE_NAME\",\"value\":\"${DATABASE_SERVICE_NAME}\"},{\"name\":\"DATABASE_ENGINE\",\"value\":\"${DATABASE_ENGINE}\"},{\"name\":\"DATABASE_NAME\",\"value\":\"${DATABASE_NAME}\"},{\"name\":\"DATABASE_USER\",\"value\":\"${DATABASE_USER}\"},{\"name\":\"DATABASE_PASSWORD\",\"value\":\"${DATABASE_PASSWORD}\"},{\"name\":\"CAKEPHP_SECRET_TOKEN\",\"value\":\"${CAKEPHP_SECRET_TOKEN}\"},{\"name\":\"CAKEPHP_SECURITY_SALT\",\"value\":\"${CAKEPHP_SECURITY_SALT}\"},{\"name\":\"CAKEPHP_SECURITY_CIPHER_SEED\",\"value\":\"${CAKEPHP_SECURITY_CIPHER_SEED}\"},{\"name\":\"OPCACHE_REVALIDATE_FREQ\",\"value\":\"${OPCACHE_REVALIDATE_FREQ}\"}],\"volumeMounts\":[]}],\"volumes\":[]}},\"ports\":[],\"accessModes\":[]}},{\"kind\":\"Service\",\"apiVersion\":\"v1\",\"metadata\":{\"name\":\"${DATABASE_SERVICE_NAME}\",\"annotations\":{\"description\":\"Exposes the database server\"}},\"spec\":{\"triggers\":[],\"selector\":{\"name\":\"${DATABASE_SERVICE_NAME}\"},\"ports\":[{\"name\":\"mysql\",\"port\":3306,\"targetPort\":3306}],\"accessModes\":[]}},{\"kind\":\"DeploymentConfig\",\"apiVersion\":\"v1\",\"metadata\":{\"name\":\"${DATABASE_SERVICE_NAME}\",\"annotations\":{\"description\":\"Defines how to deploy the database\"}},\"spec\":{\"strategy\":{\"type\":\"Recreate\"},\"triggers\":[{\"type\":\"ImageChange\",\"imageChangeParams\":{\"automatic\":false,\"containerNames\":[\"mysql\"],\"from\":{\"kind\":\"ImageStreamTag\",\"name\":\"mysql:5.6\",\"namespace\":\"openshift\"}}},{\"type\":\"ConfigChange\"}],\"replicas\":1,\"selector\":{\"name\":\"${DATABASE_SERVICE_NAME}\"},\"template\":{\"metadata\":{\"name\":\"${DATABASE_SERVICE_NAME}\",\"labels\":{\"name\":\"${DATABASE_SERVICE_NAME}\"}},\"spec\":{\"containers\":[{\"name\":\"mysql\",\"image\":\"mysql\",\"ports\":[{\"containerPort\":3306}],\"env\":[{\"name\":\"MYSQL_USER\",\"value\":\"${DATABASE_USER}\"},{\"name\":\"MYSQL_PASSWORD\",\"value\":\"${DATABASE_PASSWORD}\"},{\"name\":\"MYSQL_DATABASE\",\"value\":\"${DATABASE_NAME}\"}],\"volumeMounts\":[]}],\"volumes\":[]}},\"ports\":[],\"accessModes\":[]}}],\"parameters\":[{\"name\":\"SOURCE_REPOSITORY_URL\",\"description\":\"The URL of the repository with your application source code\",\"value\":\"https://github.com/openshift/cakephp-ex.git\"},{\"name\":\"SOURCE_REPOSITORY_REF\",\"description\":\"Set this to a branch name, tag or other ref of your repository if you are not using the default branch\"},{\"name\":\"CONTEXT_DIR\",\"description\":\"Set this to the relative path to your project if it is not in the root of your repository\"},{\"name\":\"APPLICATION_DOMAIN\",\"description\":\"The exposed hostname that will route to the CakePHP service, if left blank a value will be defaulted.\",\"from\":\"[a-z]([-a-z0-9]*[a-z0-9])?\"},{\"name\":\"GITHUB_WEBHOOK_SECRET\",\"description\":\"A secret string used to configure the GitHub webhook\",\"generate\":\"expression\",\"from\":\"[a-zA-Z0-9]{40}\"},{\"name\":\"DATABASE_SERVICE_NAME\",\"description\":\"Database service name\",\"value\":\"mysql\"},{\"name\":\"DATABASE_ENGINE\",\"description\":\"Database engine: postgresql, mysql or sqlite (default)\",\"value\":\"mysql\"},{\"name\":\"DATABASE_NAME\",\"description\":\"Database name\",\"value\":\"default\"},{\"name\":\"DATABASE_USER\",\"description\":\"Database user name\",\"value\":\"cakephp\"},{\"name\":\"DATABASE_PASSWORD\",\"description\":\"Database user password\",\"generate\":\"expression\",\"from\":\"[a-zA-Z0-9]{16}\"},{\"name\":\"CAKEPHP_SECRET_TOKEN\",\"description\":\"Set this to a long random string\",\"generate\":\"expression\",\"from\":\"[\\\\w]{50}\"},{\"name\":\"CAKEPHP_SECURITY_SALT\",\"description\":\"Security salt for session hash\",\"generate\":\"expression\",\"from\":\"[a-zA-Z0-9]{40}\"},{\"name\":\"CAKEPHP_SECURITY_CIPHER_SEED\",\"description\":\"Security cipher seed for session hash\",\"generate\":\"expression\",\"from\":\"[0-9]{30}\"},{\"name\":\"OPCACHE_REVALIDATE_FREQ\",\"description\":\"The How often to check script timestamps for updates, in seconds. 0 will result in OPcache checking for updates on every request.\",\"value\":\"2\"}],\"labels\":{\"template\":\"cakephp-mysql-example\"}}";
            String jsonSecond = "\"kind\":\"Template\",\"kind1\":{\"name\":\"Template\"},\"apiVersion\":\"v1\",\"metadata\":{\"name\":\"camunda-basic\",\"namespace\":\"openshift\",\"selfLink\":\"/oapi/v1/namespaces/openshift/templates/camunda-basic\",\"uid\":\"d5413458-c8e1-11e5-9970-fa163ea229fa\",\"creationTimestamp\":\"2016-02-01T12:46:37Z\",\"annotations\":{\"description\":\"Clean distribution of BPM and Middleware\",\"iconClass\":\"icon-mysql-database\",\"tags\":\"instant-app, bpm, camunda\"}},\"objects\":[{\"kind\":\"Service\",\"apiVersion\":\"v1\",\"metadata\":{\"name\":\"${CAMUNDA_SERVICE_NAME}\",\"creationTimestamp\":null},\"spec\":{\"triggers\":[],\"selector\":{\"name\":\"${CAMUNDA_SERVICE_NAME}\"},\"ports\":[{\"name\":\"camunda-tomcat\",\"port\":8080,\"targetPort\":8080,\"protocol\":\"TCP\",\"nodePort\":0},{\"name\":\"camunda-nginx\",\"port\":80,\"targetPort\":8900,\"protocol\":\"TCP\",\"nodePort\":0}],\"accessModes\":[],\"sessionAffinity\":\"ClientIP\",\"type\":\"ClusterIP\"},\"status\":{\"loadBalancer\":{}}},{\"kind\":\"PersistentVolumeClaim\",\"apiVersion\":\"v1\",\"metadata\":{\"name\":\"${CAMUNDA_SERVICE_NAME}\"},\"spec\":{\"triggers\":[],\"ports\":[],\"accessModes\":[\"ReadWriteMany\"],\"resources\":{\"requests\":{\"storage\":\"${STORAGE_SIZE}\"}}}},{\"kind\":\"DeploymentConfig\",\"apiVersion\":\"v1\",\"metadata\":{\"name\":\"${CAMUNDA_SERVICE_NAME}\",\"creationTimestamp\":null},\"spec\":{\"strategy\":{\"type\":\"Recreate\",\"resources\":{}},\"triggers\":[{\"type\":\"ImageChange\",\"imageChangeParams\":{\"automatic\":true,\"containerNames\":[\"camunda\"],\"from\":{\"kind\":\"ImageStreamTag\",\"name\":\"camunda-basic:latest\",\"namespace\":\"openshift\"},\"lastTriggeredImage\":\"\"}},{\"type\":\"ConfigChange\"}],\"replicas\":1,\"selector\":{\"name\":\"${CAMUNDA_SERVICE_NAME}\"},\"template\":{\"metadata\":{\"labels\":{\"name\":\"${CAMUNDA_SERVICE_NAME}\"},\"creationTimestamp\":null},\"spec\":{\"containers\":[{\"name\":\"camunda\",\"image\":\"camunda\",\"ports\":[{\"containerPort\":8080,\"protocol\":\"TCP\"},{\"containerPort\":8900,\"protocol\":\"TCP\"}],\"env\":[{\"name\":\"LC_ALL\",\"value\":\"en_US.UTF-8\"},{\"name\":\"DB_DRIVER\",\"value\":\"com.mysql.jdbc.Driver\"},{\"name\":\"DB_USERNAME\",\"value\":\"${DB_USER}\"},{\"name\":\"DB_PASSWORD\",\"value\":\"${DB_PASSWORD}\"},{\"name\":\"DB_URL\",\"value\":\"jdbc:mysql://${DB_HOST}:${DB_PORT}/${DATABASE}?autoReconnect=true&characterEncoding=UTF-8\"},{\"name\":\"TZ\",\"value\":\"${TIMEZONE}\"},{\"name\":\"LDAP_URL\",\"value\":\"${LDAP_URL}\"},{\"name\":\"LDAP_SEARCHFILTER\",\"value\":\"${LDAP_SEARCHFILTER}\"},{\"name\":\"LDAP_CONNECTIONNAME\",\"value\":\"${LDAP_CONNECTIONNAME}\"},{\"name\":\"LDAP_CONNECTIONPASS\",\"value\":\"${LDAP_CONNECTIONPASS}\"},{\"name\":\"LDAP_BASEDN\",\"value\":\"${LDAP_BASEDN}\"},{\"name\":\"BPM_ADMINNAME\",\"value\":\"${BPM_ADMINNAME}\"},{\"name\":\"TOMCAT_ADMINNAME\",\"value\":\"${TOMCAT_ADMINNAME}\"},{\"name\":\"TOMCAT_ADMINPASSWORD\",\"value\":\"${TOMCAT_ADMINPASSWORD}\"}],\"volumeMounts\":[{\"name\":\"${CAMUNDA_SERVICE_NAME}-data\",\"mountPath\":\"/camunda/webapps\"}],\"imagePullPolicy\":\"IfNotPresent\",\"securityContext\":{\"privileged\":false,\"capabilities\":{}},\"capabilities\":{},\"resources\":{}}],\"volumes\":[{\"name\":\"${CAMUNDA_SERVICE_NAME}-data\",\"persistentVolumeClaim\":{\"claimName\":\"${CAMUNDA_SERVICE_NAME}\"}}],\"restartPolicy\":\"Always\",\"dnsPolicy\":\"ClusterFirst\"}},\"ports\":[],\"accessModes\":[]}}],\"parameters\":[{\"name\":\"TIMEZONE\",\"description\":\"Timezone\",\"value\":\"Europe/Warsaw\"},{\"name\":\"CAMUNDA_SERVICE_NAME\",\"description\":\"Camunda service name\",\"value\":\"camunda\",\"required\":true},{\"name\":\"DB_HOST\",\"description\":\"Host of mysql db\",\"value\":\"mysql\",\"required\":true},{\"name\":\"DB_PORT\",\"description\":\"TCP port of mysql db\",\"value\":\"3306\",\"required\":true},{\"name\":\"DB_USER\",\"description\":\"Username for mysql database\",\"value\":\"camunda\",\"required\":true},{\"name\":\"DB_PASSWORD\",\"description\":\"Password for mysql database\",\"value\":\"camundapass\",\"required\":true},{\"name\":\"DATABASE\",\"description\":\"Database for Camunda\",\"value\":\"camundadb\",\"required\":true},{\"name\":\"LDAP_URL\",\"description\":\"Url for LDAP server\",\"value\":\"ldap://ldap.bpmn4spnt.pl\",\"required\":true},{\"name\":\"LDAP_BASEDN\",\"description\":\"DN Object of LDAP tree\",\"value\":\"o=spnt,dc=spnt,dc=pl\",\"required\":true},{\"name\":\"LDAP_SEARCHFILTER\",\"description\":\"search filter of users\",\"value\":\"(objectclass=c4c-user)\",\"required\":true},{\"name\":\"LDAP_CONNECTIONNAME\",\"description\":\"LDAP manager account\",\"value\":\"cn=camunda,o=spnt,dc=spnt,dc=pl\",\"required\":true},{\"name\":\"LDAP_CONNECTIONPASS\",\"description\":\"LDAP manager account password\",\"value\":\"manager123\",\"required\":true},{\"name\":\"BPM_ADMINNAME\",\"description\":\"Admin name\",\"required\":true},{\"name\":\"TOMCAT_ADMINNAME\",\"description\":\"Tomcat manager admin name\",\"value\":\"manager\",\"required\":true},{\"name\":\"TOMCAT_ADMINPASSWORD\",\"description\":\"Tomcat manager admin password\",\"generate\":\"expression\",\"from\":\"[a-z]{8}\",\"required\":true},{\"name\":\"STORAGE_SIZE\",\"description\":\"Size for a webapps storage\",\"value\":\"2Gi\",\"required\":true}],\"labels\":{\"template\":\"camunda\"}}\n";
//        String jsonFirst = "{\"kind\":\"dupa\"}";
//        String jsonSecond = "{\"kind\":\"dupa\"}";
            JSONCompareAndMapsJobsInterfacesImpl compareInterface = new JSONCompareAndMapsJobsInterfacesImpl();
            JSONDataOperationsImpl jsonDataOperations = new JSONDataOperationsImpl();

            Map<ChangeType, List<String>> changeTypeListMap = compareInterface.generateMapJSONChangesTypesOnPathsAndValues(jsonFirst, jsonSecond);
            Map<String, List<String>> pathOnValuesMap = compareInterface.generateMapPathOnValues(changeTypeListMap.get(ChangeType.EXPECTED));
            Set<String> paths = pathOnValuesMap.keySet();
            Iterator<String> iterator = paths.iterator();
            jsonDataOperations.getRightJSON(iterator.next().split("\\."),jsonFirst);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

