package zhulei.AI.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class DSResponseBody {

    @JsonProperty("id")
    private String id;

    @JsonProperty("created")
    private int created;

    @JsonProperty("model")
    private String model;

    @JsonProperty("choices")
    private List<Choice> choices;

    @JsonProperty("system_fingerprint")
    private String systemFingerprint;

    @JsonProperty("object")
    private String object;

    @JsonProperty("usage")
    private Usage usage;
}
