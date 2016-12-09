package pkg25;

public class KeySort
{
	int[] sort;

    public KeySort()
    {
    	sort = new int[2];
    }
    public int[] getCmd(int chr)
    {
    	if(chr == 87 | chr == 65 | chr == 68)
    	{
			if(chr == 87)
				sort[1] = 1;
			if(chr == 65)
				sort[1] = 2;
			if(chr == 68)
				sort[1] = 3;

			sort[0] = 0;
    	}
    	if(chr == 71 | chr == 86 | chr == 78)
    	{
			if(chr == 71)
				sort[1] = 1;
			if(chr == 86)
				sort[1] = 2;
			if(chr == 78)
				sort[1] = 3;

			sort[0] = 1;
    	}
    	if(chr == 80 | chr == 76 | chr == 222)
    	{
			if(chr == 80)
				sort[1] = 1;
			if(chr == 76)
				sort[1] = 2;
			if(chr == 222)
				sort[1] = 3;

			sort[0] = 2;
    	}
    	if(chr == 104 | chr == 100 | chr == 102)
    	{
			if(chr == 104)
				sort[1] = 1;
			if(chr == 100)
				sort[1] = 2;
			if(chr == 102)
				sort[1] = 3;

			sort[0] = 3;
    	}
    	return sort;
    }
}