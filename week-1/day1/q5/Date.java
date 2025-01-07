public class Date {
 private int day;
 private int month;
 private int year;

 public Date(int day, int month, int year) {
  this.day = day;
  this.month = month;
  this.year = year;
 }

 // Method to check if a year is a leap year
 public static boolean isLeapYear(int year) {
  return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
 }

 // Method to get the number of days in a given month and year
 public static int getDaysInMonth(int month, int year) {
  int[] daysInMonth = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

  if (month == 2 && isLeapYear(year)) {
   return 29;
  }
  return daysInMonth[month];
 }

 // Method to increment the date by one day
 public void incrementDate() {
  this.day++;
  if (this.day > getDaysInMonth(this.month, this.year)) {
   this.day = 1;
   this.month++;

   if (this.month > 12) {
    this.month = 1;
    this.year++;
   }
  }
 }

 @Override
 public String toString() {
  return "The date is " + this.day + "/" + this.month + "/" + this.year;
 }

 public static void main(String[] args) {
  Date date = new Date(29, 2, 2024);
  date.incrementDate();
  System.out.println(date);
 }
}
