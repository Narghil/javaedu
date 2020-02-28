@echo off
cls
"C:\Program Files\Java\jdk-11.0.1\bin\java.exe" -javaagent:D:\Gabor\Prgs\Developers\IntelliJ\lib\idea_rt.jar=55721:D:\Gabor\Prgs\Developers\IntelliJ\bin -Dfile.encoding=UTF-8 -classpath D:\Gabor\LocalProjects\IntelliJ\javaedu\out\production\javaedu ExcerciseProjects.TicTacToe.TicTacToe %1 %2 %3
