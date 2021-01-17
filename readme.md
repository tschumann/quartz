quartz
------

Building
========
```
./gradlew build
```

Running
=======
```
java -jar build/libs/quartz.jar
```

To build without running test run:
```
./gradlew build -x test
```

To upgrade Gradle run:
```
./gradlew wrapper --gradle-version=
```

To upgrade dependencies run:
```
./gradlew build --refresh-dependencies
```
