/*not corrrect
 * shoot balloon in xy plane vertically, ballons that share same area can be shot by a single arrow. find minimum number of arrows required.
 */
import java.util.*;

public class balloon {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int x1[]=new int[n];
        int x2[]=new int[n];
        int flag[]=new int[n];
        int count=0;

        for(int i=0;i<n;i++)
        {
            x1[i]=sc.nextInt();
            x2[i]=sc.nextInt();
            flag[i]=0;
        }

        for(int i=1;i<n;i++)
        {
            int k1=x1[i];
            int k2=x2[i];
            int j=i-1;

            while(j>=0 && x1[j]>k1)
            {
                x1[j+1]=x1[j];
                x2[j+1]=x2[j];
                j=j-1;
            } 
            x1[j+1]=k1;
            x2[j+1]=k2;
        }
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                if(x2[i]>=x1[j] && flag[j]==0)
                {
                    flag[j]=1;
                }
            }
        }
        for(int i=0;i<n;i++)
        {
            if(flag[i]==0)
            {
                count++;
            }
        }
        System.out.println(count);
        sc.close();
    }
}
