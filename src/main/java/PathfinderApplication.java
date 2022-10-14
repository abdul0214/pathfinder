import org.springframework.web.client.RestTemplate;

public class PathfinderApplication {

    private static final PathFinderService pathFinderService = new PathFinderService();
    private static final String bpmnFileUrl = "https://n35ro2ic4d.execute-api.eu-central-1.amazonaws.com/prod/engine-rest/process-definition/key/invoice/xml";
    public static void main(String[] args) {
        if (args.length != 2){
            throw new IllegalArgumentException("incorrect input");
        }
        else {
            String sourceNodeId = args[0];
            String targetNodeId = args[1];
            RestTemplate restTemplate = new RestTemplate();
            try {
                BpmnFile response = restTemplate.getForObject(bpmnFileUrl, BpmnFile.class);
                System.out.println(pathFinderService.findPath(sourceNodeId, targetNodeId, response.getBpmn20Xml()));
            } catch (Exception clientErrorException) {
                System.out.println("error in fetching file: " + clientErrorException.getMessage());
            }
            System.exit(0);
        }
    }

}
