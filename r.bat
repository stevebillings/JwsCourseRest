set JAXB_PATH=.\jaxb-ri-2.2.7\lib
set JAXB_LIB=%JAXB_PATH%\jaxb-api.jar;%JAXB_PATH%\jaxb-core.jar;%JAXB_PATH%\jaxb-impl.jar;%JAXB_PATH%\jaxb-jxc.jar;%JAXB_PATH%\jaxb-xjc.jar

set JAXRS_PATH=.\jaxrs-ri\lib
set JAXRS_API=.\jaxrs-ri\api
set JAXRS_EXT=.\jaxrs-ri\ext
set JAXRS_LIB=%JAXRS_PATH%\jersey-server.jar;%JAXRS_PATH%\jersey-common.jar;%JAXRS_PATH%\jersey-container-servlet.jar;%JAXRS_PATH%\jersey-container-servlet-core.jar;%JAXRS_API%\javax.ws.rs-api-2.0.1.jar;%JAXRS_PATH%\jersey-client.jar;%JAXRS_PATH%\jersey-media-jaxb.jar;%JAXRS_EXT%\hk2-api-2.4.0-b34.jar;%JAXRS_EXT%\hk2-locator-2.4.0-b34.jar;%JAXRS_EXT%\hk2-utils-2.4.0-b34.jar;%JAXRS_EXT%\jersey-guava-2.22.2.jar;%JAXRS_EXT%\javax.annotation-api-1.2.jar;%JAXRS_EXT%\javax.inject-2.4.0-b34.jar

java -classpath %JAXB_LIB%;%JAXRS_LIB%;.\classes com.uciext.ws.hw2.client.OrderingClient %1
