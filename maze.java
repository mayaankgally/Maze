public class maze extends mazebase
{
    // default constructor suffices and is equivalent to
    // public maze() { super(); }

 @Override
 public void digout(int y, int x)   // modify this function
 {
     // The following is a skeleton program that demonstrates the mechanics
     // needed for the completion of the program.

     // We always dig out two spaces at a time: we look two spaces ahead
     // in the direction we're trying to dig out, and if that space has
     // not already been dug out, we dig out that space as well as the
     // intermediate space.  This makes sure that there's always a wall
     // separating adjacent corridors.

     M[y][x] = 1;  // digout maze at coordinate y,x
     drawblock(y,x);  // change graphical display to reflect space dug out
     nextframe(40); // show next animation frame after 40ms delay

     // But the following won't work (but will compile)

     int[] DX = {0,1,0,-1};
     int[] DY = {-1,0,1,0};
     int dir = (int)(Math.random()*4);
     int ny = y+DY[dir]*2;
     int nx = x+DX[dir]*2;
     while (ny>=0 && ny<mheight && nx>=0 && nx<mwidth && M[ny][nx]==0)
     {
         M[y+DY[dir]][x+DX[dir]] = 1;
         drawblock(y+DY[dir],x+DX[dir]);
         digout(ny,nx);
     }
     while (ny>=0 && ny<mheight && nx>=0 && nx<mwidth && M[ny][nx]==0)
     {
         M[y+DY[dir]][x-DX[dir]] = 1;
         drawblock(y+DY[dir],x+DX[dir]);
         digout(ny,nx);
     }
     // sample code that tries to digout one space to the left:
     if (x-1>=0) digout(y,x-1);
     // sample code that tries to digout TWO space to the right IF it's not
     // already dug out:
     if (x+2<mwidth && M[y][x+2]==0) // always check for maze boundaries
	 {
	     M[y][x+1] = 1;
	     drawblock(y,x+1);
	     digout(y,x+2);
	 }
 }//digout

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


