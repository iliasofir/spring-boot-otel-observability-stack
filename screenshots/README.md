# Screenshots

Add your observability screenshots here:

1. **metrics.png** - Prometheus metrics dashboard showing HTTP request rates, latency percentiles, and JVM metrics
2. **traces.png** - Tempo distributed traces showing end-to-end service call hierarchy
3. **logs.png** - Loki log explorer with structured logs and trace correlation
4. **slo.png** - Grafana SLO dashboard tracking success rate and P95 latency targets
5. **Architecture.png** - System architecture diagram showing data flow

## How to Capture Screenshots

### Metrics (Prometheus)

1. Open http://localhost:9090
2. Run queries from the README
3. Capture the graph view

### Traces (Grafana + Tempo)

1. Open http://localhost:3000
2. Navigate to Explore → Tempo
3. Search for traces from `spring-otel-observability-lab`
4. Open a trace to show the span timeline
5. Capture the detailed trace view

### Logs (Grafana + Loki)

1. Open http://localhost:3000
2. Navigate to Explore → Loki
3. Query: `{container="app"}`
4. Show log entries with trace IDs
5. Capture the log explorer view

### SLO Dashboard (Grafana)

1. Import the dashboard from `grafana/dashboards/opentelemetry-observability-lab.json`
2. Generate traffic using the traffic script
3. Capture the SLO panels showing success rate and latency

### Architecture Diagram

1. Create or screenshot the architecture diagram
2. Show: App → Prometheus/Tempo/Loki → Grafana
