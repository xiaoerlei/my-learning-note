package zhulei.AI.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SteamResponse {

    private String content;

    private String reasoningContent;

    private boolean finished;

    private int created;

    public SteamResponse(boolean finished, int created) {
        this.finished = finished;
        this.created = created;
    }
}
