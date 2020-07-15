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

package com.javase.designPattern.abstractFactory;

import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 抽象工厂模式主要是提供一组组装独立的工厂的方法  没有指明具体的工厂
 * 用户提供枚举类中的其中一个类型，来得到这一整个类型的工厂
 *
 * 本质是工厂接口的实现
 *
 * 在这个例子中 最高层的是工厂接口  每一个工厂接口的实现都是一个实例工厂
 * - king
 * - castle
 *  - army
 *  这三个是最高层的接口，下边会有针对特定工厂的具体实现
 */

@Slf4j
public class App {

  private static final Logger LOGGER = LoggerFactory.getLogger(App.class);


  private King king;
  private Castle castle;
  private Army army;

  /**
   * Creates kingdom.
   */
  public void createKingdom(final KingdomFactory factory) {
    setKing(factory.createKing());
    setCastle(factory.createCastle());
    setArmy(factory.createArmy());
  }

  King getKing(final KingdomFactory factory) {
    return factory.createKing();
  }

  public King getKing() {
    return king;
  }

  private void setKing(final King king) {
    this.king = king;
  }

  Castle getCastle(final KingdomFactory factory) {
    return factory.createCastle();
  }

  public Castle getCastle() {
    return castle;
  }

  private void setCastle(final Castle castle) {
    this.castle = castle;
  }

  Army getArmy(final KingdomFactory factory) {
    return factory.createArmy();
  }

  public Army getArmy() {
    return army;
  }

  private void setArmy(final Army army) {
    this.army = army;
  }

  /**
   * The factory of kingdom factories.
   */
  public static class FactoryMaker {

    /**
     * Enumeration for the different types of Kingdoms.
     */
    public enum KingdomType {
      ELF, ORC
    }

    /**
     * The factory method to create KingdomFactory concrete objects.
     */
    public static KingdomFactory makeFactory(KingdomType type) {
      switch (type) {
        case ELF:
          return new ElfKingdomFactory();
        case ORC:
          return new OrcKingdomFactory();
        default:
          throw new IllegalArgumentException("KingdomType not supported.");
      }
    }
  }

  /**
   * Program entry point.
   *
   * @param args command line args
   */
  public static void main(String[] args) {

    var app = new App();

    log.info("Elf Kingdom");
    app.createKingdom(FactoryMaker.makeFactory(FactoryMaker.KingdomType.ELF));
    log.info(app.getArmy().getDescription());
    LOGGER.info(app.getCastle().getDescription());
    LOGGER.info(app.getKing().getDescription());

    LOGGER.info("Orc Kingdom");
    app.createKingdom(FactoryMaker.makeFactory(FactoryMaker.KingdomType.ORC));
    LOGGER.info(app.getArmy().getDescription());
    LOGGER.info(app.getCastle().getDescription());
    LOGGER.info(app.getKing().getDescription());
  }
}