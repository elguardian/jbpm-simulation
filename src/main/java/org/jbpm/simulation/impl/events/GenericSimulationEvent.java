package org.jbpm.simulation.impl.events;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.jbpm.simulation.SimulationEvent;

public class GenericSimulationEvent implements SimulationEvent {
    
    protected String processId;
    protected long processInstanceId;
    protected Map<String, Object> customMetrics = new ConcurrentHashMap<String, Object>();
    protected long startTime;
    protected long endTime;
    
    
    public long getStartTime() {
        return startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public GenericSimulationEvent(String processId, long processInstanceId, long startTime, long endTime) {
        super();
        this.processId = processId;
        this.processInstanceId = processInstanceId;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    

    public String getProcessId() {
        
        return this.processId;
    }

    public long getProcessInstanceId() {
        return processInstanceId;
    }

    

    public String getMetric(String name) {
        Object metric = this.customMetrics.get(name);
        if (metric != null) {
            return metric.toString();
        }
        return null;
    }
    
    public void addCustomMetric(String name, Object value) {
        this.customMetrics.put(name, value);
    }

    @Override
    public String toString() {
        
        return "GenericSimulationEvent[process=" + processId + ", instance=" + processInstanceId + "]";
    }
    
    

}