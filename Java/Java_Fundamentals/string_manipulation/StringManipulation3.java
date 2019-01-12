public class StringManipulation3 {
    public Integer getIndexOrNull(String word, char subString) {
        return word.indexOf(subString);
    }
    public Integer getIndexOrNull(String word, String notSubString) {
        return word.indexOf(notSubString);
    }
}