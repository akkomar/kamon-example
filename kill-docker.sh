#! /bin/bash

docker kill kamon-grafana-example
docker rm kamon-grafana-example
rm -r ./logs