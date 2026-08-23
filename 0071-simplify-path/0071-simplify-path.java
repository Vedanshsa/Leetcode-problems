import java.util.*;

class Solution {
    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();
        String[] parts = path.split("/");

        for (String part : parts) {
            if (part.equals("") || part.equals(".")) {
                continue; 
            } else if (part.equals("..")) {
                if (!stack.isEmpty()) stack.pop(); 
            } else {
                stack.push(part); 
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String dir : stack) {
            sb.insert(0, "/" + dir);
        }

        return sb.length() == 0 ? "/" : sb.toString();
    }
}
