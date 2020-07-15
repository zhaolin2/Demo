/*
 * The MIT License
 * Copyright © 2014-2019 Ilkka Seppälä
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.javase.designPattern.adapter;

import lombok.var;

/**
 * 适配器可帮助两个不兼容的接口一起工作。这是适配器的真实定义*。接口可能不兼容，但内部功能应适合需要。
 * 适配器设计模式通过将一个类的接口转换为客户端期望的接口，从而使其他不兼容的类可以一起工作。
 *
 * 在本例中
 * 船长本来只能划船
 * 但是有了适配器  它也可以操作渔船
 * 具体实现，渔船也实现划船接口 然后在划船接口中调用渔船的具体实现
 */
public final class App {

  private App() {
  }

  public static void main(final String[] args) {
    // The captain can only operate rowing boats but with adapter he is able to
    // use fishing boats as well
    var captain = new Captain(new FishingBoatAdapter());
    captain.row();
  }
}
