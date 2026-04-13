function lengthOfLongestSubstring(s: string): number {
    if(s.length=== 0 || s===null) return 0;
    let set = new Set<string>();
    let max_length: number = 0; // FIXED: Proper TS type annotation
    let left: number = 0;
    let n: number = s.length;
    for(let i=0; i<n; i++){
        while(set.has(s.charAt(i))){
            set.delete(s.charAt(left))
            
            left++
        }

        set.add(s.charAt(i));
        max_length= Math.max(max_length,set.size)
    }

    return max_length;
}