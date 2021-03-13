import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;


public class BookStore {
    public static void main(String [] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = in.readLine();
        do {
            if (!line.equals("")){
                int arraySize = Integer.parseInt(line);
                String[] bookPrices = in.readLine().split(" ");
                int money = Integer.parseInt(in.readLine());

                //Sort Array
                int[] intBookPrices = new int[arraySize];
                for (int i = 0; i < arraySize; i++) {
                intBookPrices[i] = Integer.parseInt(bookPrices[i]);
                }
                Arrays.sort(intBookPrices);
                System.out.println(process(intBookPrices, arraySize, money));

            }
            line = in.readLine();
        }while(line != null);
        //Search
        //System.out.println(Arrays.toString(intBookPrices));

        //System.out.println(arraySize);



        in.close();
        out.close();
        System.exit(0);
    }
    public static String process(int[] intBookPrices, int arraySize,int money){
        String ret = "";
        ArrayList<Integer> nums = new ArrayList<>();
        int i = 0;
        int j = arraySize-1;
        boolean ot;
        int in1 = 0;
        int in2 = 0;
        int minor = 0;
        int pos = -1;
        for(int k = 0; k < arraySize-1; k++){
            ot = false;
            while(i <= j && pos<0){
                int m = (i+j)/2;
                if(intBookPrices[m]+intBookPrices[k] == money){
                    
                	//ot = true;
                	in1 = intBookPrices[m];
                	in2 = intBookPrices[k];
                	//System.out.println(in1);
                	//System.out.println(in2);
                	//minor = in1-in2;
                	nums.add(in1);
                	nums.add(in2);
                	pos = m;
                    //System.out.println("I = "+in1+" J = "+in2);
                }else if ((intBookPrices[m]+intBookPrices[k])>= money){
                    j = m-1;
                }else{
                    i = m+1;
                }
            }
            pos = -1;
            i = 0;
            j = arraySize-1;
        }

        int temp = money;
        //System.out.println("----------");
        for(int n = 0; n < nums.size(); n = n+2) {
        	if(Math.abs(nums.get(n)-nums.get(n+1)) < temp && temp >= 0) {
        		temp = Math.abs(nums.get(n)-nums.get(n+1));
        		//System.out.println(temp);
        		in1 = nums.get(n);
        		in2 = nums.get(n+1);
        	}
        }
        //System.out.println("I = "+in2+" J = "+in1);
        ret = "Peter should buy books whose prices are "+in2+" and "+in1+"\n";
        return ret;
    }
}
