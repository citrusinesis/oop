import java.util.Arrays;

public class Assign04_10 {
    static abstract class PairMap {
        protected String[] keyArray;
        protected String[] valueArray;
        abstract String get(String key);
        abstract void put(String key, String value);
        abstract String delete(String key);
        abstract int length();
    }

    static class Dictionary extends PairMap {
        Dictionary(int size) {
            keyArray = new String[size];
            valueArray = new String[size];
        }

        @Override
        String get(String key) {
            int index = Arrays.asList(keyArray).indexOf(key);
            return index != -1 ? valueArray[index] : null;
        }

        @Override
        void put(String key, String value) {
            if (Arrays.asList(keyArray).contains(key)) {
                valueArray[Arrays.asList(keyArray).indexOf(key)] = value;
                return;
            }

            if (Arrays.asList(keyArray).contains(null)) {
                int index = Arrays.asList(keyArray).indexOf(null);
                keyArray[index] = key;
                valueArray[index] = value;
            }
        }

        @Override
        String delete(String key) {
            if (!Arrays.asList(keyArray).contains(key)) {
                return null;
            }

            int index = Arrays.asList(keyArray).indexOf(key);
            String returnValue = valueArray[index];
            valueArray[index] = null;
            keyArray[index] = null;

            return returnValue;
        }

        @Override
        int length() {
            int size = 0;
            for (String key : keyArray)
                if (key != null) size++;
            return size;
        }
    }

    public static void main(String[] args) {
        PairMap dic = new Dictionary(10);
        dic.put("황기태", "자바");
        dic.put("이재문", "파이선");
        dic.put("이재문", "C++");
        System.out.println("이재문의 값은 " + dic.get("이재문"));
        System.out.println("황기태의 값은 " + dic.get("황기태"));
        dic.delete("황기태");
        System.out.println("황기태의 값은 " + dic.get("황기태"));
    }
}
