public class AttendanceSheet {
    private String[] presentStudents;
    private int count;

    public AttendanceSheet(int maxSize) {
        this.presentStudents = new String[maxSize];
        this.count = 0;
    }

    public void markPresent(String name) {
        for (int i = 0; i < count; i++) {
            if (presentStudents[i].equals(name)) {
                return;
            }
        }
        if (count < presentStudents.length) {
            presentStudents[count] = name;
            count++;
        }
    }

    public int getPresentCount() {
        return count;
    }

    public boolean isPresent(String name) {
        for (int i = 0; i < count; i++) {
            if (presentStudents[i].equals(name)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        AttendanceSheet sheet = new AttendanceSheet(30);
        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana");
        System.out.println("getPresentCount() -> " + sheet.getPresentCount());
        System.out.println("isPresent(\"Ben\") -> " + sheet.isPresent("Ben"));
        System.out.println("isPresent(\"Chen\") -> " + sheet.isPresent("Chen"));
    }
}