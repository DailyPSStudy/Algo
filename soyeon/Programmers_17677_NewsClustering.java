package programmers_17677_NewsClustering;
import java.util.*;
import java.util.regex.Pattern; // util.* 하는데 왜 안잡히지;
/**
일    시: 2021-12-28 4:20
작 성 자: 유 소 연
https://programmers.co.kr/learn/courses/30/lessons/17677
*/
class Programmers_17677_NewsClustering {
    static String pattern = "^[A-Z]*$";
    
    public int solution(String str1, String str2) {
        List<String> subsetOfStr1 = new ArrayList<>();
        List<String> subsetOfStr2 = new ArrayList<>();
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        // subsetOfStr1,subsetOfStr2에 str1,str2를 두문자씩 쪼개어 넣는다.(특수문자제외) substring으로
        subsetOfStr1 = splitInTwo(str1);
        subsetOfStr2 = splitInTwo(str2);
        System.out.printf("subsetOfStr1 : %d, subsetOfStr2 : %d\n", subsetOfStr1.size(), subsetOfStr2.size());
        System.out.println("list1: "+subsetOfStr1);
        System.out.println("list2: "+subsetOfStr2);
        // 모두 0일 경우엔 1로 정의
        if(subsetOfStr1.size()==0 && subsetOfStr2.size()==0) {
            return 65536;
        } else {
            double jcdScore = getJacquard(subsetOfStr1, subsetOfStr2);
            System.out.printf("jcdScore*65536 : %d\n", (int)Math.floor(65536*jcdScore));
            // 65536 곱해서 리턴
            return (int)Math.floor(65536*jcdScore);
        }
        
    } // end of solution
    
    // subsetOfStr1,subsetOfStr2에 str1,str2를 두문자씩 쪼개어 넣는다.(특수문자제외) substring으로
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
        
        // 교집합,합집합 걸러내기위해 두집합을 정렬한다
        Collections.sort(subsetOfStr1);
        Collections.sort(subsetOfStr2);
        
        // 집합1의 원소를 하나씩꺼내 집합2에 포함되는지 확인한다.
        for(String str : subsetOfStr1) {
            // 집합2에 포함될경우, 교집함에 집합1 원소를 추가하고 집합2에서는 삭제한다.
            if(subsetOfStr2.remove(str)) {
                inter.add(str);
            }
            // 집합2에 포함되든안되든 집합1 원소를 합집합에 추가한다.
            union.add(str);
        }
        
        // 교집합에서 삭제된것을 제외한 나머지 원소를 합집합(union)에 추가
        for(String str : subsetOfStr2) {
            union.add(str);
        }
        
        int sizeOfInter = inter.size();
        int sizeOfUnion = union.size();
        System.out.printf("중복수: %d\n", inter.size());
        System.out.printf("size: %d\n", union.size());
        System.out.printf("jcdScore: %f\n", (double)sizeOfInter/sizeOfUnion);
        return (double)sizeOfInter/sizeOfUnion;
    } // end of getJacquard
    
} // end of class