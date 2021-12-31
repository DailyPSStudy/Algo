package Programmers;

import java.util.Arrays;

public class 행렬테두리회전하기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] q = new int[][] {
			{2,2,5,4},{3,3,6,6},{5,1,6,3}
		};
		
		Arrays.toString(solution(6,6,q));
		System.out.println("Ss");
	}
	  public static int[] solution(int rows, int columns, int[][] queries) {
	        int size = queries.length;
		  	int[] answer = new int[size];
	        
	        
		  	int array[][] = new int[rows][columns];
		  	
		  	int start = 0;
		  	for(int i=0;i<rows;i++) {
		  		for(int j=0;j<columns;j++) {
		  			array[i][j] = ++start;
		  		}
		  	}
		  	
		  	for(int i=0;i<rows;i++) {
		  		for(int j=0;j<columns;j++) {
		  			System.out.print(array[i][j] + " ");
		  		}
		  		System.out.println();
		  	}
	        System.out.println(queries.length);
	        
	        for(int i=0;i<size;i++) {
	        	int min = Integer.MAX_VALUE;
	        	int sx = queries[i][0]-1;
	        	int sy = queries[i][1]-1;
	        	int ex = queries[i][2]-1;
	        	int ey = queries[i][3]-1;
	        	
	        	
	        	
	        	
	        	int save = array[sx][sy]; 
	        	
	        	for(int j=sx;j<ex;j++) {
	        		array[j][sy] = array[j+1][sy];
	        		min = Math.min(array[j][sy], min);
	        	}
	        	
	        	for(int j=sy;j<ey;j++) {
	        		array[ex][j]= array[ex][j+1];
	        		min = Math.min(array[ex][j], min);
	        	}
	        	
	        	for(int j=ex;j>sx;j--) {
	        		array[j][ey] = array[j-1][ey];
	        		min = Math.min(array[j][ey], min);
	        	}
	        	for(int j=ey;j>sy;j--) {
	        		array[sx][j] = array[sx][j-1];
	        		min = Math.min(array[sx][j], min);
	        	}
	        	array[sx][sy+1] = save;
	        	min = Math.min(save, min);
	        	answer[i] = min;
	        	
	          	for(int a=0;a<rows;a++) {
			  		for(int b=0;b<columns;b++) {
			  			System.out.print(array[a][b] + " ");
			  		}
			  		System.out.println();
			  	}
	        }
	        
	        return answer;
	    }
}
