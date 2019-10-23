/**
 * Created by zhangtianlong on 19/10/23.
 */
public class FindNumInTwoDimensionalArray {

    public static boolean find(int[][] array, int rows, int columns, int num) {
        if (array == null || rows == 0 || columns == 0) {
            return false;
        }
        int row = 0;
        int column = columns - 1;
        while (row < rows && column >= 0) {
            if (array[row][column] == num) {
                return true;
            } else if (array[row][column] > num) {
                column--;
            } else {
                row++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] array = {{1,2,8,9},
                         {2,4,9,12},
                         {4,7,10,13},
                         {6,8,11,15}};
        System.out.println(find(array, 4, 4, 5));
    }
}
