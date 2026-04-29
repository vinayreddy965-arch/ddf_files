package finance.ddf_files;


public class App 
{
    public static void main( String[] args )
    {
    	
    	try 
    	{   
    		int[] array = {1,3,4,5,6};
    		  
    		System.out.println(array.length);
    		System.out.println(array[9]);
    	}
        catch (Exception e) {
        
        	System.out.println( e.getStackTrace() );
        }
    	    System.out.println("java");
        }
    }

