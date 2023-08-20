package GSAlgorithm;

import java.io.*;
import java.util.*;

class GFG
{
static int N = 4;

static boolean wPrefersM1OverM(int prefer[][], int w,
                               int m, int m1)
{

    for (int i = 0; i < N; i++)
    {
        if (prefer[w][i] == m1)
            return true;

        if (prefer[w][i] == m)
        return false;
    }
    return false;
}
static void stableMarriage(int prefer[][])
{
    int wPartner[] = new int[N];

    boolean mFree[] = new boolean[N];
 
    Arrays.fill(wPartner, -1);
    int freeCount = N;
 
    while (freeCount > 0)
    {
        int m;
        for (m = 0; m < N; m++)
            if (mFree[m] == false)
                break;

        for (int i = 0; i < N &&
                        mFree[m] == false; i++)
        {
            int w = prefer[m][i];

            if (wPartner[w - N] == -1)
            {
                wPartner[w - N] = m;
                mFree[m] = true;
                freeCount--;
            }
 
            else
            {
                int m1 = wPartner[w - N];

                if (wPrefersM1OverM(prefer, w, m, m1) == false)
                {
                    wPartner[w - N] = m;
                    mFree[m] = true;
                    mFree[m1] = false;
                }
            } 
        } 
    } 
 
System.out.println("Woman Man");
for (int i = 0; i < N; i++)
{
    System.out.print(" ");
    System.out.println(i + N + "     " +
                           wPartner[i]);
}
}
 
public static void main(String[] args)throws Exception
{
	String dir = System.getProperty("user.dir");
	File file = new File(dir+"\\src\\GSAlgorithm\\test.txt");
	BufferedReader br = new BufferedReader(new FileReader(file));
	String st;
	N = Integer.parseInt(br.readLine());
	int[][] twodArray = new int[N*2][N];

	int temp_array[] = new int[N*N*2];
	int index = 0;
    while ((st = br.readLine()) != null) {
    	String string_temp[] = st.split("\\s");
        for(int i=0; i<string_temp.length; i++) {
        	temp_array[index] = Integer.parseInt(string_temp[i]);
        	index++;
         }
    }
    index = 0;
		for(int i = 0 ; i < N*2 ; i++){
		for(int j = 0 ; j < N; j++)
		{
			twodArray[i][j] = temp_array[index];
			index++;
		}
	}
    stableMarriage(twodArray);
}
}