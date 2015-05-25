FROM     kamon/grafana_graphite

# Add updated dashboard
RUN     rm src/dashboards/system-metrics.json
ADD     ./grafana/dashboards/* /src/dashboards/

# Run
CMD     ["/usr/bin/supervisord"]