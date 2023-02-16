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

interface MathProcessing
{
    public void performMathOperation(String operator, List<Integer> datainput);
}

class Basicmathprocessing implements MathProcessing
{
    MathAdapter ma1 = new MathAdapter();

    public void performMathOperation(String operator, List<Integer> datainput)
    {

    }
}

class AdvancedmathProcessing
{
    public void calculateAverage(List<Integer> ls)
    {
        int sum = 0;
        for(int num:ls)
        {
            sum = sum + ls.get(num);
        }

        int average = sum / ls.size();

        System.out.println("The Average is : " + average);
    }

    public void sortData(List<Integer> ls)
    {
        int temp;

        for(int i=0;i<ls.size();i++)
        {
            for(int j=1;j<ls.size();i++)
            {
                if(ls.get(j-1)>ls.get(i))
                {
                    temp = ls.get(j-1);
                    ls.set(j-1, ls.get(j));
                    ls.set(j,temp);
                }
            }
        }

        System.out.println("Sorted array is : ");
        for(Integer i : ls)
        {
            System.out.println(i + " ");
        }

        System.out.println("\n");
    }

    public void searchData(List<Integer> ls, int key)
    {
        int flag = 0;

        for(int i=0; i<ls.size();i++)
        {
            if(key == ls.get(i))
            {
                System.out.println("Element " + key + " found at position " + i);
            }

            else
            {
                System.out.println(key + " not found in the array");
            }
        }
    }

    public void replaceData(List<Integer> ls, int key, int value) 
    {
        for(int i=0; i<ls.size();i++)
        {
            if(key == ls.get(i))
            {
                ls.set(i, value);
            }

            else
            {
                System.out.println("Element to be replaced not found !!");
            }
        }
    }

    public void listAdd(List <Integer> ls)
    {
        int sum=0;
        
        for(Integer l : ls)
        {
            sum = sum + l;
        }

        System.out.println("Sum of the array is : " + sum);
    }
}

class MathAdapter implements MathProcessing
{
    AdvancedmathProcessing m1 = new AdvancedmathProcessing();

    @Override
    public void performMathOperation(String operator, List<Integer> data)
    {
        List <Integer> ls1 = new ArrayList<Integer>();
        
        if(operator.equalsIgnoreCase("sum")|| operator.equals("+"))
        {
           
        }
    }
}

public class MathAdapterTest
{
    public static void main(String[] args) 
    {
        
    }
}

/*
 import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface MathProcessing{
    public void performMathOperation(String type,Integer[] data);
}


class AdvanceMathProcessing{
    public void calculateAverage(List<Integer> ls){
        int sum=0;
        for(int num:ls){
            sum=sum+
        }
    }
    public void sortData(List<Integer>ls){

    }

    public void searchData(List<Integer>ls,int key){

    }

    public void replaceData(List<Integer>ls,int key,int value){

    }
}

class MathAdapter implements MathProcessing{

    AdvanceMathProcessing am =new AdvanceMathProcessing();
    @Override
    public void performMathOperation(String type, Integer[] data) {
        List<Integer>ls1=new ArrayList<Integer>();
        for(int i=0;i<data.length;i++){
            ls1.add(data[i]);
        }

        if(type.equalsIgnoreCase("sort")){
            am.sortData(ls1);
        }

        else if(type.equalsIgnoreCase("search")){
            Scanner sc =new Scanner(System.in);
            System.out.println("Enter number to find:");
            int find=sc.nextInt();
            am.searchData(ls1,find);
        }

        else if(type.equalsIgnoreCase("avg")){
            am.calculateAverage(ls1);
        }

        else if(type.equalsIgnoreCase("replace")){
            Scanner sc1 =new Scanner(System.in);
            System.out.println("Enter a number you want to replace:");
            int find=sc1.nextInt();
            System.out.println("Enter a value:");
            int val=sc1.nextInt();
            am.replaceData(ls1,find,val);
        }
    }
}

class BasicMathProcessing implements MathProcessing{

    MathAdapter ma=new MathAdapter();
    @Override
    public void performMathOperation(String type, Integer[] data) {
        ma.performMathOperation(type,data);
    }
}

*/