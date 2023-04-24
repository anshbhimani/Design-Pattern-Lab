/*
    client-interface for math processing name - MathProcessing
    1 functionality -- void performMathOperation (String operator, Interger[] data)

    class Basicmathprocessing -- has implementation of performMathOperation method

    class AdvancedmathProcessing -- 
        public void calculateAverage(List<Integer> ls)
        public void sortData(List<Integer> ls)
        public int searchData(List<Integer> ls) -- returns position of the data in array, return - if not available
        public void replace(List<Integer> ls, int key, int value)]


    we would need to convert array to list
    so we make mathAdapter where we change the Array to list
*/

import java.util.List;
import java.util.ArrayList;

interface MathProcessing {
    void performMathOperation(String operator, List<Integer> data);
}

class BasicMathProcessing implements MathProcessing {
    MathAdapter mathAdapter = new MathAdapter();

    @Override
    public void performMathOperation(String operator, List<Integer> data) {
        mathAdapter.performMathOperation(operator, data);
    }
}

class AdvancedMathProcessing {
    void calculateAverage(List<Integer> ls) {
        int sum = 0;
        for (int num : ls) {
            sum = sum + num;
        }
        int average = sum / ls.size();
        System.out.println("The average is: " + average);
    }

    void sortData(List<Integer> ls) {
        int temp;
        for (int i = 0; i < ls.size(); i++) {
            for (int j = 1; j < ls.size(); j++) {
                if (ls.get(j - 1) > ls.get(j)) {
                    temp = ls.get(j - 1);
                    ls.set(j - 1, ls.get(j));
                    ls.set(j, temp);
                }
            }
        }
        System.out.println("Sorted array is: " + ls);
    }

    int searchData(List<Integer> ls, int key) {
        for (int i = 0; i < ls.size(); i++) {
            if (key == ls.get(i)) {
                System.out.println("Element " + key + " found at position " + i);
                return i;
            }
        }
        System.out.println(key + " not found in the array");
        return -1;
    }

    void replaceData(List<Integer> ls, int key, int value) {
        for (int i = 0; i < ls.size(); i++) {
            if (key == ls.get(i)) {
                ls.set(i, value);
                System.out.println("Element " + key + " replaced with " + value);
                return;
            }
        }
        System.out.println("Element to be replaced not found !!");
    }

    void listAdd(List<Integer> ls) {
        int sum = 0;
        for (int l : ls) {
            sum = sum + l;
        }
        System.out.println("Sum of the array is : " + sum);
    }
}

class MathAdapter implements MathProcessing {
    AdvancedMathProcessing advancedMathProcessing = new AdvancedMathProcessing();

    @Override
    public void performMathOperation(String operator, List<Integer> data) {
        if (operator.equalsIgnoreCase("average")) {
            advancedMathProcessing.calculateAverage(data);
        } else if (operator.equalsIgnoreCase("sort")) {
            advancedMathProcessing.sortData(data);
        } else if (operator.equalsIgnoreCase("search")) {
            int key = data.get(0);
            advancedMathProcessing.searchData(data.subList(1, data.size()), key);
        } else if (operator.equalsIgnoreCase("replace")) {
            int key = data.get(0);
            int value = data.get(1);
            advancedMathProcessing.replaceData(data.subList(2, data.size()), key, value);
        } else if (operator.equalsIgnoreCase("add")) {
            advancedMathProcessing.listAdd(data);
        } else {
            System.out.println("Invalid operator!!");
        }
    }
}

public class MathAdapterTest {
    public static void main(String[] args) {
        MathProcessing mathProcessor = new BasicMathProcessing();
        List<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        
        System.out.println("Calculating average...");
        mathProcessor.performMathOperation("average", numbers);
        
        System.out.println("Performing addition...");
        mathProcessor.performMathOperation("add", numbers);

        System.out.println("Performing sorting...");
        mathProcessor.performMathOperation("sort", numbers);

        System.out.println("Performing replacement...");
        mathProcessor.performMathOperation("replace", numbers);

        System.out.println("Performing search...");
        mathProcessor.performMathOperation("search", numbers);
    }
}

