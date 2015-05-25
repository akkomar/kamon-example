Start docker container with Grafana/Graphite/Statsd:
    
    https://github.com/kamon-io/docker-grafana-graphite

Grafana can be accessed at:

    http://localhost

Create metrics in Grafana:
 
    stats.timers.example-app.localhost.trace.bigTask-trace.segments.*.elapsed-time.upper_75


Graphite can be accessed on port 81, in order to get container's ip, run:

    docker inspect kamon-grafana-dashboard | grep IPAddress
    

----------------------------------------------------

Build docker image:

    sudo docker build -t akomar/kamon-grafana-example .
    
