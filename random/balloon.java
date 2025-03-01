/*not corrrect
 * shoot balloon in xy plane vertically, ballons that share same area can be shot by a single arrow. find minimum number of arrows required.
 */
import java.util.*;

public class balloon {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int x1[][]=new int[n][2];
        int flag[]=new int[n];
        int count=0;
        for(int i=0;i<n;i++)
        {
            x1[i][0]=sc.nextInt();
            x1[i][1]=sc.nextInt();
            flag[i]=0;
        }

        Arrays.sort(x1, (a,b) -> Integer.compare(a[0], b[0]));

        for(int[] range: x1)
        {
            System.out.println(Arrays.toString(range));
        }

        for(int i=0;i<n-1;i++)
        {
            if(x1[i][1]>x1[i+1][0] && flag[i+1]==0)
            {
                flag[i+1]=1;
            }
        }
        for(int i=0;i<n;i++)
        {
            if(flag[i]==0)
            count++;
        }
        System.out.println(count);
        sc.close();
    }
}
