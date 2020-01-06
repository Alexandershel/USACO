/*
ID: theycal2
LANG: JAVA
TASK: castle
 */
/* USACO Training
 * The Castle
 * Type: Graph Theory
 * Solution: Brute force it.
 */
import java.io.*;
import java.util.*;
import static java.lang.Math.*;

public class castle 
{
	// declares variables
	static int[][] group;
	static int[][] board;
	static int M, N;
	
	public static void main(String[] args) throws IOException 
	{
		// creates files for input and output
		Scanner in = new Scanner(new File("castle.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("castle.out")));
		
		// initializes and declares variables
		ArrayList<Integer> gcount = new ArrayList<Integer>();
		int g = 0;
		int best = 0;
		int bestAtI = 0;
		int bestAtJ = 0;
		boolean bestDir = false;
		M = in.nextInt();
		N = in.nextInt();
		board = new int[N][M];
		group = new int[N][M];
		for(int i = 0; i < N;i++)
		{
			Arrays.fill(group[i],-1);
			for(int j = 0; j < M; j++)
			{
				board[i][j] = in.nextInt();
			}
		}
		
		// finds the number of rooms
		for(int i = 0; i < N;i++)
		{
			for(int j = 0; j < M;j++)
			{
				if(group[i][j] != -1) continue;
				gcount.add(dfs(i,j,g));
				g++;
			}
		}
		
		// finds the largest room
		int max = 0;
		for(int size:gcount)
		{			
			max = max(size,max);
		}
		
		// finds the largest room created by removing a wall and
		// the single wall that makes that largest room
		for(int j = 0; j < M;j++)		
		{
			for(int i = N-1; i >= 0;i--)
			{
				if(i+1 < N && group[i][j] != group[i+1][j])
				{
					int s = gcount.get(group[i][j])+gcount.get(group[i+1][j]);
					if(s > best)
					{
						best = s;
						bestAtI = i+1;
						bestAtJ = j;
						bestDir = true;
					}
				}
			}
			for(int i = N-1; i >= 0;i--)
			{
				if(j+1 < M && group[i][j] != group[i][j+1])
				{
					int e = gcount.get(group[i][j])+gcount.get(group[i][j+1]);
					if(e > best)
					{
						best = e;
						bestAtI = i;
						bestAtJ = j;
						bestDir = false;
					}
				}
			}
		}
		
		// prints the answer
		out.println(gcount.size());
		out.println(max);
		out.println(best);
		out.println((bestAtI+1)+" "+(bestAtJ+1)+" "+(bestDir?"N":"E"));
		
		// ensures the program closes properly
		out.close();
		System.exit(0);
	}
	
	// traverses the castle
	public static int dfs(int i, int j, int g)
	{
		if(group[i][j] != -1) return 0;
		group[i][j] = g;
		int count = 1;

		if(canN(i,j)) count += dfs(i-1,j,g);
		if(canS(i,j)) count += dfs(i+1,j,g);
		if(canE(i,j)) count += dfs(i,j+1,g);
		if(canW(i,j)) count += dfs(i,j-1,g);

		return count;
	}
	
	// guides the depth-first search
	public static boolean canN(int i, int j)
	{
		if((board[i][j]&2) == 0) return true;
		return false;
	}
	public static boolean canS(int i, int j)
	{
		if((board[i][j]&8) == 0) return true;
		return false;
	}
	public static boolean canW(int i, int j)
	{
		if((board[i][j]&1) == 0) return true;
		return false;
	}
	public static boolean canE(int i, int j)
	{
		if((board[i][j]&4) == 0) return true;
		return false;
	}
}