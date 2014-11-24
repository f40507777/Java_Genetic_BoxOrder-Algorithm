package demo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


public class GA_Box {
	
	static int[][] boxsize={{4,10},{10,4},{3,3},{3,3}};
	static int Aboxcount=8,Bboxcount=8;
	static ArrayList<int []> putpoint;//剩下可放置點的位置   產生的點{x,y,box}
	static ArrayList<int []> alreadypoint;//已經放置過的點位置
	static ArrayList<Integer> boxorder;//放置的順序
	static ArrayList<Integer> half;//放置的順序
	static int x=0;
	static int y=1;
	static int pointbox=2;
	static int width=14;
	static int lenght=14;
	static int top=5;
	static int rountime=0;
	static int cutkey;
	static int  Scores=99999;
	static ArrayList<Integer>onepart;
	static ArrayList<Integer>onepartscore;
	static int[] partarray;
	static HashMap<ArrayList<Integer>,Integer> Score=new HashMap<ArrayList<Integer>,Integer>();
	static HashMap<ArrayList<Integer>,int []> part=new HashMap<ArrayList<Integer>,int []>();
	//static int Bboxcount=8;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Random();
		//test();
		First();
	}
	public static void First(){
		HashMap<ArrayList<Integer>,Integer> Score =new HashMap<ArrayList<Integer>,Integer>();
		for(int i=0;i<10;i++){
			int temp=Random();
			Score.put(boxorder,temp);
		}
		//System.out.println(Score);
		//System.out.println("size="+Score.size());
		while(Scores!=0){
			Sort(Score);
		}
		
	}
	public static void Sort(HashMap<ArrayList<Integer>,Integer> Score){
		
		HashMap<Integer, ArrayList<Integer>> tops = new HashMap<Integer,ArrayList<Integer>>();
		
		List<Map.Entry<ArrayList<Integer>,Integer>> list_path =new ArrayList<Map.Entry<ArrayList<Integer>,Integer>>(Score.entrySet());
		Collections.sort(list_path, new Comparator<Map.Entry<ArrayList<Integer>,Integer>>(){
            public int compare(Map.Entry<ArrayList<Integer>,Integer> entry1,
                               Map.Entry<ArrayList<Integer>,Integer> entry2){
                return (entry1.getValue().compareTo(entry2.getValue()));
            }
        });
		//System.out.println(list_path);
		/*for(int i=0;i<list_path.size();i++){
			tops.put(i, list_path.get(i).getKey());
		}*/
		int q=0;
		for (Entry<ArrayList<Integer>, Integer> entry:list_path) {
			if(entry.getValue()==0){
				Final(entry.getValue(),entry.getKey());
			}
			if(q==0){
				Scores=entry.getValue();
				//System.out.println("Score="+Scores+"	"+entry.getKey());
			}
			tops.put(q, entry.getKey());
			q++;
		}
		//System.out.println(tops);
		rountime++;
		/*if(rountime>50000){
			return;
		}*/
		pitch(tops);
	}
	
	public static void Final(int score, ArrayList<Integer> Answer)
	{
		System.out.println("**********************************");
		System.out.println("Answer="+Answer);
		System.out.println("Score="+score);
		System.out.println("**********************************");
		System.exit(0);
	}
	public static void pitch(HashMap<Integer, ArrayList<Integer>> tops){
		
		for(int i=0;i<4;i++){
			//System.out.println(tops.get(i));
			for(int j=i+1;j<5;j++){
				//ArrayList<Integer> childboxorder = new ArrayList<Integer>();
				//System.out.println("tops.size()="+tops.size());

				cross(tops.get(i),tops.get(j));
				Score.put(boxorder, put());
				
					
				
				//part.put(boxorder, partarray);
				
			}
		}
		//(Score);
	}
	public static ArrayList<Integer> cross(ArrayList<Integer> A,ArrayList<Integer> B){
		ArrayList<Integer>cut=new ArrayList<Integer>();
		HashMap<Integer, Integer> tmp = new HashMap<Integer,Integer>();
		int acount=8;
		int bcount=8;
		for(int i=0;i<A.size();i++){
			
			if(A.get(i)==B.get(i)){
				tmp.put(i, A.get(i));
				if(A.get(i)<2){
					acount--;//01
				}else{
					bcount--;//23
				}
			}
		}
		/*boxorder=A;
		put();
		int tmps=9999,marks = 0;
		partarray=new int[2];
		System.out.println(onepartscore);
		System.out.println(onepart);
		for(int q=0;q<onepartscore.size();q++){
			if(tmps>onepartscore.get(q)){
				tmps=onepartscore.get(q);
				marks=q;
			}
		}
		if(!(marks==0)){
			partarray[0]=onepart.get(marks-1);
			partarray[1]=onepart.get(marks);
		}else{
			partarray[0]=onepart.get(0);
			partarray[1]=onepart.get(1);
		}
		
		//System.out.println(partarray[0]);
		for(int i=partarray[0];i<partarray[1]+1;i++){
			if(acount==0 && bcount==0){
				break;
			}
			if(boxorder.get(i)<2){
				acount--;
			}else{
				bcount--;
			}
			cut.add(boxorder.get(i));
		}
		boxorder=B;
		put();
		tmps=9999;
		marks = 0;
		partarray=new int[2];
		for(int q=0;q<onepartscore.size();q++){
			if(tmps>onepartscore.get(q)){
				tmps=onepartscore.get(q);
				marks=q;
			}
		}
		if(!(marks==0)){
			partarray[0]=onepart.get(marks-1);
			partarray[1]=onepart.get(marks);
		}else{
			partarray[0]=onepart.get(0);
			partarray[1]=onepart.get(1);
		}
		
		for(int i=partarray[0];i<partarray[1]+1;i++){
			if(boxorder.size()>16 ||acount==0|| bcount==0){
				break;
			}
			if(boxorder.get(i)<2){
				acount--;
			}else{
				bcount--;
			}
			cut.add(boxorder.get(i));
		}
		int nwran;
		while(cut.size()!=16){
			nwran=(int)(Math.random()*4);
			if(nwran<2 && acount!=0){
				cut.add(nwran);
				acount--;
			}else if(nwran>1  && bcount!=0){
				cut.add(nwran);
				bcount--;
			}
		}
		
		System.out.println(cut);
		boxorder.clear();
		boxorder=cut;*/
		int count=0,ran;
		int []childarray=new int[16];
		
		while(!(acount==0 && bcount==0 && count==16)){
			if(tmp.get(count)!=null){
				childarray[count]=tmp.get(count);
				count++;
			}else{
				ran=(int)(Math.random()*4);
				if(ran<2 && acount!=0){
					childarray[count]=ran;
					count++;
					acount--;
				}else if(ran>1  && bcount!=0){
					childarray[count]=ran;
					count++;
					bcount--;
				}
			}
		}
		int temp,a,b;
		if((int)(Math.random()*100)>80){
			a=(int)(Math.random()*16);
			b=(int)(Math.random()*16);
			temp=childarray[a];
			childarray[a]=childarray[b];
			childarray[b]=temp;
		}
		boxorder = new ArrayList<Integer>();
		for(int i=0;i<childarray.length;i++){
			boxorder.add(childarray[i]);
		}
		//System.out.println(boxorder);
		return boxorder;
	}
	public static int Random(){
		boxorder = new ArrayList<Integer>();
		int aBoxcount=Aboxcount,bBoxcount=Bboxcount,ran;
		while(!(aBoxcount==0 && bBoxcount==0)){
			ran=(int)(Math.random()*4);
			if(ran<2 && aBoxcount!=0){
				boxorder.add(ran);
				aBoxcount--;
			}else if(ran>1  && bBoxcount!=0){
				boxorder.add(ran);
				bBoxcount--;
			}
		}
		System.out.println("裝箱順序:");
		for(int i=0;i<boxorder.size();i++){
			System.out.print(Arrays.toString(boxsize[boxorder.get(i)]));
		}
		System.out.println();
		System.out.println("Score="+put());
		return put();
	}
	public static void test(){
		boxorder = new ArrayList<Integer>();

		boxorder.add(1);
		boxorder.add(0);
		boxorder.add(2);
		boxorder.add(2);
		boxorder.add(1);
		boxorder.add(2);
		boxorder.add(2);
		boxorder.add(0);
		
		boxorder.add(1);
		boxorder.add(0);
		boxorder.add(2);
		boxorder.add(2);
		boxorder.add(1);
		boxorder.add(2);
		boxorder.add(2);
		boxorder.add(0);
		
		/*for(int i=0;i<boxorder.size();i++){
			System.out.print(Arrays.toString(boxsize[boxorder.get(i)]));
		}
		System.out.println("Score="+put());
*/
	}
	public static int put(){
		putpoint = new ArrayList<int []>();
		alreadypoint = new ArrayList<int []>();
		onepart = new ArrayList<Integer>();
		onepartscore= new ArrayList<Integer>();
		int [] XYputpoint={0,0};
		putpoint.add(XYputpoint);
		int BigBox=0;
		int remain=0;
		int gap=0;
		int tatal=0;
		int formark=0;
		for(int i=0;i<boxorder.size();i++){//依序跑完箱子順序	//mark
			System.out.println("");
			System.out.print("目前裝箱為="+Arrays.toString(boxsize[boxorder.get(i)])+"	");
			System.out.println("");
			int misscount=0;
			for(int j=0;j<putpoint.size();j++){//按造可放的點順序下去放
				if(collide(boxorder.get(i),putpoint.get(j),formark)){
					
					alreadypoint.add(putpoint.get(j));
					int []tmp=putpoint.get(j);
					putpoint.remove(j);
					Addputpoint(boxorder.get(i),tmp);
					//putpoint.remove(j);
					sortputpoint();
					if(boxorder.get(i)<2){//己算體積
						gap=gap+40;
					}else{
						gap=gap+9;
					}
					
					break;
				}else{
					misscount++;
				}
			}
			
			if(misscount==putpoint.size()){
				
				if(!(putpoint.size()==0)){
					formark=i;
					i--;
					
					//System.out.println("i--");
				}else{
					formark=i+1;
				}
				
				putpoint = new ArrayList<int []>();
				alreadypoint = new ArrayList<int []>();
				onepart.add(i);
				onepartscore.add((14*14)-gap);
				tatal=tatal+(14*14)-gap;
				if(tatal==0){
					half = new ArrayList<Integer>();
					System.out.println("!!!!!!!!!!!!!!!!");
					cutkey=i;
					for(int k=0;k<i+1;k++){
						half.add(boxorder.get(k));

					}
					int k=half.size();
					for(int w=0;w<k;w++){
						half.add(half.get(w));
					}
					stop(half);
				}
				System.out.println("各分數="+tatal);	//mark
				BigBox++;
				remain=(boxorder.size()-1)-i;
				System.out.println("//////////////////////重新裝箱/////////////////////");	//mark
				//System.out.println("現在i="+i);
				gap=0;
				putpoint.add(XYputpoint);
			}
		}
		if(remain>0){
			BigBox++;
		}
		//mark
		System.out.println("剩下="+remain);
		System.out.println("總共需要"+BigBox+"個大箱子");
		System.out.println("分數="+tatal);
		//return (BigBox*10+remain)-20;	//最小為0
		return tatal;
	}

	public static void stop(ArrayList<Integer> half){

		System.out.println(half);
		System.out.println("疊帶次數="+rountime);
		System.exit(0);
	}
	public static boolean collide(int box,int []putpoint,int formark){
		System.out.println();
		for(int i=0;i<alreadypoint.size();i++){

			/*System.out.println("(alreadypoint.get(i))[x]="+(alreadypoint.get(i))[x]);
			System.out.println("(alreadypoint.get(i))[y]="+(alreadypoint.get(i))[y]);
			System.out.println("+boxsize[boxorder.get(i)][x]="+boxsize[boxorder.get(i+formark)][x]);
			System.out.println("+boxsize[boxorder.get(i)][y]"+boxsize[boxorder.get(i+formark)][y]);*/
			if((putpoint[x]<(alreadypoint.get(i))[x]+boxsize[boxorder.get(i+formark)][x] 
					&& putpoint[y]+boxsize[box][y]>alreadypoint.get(i)[y]
							&& putpoint[x]+boxsize[box][x]>(alreadypoint.get(i))[x]
									&& (putpoint[y]<(alreadypoint.get(i))[y]+boxsize[boxorder.get(i)][y]))//下半部
					|| (putpoint[x]+boxsize[box][x]>alreadypoint.get(i)[x] 
							&& putpoint[y]<alreadypoint.get(i)[y]+boxsize[boxorder.get(i+formark)][y]
									&& putpoint[y]+boxsize[box][y]>alreadypoint.get(i)[y] 
											&& (putpoint[x]<(alreadypoint.get(i))[x]+boxsize[boxorder.get(i+formark)][x]))//右半部
					|| (putpoint[x]+boxsize[box][x]>width || putpoint[y]+boxsize[box][y]>lenght)){
				
				System.out.print("裝入點="+Arrays.toString(putpoint)+"	狀態:");	//mark
				System.out.println("失敗");
				return false;
			}
		}
		System.out.println();	//mark
		System.out.print("裝入點="+Arrays.toString(putpoint)+"	狀態:");
		System.out.println("成功");
		return true;		
	}
	public static void Addputpoint(int box,int []put){

		int []tmpA=new int[2];
		int []tmpB=new int[2];
		int []tmpC=new int[2];
		int []tmpD=new int[2];
		//boxsize
		if(put[x]==0 && put[y]==0){		//最一開始!!
			for(int i=0;i<2;i++){
				int []tmp=new int[2];
				tmp[i]=boxsize[box][i];
				putpoint.add(tmp);
			}
			//System.out.println(Arrays.toString(putpoint.get(0))+","+Arrays.toString(putpoint.get(1)));
		}else if(put[x]==0){	//碰到左邊	
			
			for(int i=0;i<alreadypoint.size();i++){
				if(alreadypoint.get(i)[y]+boxsize[boxorder.get(i)][y]==put[y] //確認在正上方的箱子
						&& alreadypoint.get(i)[x]+boxsize[boxorder.get(i)][x]>boxsize[box][x]
								&& alreadypoint.get(i)[x]<boxsize[box][x]){
					tmpB[x]=boxsize[box][x];
					tmpB[y]=put[y];
					if(tmpB[x] <14 && tmpB[y]<14){
						putpoint.add(tmpB);
					}
					//System.out.println("碰到左邊-確認在正上方的箱子");
				}	
				
				if(alreadypoint.get(i)[x]==put[x]+boxsize[box][x]
						&& alreadypoint.get(i)[y]+boxsize[boxorder.get(i)][y]<put[y]+boxsize[box][y]
								&& alreadypoint.get(i)[y]+boxsize[boxorder.get(i)][y]>put[y]){//確認在正右方的箱子
					tmpC[x]=alreadypoint.get(i)[x];
					tmpC[y]=alreadypoint.get(i)[y]+boxsize[boxorder.get(i)][y];
					if(tmpC[x] <14 && tmpC[y]<14){
						putpoint.add(tmpC);
					}
					//System.out.println("碰到左邊-確認在正右方的箱子");
				}
				
			}
			tmpA[x]=0;
			tmpA[y]=put[y]+boxsize[box][y];
			if(tmpA[x] <14 && tmpA[y]<14){
				putpoint.add(tmpA);
			}
			
		}else if(put[y]==0){  	//碰到 上面
			
			for(int i=0;i<alreadypoint.size();i++){
				if(alreadypoint.get(i)[x]+boxsize[boxorder.get(i)][x]==put[x]
						&& alreadypoint.get(i)[y]+boxsize[boxorder.get(i)][y]>boxsize[box][y]
								&& alreadypoint.get(i)[y]<=boxsize[box][y]){//確認在正左方的箱子
					tmpB[x]=put[x];
					tmpB[y]=boxsize[box][y];
					if(tmpB[x] <14 && tmpB[y]<14){
						putpoint.add(tmpB);
					}
					//System.out.println("碰到上面-確認在正左方的箱子");
				}
				if(alreadypoint.get(i)[y]==put[y]+boxsize[box][y]
						&& alreadypoint.get(i)[x]+boxsize[boxorder.get(i)][x]<put[x]+boxsize[box][x]
								&& alreadypoint.get(i)[x]+boxsize[boxorder.get(i)][x]>put[x]){//確認在正下方的箱子
					tmpC[x]=alreadypoint.get(i)[x]+boxsize[boxorder.get(i)][x];
					tmpC[y]=alreadypoint.get(i)[y];
					if(tmpC[x] <14 && tmpC[y]<14){
						putpoint.add(tmpC);
					}
					//System.out.println("碰到上面-確認在正下方的箱子");
				}
				
			}
			tmpA[x]=put[x]+boxsize[box][x];
			tmpA[y]=0;
			if(tmpA[x] <14 && tmpA[y]<14){
				putpoint.add(tmpA);
			}
		}else{
			
			for(int i=0;i<alreadypoint.size();i++){
				
				if(alreadypoint.get(i)[y]+boxsize[boxorder.get(i)][y]==put[y]
						&& alreadypoint.get(i)[x]<=put[x]+boxsize[box][x]
								&& alreadypoint.get(i)[x]+boxsize[boxorder.get(i)][x]>put[x]+boxsize[box][x]){//上邊大於下邊
					
					tmpA[x]=put[x]+boxsize[box][x];
					tmpA[y]=put[y];
					if(tmpA[x] <14 && tmpA[y]<14){
						putpoint.add(tmpA);
					}
					//System.out.println("在中間-上邊大於下邊");
				}
				if(alreadypoint.get(i)[x]+boxsize[boxorder.get(i)][x]==put[x]
						&& alreadypoint.get(i)[y]<=put[y]+boxsize[box][y]
								&& alreadypoint.get(i)[y]+boxsize[boxorder.get(i)][y]>put[y]+boxsize[box][y]){//左邊大於右邊
					
					tmpB[x]=put[x];
					tmpB[y]=put[y]+boxsize[box][y];
					if(tmpB[x] <14 && tmpB[y]<14){
						putpoint.add(tmpB);
					}
					//System.out.println("在中間-左邊大於右邊");
				}
				
				if(alreadypoint.get(i)[x]==put[x]+boxsize[box][x]
						&& alreadypoint.get(i)[y]+boxsize[boxorder.get(i)][y]<put[y]+boxsize[box][y]
								&& alreadypoint.get(i)[y]+boxsize[boxorder.get(i)][y]>put[y]){//確認在正右方的箱子
					tmpC[x]=alreadypoint.get(i)[x];
					tmpC[y]=alreadypoint.get(i)[y]+boxsize[boxorder.get(i)][y];
					if(tmpC[x] <14 && tmpC[y]<14){
						putpoint.add(tmpC);
					}
					//System.out.println("在中間-確認在正右方的箱子");
				}
				
				if(alreadypoint.get(i)[y]==put[y]+boxsize[box][y]
						&& alreadypoint.get(i)[x]+boxsize[boxorder.get(i)][x]<put[x]+boxsize[box][x]
								&& alreadypoint.get(i)[x]+boxsize[boxorder.get(i)][x]>put[x]){//確認在正下方的箱子
					tmpD[x]=alreadypoint.get(i)[x]+boxsize[boxorder.get(i)][x];
					tmpD[y]=alreadypoint.get(i)[y];
					if(tmpD[x] <14 && tmpD[y]<14){
						putpoint.add(tmpD);
					}
					//System.out.println("在中間-確認在正下方的箱子");
				}
			}
		}
	}
	public static void sortputpoint(){
		ArrayList<int []> tmp=putpoint;
		ArrayList<int []> sortpoint=new ArrayList<int []>();
		while(tmp.size()!=0){
			int xpoint=14,ypoint=14,itmp=0;
			for(int i=0;i<tmp.size();i++){
				if(tmp.get(i)[x]<xpoint){
					itmp=i;
					xpoint=tmp.get(i)[x];
					ypoint=tmp.get(i)[y];

				}else if(tmp.get(i)[x]==xpoint && tmp.get(i)[y]<=ypoint){
					itmp=i;
					xpoint=tmp.get(i)[x];
					ypoint=tmp.get(i)[y];
				}
			}
			sortpoint.add(tmp.get(itmp));
			tmp.remove(itmp);
		}
		//ArrayList<Integer> comment=new ArrayList<Integer>();
		int []test=new int[2];
		//System.out.print("排序完=");
		for(int i=0;i<sortpoint.size()-1;i++){
			for(int j=i+1;j<sortpoint.size();j++){
				if(sortpoint.get(i)[x]==sortpoint.get(j)[x] && sortpoint.get(i)[y]==sortpoint.get(j)[y]){
					test[x]=sortpoint.get(i)[x];
					test[y]=sortpoint.get(i)[y];
					break;
				}
			}
		}
		for(int i=0;i<sortpoint.size();i++){
			
			if(sortpoint.size()<2){
				putpoint.add(sortpoint.get(i));
				//System.out.print(Arrays.toString(putpoint.get(i)));
				break;
			}
			if(!(sortpoint.get(i)[x]==test[x] && sortpoint.get(i)[y]==test[y])){
				putpoint.add(sortpoint.get(i));
			}
			
		}
		for(int i=0;i<putpoint.size();i++){
			System.out.print(Arrays.toString(putpoint.get(i)));
		}
		//System.out.println();
		//putpoint=sortpoint;
	}
}
