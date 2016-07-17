# server

A Clojure library designed to ... well, that part is up to you.

## Usage

Develop using lein ring:

```
% lein ring server-headless
```

Make the server with

```
% lein ring uberjar
```

TODO: copy all assets into the dist directory

- the jar File
- scripts/Makefile
- scripts/run.sh


Make a docker image

```
docker build -t eapearson-ui-test .
```

Run it

```
docker run -rm -d -p 3000:3000 eapearson-ui-test
```


Run it directly:

For server mode:

```
java -jar server-0.1.0-SNAPSHOT-standalone.jar ${PORT}
```

For async mode:

```
java -jar server-0.1.0-SNAPSHOT-standalone.jar in.json out.json token
```

where

- in.json is the input parameters in json format
- out.json is the ouput in json format
- token is the auth token string provided directly

So now, for testing in async mode, we need to do this:

- build the docker container
- create directories with sample input and prepared sample output
- run the dockerized app against each of the test work dirs
- compare the real output to the expected.

```
docker build -t eapearson-ui-test .
docker run --rm eapearson-ui-test -v `pwd`/tests/work1:/kb/module/work async
```




## License

Copyright © 2016 FIXME

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
