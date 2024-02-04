package org.lld.model;

import lombok.Getter;
import lombok.NonNull;
import org.lld.interfaces.ISubscriber;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Topic {
  private final String topicName;
  private final String topicId;
  private final List<Message> messages;
  private final List<TopicSubscriber> subscribers;

  public Topic(@NonNull String topicName,@NonNull String topicId) {
    this.topicName = topicName;
    this.topicId = topicId;
    this.messages = new ArrayList<>();
    this.subscribers = new ArrayList<>();
  }

  public synchronized void addMessage(@NonNull final Message message) {
    messages.add(message);
  }

  public void addSubscriber(@NonNull final TopicSubscriber subscriber){
    this.subscribers.add(subscriber);
  }
}
