#!/usr/bin/env bash

project_name="todolist"
active="dev"
port=9090

echo "$(whoami) : $(date +'%Y-%m-%d %H:%M:%S') build: ${project_name}"

if docker stop ${project_name}_${active}; then
  echo "stop ${project_name}_${active}"
fi

#拉取最新代码
/usr/bin/git fetch
/usr/bin/git checkout "$1"
/usr/bin/git pull
echo "commit message : $(/usr/bin/git log --oneline -1 --pretty=%B)"

#重新打包
/usr/bin/mvn -B -f pom.xml clean install -Dmaven.test.skip=true -P ${active}

if docker rm -f ${project_name}_${active}; then
  echo "remove old container : ${project_name}_${active}"
fi

if docker rmi ${project_name}_${active} >/dev/null; then
  echo "remove old image : ${project_name}_${active}"
fi

#if docker build . -t ${project_name}_${active}; then
#  echo "docker build : ${project_name}_${active} successful"
#fi

if docker build -t springio/gs-spring-boot-docker . ${project_name}_${active}; then
  echo "docker build : ${project_name}_${active} successful"
fi

if docker run -it --init -m 512M -v "$PWD"/log:/app/log/ -d -p ${port}:${port} --name "${project_name}_${active}" ${project_name}_${active}; then
  echo "docker run : ${project_name}_${active} successful"
fi
