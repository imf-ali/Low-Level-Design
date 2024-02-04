package org.lld.model;

import lombok.Getter;
import org.lld.interfaces.ISubscriber;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class TopicSubscriber {
  private final AtomicInteger offset;
  private final ISubscriber subscriber;

  public TopicSubscriber(ISubscriber subscriber) {
    this.subscriber = subscriber;
    this.offset = new AtomicInteger(0);
  }
}
