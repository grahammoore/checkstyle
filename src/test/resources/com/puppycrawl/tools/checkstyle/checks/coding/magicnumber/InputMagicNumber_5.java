package com.puppycrawl.tools.checkstyle.checks.coding.magicnumber;

/* Config:
 *
 * ignoreNumbers ={-9223372036854775808, -2147483648, -1, 0, 1, 2, -2}
 * tokens = NUM_INT, NUM_LONG
 * ignoreAnnotation =  true
 */

/**
 * Describe class InputMagicNumber
 * @author Rick Giles
 * @version 6-May-2003
 */
public class InputMagicNumber_5 {
    public void magicMethod() {

        final int INT_CONST = 101_000;
        final long LONG_CONST1 = 100_000L;
        final long LONG_CONST2 = 100l;
        final float FLOAT_CONST1 = 1.500_0F;
        final float FLOAT_CONST2 = 1.5f;
        final double DOUBLE_CONST1 = 1.500_0D;
        final double DOUBLE_CONST2 = 1.5d;
        final double DOUBLE_CONST3 = 1.5;


        int int_var1 = 1;
        int int_var2 = (2); // ok
        long long_var1 = 0L;
        long long_var2 = 0l;
        double double_var1 = 0D;
        double double_var2 = 0d;

        int[] int_array = new int[2]; // ok

        int_var1 = 1 + 2; // ok
        int_var1 += 1;
        double_var1 = 1.0 + 2.0; // ok

        for (int i = 0; i < 2; i++); // ok

        if (1 < 2); // ok

        if (1.0 < 2.0); // ok


        int int_magic1 = 3_000; // violation
        double double_magic1 = 1.5_0;
        int int_magic2 = (3 + 4); // violation

        int_array = new int[3]; // violation

        int_magic1 += 3; // violation
        double_magic1 *= 1.5;

        for (int j = 3; j < 5; j += 3) { // violation
            int_magic1++;
        }

        if (int_magic1 < 3) { // violation
            int_magic1 = int_magic1 + 3; // violation
        }


        int octalVar0 = 00;
        int octalVar8 = 010; // violation
        int octalVar9 = 011; // violation

        long longOctalVar8 = 0_10L; // violation
        long longOctalVar9 = 011l; // violation


        int hexVar0 = 0x0;
        int hexVar16 = 0x10; // violation
        int hexVar17 = 0X011;  // violation
        long longHexVar0 = 0x0L;
        long longHexVar16 = 0x10L;  // violation
        long longHexVar17 = 0X11l; // violation
    }
}

interface Blah2_5
{
  int LOW = 5;
  int HIGH = 78;
}

class ArrayMagicTest_5
{
    private static final int[] NONMAGIC = {3};
    private int[] magic = {3}; // violation
    private static final int[][] NONMAGIC2 = {{1}, {2}, {3}};
}

/** test long hex */
class LongHex_5
{
    long l = 0xffffffffL; // violation
}

/** test signed values */
class Signed_5
{
    public static final int CONST_PLUS_THREE = +3;
    public static final int CONST_MINUS_TWO = -2;
    private int mPlusThree = +3; // violation
    private int mMinusTwo = -2; // violation
    private double mPlusDecimal = +3.5;
    private double mMinusDecimal = -2.5;
}

/** test octal and hex negative values */
class NegativeOctalHex_5
{
    private int hexIntMinusOne = 0xffffffff;
    private long hexLongMinusOne = 0xffffffffffffffffL;
    private long hexIntMinValue = 0x80000000;
    private long hexLongMinValue = 0x8000000000000000L;
    private int octalIntMinusOne = 037777777777;
    private long octalLongMinusOne = 01777777777777777777777L;
    private long octalIntMinValue = 020000000000;
    private long octalLongMinValue = 01000000000000000000000L;
}

class Cast_5
{
    public static final int TESTINTVAL = (byte) 0x80;
}

class ComplexAndFlagged_5
{
    public static final java.util.List MYLIST = new java.util.ArrayList()
    {
        public int size()
        {

            return 378; // violation
        }
    };
}

class InputComplexButNotFlagged_5
{

    public final double SpecialSum = 2 + 1e10, SpecialDifference = 4 - java.lang.Math.PI;
    public final Integer DefaultInit = new Integer(27);
    public final int SpecsPerDay = 24 * 60 * 60, SpecialRatio = 4 / 3;
    public final javax.swing.border.Border StdBorder =
        javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3);
}

enum MyEnum2_5
{
    A_2(3),
    B_2(54);

    private MyEnum2_5(int value)
    {

    }
}

class TestHashCodeMethod_5 {

    public int hashCode() {
        return 31; // violation
    }


    public int hashCode(int val) {
        return 42; // violation
    }


    public int hashcode() {
        return 13; // violation
    }

    static {
        int x=21; // violation
    }

    {
        int y=37; // violation
    }

    public TestHashCodeMethod_5() {
        int z=101; // violation
    }

    @InputMagicNumberIntMethodAnnotation(42)
    public void another() {
    }

    @InputMagicNumberIntMethodAnnotation(value=43)
    public void another2() {
    }

    @InputMagicNumberIntMethodAnnotation(-44)
    public void anotherNegative() {
    }

    @InputMagicNumberIntMethodAnnotation(value=-45)
    public void anotherNegative2() {
    }
}

class TestMethodCall_5 {

        public TestMethodCall_5(int x){

    }

        public void method2() {
        final TestMethodCall_5 dummyObject = new TestMethodCall_5(62);
        }
}

class Binary_5 {
    int intValue = 0b101; // violation
    long l = 0b1010000101000101101000010100010110100001010001011010000101000101L; // violation
}
@interface AnnotationWithDefaultValue_5 {
    int value() default 101;
    int[] ar() default {102};
}
class A_5 {
    {
        switch (Blah2_5.LOW) {
        default:
            int b = 122; // violation
        }
    }
}
