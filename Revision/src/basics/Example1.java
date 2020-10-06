package basics;



import java.math.BigInteger;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;



public class Example1 {

	private final static  long  MODE=1000000007;
	
	static int con(boolean f)
	{
		if(f)return 1;
		else return 0;
	}
	
	
public static void main(String[] args) {
	int t,i,j,k;
	Scanner sc=new Scanner(System.in);
	t=sc.nextInt();
	while(t>0)
	{
		
		t--;
		String s=sc.next();
		char []ch=s.toCharArray();
		int len=s.length();
		int cr=0,cry=0,cryy=0;
		for(i=0;i<len;i++)
		{
			if(ch[i]=='R')cr++;
		}
		for(i=0;i<len-1;i++)
		{
			if(ch[i]=='R'&& ch[i]=='Y')cry++;
		}
		for(i=0;i<len-2;i++)
		{
			if(ch[i]=='R'&&ch[i+1]=='Y'&&ch[i+2]=='Y')cryy++;
		}
		if(cr+cry+cryy>3)
			System.out.print("YES");
		else
			System.out.print("NO");
	System.out.println();
	
	}
}
}	



class GFG
{
public static void main (String[] args)
{
//code
Scanner sc = new Scanner(System.in);
int num = sc.nextInt();
while(num-- > 0){
int sum = 0;
PriorityQueue<Integer> pq = new PriorityQueue<>();
int num_ropes = sc.nextInt();
for(int i = 0; i < num_ropes; i++){
pq.add(sc.nextInt());
}
while(pq.size()>=2){
int a = pq.remove();

int b = pq.remove();
sum += (a + b);
pq.add(a + b);
}
System.out.println(sum);
}
}

