package leetCode;

public class RotateImage {
	public static void main (String [] args){
		int a [][] = {{1, 2, 3}
						,{4, 5, 6}
						,{7, 8, 9}};
		rotate(a);
		for (int i=0;i<a.length;i++){
			for (int j=0;j<a[i].length;j++){
				System.out.print (a[i][j] + " " );
			}
			System.out.println();
		}
	}
    public static void rotate(int[][] matrix) {
        for (int i=0;i<matrix.length/2;i++){
        	for (int j=i;j<matrix[i].length-i-1;j++){
        		int temp = matrix[j][matrix.length-1-i];
        		matrix[j][matrix[i].length-1-i] = matrix[i][j];
        		
        		int temp2 = matrix[matrix.length-1-i][matrix[i].length-1-j];
        		matrix[matrix.length-1-i][matrix[i].length-1-j] = temp;
        		
        		temp = matrix[matrix.length-1-j][i];
        		matrix[matrix.length-1-j][i] = temp2;
        		
        		matrix[i][j] = temp;
        	}
        }
    }
}
