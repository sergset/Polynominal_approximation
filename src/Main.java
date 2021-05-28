import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;




public class Main {
    public static float[][] transpose(float[][] a) {
        int tmp = a.length;
        float[][] b = new float[tmp][tmp];
        for (int i = 0; i < tmp; i++){
            for (int j = 0; j < tmp; j++){
                b[j][i] = a[i][j];
            }
        }
        return b;
    }
    public static float[][] multiply(float[][] a, float[] x) {
        int tmp = a.length;
        float[][] y = new float[tmp][tmp];
        for (int i = 0; i < tmp; i++)
            for (int j = 0; j < tmp; j++)
                y[i][j] = a[i][j] * x[j];
        return y;
    }

    public static String printFunction(float[] result) {
        String wynik = "y=";
        for (int i = result.length - 1; i >= 0; --i) {
            float a = result[i];
            a *= 1000;
            a = Math.round(a);
            a /= 1000;
            if (i == 0) {
                if (a < 0) {
                    wynik += " " + a;
                } else
                    wynik += "+" + a;
            } else if (i == 1) {
                if (a < 0) {
                    wynik += " " + a + "x ";
                } else {
                    if (i == result.length - 1)
                        wynik +=  a + "x ";
                    else wynik += " +" + a + "x ";
                }
            } else {
                if (a < 0) {
                    wynik += " " + a + "x^" + i;
                } else {
                    if (i == result.length - 1) wynik += " " + a + "x^" + i;
                    else
                        wynik += " +" + a + "x^" + i;
                }
            }
        }
        return wynik;
    }
    public static float[] multiply2(float[][] a, float[] x) {
        int m = a.length;
        int n = a[0].length;
        if (x.length != n) throw new RuntimeException("Illegal matrix dimensions.");
        float[] y = new float[m];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                y[i] += a[i][j] * x[j];
        return y;
    }

    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\User\\IdeaProjects\\Polynominal approximation\\test3.txt");
        Scanner sc = new Scanner(file);

        BufferedReader buffer = new BufferedReader(
                new InputStreamReader(System.in));
        //System.out.print("Podaj wartość x: ");
        //int polynominalDegree = Integer.parseInt(buffer.readLine());

        int n = 5;
        int tmp = 0;
        int tmp2 = 0;
        float values[] = new float[n];
        float matrix[][] = new float[n][n];
        while (sc.hasNext()) {
            matrix[tmp][1]  = Float.parseFloat(sc.next());
            tmp++;
            if (tmp>=n) {
                break;
            }
        }

        while (sc.hasNext()) {
                values[tmp2]= Float.parseFloat(sc.next());
                tmp2++;
        }
        sc.close();
            for (int i=0; i<tmp; i++) {
                for (int j=0; j<tmp; j++) {
                    matrix[i][j]= (float) Math.pow(matrix[i][1],j);
        }
    }
        float[][] tmpmatrix = new float[n][n] ;
        tmpmatrix=transpose(matrix);

        float[][] tmpmatrix2 = new float[n][n];
        tmpmatrix2=multiply(tmpmatrix,values);

        float[][] sumS = new float[n][n];
        for (int i=0; i<tmp; i++)
        {
            for (int j=0; j<tmp; j++)
            {
                sumS[i][0]+=tmpmatrix[i][j];
            }
        }
        for (int j=0; j<tmp-1; j++)
        {
            for (int i=0; i<tmp; i++)
            {
                if (i-1>=0)
                    sumS[i-1][j+1]=sumS[i][j];
            }
        }

        Scanner giveM = new Scanner(System.in);
        System.out.println("Enter the degree of the polynomial: ");
        int m = giveM.nextInt();
        m=m+1;
        float [][] sumS2 = new float[m][m];
        for (int i=0; i<m; i++)
        {
            for (int j=0; j<m; j++)
            {
                sumS2[i][j]=sumS[i][j];
            }
        }
        sumS2=invert(sumS2);

        float[] sumT = new float[n];
        float[] sumT2 = new float[m];

        for (int i=0; i<tmp; i++)
        {
            for (int j=0; j<tmp; j++)
            {
                sumT[i]+=tmpmatrix2[i][j];
            }
        }
        for(int i=0; i<m; i++)
        {
            sumT2[i]=sumT[i];
        }
        float[] result = new float[m];
        result=multiply2(sumS2,sumT2);
        System.out.println(printFunction(result));
    }
}
