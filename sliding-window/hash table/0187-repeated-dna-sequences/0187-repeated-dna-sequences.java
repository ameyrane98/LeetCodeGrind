class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
    Set<String> seen = new HashSet<>();
    Set<String> repeated = new HashSet<>();
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < s.length(); i++) {
        sb.append(s.charAt(i));
        if (sb.length() > 10) {
            sb.deleteCharAt(0);
        }
        if (sb.length() == 10) {
            String window = sb.toString();
            if (!seen.add(window)) {
                repeated.add(window);
            }
        }
    }
    return new ArrayList<>(repeated);
}
}