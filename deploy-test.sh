#!/usr/bin/env bash


deploySubApp(){
  if sudo docker rm -f $1; then
    echo "remove old container : $1"
  fi

  if sudo docker rmi $1 >/dev/null; then
    echo "remove old image : $1"
  fi

  if sudo docker build --build-arg SOURCE_JAR_FILE=$3/target/$1.jar --build-arg TARGET_JAR_FILE=/$1.jar -f $3/docker/Dockerfile -t $1 .; then
    echo "docker build : $1 successful"
  fi

  if sudo docker run -e "SPRING_PROFILES_ACTIVE=test" --init -m 256M -p $2:$2 -it -d --name "$1" $1; then
    echo "docker run : $1 successful"
  fi
}

check(){
  if [ -z $1 ]; then
    echo "branch must not be empty"
    exit 1
  fi
}

check "$@"

active="test"
project_name="toolbox"
app_gw='toolbox-gw'
app_web='toolbox-web'
app_todolist='todolist'
gw_port=8080
web_port=9999
todolist_port=9090

echo "$(whoami) : $(date +'%Y-%m-%d %H:%M:%S') building: ${project_name}"

if sudo docker stop ${app_gw}; then
  echo "stopped ${app_gw}"
fi

if sudo docker stop ${app_web}; then
  echo "stopped ${app_web}"
fi

if sudo docker stop ${app_todolist}; then
  echo "stopped ${app_todolist}"
fi

#拉取最新代码
git reset --hard HEAD
git fetch
git checkout "$1"
git pull
echo "commit message : $(/usr/bin/git log --oneline -1 --pretty=%B)"

#重新打包
mvn clean install -Dmaven.test.skip=true -P ${active}

deploySubApp ${app_todolist} ${todolist_port} ./todolist
deploySubApp ${app_web} ${web_port} ./toolbox-web
deploySubApp ${app_gw} ${gw_port} ./toolbox-gw

echo "$(whoami) : $(date +'%Y-%m-%d %H:%M:%S') completed: ${project_name}"