package zhulei.AI.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Choice {

    @JsonProperty("index")
    private int index;

    @JsonProperty("finish_reason")
    private String finishReason;

    @JsonProperty("delta")
    private Message delta;
}
