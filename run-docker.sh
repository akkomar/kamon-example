#! /bin/bash

docker kill kamon-grafana-example
docker rm kamon-grafana-example
truncate ./logs/* --size 0

docker run -d -v $(pwd)/logs:/var/log/supervisor -p 80:80 -p 8125:8125/udp -p 8126:8126 --name kamon-grafana-example akomar/kamon-grafana-example