# MOI
## How Install MinGW (C++ Compiler)
-	Download The file:
[mingw-get-inst-20110530.exe](www.rose-hulman.edu/class/csse/binaries/MinGW/mingw-get-inst-20110530.exe)
-	Execute the file: mingw-get-inst-20110530.exe
-	Install the application into the directory: C:\MinGW (note, this can be moved to another place)
-	Set the \MinGW\bin\ as environment variable:

Windows 10 and Windows 8
  1.	In Search, search for and then select: System (Control Panel)
  2.	Click the Advanced system settings link.
  3.	Click Environment Variables. In the section System Variables, find the PATH environment variable and select it. Click Edit. If the PATH environment variable does not exist, click New.
  4.	In the Edit System Variable (or New System Variable) window, specify the value of the PATH environment variable. Click OK. Close all remaining windows by clicking OK.
  5.	Reopen Command prompt window, and run the code: 'c++ --version'.
  
-	Also, you can view this tutorial: [install MINGW](https://youtu.be/bhxqI6xmsuA)


## To Use CSharp Compiler
-	To compile C# files this project uses "C:/Windows/Microsoft.NET/Framework64/v4.0.30319/csc.exe " as default windows compiler path, this would be chage in case to use other Operative System  

## To Use Python Compiler
- Unzip the file in the same folder:
```
thirdparty/python/win/python32/Portable_Python_3.2.5.1.zip
```
Now you are able to use Python language with the app.

## To Use Java Compiler
- Install Java jdk 1.8 .

## To execute MOI gradle Project
- Run this command: 
```
gradle clean bootrun
```
## To execute MOI Project from Swagger
- Type this url address:
```
http://localhost:9091/api/v1/swagger-ui.html
```
## To execute MOI whit MySql DataBase
- Install Docker:
```
https://hub.docker.com/editions/community/docker-ce-desktop-windows/
```
- Open CMD console and execute:
```
docker version
```
- Example of expected result:
```
Client: Docker Engine - Community
 Version:           18.09.2
 API version:       1.39
 Go version:        go1.10.8
 Git commit:        6247962
 Built:             Sun Feb 10 04:12:39 2019
 OS/Arch:           darwin/amd64
 Experimental:      false
 ```
- On CMD console execute this command:
```
docker run -d -p 33061:3306 --name moi-mysql -e MYSQL_ROOT_PASSWORD=root mysql:5.7 --character-set-server=utf8mb4 --collation-server=utf8mb4_unicode_ci
```
- Example of expected result:
```
CONTAINER ID        IMAGE               COMMAND                  CREATED             STATUS              PORTS                                NAMES
4c2623959deb        mysql:5.7           "docker-entrypoint.s…"   4 days ago          Up 4 days           33060/tcp, 0.0.0.0:33061->3306/tcp   moi-mysql
```