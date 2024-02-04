package org.lld.interfaces;

import lombok.NonNull;
import org.lld.handler.TopicHandler;
import org.lld.model.Message;
import org.lld.model.Topic;
import org.lld.model.TopicSubscriber;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Queue {
  private final Map<String, TopicHandler> topicHandlerMap;

  public Queue() {
    this.topicHandlerMap = new HashMap<>();
  }

  public Topic createTopic(@NonNull final String topicName){
    Topic topic = new Topic(topicName, UUID.randomUUID().toString());
    TopicHandler topicHandler = new TopicHandler(topic);
    topicHandlerMap.put(topic.getTopicId(), topicHandler);
    System.out.println("Created topic: " + topic.getTopicName());
    return topic;
  }

  public void subscribe(@NonNull final ISubscriber subscriber, @NonNull final Topic topic){
    topic.addSubscriber( new TopicSubscriber(subscriber));
    System.out.println(subscriber.getId() + " subscribed to the topic " + topic.getTopicName());
  }

  public void publish(@NonNull Topic topic, @NonNull Message message){
    topic.addMessage(message);
    System.out.println("Message added to the queue");
    new Thread(() -> topicHandlerMap.get(topic.getTopicId()).publish()).start();
  }

  public void resetOffset(@NonNull Topic topic, @NonNull ISubscriber subscriber, @NonNull Integer newOffset){
    for (TopicSubscriber topicSubscriber : topic.getSubscribers()){
      if(topicSubscriber.getSubscriber().equals(subscriber)){
        topicSubscriber.getOffset().set(newOffset);
        new Thread(() -> topicHandlerMap.get(topic.getTopicId()).startSubscriberWorker(topicSubscriber)).start();
      }
    }
  }
}
