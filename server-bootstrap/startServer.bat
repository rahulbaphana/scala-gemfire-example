@echo off

call setEnv.bat

echo Starting Locator and Server...
call gfsh run --file=serverStart.gf

REM Run the Loader client (LoadRegions) to load the data