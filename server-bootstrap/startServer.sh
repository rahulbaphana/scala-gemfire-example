#!/bin/bash

. ./gf.config

echo "Starting locator and server..."
gfsh run --file=serverStart.gf
gfsh configure pdx --auto-serializable-classes=com\.example\.model\..*

echo "Loading data..."
gfsh run --file=loadData.gf
