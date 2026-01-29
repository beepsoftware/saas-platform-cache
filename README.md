Session demo

This project demonstrates switching HTTP session storage between Redis and an in-memory MapSessionRepository using Spring Profiles.

Running locally (Windows cmd.exe)

1) Build:

mvn -DskipTests package

2) Run with in-memory sessions (default):

set SPRING_PROFILES_ACTIVE=inmemory
java -jar target/sessiondemo-0.0.1-SNAPSHOT.jar

3) Run with Redis-backed sessions (requires Redis running):

set REDIS_PASSWORD=change_me_to_a_strong_password
set SPRING_PROFILES_ACTIVE=redis
java -jar target/sessiondemo-0.0.1-SNAPSHOT.jar

Test endpoints:

- Set a session value:
  http://localhost:8080/set?val=hello
- Get the session value:
  http://localhost:8080/get

Notes
- application.properties sets the default profile to `inmemory` for local development.
- application-redis.properties reads the Redis password from the environment variable `REDIS_PASSWORD`.
- In-memory sessions are JVM-local and not suitable for multi-instance deployments.
- Use Redis (or another distributed session store) for production when running multiple instances.

