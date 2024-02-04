package org.lld.interfaces;

import org.lld.model.Message;

public interface ISubscriber {
  String getId();
  void consume(Message message) throws InterruptedException;
}
