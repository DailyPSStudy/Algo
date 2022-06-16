import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import java.util.*;
import java.io.*;



public class 거짓말 {
	
	static void make() {
		p = new int[N+1];
		for(int i=1;i<N+1;i++) {
			p[i] = i;
		}
	}
	static int findp(int x) {
		if(p[x]!=x) return findp(p[x]);
		else return p[x]=x;
	}
	static boolean union(int a , int b) {
		
		int fa = findp(a);
		int fb = findp(b);

		
		if(fa==fb) return false;
		else {
			if(a>b) {
			p[fb] = fa;
			}
			else {
			p[fa] = fb;
			}
			return true;
		}
	}
	
	static int N;
	static int p[];
public static void main(String[] args) throws Exception {
	// TODO Auto-generated method stub
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(br.readLine());
	
	N = Integer.parseInt(st.nextToken());
	int M = Integer.parseInt(st.nextToken());


	
	make();
	
	boolean[] people = new boolean[N+1];
	
	String lines = br.readLine();
	st = new StringTokenizer(lines);
	int tpc = Integer.parseInt(st.nextToken());
	
	if(tpc!=0) {
		int answer = 0;
		for(int i=0;i<tpc;i++) {
			//진실을 아는사람
			people[Integer.parseInt(st.nextToken())]=true;
		}
		
		ArrayList<Integer>[] partilist = new ArrayList[M];
		
		for(int i=0;i<M;i++) {
			partilist[i] = new ArrayList<>();
		}
		
		int first = 0;
		int second = 0;
		for(int i=0;i<M;i++) { // 미팅 주최 인원 체크

			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			

			
			if(n>0) { //첫번쨰 친구가 대표자에욤
				 first = Integer.parseInt(st.nextToken());
				 partilist[i].add(first);
			}
			
			for(int j=1;j<n;j++) {
				second = Integer.parseInt(st.nextToken());
				partilist[i].add(second);
				union(first,second);
				first=second ; //체인기능
			}

		}

		for(int i=1;i<people.length;i++) {
			//진실을 아는사람
			if(people[i]) {
				int parent = findp(i);
				people[parent] =true;
			}
		}
		
		for(int i=0;i<M;i++) {
			if(partilist[i].size()>0) {
				int parent = findp(partilist[i].get(0));
				if(!people[parent]) {
					answer++;
				}
			}
		}
		
		System.out.println(answer);
		
		
		
	}
	else {
		System.out.println(M);
	}
	
}
}
