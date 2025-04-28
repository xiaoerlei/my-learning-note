package zhulei.AI.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
public class DSRequestBody {

    @JsonProperty(value = "model")
    private String model;

    @JsonProperty(value = "messages")
    private List<Message> messages;

    @JsonProperty(value = "response_format")
    private ResponseFormat responseFormat;

    @JsonProperty(value = "stream")
    private boolean stream;

    @JsonProperty(value = "stream_options")
    private StreamOptions streamOptions;

    @JsonProperty(value = "temperature")
    private float temperature;

    @JsonProperty(value = "top_p")
    private float topP;

    @JsonProperty(value = "frequency_penalty")
    private float frequencyPenalty;

    @JsonProperty(value = "max_tokens")
    private int maxTokens;
}
