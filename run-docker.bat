@echo off
setlocal

set COMPOSE_PROJECT_NAME=saas-platform
set SERVER_NAME=redis
set CLIENT_NAME=redisinsight

docker rm -f %CLIENT_NAME%
if errorlevel 1 (
    echo Failed to remove Docker container: %CLIENT_NAME%.
    exit /b 1
)


docker rm -f %SERVER_NAME%
if errorlevel 1 (
    echo Failed to remove Docker container: %SERVER_NAME%.
    exit /b 1
)


docker compose up --build
if errorlevel 1 (
    echo Failed to start Docker containers.
    exit /b 1
)