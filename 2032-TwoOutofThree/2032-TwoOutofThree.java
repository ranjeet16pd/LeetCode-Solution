// Last updated: 19/05/2025, 10:29:46

class Solution {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        
        
        Set<Integer>s1=new HashSet<>();
        Set<Integer>s2=new HashSet<>();
        Set<Integer>s3=new HashSet<>();
        
        for(int ele: nums1){
            s1.add(ele);
        }
        for(int ele : nums2){
            s2.add(ele);
        }
        for(int ele : nums3){
            s3.add(ele);
        }
        
        Map<Integer,Integer> mp= new HashMap<>();
        s1.forEach(ele->{
            mp.put(ele, mp.getOrDefault(ele,0)+1);
        });
        
        s2.forEach(ele->{
            mp.put(ele,mp.getOrDefault(ele,0)+1);
        });
        
        s3.forEach(ele->{
            mp.put(ele,mp.getOrDefault(ele,0)+1);
        });
        
        List<Integer> ans= new ArrayList<>();
        mp.forEach((key,value)->{
             if(value>=2){
                ans.add(key);
            }
        });
        return  ans;
        
        
       
    }
}