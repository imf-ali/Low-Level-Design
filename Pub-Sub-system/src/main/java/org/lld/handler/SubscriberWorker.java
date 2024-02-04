package org.lld.handler;

import lombok.NonNull;
import lombok.SneakyThrows;
import org.lld.model.Message;
import org.lld.model.Topic;
import org.lld.model.TopicSubscriber;

public class SubscriberWorker implements Runnable{

  private final Topic topic;
  private final TopicSubscriber topicSubscriber;

  public SubscriberWorker(@NonNull Topic topic, @NonNull TopicSubscriber topicSubscriber) {
    this.topic = topic;
    this.topicSubscriber = topicSubscriber;
  }

  @SneakyThrows
  @Override
  public void run() {
    synchronized (topicSubscriber){
      do {
        int currOffSet = topicSubscriber.getOffset().get();
        if(currOffSet >= topic.getMessages().size()){
          topicSubscriber.wait();
        }
        // publish message and increase offset
        Message message = topic.getMessages().get(currOffSet);
        topicSubscriber.getSubscriber().consume(message);
        topicSubscriber.getOffset().compareAndSet(currOffSet, currOffSet + 1);
      } while (true);
    }
  }

  synchronized public void wakeUpIfNeeded(){
    synchronized (topicSubscriber){
      topicSubscriber.notify();
    }
  }
}
