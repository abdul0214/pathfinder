import org.springframework.web.client.RestTemplate;

import java.util.List;

public class PathfinderApplication {

    static final PathFinderService pathFinderService = new PathFinderService();

    static final String bpmnFileUrl = "https://n35ro2ic4d.execute-api.eu-central-1.amazonaws.com" +
            "/prod/engine-rest/process-definition/key/invoice/xml";

    public static void main(String[] args) {
        if (args.length != 2){
            System.out.println("incorrect input");
            System.exit(-1);
        }
        else {
            String sourceNodeId = args[0];
            String targetNodeId = args[1];
            RestTemplate restTemplate = new RestTemplate();
            try {
                BpmnFile response = restTemplate.getForObject(bpmnFileUrl, BpmnFile.class);
                List<String> path = pathFinderService.findPath(sourceNodeId, targetNodeId, response.getBpmn20Xml());
                if (path == null)
                {
                    System.exit(-1);
                }
                System.out.println("The path from approveInvoice to invoiceProcessed is:" + path);
                System.exit(0);
            } catch (Exception clientErrorException) {
                System.out.println("error in fetching bpmn file: " + clientErrorException.getMessage());
                System.exit(-1);
            }
        }
    }
}