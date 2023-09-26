public class Data {
    private int day, month, year;

    public Data(int day, int month, int year){
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String toString() {
        String formattedDay = day < 10 ? "0" + day : Integer.toString(day);
        String formattedMonth = month < 10 ? "0" + month : Integer.toString(month);

        return String.format("%s/%s/%s", formattedDay, formattedMonth, year);
    }
}
