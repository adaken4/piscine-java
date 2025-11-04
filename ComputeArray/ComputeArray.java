public class ComputeArray {
    public static int[] computeArray(int[] array) {
        if (array == null) return null;
        int[] result = new int[array.length];
        
        for (int i = 0; i < array.length; i++) {
            int remainder = array[i] % 3;
            
            if (remainder == 0) {
                // Multiple of 3: multiply by 5
                result[i] = array[i] * 5;
            } else if (remainder == 1) {
                // Multiple of 3 + 1: increment by 7
                result[i] = array[i] + 7;
            } else {
                // Multiple of 3 + 2: stays unchanged
                result[i] = array[i];
            }
        }
        
        return result;
    }
}