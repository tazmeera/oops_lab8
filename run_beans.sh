#!/bin/bash
# Compiles everything and runs the bean demos (Q1-Q10) and Q11. Usage: bash run_beans.sh
mkdir -p out && javac -d out src/*.java || exit 1
cd out
for c in Q01_StudentBeanDemo Q02_RectangleBeanDemo Q03_EmployeeBeanDemo Q04_DateBeanDemo Q05_UserBeanDemo \
         Q06_Q07_AccountBeanDemo Q08_IntrospectorDemo Q09_CarBeanDemo Q10_CircleBeanDemo Q11_IpAddress; do
  echo "=============== $c"; java $c
done
