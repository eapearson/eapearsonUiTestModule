#!/bin/bash

#
# Entry point
# This script is the interface to the world of SDK driven apps
# TODO: could there be a better term for this? The essential nature is not
# SDK as such, but rather the application running conventions.
#

#. /kb/deployment/user-env.sh

# python ./scripts/prepare_deploy_cfg.py ./deploy.cfg ./work/config.properties

# ls ./work

#
# Plase auth token in the environment variable
#
if [ -f ./work/token ] ; then
  export KB_AUTH_TOKEN=$(<./work/token)
fi


# Server Mode:
# In this mode the server is started up and listens for connections
# This is the preferred mode to run tasks which complete in some limited
# amount of time
# TODO: what are the guidelines for this? several minutes? less than an hour?
if [ $# -eq 0 ] ; then
  echo "Running in server mode"
  sh ./start_server.sh

# Test Mode:
elif [ "${1}" = "test" ] ; then
  echo "Run Tests"
  make test

# Job Mode:
# I find the term "async" here, as in many other terms at KBase, to be confusing.
# It is already a common term with specific meaning.
# In this context it means that the calling code treats this like other code
# contexts would treat an asynchronous task -- fire, forget, receive notification
# when it is complete.
# In this context it really means to just run the app, using the conventions
# env variables, input file, and output file.
elif [ "${1}" = "async" ] ; then
  echo "Running in async mode"
  sh ./run_async.sh

# ??
elif [ "${1}" = "init" ] ; then
  echo "Initialize module"

# Simply provide a bash cli into the docker container.
elif [ "${1}" = "bash" ] ; then
  bash

# ??
elif [ "${1}" = "report" ] ; then
  export KB_SDK_COMPILE_REPORT_FILE=./work/compile_report.json
  make compile

# ??
else
  echo Unknown
fi
