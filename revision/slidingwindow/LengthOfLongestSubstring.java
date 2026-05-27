package revision.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> f = new HashMap<>();
        int l = 0, r = 0;
        int ans = 0;

        while (r < s.length()) {
            char ch = s.charAt(r);

            if (f.containsKey(ch) && f.get(ch) >= l) {
                l = f.get(ch) + 1;
            }

            f.put(ch, r);

            int len = r - l + 1;
            ans = Math.max(ans, len);

            r++;
        }

        return ans;
    }
}
