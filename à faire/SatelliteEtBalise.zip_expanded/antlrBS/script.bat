@echo off
set CLASSPATH=lib/antlr-4.9.1-complete.jar;
java org.antlr.v4.Tool -visitor -package BalSat.generated BalSat.g4
pause

move "*.java" "../SatelliteEtBaliseWithDeplacementAsDecorator2/src/BalSat/generated"
del "*.interp"
del "*.tokens" 