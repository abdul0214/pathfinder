import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Data;
import org.camunda.bpm.model.bpmn.Bpmn;
import org.camunda.bpm.model.bpmn.BpmnModelInstance;

import java.io.ByteArrayInputStream;

@Data
public class BpmnFile {

    private String id;
    private BpmnModelInstance bpmn20Xml;

    @JsonSetter("bpmn20Xml")
    public void setNightData(String value) {
        BpmnModelInstance modelInstance = Bpmn.readModelFromStream(new ByteArrayInputStream(value.getBytes()));
        this.bpmn20Xml = modelInstance;
    }
}
