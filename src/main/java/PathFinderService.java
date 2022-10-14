import org.camunda.bpm.model.bpmn.BpmnModelInstance;
import org.camunda.bpm.model.bpmn.instance.FlowNode;
import org.camunda.bpm.model.bpmn.instance.SequenceFlow;

import java.util.ArrayList;
import java.util.List;

public class PathFinderService {

    public List<String> findPath(String sourceNodeId, String targetNodeId, BpmnModelInstance modelInstance) {
        FlowNode startNode = modelInstance.getModelElementById(sourceNodeId);
        return tracePath(new ArrayList<>(), startNode, targetNodeId);
    }

    public List<String> tracePath(List<String> visitedNodeIds, FlowNode currentNode, String targetNodeId) {
        if (currentNode.getOutgoing() == null) {
            return null;
        }
        visitedNodeIds = new ArrayList<>(visitedNodeIds);
        visitedNodeIds.add(currentNode.getId());
        for (SequenceFlow flow : currentNode.getOutgoing()) {
            if (flow.getTarget().getId().equals(targetNodeId)) {
                return new ArrayList<>() {{
                    add(currentNode.getId());
                    add(targetNodeId);
                }};
            }
            if (visitedNodeIds.contains(flow.getTarget().getId())) {
                continue;
            }

            List<String> childList = tracePath(visitedNodeIds, flow.getTarget(), targetNodeId);
            if (childList != null) {
                childList.add(0, currentNode.getId());
                return childList;
            }
        }
        return null;
    }
}
