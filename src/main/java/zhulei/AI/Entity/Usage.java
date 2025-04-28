package zhulei.AI.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Usage {

    @JsonProperty("prompt_tokens")
    private int promptTokens;

    @JsonProperty("prompt_cache_hit_tokens")
    private int promptCacheHitTokens;

    @JsonProperty("prompt_cache_miss_tokens")
    private int promptCacheMissTokens;

    @JsonProperty("completion_tokens")
    private int completionTokens;

    @JsonProperty("total_tokens")
    private int totalTokens;

    @JsonProperty("completion_tokens_details")
    private CompletionTokensDetails completionTokensDetails;
}
