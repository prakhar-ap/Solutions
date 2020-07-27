/**
* @author Prakhar Khandelwal
*/

/*
	Raj stays at a hostel. He has N friends, numbered from 1 to N.
One day, when he woke up at time p:q, he found his slippers to be missing.
He couldn't go out to get a new slipper on bare foot. So, he wants to borrow slippers from one of his friends to go to the store to get a new slipper.
 But there are 5 conditions he must follow:
The hostel has an in-time of x:y . He has to return back before x:y.
The footwear store in that area opens at a time a:b, only after which a slipper can be selected and bought,
 no matter how early Raj goes to the shop. Once the shop is opened, it stays open throughout the day.
He can borrow the slippers from his friend numbered x, only if x does not use his slippers in the time interval that Raj asks for. 
Luckily, all of Raj's friends are lazy and hence they use their slippers exactly once a day. For each friend, you are given h1:m1 and h2:m2. 
The friend uses his slippers from h1:m1 to h2:m2 (inclusive)
if Raj has the option to use the slippers of friend i and friend j such that i<j, he would prefer to use the slipper of friend i.
It takes Raj R minutes to travel from the store to his hostel and from his hostel to the store, both . Once he is at the store
 it takes him S minutes to select a new slipper.
Raj wants to go to the footwear store, select and buy a new slipper and return to the hostel at the earliest. Given all the required information, 
find the friend from whom Raj should borrow the slippers.
He can start his journey after he wakes up, that is, after p:q
Input:
First line contains an integer T, denoting the number of test cases to follow.
Each testcase begins with an integer N. The next 5 lines contains:
1. The in-time of the hostel, x:y,
2. Time at which Raj wakes up, p:q
3. The time from which the Footwear store will be open, a:b
4. Integer R denoting the minutes it takes to travel between the store and his hostel 
5. Integer S denoting the minutes Raj takes to select a new slipper.
N lines follow. The ith line contains the time interval during which his ith friend use his slippers in the format "h1:m1 h2:m2"
Hence, each testcase contains N+6 line.
(Strictly follow the format given in the sample Testcase for input and output)
Output: 
If it is possible to get slippers on that day, print the index of the friend from whom Raj should borrow the slippers, adhering to the above mentioned conditions.
Else print "-1" to denote that he cannot get the slippers before the day end.
Constraints
0<=T<=100
0<=N<=200
0<=R,S<(24*60)
h1:m1 <= h2:m2
All the times are given as hours:minutes. (0<=hours<=23, 0<=minutes<=59) ( See 24 - hour format )
Note: hours and minutes will always be a two digit integer, Eg: 09:05, 13:09
Sample Case:
1
5
21:30
06:00
09:00
25
10
07:00 10:00
08:30 09:20
12:00 13:45
06:00 16:00
12:05 15:00
Sample Output:
3
SAMPLE INPUT 
1
5
21:30
06:00
09:00
25
10
07:00 10:00
08:30 09:20
12:00 13:45
06:00 16:00
12:05 15:00
SAMPLE OUTPUT 
Case 1: 3
Explanation
If Raj borrows from his friend 1: He would be back at his hostel by 11:00 
If Raj borrows from his friend 2: He would be back at his hostel by 10:20 
If Raj borrows from his friend 3: He would be back at his hostel by 9:35 
If Raj borrows from his friend 4: He would be back at his hostel by 17:00 
If Raj borrows from his friend 5: He would be back at his hostel by 9:35
Thus he can borrow from either of friend 3 or 5. 
Going by the condition that he would borrow from a closer friend, he picks the friend lowest index. 
Hence, he would borrow from friend 3.
*/


/* IMPORTANT: Multiple classes and nested static classes are supported */

import java.util.Scanner;

class Solution {
    public static void main(String args[] ) throws Exception {
        
        Scanner scanner = new Scanner(System.in);
        
        int T = scanner.nextInt();
        
        while(T>0){
            
            int N = scanner.nextInt();
            scanner.nextLine();
            String entry = scanner.nextLine();
            String wake = scanner.nextLine();
            String open = scanner.nextLine();
            
            int R = scanner.nextInt();
            int S = scanner.nextInt();
            
            String friends[] = new String[N];
            scanner.nextLine();
            for(int i=0;i<N;i++){
                friends[i] = scanner.nextLine();
            }
            
            // splits the given time into actual seconds.
            String a[] = entry.split(":");
            int entry_time = Integer.parseInt(a[0])*60 + Integer.parseInt(a[1]);
            String a1[] = wake.split(":");
            int wake_time = Integer.parseInt(a1[0])*60 + Integer.parseInt(a1[1]);
            String a2[] = open.split(":");
            int open_time = Integer.parseInt(a2[0])*60 + Integer.parseInt(a2[1]);

            // to calculate as per his friends timing.
            int friends_time[][] = new int[N][2];


            for(int i=0;i<N;i++){
            	String aa[] = friends[i].split("\\s+");
            	String aa1[] = aa[0].split(":");
            	String aa2[] = aa[1].split(":");

            	friends_time[i][0] = Integer.parseInt(aa1[0])*60 + Integer.parseInt(aa1[1]);
            	friends_time[i][1] = Integer.parseInt(aa2[0])*60 + Integer.parseInt(aa2[1]);
            }

            // manipulates the time to fetch the required inbounds.  
            int max_time[] = new int[N];
            for(int i=0;i<N;i++){
            	if(friends_time[i][0]<=open_time)
                    max_time[i]= friends_time[i][1] + 60;
            	else if(friends_time[i][0]>=open_time+R+S)
                    max_time[i] = open_time+R+S;
            }

            int min = 100000;
            int c=0;
            for(int i=0;i<N;i++){
            	if(max_time[i]<min){min = max_time[i]; c = i;}
            }
            //prints the minimum matched index.
            System.out.println(c+1);
            T--;
        }
    }
}