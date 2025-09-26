package com.note.二分查找;

public class _410_分割数组的最大值 {
    public int splitArray(int[] nums, int k) {
        int l=0,r=(int)1e9;
        while(l<r){
            int mid = (l+r)>>1;
            if(check(mid,nums,k)) r=mid;
            else l=mid+1;
        }
        return l;
    }
    boolean check(int x,int []nums,int k){
        int count=1,sum=0;
        for(int num:nums){
            if(sum+num<=x)sum+=num;
            else{
                if(sum>x) return false;
                count++;
                sum=num;
            }
        }
        return count<=k;

    }
}
