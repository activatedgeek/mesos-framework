# Mesos Framework

Building Distributed Schedulers on top of Mesos

## Build

```
$ gradle build shadowJar
```

This will create the executable JAR in `build/libs`.

## Run

### Usage

```
$ java -jar mesos-framework-VERSION-all.jar --help
```

### Start Framework

```
$ java -jar mesos-framework-VERSION-all.jar --zookeeper-url m1.dcos:2181
```

## Documentation

TODO