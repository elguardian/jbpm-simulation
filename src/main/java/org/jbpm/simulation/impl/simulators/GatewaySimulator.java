package org.jbpm.simulation.impl.simulators;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.drools.definition.process.Node;
import org.drools.runtime.process.NodeInstance;
import org.drools.runtime.process.ProcessInstance;
import org.jbpm.simulation.ActivitySimulator;
import org.jbpm.simulation.SimulationContext;
import org.jbpm.simulation.SimulationEvent;
import org.jbpm.simulation.impl.events.GatewaySimulationEvent;


public class GatewaySimulator implements ActivitySimulator {

    public SimulationEvent simulate(Object activity, SimulationContext context) {
        NodeInstance gateway = (NodeInstance) activity;
        long startTime = context.getClock().getCurrentTime();
        Map<String, Object> metadata = gateway.getNode().getMetaData();
        
        ProcessInstance pi = gateway.getProcessInstance();
        Node node = gateway.getNode();
        String bpmn2NodeId = (String) metadata.get("UniqueId");
        // todo
        long duration = 0;
        
        long endTime = startTime + duration;

        context.getClock().advanceTime(duration, TimeUnit.MILLISECONDS);
        return new GatewaySimulationEvent(pi.getProcessId(), pi.getId(), startTime, endTime, bpmn2NodeId, node.getName());
    }
    
}