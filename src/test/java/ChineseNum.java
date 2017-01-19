import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

/**
 * Created by Administrator on 2017/1/19.
 */
public class ChineseNum {

    public static final String[] numChinese = {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};
    public static final String[] unitChinese = {"元", "拾", "佰", "仟", "万", "亿"};

    public static void main(String[] args) {
        Random rand = new Random(25);
        System.out.println(getChineseNum(new BigDecimal(rand.nextInt(100000000))));
    }

    public static String getChineseNum(BigDecimal num) {
        String numString = num.toString();
//        String[] parts = numString.split(".");
        StringBuilder sb = new StringBuilder();
        int pow = 0;
//        getIntString(new BigDecimal(parts[0]), sb, pow);
//        if (parts.length > 1) {
//
//        } else {
//
//        }
        getIntString(num, sb, pow);
        return sb.toString();
    }

    private static void getIntString(BigDecimal bigDecimal, StringBuilder sb, int pow) {
        BigDecimal temp = bigDecimal.divide(new BigDecimal(10000)).setScale(0, BigDecimal.ROUND_DOWN);
        if (temp.compareTo(new BigDecimal(0)) > 0) {
            pow++;
            getIntString(temp, sb, pow);
        } else {
            int value = bigDecimal.intValue();
            int intTh = value / 1000 % 10;
            int intH = value / 100 % 10;
            int intT = value / 10 % 10;
            int intLast = value % 10;
            boolean first = sb.length() == 0;
            if (!first && pow != 0 && value == 0) {
                return;
            }
            if (pow == 0) {
                if (value != 0) {
                    if (intTh != 0) {
                        sb.append(numChinese[intTh]).append(unitChinese[3]);
                    }
                    if (intH != 0) {
                        sb.append(numChinese[intH]).append(unitChinese[2]);
                    }
                    if (intT != 0) {
                        sb.append(numChinese[intT]).append(unitChinese[1]);
                    }
                    if (intLast != 0) {
                        sb.append(numChinese[intLast]).append(unitChinese[0]);
                    }
                } else {
                    sb.append("零元");
                }
                return;
            }

            if (first && pow > 0) {
                if (intTh != 0) {
                    sb.append(numChinese[intTh]).append(unitChinese[3]);
                }
                if (intH != 0) {
                    sb.append(numChinese[intH]).append(unitChinese[2]);
                }
                if (intT != 0 && sb.length()>0 && intH == 0) {
                    sb.append("零").append(numChinese[intT]).append(unitChinese[1]);
                } else if (intT != 0) {
                    sb.append(numChinese[intT]).append(unitChinese[1]);
                }
                if (intLast != 0 && sb.length()>0 && intT == 0) {
                    sb.append("零").append(numChinese[intLast]).append(unitChinese[0]);
                }else if (intLast != 0) {
                    sb.append(numChinese[intLast]).append(unitChinese[0]);
                }
                sb.append(unitChinese[1 + (pow * 4 - 1)]);
                return;
            }

            if (intTh != 0) {
                sb.append(numChinese[intTh]).append(unitChinese[3]);
            }
            if (intH != 0 && intTh == 0) {
                sb.append("零").append(numChinese[intH]).append(unitChinese[2]);
            } else if (intH != 0) {
                sb.append(numChinese[intH]).append(unitChinese[2]);
            }
            if (intT != 0 && intH == 0 && intTh == 0) {
                sb.append("零").append(numChinese[intT]).append(unitChinese[1]);
            } else if (intT != 0) {
                sb.append(numChinese[intT]).append(unitChinese[1]);
            }
            if (intLast != 0 && intT == 0 && intH == 0 && intTh == 0) {
                sb.append("零").append(numChinese[intLast]).append(unitChinese[0]);
            } else if (intLast != 0) {
                sb.append(numChinese[intLast]).append(unitChinese[0]);
            }
            sb.append(unitChinese[1 + (pow * 4 - 1)]);
        }
    }
}
