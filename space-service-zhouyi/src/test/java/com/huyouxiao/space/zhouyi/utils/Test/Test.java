package com.huyouxiao.space.zhouyi.utils.Test;

import com.huyouxiao.space.common.utils.FileUtils;

import java.util.List;

public class Test {
  public static void main(String args[]) {
    /**
    // U+4E0A,19978,上,
    //U+250AD,151725,𥂭,17
    //U+250AE,151726,𥂮,17
    System.out.println(Character.valueOf('上').hashCode());
    System.out.println(Character.toString((char)0x250D7));


    // this character:
    // http://www.isthisthingon.org/unicode/index.php?page=1F&subpage=4&glyph=1F495
    // using code points here, not U+n notation
    // for equivalence with U+n, below would be 0xnnnn
    int codePoint = 128149;
    // converting to char[] pair
    char[] charPair = Character.toChars(codePoint);
    // and to String, containing the character we want
    String symbol = new String(charPair);
    System.out.println(symbol);

    // we now have str with the desired character as the first item
    // confirm that we indeed have character with code point 128149
    System.out.println("First code point: " + symbol.codePointAt(0));
     **/
    write("kangxi-strokecount.csv");
  }

  // CodePoint,Value,Character,Strokes
  public static void write(String input) {
    List<String> lines = FileUtils.readFileLines(input);
    StringBuffer stringBuffer = new StringBuffer();
    for (String line : lines) {
      System.out.println(line);
      // readFileLines U+49F9,18937,䧹,13
      String[] values = line.split(",");
      stringBuffer.append(values[0]).append(",").append(values[1]).append(",");
      String code =values[1];
      char word = Character.valueOf((char) Integer.valueOf(code.replace("U+", "0x"), 16).intValue());
      stringBuffer.append(Character.toString(word)).append(",").append(values[3]).append('\n');
    }
    String out = "out_" + input;
    System.out.println("output file: " + out);
    FileUtils.writeFile(out, stringBuffer.toString());
  }
}
