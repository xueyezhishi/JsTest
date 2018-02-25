package com.itextpdf.text.pdf;

import java.util.ArrayList;
import java.util.List;

/**
 * 不能放在行首的中文标点
 * @author Administrator
 *
 */
public class ChineseSymbolSplit {
public static List<Character> chSymSplits;

static {
chSymSplits  = new ArrayList<Character>();
/**  无法放开头的全角标点  ***/
chSymSplits.add('，');
chSymSplits.add('。');
chSymSplits.add('！');
chSymSplits.add('；');
chSymSplits.add('？');
chSymSplits.add('、');
chSymSplits.add('）');
chSymSplits.add('】');
chSymSplits.add('}');
chSymSplits.add('”');
chSymSplits.add('’');
chSymSplits.add('：');
chSymSplits.add('》');

/**  添加你所需的标点  ***/
chSymSplits.add(',');
chSymSplits.add('.');
chSymSplits.add('!');
chSymSplits.add(';');
chSymSplits.add('?');
chSymSplits.add(')');
chSymSplits.add(']');
chSymSplits.add('}');
chSymSplits.add(':');
chSymSplits.add('>');
}

public static boolean isIncludeChar(int srcChar) {
for (int i = 0; i < chSymSplits.size(); i++) {
if (chSymSplits.get(i) == srcChar) {
return true;
}
}
return false;
}

}