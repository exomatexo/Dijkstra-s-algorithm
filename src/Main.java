import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static int[][] trasposeMatrix(int[][] matrix)
    {
        int m = 6;
        int n = 6;

        int[][] trasposedMatrix = new int[n][m];

        for(int x = 0; x < n; x++)
        {
            for(int y = 0; y < m; y++)
            {
                trasposedMatrix[x][y] = matrix[y][x];
            }
        }

        return trasposedMatrix;
    }
    public static void dikstra(int s, int n, int[][] A, int[] dist, int[] pred) throws FileNotFoundException {
        int [] fin = new int [n];
        int inf =999;
        for (int v=0;v<n;v++){
            dist[v]=inf;
            pred[v]=-1;
            fin[v]=0;
        }
        dist[s-1]=0;
        fin[s-1]=1;
        int last = s-1;
        for (int i =1;i<n-1;i++)
        {
            for (int v = 0; v < n; v++) {
                if ((A[last][v]) < inf && (fin[v] == 0)) {
                    if (dist[last] + A[last][v] < dist[v]) {
                        dist[v] = dist[last] + A[last][v];
                        pred[v] = last;
                    }
                }
            }
            int y = 0, temp = inf;
            for (int u = 0; u < n; u++){
                if ((fin[u]) == 0 && dist[u] < temp)
                {
                    y = u; temp = dist[u];
                }
            }
            if (temp < inf)
            {
                fin[y] = 1; last = y;
            }
        }
        PrintWriter fileout = new PrintWriter ("Out0305.txt");
        fileout.print("Dist[");
        for(int i =0;i<n;i++){
            fileout.print(dist[i]+" ");
        }
        fileout.println("]");
        fileout.print("Pred[");
        for(int i =0;i<n;i++){
            fileout.print(pred[i]+" ");
        }
        fileout.println("]");
        fileout.close();
    }
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("In0305.txt");
        Scanner sc = new Scanner(file);
        int liczba_wierzch  = sc.nextInt();
        int ujscia  = sc.nextInt();
        int dist[] = new int[liczba_wierzch];
        int pred[] = new int[liczba_wierzch];
        int visited[] = new int [liczba_wierzch];
        int tab [][] = new int[liczba_wierzch][ujscia];
        for (int i =0 ; i<liczba_wierzch; i++)
            for (int j = 0; j<liczba_wierzch;j++)
                tab[i][j]=sc.nextInt();
        tab = trasposeMatrix(tab);

        dikstra(liczba_wierzch,ujscia,tab,dist,pred);

    }
}
