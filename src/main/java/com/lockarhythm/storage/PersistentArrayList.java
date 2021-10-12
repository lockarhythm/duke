package com.lockarhythm.storage;

import java.util.ArrayList;

public class PersistentArrayList<E> extends ArrayList<E> {
  private transient Storage storage;

  public void setStorage(Storage storage) {
    this.storage = storage;
  }

  @Override
  public boolean add(E element) {
    boolean res = super.add(element);
    storage.overwrite(this);
    return res;
  }

  @Override
  public E remove(int index) {
    E e = super.remove(index);
    storage.overwrite(this);
    return e;
  }
}
