import java.util.*;

public class Management {

    public static class Student {
        private int id;
        private String name;
        private int age;
        private Set<String> subjects;
        private Map<String, Double> grades;

        public Student(int id, String name, int age) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.subjects = new HashSet<>();
            this.grades = new HashMap<>();
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public Set<String> getSubjects() {
            return subjects;
        }

        public Map<String, Double> getGrades() {
            return grades;
        }

        public void addSubject(String subject) {
            subjects.add(subject);
        }

        public void addGrade(String subject, double grade) {
            subjects.add(subject);
            grades.put(subject, grade);
        }

        public double getAverageGrade() {
            if (grades.isEmpty()) return 0.0;
            double total = 0.0;
            for (double grade : grades.values()) {
                total += grade;
            }
            return total / grades.size();
        }

        @Override
        public String toString() {
            return "Student{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", age=" + age +
                    ", subjects=" + subjects +
                    ", grades=" + grades +
                    '}';
        }
    }

    private Map<Integer, Student> studentsById;
    private Map<String, Set<Student>> studentsByName;

    public Management() {
        studentsById = new HashMap<>();
        studentsByName = new HashMap<>();
    }

    public void addStudent(Student student) {
        studentsById.put(student.getId(), student);
        studentsByName.computeIfAbsent(student.getName(), k -> new HashSet<>()).add(student);
    }

    public boolean removeStudentById(int id) {
        Student student = studentsById.remove(id);
        if (student != null) {
            Set<Student> set = studentsByName.get(student.getName());
            if (set != null) {
                set.remove(student);
                if (set.isEmpty()) {
                    studentsByName.remove(student.getName());
                }
            }
            return true;
        }
        return false;
    }

    public Student searchStudentById(int id) {
        return studentsById.get(id);
    }

    public Set<Student> searchStudentsByName(String name) {
        return studentsByName.getOrDefault(name, Collections.emptySet());
    }

    public List<Student> sortStudentsByName() {
        List<Student> list = new ArrayList<>(studentsById.values());
        list.sort(Comparator.comparing(Student::getName));
        return list;
    }

    public List<Student> sortStudentsByGrade() {
        List<Student> list = new ArrayList<>(studentsById.values());
        list.sort(Comparator.comparingDouble(Student::getAverageGrade).reversed());
        return list;
    }

    public Set<Student> findStudentsBySubject(String subject) {
        Set<Student> result = new HashSet<>();
        for (Student student : studentsById.values()) {
            if (student.getSubjects().contains(subject)) {
                result.add(student);
            }
        }
        return result;
    }

    public static void simpleTest() {
        Management management = new Management();

        Student s1 = new Student(1, "Alice", 20);
        s1.addGrade("Math", 85);
        s1.addGrade("Physics", 90);

        Student s2 = new Student(2, "Bob", 22);
        s2.addGrade("Math", 75);
        s2.addGrade("Chemistry", 80);

        Student s3 = new Student(3, "Alice", 21);
        s3.addGrade("Physics", 95);
        s3.addGrade("Chemistry", 88);

        management.addStudent(s1);
        management.addStudent(s2);
        management.addStudent(s3);

        System.out.println("Search by ID 1: " + management.searchStudentById(1));
        System.out.println("Search by name 'Alice': " + management.searchStudentsByName("Alice"));

        System.out.println("Students sorted by name:");
        for (Student s : management.sortStudentsByName()) {
            System.out.println(s);
        }

        System.out.println("Students sorted by grade:");
        for (Student s : management.sortStudentsByGrade()) {
            System.out.println(s);
        }

        System.out.println("Students enrolled in Physics:");
        for (Student s : management.findStudentsBySubject("Physics")) {
            System.out.println(s);
        }

        management.removeStudentById(2);
        System.out.println("After removing student with ID 2:");
        for (Student s : management.sortStudentsByName()) {
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
        simpleTest();
    }
}