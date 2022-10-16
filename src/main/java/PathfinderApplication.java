import org.springframework.web.client.RestTemplate;

import java.util.List;

public class PathfinderApplication {

    static final PathFinderService pathFinderService = new PathFinderService();

    static final String bpmnFileUrl = "https://n35ro2ic4d.execute-api.eu-central-1.amazonaws.com" +
            "/prod/engine-rest/process-definition/key/invoice/xml";

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("incorrect input");
            System.exit(-1);
        }
        String sourceNodeId = args[0];
        String targetNodeId = args[1];
        RestTemplate restTemplate = new RestTemplate();
        BpmnFile bpmnFile = null;
        try {
            bpmnFile = restTemplate.getForObject(bpmnFileUrl, BpmnFile.class);
        } catch (Exception exception) {
            System.out.println("error in fetching bpmn file: " + exception.getMessage());
            System.exit(-1);
        }
        List<String> path = pathFinderService.findPath(sourceNodeId, targetNodeId, bpmnFile.getBpmn20Xml());
        if (path == null) {
            System.out.println("no path found");
            System.exit(-1);
        }
        System.out.println(String.format("The path from %s to %s is:", sourceNodeId, targetNodeId) + path);
        System.exit(0);
    }
}