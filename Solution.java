class Solution {
	
    @Override
	public String toString() {
		return "Solution [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

	public Solution() {
		// TODO Auto-generated constructor stub
	}
	
	//*****ALgo1
	public int solution(int[]A) {
		int n =A.length;
		int res=0;
		for (int i = 0; i < n; i++) 
	        res = res ^ A[i]; 
		System.out.print(res);
	    return res;
	}
	
	//*****Algo 2
	public int[] solution(int N, int[] A) {

        final int condition = N + 1;
        int maxValue = 0;
        int operation = 0;
        int countersArray[] = new int[N];

        for (int i = 0; i < A.length; i++) {
            int currentValue = A[i];
            if (currentValue == condition) {
                operation = maxValue;
            } else {
                int pos = currentValue - 1;
                if (countersArray[pos] < operation)
                    countersArray[pos] = operation + 1;
                else
                    countersArray[pos]++;

                if (countersArray[pos] > maxValue) {
                    maxValue = countersArray[pos];
                }
            }

        }

        for (int i = 0; i < N; i++)
           if (countersArray[i] < operation)
               countersArray[i] = operation;

        return countersArray;
    }
	
	//****Algo3
	 public int[] solution(int[] a, int[] b) {
	        final int[] tab = new int[a.length < 2 ? 2 : a.length];
	        tab[0] = 1;
	        tab[1] = 2;
	        
	        for (int i = 2; i < a.length; i++) {
	            
	            tab[i] = (tab[i - 1] + tab[i - 2]) & ((1 << 30) - 1);
	        }
	        for (int i = 0; i < a.length; i++) {
	            a[i] = tab[a[i] - 1] & ((1 << b[i]) - 1);
	        }
	        return a;
	    }
	
}