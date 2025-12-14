void main() {
    // input : s1 : pretty , s2 = floppy

    IO.println(isIsomorphic("pretty", "floppy"));
    IO.println(isIsomorphic("pretty", "floppf"));
    IO.println(isIsomorphic("caat", "pool"));
}

private static boolean isIsomorphic(String s1, String s2) {
    if (s1.length() != s2.length()) return false;

    Map<Character, Character> characterMap = new HashMap<>();
    Set<Character> secondCharSet = new HashSet<>();
    for (int i = 0; i < s1.length(); i++) {
        char ch1 = s1.charAt(i);
        char ch2 = s2.charAt(i);

        if (!characterMap.containsKey(ch1)) {
            characterMap.put(ch1, ch2);
            // consider example pretty, floppy
            // mapping p-> f and further p need to be replaced by f only.
            // what if another character l -> f too? now it is not a isomorphic
            if (secondCharSet.contains(ch2)) return false;

            secondCharSet.add(ch2);
        } else {
            char ch3 = characterMap.get(ch1);
            if (ch3 != ch2) return false;
        }
    }
    return true;
}
