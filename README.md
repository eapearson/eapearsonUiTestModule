[![Build Status](https://travis-ci.org/eapearson/eapearsonUiTestModule.svg?branch=master)](https://travis-ci.org/eapearson/eapearsonUiTestModule)

# eapearsonUiTestModule
---

Dear Reader,

This was a small weekend project from a couple of years ago, which started as way to test certain characteristics of dynamic service behavior with user interface client code. However, it morphed into an exercise in running a non-supported programming language (Clojure) as a dynamic service.

Dusting off the project ...

## Files Guide

The following directories and files are actively involved in this module:

- clojure: source code
- dist/module: contains all service module assets to be included in the target image
- eapearsonUITestModule.spec
- Dockerfile
- deploy.cfg
- README.md

Generally, the normal sdk development process is ignored. The top level Makefile is not used. Rather, development of the service code is within the clojure directory, where a minimal README.md describes the process. Essentially, the service may be run locally inside the container, or directly on the host. The latter, especially, enabled iterative development in the Clojure manner, with live code recompilation and loading. 

Today, I would strive harder to create that same environment inside of a docker container.

## Notes

### The module contents 

The dist/module directory was (somewhat) carefully crafted to contain the minimal files necessary for the sdk to register and run the service:

- entrypoint.sh and associated scripts (start_server.sh, run_async.sh, run_async_job.sh) - required to invoke the service during container run
- report.json (report.yaml??) - required for registration; this file was simply copied from from a compilation of the original Java stub project.
- server-*.jar - the entire service code contained in an "uberjar".
- Makefile - the make file does very little; just enough to satisfy the way the sdk calls it during service registration

### Tests 

none

