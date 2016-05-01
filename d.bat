SET TOMCAT_PATH=C:\apps\apache-tomcat-7.0.50

REM copy classes
cd webapp\inventory\WEB-INF
rd classes /S /Q
md classes
xcopy ..\..\..\classes .\classes /S 

REM create war
cd ..
jar -cvf inventory.war WEB-INF

REM deploy
copy inventory.war %TOMCAT_PATH%\webapps

cd ..\..



