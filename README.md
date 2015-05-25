Start docker container with Grafana/Graphite/Statsd:
    
    https://github.com/kamon-io/docker-grafana-graphite






Graphite can be accessed on port 81, in order to get container's ip, run:

    docker inspect kamon-grafana-dashboard | grep IPAddress
    
    