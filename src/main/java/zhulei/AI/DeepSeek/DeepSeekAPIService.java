package zhulei.AI.DeepSeek;

import kotlin.Pair;
import zhulei.AI.Entity.EventInfo;
import zhulei.AI.Entity.Message;

import java.util.List;
import java.util.concurrent.BlockingQueue;

public interface DeepSeekAPIService {

    /**
     * AI 对话
     * @param messages
     * @param eventQueue
     * @return
     */
    Pair<String, String> chat(List<Message> messages, BlockingQueue<EventInfo> eventQueue) throws Exception;
}
