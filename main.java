package com.company;
import java.util.Scanner;

class eligibility {
    static boolean markFlag;
    int[] maxi, m1, m2, m3, other, other_maxi , cheld, catt;
    float[] average, attperc;
    public String fname, lname, USN;
    public String[] subject;
    String[] status;
    boolean[] b;

    //Setter and Getter Methods//

    public void setName(String name) {

        this.fname = name;

    }

    public String getName() {

        return fname;

    }

    public void setLname(String lname) {

        this.lname = lname;

    }

    public String getLname() {

        return lname;

    }

    public void setUSN(String usn) {

        this.USN = usn;

    }

    public String getUSN() {

        return USN;

    }

    void calcMarks(){
        System.out.println("--------------------MINI_PROJECT--------------------");
        System.out.println("----------------------------------------------------");
        System.out.println("----------------Enter Student Details---------------");
        Scanner in = new Scanner(System.in);
        System.out.println("\nEnter USN: ");
        this.setUSN(in.next());
        System.out.println("\nEnter First Name: ");
        this.setName(in.next());
        System.out.println("\nEnter Last Name: ");
        this.setLname(in.next());

        status = new String[5];
        b = new boolean[5];
        subject = new String[5];
        maxi = new int[5];
        m1 = new int[5];
        m2 = new int[5];
        m3 = new int[5];
        other = new int[5];
        other_maxi = new int[5];
        average = new float[5];
        cheld = new int[5];
        catt = new int[5];
        attperc = new float[5];


        System.out.println("------------------Enter I.A Marks------------------");
        for(int i = 0; i < 5; i++) {
            System.out.println("\nEnter Name of Subject: " + Integer.toString(i + 1));
            subject[i] = in.next();
            System.out.println("\nEnter Maximun Marks: ");
            maxi[i] = in.nextInt();
            System.out.println("\nI.A-1: ");
            m1[i] = in.nextInt();
            System.out.println("\nI.A-2: ");
            m2[i] = in.nextInt();
            System.out.println("\nI.A-3: ");
            m3[i] = in.nextInt();
            System.out.println("\nAssignment/Quiz Maximum Marks: ");
            other_maxi[i] = in.nextInt();
            System.out.println("\nAssignment/Quiz Marks: ");
            other[i] = in.nextInt();


            int ia_total = m1[i] + m2[i] + m3[i];

            average[i] = ((float) ia_total / 3);
            System.out.println("\nAverage:" + Float.toString(average[i]));

            int totalScore = ia_total / 3;


            if (maxi[i] >= m1[i] && maxi[i] >= m2[i] && maxi[i] >= m3[i] && other_maxi[i] >= other[i]) {
                int total_marks = totalScore + other[i];
                {
                    if (total_marks < 20) {
                        markFlag = false;
                        b[i] = false;

                    }
                    else {
                        markFlag = true;
                        b[i] = true;
                    }
                }
            }
            else {
                throw new ArithmeticException("ERROR!!!!!! - Input Marks should be below Maximum Marks!!!!");
            }
        }
    }
}
class attended extends eligibility{

    static boolean attflag;

    void calcAttendance() {

        calcMarks();
        Scanner sc = new Scanner(System.in);
        int n = 5;
        for (int i = 0; i < n; i++) {
            System.out.println("------------------Enter Attendance------------------");
            System.out.println("\nEnter number of classes held for subject: " + Integer.toString(i + 1));
            cheld[i] = sc.nextInt();
            System.out.println("\nEnter number of classes attended: ");
            catt[i] = sc.nextInt();
            attperc[i] = 100 * ((float) catt[i] / cheld[i]);
            System.out.println("\nAttendance percentage:\n" + Float.toString(attperc[i]));

            if (cheld[i] >= catt[i]) {

                if (attperc[i] < 75 && b[i]) {
                    attflag = false;
                    status[i] = "NE";
                }

                else if (attperc[i] >= 75 && b[i]) {
                    attflag = true;
                    status[i] = "E";
                }else {
                    attflag = false;
                    status[i] = "NE";
                }
            }
            else {
                throw new ArithmeticException("ERROR!!!!!! - Classes Attended should be below Classes Held.");            }
        }
        System.out.println("---------------------Final Marks--------------------");
        System.out.println("\nFirstName: "+getName()+"\tLastName: "+getLname()+"\tUSN: "+getUSN()+"\n");

        for (int j = 0; j < 5; j++) {
            System.out.println("\nName of the Subject: "+Integer.toString(j + 1)+":"+subject[j]+"\nI.A-1: "+m1[j]+"\tI.A-2: "+m2[j]+"\tI.A-3: "+m3[j]+"\tAssignment/Other Marks: "+other[j]+"\tAverage: "+average[j]+"\n");
            System.out.println("\nClass Attendance: "+subject[j]+"\nClasses Held: "+cheld[j]+"\tClasses Attendend: "+catt[j]+"\tAttendance Percentage: "+attperc[j]+"\n");
            System.out.println("\nSubject: "+Integer.toString(j + 1)+":"+subject[j]+"\tELIGIBITY: "+status[j]+"\n");
        }
    }
}

class aj  {
    public static void main(String args[]) {
        attended a = new attended();
        a.calcAttendance();
    }
}
