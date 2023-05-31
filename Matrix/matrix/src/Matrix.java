import java.util.Scanner; // Импорт сканера
public class Matrix //Класс матрица
{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("1 вывод первой матрицы");
        System.out.println("2 вывод второй матрицы");
        System.out.println("3 сложение матрицы");
        System.out.println("4 вычитание матрицы");
        System.out.println("5 умножения матрицы");
        System.out.println("6 вывод главной диагонали");
        System.out.println("7 вывод побочной диагонали");
        System.out.println("8 вывод строки матрицы");
        System.out.println("9 вывод столбца матрицы");
        System.out.print("Введите число:" + " ");
        int num = in.nextInt();


        int [][] twoDimArray1 = {{9,8,7},{6,5,4},{3,2,1}};
        int[][] twoDimArray2 = {{2,2,2},{2,2,2},{2,2,2},{2,2,2}};
        if(num==1){
            System.out.println("матрица 1");
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print(" " + twoDimArray1[i][j] + " ");
                }
                System.out.println();
            }
        }


        if(num==2){
            System.out.println("матрица 2");
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print(" " + twoDimArray2[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }

        if(num==3){
            int[][]twoDimArray3 = new int [twoDimArray1.length][twoDimArray2[0].length];
            for (int i=0; i<twoDimArray3[0].length; i++)
                for (int j=0; j<twoDimArray3.length; j++)
                    for (int k=0; k<twoDimArray1[0].length; k++)
                        twoDimArray3[i][j] = twoDimArray1[i][k] + twoDimArray2[k][j];
            for (int i = 0; i < twoDimArray3.length; i++) {
                for (int j = 0; j < twoDimArray3[0].length; j++) {
                    System.out.print(" " + twoDimArray3[i][j] + " ");
                }
                System.out.println();
            }
        }

        if(num==4){
            int[][]twoDimArray3 = new int [twoDimArray1.length][twoDimArray2[0].length];
            for (int i=0; i<twoDimArray3[0].length; i++)
                for (int j=0; j<twoDimArray3.length; j++)
                    for (int k=0; k<twoDimArray1[0].length; k++)
                        twoDimArray3[i][j] = twoDimArray1[i][k] - twoDimArray2[k][j];
            for (int i = 0; i < twoDimArray3.length; i++) {
                for (int j = 0; j < twoDimArray3[0].length; j++) {
                    System.out.print(" " + twoDimArray3[i][j] + " ");
                }
                System.out.println();
            }
        }



        if(num==5){
            System.out.println("Перемноженная матрица");

            int[][]twoDimArray3 = new int [twoDimArray1.length][twoDimArray2[0].length];
            for (int i=0; i<twoDimArray3[0].length; i++)
                for (int j=0; j<twoDimArray3.length; j++)
                    for (int k=0; k<twoDimArray1[0].length; k++)
                        twoDimArray3[i][j] = twoDimArray3[i][j] + twoDimArray1[i][k] * twoDimArray2[k][j];


            for (int i = 0; i < twoDimArray3.length; i++) {
                for (int j = 0; j < twoDimArray3[0].length; j++) {
                    System.out.print(" " + twoDimArray3[i][j] + " ");
                }
                System.out.println();
            }
        }

        if(num==6){
            System.out.println("Вывод главной диагонали матрицы");
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if(i==j)
                        System.out.print(" " + twoDimArray1[i][j] + " ");
                }
                System.out.println();
            }
        }

        if(num==7){
            System.out.println("Вывод побочной диагонали матрицы");
            for (int i = 2; i >= 0; i--) {
                System.out.print(twoDimArray1[2 - i][i] + " ");
            }
            System.out.println();
        }
        if(num==8){
            System.out.println("Вывод строки");
            System.out.print("Введите номер строки от 1 до 3:"+" ");
            int s = in.nextInt();
            in.close();
            if (s<=3){
                for (int i = 0; i < 3; i++) {
                    System.out.print(twoDimArray1[s-1][i] + " ");
                }}
            else{
                System.out.print("ошибка");}
        }

        if(num==9){
            System.out.println("Вывод столбца");
            System.out.print("Введите номер столбца от 1 до 3:"+" ");
            int s = in.nextInt();
            in.close();
            if (s<=3){
                for (int i = 0; i < 3; i++) {
                    System.out.println(twoDimArray1[i][s-1] + " ");
                }}

            else{
                System.out.print("ошибка");}
        }


        else{
            System.out.println("Ошибка");}
    }

}
