/*
 * Copyright (C) 2015 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.gson.internal.bind;

import java.util.Iterator;

final class SerializedNameValue implements Iterable<String> {
  private final String value;
  private final String[] alternate;

  public SerializedNameValue(String value, String[] alternate) {
    this.value = value;
    this.alternate = alternate;
  }

  public String getDefaultName() {
    return value;
  }

  public String get(int i) {
    if (i == 0) return value;
    return alternate[i-1];
  }

  public int size() {
    return alternate == null ? 1 : 1 + alternate.length;
  }

  public Iterator<String> iterator() {
    final int size = size();
    return new Iterator<String>() {
      int i = 0;
      public boolean hasNext() {
        return i < size;
      }
      public String next() {
        return get(i++);
      }
      public void remove() {
        throw new UnsupportedOperationException("remove");
      }
    };
  }
}
