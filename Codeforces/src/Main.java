import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int []f = new int[n];
        int []f1 = new int [n];
        int []b = new int[m];
        int []a = new int[m];
        boolean flag = false;
        for(int i = 0; i<n; i++) {
            f[i] = sc.nextInt();
            f1[i] = f[i];
        }
        for(int i = 0; i<m; i++)
            b[i] = sc.nextInt();
        if(n!=m){
            System.out.println("Impossible");
            System.exit(0);
        }
        boolean flag1 = true;
        for (int i = 1; i < n; i++) {
            if(f[0]!=f[i]) {
                flag1 = false;
                break;
            }
        }
        if(flag1){
            System.out.println("Ambiguity");
            System.exit(0);
        }
        for (int i = 0; i < n; i++) {
            for (int j = i; j<n; j++){
                if (f1[j]<f1[i]){
                    int g = f1[i];
                    f1[i] = f1[j];
                    f1[j] = g;
                }
            }
        }
        for (int i = 0; i<n; i++){
            if (f1[i]!=i+1){
                System.out.println("Impossible");
                System.exit(0);
            }
        }
        System.out.println("Possible");
        for(int i = 0; i<m; i++) {
            a[i] = b[f[i]-1];
            System.out.print(a[i] + " ");
        }
    }
}