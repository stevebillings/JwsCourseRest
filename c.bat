set JAXB_PATH=.\jaxb-ri-2.2.7\lib
set JAXB_LIB=%JAXB_PATH%\jaxb-api.jar;%JAXB_PATH%\jaxb-core.jar;%JAXB_PATH%\jaxb-impl.jar;%JAXB_PATH%\jaxb-jxc.jar;%JAXB_PATH%\jaxb-xjc.jar

set JAXRS_PATH=.\jaxrs-ri\lib
set JAXRS_API=.\jaxrs-ri\api
set JAXRS_LIB=%JAXRS_PATH%\jersey-server.jar;%JAXRS_PATH%\jersey-common.jar;%JAXRS_PATH%\jersey-container-servlet.jar;%JAXRS_PATH%\jersey-container-servlet-core.jar;%JAXRS_API%\javax.ws.rs-api-2.0.1.jar

REM compile service
javac -classpath %JAXB_LIB%;%JAXRS_LIB%;. -d classes .\src\com\uciext\ws\hw2\util\*.java .\src\com\uciext\ws\hw2\backend\model\*.java .\src\com\uciext\ws\hw2\backend\*.java .\src\com\uciext\ws\hw2\backend\impl\*.java .\src\com\uciext\ws\hw2\service\model\catalog\*.java .\src\com\uciext\ws\hw2\service\model\order\*.java .\src\com\uciext\ws\hw2\service\model\orderconfirm\*.java .\src\com\uciext\ws\hw2\service\*.java .\src\com\uciext\ws\hw2\service\impl\*.java 

REM compile client
REM javac -classpath %JAXB_LIB%;%JAXRS_LIB%;. -d classes .\src\com\uciext\ws\hw2\client\model\catalog\*.java .\src\com\uciext\ws\hw2\client\model\order\*.java .\src\com\uciext\ws\hw2\client\model\orderconfirm\*.java .\src\com\uciext\ws\hw2\client\*.java 