#!/bin/bash

mvn wildfly:start &&

mvn package &&

mvn wildfly:deploy