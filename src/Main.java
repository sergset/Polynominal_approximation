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
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\User\\IdeaProjects\\Polynominal approximation\\test.txt");
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
        String result = Arrays
                .stream(matrix)
                .map(Arrays::toString)
                .collect(Collectors.joining(System.lineSeparator()));
        System.out.println(result);

        while (sc.hasNext()) {
                values[tmp2]= Float.parseFloat(sc.next());
                tmp2++;
        }
        sc.close();

        float[][] b = new float[tmp][tmp];
    for (int i=0; i<tmp; i++)
    {
        for (int j=0; j<tmp; j++)
        {
                matrix[i][j]= (float) Math.pow(matrix[i][1],j);
        }
    }
    b=transpose(matrix);
        String result2 = Arrays
                .stream(b)
                .map(Arrays::toString)
                .collect(Collectors.joining(System.lineSeparator()));
        System.out.println();
        System.out.println(result2);


  b=multiply(b,values);
        String result3 = Arrays
                .stream(b)
                .map(Arrays::toString)
                .collect(Collectors.joining(System.lineSeparator()));
        System.out.println();
        System.out.println(result3);

     /*       PrintWriter zapis = new PrintWriter("Newton Wynik.txt");
        zapis.println("Wartość w " + df.format(value) + " wynosi " + df.format(applyFormula(value, x, y, n)));
        zapis.println(result2);
        zapis.close();*/
    }
}
