package niuketest;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;

public class ReadFileToString {
	public static void main(String []args) throws IOException{
		String fileData = readtxt("JAVA网络爬虫.txt");
		CountRelatedDocument(fileData);
		//MyWebRec []myWebRec = new MyWebRec[2000];
		
		ClassifyURL(fileData);
	}
	private static String readtxt(String filePath) throws IOException{
		BufferedReader br=new BufferedReader(new FileReader(filePath));
		String str="";
		String r=br.readLine();
		while(r!=null){
			str+=r+"\n";
			r=br.readLine();
		}
		return str;
	}
	private static char[][] readtxtToChar(String filePath) throws IOException{
		char [][]data = null;
		int currentline = 0;
		BufferedReader br=new BufferedReader(new FileReader(filePath));
		String str="";
		String r=br.readLine();
		while(r!=null){
			str+=r+"\n";
			data[currentline++] = str.toCharArray();
			r=br.readLine();
		}
		return data;
	}
	private static int CountRelatedDocument(String fileData){
		int cntRelated = 0;
		int currentLine = 1;
		int baiduCnt = 0;
		int bingCnt = 0;
		int sogouCnt = 0;
		int _360Cnt = 0;
		int State = 0;
		boolean baiduY[] = new boolean[51];
		boolean bingY[] = new boolean[51];
		boolean sogouY[] = new boolean[51];
		boolean _360Y[] = new boolean[51];
		char []fileChar = fileData.toCharArray();
		for(int i = 0; i < fileChar.length;i ++)
		{
			if(fileChar[i] == '#' && fileChar[i+1] == '*')
			{
				State++;
				System.out.println("分点："+currentLine);
			}
			if(fileChar[i] == '\n')
				currentLine ++;
			if(currentLine %3 == 0)
			{
				if(fileChar[i] == 'Y'||fileChar[i] == 'y')
				{
					if(State == 1){
						baiduCnt ++;
						baiduY[currentLine/3] = true;

					}
					else if(State == 2){
						bingCnt ++;
						bingY[currentLine/3 - 50 ] = true;
						//System.out.println(currentLine/3 - 50);
					}
					else if(State == 3){
						sogouCnt ++;
						sogouY[currentLine/3 - 100] =true;
					}
					else if(State == 4){
						_360Cnt ++;
						_360Y[currentLine/3 - 150] = true;
					}
					cntRelated++;
				}			
			}
		}
		try{

		CaculatePR(baiduY,bingY,_360Y,sogouY,cntRelated);

		}catch(Exception e){
			e.getMessage();
		}
		System.out.println("cntRelated = "+cntRelated);
		System.out.println("baiduCnt = "+baiduCnt);
		System.out.println("bingCnt = "+bingCnt);
		System.out.println("sohuCnt = "+sogouCnt);
		System.out.println("_360Cnt = "+_360Cnt);
		System.out.println("currentLine = " + currentLine);
		return cntRelated;
	}
	private static void ClassifyURL(String fileData){
		String str1[] = fileData.split("\n");
		for(int i = 0;i < str1.length;i ++)
		{
			if(str1[i].startsWith("#*"))
				str1[i] = str1[i].substring(10);
		}
	}
	private static void CaculatePR(boolean baiduY[],boolean bingY[],boolean _360Y[],boolean sogouY[],int cntRelated) throws IOException{
		double baiduP[] = new double [51];double baiduR[] = new double [51];
		double bingP[] = new double [51];double bingR[] = new double [51];
		double sogouP[] = new double [51];double sogouR[] = new double [51];
		double _360P[] = new double [51];double _360R[] = new double [51];
		int cntBaidu = 0;int cntBing = 0;int cntSogou = 0;int cnt360 = 0;
		//System.out.println("Related:"+cntRelated);
		for(int i = 1;i <= 50;i ++)
		{
			if(baiduY[i] == true)
				cntBaidu ++;	
			if(bingY[i] == true)
				cntBing ++;	
			if(sogouY[i] == true)
				cntSogou ++;	
			if(_360Y[i] == true)
				cnt360 ++;	
			baiduP[i] = 1.000000*cntBaidu/i;
			baiduR[i] = 1.000000*cntBaidu/cntRelated;
			bingP[i] = 1.000000*cntBing/i;
			bingR[i] = 1.000000*cntBing/cntRelated;
			sogouP[i] = 1.000000*cntSogou/i;
			sogouR[i] = 1.000000*cntSogou/cntRelated;
			_360P[i] = 1.000000*cnt360/i;
			_360R[i] = 1.000000*cnt360/cntRelated;
			//System.out.print(cntBaidu+"\t"+cntBing+"\t"+cntSogou+"\t"+cnt360+"\n");
		}
		CaculateMAP(baiduP,bingP,sogouP, _360P);
		File file = new File("D:/JAVA网络爬虫.txt");
		FileWriter out = new FileWriter(file);  //文件写入流
		 
		  //将数组中的数据写入到文件中。每行各数据之间TAB间隔
		  for(int i=1;i<=50;i++){
		    out.write("baidu"+"\t"+baiduP[i]+"\t" + baiduR[i]+"\r\n"); 
		  }
		  for(int i=1;i<=50;i++){
			  out.write("bing"+"\t"+bingP[i]+"\t" + bingR[i]+"\r\n"); 
			  }
		  for(int i=1;i<=50;i++){
			    out.write("sogou"+"\t"+sogouP[i]+"\t" + sogouR[i]+"\r\n"); 
			  }
		  for(int i=1;i<=50;i++){
			    out.write("360"+"\t"+_360P[i]+"\t" + _360R[i]+"\r\n"); 
			  }
		  out.close();
	}
	private static void CaculateMAP(double baiduP[],double bingP[],double sogouP[],double _360P[]){
		double baiduPre=0,bingPre=0,sogouPre=0,_360Pre=0;
		for(int i = 1;i <= 50;i ++ ){
			baiduPre += baiduP[i];
			bingPre += bingP[i];
			sogouPre += sogouP[i];
			_360Pre += _360P[i];
		}
		baiduPre /= 50;
		bingPre /= 50;
		sogouPre /= 50;
		_360Pre /= 50;
		System.out.println("baidu:"+baiduPre+"bing:"+bingPre+"sogou:"+sogouPre+"360:"+_360Pre);
	}
}
