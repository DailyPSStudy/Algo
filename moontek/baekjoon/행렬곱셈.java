import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 행렬곱셈 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());
		
		int[][] array = new int[count][count];  // a번부터 b번쨰까지 곱연산수의 합
		int[][] def = new int[count][2]; //행렬의 행 + 열을 저장할 공간
		
		/*결국 핵심은 
		
		행렬 3개의 묶음을 보는기준이 핵심이다
		
		2개는 고정이되어있음
		그러나 3개부터는
		012 라고하면  |  01 // 2연산 |  0// 12 연산 | 이렇게 볼수있따. 여기중에 작은거..
		
		4개는 
		
		0123이라고하면 결국  
		
		012 // 3 연산인데 부터..인데..
		012 해놓은거는 우리가 이전에 [0][2] 를통해 구해놓았기때ㅔ문에 그것만쓰시면된다..\
		
		012 //3  || 01//23 || 0//123 이렇게 된다  
		
		01234일경우
		
		0123//4  || 012//34 || 01//234 || 0//1234 ||
		
		이렇게 구성으로된다.
		
		그리고 인접으로만 묶을수있기때문에 j 스타트를찍어준다
		*/
        StringTokenizer st;
		for(int i=0;i<count;i++) 
		{
			st= new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			def[i][0] = start;
			def[i][1] = end;
		}
		
		for(int i=1;i<count;i++) { //간격
			for(int j=0;j<count-i;j++) { //시작포인트
				array[j][j+i] = Integer.MAX_VALUE;
				for(int k=0;k<i;k++) { //중간지점
					int val = array[j][j+k] + array[j+k+1][j+i] + def[j][0] * def[j+k][1] * def[j+i][1];
					array[j][j+i] = Math.min(val, array[j][j+i]);
				}
			}
		}
		System.out.println(array[0][count-1]);
	}

}
