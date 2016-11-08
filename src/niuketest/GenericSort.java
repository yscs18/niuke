package niuketest;

public class GenericSort {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] intArray={new Integer( 1),new Integer(3),new Integer(4)		};
		Double[] doubleArray={ new Double( 3.4),new Double(3.9),new Double(9.9)};
		Character[] charArray={new Character('a'),new Character('r'),new Character('J')};
		String[]  StringArray={"fsdhf","d","ghshf"};
		sort(intArray);
		sort(doubleArray);
		sort(charArray);
		sort(StringArray);
		System.out.println("Sorted Integer objects:");
		printList(intArray);
		System.out.println("Sorted Double objects:");
		printList(doubleArray);
		System.out.println("Sorted Character objects:");
		printList(charArray);
		System.out.println("Sorted  String objects:");
		printList(StringArray);
	}
		public static void sort(Comparable[] list){
			Comparable currentMin;
			int currentMinIndex;
			for(int i=0;i<list.length-1;i++){
				currentMin=list[i];
				currentMinIndex=i;
				for(int j=i+1;j<list.length;j++){
					if(currentMin.compareTo(list[j])>0){
						currentMin=list[j];
						currentMinIndex=j;
					}
				}
				if(currentMinIndex!=i){
					list[currentMinIndex]=list[i];
					list[i]=currentMin;
				}
			}
			}
		public static void printList(Comparable[] list){
			for(int i=0;i<list.length;i++){
				System.out.print(list[i]+"  ");
			}
			System.out.println();
		}
}
