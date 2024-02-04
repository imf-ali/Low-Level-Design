package org.lld.handler;

import lombok.NonNull;
import org.lld.model.Topic;
import org.lld.model.TopicSubscriber;

import java.util.HashMap;
import java.util.Map;

public class TopicHandler {
  private final Topic topic;
  private final Map<String, SubscriberWorker> subscriberWorkers;

  public TopicHandler(@NonNull Topic topic) {
    this.topic = topic;
    subscriberWorkers = new HashMap<>();
  }

  public void publish(){
    for(TopicSubscriber topicSubscriber : topic.getSubscribers()){
      startSubscriberWorker(topicSubscriber);
    }
  }

  public void startSubscriberWorker(@NonNull TopicSubscriber topicSubscriber){
    String subscriberId = topicSubscriber.getSubscriber().getId();
    if(!subscriberWorkers.containsKey(subscriberId)){
      SubscriberWorker subscriberWorker = new SubscriberWorker(topic, topicSubscriber);
      subscriberWorkers.put(subscriberId, subscriberWorker);
      new Thread(subscriberWorker).start();
    }
    SubscriberWorker subscriberWorker = subscriberWorkers.get(subscriberId);
    subscriberWorker.wakeUpIfNeeded();
  }
}
