/**
 * Created by zhangtianlong on 19/10/23.
 */
public class ReplaceBlank {

    public static void replaceBlank(char[] array) {
        if (array == null || array.length <= 0) {
            return;
        }
        int originLength = 0;
        int numOfBlank = 0;
        int i = 0;
        while (array[i] != '\0') {
            originLength++;
            if (array[i] == ' ') {
                numOfBlank++;
            }
            i++;
        }
        originLength++; // 最后的 \0
        System.out.println(originLength);
        System.out.println(numOfBlank);
        int newLength = originLength + 2 * numOfBlank;
        if (newLength > array.length) {
            return;
        }
        int indexOfNew = newLength - 1;
        int indexOfOrigin = originLength - 1;
        while (indexOfOrigin >= 0 && indexOfNew > indexOfOrigin) {
            if (array[indexOfOrigin] == ' ') {
                array[indexOfNew--] = '0';
                array[indexOfNew--] = '2';
                array[indexOfNew--] = '%';
            } else {
                array[indexOfNew--] = array[indexOfOrigin];
            }
            --indexOfOrigin;
        }
    }

    public static void main(String[] args) {
        char[] array = {'w','e',' ','h','a','p','p','y',' ','b','o','y','\0',' ',' ',' ',' '};
        for (char c : array) {
            System.out.print(c);
        }
        replaceBlank(array);
        for (char c : array) {
            System.out.print(c);
        }
    }
}
