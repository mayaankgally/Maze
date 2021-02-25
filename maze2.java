public class maze extends mazebase
{
    //private boolean[][] checked;
    // default constructor suffices and is equivalent to
    // public maze() { super(); }

    @Override
    public void digout(int y, int x)
    {
        M[y][x]=1;
        drawblock(y,x); // draw square at cooresponding coord
        //nextframe(10);  // be quick
        // directions s, e, n, w
        int[] DX = {0,1,0,-1};
        int[] DY = {1,0,-1,0};
        // scramble
        for(int i=0;i<3;i++)
            {
                int r = i+(int)(Math.random()*(4-i));
                int tmp = DX[i]; DX[i]=DX[r]; DX[r]=tmp;
                tmp = DY[i]; DY[i]=DY[r]; DY[r]=tmp;                
            }//scramble loop

        for(int dir=0;dir<4;dir++)
            {
               int nx = x+DX[dir]*2, ny = y+DY[dir]*2;
               if (nx>=0&&nx<mwidth&&ny>=0&&ny<mheight&&M[ny][nx]==0)
                   {
                       M[y+DY[dir]][x+DX[dir]]=1;
                       drawblock(y+DY[dir],x+DX[dir]);
                       digout(ny,nx);
                   }
            }
    }//digout

     // sample code that tries to digout one space to the left:
    // if (x-1>=0) digout(y,x-1);
     // sample code that tries to digout TWO space to the right IF it's not
     // already dug out:
     //if (x+2<mwidth && M[y][x+2]==0) // always check for maze boundaries
	 //{
	    // M[y][x+1] = 1;
	    // drawblock(y,x+1);
	     //digout(y,x+2);
	 //}
 //digout

@Override
public void solve()
{
    int x = 1;
    int y = 1;
    //boolean visited[] = visited[n];
    

    // initialize stack
    // add first value to stack

    //while(stack!=empty)

        // pop stack to value
        // mark value
        // find neighbors using loop
            // add to stack
            // recursively run dfs on each neighbor




    while(y!=mheight-2 && x!=mwidth-1)
    {
        /*if(M[y][x] != 0)
        {
            nextframe(40);
            drawblock(x,y);
            drawdot(y,x);
            System.out.println(x);
            System.out.println(y);
        }*/
        for(int i=0; i < M.length; i++)
        {
            if(M[y][x] != 0)
            {
            nextframe(40);
            //drawblock(x,y);
            drawdot(y,x);
            System.out.println(x);
            System.out.println(y);
            }

        }
    }
}

    public static void main(String[] av)
    {
	new maze(); // constructor of superclass will initiate everything
    }

    // other hints:  override customize to change maze parameters:
    @Override
    public void customize()
    {
	// ... can change mwidth, mheight, bw,bh, colors here
    }

}//maze subclass
