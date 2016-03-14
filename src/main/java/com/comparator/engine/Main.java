package com.comparator.engine;

import com.comparator.engine.enumerator.ChangeType;
import com.comparator.engine.logic.JSONCompareInterfaceImpl;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        try {
            String jsonFirst = "{ \"kind\": \"ImageStreamTag\", \"apiVersion\": \"v2\", \"listInSecond\": [{ \"obj1InSec\": { \"obj2InSec\": \"some\" } }],\"listInHereAndThere\":[{\"obj1InSec\":\"some\"},{\"obj2InSec\":\"some\"}], \"listInHereAndThereWithLists\": [{ \"obj1InSec\": { \"obj2InSec\": \"some\" } }], \"metadata\": { \"name\": \"python-docker:2\", \"selfLink\": \"/oapi/v1/namespaces/openshift/imagestreamtags/python-docker:2\", \"resourceVersion\": \"4087160\", \"creationTimestamp\": \"2016-02-15T14:51:14Z\", \"namespace\": \"openshift\" }, \"image\": { \"metadata\": { \"name\": \"sha256:c890f05cf20e62075822dbc3731d971bafcb8d659f6c46f589c4e5ea4cd06e34\", \"uid\": \"4ea26abe-d175-11e5-8c76-4a29253e9062\", \"resourceVersion\": \"3972153\", \"creationTimestamp\": \"2016-02-12T10:42:26Z\" }, \"dockerImageReference\": \"library/python@sha256:c890f05cf20e62075822dbc3731d971bafcb8d659f6c46f589c4e5ea4cd06e34\", \"dockerImageMetadata\": { \"kind\": \"DockerImage\", \"apiVersion\": \"1.0\", \"Id\": \"sha256:c890f05cf20e62075822dbc3731d971bafcb8d659f6c46f589c4e5ea4cd06e34\", \"Parent\": \"bfa7dba54292af840cdb2994af8883d2b5c4610c58ae6c51d5c00b0f1a5f1843\", \"Created\": \"2016-01-26T19:48:30Z\", \"Container\": \"0c9bff18848d83301cca8af39d4f6e6408977824d7304e072f1ae411d339d4a5\", \"ContainerConfig\": { \"Hostname\": \"e06f5a03fe1f\", \"Env\": [\"PATH=/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin\", \"LANG=C.UTF-8\", \"GPG_KEY=C01E1CAD5EA2C4F0B8E3571504C367C218ADD4FF\", \"PYTHON_VERSION=2.7.11\", \"PYTHON_PIP_VERSION=7.1.2\"], \"Cmd\": [\"/bin/sh\", \"-c\", \"#(nop) CMD [\\\"python2\\\"]\"], \"Image\": \"bfa7dba54292af840cdb2994af8883d2b5c4610c58ae6c51d5c00b0f1a5f1843\" }, \"DockerVersion\": \"1.8.3\", \"Config\": { \"Hostname\": \"e06f5a03fe1f\", \"Env\": [\"PATH=/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin\", \"LANG=C.UTF-8\", \"GPG_KEY=C01E1CAD5EA2C4F0B8E3571504C367C218ADD4FF\", \"PYTHON_VERSION=2.7.11\", \"PYTHON_PIP_VERSION=7.1.2\"], \"Cmd\": [\"python2\"], \"Image\": \"bfa7dba54292af840cdb2994af8883d2b5c4610c58ae6c51d5c00b0f1a5f1843\" }, \"Architecture\": \"amd64\" }, \"dockerImageMetadataVersion\": \"1.0\" } }";
            String jsonSecond = "{ \"kind\": \"ImageStreamTag\", \"apiVersion\": \"v1\", \"list\": [{ \"obj1\": { \"obj2\": \"some\" } }], \"listInHereAndThere\": [{ \"obj1InSec\": \"some\" }], \"listInHereAndThereWithLists\": [{ \"obj1InSec\": [{ \"sume\": \"sumeVal\", \"obj\": 12, \"data\": [] }] }], \"metadata\": { \"name\": \"python-docker:2\", \"selfLink\": \"/oapi/v1/namespaces/openshift/imagestreamtags/python-docker:2\", \"resourceVersion\": \"4087160\", \"creationTimestamp\": \"2016-02-15T14:51:14Z\", \"namespace\": \"openshift\" }, \"image\": { \"metadata\": { \"name\": \"sha256:c890f05cf20e62075822dbc3731d971bafcb8d659f6c46f589c4e5ea4cd06e34\", \"uid\": \"4ea26abe-d175-11e5-8c76-4a29253e9062\", \"resourceVersion\": \"3972153\", \"creationTimestamp\": \"2016-02-12T10:42:26Z\" }, \"dockerImageReference\": \"library/python@sha256:c890f05cf20e62075822dbc3731d971bafcb8d659f6c46f589c4e5ea4cd06e34\", \"dockerImageMetadata\": { \"kind\": \"DockerImage\", \"apiVersion\": \"1.0\", \"Id\": \"sha256:c890f05cf20e62075822dbc3731d971bafcb8d659f6c46f589c4e5ea4cd06e34\", \"Parent\": \"bfa7dba54292af840cdb2994af8883d2b5c4610c58ae6c51d5c00b0f1a5f1843\", \"Created\": \"2016-01-26T19:48:30Z\", \"Container\": \"0c9bff18848d83301cca8af39d4f6e6408977824d7304e072f1ae411d339d4a5\", \"ContainerConfig\": { \"Hostname\": \"e06f5a03fe1f\", \"Env\": [\"PATH=/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin\", \"LANG=C.UTF-8\", \"GPG_KEY=C01E1CAD5EA2C4F0B8E3571504C367C218ADD4FF\", \"PYTHON_VERSION=2.7.11\", \"PYTHON_PIP_VERSION=7.1.2\"], \"Cmd\": [\"/bin/sh\", \"-c\", \"#(nop) CMD [\\\"python2\\\"]\"], \"Image\": \"bfa7dba54292af840cdb2994af8883d2b5c4610c58ae6c51d5c00b0f1a5f1843\" }, \"DockerVersion\": \"1.8.3\", \"Config\": { \"Hostname\": \"e06f5a03fe1f\", \"Env\": [\"PATH=/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin\", \"LANG=C.UTF-10\", \"GPG_KEY=C01E1CAD5EA2C4F0B8E3571504C367C218ADD4FF\", \"PYTHON_VERSION=2.7.11\", \"PYTHON_PIP_VERSION=7.1.2\"], \"Cmd\": [\"python2\"], \"Image\": \"bfa7dba54292af840cdb2994af8883d2b5c4610c58ae6c51d5c00b0f1a5f1843\" }, \"Architecture\": \"amd64\" }, \"dockerImageMetadataVersion\": \"1.0\" } }";
//        String jsonFirst = "{\"kind\":\"dupa\"}";
//        String jsonSecond = "{\"kind\":\"dupa\"}";
            JSONCompareInterfaceImpl compareInterface = new JSONCompareInterfaceImpl();


            Map<ChangeType, List<String>> changeTypeListMap = compareInterface.generateMapJSONChangesTypesOnPaths(jsonFirst, jsonSecond);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

