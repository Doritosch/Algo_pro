class Solution {
    public String solution(String new_id) {
        
        String answer = new KAKAOID(new_id).
                            toLower().
                            filter().
                            replaceDot().
                            removeDot().
                            ifEmpty().
                            substringString().
                            concatString().
                            getString();
        
        return answer;
    }
    
    private static class KAKAOID {
        private String id;
        
        KAKAOID(String id) {
            this.id = id;
        }
        
        private KAKAOID toLower() {
            id = id.toLowerCase();
            return this;
        }
        
        private KAKAOID filter() {
            id = id.replaceAll("[^a-z0-9-_.]", "");
            return this;
        }
        
        private KAKAOID replaceDot() {
            id = id.replaceAll("[.]{2,}", ".");
            return this;
        }
        
        private KAKAOID removeDot() {
            id = id.replaceAll("^[.]|[.]$", "");
            return this;
        }
        
        private KAKAOID ifEmpty() {
            if ( id.isEmpty() ) {
                id = "a";
            }
            return this;
        }
        
        private KAKAOID substringString() {
            if ( id.length() >= 16 ) {
                id = id.substring(0, 15);
                id = id.replaceAll("[.]$", "");
            }
            return this;
        }
        
        private KAKAOID concatString() {
            if ( id.length() <= 2 ) {
                while(id.length()<3) {
                    id += id.charAt(id.length()-1);
                }
            }
            return this;
        }
        
        private String getString() {
            return id;
        }
    }
}