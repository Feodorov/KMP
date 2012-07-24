package KMP;

public class KMP {
	public static void main(String[] args) {
	 
		String yourWord = new String("testt");
		char[] t = new String(yourWord).toCharArray();
		char[] p = new StringBuffer(yourWord).reverse().toString().toCharArray();
		
		int[] b = new int[p.length + 1]; //border length of prefix
		int i=0, j=-1;
	    b[i]=j;
	    
	    //Preprocess KMP
	    while (i<p.length)
	    {
	        while (j>=0 && p[i]!=p[j]) j=b[j];
	        i++; j++;
	        b[i]=j;
	    }
		
	    i=0; j=0;

	    while(i < t.length)
	    {
	    	j = 0; //holds the common length of prefix and text from position i
	    	//Search common length in prefix and text from position i
	    	while(j < p.length && i < t.length && (t[i] == p[j]))
	    	{
	    		j++; i++;
	    	}
	    	
	    	if(i == t.length) // i and j points to the next position, so do not substract 1 from length
	    	{
	    		System.out.println("Start index of the overlap is: " + (i - j));
	    		System.out.println("You need to add minimum " + (i - j) + " bytes at the end to make palindrom");
	    		System.out.println("Your palindrom is: " + yourWord +  
	    				new StringBuffer(yourWord.substring(0, i - j)).reverse().toString());
	    		break;
	    	}
	    	
	    	i -= b[j]; //shift back for the border value
	    }
	}
}
