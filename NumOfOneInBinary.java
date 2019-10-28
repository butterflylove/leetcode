public class NumOfOneInBinary {

    public static int getNumberOfOneInBinary(int n) {
        int count = 0;
        int flag = 1;
        while (flag > 0) {
            if ((n & flag) > 0) {
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }

    public static int get(int n) {
        int count  = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(-11));
        System.out.println(getNumberOfOneInBinary(-11));
        System.out.println(get(-11));
    }
}
