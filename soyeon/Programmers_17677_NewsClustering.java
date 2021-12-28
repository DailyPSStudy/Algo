package programmers_17677_NewsClustering;
import java.util.*;
import java.util.regex.Pattern; // util.* �ϴµ� �� ��������;
/**
��    ��: 2021-12-28 4:20
�� �� ��: �� �� ��
https://programmers.co.kr/learn/courses/30/lessons/17677
*/
class Programmers_17677_NewsClustering {
    static String pattern = "^[A-Z]*$";
    
    public int solution(String str1, String str2) {
        List<String> subsetOfStr1 = new ArrayList<>();
        List<String> subsetOfStr2 = new ArrayList<>();
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        // subsetOfStr1,subsetOfStr2�� str1,str2�� �ι��ھ� �ɰ��� �ִ´�.(Ư����������) substring����
        subsetOfStr1 = splitInTwo(str1);
        subsetOfStr2 = splitInTwo(str2);
        System.out.printf("subsetOfStr1 : %d, subsetOfStr2 : %d\n", subsetOfStr1.size(), subsetOfStr2.size());
        System.out.println("list1: "+subsetOfStr1);
        System.out.println("list2: "+subsetOfStr2);
        // ��� 0�� ��쿣 1�� ����
        if(subsetOfStr1.size()==0 && subsetOfStr2.size()==0) {
            return 65536;
        } else {
            double jcdScore = getJacquard(subsetOfStr1, subsetOfStr2);
            System.out.printf("jcdScore*65536 : %d\n", (int)Math.floor(65536*jcdScore));
            // 65536 ���ؼ� ����
            return (int)Math.floor(65536*jcdScore);
        }
        
    } // end of solution
    
    // subsetOfStr1,subsetOfStr2�� str1,str2�� �ι��ھ� �ɰ��� �ִ´�.(Ư����������) substring����
    public List<String> splitInTwo(String target) {
        List<String> res = new ArrayList<>();
        // 222
        for(int i = 0; i < target.length()-1; i++) {
            String temp = target.substring(i,i+2);
            boolean regex = Pattern.matches(pattern, temp);
            if(regex){
                res.add(temp);
            }
        }
        return res;
    } // end of splitInTwo
    
    public double getJacquard(List<String> subsetOfStr1, List<String> subsetOfStr2) {
        List<String> inter = new ArrayList<>();
        List<String> union = new ArrayList<>();
        
        // ������,������ �ɷ��������� �������� �����Ѵ�
        Collections.sort(subsetOfStr1);
        Collections.sort(subsetOfStr2);
        
        // ����1�� ���Ҹ� �ϳ������� ����2�� ���ԵǴ��� Ȯ���Ѵ�.
        for(String str : subsetOfStr1) {
            // ����2�� ���Եɰ��, �����Կ� ����1 ���Ҹ� �߰��ϰ� ����2������ �����Ѵ�.
            if(subsetOfStr2.remove(str)) {
                inter.add(str);
            }
            // ����2�� ���Եǵ�ȵǵ� ����1 ���Ҹ� �����տ� �߰��Ѵ�.
            union.add(str);
        }
        
        // �����տ��� �����Ȱ��� ������ ������ ���Ҹ� ������(union)�� �߰�
        for(String str : subsetOfStr2) {
            union.add(str);
        }
        
        int sizeOfInter = inter.size();
        int sizeOfUnion = union.size();
        System.out.printf("�ߺ���: %d\n", inter.size());
        System.out.printf("size: %d\n", union.size());
        System.out.printf("jcdScore: %f\n", (double)sizeOfInter/sizeOfUnion);
        return (double)sizeOfInter/sizeOfUnion;
    } // end of getJacquard
    
} // end of class