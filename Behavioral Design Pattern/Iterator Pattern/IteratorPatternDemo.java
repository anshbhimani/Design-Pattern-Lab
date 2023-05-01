import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Student {
    int roll;
    String name;
    double percentage;

    public Student(int r, String name, double percentage) {
        roll = r;
        this.name = name;
        this.percentage = percentage;
    }

    public double getPercentage() {
        return percentage;
    }

    public String toString() {
        return "Student Details : \n " + "Roll Number : " + roll + "\n" + "Name :" + name + "\n " + "Percentage : "
                + percentage;
    }
}

interface StudentIterator {
    public Student next();

    public boolean hasNext();
}


class StudentCollection {
    List<Student> ls = new ArrayList<Student>();

    public void addStudent(Student s) {
        ls.add(s);
    }

    public void removeStudent(Student s) {
        ls.remove(s);
    }

    public List<Student> getList() {
        return ls;
    }

    public StudentIterator getIterator(String type) {
        if (type.equalsIgnoreCase("Percentage"))
            return new PercentageIterator();
        else
            return new StandardIterator();
    }

    private class PercentageIterator implements StudentIterator {
        int position_Counter = 0;

        public Student next() {
            Student s = ls.get(position_Counter);
            position_Counter++;
            return s;
        }

        @Override
        public boolean hasNext() {
            while (position_Counter < ls.size()) {
                if (ls.get(position_Counter).getPercentage() > 60.0) {
                    return true;
                } else {
                    position_Counter++;
                }
            }
            return false;
        }
    }

    private class StandardIterator implements StudentIterator {
        int position_Counter;

        public Student next() {
            Student s = ls.get(position_Counter);
            position_Counter++;
            return s;
        }

        @Override
        public boolean hasNext() {
            return position_Counter < ls.size();
        }
    }
}


class IteratorPatternDemo
{
    public static void main(String[] args)
    {
        Student s1 = new Student(101, "Dev Sapariya", 99.99);
        Student s2 = new Student(102, "Mit", 99.00);
        Student s3 = new Student(103, "Chintan", 100);
        Student s4 = new Student(104, "Abhisht", 10.00);
        Student s5 = new Student(105, "Ansh", 98.99);

        StudentCollection collection = new StudentCollection();

        collection.addStudent(s1);
        collection.addStudent(s2);
        collection.addStudent(s3);
        collection.addStudent(s4);
        collection.addStudent(s5);

        StudentIterator is = collection.getIterator("Standard");

        while(is.hasNext())
        {
            Student s = is.next();
            System.out.println(s.toString());
        }
    }
}
