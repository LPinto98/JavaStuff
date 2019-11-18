package lcs;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class LCS {
	int count=0;
 	public String lcs(String str1, String str2){
		int l1 = str1.length();
		int l2 = str2.length();
		int[][] arr = new int[l1 + 1][l2 + 1];
		for (int i = l1 - 1; i >= 0; i--){
			for (int j = l2 - 1; j >= 0; j--){
				if (str1.charAt(i) == str2.charAt(j))
					arr[i][j] = arr[i + 1][j + 1] + 1;
				else
					arr[i][j] = Math.max(arr[i + 1][j], arr[i][j + 1]);
			}
		}
		int i = 0, j = 0;
		StringBuffer sb = new StringBuffer();
		while (i < l1 && j < l2){
			if (str1.charAt(i) == str2.charAt(j)){
				sb.append(str1.charAt(i));
				i++;
				j++;
				count++;
			}
			else if (arr[i + 1][j] >= arr[i][j + 1])
				i++;
			else
				j++;
		}
		return sb.toString();
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Longest Common Subsequence Algorithm Test\n");
		System.out.println("\nEnter string 1");
		String str1 = br.readLine();
		System.out.println("\nEnter string 2");
		String str2 = br.readLine();
		LCS obj = new LCS();
		String result = obj.lcs(str1, str2);
		System.out.println("\nLongest Common Subsequence : "+ result);
		System.out.println("\nLength Of Longest Common Subsequence : "+obj.count);
	}
}