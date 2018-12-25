package task;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        
        // 1
        List<Student> students = new ArrayList<>();
        students.add(new Student("Valery", "Popov"));
        students.add(new Student("Semyon", "Korzhev"));
        students.add(new Student("Peter", "Ivanov"));
        students.add(new Student("Maria", "Semenova"));
        students.add(new Student("Kolya", "Nesterenko"));

        // 2
        List<Subject> subjects = new ArrayList<>();
        subjects.add(new Subject("Mathematics", true));
        subjects.add(new Subject("Physics", true));
        subjects.add(new Subject("Astronomy", true));
        subjects.add(new Subject("History", true));
        subjects.add(new Subject("Ethics", false));

        // 3
        List<Mark> marks = new ArrayList<>();
        for (Student student : students) {
            for (Subject subject : subjects) {
                if (student.getFirstName() == "Maria" && (subject.getName() == "History" || !subject.isMandatory())) {
                    marks.add(new Mark(student, subject, 5));
                }
                else if (subject.isMandatory()) {
                    marks.add(new Mark(student, subject, 3));
                }
            }
        }

        // 4
        marks.stream()
                .map(Mark::getStudent)
                .distinct()
                .forEach(x -> System.out.println(x + " " + studentSubjectsMarks(x, marks)));


    }

    public static String studentSubjectsMarks(Student student, List<Mark> list) {
        return list.stream()
                .filter(x -> x.getStudent().equals(student))
                .map(x -> x.getSubject() + "-" + x.getRank())
                .reduce("", (acc, comb) -> acc + comb + " ");
    }
}
