package servletTest;

import makeCardGame230901.cardBundle.TotalCardBase;

public class TEST {
  public static void main(String[] args) {
    TotalCardBase totalCardBase = new TotalCardBase();
    System.out.println(String.valueOf(totalCardBase.totalCard()[0].getVolatility()));
  }

}
