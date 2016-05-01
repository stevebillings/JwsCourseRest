SET TOMCAT_PATH=C:\Apps\apache-tomcat-7.0.42

REM copy classes
cd webapp\inventory\WEB-INF
rd classes /S /Q
md classes
xcopy ..\..\..\classes .\classes /S /Q

REM create war
cd ..
jar -cvf inventory.war WEB-INF

REM deploy
copy inventory.war %TOMCAT_PATH%\webapps

cd ..\..



