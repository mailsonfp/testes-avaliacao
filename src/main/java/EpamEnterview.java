import java.util.Arrays;

public class EpamEnterview {
	
	static int getMissing(int a[]){
		
		int missingNumber = -1;		
		Arrays.sort(a);
		int count = 1;
		
		for(int i = 0;i<a.length;i++) {
			if(a[i]!=count) {
				missingNumber = count;
				break;
			}
			
			count++;
		}
				
		return missingNumber;
	}
	
	public static void main(String args[]){
		int a[] = { 1, 2, 3, 4, 6 };
		
		int miss = getMissing(a);
		
		System.out.println(miss);
	}
	
}
